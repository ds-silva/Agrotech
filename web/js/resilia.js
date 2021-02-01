  //FUNÇÃO PRA SÓ ESCREVER LETRAS EM UM INPUT
  
  function apenasLetras(e) {
    try {
        if (window.event) {
            var charCode = window.event.keyCode;
        } else if (e) {
            var charCode = e.which;
        } else {
            return true;
        }
        if (
            (charCode > 31 && charCode < 33) || // espaço
            (charCode > 64 && charCode < 91) || // letras maiúsculas
            (charCode > 96 && charCode < 123) || // letras minúsculas
            (charCode > 191 && charCode <= 255) // letras com acentos
        ){
            return true;
        } else {
            return false;
        }
    } catch (err) {
        console.error(err.Description);
    }
}

////FUNÇÃO PRA SÓ ESCREVER NUMEROS EM UM INPUT
 function apenasNumeros(e) {
    try {
        if (window.event) {
            var charCode = window.event.keyCode;
        } else if (e) {
            var charCode = e.which;
        } else {
            return true;
        }
        if (
            (charCode > 45 && charCode < 47) || // ponto
            (charCode > 47 && charCode < 58) || // numeros de 0 a 9
            (charCode > 31 && charCode <33) //espaço
        ){
            return true;
        } else {
            return false;
        }
    } catch (erro) {
        console.log(erro.Description);
    }
}

//Jqery mascara para Matricula
$(document).ready(function(){
	$('#matriculaUsuario').mask('0000000');
  });

// Jquery ano
$(document).ready(function(){
	$('#ano').mask('0000');
  });

// mascara de data1

