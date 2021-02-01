<%@page import="model.Regional"%>
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
        <title>Resultado de Consulta</title>
        <link rel="icon" href="/agrotech/favicon.ico">
        <link href="css/styles.css" rel="stylesheet" />
        <link href="css/dataTables.bootstrap4.min.css" rel="stylesheet" />
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script>
            $(document).ready(function() {
                $("#excluir").click(function() {
                    event.preventDefault();

                    var idOrgaoFuncional_digitado = $("#idOrgaoFuncional").val();

                    $.ajax(
                        {
                            url: "excluirOrgaoFuncional?"+
                            "idOrgaoFuncional="+idOrgaoFuncional_digitado,
                            contentType: "charset=UTF-8",
                            success: function(retorno) {
                                if (retorno.trim()=="ok") {
                                    //sucesso
                                    location.replace("mensagem_excluir.jsp");
                                    } 
                                    else {
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
        
        <script>
            $(document).ready(function() {
                $("#desabilitar").click(function() {
                    event.preventDefault();

                    var idOrgaoFuncional_digitado = $("#idOrgaoFuncional").val();

                    $.ajax(
                        {
                            url: "desabilitarOrgaoFuncional?"+
                            "idOrgaoFuncional="+idOrgaoFuncional_digitado,
                            contentType: "charset=UTF-8",
                            success: function(retorno) {
                                if (retorno.trim()=="ok") {
                                    //sucesso
                                    location.replace("mensagem_desabilitar.jsp");
                                    } 
                                    else {
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
                        <h1 class="mt-4">Resultado de Consulta de Órgão Funcional</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="dashboard.jsp">Dashboard</a></li>
                            <li class="breadcrumb-item"><a href="consultar_og.jsp">Consultar</a></li>
                            <li class="breadcrumb-item"><a href="li_consulta_og.jsp">Listagem de Consulta</a></li>
                            <li class="breadcrumb-item active">Resultado Consulta</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                
                                <!-- COMEÇO DO FORM -->

                                <form action="resultadoConsOrgaoFuncional" method="post">
                                    <div class="form-row">
                                        
                                        <div class="col-md-4">    </div>
                                        <div class="col-md-4">
                                        <div class="form-group">
                                                <label class="small mb-1.1" for="orgaoFuncional">Órgão Funcional</label>
                                                <%
                                                    Regional oG = (Regional) request.getAttribute("orgaoFunc");
                                                %>
                                                <input class="form-control py-3" id="idOrgaoFuncional" name="idOrgaoFuncional" type="hidden" placeholder="" value="<%=oG.getIdOrgaoFuncional()%>" disabled/>
                                                <input class="form-control py-3" id="orgaoFuncional" name="orgaoFuncional" type="text" placeholder="" value="<%=oG.getOrgaoFuncional()%>" disabled/>
                                            </div>                                            
                                         </div>
                                         
                                    </div>


                                    <div class="form-row">
                                        <div class="col-md-3"></div>

                                        
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <div class="form-group mt-4 mb-0"><a href="alterarOrgaoFuncional?id=<%=oG.getIdOrgaoFuncional()%>" class="btn btn-warning btn-block text-light" role="button">Alterar</a></div>
                                            </div>
                                        </div>


                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <%
                                                    if (oG.getDesabilitarOrgaoFuncional()== true) {
                                                %>
                                                <div class="form-group mt-4 mb-0" class="col-md-2"><a href="#DisableEmployeeModal" data-toggle="modal"><button class="btn btn-info btn-block" type="submit">Desabilitar</button></a></div>
                                                <%} else {%>
                                                <div class="form-group mt-4 mb-0" class="col-md-2"><a href="#DisableEmployeeModal" data-toggle="modal"><button class="btn btn-info btn-block" type="submit">Habilitar</button></a></div>
                                                <%}%>
                                            </div>
                                        </div>


                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <div class="form-group mt-4 mb-0" class="col-md-2"><a href="#deleteEmployeeModal"  data-toggle="modal"><button class="btn btn-danger btn-block" type="submit">Excluir</button></a></div>
                                            </div>
                                        </div>

                                    </div>
                                        
                                    <!-- FINAL BOTOES -->

                                <!-- Delete Modal html -->
                                <div id="deleteEmployeeModal" class="modal fade">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <form>
                                                <div class="modal-header">						
                                                    <h4 class="modal-title">Excluir Órgão Funcional</h4>
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                </div>
                                                <div class="modal-body">					
                                                    <p>Tem certeza que deseja <strong>apagar</strong> esse órgão funcional?</p>
                                                    <p class="text-warning"><small>Essa ação não poderá ser desfeita.</small></p>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">Cancelar</button>
                                                    <button type="submit" class="btn btn-danger" id="excluir" value="Excluir" >Excluir</button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>


                                    <!-- Desabilitar Modal jsp -->
                                    <div id="DisableEmployeeModal" class="modal fade">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <form>
                                                    <div class="modal-header">						
                                                        <h4 class="modal-title">Desabilitar Órgão Funcional</h4>
                                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                    </div>
                                                    <div class="modal-body">					
                                                        <p>Tem certeza que deseja <strong>desabilitar</strong> esse órgão funcional?</p>
                                                        </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">Cancelar</button>
                                                        <%
                                                            if (oG.getDesabilitarOrgaoFuncional()== true) {
                                                        %>
                                                            <button type="submit" class="btn btn-danger" id="desabilitar" value="Desabilitar" >Desabilitar</button>
                                                        <%} else {%>
                                                            <button type="submit" class="btn btn-danger" id="desabilitar" value="Desabilitar" >Habilitar</button>
                                                        <%}%>  
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                <!--Fim dos modais-->    
                                                
                                
                                </form>


                               
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