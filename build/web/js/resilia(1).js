/////////////////MASCARA DO TELEFONE RESIDENCIAL E CELULAR-1

function telefoneMask1(){
	if(document.getElementById('tipoTelefone1').value == "1") {
		$('.telefone1').mask('00 0000-0000', {reverse: true});
	}
	if(document.getElementById('tipoTelefone1').value == "2") {
		$('.telefone1').mask('00 00000-0000', {reverse: true});
	}
	if(document.getElementById('tipoTelefone1').value == "3") {
		$('.telefone1').mask('00 00000-0000', {reverse: true});
	}
	if(document.getElementById('tipoTelefone1').value == "4") {
		$('.telefone1').mask('00 00000-0000', {reverse: true});
	}
} 
/////////////////MASCARA DO TELEFONE RESIDENCIAL E CELULAR-
function telefoneMask2(){
	if(document.getElementById('tipoTelefone2').value == "celular") {
		$('.telefone2').mask('00 00000-0000', {reverse: true});
	}
	
	if(document.getElementById('tipoTelefone2').value == "residencial") {
		$('.telefone2').mask('00 0000-0000', {reverse: true});
	}
} 
/////////////////MASCARA DO TELEFONE RESIDENCIAL E CELULAR-3
function telefoneMask3(){
	if(document.getElementById('tipoTelefone3').value == "celular") {
		$('.telefone3').mask('00 00000-0000', {reverse: true});
	}
	
	if(document.getElementById('tipoTelefone3').value == "residencial") {
		$('.telefone3').mask('00 0000-0000', {reverse: true});
	}
} 
/////////////////MASCARA DO TELEFONE RESIDENCIAL E CELULAR-4
function telefoneMask4(){
	if(document.getElementById('tipoTelefone4').value == "celular") {
		$('.telefone4').mask('00 00000-0000', {reverse: true});
	}
	
	if(document.getElementById('tipoTelefone4').value == "residencial") {
		$('.telefone4').mask('00 0000-0000', {reverse: true});
	}
} 





/////////////////MASCARA DO TELEFONE RESIDENCIAL E CELULAR

//function telefoneMask(selectID){

//	var tipoTelefone = `tipoTelefone${selectID}`
//	var telefone = `#telefone${selectID}`

//console.log(document.getElementById(tipoTelefone))
//console.log($(telefone))

//	if(document.getElementById(tipoTelefone).value == "celular") {
//		$(telefone).mask("00 00000-0000", {reverse: true});
//	}
	
//	if(document.getElementById(tipoTelefone).value == "residencial") {
//		$(telefone).mask('00 0000-0000', {reverse: true});
//	}
//}  

//função para adicionar mais telefones aos cadastros
var quantidadetelefone = 1
 
function adicionarTelefone (){
	
	if(quantidadetelefone == 10){
		return;
	}
  
		
		document.getElementById("divTelefone").innerHTML +=`  <div class="form-row">

		<div class="col-md-3">    </div>

		<div class="col-md-2">
			<div class="form-group">
				<label class="small mb-2 " >Tipo de Telefone*</label>
				<select id="tipoTelefone${quantidadetelefone}" name="tipoTelefone${quantidadetelefone}" class="form-control"  style="height:46px;" onchange="telefoneMask('${quantidadetelefone}')">
					<option disabled selected> </option>
					<option value="celular">Celular</option>
					<option value="residencial">Residencial</option>
				  

				</select>
			</div>
		</div>

		<div class="col-md-2">
			<div class="form-group">
				<label class="small mb-1" for="inputLastName">Telefone*</label>
				<input class="telefone-slc form-control py-4" id="telefone${quantidadetelefone}" name="telefone${quantidadetelefone}" type="text" placeholder="Telefone"/>
			</div>
		</div>

	
	<div class="col-md-2 mt-1">
		
	</div>
		
</div>`;

	
quantidadetelefone++;


	

}


//função para adicionar o telefone do pre cadastro


