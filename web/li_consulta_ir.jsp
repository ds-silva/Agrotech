<%@page import="model.ImovelRural"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%
  if (session.getAttribute("user") == null)
  {
    String address =  "login.jsp";
    response.sendRedirect(address);
  }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <title>Listagem de Consulta de Imóvel Rural</title>
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
                    <h1 class="mt-4">Listagem de Consultar Imóvel Rural</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item"><a href="dashboard.jsp">Dashboard</a></li>
                        <li class="breadcrumb-item"><a href="consultar_ir.jsp">Consulta</a></li>
                        <li class="breadcrumb-item active">Listagem de Consulta</li>
                    </ol>
                    <div class="card mb-4">
                        <div class="card-body">
                            <div class="table-responsive">    
                                <p class="mb-0"></p>


                                <div class="container">
                                    <div class="table-wrapper">
                                        <div class="table-title">
                                            <div class="row">
                                                <div class="col-sm-6">
                                                    <h2>Listagem de <b> Consulta</b></h2>
                                                </div>
                                            </div>
                                        </div>
                                        <table class="table table-striped table-hover">
                                            <thead>
                                                <tr data-href="#">
                                                    <th>Inscrição</th>
                                                    <th>Nirf</th>
                                                    <th>Situação</th>
                                                    <th>Propri.</th>
                                                    <th>Ocupação</th>
                                                    <th>Atuação</th>
                                                    <th>Geo-ref</th>
                                                    <th>Reserva</th>
                                                    <th>Agricul.</th>
                                                    <th>Pecuária</th>


                                                </tr>
                                            </thead>
                                            <tbody>

                                                <%
                                                    List<ImovelRural> listImovel = (ArrayList<ImovelRural>) session.getAttribute("listaImovelRural");
                                                    for (ImovelRural ir : listImovel) {
                                                %>

                                                <tr data-href="#">
                                                    <td><a href="consultarImovelRuralResultado?id=<%=ir.getIdImovelRural()%>"><%=ir.getnInscricaoEstadual()%></a></td>
                                                    <td><a href="consultarImovelRuralResultado?id=<%=ir.getIdImovelRural()%>"><%=ir.getNirf()%></a></td>
                                                    <td><a href="consultarImovelRuralResultado?id=<%=ir.getIdImovelRural()%>"><%=ir.getSituacaoImovel()%></a></td>
                                                    <td><a href="consultarImovelRuralResultado?id=<%=ir.getIdImovelRural()%>"><%=ir.getTipoPropriedade()%></a></td>
                                                    <td><a href="consultarImovelRuralResultado?id=<%=ir.getIdImovelRural()%>"><%=ir.getTipoOcupacao()%></a></td>
                                                    <td><a href="consultarImovelRuralResultado?id=<%=ir.getIdImovelRural()%>"><%=ir.getMercadoAtuacao()%></a></td>
                                                    <td><a href="consultarImovelRuralResultado?id=<%=ir.getIdImovelRural()%>"><%=ir.getAreaGeoreferenciada()%></a></td>
                                                    <td><a href="consultarImovelRuralResultado?id=<%=ir.getIdImovelRural()%>"><%=ir.getAreaReservaAmbiental()%></a></td>
                                                    <td><a href="consultarImovelRuralResultado?id=<%=ir.getIdImovelRural()%>"><%=ir.getAreaUtilizacaoPecuaria()%></a></td>
                                                    <td><a href="consultarImovelRuralResultado?id=<%=ir.getIdImovelRural()%>"><%=ir.getAreaUtilizacaoAgricultura()%></a></td>
                                                </tr>
                                                <% }%>
                                            </tbody>
                                        </table>

                                    </div>
                                </div>
                                <script>checkbox.click(function () {
                                        if (!this.checked) {
                                            $("#selectAll").prop("checked", false);
                                        }
                                    });

                                </script>


                                <!-- Delete Modal jsp -->
                                <div id="deleteEmployeeModal" class="modal fade">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <form>
                                                <div class="modal-header">						
                                                    <h4 class="modal-title">Deletar Imóvel Rural</h4>
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

                                <div id="deleteEmployeeModal1" class="modal fade">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <form>
                                                <div class="modal-header">						
                                                    <h4 class="modal-title">Desabilitar Imóvel Rural</h4>
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
