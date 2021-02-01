<%@page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Confirmação</title>
        <link rel="icon" href="/agrotech/favicon.ico">
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
                    
                        <div class="card mb-4">
                                <div class="card-body">
                            
                                        <!-- COMEÇO DO FORM -->

                    
                                        <div id="layoutAuthentication">
                                    
                                            <div id="layoutAuthentication_content">
                                            
                                                <div class="text-center">
                        
                                                    <img src="img/sucesso.png" alt="Ok" height="12%;" width="12%;" style="text-align: center; padding-top: 7%;">
                        
                                                    <h1 style="text-align: center; font-size: 22px; padding-top: 5%;">Exclusão realizada com sucesso!</h1>                        
                                                    <div class="col-md-2," style="display : flex; justify-content : center; align-items : center; flex-direction : initial;">
                                                                    
                                                    <a href="dashboard.jsp" class="form-group mt-4 mb-0"><button class="btn btn-success btn-block">Voltar ao Início</button></a>
                                                  
                                            
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
            