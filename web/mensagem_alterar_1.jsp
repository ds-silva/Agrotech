<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Confirmação</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <link href="css/styles.css" rel="stylesheet" />
        <link href="css/dataTables.bootstrap4.min.css" rel="stylesheet" />
       
        
    </head>
    <body>
            <%@include file="menu.jsp" %>
                <!-- Fim do menu da esquerda -->
            
                <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid">
                    <h1 class="mt-4">Consultar Administrador</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item"><a href="dashboard.jsp">Dashboard</a></li>
                        <li class="breadcrumb-item active">Consultar Administrador</li>
                    </ol>
                    <div class="card mb-4">
                        <div class="card-body">
                            
                            <!-- COMEÇO DO FORM -->

                            <div class="card mb-4 mt-4">
                                <div class="card-body">
                    
                                    <div id="layoutAuthentication">
                                
                                        <div id="layoutAuthentication_content">
                                        
                                            <div class="text-center">
                    
                                                <img src="img/sucesso.png" alt="Ok" height="12%;" width="12%;" style="text-align: center; padding-top: 7%;">
                    
                                                <h1 style="text-align: center; font-size: 22px; padding-top: 5%;">Alteração realizada com sucesso!</h1>
                    
                                                <div class="col-md-1," style="display : flex; justify-content : center; align-items : center; flex-direction : initial;">
                                                                
                                                <a href="dashboard.jsp" class="form-group mt-4 mb-0"><button class="btn btn-success btn-block">Voltar ao Início</button></a>
                                        
                                                </div>
                                            </div>
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
            
                
                <script type="text/javascript" src="js/scripts.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>
                <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
                <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
                <script src="js/scripts.js"></script>
                <script src="js/resilia.js"></script>
                <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
                <script src="assets/demo/datatables-demo.js"></script>
    </body>
</html>