function adicionarTelefonePre (){

	while(true){

		document.getElementById("divTelefonePre").innerHTML += `<div class="form-row">

		<div class="col-md-3">
				<div class="form-group">
						<label class="small mb-1" for="inputState">Telefone</label>
						<select style="height: 49px;" id="tipoTelefone${quantidadetelefone}" name="tipoTelefone${quantidadetelefone}" class="form-control">
								<option disabled selected></option>
								<option>Celular</option>
								<option>Residencial</option>
								
						</select>
				</div>
		</div>
		<div class="col-md-6">
				<div class="form-group">
						<label class="small mb-1" for="inputLastName">Telefone</label>
						<input class="form-control py-4" id="telefone${quantidadetelefone}" name="telefone${quantidadetelefone}" type="text" placeholder="(xx) xxxxxxxxx" />
				</div>
		</div>
		<div class="col-md-3 mt-1">
				
		</div>
		</div>`
		break
	}
	quantidadetelefone++
}

//////////////Codigo para mascara de telefone1

$("#telefone1").keydown(function(){
	try {
		$("#telefone1").unmask();
	} catch (e) {}

	var tamanho = $("#telefone1").val().length;

	if(tamanho < 10){
		$("#telefone1").mask("99 9999-9999");
	} else {
		$("#telefone1").mask("99 99999-9999");
	}

		//ajustando foco
	var elem = this;
	setTimeout(function(){
		//mudo a posição do seletor
		elem.selectionStart = elem.selectionEnd = 10000;
	}, 0);
	//reaplico o valor para mudar o foco
	var currentValue = $(this).val();
	$(this).val('');
	$(this).val(currentValue);
});


//////////////Codigo para mascara de telefone2

$("#telefone2").keydown(function(){
	try {
		$("#telefone2").unmask();
	} catch (e) {}

	var tamanho = $("#telefone2").val().length;

	if(tamanho < 10){
		$("#telefone2").mask("99 9999-9999");
	} else {
		$("#telefone2").mask("99 99999-9999");
	}

		//ajustando foco
	var elem = this;
	setTimeout(function(){
		//mudo a posição do seletor
		elem.selectionStart = elem.selectionEnd = 10000;
	}, 0);
	//reaplico o valor para mudar o foco
	var currentValue = $(this).val();
	$(this).val('');
	$(this).val(currentValue);
});

//////////////Codigo para mascara de telefone3

$("#telefone3").keydown(function(){
	try {
		$("#telefone3").unmask();
	} catch (e) {}

	var tamanho = $("#telefone3").val().length;

	if(tamanho < 10){
		$("#telefone3").mask("99 9999-9999");
	} else {
		$("#telefone3").mask("99 99999-9999");
	}

		//ajustando foco
	var elem = this;
	setTimeout(function(){
		//mudo a posição do seletor
		elem.selectionStart = elem.selectionEnd = 10000;
	}, 0);
	//reaplico o valor para mudar o foco
	var currentValue = $(this).val();
	$(this).val('');
	$(this).val(currentValue);
});

//////////////Codigo para mascara de telefone4

$("#telefone4").keydown(function(){
	try {
		$("#telefone4").unmask();
	} catch (e) {}

	var tamanho = $("#telefone4").val().length;

	if(tamanho < 10){
		$("#telefone4").mask("99 9999-9999");
	} else {
		$("#telefone4").mask("99 99999-9999");
	}

		//ajustando foco
	var elem = this;
	setTimeout(function(){
		//mudo a posição do seletor
		elem.selectionStart = elem.selectionEnd = 10000;
	}, 0);
	//reaplico o valor para mudar o foco
	var currentValue = $(this).val();
	$(this).val('');
	$(this).val(currentValue);
});


//////////////Codigo para mascara de cpf

		$("#numeroCpfCnpjUsuario").keydown(function(){
			try {
				$("#numeroCpfCnpjUsuario").unmask();
			} catch (e) {}

			var tamanho = $("#numeroCpfCnpjUsuario").val().length;

			if(tamanho < 11){
				$("#numeroCpfCnpjUsuario").mask("999.999.999-99");
			} else {
				$("#numeroCpfCnpjUsuario").mask("99.999.999/9999-99");
			}

				//ajustando foco
			var elem = this;
			setTimeout(function(){
				//mudo a posição do seletor
				elem.selectionStart = elem.selectionEnd = 10000;
			}, 0);
			//reaplico o valor para mudar o foco
			var currentValue = $(this).val();
			$(this).val('');
			$(this).val(currentValue);
		});




