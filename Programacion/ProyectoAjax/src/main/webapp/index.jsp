<%-- -------------------------------------------------------------------------------------------------------------------
                   Directivas
----------------------------------------------------------------------------------------------------------------------%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    String titulo = "Calculadora de pila";
    String servlet = "Calculadora";
%>


<%-- -------------------------------------------------------------------------------------------------------------------
                   HTML
----------------------------------------------------------------------------------------------------------------------%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><%= titulo %></title>
    <%-- CSS ---------------------------------------------------------------------------------------------------------%>
    <style>
        .div-center {
            position: absolute;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
        }
    </style>
    <%-- ---------------------------------------------------------------------------------------------------------------
                   2 - javascript - AJAX (con jquery)
    ------------------------------------------------------------------------------------------------------------------%>
    <script src="https://code.jquery.com/jquery-latest.js"></script>
    <script>
        $(document).ready(function() {
            $('#borrar').click(function (event) {
                $('#resultado').html("RESULTADO");
            });

            $('#calcular').click(function (event) {
                let textoVar = $('#texto').val(); // capta contenido de id='texto'
                $.get('<%= servlet %>', {
                    texto: textoVar
                }, function (responseText) {
                    $('#resultado').html(responseText);
                })
                    .done(function() {
                        //alert( "second success" );
                    })
                    .fail(function(e) {
                        alert( "error "+e );
                    });
            });

            $('#miPrimerServlet').click(function (event) {
                window.location.href = "escucha-peticiones";
                //$('#resultado').html("RESULTADO");
            });
        });
    </script>

</head>
<body>
<div class="div-center">
    <h1><%= titulo %></h1>

    <%-- ---------------------------------------------------------------------------------------------------------------
                   1 - Formulario
    ------------------------------------------------------------------------------------------------------------------%>
    <div style="border: 1px solid black; padding: 1em;">
        <form>
            <label>La ecuación a mandar a la calculadora:</label><br />
            <input type="text" id="texto" value="2 2 + 3 *"/>
        </form>
        <div><button id="borrar">Borrar</button>&nbsp;
            <button id="calcular">Calcular</button>
            <h1 id="resultado" style="text-align: right">RESULTADO</h1>
        </div>
    </div>
    <div style="height: 3em;"></div>
    <div style="border: 1px solid black; padding: 1em;">
        <div id="miPrimerServlet">Ir a mi primer servlet</div>
    </div>

</body>
</html>