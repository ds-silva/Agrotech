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
        <title>Listar Produto</title>
        <link rel="icon" href="/agrotech/favicon.ico">
        <link href="css/styles.css" rel="stylesheet" />
        <link href="css/dataTables.bootstrap4.min.css" rel="stylesheet" />
        
    </head>
    <body>
        <%@include file="menu.jsp" %>
                <!-- Fim do menu da esquerda -->
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">Listagem de Produtos</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="dashboard.jsp">Dashboard</a></li>
                            <li class="breadcrumb-item active">Listagem de Produtos</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">

                                <div class="card mb-4">
                                    <div class="card-header"><i class="fas fa-table mr-1"></i>Lista de Produtos</div>
                                    <div class="card-body">
                                        <div class="table-responsive">
                                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0" cellpading="3" border="1">
                                                <thead>
                                                    <tr>
                                                        <th>Nome</th>
                                                        <th>Ano</th>
                                                        <th>Quantidade produzida</th>
                                                        <th>Mês da safra</th>
                                                    </tr>
                                                </thead>
                                                <tfoot>
                                                    <tr>
                                                        <th>Nome</th>
                                                        <th>Ano</th>
                                                        <th>Quantidade produzida</th>
                                                        <th>Mês da safra</th>
                                                    </tr>
                                                </tfoot>
                                                <tbody>
                                                    <tr>
                                                        <td>Feijão</td>
                                                        <td>2020</td>
                                                        <td>1.338,948 mil toneladas</td>
                                                        <td>Dezembro</td>
                                                    </tr>
                                                    
                                                    <tr>
                                                        <td>Algodão</td>
                                                        <td>2020</td>
                                                        <td>2,7 milhões de toneladas</td>
                                                        <td>Dezembro</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Arroz</td>
                                                        <td>2020</td>
                                                        <td>175,3 mil toneladas</td>
                                                        <td>Dezembro</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Café</td>
                                                        <td>2020</td>
                                                        <td>53,4 milhões de sacas</td>
                                                        <td>Dezembro</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Cana-de-açúcar</td>
                                                        <td>2020</td>
                                                        <td>615.978,9 mil toneladas</td>
                                                        <td>Dezembro</td>
                                                    </tr>

                                                    
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <button class="btn btn-info" onclick="printData()">Imprimir Tabela</button>
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
