<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%
  if (session.getAttribute("user") == null)
  {
    String address =  "login.jsp";
    response.sendRedirect(address);
  }
%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Cadastrar Produtor</title>
        <link rel="icon" href="/agrotech/favicon.ico">
        <link href="css/styles.css" rel="stylesheet" />     
        <link href="css/dataTables.bootstrap4.min.css" rel="stylesheet" />
       
        

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script>
            $(document).ready(function() {
                $("#cadastrar").click(function() {
                    event.preventDefault();

                    var nome_digitado = $("#nomeUsuario").val();
                    var sobrenome_digitado = $("#sobrenomeUsuario").val();
                    var email_digitado = $("#emailUsuario").val();
                    var senha_digitado = $("#senha").val();
                    var confirmarSenha_digitado = $("#confirmaSenha").val();
                    var naturalizacaoDocumento_digitado = $("#naturalizacaoDocumento").val();
                    var orgaoDocumento_digitado = $("#orgaoDocumento").val();
                    var emissaoDocumento_digitado = $("#emissaoDocumento").val();
                    var numeroCpfCnpjUsuario_digitado = $("#numeroCpfCnpjUsuario").val();
                    var sexo_digitado = $("#sexo").val();
                    var nascimentoUsuario_digitado = $("#nascimentoUsuario").val();
                    var tipoUsuario_digitado = $("#tipoUsuario").val();
                    var nacionalidadeUsuario_digitado = $("#nacionalidadeUsuario").val();
                    var tipoTelefone1_digitado = $("#tipoTelefone1").val();
                    var telefone1_digitado = $("#telefone1").val();
                    var tipoTelefone2_digitado = $("#tipoTelefone2").val();
                    var telefone2_digitado = $("#telefone2").val();
                    var tipoTelefone3_digitado = $("#tipoTelefone3").val();
                    var telefone3_digitado = $("#telefone3").val();
                    var tipoTelefone4_digitado = $("#tipoTelefone4").val();
                    var telefone4_digitado = $("#telefone4").val();
                    var cep_digitado = $("#cep").val();
                    var tipoLogradouro_digitado = $("#tipoLogradouro").val();
                    var logradouro_digitado = $("#logradouro").val();
                    var numeroEndereco_digitado = $("#numeroEndereco").val();
                    var complemento_digitado = $("#complemento").val();
                    var bairro_digitado = $("#bairro").val();
                    var cidade_digitado = $("#cidade").val();
                    var estado_digitado = $("#estado").val();
                    var validarRgRne_anexo  = $("#validarRgRne").val();
                    var validarCpfCnpj_anexo = $("#validarCpfCnpj").val();
                    var validarComprovanteResi_anexo = $("#validarComprovanteRes").val();
                    

                    $.ajax(
                        {
                            url: "cadastrarProdutor?"+ 
                            "nomeUsuario="+nome_digitado+
                            "&sobrenomeUsuario="+sobrenome_digitado+ 
                            "&emailUsuario="+email_digitado+
                            "&senha="+senha_digitado+
                            "&confirmaSenha="+confirmarSenha_digitado+
                            "&naturalizacaoDocumento="+naturalizacaoDocumento_digitado+
                            "&orgaoDocumento="+orgaoDocumento_digitado+
                            "&emissaoDocumento="+emissaoDocumento_digitado+
                            "&numeroCpfCnpjUsuario="+numeroCpfCnpjUsuario_digitado+
                            "&sexo="+sexo_digitado+
                            "&nascimentoUsuario="+nascimentoUsuario_digitado+
                            "&tipoUsuario="+tipoUsuario_digitado+
                            "&nacionalidadeUsuario="+nacionalidadeUsuario_digitado+
                            "&tipoTelefone1="+tipoTelefone1_digitado+
                            "&telefone1="+telefone1_digitado+
                            "&tipoTelefone2="+tipoTelefone2_digitado+
                            "&telefone2="+telefone2_digitado+
                            "&tipoTelefone3="+tipoTelefone3_digitado+
                            "&telefone3="+telefone3_digitado+
                            "&tipoTelefone4="+tipoTelefone4_digitado+
                            "&telefone4="+telefone4_digitado+
                            "&cep="+cep_digitado+
                            "&tipoLogradouro="+tipoLogradouro_digitado+
                            "&logradouro="+logradouro_digitado+
                            "&numeroEndereco="+numeroEndereco_digitado+
                            "&complemento="+complemento_digitado+
                            "&bairro="+bairro_digitado+
                            "&cidade="+cidade_digitado+
                            "&estado="+estado_digitado+
                            "&validarRgRne=" +validarRgRne_anexo+
                            "&validarCpfCnpj="+validarCpfCnpj_anexo+
                            "&validarComprovanteRes="+validarComprovanteResi_anexo,
                            contentType: "charset=UTF-8",
                            success: function(retorno) {
                                if (retorno.trim()=="ok") {
                                    location.replace("mensagem_cadastrar.jsp");  //sucesso
                                    } 
                                    else {
                                        //erro
                                        $ ("#mostrarErro").html (retorno);
                                        $('#myModal').modal('show'); 
                                    
                                }
                            }
                        }
                    );
                });
               
            });
        </script>
    </head>
    <body>
        
       <!-- Começo do menu da esquerda -->
        <%@include file="menu.jsp" %>
            <!-- Fim do menu da esquerda -->
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">Cadastrar Produtor</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="dashboard.jsp">Dashboard</a></li>
                            <li class="breadcrumb-item active">Cadastrar Produtor</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                
                                <!-- COMEÇO DO FORM -->

                                <form action="#" method="#">
                                    <div class="col-md-3">    </div>
                                    <div class="form-row"><div class="col-md-3"></div><h5 class="font-weight-light my-4">Dados do Produtor</h5></div>
                                    <div class="form-row">
                                        
                                        <div class="col-md-3">    </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1" for="nomeUsuario">Nome</label>
                                                <input class="form-control py-3" id="nomeUsuario" name="nomeUsuario" type="text" placeholder="Digite seu nome" value=""/>
                                            </div>
                                        </div>
                                        
                                        

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1" for="sobrenomeUsuario">Sobrenome</label>
                                                <input class="form-control py-3" id="sobrenomeUsuario" name="sobrenomeUsuario" type="text" placeholder="Digite seu sobrenome" value=""/>
                                            </div>
                                        </div>
                                    
                                        
                                    
                                         <div class="col-md-3">    </div>

                                    </div>
                                
                                    <div class="form-row">    
                                        <div class="col-md-3">    </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label class="small mb-1" for="emailUsuario">Email</label>
                                                <input class="form-control py-3" id="emailUsuario" name="emailUsuario" type="email" placeholder="Digite seu email" value=""/>
                                            </div>   
                                        </div>

  
                                         <div class="col-md-3">    </div>
                                    </div>


                                       <div class="form-row">
                                        <div class="col-md-3"></div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1" for="senha">Senha</label>
                                                <input class="form-control py-3" id="senha" name="senha" type="password" placeholder="Digite sua senha" value=""/>
                                            </div>
                                        </div>

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1" for="confirmaSenha">Confirme sua Senha</label>
                                                <input class="form-control py-3" id="confirmaSenha" name="confirmaSenha" type="password" placeholder="Repita sua senha" value=""/>
                                            </div>
                                        </div>
                                                
                                       

                                    </div>
                                       
                                    <div class="form-row">
                                        <div class="col-md-3"></div> <span id='result'></span>
                                        
                                    </div>
                                    
                                    <div class="form-row">
                                        <div class="col-md-3"></div>  <span id='message'></span>
                                        
                                    </div>   

                                    <div class="form-row"><div class="col-md-3"></div><h5 class="font-weight-light my-4">Dados Pessoais</h5></div>

                                    <div class="form-row">  
                                        <div class="col-md-3"></div> 
                                      

                                        
                                        <div class="col-md-3"></div> 
                                    </div>


                                    <div class="form-row">    
                                        <div class="col-md-3">    </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="naturalizacaoDocumento" >RG/RNE</label>
                                                <input class="form-control py-3 " id="naturalizacaoDocumento" name="naturalizacaoDocumento" type="text" value="" placeholder="Digite seu documento"/>
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="orgaoDocumento">Órgão Expedidor</label>
                                                <input class="form-control py-3" id="orgaoDocumento" name="orgaoDocumento" type="text" placeholder="Digite o órgão" value="" />
                                            </div>
                                        </div>
                                        

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="emissaoDocumento">Data de Emissão</label>
                                                <input class="form-control py-3" id="emissaoDocumento" name="emissaoDocumento" type="text" placeholder="dd/mm/aaaa" value="" />
                                            </div>
                                        </div>
                                    </div>
                                        



                                    <div class="form-row"> 
                                        <div class="col-md-3">    </div>   
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="numeroCpfCnpjUsuario" >CPF/CNPJ</label>
                                                <input class="form-control py-3 " id="numeroCpfCnpjUsuario" name="numeroCpfCnpjUsuario" type="text" value="" placeholder="Digite seu documento"/>
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group" Style="height: 38px;">                                            
                                                <label class="small mb-1" for="sexo" >Sexo</label>
                                                <select id="sexo" name="sexo" class="form-control">
                                                    <option value="">Selecione o sexo</option>
                                                    <option value="masculino">Masculino</option>
                                                    <option value="feminino">Feminino</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="nascimentoUsuario" onkeypress="return apenasNumeros(event);">Data de Nascimento</label>
                                                <input class="form-control py-3" id="nascimentoUsuario" name="nascimentoUsuario" type="text" placeholder="dd/mm/aaaa" onblur="Is18()" value="" />
                                            </div>
                                        </div> 
                                    </div>


                                    
                                    <div class="form-row">    
                                        <div class="col-md-3"></div>
                                        <div class="col-md-3">
                                            <div class="form-group">                                            
                                                <label class="small mb-1" for="nacionalidadeUsuario" >País</label>
                                                <select id="nacionalidadeUsuario" name="nacionalidadeUsuario" class="form-control">
                                                    <option value="">Selecione o país</option>
                                                    <option value="1">Afeganistão</option>
                                                    <option value="2">Albânia</option>
                                                    <option value="3">Argélia</option>
                                                    <option value="4">Andorra</option>
                                                    <option value="5">Angola</option>
                                                    <option value="6">Antígua e Barbuda</option>
                                                    <option value="7">Argentina</option>
                                                    <option value="8">Armênia</option>
                                                    <option value="9">Aruba</option>
                                                    <option value="10">Austrália</option>
                                                    <option value="11">Áustria</option>
                                                    <option value="12">Azerbaijão</option>
                                                    <option value="13">Bahamas</option>
                                                    <option value="14">Bangladesh</option>
                                                    <option value="15">Barbados</option>
                                                    <option value="16">Burundi</option>
                                                    <option value="17">Bélgica</option>
                                                    <option value="18">Benim</option>
                                                    <option value="19">Bermudas</option>
                                                    <option value="20">Butão</option>
                                                    <option value="21">Bósnia e Herzegovina</option>
                                                    <option value="22">Belize</option>
                                                    <option value="23">Bielorussia</option>
                                                    <option value="24">Bolívia</option>
                                                    <option value="25">Botswana</option>
                                                    <option value="26">Brasil</option>
                                                    <option value="27">Bahrein</option>
                                                    <option value="28">Brunei</option>
                                                    <option value="29">Bulgária</option>
                                                    <option value="30">Burkina Faso</option>
                                                    <option value="31">República Centro-Africana</option>
                                                    <option value="32">Camboja</option>
                                                    <option value="33">Canadá</option>
                                                    <option value="34">Ilhas Cayman</option>
                                                    <option value="35">República do Congo</option>
                                                    <option value="36">Chade</option>
                                                    <option value="37">Chile</option>
                                                    <option value="38">China</option>
                                                    <option value="39">Costa do Marfim</option>
                                                    <option value="40">Camarões</option>
                                                    <option value="41">República Democrática do Congo</option>
                                                    <option value="42">Ilhas Cook</option>
                                                    <option value="43">Colômbia</option>
                                                    <option value="44">Comores</option>
                                                    <option value="45">Cabo Verde </option>
                                                    <option value="46">Costa Rica</option>
                                                    <option value="47">Croácia</option>
                                                    <option value="48">Cuba</option>
                                                    <option value="49">Chipre</option>
                                                    <option value="50">Chéquia</option>
                                                    <option value="51">Dinamarca</option>
                                                    <option value="52">Djibouti</option>
                                                    <option value="53">Dominica</option>
                                                    <option value="54">República Dominicana</option>
                                                    <option value="55">Equador</option>
                                                    <option value="56">Egito</option>
                                                    <option value="57">Eritreia</option>
                                                    <option value="58">El Salvador</option>
                                                    <option value="59">Espanha</option>
                                                    <option value="60">Estónia</option>
                                                    <option value="61">Etiópia</option>
                                                    <option value="62">Fiji</option>
                                                    <option value="63">Finlândia</option>
                                                    <option value="64">França</option>
                                                    <option value="65">Estados Federados da Micronésia</option>
                                                    <option value="66">Gabão</option>
                                                    <option value="67">Gâmbia</option>
                                                    <option value="68">Reino Unido</option>
                                                    <option value="69">Inglaterra</option>
                                                    <option value="70">Irlanda do Norte</option>
                                                    <option value="71">Escócia</option>
                                                    <option value="72">Países de Gales</option>
                                                    <option value="73">Guiné-Bissau</option>
                                                    <option value="74">Geórgia</option>
                                                    <option value="75">Guiné Equatorial</option>
                                                    <option value="76">Alemanha</option>
                                                    <option value="77">Gana</option>
                                                    <option value="78">Grécia</option>
                                                    <option value="79">Granada</option>
                                                    <option value="80">Guatemala</option>
                                                    <option value="81">Guiné</option>
                                                    <option value="82">Guam</option>
                                                    <option value="83">Guiana</option>
                                                    <option value="84">Haiti</option>
                                                    <option value="85">Hong Kong</option>
                                                    <option value="86">Honduras</option>
                                                    <option value="87">Hungria</option>
                                                    <option value="88">Indonésia</option>
                                                    <option value="89">Índia</option>
                                                    <option value="90">Irão</option>
                                                    <option value="91">Irlanda</option>
                                                    <option value="92">Iraque</option>
                                                    <option value="93">Islândia</option>
                                                    <option value="94">Israel</option>
                                                    <option value="95">Ilhas Virgens Americanas</option>
                                                    <option value="96">Itália</option>
                                                    <option value="97">Ilhas Virgens Britânicas</option>
                                                    <option value="98">Jamaica</option>
                                                    <option value="99">Jordânia</option>
                                                    <option value="100">Japão</option>
                                                    <option value="101">Cazaquistão</option>
                                                    <option value="102">Quênia</option>
                                                    <option value="103">Quirguistão</option>
                                                    <option value="104">Kiribati</option>
                                                    <option value="105">Coreia do Sul</option>
                                                    <option value="106">Kosovo</option>
                                                    <option value="107">Arábia Saudita</option>
                                                    <option value="108">Kuwait</option>
                                                    <option value="109">Laos</option>
                                                    <option value="110">Nova Zelândia</option>
                                                    <option value="111">Omã</option>
                                                    <option value="112">Paquistão</option>
                                                    <option value="113">Panamá</option>
                                                    <option value="114">Paraguai</option>
                                                    <option value="115">Peru</option>
                                                    <option value="116">Filipinas</option>
                                                    <option value="117">Palestina</option>
                                                    <option value="118">Palau</option>
                                                    <option value="119">Papua-Nova Guiné</option>
                                                    <option value="120">Polónia</option>
                                                    <option value="121">Portugal</option>
                                                    <option value="122">Coreia do Norte</option>
                                                    <option value="123">Porto Rico</option>
                                                    <option value="124">Catar</option>
                                                    <option value="125">Roménia</option>
                                                    <option value="126">África do Sul</option>
                                                    <option value="127">Sudão</option>
                                                    <option value="128">Suíça</option>
                                                    <option value="129">Suriname</option>
                                                    <option value="130">Eslováquia</option>
                                                    <option value="131">Suécia</option>
                                                    <option value="132">Essuatíni</option>
                                                    <option value="133">Síria</option>
                                                    <option value="134">Tanzânia</option>
                                                    <option value="135">Tonga</option>
                                                    <option value="136">Tailândia</option>
                                                    <option value="137">Tajiquistão</option>
                                                    <option value="138">Uruguai</option>
                                                    <option value="139">Estados Unidos</option>
                                                    <option value="140">Venezuela</option>
                                                    </select>
                                            </div>
                                        </div> 
                                        <div class="col-md-3" >
                                            <div class="form-group">                                            
                                                <label class="small mb-1" for="tipoUsuario" >Tipo de Usuário</label>
                                                <select id="tipoUsuario" name="tipoUsuario" class="form-control">
                                                    <option value="">Selecione o tipo de usuário</option>
                                                    <option value="1">Administrador</option>
                                                    <option value="2">Agente</option>
                                                    <option value="3">Operador</option>
                                                    <option value="4">Proprietário</option>
                                                    <option value="5">Produtor</option>
                                                </select>
                                            </div>
                                        </div>
                                       

                                    </div>




                                    <div class="form-row"><div class="col-md-3"></div><h5 class="font-weight-light my-4">Contatos</h5></div>

                                    <div class="form-row">

                                        <div class="col-md-3">    </div>

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-2 " for="tipoTelefone1">Tipo de Telefone</label>
                                                <select id="tipoTelefone1" name="tipoTelefone1" class="form-control" onchange="telefoneMask1()">
                                                    <option value="">Selecione o tipo de telefone</option>
                                                    <option value="1">Residencial</option>
                                                    <option value="2">Celular</option>
                                                    <option value="3">Comercial</option>
                                                    <option value="4">Recado</option>
                                                   

                                                </select>
                                            </div>
                                        </div>

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1.1" for="telefone1">Telefone</label>
                                                <input class="telefone1 form-control py-3" id="telefone1" name="telefone1" type="text" placeholder="Telefone" value=""/>
                                            </div>
                                        </div>


                                    </div>
                                       
                                    <div class="form-row">

                                        <div class="col-md-3">    </div>

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-2 " for="tipoTelefone2">Tipo de Telefone</label>
                                                <select id="tipoTelefone2" name="tipoTelefone2" class="form-control" onchange="telefoneMask2()">
                                                    <option value="">Selecione o tipo de telefone</option>
                                                    <option value="1">Residencial</option>
                                                    <option value="2">Celular</option>
                                                    <option value="3">Comercial</option>
                                                    <option value="4">Recado</option>
                                                   

                                                </select>
                                            </div>
                                        </div>

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1.1" for="telefone2">Telefone</label>
                                                <input class="telefone2 form-control py-3" id="telefone2" name="telefone2" type="text" placeholder="Telefone" value=""/>
                                            </div>
                                        </div>


                                    </div>
                                    
                                    <div class="form-row">

                                        <div class="col-md-3">    </div>

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-2 " for="tipoTelefone3">Tipo de Telefone</label>
                                                <select id="tipoTelefone3" name="tipoTelefone3" class="form-control" onchange="telefoneMask3()">
                                                    <option value="">Selecione o tipo de telefone</option>
                                                    <option value="1">Residencial</option>
                                                    <option value="2">Celular</option>
                                                    <option value="3">Comercial</option>
                                                    <option value="4">Recado</option>
                                                   

                                                </select>
                                            </div>
                                        </div>

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1.1" for="telefone3">Telefone</label>
                                                <input class="telefone3 form-control py-3" id="telefone3" name="telefone3" type="text" placeholder="Telefone" value=""/>
                                            </div>
                                        </div>


                                    </div>

                                    <div class="form-row">

                                        <div class="col-md-3">    </div>

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-2 " for="tipoTelefone4">Tipo de Telefone</label>
                                                <select id="tipoTelefone4" name="tipoTelefone4" class="form-control" onchange="telefoneMask4()">
                                                    <option value="">Selecione o tipo de telefone</option>
                                                    <option value="1">Residencial</option>
                                                    <option value="2">Celular</option>
                                                    <option value="3">Comercial</option>
                                                    <option value="4">Recado</option>
                                                   

                                                </select>
                                            </div>
                                        </div>

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1.1" for="telefone4">Telefone</label>
                                                <input class="telefone4 form-control py-3" id="telefone4" name="telefone4" type="text" placeholder="Telefone" value=""/>
                                            </div>
                                        </div>


                                    </div>
                                

                                    <div class="form-row">
                                        <div class="col-md-3">    </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="cep">CEP<i class="fas fa-search" style="margin-left: 10px;"  onclick="pesquisacep(cep.value);"></i></label>
                                                <input class="form-control py-3" id="cep" name="cep" type="text" onblur="pesquisacep(this.value);" value="" placeholder="Digite o CEP"/>
                                            </div>
                                        </div>

                                        <div class="col-md-2" hidden>
                                            <div class="form-group">
                                                <label class="small mb-1" for="tipoLogradouro">Tipo de Logradouro</label>
                                                <input class="form-control py-3" id="tipoLogradouro" name="tipoLogradouro" type="text" placeholder="Tipo de logradouro" value=""/>
                                            </div>
                                        </div>

                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label class="small mb-1" for="logradouro">Logradouro</label>
                                                <input class="form-control py-3" id="logradouro" name="logradouro" type="text" placeholder="Nome logradouro" value=""/>
                                            </div>
                                        </div>
                                                    
                                    </div>

                                    <div class="form-row">
                                        

                                        <div class="col-md-3">    </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="numeroEndereco">Número</label>
                                                <input class="form-control py-3" id="numeroEndereco" name="numeroEndereco" type="text" placeholder="Nº do local" value=""/>
                                            </div>
                                        </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="complemento">Complemento</label>
                                                <input class="form-control py-3" id="complemento" name="complemento" type="text" placeholder="Complemento" value=""/>
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="bairro">Bairro</label>
                                                <input class="form-control py-3" id="bairro" name="bairro" type="text" placeholder="Bairro" value=""/>
                                            </div>
                                        </div>

                                         
                                    </div>
                                    <div class="form-row">    
                                        <div class="col-md-3">    </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1" for="cidade" >Cidade</label>
                                                <input class="form-control py-3" id="cidade" name="cidade" type="text" placeholder="Cidade" onkeypress="return apenasLetras(event);" value=""/>
                                            </div>
                                        </div>
                                    

                                        <div class="col-md-3">
                                            <label class="small mb-1" for="estado">Estado</label>
                                            <select id="estado" name="estado" class="form-control">
                                                <option value="">Selecione o estado</option>
                                                <option value="1">Acre</option>
                                                <option value="2">Alagoas</option>
                                                <option value="3">Amapá</option>
                                                <option value="4">Amazonas</option>
                                                <option value="5">Bahia</option>
                                                <option value="6">Ceará</option>
                                                <option value="7">Distrito Federal</option>
                                                <option value="8">Espírito Santo</option>
                                                <option value="9">Goiás</option>
                                                <option value="10">Maranhão</option>
                                                <option value="11">Mato Grosso</option>
                                                <option value="12">Mato Grosso do Sul</option>
                                                <option value="13">Minas Gerais</option>
                                                <option value="14">Pará</option>
                                                <option value="15">Paraíba</option>
                                                <option value="16">Paraná</option>
                                                <option value="17">Pernambuco</option>
                                                <option value="18">Piauí</option>
                                                <option value="19">Rio de Janeiro</option>
                                                <option value="20">Rio Grande do Norte</option>
                                                <option value="21">Rio Grande do Sul</option>
                                                <option value="22">Rondônia</option>
                                                <option value="23">Roraima</option>
                                                <option value="24">Santa Catarina</option>
                                                <option value="25">São Paulo</option>
                                                <option value="26">Sergipe</option>
                                                <option value="27">Tocantins</option>

                                            </select>
                                        </div>

                                        

                                    </div>

                                    
                                                                                                    
                                    <h6 class="text-justify lead text-center mb-0" style="font-size: 13px; font-weight: bolder;"><br>INSIRA FOTO/PDF DOS SEGUINTES DOCUMENTOS:</h6>    

                                    <h6 class="text-justify lead text-center" style="font-size: 10px; font-weight: bolder;"><br>REPITA O DOCUMENTO CASO NECESSÁRIO
                                        <span data-toggle="tooltip" data-placement="right" title="Mesmo que um documento esteja inserido dentro de outro, como o CPF no RG, é necessário uma foto para cada documento">[&#63;]</span>                                
                                        <br><br></h6>


                                        <div class="form-row">
                                            <div class="col-md-2"></div>

                                            <div class="form-group col-md-2 offset-md-1">
                                              <label for="validarRgRne">RG/RNE</label>
                                              <input type="file" class="validarRgRne" id="validarRgRne">
                                            </div>
                                    </div>                                  
                                          
                                    <div class="form-row">
                                        <div class="col-md-2"></div>

                                            <div class="form-group col-md-2 offset-md-1">
                                              <label for="validarCpfCnpj">CPF/CNPJ</label>
                                              <input type="file" class="validarCpfCnpj" id="validarCpfCnpj">
                                            </div>
                                    </div> 

                                        

                                    <div class="form-row">
                                        <div class="col-md-2"></div>

                                            <div class="form-group col-md-4 offset-md-1">
                                              <label for="validarComprovanteRes">COMPROVANTE DE RESIDÊNCIA</label>
                                              <input type="file" class="form-control-file" id="validarComprovanteRes" name="validarComprovanteRes">
                                            </div>
                                    </div>
                                          

                                        
  
                                                                      
                                        <div class="col-md-1," style="display : flex; justify-content : center; align-items : center; flex-direction : initial;">
                                            
                                            <div class="form-group mt-4 mb-0"><button id="cadastrar" class="btn btn-success btn-block" >Cadastrar</button></div>
                                    
                                    </div>
                                
                                
                                </form>

                                    <div id="myModal" class="modal fade" tabindex="-1" role="dialog">
                                      <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                          <div class="modal-header">
                                            <h5 class="modal-title">Atenção!</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                              <span aria-hidden="true">&times;</span>
                                            </button>
                                          </div>
                                            <div class="modal-body py-5">    
                                              <h6 class="text-danger text-center"> 
                                                  <div class="" id="mostrarErro"></div>
                                              </h6>
                                            </div>
                                          <div class="modal-footer">
                                            <button type="button" class="btn btn-dark" data-dismiss="modal">Fechar</button>
                                          </div>
                                        </div>
                                      </div>
                                    </div> 
                               
                            </div>
                            </main>
                            <footer class="py-4 bg-success mt-auto ">
                                <div class="container-fluid ">
                                    <div class="d-flex align-items-right justify-content-between small">
                                        <div class="text-light">2020 Agrotech Sistema de Unificação de Dados do Agronegócio.</div>
                                    </div>
                                </div>
                            </footer>
                    </div>
                </div>

                <script src="js/jquery-3.4.1.min.js"></script>
                <script src="js/all.min.js"></script>
                <script src="js/scripts.js"></script>
                <script src="js/resilia.js"></script>
                <script src="assets/demo/datatables-demo.js"></script>
                <script src="js/jquery.mask.min.js"></script>
                <script src="js/bootstrap.bundle.min.js"></script>
                <script src="js/dataTables.bootstrap4.min.js"></script>
                <script src="js/validaDados.js"></script>



                
            </body>
        </html>