$("#nascimentoUsuario").keydown(function(){
	try {
		$("#nascimentoUsuario").unmask();
	} catch (e) {}

	var tamanho = $("#nascimentoUsuario").val().length;

	if(tamanho < 8){
		$("#nascimentoUsuario").mask("99/99/9999");
	} else {
		$("#nascimentoUsuario").mask("99/99/9999");
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


// mascara de data2

$("#emissaoDocumento").keydown(function(){
	try {
		$("#emissaoDocumento").unmask();
	} catch (e) {}

	var tamanho = $("#emissaoDocumento").val().length;

	if(tamanho < 8){
		$("#emissaoDocumento").mask("99/99/9999");
	} else {
		$("#emissaoDocumento").mask("99/99/9999");
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



$(document).ready(function() {
    
    $('#senha').keyup(function(){ 
        $('#result').html(checkStrength($('#senha').val()))
    }) 
    
    function checkStrength(password){ 
        //initial strength 
        var strength = 0 
        
        //if the password length is less than 6, return message. 
        if (password.length < 8) { 
            $('#result').removeClass() 
            $('#result').addClass('short') 
            return 'A senha deverá ter no mínimo 8 caracteres, com pelo menos uma letra maiúscula, um número e um caracter especial.' } 
            
      //length is ok, lets continue. 
      
      //if length is 8 characters or more, increase strength value 
      if (password.length > 7) strength += 1 
      
      //if password contains both lower and uppercase characters, increase strength value 
      if (password.match(/([a-z].*[A-Z])|([A-Z].*[a-z])/)) strength += 1 

      //if it has numbers and characters, increase strength value 
      if (password.match(/([a-zA-Z])/) && password.match(/([0-9])/)) strength += 1 

      //if it has one special character, increase strength value 
      if (password.match(/([!,%,&,@,#,$,^,*,?,_,~])/)) strength += 1 

       

      //now we have calculated strength value, we can return messages 
      
      
      //if value is less than 2 
      if (strength < 4 ) {
          $('#result').removeClass() 
          $('#result').addClass('weak') 
          return 'Senha muito fraca' 
        } else if (strength == 4 ) { 
            $('#result').removeClass() 
            $('#result').addClass('good') 
            return 'Válida' 
        } else { 
            $('#result').removeClass() 
            $('#result').addClass('strong') 
            return 'Senha Forte' } } });



           /**


            function validarSenha() {
                var senha1 = document.getElementById("senha");
                var senha2 = document.getElementById("confirmaSenha");
                var s1 = senha1.value;
                var s2 = senha2.value;
                var resultado = document.querySelector('#message')
                  if (s1 == s2) {
                    resultado.innerHTML = "// As senhas coincidem"
                    resultado.style.color = 'green'
                }   else {
                    resultado.innerHTML = "// As senhas não coincidem."
                    resultado.style.color = 'red'
              }
            }
 */

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


function limpa_formulario_cep() {
	//Limpa valores do formulario de cep.
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
	limpa_formulario_cep();
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
		limpa_formulario_cep();
		alert("Formato de CEP inválido.");
	}
} //end if.
else {
	//cep sem valor, limpa formulario.
	limpa_formulario_cep();
}
};

// IMPRIMIR tabela //

function printData()
{
   var divToPrint=document.getElementById("dataTable");
   newWin= window.open("");
   newWin.document.write(divToPrint.outerHTML);
   newWin.print();
   newWin.close();
}

/*  SCRIPT DE REGIONAIS  // 
  
	function changeSelect2(){
  
		let select = document.getElementById('orgaoFuncional');
		let selectSetor = document.getElementById('regional');
	  
		let value = select.options[select.selectedIndex].value;
	  
		//remove itens from select
		let length = selectSetor.options.length;        
		let i;
		for(i = selectSetor.options.length-1 ; i>=0 ; i--)
		{
			selectSetor.remove(i);
		}
	  
		if (value == ''){
		  let optionDefault = document.createElement('option');
		  optionDefault.value = 'Default';
		  optionDefault.text = 'Selecione a regional';
	  
		  selectSetor.add(optionDefault);
		}
	  
	   else if(value == '1') {
	  
			let option = document.createElement('option');
			option.value = '0';
			option.text = 'Selecione a regional';
	  
			let option1 = document.createElement('option');
			option1.value = '1';
			option1.text = 'SRO 07 - Rio Grande do Sul';
	  
			let option2 = document.createElement('option');
			option2.value = '2';
			option2.text = 'SR 07 - Rio de Janeiro';

			let option3 = document.createElement('option');
			option3.value = '2';
			option3.text = 'SR 28 - Brasilia';

			let option4 = document.createElement('option');
			option4.value = '2';
			option4.text = 'SR 08 - São Paulo';

			let option5 = document.createElement('option');
			option5.value = '2';
			option5.text = 'SR 06 - Minas Gerais';
	  
			selectSetor.add(option);
			selectSetor.add(option1);
			selectSetor.add(option2);
			selectSetor.add(option3);
			selectSetor.add(option4);
			selectSetor.add(option5);
	  
		} else if (value == '2'){
	  
		  let option = document.createElement('option');
		  option.value = '1';
		  option.text = 'Selecione a regional';
		  
		  let option2 = document.createElement('option');
		  option2.value = '2';
		  option2.text = 'S1';
	  
		  let option3 = document.createElement('option');
		  option3.value = '3';
		  option3.text = 'S2';
		  
		  let option4 = document.createElement('option');
		  option4.value = '4';
		  option4.text = 'S3';
	  
		  selectSetor.add(option);
		  selectSetor.add(option2);
		  selectSetor.add(option3);
		  selectSetor.add(option4);
	  
		}   else if (value == '3'){
	  
		  let option = document.createElement('option');
		  option.value = '1';
		  option.text = 'Selecione a regional';
		  
		  let option2 = document.createElement('option');
		  option2.value = '2';
		  option2.text = 'S1';
	  
		  let option3 = document.createElement('option');
		  option3.value = '3';
		  option3.text = 'S2';
		  
		  let option4 = document.createElement('option');
		  option4.value = '4';
		  option4.text = 'S3';
	  
		  selectSetor.add(option);
		  selectSetor.add(option2);
		  selectSetor.add(option3);
		  selectSetor.add(option4);
	  
		} else if (value == '4'){
	  
		  let option = document.createElement('option');
		  option.value = '1';
		  option.text = 'Selecione a regional';
		  
		  let option2 = document.createElement('option');
		  option2.value = '2';
		  option2.text = 'S1';
	  
		  let option3 = document.createElement('option');
		  option3.value = '3';
		  option3.text = 'S2';
		  
		  let option4 = document.createElement('option');
		  option4.value = '4';
		  option4.text = 'S3';
	  
		  selectSetor.add(option);
		  selectSetor.add(option2);
		  selectSetor.add(option3);
		  selectSetor.add(option4);
	  
		} else if (value == '5'){
	  
		  let option = document.createElement('option');
		  option.value = '1';
		  option.text = 'Selecione a regional';
		  
		  let option2 = document.createElement('option');
		  option2.value = '2';
		  option2.text = 'S1';
	  
		  let option3 = document.createElement('option');
		  option3.value = '3';
		  option3.text = 'S2';
		  
		  let option4 = document.createElement('option');
		  option4.value = '4';
		  option4.text = 'S3';
	  
		  selectSetor.add(option);
		  selectSetor.add(option2);
		  selectSetor.add(option3);
		  selectSetor.add(option4);
	  
		}  else if (value == '6'){
	  
		  let option = document.createElement('option');
		  option.value = '1';
		  option.text = 'Selecione a regional';
		  
		  let option2 = document.createElement('option');
		  option2.value = '2';
		  option2.text = 'S1';
	  
		  let option3 = document.createElement('option');
		  option3.value = '3';
		  option3.text = 'S2';
		  
		  let option4 = document.createElement('option');
		  option4.value = '4';
		  option4.text = 'S3';
	  
		  selectSetor.add(option);
		  selectSetor.add(option2);
		  selectSetor.add(option3);
		  selectSetor.add(option4);
	  
		}  
	  }

// SCRIPT DE TELAS DE PRODUTOS //

function changeSelect(){
  
	let select = document.getElementById('tipoProduto');
	let selectSetor = document.getElementById('nomeProduto');
  
	let value = select.options[select.selectedIndex].value;
  
	//remove itens from select
	let length = selectSetor.options.length;        
	let i;
	for(i = selectSetor.options.length-1 ; i>=0 ; i--)
	{
		selectSetor.remove(i);
	}
  
	if (value == ''){
	  let optionDefault = document.createElement('option');
	  optionDefault.value = 'Default';
	  optionDefault.text = 'Selecione o produto';
  
	  selectSetor.add(optionDefault);
	}
  
   else if(value == '1') {
  
		let option = document.createElement('option');
		option.value = '';
		option.text = 'Selecione o produto';

		let option2 = document.createElement('option');
		option2.value = '1';
		option2.text = 'Soja';
  
		let option3 = document.createElement('option');
		option3.value = '2';
		option3.text = 'Feijao';
		
  
		selectSetor.add(option);
		selectSetor.add(option2);
		selectSetor.add(option3);
  
	} else if (value == '2'){

	  let option = document.createElement('option');
	  option.value = '';
	  option.text = 'Selecione o produto';	
  
	  let option2 = document.createElement('option');
	  option2.value = '4';
	  option2.text = 'Gado';
  
	  let option3 = document.createElement('option');
	  option3.value = '5';
	  option3.text = 'Porco';
	  
	  let option4 = document.createElement('option');
	  option4.value = '6';
	  option4.text = 'Cavalo';
  
	  selectSetor.add(option);
	  selectSetor.add(option2);
	  selectSetor.add(option3);
	  selectSetor.add(option4);
  
	}   
  }
  
*/

