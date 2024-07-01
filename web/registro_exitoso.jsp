<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="refresh" content="3; URL=index.html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro Exitoso - Taller Antonio Piedrahita</title>
    <style>
        body {
            position: relative;
            margin: 0;
            padding: 0;
            background-color: #E6DDDD;
            text-align: center; /* Alinea el contenido al centro horizontalmente */
        }
        body::before {
            content: '';
            position: absolute;
            top: -125px;
            left: 20px;
            width: 96.5%;
            height: 190%;
            background-color: #DFDEDE;
            border: 3px solid #707070;
            z-index: -1;
        }      
        h1, #mensajeRegistroExitoso {
            font-size: 70px;
            margin-top: 150px; /* Ajusta el margen superior para centrarlo verticalmente */
        }
    </style>
</head>
<body>
    <h1>Registro Exitoso</h1>
    <div id="mensajeRegistroExitoso">¡Tu registro ha sido exitoso!</div>
</body>
</html>