//////////////Codigo para mascara de RG/RNG
$('#naturalizacaoDocumento').attr('maxlength', 14);



//Código para dizer se as senhas são iguais em tempo real

//var senha = document.getElementById("senha").value;
//var tipoTelefone = document.getElementById("tipoTelefone").value;

//if(senha.value != tipoTelefone.value){
//	document.getElementById("situaçãoSenha").innerHTML += ` <label class="small mb-1" for="inputFirstName">**As senhas não coincidem.</label> `
//} else {
//	document.getElementById("situaçãoSenha").innerHTML += ` <label class="small mb-1" for="inputFirstName">**As senhas coincidem.</label> `
//}


$('#senha, #confirmaSenha').on('keyup', function () {

	if ($('#senha').val() == $('#confirmaSenha').val()) {
	  $('#message').html('***As senhas coincidem').css('color', 'green');
	} else 
	  $('#message').html('***Senhas não coincidem').css('color', 'red');
  });






//Código para conferir senhas

			function validar(){
				var senha = cadastrarUsu.senha.value;
				var confirmaSenha = cadastrarUsu.confirmaSenha.value;
				
				if(senha == "" || senha.length <= 5){
					alert('Preencha o campo senha com minimo 6 caracteres');
					cadastrarUsu.senha.focus();
					return false;
				}
				
				if(confirmaSenha == "" || confirmaSenha.length <= 5){
					alert('Preencha o campo senha com minimo 6 caracteres');
					cadastrarUsu.confirmaSenha.focus();
					return false;
				}
				
				if (senha != confirmaSenha) {
					alert('Senhas diferentes');
					cadastrarUsu.senha.focus();
					return false;
				}
			}

/////////////////MASCARA DOS CAMPOS DE NATURALIZAÇÃO E CNPJ CPF


  





			//Tabelas clicaveis
			$(".rows").click(
				function(e){
				  alert($(this).data('href'));
				  window.location.replace($(this).data('href'));
				  return false;
				}
			  )
			





		
		
		
			// estado e UF preenchimento automático 

