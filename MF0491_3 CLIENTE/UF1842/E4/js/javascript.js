function init(){														//INICIAR VARIABLES

		objImage=document.getElementById("pokemon");					//VARIABLES POKEMON
		objImage.style.position='sticky';
		objImage.style.left='600px';
		objImage.style.top='450px';

		humo=document.getElementById("humo");							//VARIABLES HUMO
		humo.style.position='absolute';
		humo.style.top= '40px';

		fondo1=document.getElementById("suelo");						//VARIABLES SUELO
		fondo1.style.backgroundPosition= '0px';	

		humo.addEventListener("webkitAnimationEnd", reset_humo);		//RESET ANIMACION HUMO
		objImage.addEventListener("webkitAnimationEnd", reset_salto);	//RESET ANIMACION SALTO

		var musica=document.getElementById("musica");					//VARIABLE MUSICA DE FONDO
		setTimeout("reproducir()", 3000);								

		var pokeball = document.getElementById('pokeball');				//VARIABLE SONIDO POKEBALL				
		pokeball.playbackRate= 2.5;
		pokeball.volume=0.1;

		document.getElementById("slider").value=100;					//ASIGNAR VALOR MAXIMO AL SLIDER DEL VOLUMEN

		var map = {}; 													//VARIABLE ARRAY TECLAS
		onkeydown = onkeyup = function(e){
    		e = e || event; 
   		 	map[e.keyCode] = e.type == 'keydown';

			if(map[16] && map[37]){										//EJECUTAR CORRER IZQUIERDA
			runLeft();
			}
			if(map[16] && map[39]){										//EJECUTAR CORRER DERECHA
			runRight();
			}
			if(map[37]){												//EJECUTAR CAMINAR IZQUIERDA
			moveLeft();
			}
			if (map[39]) {												//EJECUTAR CAMINAR DERECHA
			moveRight();
			}
			if (map[38]){	
				if (volador){											//EJECUTAR VOLAR ARRIBA
					flyup();											
				}
				else {jump();}											//EJECUTAR SALTAR
			}
			if (map[40]){
				if (volador){											//EJECUTAR VOLAR ABAJO
					flydown();
				}
			}
		}
	}
	function moveLeft(){												//CAMINAR IZQUIERDA
		if (parseInt(objImage.style.left)<=1200){
			objImage.style.left=parseInt(objImage.style.left)-5 +'px';
		}
		else {
			objImage.style.left= 1200+'px';								//EVITAR QUE SE SALGA DE LA PANTALLA
		}
		objImage.style.backgroundPosition= '0px 0px';
		objImage.style.animation= 'walkleft 0.5s steps(4) infinite';
		fondo1.style.backgroundPosition= parseInt(fondo1.style.backgroundPosition)+2.5 +'px';
	}
	function runLeft(){													//CORRER IZQUIERDA
		if (parseInt(objImage.style.left)<=1200){
			objImage.style.left=parseInt(objImage.style.left)-10 +'px';
		}
		else {
			objImage.style.left= 1200+'px';								//EVITAR QUE SE SALGA DE LA PANTALLA
		}
		objImage.style.backgroundPosition= '0px 0px';
		objImage.style.animation= 'walkleft 0.5s steps(4) infinite';
		fondo1.style.backgroundPosition= parseInt(fondo1.style.backgroundPosition)+5 +'px';
	}
	function moveRight(){												//CAMINAR DERECHA
		if (parseInt(objImage.style.left)>=0){							
			objImage.style.left=parseInt(objImage.style.left)+5 +'px';
		}
		else {
			objImage.style.left= 0+'px';								//EVITAR QUE SE SALGA DE LA PANTALLA
		}
		objImage.style.backgroundPosition= '0px 128px';
		objImage.style.animation= 'walkright 1s steps(4) infinite';
		fondo1.style.backgroundPosition= parseInt(fondo1.style.backgroundPosition)-2.5 +'px';
	}
	function runRight(){												//CORRER DERECHA
		if (parseInt(objImage.style.left)<=1200){
			objImage.style.left=parseInt(objImage.style.left)+10 +'px';
		}
		else {
			objImage.style.left= 1200+'px';								//EVITAR QUE SE SALGA DE LA PANTALLA
		}
		objImage.style.backgroundPosition= '0px 128px';
		objImage.style.animation= 'walkright 0.5s steps(4) infinite';
		fondo1.style.backgroundPosition= parseInt(fondo1.style.backgroundPosition)-5 +'px';
	}
	function jump(){													//SALTAR
		objImage.style.animation= 'jump 1s';
	}
	function flyup(){													//VOLAR ARRIBA
		if (parseInt(objImage.style.top)>=0){
			objImage.style.top=parseInt(objImage.style.top)-5 +'px';
		}	
		else {															//EVITAR QUE SE SALGA DE LA PANTALLA
			objImage.style.top= 0+'px';
		}
	}
	function flydown(){													//VOLAR ABAJO
		if (parseInt(objImage.style.top)<500){
			objImage.style.top=parseInt(objImage.style.top)+5 +'px';
		}
		else {															//EVITAR QUE SE SALGA DE LA PANTALLA
			objImage.style.top= 500+'px';
		}
	}
	function changeBulbasaur(){											//CAMBIAR A BULBASAUR
		humo.style.animation= 'explosion 1s steps(11)';
		objImage.style.top='450px';
		objImage.style.backgroundImage='url(../sprite/bulbasaur.png)';
		objImage.style.backgroundSize= '512px';
		volador= false;
		pokeball.play();
	}
	function changeCharmander(){										//CAMBIAR A CHARMANDER
		humo.style.animation= 'explosion 1s steps(11)';
		objImage.style.top='450px';
		objImage.style.backgroundImage='url(../sprite/charmander.png)';
		objImage.style.backgroundSize= '512px';
		volador= false;
		pokeball.play();
	}
	function changeSquirtle(){											//CAMBIAR A SQUIRTLE
		humo.style.animation= 'explosion 1s steps(11)';
		objImage.style.top='450px';
		objImage.style.backgroundImage='url(../sprite/squirtle.png)';
		objImage.style.backgroundSize= '512px';
		volador= false;
		pokeball.play();
	}
	function changePidgeot(){											//CAMBIAR A PIDGEOT
		humo.style.animation= 'explosion 1s steps(11)';
		objImage.style.backgroundImage='url(../sprite/pidgeot.png)';
		objImage.style.backgroundSize= '512px';
		volador= true;
		pokeball.play();
	}
	function reset_humo() {												//RESET HUMO
 	humo.style.animation = 'none';
 	humo.offsetHeight; /* trigger reflow */
  	humo.style.animation = null; 
	}
	function reset_salto() {											//RESET SALTO
 	objImage.style.animation = 'none';
 	objImage.offsetHeight; /* trigger reflow */
  	objImage.style.animation = null; 
	}
	function reproducir(){												//REPRODUCIR MUSICA DE FONDO
		musica.play();
	}
	function parar(){													//PAUSAR MUSICA DE FONDO
		musica.pause();
	}
	function setvolume(){												//CONTROLAR VOLUMEN MUSICA DE FONDO
		musica.volume= parseInt(slider.value)/100;
	}