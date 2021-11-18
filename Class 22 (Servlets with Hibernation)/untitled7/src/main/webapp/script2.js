let x = document.cookie;
x = x.split(';');
x = x[0].split('=');
x = x[1];
const b = "1";
document.getElementById("user").value = x;
document.getElementById("url").value = b;

function add() {
    let x = Number(document.getElementById("input1").value);
    let y = Number(document.getElementById("pass").value);
    let z = x+y;
    document.getElementById("res").value = z;
}

function sub() {
    let x = Number(document.getElementById("input1").value);
    let y = Number(document.getElementById("pass").value);
    let z = x-y;
    document.getElementById("res").value = z;
}

function mul() {
    let x = Number(document.getElementById("input1").value);
    let y = Number(document.getElementById("pass").value);
    let z = x*y;
    document.getElementById("res").value = z;
}
function div() {
    let x = Number(document.getElementById("input1").value);
    let y = Number(document.getElementById("pass").value);
    let z = x/y;
    document.getElementById("res").value = z;
}