<!DOCTYPE html>
<html lang="zxx">

<head>
	<title>Mis Reservas</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="utf-8">
	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
	<link href="css/style.css" rel='stylesheet' type='text/css' />
	<link href="css/fontawesome-all.css" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Quicksand:300,400,500,700" rel="stylesheet">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/button.css" rel="stylesheet" type="text/css"/>
        <style>
        body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
        .mySlides {display:none}
        </style>
</head>


<body>
	<!--/banner-w3layouts-sec-->
	<div class="banner-w3layouts two">
		<header>
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
                            
                            <!--Logo-->
                            &nbsp; &nbsp; &nbsp; &nbsp;<a class="navbar-brand" href="home.jsp">
                                <img src="images/logo2.png" style="width: 180px; height: 60px;"/></a>
                            
                            <!--Menu-->
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
                                        
					<ul class="navbar-nav ml-auto">
						<li class="nav-item active">
							<a class="nav-link" href="home.jsp">Home</a>
						</li>
						<li class="nav-item ml-xl-2">
							<a class="nav-link" href="#">Quienes Somos</a>
						</li>
                                                <li class="nav-item ml-xl-2">
							<a class="nav-link" href="#">Departamentos</a>
						</li>
                                                <li class="nav-item ml-xl-2">
							<a class="nav-link" href="#">Servicios</a>
						</li>
						<li class="nav-item ml-xl-2">
							<a class="nav-link" href="">Contacto</a>
						</li>

					</ul>
					<ul class="navbar-nav ml-auto">
                                                <li class="nav-item ml-xl-2">
                                                        <button type="button" onclick="location.href='miPerfil.jsp'" class="btn btn-info btn-block">Mi Perfil</button>
                                                </li>
						<li class="nav-item ml-xl-2">
							<a class="nav-link" href="ingresar.jsp">Ingresar</a>
						</li>
					</ul> 
				</div>
			</nav>
		</header>


	</div>
        
        <section class="banner-w3layouts-bottom py-lg-5 py-3" style="text-align: center">
            <div class="container py-lg-4 py-3">
                <h2>Mis <b>Reservas</b></h2>
                <div class="table-wrapper">

                    <br>
            <table class="table table-striped table-hover table-bordered">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Dirección</th>
                        <th>Ciudad</th>
                        <th>Estado</th>
                        <th>Ciudad</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>Thomas Hardy</td>
                        <td>89 Chiaroscuro Rd.</td>
                        <td>Portland</td>
                        <td>Pendiente</td>
                        <td>USA</td>
                        <td>
                            <button type="button" class="btndele">Cancelar</button>
                        </td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>Maria Anders</td>
                        <td>Obere Str. 57</td>
                        <td>Berlin</td>
                        <td>Pendiente</td>
                        <td>Germany</td>
                        <td>
                            <button type="button" class="btndele">Cancelar</button>
                        </td>
                    </tr>

     
                </tbody>
            </table>
        </div>
            </div>
            
        </section>

	<!--//projects -->
	<!--footer-->
	<footer>
		<div class="footer-sec-w3-agileits py-lg-5 py-3">
			<div class="container py-lg-4 py-3">
				<div class="row">
					<div class="col-lg-4 footer-grid-wthree text-left">
						<h3>About US</h3>
						<p>Curabitur non nulla sit amet nisl tempus convallis quis ac lectus. lacinia eget consectetur sed, convallis at tellus..</p>
						<address class="ad-info mt-3">
							<strong>Twitter, Inc.</strong>
							<br> 1355 Market St, Suite 900
							<br> San Francisco, CA 94103
							<br>
							<abbr title="Phone">P:</abbr> (123) 456-7890
						</address>
					</div>
					<div class="col-lg-4 footer-grid-wthree text-left">

						<div class="tech-btm">
							<h3>Popular Properties </h3>
							<div class="blog-grids row mb-3">
								<div class="col-md-5 blog-grid-left">
									<a href="single.html">
										<img src="images/g1.jpg" class="img-fluid rounded" alt="">
									</a>
								</div>
								<div class="col-md-7 blog-grid-right">
									<h6 class="price mb-2">$12,000</h6>
									<h5>
										<a href="single.html">Pellentesque dui, non felis. Maecenas male non felis </a>
									</h5>
									<div class="sub-meta mt-2">
										<span>
											<i class="fab fa-periscope"></i> 51-199 Pike St,</span>
									</div>
								</div>

							</div>
							<div class="blog-grids row mt-2">
								<div class="col-md-5 blog-grid-left">
									<a href="single.html">
										<img src="images/g5.jpg" class="img-fluid rounded" alt="">
									</a>
								</div>
								<div class="col-md-7 blog-grid-right">
									<h6 class="price mb-2">$13,000</h6>
									<h5>
										<a href="single.html">Pellentesque dui, non felis. Maecenas male non felis </a>
									</h5>
									<div class="sub-meta mt-2">
										<span>
											<i class="fab fa-periscope"></i> 51-199 Pike St,</span>
									</div>
								</div>

							</div>
						</div>
					</div>
					<!-- subscribe -->
					<div class="col-lg-4 subscribe-main footer-grid-wthree text-left">
						<h2>Signup to our newsletter</h2>
						<div class="subscribe-main text-left">
							<div class="subscribe-form">
								<form action="#" method="post" class="subscribe_form">
									<input class="form-control" type="email" placeholder="Enter your email..." required="">
									<button type="submit" class="btn btn-primary submit">Submit</button>
								</form>
								<div class="clearfix"> </div>
							</div>
							<p>We respect your privacy.No spam ever!</p>
						</div>
						<!-- //subscribe -->
					</div>
				</div>
				<!-- //footer -->
			</div>
		</div>

	</footer>
	<!---->



</body>

</html>