var cidades = {
    "estados": [
        {
            "sigla": "AC",
            "nome": "Acre",
            "cidades": [
                "AC"
            ]
        },
        {
            "sigla": "AL",
            "nome": "Alagoas",
            "cidades": [
                "AL"
            ]
        },
        {
            "sigla": "AP",
            "nome": "Amapá",
            "cidades": [
                "AP"
            ]
        },
        {
            "sigla": "AM",
            "nome": "Amazonas",
            "cidades": [
                "AM"
            ]
        },
        {
            "sigla": "BA",
            "nome": "Bahia",
            "cidades": [
                "BA"
            ]
		},
		{
			"sigla": "CE",
			"nome": "Bahia",
			"cidades": [
				"CE"
			]
		},
		{
			"sigla": "DF",
			"nome": "Brasília",
			"cidades": [
				"DF"
			]
		},
		{
			"sigla": "ES",
			"nome": "Espírito santo",
			"cidades": [
				"ES"
			]
		},
		{
			"sigla": "GO",
			"nome": "Goías",
			"cidades": [
				"GO"
			]
		},
		{
			"sigla": "MA",
			"nome": "Maranhão",
			"cidades": [ 
				"MA"
			]
		},
		{
			"sigla": "MS",
			"nome": "Mato Grosso do sul",
			"cidades": [
			  "MS"
			]
		},
		{
			"sigla": "MT",
			"nome": "Mato Grosso",
			"cidades": [
			  "MT"
			]
		},
		{
			"sigla": "MG",
			"nome": "Minas gerais",
			"cidades": [
				"MG"
			]
		},
		{
			"sigla": "PA",
			"nome": "Pará",
			"cidades": [
				"PA"
			]
		},
		{
			"sigla": "PB",
			"nome": "Paraíba",
			"cidades": [
				"PB"
			]
		},
		{
			"sigla": "PR",
			"nome": "Paraná",
			"cidades": [
				"PR"
			]
		},	
		{
			"sigla": "PE",
			"nome": "Pernambuco",
			"cidades": [
				"PE"
			]
		},
		{
			"sigla": "PI",
			"nome": "Piauí",
			"cidades": [
			  "PI"
			]
			  
		},
		{
			"sigla": "RJ",
			"nome": "Rio de janeiro",
			"cidades": [
				"RJ"
			]
		},
		{
			"sigla": "RN",
			"nome": "Rio grande do norte",
			"cidades": [
				"RN"
			]
		},
		{
			"sigla": "RS",
			"nome": "Rio grande do sul",
			"cidades": [
				"RS"
			]
		},
		{
			"sigla": "RO",
			"nome": "Rondônia",
			"cidades": [
				"RO"
			]
		},
		{
			"sigla": "RR",
			"nome": "Roraima",
			"cidades": [
				"RR"
			]
		},
		{
			"sigla": "SC",
			"nome": "Santa catarina",
			"cidades": [
				"SC"
			]
		},
		{
			"sigla": "SP",
			"nome": "São paulo",
			"cidades": [
			   "SP"
			]
		},
		{
			"sigla": "SE",
			"nome": "Sergipe",
			"cidades": [
				"SE"
			]
		},
		{
			"sigla": "TO",
			"nome": "Tocantins",
			"cidades": [
				"TO"
			]
		},

	]
};





	function buscaCidades(e){
    document.querySelector("#uf").innerHTML = '';
    var cidade_select = document.querySelector("#uf");
    var num_estados = cidades.estados.length;
    var j_index = -1;

    // aqui eu pego o index do estado dentro de cidades
	for(var x=0; x < num_estados;x++){
        if(cidades.estados[x].sigla == e){
           j_index = x;
        }
     }

    if(j_index != -1){

        // aqui eu percorro todas as cidades e crio os options
        cidades.estados[j_index].cidades.forEach(function(uf){
			var cid_opts = document.createElement('option');
            cid_opts.setAttribute('value',uf)
            cid_opts.innerHTML = uf;
            cidade_select.appendChild(cid_opts);
        });
    }else{
        document.querySelector("#uf").innerHTML = '';
    }
}



///////////////////////// BUSCADOR DE CEP


function limpa_formulário_cep() {
	//Limpa valores do formulário de cep.
	document.getElementById('logradouro').value=("");
	document.getElementById('bairro').value=("");
	document.getElementById('cidade').value=("");
	//document.getElementById('estado').value=("");
 
}



function meu_callback(conteudo) {
if (!("erro" in conteudo)) {
	//Atualiza os campos com os valores.
	document.getElementById('logradouro').value=(conteudo.logradouro);
	document.getElementById('bairro').value=(conteudo.bairro);
	document.getElementById('cidade').value=(conteudo.localidade);
	//document.getElementById('estado').value=(conteudo.estado);
   
} //end if.
else {
	//CEP não Encontrado.
	limpa_formulário_cep();
	alert("CEP não encontrado.");
}
}


function pesquisacep(valor) {

//Nova variável "cep" somente com dígitos.
var cep = valor.replace(/\D/g, '');

//Verifica se campo cep possui valor informado.
if (cep != "") {

	//Expressão regular para validar o CEP.
	var validacep = /^[0-9]{8}$/;

	//Valida o formato do CEP.
	if(validacep.test(cep)) {

		//Preenche os campos com "..." enquanto consulta webservice.
		document.getElementById('logradouro').value="...";
		document.getElementById('bairro').value="...";
		document.getElementById('cidade').value="...";
		//document.getElementById('estado').value="...";
   

		//Cria um elemento javascript.
		var script = document.createElement('script');

		//Sincroniza com o callback.
		script.src = 'https://viacep.com.br/ws/'+ cep + '/json/?callback=meu_callback';

		//Insere script no documento e carrega o conteúdo.
		document.body.appendChild(script);

	} //end if.
	else {
		//cep é inválido.
		limpa_formulário_cep();
		alert("Formato de CEP inválido.");
	}
} //end if.
else {
	//cep sem valor, limpa formulário.
	limpa_formulário_cep();
}
};





