// Utilize o jQuery Mask Plugin: https://igorescobar.github.io/jQuery-Mask-Plugin/
// Adicione no HTML as tags script para importar o jQuery e o jQuery Mask Plugin
// <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
// <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"></script>

$("#cep").mask("99999-999");

let cep = document.getElementById("cep");

cep.addEventListener("keyup", function (event) {
    if (cep.value.length == 9) {
        autoCompleteCep(cep.value);
    }
});

function autoCompleteCep(cep) {
    let url = `http://localhost:8080/cep/${cep}`;
    fetch(url).then(function (response) {
        if (response.ok) {
            response.json().then(function (data) {
                document.getElementById("logradouro").value = data.logradouro;
                document.getElementById("bairro").value = data.bairro;
                document.getElementById("cidade").value = data.cidade;
                document.getElementById("uf").value = data.uf;
            });
        } else {
            console.log("Erro ao buscar CEP");
        }
    });
}