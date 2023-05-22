use p8
db.socio.insertMany([
    {
        "_id": 1,
        "nombre": "Juan",
        "apellido": "Parejo",
        "direccion": "Avda del Perú",
        "telefono": 666666666,
        "saldo": 100,
    },
    {
        "_id": 2,
        "nombre": "Pablo",
        "apellido": "Verdejo",
        "direccion": "Calle de Ecuador",
        "telefono": 777777777,
        "saldo": 150,
    },
    {
        "_id": 3,
        "nombre": "Jose",
        "apellido": "Pardo",
        "direccion": "Calle de Colombia",
        "telefono": 333333333,
        "saldo": 125,
    },
    {
        "_id": 4,
        "nombre": "Miguel",
        "apellido": "Calles",
        "direccion": "Calle de Ecuador",
        "telefono": 999999999,
        "saldo": 200,
    },
])

db.pelicula.insertMany(
    [
        {
            "_id": 1,
            "título": "The Shinning",
            "dvd": [
                {
                    "dvdID" : 1,
                },
                {
                    "dvdID" : 2,
                },
                {
                    "dvdID" : 3,
                },
            ]
        },
        {
            "_id": 2,
            "título": "The Machinist",
            "dvd": [
                {
                    "dvdID" : 1,
                },
                {
                    "dvdID" : 2,

                },
            ]
        },
        {
            "_id": 3,
            "título": "Avengers: Age of Ultron.",
            "dvd": [
                {
                    "dvdID" : 1,
                },
                {
                    "dvdID" : 2,
                },
                {
                    "dvdID" : 3,
                },
                {
                    "dvdID" : 4,
                },
                {
                    "dvdID" : 5,
                },
                {
                    "dvdID" : 6,
                },
            ]
        },
        {
            "_id": 4,
            "título": "Braveheart",
            "dvd": [
                {
                    "dvdID" : 1,
                },
                {
                    "dvdID" : 2,
                },
                {
                    "dvdID" : 3,
                },
            ]
        },
        {
            "_id": 5,
            "título": "Fast and furious",
            "dvd": [
                {
                    "dvdID" : 1,
                },
                {
                    "dvdID" : 2,

                },
                {
                    "dvdID" : 3,
                },
                {
                    "dvdID" : 4,
                },
                {
                    "dvdID" : 5,
                },
            ]
        },
        {
            "_id": 6,
            "título": "Zombeavers",
            "dvd": [
                {
                    "dvdID" : 1,
                },
                {
                    "dvdID" : 2,
                },
                {
                    "dvdID" : 3,
                },
                {
                    "dvdID" : 4,
                },
                {
                    "dvdID" : 5,
                },
                {
                    "dvdID" : 6,
                },
                {
                    "dvdID" : 7,
                },
                {
                    "dvdID" : 8,
                },
                {
                    "dvdID" : 9,
                },
                {
                    "dvdID" : 10,
                },
            ]
        },
    ]
    )

db.actor.insertMany([
    {
        "_id": 1,
        "nombre": "Harrison",
        "apellido": "Ford",
    },
    {
        "_id": 2,
        "nombre": "Dwayne",
        "apellido": "Jonshon",
    },
    {
        "_id": 3,
        "nombre": "Keaune",
        "apellido": "Reeves",
    },
    {
        "_id": 4,
        "nombre": "Morgan",
        "apellido": "Freeman",
    },
    {
        "_id": 5,
        "nombre": "Brad",
        "apellido": "Pitt",
    },
    {
        "_id": 6,
        "nombre": "Bruce",
        "apellido": "Willies",
    },
    {
        "_id": 7,
        "nombre": "Rubén",
        "apellido": "Doblás",
    },
    {
        "_id": 8,
        "nombre": "José Antonio",
        "apellido": "Parra",
    },
])

// Tablas de relaciones
db.alquiler.insertMany([
    {
        "_id": 1,
        "socioID": 1,
        "peliID": 2,
        "dvdID": 1,
        "f_alquiler": new Date("2023-04-02"),
        "f_devolución": new Date("2023-04-23"),
    },
    {
        "_id": 2,
        "socioID": 3,
        "peliID": 6,
        "dvdID": 1,
        "f_alquiler": new Date("2023-04-01"),
        "f_devolución": new Date(),
    },
    {
        "_id": 3,
        "socioID": 2,
        "peliID": 4,
        "dvdID": 2,
        "f_alquiler": new Date("2023-05-06"),
        "f_devolución": new Date(),
    },
    {
        "_id": 4,
        "socioID": 1,
        "peliID": 3,
        "dvdID": 1,
        "f_alquiler": new Date("2019-09-11"),
        "f_devolución": new Date(),
    },
    {
        "_id": 5,
        "socioID": 4,
        "peliID": 1,
        "dvdID": 1,
        "f_alquiler": new Date("2022-02-02"),
        "f_devolución": new Date(),
    },
    {
        "_id": 6,
        "socioID": 1,
        "peliID": 5,
        "dvdID": 1,
        "f_alquiler": new Date("2022-02-02"),
        "f_devolución": new Date("2022-02-03"),
    },
])

db.actua.insertMany([
    {
        "_id": 1,
        "peliID": 1,
        "actorIDs": [
            1, 2, 3,
        ]
    },
    {
        "_id": 2,
        "peliID": 2,
        "actorIDs": [
            4,
        ]
    },
    {
        "_id": 3,
        "peliID": 3,
        "actorIDs": [
            5, 6, 7, 8,
        ]
    },
    {
        "_id": 4,
        "peliID": 4,
        "actorIDs": [
            3, 4, 5, 6, 7,
        ]
    },
    {
        "_id": 5,
        "peliID": 5,
        "actorIDs": [
            1, 8,
        ]
    },
    {
        "_id": 6,
        "peliID": 6,
        "actorIDs": [
            1, 2, 3, 4, 5, 6, 7, 8,
        ]
    },
])

// --------------------------------------------------

