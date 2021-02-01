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

        <!-- Tags rqueridas -->

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard</title>
        <link rel="icon" href="/agrotech/favicon.ico">
        <link href="css/styles.css" rel="stylesheet" />
        <link href="css/dataTables.bootstrap4.min.css" rel="stylesheet" />
        
    </head>
    <body>
    <%@include file="menu.jsp" %>
                <!-- Fim do menu da esquerda -->


            <div id="layoutSidenav_content">
                <main>


                    <!--TABELAS-->
                    <div class="container-fluid">
                        <h1 class="mt-4">Painel de Controle </h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                        </ol>

                      

                        <div class="row">
                            <div class="col-xl-3 col-md-3">
                                <div class="card bg-success text-white mb-4">
                                    <div class="card-body" style="text-align: center; ">Áreas Produtivas cadastradas</div>
                                    <div class="card-footer  align-items-center justify-content-between" style="text-align: center;">
                                        <a class="small text-white stretched-link" >40.000.000 (Hec)</a>
                                        <div class="small text-white"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-3">
                                <div class="card bg-success text-white mb-4">
                                    <div class="card-body" style="text-align: center; ">Qtd. de Imóveis Cadastrados</div>
                                    <div class="card-footer  align-items-center justify-content-between" style="text-align: center;">
                                        <a class="small text-white stretched-link">30.000</a>
                                        <div class="small text-white"></div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-xl-3 col-md-3">
                                <div class="card bg-success text-white mb-4">
                                    <div class="card-body" style="text-align: center; ">Quantidade Produzida</div>
                                    <div class="card-footer  align-items-center justify-content-between" style="text-align: center;">
                                        <a class="small text-white stretched-link" >22.223</a>
                                        <div class="small text-white"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-3">
                                <div class="card bg-success text-white mb-4">
                                    <div class="card-body" style="text-align: center; ">Percentual de Área Produtiva</div>
                                    <div class="card-footer  align-items-center justify-content-between" style="text-align: center;">
                                        <a class="small text-white stretched-link">76%</a>
                                        <div class="small text-white"></div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                           
                            <div class="col-xl-3 col-md-6"></div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-primary text-white mb-4">
                                    <div class="card-body" style="text-align: center; ">Validar Usuários (4.215)</div>
                                    <div class="card-footer  align-items-center justify-content-between" style="text-align: center;">
                                        <a class="small text-white stretched-link" href="listar_valid_cliente.jsp" >ver mais &nbsp <i class="fas fa-angle-right"></i></a>
                                        <div class="small text-white"></div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-primary text-white mb-4">
                                    <div class="card-body" style="text-align: center; ">Validar Imóveis Rurais</div>
                                    <div class="card-footer  align-items-center justify-content-between" style="text-align: center;">
                                        <a class="small text-white stretched-link" href="listar_valid_ir.jsp" >ver mais &nbsp <i class="fas fa-angle-right"></i></a>
                                        <div class="small text-white"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6"></div>
                        </div>
                                            
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="card mb-4">
                                    <div class="card-header"><i class="fas fa-chart-bar mr-1"></i>Número de Cadastros</div>
                                    <div class="card-body"><canvas id="myBarChart" width="100%" height="50"></canvas></div>
                                    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                                </div>
                            </div>

                            <div class="col-lg-6">
                                <div class="card mb-4">
                                    <div class="card-header"><i class="fas fa-chart-area mr-1"></i>Quatidade Produzida Por Ano</div>
                                    <div class="card-body"><canvas id="myAreaChart" width="100%" height="50"></canvas></div>
                                    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                                </div>
                            </div>
                            
                        </div>


                    
                        
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="card mb-4">
                                    <div class="card-header"><i class="fas fa-chart-pie mr-1"></i>Estados com maiores números de cadastros pendentes</div>
                                    <div class="card-body"><canvas id="myPieChart" width="100%" height="50"></canvas></div>
                                    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                                </div>
                            </div>

                            <div class="col-lg-6">
                                <div class="card mb-4">
                                    <div class="card-header"><i class="fas fa-chart-pie mr-1"></i>Área por tipo de produção</div>
                                    <div class="card-body"><canvas id="pizzaestado" width="100%" height="50"></canvas></div>
                                    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                                </div>
                            </div>

                        </div>
                    </div>
                    <div class="container-fluid">
                        
                        <!--nome da tabela-->
                        <h1 class="mt-4"></h1>
                      
                        
                        <div class="card mb-4">
                            <div class="card-header"><i class="fas fa-table mr-1"></i>DataTable Example</div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th style="padding-right: 100px;">Estado</th>
                                                <th>Total de Cadastros</th>
                                                <th>Cadastros Válidos</th>
                                                <th>Cadastros Pendentes</th>
                                                
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th>Estado</th>
                                                <th>Total de Cadastros</th>
                                                <th>Cadastros Válidos</th>
                                                <th>Cadastros Pendentes</th>      
                                            </tr>
                                        </tfoot>
                                        <tbody>
                                            <tr>
                                                <td>Rio de Janeiro</td>
                                                <td>10</td>
                                                <td>5</td>
                                                <td>5</td>
                                            </tr>
                                            <tr>
                                                <td>Rio de Janeiro</td>
                                                <td>10</td>
                                                <td>5</td>
                                                <td>5</td>
                                            </tr>
                                            <tr>
                                                <td>Rio de Janeiro</td>
                                                <td>10</td>
                                                <td>5</td>
                                                <td>5</td>
                                            </tr>
                                            <tr>
                                                <td>Rio de Janeiro</td>
                                                <td>10</td>
                                                <td>5</td>
                                                <td>5</td>
                                            </tr>
                                            <tr>
                                                <td>Rio de Janeiro</td>
                                                <td>10</td>
                                                <td>5</td>
                                                <td>5</td>
                                            </tr>
                                            <tr>
                                                <td>Rio de Janeiro</td>
                                                <td>10</td>
                                                <td>5</td>
                                                <td>5</td>
                                            </tr>
                                            <tr>
                                                <td>Rio de Janeiro</td>
                                                <td>10</td>
                                                <td>5</td>
                                                <td>5</td>
                                            </tr>
                                            <tr>
                                                <td>Rio de Janeiro</td>
                                                <td>10</td>
                                                <td>5</td>
                                                <td>5</td>
                                            </tr>
                                            <tr>
                                                <td>Rio de Janeiro</td>
                                                <td>10</td>
                                                <td>5</td>
                                                <td>5</td>
                                            </tr>
                                            <tr>
                                                <td>Rio de Janeiro</td>
                                                <td>10</td>
                                                <td>5</td>
                                                <td>5</td>
                                            </tr>
                                            <tr>
                                                <td>Rio de Janeiro</td>
                                                <td>10</td>
                                                <td>5</td>
                                                <td>5</td>
                                            </tr>
                                            
                                            
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Resília 2020</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Termos &amp; Condições</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="js/resilia.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="assets/demo/chart-pie-demo.js"></script>
        <script src="assets/demo/chart-pie-agro.js"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/datatables-demo.js"></script>
    </body>
</html>
