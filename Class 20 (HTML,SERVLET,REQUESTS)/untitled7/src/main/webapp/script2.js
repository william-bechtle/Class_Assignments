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