<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>
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
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <title>Listagem de Consulta</title>
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <%@include file="menu.jsp" %>
            <!-- Fim do menu da esquerda -->
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">Listagem de Valida��o</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="dashboard.jsp">Dashboard</a></li>
                            <li class="breadcrumb-item active">Listagem de Valida��o</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                <div class="table-responsive">    
                                <p class="mb-0"></p>


                                <div class="container">
                                    <div class="row">
                                    
                                      
                                      <div class="col-sm">
                                        
                                      </div>
                                    </div>
                                  </div>

                                <div class="container">
                                    <div class="table-wrapper">
                                        <div class="table-title">
                                            <div class="row">
                                                <div class="col-sm-6">
                                                    <h2>Valida��es em Espera de <b> An�lise</b></h2>
                                                </div>
                                            </div>
                                        </div>
                                        <table class="table table-striped table-hover">
                                            <thead>
                                                 <tr data-href="#">
                                                   
                                                    <th>Pendentes</th>
                                                   
                                                </tr>
                                            </thead>
                                            <tbody>
                                                 <tr data-href="#">
                                                    <td>Jo�o da Silva</td>
                                                   
                                                </tr>
                                                 <tr data-href="#">
                                                    <td>Maria da Silva</td>
                                                  
                                                </tr>
                                            </tbody>
                                        </table>
                                        <div class="clearfix">
                                            <div class="hint-text">P�gina <b>1</b> de <b>1</b> </div>
                                            <ul class="pagination">
                                                <li class="page-item disabled"><a href="#">Anterior</a></li>
                                                <li class="page-item active"><a href="#" class="page-link">1</a></li>
                                                <li class="page-item"><a href="#" class="page-link">Pr�xima</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>

                                <script>checkbox.click(function(){
                                    if(!this.checked){
                                        $("#selectAll").prop("checked", false);
                                    }
                                });
                            
                            </script>


                                <!-- Delete Modal html -->
                                <div id="DisableEmployeeModal" class="modal fade">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <form>
                                                <div class="modal-header">
                                                    <h4 class="modal-title">Desabilitar Situa��o</h4>
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                </div>
                                                <div class="modal-body">
                                                    <p>Tem certeza que deseja desabilitar esses dados?</p>
                                                    </div>
                                                <div class="modal-footer">
                                                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
                                                    <input type="submit" class="btn btn-danger" value="Desabilitar">
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>

                                <!-- Delete Modal html -->
                                    <div id="deleteEmployeeModal" class="modal fade">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <form>
                                                    <div class="modal-header">						
                                                        <h4 class="modal-title">Deletar Situa��o</h4>
                                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                    </div>
                                                    <div class="modal-body">					
                                                        <p>Tem certeza que deseja apagar esses dados?</p>
                                                        <p class="text-warning"><small>Essa a��o n�o poder� ser desfeita.</small></p>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
                                                        <input type="submit" class="btn btn-danger" value="Deletar">
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                 </div>
                            </div>
                        </div>
                       
                </main>
                <footer class="py-4 bg-success mt-auto ">
                    <div class="container-fluid ">
                        <div class="d-flex align-items-right justify-content-between small">
                            <div class="text-light">2020 Agrotech Sistema de Unifica��o de Dados do Agroneg�cio.</div>
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
