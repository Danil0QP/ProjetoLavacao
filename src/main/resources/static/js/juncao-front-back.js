fetch("http://localhost:8080/clientes")
    .then(response => response.json())
    .then(data => console.log(data));