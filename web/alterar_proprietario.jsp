<%@page import="model.Telefone"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Proprietario"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%
    if (session.getAttribute("user") == null) {
        String address = "login.jsp";
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
        <title>Alterar Proprietário</title>
        <link rel="icon" href="/agrotech/favicon.ico">
        <link href="css/styles.css" rel="stylesheet" />
        <link href="css/dataTables.bootstrap4.min.css" rel="stylesheet" />


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

        <script>
            $(document).ready(function () {
                $("#salvarAlteracoes").click(function () {
                    event.preventDefault();
                    var _idProprietario = $("#idProprietario").val();
                    var nome_usuario = $("#nomeUsuario").val();
                    var sobre_nome_usuario = $("#sobrenomeUsuario").val();
                    var email_usuario = $("#emailUsuario").val();
                    var situacao_usuario = $("#situacaoUsuario").val();
                    var senha = $("#senha").val();
                    var confirma_senha = $("#confirmaSenha").val();
                    var naturalizacao_documento = $("#naturalizacaoDocumento").val();
                    var orgao_documento = $("#orgaoDocumento").val();
                    var emissao_documento = $("#emissaoDocumento").val();
                    var numero_cpf_cnpj_usuario = $("#numeroCpfCnpjUsuario").val();
                    var sexo = $("#sexo").val();
                    var nascimento_usuario = $("#nascimentoUsuario").val();
                    var nacionalidade_usuario = $("#nacionalidadeUsuario").val();
                    var tipo_usuario = $("#tipoUsuario").val();
                    var tipo_telefone1 = $("#tipoTelefone1").val();
                    var telefone1 = $("#telefone1").val();
                    var tipoTelefone2 = $("#tipoTelefone2").val();
                    var telefone2 = $("#telefone2").val();
                    var tipo_telefone3 = $("#tipoTelefone3").val();
                    var telefone3 = $("#telefone3").val();
                    var tipo_telefone4 = $("#tipoTelefone4").val();
                    var telefone4 = $("#telefone4").val();
                    var cep = $("#cep").val();
                    var tipo_logradouro = $("#tipoLogradouro").val();
                    var logradouro = $("#logradouro").val();
                    var numero_endereco = $("#numeroEndereco").val();
                    var complemento = $("#complemento").val();
                    var bairro = $("#bairro").val();
                    var cidade = $("#cidade").val();
                    var estado = $("#estado").val();
                    var idEndereco = $("#idEndereco").val();
                    var id_telefone1 = $("#idTelefone1").val();
                    var id_telefone2 = $("#idTelefone2").val();
                    var id_telefone3 = $("#idTelefone3").val();
                    var id_telefone4 = $("#idTelefone4").val();
                    var id_tipo_telefone1 = $("#idTipoTelefone1").val();
                    var id_tipo_telefone2 = $("#idTipoTelefone2").val();
                    var id_tipo_telefone3 = $("#idTipoTelefone3").val();
                    var id_tipo_telefone4 = $("#idTipoTelefone4").val();

                    $.ajax(
                            {
                                url: "alterarProprietario?" +
                                        "idProprietario=" + _idProprietario +
                                        "&nomeUsuario=" + nome_usuario +
                                        "&sobrenomeUsuario=" + sobre_nome_usuario +
                                        "&emailUsuario=" + email_usuario +
                                        "&situacaoUsuario=" + situacao_usuario +
                                        "&senha=" + senha +
                                        "&confirmaSenha=" + confirma_senha +
                                        "&naturalizacaoDocumento=" + naturalizacao_documento +
                                        "&orgaoDocumento=" + orgao_documento +
                                        "&emissaoDocumento=" + emissao_documento +
                                        "&numeroCpfCnpjUsuario=" + numero_cpf_cnpj_usuario +
                                        "&sexo=" + sexo +
                                        "&nascimentoUsuario=" + nascimento_usuario +
                                        "&nacionalidadeUsuario=" + nacionalidade_usuario +
                                        "&tipoUsuario=" + tipo_usuario +
                                        "&tipoTelefone1=" + tipo_telefone1 +
                                        "&telefone1=" + telefone1 +
                                        "&tipoTelefone2=" + tipoTelefone2 +
                                        "&telefone2=" + telefone2 +
                                        "&tipoTelefone3=" + tipo_telefone3 +
                                        "&telefone3=" + telefone3 +
                                        "&tipoTelefone4=" + tipo_telefone4 +
                                        "&telefone4=" + telefone4 +
                                        "&cep=" + cep +
                                        "&tipoLogradouro=" + tipo_logradouro +
                                        "&logradouro=" + logradouro +
                                        "&numeroEndereco=" + numero_endereco +
                                        "&complemento=" + complemento +
                                        "&bairro=" + bairro +
                                        "&cidade=" + cidade +
                                        "&estado=" + estado +
                                        "&idEndereco=" + idEndereco+
                                        "&idTelefone1="+id_telefone1+
                                        "&idTelefone2="+id_telefone2+
                                        "&idTelefone3="+id_telefone3+
                                        "&idTelefone4="+id_telefone4+
                                        "&idTipoTelefone1="+id_tipo_telefone1+
                                        "&idTipoTelefone2="+id_tipo_telefone2+
                                        "&idTipoTelefone3="+id_tipo_telefone3+
                                        "&idTipoTelefone4="+id_tipo_telefone4,
                                
                                contentType: "charset=UTF-8",
                                success: function (retorno) {
                                    if (retorno == "ok") {
                                        //sucesso
                                        location.replace("mensagem_alterar.jsp");
                                    } else {
                                        //erro
                                        $("#mostrarErro").html(retorno);
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
                    <h1 class="mt-4">Alterar Proprietário</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item"><a href="dashboard.jsp">Dashboard</a></li>
                        <li class="breadcrumb-item"><a href="consultar_proprietario.jsp">Consultar Proprietário</a></li>
                        <li class="breadcrumb-item"><a href="li_consulta_proprietario.jsp">Listagem de Consulta</a></li>
                        <li class="breadcrumb-item"><a href="resultado_cons_proprietario.jsp">Resultado Consulta</a></li>
                        <li class="breadcrumb-item active">Alterar Proprietário</li>
                    </ol>
                    <div class="card mb-4">
                        <div class="card-body">

                            <!-- COMEÇO DO FORM -->

                            <form action="#" method="#">
                                <div class="col-md-3">    </div>
                                <div class="form-row"><div class="col-md-3"></div><h5 class="font-weight-light my-4">Dados do Proprietário</h5></div>
                                <div class="form-row">

                                    <div class="col-md-3">    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="small mb-1" for="nomeUsuario">Nome</label>
                                            <%                                                     Proprietario proprietario = (Proprietario) request.getAttribute("alterarProprietario");
                                            %>
                                            <input class="form-control py-3" id="idProprietario" name="idProprietario" type="hidden" placeholder="Digite o tipo" value="<%=proprietario.getIdUsuario()%>" />
                                            <input class="form-control py-3" id="nomeUsuario" name="nomeUsuario" type="text" placeholder="Digite seu nome" value="<%=proprietario.getNome()%>"/>
                                        </div>
                                    </div>



                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="small mb-1" for="sobrenomeUsuario">Sobrenome</label>
                                            <input class="form-control py-3" id="sobrenomeUsuario" name="sobrenomeUsuario" type="text" placeholder="Digite seu sobrenome" value="<%=proprietario.getSobrenome()%>"/>
                                        </div>
                                    </div>



                                    <div class="col-md-3">    </div>

                                </div>

                                <div class="form-row">    
                                    <div class="col-md-3">    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label class="small mb-1" for="emailUsuario">Email</label>
                                            <input class="form-control py-3" id="emailUsuario" name="emailUsuario" type="email" placeholder="Digite seu email" value="<%=proprietario.getEmail()%>"/>
                                        </div>   
                                    </div>

                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label class="small mb-1" for="situacaoUsuario">Situação do Usuário</label>
                                            <select id="situacaoUsuario" name="situacaoUsuario" class="form-control">
                                                <option value="<%=proprietario.getIdSituacaoUsuario()%>"><%=proprietario.getDescSituacaoUsuario()%></option>
                                                <option value="1">Ativo</option>
                                                <option value="2">Inativo</option>
                                            </select>
                                        </div>
                                    </div>


                                    <div class="col-md-3">    </div>
                                </div>


                                <div class="form-row">
                                    <div class="col-md-3"></div>
                                    <div hidden class="col-md-3">
                                        <div class="form-group">
                                            <label class="small mb-1" for="senha">Senha</label>
                                            <input class="form-control py-3" id="senha" name="senha" type="password" placeholder="Digite sua senha" value=""/>
                                        </div>
                                    </div>

                                    <div hidden class="col-md-3">
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
                                            <input class="form-control py-3 " id="naturalizacaoDocumento" name="naturalizacaoDocumento" type="text" value="<%=proprietario.getRgRne()%>" placeholder="Digite o documento"/>
                                        </div>
                                    </div>

                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label class="small mb-1" for="orgaoDocumento">Órgão Expedidor</label>
                                            <input class="form-control py-3" id="orgaoDocumento" name="orgaoDocumento" type="text" placeholder="Digite o órgão" value="<%=proprietario.getOrgaoExpedidorRgRne()%>"/>
                                        </div>
                                    </div>


                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label class="small mb-1" for="emissaoDocumento">Data de Emissão</label>
                                            <%SimpleDateFormat fUS = new SimpleDateFormat("dd/MM/yyyy");%>
                                            <input class="form-control py-3" id="emissaoDocumento" name="emissaoDocumento" type="text" placeholder="dd/mm/aaaa" value="<%=fUS.format(proprietario.getDataEmissaoRgRne())%>" />
                                        </div>
                                    </div>
                                </div>




                                <div class="form-row"> 
                                    <div class="col-md-3">    </div>   
                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label class="small mb-1" for="numeroCpfCnpjUsuario" >CPF/CNPJ</label>
                                            <input class="form-control py-3 " id="numeroCpfCnpjUsuario" name="numeroCpfCnpjUsuario" type="text" value="<%=proprietario.getCpfCnpj()%>" placeholder="Digite o documento"/>
                                        </div>
                                    </div>

                                    <div class="col-md-2">
                                        <div class="form-group" Style="height: 38px;">                                            
                                            <label class="small mb-1" for="sexo" >Sexo</label>
                                            <select id="sexo" name="sexo" class="form-control">
                                                <option value="<%=proprietario.getSexo()%>"><%=proprietario.getSexo()%></option>
                                                <option value="masculino">Masculino</option>
                                                <option value="feminino">Feminino</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label class="small mb-1" for="nascimentoUsuario">Data de Nascimento</label>
                                            <input class="form-control py-3" id="nascimentoUsuario" name="nascimentoUsuario" type="text" placeholder="dd/mm/aaaa" onblur="Is18()" value="<%=fUS.format(proprietario.getDataNascimento())%>" />
                                        </div>
                                    </div> 
                                </div>



                                <div class="form-row">    
                                    <div class="col-md-3"></div>
                                    <div class="col-md-3">
                                        <div class="form-group">                                            
                                            <label class="small mb-1" for="nacionalidadeUsuario" >País</label>
                                            <select id="nacionalidadeUsuario" name="nacionalidadeUsuario" class="form-control">
                                                <option value="<%=proprietario.getNacionalidade().getIdNacionalidade()%>"><%=proprietario.getNacionalidade().getDescricaoNacionalidade()%></option>
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
                                                <option value="<%=proprietario.getTipoUsuario().getIdTipoUsuario()%>"><%=proprietario.getTipoUsuario().getTipoUsuario()%></option>
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
                                
                                
                               <%  
                                        Telefone t1 = null;
                                        if (proprietario.getTelefones().size()<1) {
                                            t1 = new Telefone();
                                        } else {
                                            t1 = proprietario.getTelefones().get(0);
                                        }
                                    %>
                                    <div class="form-row">
                                        <div class="col-md-3">    </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-2 " for="tipoTelefone1" >Tipo de Telefone</label>
                                                <select id="tipoTelefone1" name="tipoTelefone1" class="form-control" onchange="telefoneMask1()">
                                                    <option value="">Selecione o tipo</option>
                                                    <option value="1"<%=(t1.getIdTipoTelefone()==1?" selected='selected'":"")%>>Residencial</option>
                                                    <option value="2"<%=(t1.getIdTipoTelefone()==2?" selected='selected'":"")%>>Celular</option>
                                                    <option value="3"<%=(t1.getIdTipoTelefone()==3?" selected='selected'":"")%>>Comercial</option>
                                                    <option value="4"<%=(t1.getIdTipoTelefone()==4?" selected='selected'":"")%>>Recado</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1.1" for="telefone1">Telefone</label>
                                                <input class="telefone1 form-control py-3" id="idTelefone1" name="idTelefone1" type="hidden" placeholder="Telefone" value="<%=t1.getIdTelefone()%>"/>
                                                <input class="telefone1 form-control py-3" id="idTipoTelefone1" name="idTipoTelefone1" type="hidden" placeholder="Telefone" value="<%=t1.getIdTipoTelefone()%>"/>
                                                <input class="telefone1 form-control py-3" id="telefone1" name="telefone1" type="text" placeholder="Telefone" value="<%=(t1.getNumeroTelefone() == null ? "" : t1.getNumeroTelefone())%>"/>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- -->
                                    
                                    <%  
                                        Telefone t2 = null;
                                        if (proprietario.getTelefones().size()<2) {
                                            t2 = new Telefone();
                                        } else {
                                            t2 = proprietario.getTelefones().get(1);
                                        }
                                    %>
                                    <div class="form-row">
                                        <div class="col-md-3">    </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-2 " for="tipoTelefone2" >Tipo de Telefone</label>
                                                <select id="tipoTelefone2" name="tipoTelefone2" class="form-control" onchange="telefoneMask2()">
                                                    <option value="">Selecione o tipo</option>
                                                    <option value="1"<%=(t2.getIdTipoTelefone()==1?" selected='selected'":"")%>>Residencial</option>
                                                    <option value="2"<%=(t2.getIdTipoTelefone()==2?" selected='selected'":"")%>>Celular</option>
                                                    <option value="3"<%=(t2.getIdTipoTelefone()==3?" selected='selected'":"")%>>Comercial</option>
                                                    <option value="4"<%=(t2.getIdTipoTelefone()==4?" selected='selected'":"")%>>Recado</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1.1" for="telefone2">Telefone</label>
                                                <input class="telefone1 form-control py-3" id="idTelefone2" name="idTelefone2" type="hidden" placeholder="Telefone" value="<%=t2.getIdTelefone()%>"/>
                                                <input class="telefone1 form-control py-3" id="idTipoTelefone2" name="idTipoTelefone2" type="hidden" placeholder="Telefone" value="<%=t2.getIdTipoTelefone()%>"/>
                                                <input class="telefone1 form-control py-3" id="telefone2" name="telefone2" type="text" placeholder="Telefone" value="<%=(t2.getNumeroTelefone() == null ? "" : t2.getNumeroTelefone())%>"/>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <!-- -->
                                    <%  
                                        Telefone t3 = null;
                                        if (proprietario.getTelefones().size()<3) {
                                            t3 = new Telefone();
                                        } else {
                                            t3 = proprietario.getTelefones().get(2);
                                        }
                                    %>
                                    <div class="form-row">
                                        <div class="col-md-3">    </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-2 " for="tipoTelefone3" >Tipo de Telefone</label>
                                                <select id="tipoTelefone3" name="tipoTelefone3" class="form-control" onchange="telefoneMask3()">
                                                    <option value="">Selecione o tipo</option>
                                                    <option value="1"<%=(t3.getIdTipoTelefone()==1?" selected='selected'":"")%>>Residencial</option>
                                                    <option value="2"<%=(t3.getIdTipoTelefone()==2?" selected='selected'":"")%>>Celular</option>
                                                    <option value="3"<%=(t3.getIdTipoTelefone()==3?" selected='selected'":"")%>>Comercial</option>
                                                    <option value="4"<%=(t3.getIdTipoTelefone()==4?" selected='selected'":"")%>>Recado</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1.1" for="telefone3">Telefone</label>
                                                <input class="telefone1 form-control py-3" id="idTelefone3" name="idTelefone3" type="hidden" placeholder="Telefone" value="<%=t3.getIdTelefone()%>"/>
                                                <input class="telefone1 form-control py-3" id="idTipoTelefone3" name="idTipoTelefone3" type="hidden" placeholder="Telefone" value="<%=t3.getIdTipoTelefone()%>"/>
                                                <input class="telefone1 form-control py-3" id="telefone3" name="telefone3" type="text" placeholder="Telefone" value="<%=(t3.getNumeroTelefone() == null ? "" : t3.getNumeroTelefone())%>"/>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- -->
                                    
                                    <%  
                                        Telefone t4 = null;
                                        if (proprietario.getTelefones().size()<4) {
                                            t4 = new Telefone();
                                        } else {
                                            t4 = proprietario.getTelefones().get(3);
                                        }
                                    %>
                                    
                                    <div class="form-row">
                                        <div class="col-md-3">    </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-2 " for="tipoTelefone4" >Tipo de Telefone</label>
                                                <select id="tipoTelefone4" name="tipoTelefone4" class="form-control" onchange="telefoneMask4()">
                                                    <option value="">Selecione o tipo</option>
                                                    <option value="1"<%=(t4.getIdTipoTelefone()==1?" selected='selected'":"")%>>Residencial</option>
                                                    <option value="2"<%=(t4.getIdTipoTelefone()==2?" selected='selected'":"")%>>Celular</option>
                                                    <option value="3"<%=(t4.getIdTipoTelefone()==3?" selected='selected'":"")%>>Comercial</option>
                                                    <option value="4"<%=(t4.getIdTipoTelefone()==4?" selected='selected'":"")%>>Recado</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1.1" for="telefone4">Telefone</label>
                                                <input class="telefone4 form-control py-3" id="idTelefone4" name="idTelefone4" type="hidden" placeholder="Telefone" value="<%=t4.getIdTelefone()%>"/>
                                                <input class="telefone4 form-control py-3" id="idTipoTelefone4" name="idTipoTelefone4" type="hidden" placeholder="Telefone" value="<%=t4.getIdTipoTelefone()%>"/>
                                                <input class="telefone4 form-control py-3" id="telefone4" name="telefone4" type="text" placeholder="Telefone" value="<%=(t4.getNumeroTelefone()==null?"":t4.getNumeroTelefone())%>"/>
                                            </div>
                                        </div>
                                    </div>


                                <div class="form-row">
                                    <div class="col-md-3">    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label class="small mb-1" for="cep">CEP<i class="fas fa-search" style="margin-left: 10px;"  onclick="pesquisacep(cep.value);"></i></label>
                                             <input class="form-control py-3" id="idEndereco" name="idEndereco" type="hidden" placeholder="" value="<%=proprietario.getEndereco().getIdEndereco()%>" />
                                            <input class="form-control py-3" id="cep" name="cep" type="text" onblur="pesquisacep(this.value);" value="<%=proprietario.getEndereco().getCep()%>" placeholder="Digite o CEP"/>
                                        </div>
                                    </div>

                                    <div hidden class="col-md-2">
                                        <div class="form-group">
                                            <label class="small mb-1" for="tipoLogradouro">Tipo de Logradouro</label>
                                            <input class="form-control py-3" id="tipoLogradouro" name="tipoLogradouro" type="text" placeholder="Nome logradouro" value="<%=proprietario.getEndereco().getTipoLogradouro()%>"/>
                                        </div>
                                    </div>

                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label class="small mb-1" for="logradouro">Logradouro</label>
                                            <input class="form-control py-3" id="logradouro" name="logradouro" type="text" placeholder="Nome logradouro" value="<%=proprietario.getEndereco().getLogradouro()%>"/>
                                        </div>
                                    </div>

                                </div>

                                <div class="form-row">


                                    <div class="col-md-3">    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label class="small mb-1" for="numeroEndereco">Número</label>
                                            <input class="form-control py-3" id="numeroEndereco" name="numeroEndereco" type="text" placeholder="Nº do local" value="<%=proprietario.getEndereco().getNumero()%>"/>
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label class="small mb-1" for="complemento">Complemento</label>
                                            <input class="form-control py-3" id="complemento" name="complemento" type="text" placeholder="Complemento" value="<%=proprietario.getEndereco().getComplemento()%>"/>
                                        </div>
                                    </div>

                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label class="small mb-1" for="bairro">Bairro</label>
                                            <input class="form-control py-3" id="bairro" name="bairro" type="text" placeholder="Bairro" value="<%=proprietario.getEndereco().getBairro()%>"/>
                                        </div>
                                    </div>


                                </div>
                                <div class="form-row">    
                                    <div class="col-md-3">    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="small mb-1" for="cidade">Cidade</label>
                                            <input class="form-control py-3" id="cidade" name="cidade" type="text" placeholder="Cidade" onkeypress="return apenasLetras(event);" value="<%=proprietario.getEndereco().getCidade()%>"/>
                                        </div>
                                    </div>


                                    <div class="col-md-3">
                                        <label class="small mb-1" for="estado">Estado</label>
                                        <select id="estado" name="estado" class="form-control">
                                            <option value="<%=proprietario.getEndereco().getEstado().getIdEstado()%>"><%=proprietario.getEndereco().getEstado().getDescricaoEstado()%></option>
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

                                    <div class="form-group mt-4 mb-0"><button id="salvarAlteracoes" class="btn btn-success btn-block" >Salvar Alterações</button></div>

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

                        <div id="savechangemodal" class="modal fade">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <form>
                                        <div class="modal-header">						
                                            <h4 class="modal-title">Alterações feitas com sucesso!</h4>
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        </div>

                                        <div class="modal-footer">
                                            <input type="button" class="btn btn-success" data-dismiss="modal" value="Voltar">
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>

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