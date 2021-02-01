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
        <title>Listar Estado</title>
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
                        <h1 class="mt-4">Listagem de Estado</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="dashboard.jsp">Dashboard</a></li>
                            <li class="breadcrumb-item active">Listagem de Estado</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">

                                <div class="card mb-4">
                                    <div class="card-header"><i class="fas fa-table mr-1"></i>Lista de Estado</div>
                                    <div class="card-body">
                                        <div class="table-responsive">
                                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0" cellpading="3" border="1">
                                                <thead>
                                                    <tr>
                                                        <th>N°</th>
                                                        <th>Estado</th>
                                                        <th>Sigla</th>
                                                    </tr>
                                                </thead>
                                                <tfoot>
                                                    <tr>
                                                        <th>N°</th>
                                                        <th>Estado</th>
                                                        <th>Sigla</th>
                                                    </tr>
                                                </tfoot>
                                                <tbody>
                                                    <tr>
                                                        <td>1</td>
                                                        <td>Acre</td>
                                                        <td>AC</td>
                                                    </tr>
                                                    
                                                    <tr>
                                                        <td>2</td>
                                                        <td>Alagoas</td>
                                                        <td>AL</td>
                                                    </tr>
                                                    <tr>
                                                        <td>3</td>
                                                        <td>Amapá</td>
                                                        <td>AP</td>
                                                    </tr>
                                                    <tr>
                                                        <td>4</td>
                                                        <td>Amazonas</td>
                                                        <td>AM</td>
                                                    </tr>
                                                    <tr>
                                                        <td>5</td>
                                                        <td>Bahia</td>
                                                        <td>BA</td>
                                                    </tr>
                                                    <tr>
                                                        <td>6</td>
                                                        <td>Ceará</td>
                                                        <td>CE</td>
                                                    </tr>
                                                    <tr>
                                                        <td>7</td>
                                                        <td>Distrito Federal</td>
                                                        <td>DF</td>
                                                    </tr>
													<tr>
                                                        <td>8</td>
                                                        <td>Espírito Santo</td>
                                                        <td>ES</td>
                                                    </tr>
													<tr>
                                                        <td>9</td>
                                                        <td>Goiás</td>
                                                        <td>GO</td>
                                                    </tr>
													<tr>
                                                        <td>10</td>
                                                        <td>Maranhão</td>
                                                        <td>MA</td>
                                                    </tr>
													<tr>
                                                        <td>11</td>
                                                        <td>Mato Grosso</td>
                                                        <td>MT</td>
                                                    </tr>
													<tr>
                                                        <td>12</td>
                                                        <td>Mato Grosso do Sul</td>
                                                        <td>MS</td>
                                                    </tr>													
													<tr>
                                                        <td>13</td>
                                                        <td>Minas Gerais</td>
                                                        <td>MG</td>
                                                    </tr>
													<tr>
                                                        <td>14</td>
                                                        <td>Pará</td>
                                                        <td>PA</td>
                                                    </tr>
													<tr>
                                                        <td>15</td>
                                                        <td>Paraíba</td>
                                                        <td>PB</td>
                                                    </tr>
													<tr>
                                                        <td>16</td>
                                                        <td>Paraná</td>
                                                        <td>PR</td>
                                                    </tr>
													<tr>
                                                        <td>17</td>
                                                        <td>Pernambuco</td>
                                                        <td>PE</td>
                                                    </tr>
													<tr>
                                                        <td>18</td>
                                                        <td>Piauí</td>
                                                        <td>PI</td>
                                                    </tr>
													<tr>
                                                        <td>19</td>
                                                        <td>Rio de Janeiro</td>
                                                        <td>RJ</td>
                                                    </tr>
													<tr>
                                                        <td>20</td>
                                                        <td>Rio Grande do Norte</td>
                                                        <td>RN</td>
                                                    </tr>
													<tr>
                                                        <td>21</td>
                                                        <td>Rio Grande do Sul</td>
                                                        <td>RS</td>
                                                    </tr>
													<tr>
                                                        <td>22</td>
                                                        <td>Rondônia</td>
                                                        <td>RO</td>
                                                    </tr>
													<tr>
                                                        <td>23</td>
                                                        <td>Roraima</td>
                                                        <td>RR</td>
                                                    </tr>
													<tr>
                                                        <td>24</td>
                                                        <td>Santa Catarina</td>
                                                        <td>SC</td>
                                                    </tr>
													<tr>
                                                        <td>25</td>
                                                        <td>São Paulo</td>
                                                        <td>SP</td>
                                                    </tr>
													<tr>
                                                        <td>26</td>
                                                        <td>Sergipe</td>
                                                        <td>SE</td>
                                                    </tr>
													<tr>
                                                        <td>27</td>
                                                        <td>Tocantis</td>
                                                        <td>TO</td>
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