<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
</head>
<style>
h4 { color: #FF0000; }
</style>
<body>

<div class="container-fluid">
		<div class="container">
			
			<h2 class="text-center" id="title">&nbsp; Trofi &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Cliente</h2>
			<p class="text-center">
			</p>
			<hr>
			<div class="row">
			
				<div class="col-md-4">
					
				</div>
				
				<div class="col-md-5">
				<form action="IniciarSesion?action=verificarCliente" method="post">
				
						<fieldset>
								<h3>Correo</h3>
								<h4>El correo ingresado es invalido</h4>
							<div class="form-group">
								<input type="text" name="correo" 
									class="form-control input-lg">
							</div>
								<h3>Contraseña</h3>
							<div class="form-group">
								<input type="password" name="contrasenia"
									class="form-control input-lg">
							</div>
							<div>
								<input type="submit" class="btn btn-success btn-lg" value="Aceptar">
							</div>
						</fieldset>
					</form>
				</div>				
			</div>
		</div><hr>
	</div>
</body>
</html>