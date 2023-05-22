import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;

import java.util.*;

import static com.mongodb.client.model.Accumulators.sum;
import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Indexes.descending;

public class CRUD {
    MongoClient mongoCliente;
    MongoDatabase bbdd;
    public CRUD(){
        mongoCliente = new MongoClient(new MongoClientURI("mongodb://Juan:1234@localhost:27017"));
        bbdd = mongoCliente.getDatabase("p8");
    }

    public List<Object> listadoSocios() {
        List<Object> lista = new ArrayList<>();
        Calendar fecha_actual = Calendar.getInstance();
        fecha_actual.add(Calendar.DATE, -90);

        MongoCursor<Document> alquileres = bbdd.getCollection("alquiler").find(gte("f_alquiler",
                fecha_actual.getTime())).iterator();

        while (alquileres.hasNext()) {
            Document alquiler = alquileres.next();
            Document socio = bbdd.getCollection("socio").find(eq("_id", alquiler.getInteger("socioID"))).first();
            Document peli = bbdd.getCollection("pelicula").find(eq("_id", alquiler.getInteger("peliID"))).first();

            lista.add(new PrimeraConsulta(socio.getInteger("_id"), socio.getString("nombre"), socio.getString("apellido"),
                    peli.getString("título")));
        }

        return lista;
    }


    public SegundaConsulta listadoActores() {
        List<Actor> listaActores = new ArrayList<>();
        Calendar fecha_actual = Calendar.getInstance();
        fecha_actual.add(Calendar.DATE, -90);

        MongoCursor<Document> alquileres = bbdd.getCollection("alquiler").find(gte("f_alquiler",
                fecha_actual.getTime())).iterator();

        while (alquileres.hasNext()) {
            Document alquiler = alquileres.next();
            Document actua = bbdd.getCollection("actua").find(eq("peliID", alquiler.getInteger("peliID"))).first();
            MongoCursor<Document> actores = bbdd.getCollection("actor").find(in("_id", actua.getList("actorIDs", Integer.class))).iterator();

            while (actores.hasNext()) {
                Document actor = actores.next();
                Actor actorObjeto = new Actor(actor.getString("nombre"), actor.getString("apellido"), 1);

                // Filtro para encontrar objetos iguales en la lista
                if(listaActores.contains(actorObjeto)) {
                    int i = 0;
                    boolean encontrado = false;
                    while (!encontrado) {
                        if(actorObjeto.equals(listaActores.get(i))) {
                            Actor aEncontrado = (Actor) listaActores.get(i);
                            aEncontrado.setContador(aEncontrado.getContador()+1);
                            encontrado = true;
                        }
                        i++;
                    }

                }
                else {
                    listaActores.add(actorObjeto);
                }
            }
        }
        Collections.sort(listaActores);
        SegundaConsulta consulta = new SegundaConsulta(listaActores);

        return consulta;
    }

    public List<String> listadoDVD() {
        List<String> lista = new ArrayList<>();
        MongoCollection<Document> alquilerCollection = bbdd.getCollection("alquiler");
        MongoCursor<Document> cursor = alquilerCollection.aggregate(
                List.of(
                        group("$dvdID", sum("count", 1)),
                        sort(descending("count")),
                        limit(20)
                )
        ).iterator();

        // Imprimir los resultados
        System.out.println("Los 20 dvdID más alquilados:");
        while (cursor.hasNext()) {
            Document result = cursor.next();
            lista.add(""+ result.getInteger("_id") + " - " + result.getInteger("count"));
        }
        return lista;
    }
}
