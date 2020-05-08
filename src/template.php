<!DOCTYPE html>
<html lang="en">

<head>
	<title>LIVEFOX</title>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<!--     Fonts and icons     -->
	<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/css/add.css">
	<!-- Material Kit CSS -->
	<link href="assets/css/material-kit.css?v=2.0.6" rel="stylesheet" />
	<link href="https://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 			crossorigin="anonymous">
	<link rel="icon" href="assets/favicon.ico" />
</head>

<body>
<nav class="navbar navbar-expand-lg bg-white">
	<div class="container">
		<a class="navbar-brand" href="template.php"><img border="0" src="assets/img/logo.png" width="30" height="30" alt="Livefox presentation"> LIVEFOX</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
			<span class="sr-only">Toggle navigation</span>
    			<span class="navbar-toggler-icon"></span>
    			<span class="navbar-toggler-icon"></span>
    			<span class="navbar-toggler-icon"></span>
    		</button>
    		<div class="collapse navbar-collapse" id="navbarText">
        		<ul class="navbar-nav mr-auto">
        			<li class="nav-item active">
					<a class="nav-link" href="template.php"><em class="material-icons">home</em>Home</a>
        			</li>
        			<li class="nav-item">
        	  			<a class="nav-link" href="#Videos"><em class="material-icons">play_arrow</em>Videos</a>
        			</li>
      			</ul>
    		</div>
  	</div>
</nav>
    
<header>
	<div class="overlay"></div>
		<video playsinline="playsinline" autoplay="autoplay" muted="muted" loop="loop">
			<source src="assets/landscape.mp4">
		</video>
		<div class="container h-100">
			<div class="d-flex h-100 text-center align-items-center">
				<div class="w-100 text-white">
					<h1 class="display-3"><img border="0" src="assets/img/logo2.png" width="40" height="40" alt="Foreground logo">LIVEFOX</h1>
					<p class="lead mb-0">Discover new amazing content!</p>
				</div>
			</div>
		</div>
</header>
    
<div class="main main-raised p-3">
	<div>
		<div class="row">
			<div class="col-sm">
				<div class="card">
					<div class="card-header card-header-primary rounded">
						<h4 class="card-title" id="Videos">VIDEOS</h4>
							<p class="category">Discover new videos in several categories!</p>
					</div>
					<div class="card-body">
						<?php
							$dossier = 'upl_enc/';
							$iterator = new DirectoryIterator($dossier);
							foreach($iterator as $fichier){
								if($fichier->isFile() && $fichier->getExtension() == "mpd") {
      									echo '<video src="upl_enc/'.$fichier.'" class="video1"  style="padding-right:5px" data-dashjs-player controls></video>';
								}
							} ?>
					</div>
				</div>             
			</div>
		</div>        
	</div>
</div>
  
<script src="https://cdn.dashjs.org/latest/dash.all.min.js"></script>
<br>
<!-- Footer -->
<footer id="sticky-footer" class="py-4 bg-dark text-white-50">
	<div class="container text-center">
		<p>Copyright &copy 2020 LIVEFOX</p>
	</div>
</footer>
<!-- Footer -->
</body>
</html>
