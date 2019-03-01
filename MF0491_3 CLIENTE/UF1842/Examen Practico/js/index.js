function startGame() {															                //INICIAR EL AREA
  myGameArea.start();
  myGamePiece = new component(30, 30, "red", 10, 120);						//CREA UN NUEVO COMPONENTE CON LAS CARACTERÍSTICAS DADAS
  myBloqCal= document.getElementById('bloqCal');
  myBloqCal = new component(300, 510, "black", 70, 109);
  var musica=document.getElementById("musica");
  document.getElementById("slider").value=100;    

}

var myGameArea = {     //CREAR Y DEFINIR EL AREA DE JUEGO
  canvas : document.createElement("canvas"),
  start : function() {      
    this.canvas.width = window.innerWidth;  //ESTABLECE LA ANCHURA DEL AREA A LA PANTALLA  
    this.canvas.height = window.innerHeight;  //ESTABLECE LA ALTURA DEL AREA A LA PANTALLA
    this.context = this.canvas.getContext("2d");
    document.body.insertBefore(this.canvas, document.body.childNodes[0]);
    this.interval = setInterval(updateGameArea, 20);  //ACTUALIZA EL AREA CADA X TIEMPO

   window.addEventListener('keydown', function (e) {
      myGameArea.keys = (myGameArea.keys || []);
      myGameArea.keys[e.keyCode] = true;
    })
    window.addEventListener('keyup', function (e) {
      myGameArea.keys[e.keyCode] = false; 
    })
  }, 
  clear : function(){
    this.context.clearRect(0, 0, this.canvas.width, this.canvas.height);
  }
}

 function updateGameArea() {          //FUNCION QUE ACTUALIZA EL AREA Y LA POSICIÓN DE LA PIEZA 
  myGameArea.clear();
  if (myGameArea.keys && myGameArea.keys[37]) {moveleft();}
  if (myGameArea.keys && myGameArea.keys[39]) {moveright();}
  if (myGameArea.keys && myGameArea.keys[38]) {jump();}
  myGamePiece.newPos(); 
  myGamePiece.update();
  myBloqCal.update();
}

function component(width, height, color, x, y) {      //FUNCION QUE CREA EL COMPONENTE
  this.width = width;
  this.height = height;
  this.speedX = 0;
  this.speedY = 0;
  this.friccion= 0.9;
  this.gravity = 0.5;
  this.gravitySpeed = 0;
  this.bounce = 0.6;
  this.x = x;
  this.y = y; 
  this.update = function(){                         
    ctx = myGameArea.context;
    ctx.fillStyle = color;
    ctx.fillRect(this.x, this.y, this.width, this.height);
  }
  this.newPos = function() {
    this.speedX *= this.friccion;
    this.x += this.speedX;

    this.gravitySpeed += this.gravity;
    this.y += this.speedY + this.gravitySpeed;
                                  
    if (this.y+this.width>=window.innerHeight){       //NO PERMITE IR MÁS ALLA DEL BORDE INFERIOR
      this.hitBottom();
      this.y= window.innerHeight-this.width;
    }
    if (this.y<=60){                                   //NO PERMITE IR MÁS ALLA DEL BORDE SUPERIOR
      this.y=60;
      this.gravitySpeed= 0;
    }
    if (this.x<=0){                                   //NO PERMITE IR MÁS ALLA DEL BORDE IZQUIERDA
      this.x=0;
    }
    if (this.x+this.width>=window.innerWidth){        //NO PERMITE IR MÁS ALLA DEL BORDE DERECHO
      this.x= window.innerWidth-this.width;
    }
  }
  this.hitBottom = function() {                       //FUNCION PARA REBOTAR  
    this.gravitySpeed = -(this.gravitySpeed * this.bounce);    
  }
}

function jump() {         //FUNCION SALTAR
  myGamePiece.gravitySpeed -= 1; 
}

function moveleft() {     //FUNCION MOVER A LA IZQUIERDA
  myGamePiece.speedX = -5;
}

function moveright() {    //FUNCION MOVER A LA DERECHA
  myGamePiece.speedX = 5;
}

var borrar = false;                                                           //COMIENZO FUNCIONES CALCULADORA
  function deletecarac(){
    var caja2 = document.f1.txtcaja2.value;
            if (caja2 == "" || caja2 == "0" || caja2.length == 1 && blocdel!=true){
              document.f1.txtcaja2.value = "0";
            }
            else if(blocdel!=true){
              var res = caja2.substring(0,caja2.length-1);
              document.f1.txtcaja2.value = res;
            }
  }
   function escribir(n){
    var caja2 = document.f1.txtcaja2.value;
    if (borrar) {
      //alert("se borro");
      document.f1.txtcaja2.value="";
      borrar = false;
      document.f1.txtcaja2.value = n;
    }
    else if (caja2 == "0" && n != "."){
      cajao = caja2.replace("0", "")
      document.f1.txtcaja2.value = cajao + n;
    }
    else{
      document.f1.txtcaja2.value = caja2 + n;
    }
  }
  function raiz(){
    var caja1 = document.f1.txtcaja1.value;
    var caja2 = document.f1.txtcaja2.value;
    document.f1.txtcaja1.value = "Math.sqrt("+ caja2 + caja1 +")";
    document.f1.txtcaja2.value = "";
  }
  function arit(o){
    var caja1 = document.f1.txtcaja1.value;
    var caja2 = document.f1.txtcaja2.value;
    var unum = caja1.substring(caja1.length-1);
    calcular()
    if (unum == "+" || unum == "-" || unum=="*" || unum=="/") {
      unum = unum.replace(unum,o);
      var res = caja1.substring(0,caja1.length-1);
      document.f1.txtcaja1.value = res+unum;
    }
    if (caja1 == "" && caja2 != ""){
      document.f1.txtcaja1.value = caja2 + o;
    }
    else{
      document.f1.txtcaja1.value = caja1 + caja2 + o;
    }
    borrar = true;
  }
  function calcular(){
    var caja1 = document.f1.txtcaja1.value;
    var caja2 = document.f1.txtcaja2.value;
    document.f1.txtcaja2.value = eval(caja1 + caja2);
    document.f1.txtcaja1.value = "";
    borrar = true;
    blocdel = true;
  }
  function masmenos(){
    var caja2 = document.f1.txtcaja2.value;
    if (caja2 > 0){
      document.f1.txtcaja2.value = "(-" + caja2 + ")";
    }
    else{
      cajaplus = caja2.replace(/[-|(|)]/g, "");
      document.f1.txtcaja2.value = cajaplus;
    }
  }                                                         //FIN FUNCIONES CALCULADORA

function ampliar(x) {
    x.style.width = '1200px';
    x.style.height = '600px';
    x.style.position= 'absolute';
    x.style.top= '-80px';
    x.style.left= '-890px';
    x.style.borderLeft= '3px solid black';
    x.style.borderRight= '3px solid black';
    x.style.zIndex= 5;
}
function reducir (x) {
    x.style.width = '300px';
    x.style.height = '135px';
    x.style.position= 'relative';
    x.style.top= '0';
    x.style.left= '0';
    x.style.borderLeft= 'none';
    x.style.borderRight= 'none';
    x.style.zIndex=4;
}       

function reproducir(){                        //REPRODUCIR MUSICA DE FONDO
  musica.play();
}
function parar(){                         //PAUSAR MUSICA DE FONDO
  musica.pause();
}
function setvolume(){                       //CONTROLAR VOLUMEN MUSICA DE FONDO
  musica.volume= parseInt(slider.value)/100;
}