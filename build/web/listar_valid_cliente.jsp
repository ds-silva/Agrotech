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
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <title>Listagem de Consulta</title>
        <link rel="icon" href="/agrotech/favicon.ico">
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <%@include file="menu.jsp" %>
            <!-- Fim do menu da esquerda -->
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">Listagem de Validação</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="dashboard.jsp">Dashboard</a></li>
                            <li class="breadcrumb-item active">Listagem de Validação</li>
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
                                                    <h2>Validações de Usuários<b> Pendentes</b></h2>
                                                </div>
                                            </div>
                                        </div>
                                        <table class="table table-striped table-hover">
                                            <thead>
                                                 <tr data-href="#">
                                                   
                                                    <th>Nomes</th>
                                                    <th>CPF/CNPJ</th>
                                                    <th>RGE/RNE</th>
                                                    <th>Logradrouro</th>
                                                    <th>Número</th>
                                                    <th>Bairro</th>
                                                    <th>Cidade</th>
                                                    <th>Estado</th>
                                                    <th>Telefone</th>

                                                   
                                                </tr>
                                            </thead>
                                            <tbody>
                                                 <tr data-href="#">
                                                    <td>João da Silva</td>
                                                    <td>11122233344</td>
                                                    <td>212129GF</td>
                                                    <td>Rua Silva Marques</td>
                                                    <td>200</td>
                                                    <td>Nova Serra</td>
                                                    <td>Montanha</td>
                                                    <td>Mato Grosso do Sul</td>
                                                    <td>90999998888</td>

                                                </tr>
                                                 <tr data-href="#">
                                                    <td>Maria da Silva</td>
                                                    <td>2020404508</td>
                                                    <td>55566677788</td>
                                                    <td>Avenida Barroso</td>
                                                    <td>4</td>
                                                    <td>Nova Serra</td>
                                                    <td>Santa Marta</td>
                                                    <td>Espírito Santo</td>
                                                    <td>80999998888</td>
                                                  
                                                </tr>
                                            </tbody>
                                        </table>
                                        <div class="clearfix">
                                            <div class="hint-text">Página <b>1</b> de <b>1</b> </div>
                                            <ul class="pagination">
                                                <li class="page-item disabled"><a href="#">Anterior</a></li>
                                                <li class="page-item active"><a href="#" class="page-link">1</a></li>
                                                <li class="page-item"><a href="#" class="page-link">Próxima</a></li>
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
                                                    <h4 class="modal-title">Desabilitar Situação</h4>
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
                                                        <h4 class="modal-title">Deletar Situação</h4>
                                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                    </div>
                                                    <div class="modal-body">					
                                                        <p>Tem certeza que deseja apagar esses dados?</p>
                                                        <p class="text-warning"><small>Essa ação não poderá ser desfeita.</small></p>
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
