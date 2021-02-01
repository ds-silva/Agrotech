<%@page import="model.Usuario"%>
<%@page import="model.Telefone"%>
<%@page import="model.Administrador"%>
<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
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
        <title>Meu Perfil</title>
        <link rel="icon" href="/agrotech/favicon.ico">
        <link href="css/styles.css" rel="stylesheet" />
        <script type="text/javascript" src="js/buscadorcep.js"></script>
        <link href="css/dataTables.bootstrap4.min.css" rel="stylesheet" />

        <!-- Script -->

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

        <script>
            $(document).ready(function () {
                $("#alterar").click(function () {
                    event.preventDefault();

                    var id_usuario = $("#idUsuario").val();
                    var nome_digitado = $("#nomeUsuario").val();
                    var sobrenome_digitado = $("#sobrenomeUsuario").val();
                    var email_digitado = $("#emailUsuario").val();
                    var matricula_digitada = $("#matriculaUsuario").val();
                    var senha_digitada = $("#senha").val();
                    var tipoUsuario_digitada = $("#tipoUsuario").val();
                    var naturalizacaoDocumento_digitado = $("#naturalizacaoDocumento").val();
                    var orgaoExpedidor_digitado = $("#orgaoDocumento").val();
                    var emissaoDocumento_digitado = $("#emissaoDocumento").val();
                    var numeroCpfCnpjUsuario_digitado = $("#numeroCpfCnpjUsuario").val();
                    var sexo_digitado = $("#sexo").val();
                    var id_digitado = $("#nascimentoUsuario").val();
                    var nacionalidadeUsuario_digitada = $("#nacionalidadeUsuario").val();
                    var orgaoFuncional_digitado = $("#orgaoFuncional").val();
                    var regional_digitada = $("#regional").val();
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
                    var bairro_digitada = $("#bairro").val();
                    var cidade_digitada = $("#cidade").val();
                    var estado_digitado = $("#estado").val();
                    var id_endereco = $("#idEndereco").val();
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
                                url: "meuPerfil?" +
                                        "idUsuario=" + id_usuario +
                                        "&nomeUsuario=" + nome_digitado +
                                        "&sobrenomeUsuario=" + sobrenome_digitado +
                                        "&emailUsuario=" + email_digitado +
                                        "&matriculaUsuario=" + matricula_digitada +
                                        "&senha=" + senha_digitada +
                                        "&tipoUsuario=" + tipoUsuario_digitada +
                                        "&naturalizacaoDocumento=" + naturalizacaoDocumento_digitado +
                                        "&orgaoDocumento=" + orgaoExpedidor_digitado +
                                        "&emissaoDocumento=" + emissaoDocumento_digitado +
                                        "&numeroCpfCnpjUsuario=" + numeroCpfCnpjUsuario_digitado +
                                        "&sexo=" + sexo_digitado +
                                        "&nascimentoUsuario=" + id_digitado +
                                        "&nacionalidadeUsuario=" + nacionalidadeUsuario_digitada +
                                        "&orgaoFuncional=" + orgaoFuncional_digitado +
                                        "&regional=" + regional_digitada +
                                        "&tipoTelefone1=" + tipoTelefone1_digitado +
                                        "&telefone1=" + telefone1_digitado +
                                        "&tipoTelefone2=" + tipoTelefone2_digitado +
                                        "&telefone2=" + telefone2_digitado +
                                        "&tipoTelefone3=" + tipoTelefone3_digitado +
                                        "&telefone3=" + telefone3_digitado +
                                        "&tipoTelefone4=" + tipoTelefone4_digitado +
                                        "&telefone4=" + telefone4_digitado +
                                        "&cep=" + cep_digitado +
                                        "&tipoLogradouro=" + tipoLogradouro_digitado +
                                        "&logradouro=" + logradouro_digitado +
                                        "&numeroEndereco=" + numeroEndereco_digitado +
                                        "&complemento=" + complemento_digitado +
                                        "&bairro=" + bairro_digitada +
                                        "&cidade=" + cidade_digitada +
                                        "&estado=" + estado_digitado +
                                        "&idEndereco=" + id_endereco +
                                        "&idTelefone1=" + id_telefone1 +
                                        "&idTelefone2=" + id_telefone2 +
                                        "&idTelefone3=" + id_telefone3 +
                                        "&idTelefone4=" + id_telefone4 +
                                        "&idTipoTelefone1=" + id_tipo_telefone1 +
                                        "&idTipoTelefone2=" + id_tipo_telefone2 +
                                        "&idTipoTelefone3=" + id_tipo_telefone3 +
                                        "&idTipoTelefone4=" + id_tipo_telefone4,
                                contentType: "charset=UTF-8",
                                success: function (retorno) {
                                    if (retorno.trim() == "ok") {
                                        //sucesso
                                        location.replace("alterar_perfil.jsp");
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

        <%@include file="menu.jsp" %>

        <!-- Fim do menu da esquerda -->
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid">
                    <h1 class="mt-4">Meu Perfil</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item"><a href="dashboard.jsp">Dashboard</a></li>
                        <li class="breadcrumb-item active">Meu Perfil</li>
                    </ol>
                    <div class="card mb-4">
                        <div class="card-body">

                            <!-- COMEÇO DO FORM -->

                            <%                                
                                Usuario user = (Usuario) session.getAttribute("userInfos");
                            %>

                            <form action="#" method="#">
                                <div class="col-md-3">    </div>
                                <div class="form-row"><div class="col-md-3"></div><h5 class="font-weight-light my-4">Dados do Usuário</h5></div>
                                <div class="form-row">

                                    <div class="col-md-3">    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="small mb-1" for="nomeUsuario">Nome</label>
                                            <input class="form-control py-3" id="nomeUsuario" name="nomeUsuario" type="text" placeholder="Digite seu Nome" value="<%=user.getNome()%>" disabled/>
                                        </div>
                                    </div>



                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="small mb-1" for="sobrenomeUsuario">Sobrenome</label>
                                            <input class="form-control py-3" id="sobrenomeUsuario" name="sobrenomeUsuario" type="text" placeholder="Digite seu Sobrenome" value="<%=user.getSobrenome()%>" disabled/>
                                        </div>
                                    </div>



                                    <div class="col-md-3">    </div>

                                </div>

                                <div class="form-row">    
                                    <div class="col-md-3">    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label class="small mb-1" for="emailUsuario">Email</label>
                                            <input class="form-control py-3" id="emailUsuario" name="emailUsuario" type="email" placeholder="Digite seu Email" value="<%=user.getEmail()%>" disabled/>
                                        </div>   
                                    </div>


                                        <div class="col-md-2">    
                                            <div class="form-group">
                                                <label class="small mb-1" for="matriculaUsuario">Matrícula</label>
                                                <input class="form-control py-3" id="matriculaUsuario" name="matriculaUsuario" type="text" placeholder="Apenas números" value="<%=user.getFuncionario().getMatricula()%>"  disabled=""/>
                                            </div>                                 
                                         </div>
                                         <div class="col-md-3">    </div>
                                </div>
                                    
                                <div class="form-row"><div class="col-md-3"></div><h5 class="font-weight-light my-4">Dados Pessoais</h5></div>

                                <div class="form-row">  
                                    
                                    <div class="col-md-3"></div> 
                                    <div class="col-md-6">
                                        <div class="form-group">                                            
                                            <label class="small mb-1" for="tipoUsuario" >Tipo de Usuário</label>
                                            <select id="tipoUsuario" name="tipoUsuario" class="form-control" disabled>
                                                <option value="<%=user.getTipoUsuario().getIdTipoUsuario()%>"><%=user.getTipoUsuario().getTipoUsuario()%></option>
                                            </select>
                                        </div>
                                    </div>


                                    <div class="col-md-3"></div> 
                                    
                                </div>


                                <div class="form-row">    
                                    <div class="col-md-3">    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label class="small mb-1" for="naturalizacaoDocumento">RG/RNE</label>
                                            <input class="form-control py-3 " id="naturalizacaoDocumento" name="naturalizacaoDocumento" type="text" value="<%=user.getRgRne()%>" disabled/>
                                        </div>
                                    </div>

                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label class="small mb-1" for="orgaoDocumento">Órgão Expedidor</label>
                                            <input class="form-control py-3" id="orgaoDocumento" name="orgaoDocumento" type="text" placeholder="" value="<%=user.getOrgaoExpedidorRgRne()%>" disabled/>
                                        </div>
                                    </div>


                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label class="small mb-1" for="emissaoDocumento">Data de Emissão</label>
                                            <input class="form-control py-3" id="emissaoDocumento" name="emissaoDocumento" type="date" placeholder="dd/mm/aaaa" value="<%=user.getDataEmissaoRgRne()%>" disabled/>
                                        </div>
                                    </div>
                                </div>




                                <div class="form-row"> 
                                    <div class="col-md-3">    </div>   
                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label class="small mb-1" for="numeroCpfCnpjUsuario" >CPF/CNPJ</label>
                                            <input class="form-control py-3 " id="numeroCpfCnpjUsuario" name="numeroCpfCnpjUsuario" type="text" value="<%=user.getCpfCnpj()%>" disabled/>
                                        </div>
                                    </div>

                                    <div class="col-md-2">
                                        <div class="form-group" Style="height: 38px;">                                            
                                            <label class="small mb-1" for="sexo" >Sexo</label>
                                            <select id="sexo" name="sexo" class="form-control" disabled>
                                                <option value="">Selecione uma opção</option>
                                                    <option value="Masculino"<%=(user.getSexo().contains("Masculino")?" selected='selected'":"")%>>Masculino</option>
                                                    <option value="Feminino"<%=(user.getSexo().contains("Feminino")?" selected='selected'":"")%>>Feminino</option>

                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label class="small mb-1" for="nascimentoUsuario">Data de Nascimento</label>
                                            <input class="form-control py-3" id="nascimentoUsuario" name="nascimentoUsuario" type="date" placeholder="dd/mm/aaaa" value="<%=user.getDataNascimento()%>" disabled/>
                                        </div>
                                    </div> 
                                </div>



                                <div class="form-row">    
                                    <div class="col-md-3"></div>
                                    <div class="col-md-2">
                                        <div class="form-group">                                            
                                            <label class="small mb-1" for="nacionalidadeUsuario" >País</label>
                                            <select id="nacionalidadeUsuario" name="nacionalidadeUsuario" class="form-control" disabled>
                                                <option value="<%=user.getNacionalidade().getIdNacionalidade()%>"><%=user.getNacionalidade().getDescricaoNacionalidade()%></option>
                                            </select>
                                        </div>
                                    </div> 

                                    <div class="col-md-2">
                                        <div class="form-group" >                                            
                                            <label class="small mb-1" for="orgaoFuncional">Órgão Funcional</label>
                                            <select id="orgaoFuncional" name="orgaoFuncional" class="form-control" disabled>
                                                <option value="">Selecione o órgão</option>
                                                    <option value="1"<%=(user.getFuncionario().getRegional().getIdOrgaoFuncional()==1?" selected='selected'":"")%>>INCRA</option>
                                                    <option value="2"<%=(user.getFuncionario().getRegional().getIdOrgaoFuncional()==2?" selected='selected'":"")%>>MAPA</option>
                                                    <option value="3"<%=(user.getFuncionario().getRegional().getIdOrgaoFuncional()==3?" selected='selected'":"")%>>IBAMA</option>
                                                    <option value="4"<%=(user.getFuncionario().getRegional().getIdOrgaoFuncional()==4?" selected='selected'":"")%>>IBGE</option>
                                                    <option value="5"<%=(user.getFuncionario().getRegional().getIdOrgaoFuncional()==5?" selected='selected'":"")%>>RECEITA FEDERAL</option>
                                                    <option value="6"<%=(user.getFuncionario().getRegional().getIdOrgaoFuncional()==6?" selected='selected'":"")%>>MINISTÉRIO DA AGRICULTURA</option>
                                            </select>
                                        </div>
                                    </div> 

                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label class="small mb-1" for="regional">Regional</label>
                                            <input class="form-control py-3" id="regional" name="regional" type="text" placeholder="Regional" value="<%=user.getFuncionario().getRegional().getDescricaoRegional()%>" disabled/>
                                        </div>
                                    </div>

                                </div>


                                <div class="form-row"><div class="col-md-3"></div><h5 class="font-weight-light my-4">Contatos</h5></div>

                                <%
                                    for (Telefone t : user.getTelefones()) {
                                %>
                                <div class="form-row">

                                    <div class="col-md-3">    </div>



                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="small mb-2 " for="tipoTelefone1">Tipo de Telefone</label>
                                            <select id="tipoTelefone1" name="tipoTelefone1" class="form-control" disabled>
                                                <option value="<%=t.getIdTipoTelefone()%>"><%=t.getTipoTelefone()%></option>

                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="small mb-1.1" for="telefone1">Telefone</label>
                                            <input class="form-control py-3" id="telefone1" name="telefone1" type="text" placeholder="Telefone" value="<%=t.getNumeroTelefone()%>" disabled/>
                                        </div>
                                    </div>


                                </div>
                                <%}%>         


                                <div class="form-row">
                                    <div class="col-md-3">    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label class="small mb-1" for="cep">CEP<i class="fas fa-search" style="margin-left: 10px;"  onclick="pesquisacep(cep.value);"></i></label>
                                            <input class="form-control py-3" id="cep" name="cep" type="text" onblur="pesquisacep(this.value);" value="<%=user.getEndereco().getCep()%>" disabled/>
                                        </div>
                                    </div>

                                    <div hidden class="col-md-2">
                                        <div class="form-group">
                                            <label class="small mb-1" for="tipoLogradouro">Tipo de Logradouro</label>
                                            <input class="form-control py-3" id="tipoLogradouro" name="tipoLogradouro" type="text" placeholder="Tipo de Logradouro" value="<%=user.getEndereco().getTipoLogradouro()%>" disabled/>
                                        </div>
                                    </div>

                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label class="small mb-1" for="logradouro">Logradouro</label>
                                            <input class="form-control py-3" id="logradouro" name="logradouro" type="text" placeholder="Nome do Logradouro" value="<%=user.getEndereco().getLogradouro()%>" disabled/>
                                        </div>
                                    </div>

                                </div>

                                <div class="form-row">


                                    <div class="col-md-3">    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label class="small mb-1" for="numeroEndereco">Número</label>
                                            <input class="form-control py-3" id="numeroEndereco" name="numeroEndereco" type="text" placeholder="Nº do Local" value="<%=user.getEndereco().getNumero()%>" disabled/>
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label class="small mb-1" for="complemento">Complemento</label>
                                            <input class="form-control py-3" id="complemento" name="complemento" type="text" placeholder="Complemento" value="<%=user.getEndereco().getComplemento()%>" disabled/>
                                        </div>
                                    </div>

                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label class="small mb-1" for="bairro">Bairro</label>
                                            <input class="form-control py-3" id="bairro" name="bairro" type="text" placeholder="Bairro" value="<%=user.getEndereco().getBairro()%>" disabled/>
                                        </div>
                                    </div>


                                </div>
                                <div class="form-row">    
                                    <div class="col-md-3">    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="small mb-1" for="cidade">Cidade</label>
                                            <input class="form-control py-3" id="cidade" name="cidade" type="text" placeholder="Cidade" value="<%=user.getEndereco().getCidade()%>" disabled/>
                                        </div>
                                    </div>


                                    <div class="col-md-3">
                                        <label class="small mb-1" for="estado">Estado</label>
                                        <select id="estado" name="estado" class="form-control" disabled>
                                            <option value="<%=user.getEndereco().getEstado().getIdEstado()%>"><%=user.getEndereco().getEstado().getDescricaoEstado()%></option>

                                        </select>
                                    </div>

                                </div>

                                <!-- INICIO BOTOES -->

                                <div class="form-row">
                                    <div class="col-md-5"></div>


                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <div class="form-group mt-4 mb-0"><a class="btn btn-warning btn-block text-light" href="meuPerfilConsultaResultado" >Alterar</a></div>
                                        </div>
                                    </div>
                                </div>

                                <!-- FINAL BOTOES -->

                            </form>   

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


</body>
</html>