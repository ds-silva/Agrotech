
// data de nascimento

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




function getIdade(data) {
  var hoje = new Date();
 
   var nascimento = new Date(convertDateMMDDYYY(data.split("/")));

   //Retorna a diferença entre hoje e a data de nascimento em anos.
   var ano = hoje.getFullYear() - nascimento.getFullYear();

   //Retorna a diferença de mês do mês de nascimento para o atual.
   var m = hoje.getMonth() - nascimento.getMonth();

   //Caso ainda não tenha ultrapassado o dia e o mês
   if (m < 0 || (m === 0 && hoje.getDate() < nascimento.getDate())) {
       ano--;
   }
   return ano;
}

function convertDateMMDDYYY(datearray) {
 return datearray[1] + '-' + datearray[0] + '-' + datearray[2];
}

function Is18() 
{
 var data = document.getElementById("nascimentoUsuario");
  
 if(getIdade(data.value) >= 18)
    return
 else
    alert('Você precisa ser maior de 18 anos para se cadastrar no sistema!')
    document.querySelector('#nascimentoUsuario').value = ''
}


// Número de matricula 

function maxLenght(){
  var matr = document.querySelector('#matriculaUsuario').value

  if(matr.length <= 6){
    document.querySelector('#matriculaUsuario').value = ''
    alert('A matricula necessita de 7 números')
    return
  }
}