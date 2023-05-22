public class Controlador {
    public static void main(String[] args) {
        CRUD crud = new CRUD();

        System.out.println("Lista de los socios  con el alquiler de los últimos 3 meses:");
        System.out.println(crud.listadoSocios());
        System.out.println();

        System.out.println("Lista de los actores que más aparecen en la anterior consulta:");
        System.out.println(crud.listadoActores());
        System.out.println();

        System.out.println("Lista de los dvds más vendidos:");
        System.out.println(crud.listadoDVD());
    }
}
