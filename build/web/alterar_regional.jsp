<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Regional"%>
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
        <title>Alterar Regional</title>
        <link rel="icon" href="/agrotech/favicon.ico">
        <link href="css/styles.css" rel="stylesheet" />
        <link href="css/dataTables.bootstrap4.min.css" rel="stylesheet" />


        <!---->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

        <script>
            $(document).ready(function () {
            $("#salvarAlteracoes").click(function () {
            event.preventDefault();
                    var _idRegional = $("#idRegional").val();
                    var idEndereco = $("#idEndereco").val();
                    var ogFuncional = $("#orgaoFuncional").val();
                    var regional_digitado = $("#regional").val();
                    var cep_digitado = $("#cep").val();
                    var tipoLogradouro_digitado = $("#tipoLogradouro").val();
                    var logradouro_digitado = $("#logradouro").val();
                    var numero = $("#numeroEndereco").val();
                    var complemento_digitado = $("#complemento").val();
                    var bairro_digitado = $("#bairro").val();
                    var cidade_digitado = $("#cidade").val();
                    var estado_digitado = $("#estado").val();
                    var telefone_digitado = $("#telefone1").val();
//                 
                    $.ajax (
                    {       url:"alterarRegionalResultado?" +
                            "idRegional=" + _idRegional +
                            "&idEndereco=" +idEndereco +
                            "&orgaoFuncional=" + ogFuncional +
                            "&regional=" + regional_digitado +
                            "&cep=" + cep_digitado +
                            "&tipoLogradouro=" + tipoLogradouro_digitado +
                            "&logradouro=" + logradouro_digitado +
                            "&numeroEndereco=" + numero +
                            "&complemento=" + complemento_digitado +
                            "&bairro=" + bairro_digitado +
                            "&cidade=" + cidade_digitado +
                            "&estado=" + estado_digitado +
                            "&telefone1=" + telefone_digitado,
                            contentType: "charset=UTF-8",
                            success: function(retorno){
                            if (retorno.trim() == "ok"){
                            //sucesso
                            location.replace("mensagem_alterar.jsp");
                            } else{
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
        <%@include file="menu.jsp" %>
        <!-- Fim do menu da esquerda -->
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid">
                    <h1 class="mt-4">Alterar Regional</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item"><a href="dashboard.jsp">Dashboard</a></li>
                        <li class="breadcrumb-item"><a href="consultar_regional.jsp">Consultar Regional</a></li>
                        <li class="breadcrumb-item"><a href="li_consulta_regional.jsp">Listagem de Consulta</a></li>
                        <li class="breadcrumb-item"><a href="resultado_cons_regional.jsp">Resultado Consulta</a></li>
                        <li class="breadcrumb-item active">Alterar Regional</li>
                    </ol>
                    <div class="card mb-4">
                        <div class="card-body">

                            <!-- COMEÇO DO FORM -->

                            <form action="#" method="#">  
                                <div class="form-row">
                                    <%
                                        Regional r = (Regional) request.getAttribute("regional");

                                    %>

                                    <div class="col-md-3">    </div>
                                    <div class="col-md-3">
                                        <div class="form-group" >                                            
                                            <label class="small mb-1" for="orgaoFuncional">Órgão Funcional</label>
                                            <input class="form-control py-3" id="idRegional" name="idRegional" type="hidden" placeholder="Digite o tipo" value="<%=r.getIdRegional()%>" />
                                            
                                            <input class="form-control py-3" id="idEndereco" name="idEndereco" type="hidden" placeholder="Digite o tipo" value="<%=r.getEndereco().getIdEndereco()%>" />
                                            
                                            <select id="orgaoFuncional" name="orgaoFuncional" class="form-control" onchange="changeSelect2();">
                                                <option value="<%=r.getIdOrgaoFuncional()%>"><%=r.getOrgaoFuncional()%></option>

                                                <option value="2">MAPA</option>
                                                <option value="3">IBAMA</option>
                                                <option value="4">IBGE</option>
                                                <option value="5">RECEITA FEDERAL</option>
                                                <option value="6">MINISTÉRIO DA AGRICULTURA</option>
                                            </select>
                                        </div>
                                    </div>        
                                    <div class="form-group">
                                        <label class="small mb-1" for="regional">Regional</label>
                                        <select class="form-control" id="regional" name="regional">
                                            <option value="<%=r.getIdRegional()%>"><%=r.getDescricaoRegional() %></option>
                                                    <option value="1">INCRA</option>
                                                    <option value="2">MAPA</option>
                                                    <option value="3">IBAMA</option>
                                                    <option value="4">IBGE</option>
                                                    <option value="5">RECEITA FEDERAL</option>
                                                    <option value="6">MINISTÉRIO DA AGRICULTURA</option>
                                        </select>
                                    </div>
                                </div>

                        </div>

                        <div class="form-row">
                            <div class="col-md-3">    </div>
                            <div class="col-md-2">
                                <div class="form-group">

                                    <label class="small mb-1" for="cep">CEP<i class="fas fa-search" style="margin-left: 10px;"  onclick="pesquisacep(cep.value);"></i></label>
                                    <input class="form-control py-3" id="cep" name="cep" type="text" onblur="pesquisacep(this.value);" value="<%= r.getEndereco().getCep()%>" placeholder="Digite o CEP"/>
                                </div>
                            </div>

                            <div class="col-md-2">
                                <div class="form-group">
                                    <label class="small mb-1" for="tipoLogradouro">Tipo de Logradouro</label>
                                    <input class="form-control py-3" id="tipoLogradouro" name="tipoLogradouro" type="text" placeholder="Tipo de logradouro" value="<%=r.getEndereco().getTipoLogradouro()%>"/>
                                </div>
                            </div>

                            <div class="col-md-2">
                                <div class="form-group">
                                    <label class="small mb-1" for="logradouro">Logradouro</label>
                                    <input class="form-control py-3" id="logradouro" name="logradouro" type="text" placeholder="Nome do logradouro" value="<%=r.getEndereco().getLogradouro()%>"/>
                                </div>
                            </div>

                        </div>

                        <div class="form-row">


                            <div class="col-md-3">    </div>
                            <div class="col-md-2">
                                <div class="form-group">
                                    <label class="small mb-1" for="numeroEndereco">Número</label>
                                    <input class="form-control py-3" id="numeroEndereco" name="numeroEndereco" type="text" placeholder="Nº do local" value="<%=r.getEndereco().getNumero()%>"/>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="form-group">
                                    <label class="small mb-1" for="complemento">Complemento</label>
                                    <input class="form-control py-3" id="complemento" name="complemento" type="text" placeholder="Complemento" value="<%=r.getEndereco().getComplemento()%>"/>
                                </div>
                            </div>

                            <div class="col-md-2">
                                <div class="form-group">
                                    <label class="small mb-1" for="bairro">Bairro</label>
                                    <input class="form-control py-3" id="bairro" name="bairro" type="text" placeholder="Bairro" value="<%=r.getEndereco().getBairro()%>"/>
                                </div>
                            </div>


                        </div>
                        <div class="form-row">    
                            <div class="col-md-3">    </div>
                            <div class="col-md-2">
                                <div class="form-group">
                                    <label class="small mb-1" for="cidade">Cidade</label>
                                    <input class="form-control py-3" id="cidade" name="cidade" type="text" placeholder="Cidade" value="<%=r.getEndereco().getCidade()%>"/>
                                </div>
                            </div>


                            <div class="col-md-2">
                                <label class="small mb-1" for="estado">Estado</label>
                                <select id="estado" name="estado" class="form-control">
                                    <option value="<%=r.getEndereco().getEstado().getIdEstado()%>"><%=r.getEndereco().getEstado().getDescricaoEstado()%></option>
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

                            <div class="col-md-2">
                                <div class="form-group">
                                    <label class="small mb-1" for="telefone1">Telefone</label>
                                    <input class="telefone1 form-control py-3" id="telefone1" name="telefone1" type="text" placeholder="Telefone" value="<%=r.getTelefoneRegional()%>"/>
                                </div>
                            </div>


                        </div>
                        <div class="form-row">

                            <div class="col-md-3">    </div>

                            <div class="col-md-3">
                                <!-- <div class="form-group">
                                    <label class="small mb-2" for="tipoTelefone1" >Tipo de Telefone</label>
                                    <select id="tipoTelefone1" name="tipoTelefone1" class="form-control" onchange="telefoneMask1()">
                                        <option disabled selected hidden> </option>
                                        <option value="1">Residencial</option>
                                        <option value="2">Celular</option>
                                        <option value="3">Comercial</option>
                                        <option value="4">Recado</option>
                                       

                                    </select>
                                </div> -->
                            </div>




                            <!-- </div>
                               
                            <div class="form-row">

                                <div class="col-md-3">    </div>

                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label class="small mb-2" for="tipoTelefone2" >Tipo de Telefone</label>
                                        <select id="tipoTelefone2" name="tipoTelefone2" class="form-control" onchange="telefoneMask2()">
                                            <option disabled selected hidden> </option>
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
                                        <label class="small mb-2" for="tipoTelefone3" >Tipo de Telefone</label>
                                        <select id="tipoTelefone3" name="tipoTelefone3" class="form-control" onchange="telefoneMask3()">
                                            <option disabled selected hidden> </option>
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
                                        <label class="small mb-2" for="tipoTelefone4" >Tipo de Telefone</label>
                                        <select id="tipoTelefone4" name="tipoTelefone4" class="form-control" onchange="telefoneMask4()">
                                            <option value=""> </option>
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
                                </div> -->


                        </div>


                        <div class="col-md-15" style="display : flex; justify-content : center; align-items : center; flex-direction : initial;">

                            <div class="form-group mt-4 mb-0"><button class="btn btn-success btn-block" id="salvarAlteracoes">Salvar Alterações</button></div>

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

</body>
</html>