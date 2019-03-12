function cambiarColores(z) {
    var todos = document.getElementsByTagName('*');
    const todosFijo = document.getElementsByTagName('*');
    var i;
    if (z%2==0){
        for (i = 0; i < todos.length; i++) {
            todos[i].style.backgroundImage = "none";
            todos[i].style.backgroundColor = "none";
            todos[i].style.color = "yellow";
            document.getElementById('sol').style.backgroundImage= 'url("http://pluspng.com/img-png/png-hd-sun-with-sunglasses-sun-hd-sun-hd-png-png-hd-picture-of-sun-824.png")';
        }
    }
    else {
        for (i = 0; i < todosFijo.length; i++) {
            todos[i].style= todosFijo[i].style;
        }
    }
    this.z = z + 1;
    return this.z;
}

function aumTam(multi) {
    txt = document.getElementById('body');
    style = window.getComputedStyle(txt, null).getPropertyValue('font-size');
    currentSize = parseFloat(style);
    txt.style.fontSize = (currentSize + 1) + 'px';
}
function disTam(multi) {
    txt = document.getElementById('body');
    style = window.getComputedStyle(txt, null).getPropertyValue('font-size');
    currentSize = parseFloat(style);
    txt.style.fontSize = (currentSize - 1) + 'px';
}
function colorFuen() {
    var colorFue = document.getElementById('colorFuente').value;
    var todos = document.getElementsByTagName('*');
    for (i = 0; i < todos.length; i++) {
            todos[i].style.color = colorFue;
        }
}
function colorFond() {
    var colorFon = document.getElementById('colorFondo').value;
    var todos = document.getElementsByTagName('*');
    for (i = 0; i < todos.length; i++) {
            todos[i].style.background = colorFon;
        }
    document.getElementById('sol').style.background= 'none';
    document.getElementById('sol').style.backgroundImage= 'url("http://pluspng.com/img-png/png-hd-sun-with-sunglasses-sun-hd-sun-hd-png-png-hd-picture-of-sun-824.png")';
}

function getSelectionText() {
    var text = "";
    if (window.getSelection) {
        text = window.getSelection().toString();
    } 
    else if (document.selection && document.selection.type != "Control") { 
        text = document.selection.createRange().text;
    }
    return text;
}
function leerSeleccion(s){
     this.s = s + 1;
    return this.s;
}

function leerTodo() {
    var theText = document.body.innerText;
    responsiveVoice.speak(theText, "Spanish Female");
}
