let searchParams = new URLSearchParams(window.location.search);
        let email = searchParams.get('email');
        let password = searchParams.get('password');
        let address1 = searchParams.get('address1');
        let address2 = searchParams.get('address2');
        let city = searchParams.get('city');
        let state = searchParams.get('state');
        let zip = searchParams.get('zip');
        let age = searchParams.get('age');
        document.getElementById("tables").innerHTML += `
        <tr>
            <td>${email}</td>
            <td>${password}</td>
            <td>${address1}</td>
            <td>${address2}</td>
            <td>${city}</td>
            <td>${state}</td>
            <td>${zip}</td>
            <td>${age}</td>
        </tr>
        `;
function getDat() {
    location.href = "http://localhost:8081/home";
}


