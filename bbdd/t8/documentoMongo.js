use p8
db.socio.insertMany(
    {
        "socioID": 1,
        "nombre": "Juan",
        "apellido": "Parejo",
    },
    {
        "socioID": 2,
        "nombre": "Pablo",
        "apellido": "Verdejo",
    },
)

db.alquiler.insertMany(
    {
        "alquilerID": 1,
        "socioID": 1,
        "peliID": 1,
    },
    {
        "alquilerID": 2,
        "socioID": 1,
        "peliID": 2,
    },
    {
        "alquilerID": 3,
        "socioID": 2,
        "peliID": 3,
    },
)

db.pelicula.insertMany(
    [
        {
            "peliID": 1,
            "título": "El Resplandor",
            "dvd": [
                {
                    "dvdID" : 1,
                    "nombre": "DVD",
                },
                {
                    "dvdID" : 2,
                    "nombre": "BlueRay",
                },
                {
                    "dvdID" : 3,
                    "nombre": "VHS",
                }
            ]
        },
        {
            "peliID": 2,
            "título": "BabySister",
            "dvd": [
                {
                    "dvdID" : 1,
                    "nombre": "DVD",
                },
                {
                    "dvdID" : 2,
                    "nombre": "BlueRay",
                },
            ]
        },
        {
            "peliID": 3,
            "título": "Mario Bross",
            "dvd": [
                {
                    "dvdID" : 1,
                    "nombre": "DVD",
                },
                {
                    "dvdID" : 2,
                    "nombre": "VHS",
                }
            ]
        }
    ]
)

db.actor.insertMany(
    {
        "actorID": 1,
        "nombre": "Harrison",
        "apellido": "Ford",
    },
    {
        "actorID": 2,
        "nombre": "La",
        "apellido": "Roca",
    },
)

db.actua.insertMany(
    {
        "peliID": 1,
        "actorIDs": [
            1, 2
        ]
    },
    {
        "peliID": 2,
        "actorIDs": [
            1
        ]
    },
    {
        "peliID": 3,
        "actorIDs": [
            2
        ]
    }
)