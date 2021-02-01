<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  if (session.getAttribute("user") != null)
  {
    String address =  "/agrotech/dashboard.jsp";
    response.sendRedirect(address);
  }
%>

<!DOCTYPE html>
<html lang="pt-br">

    <head>

        <title>Login</title>

        <!-- Tags rqueridas -->

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Icons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" type="text/css" href="css/styles.css">

        <!-- CSS -->

        <link rel="stylesheet" type="text/css" href="css/livre.css">

        <!-- Script Ajax -->

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script>
            $(document).ready(function() {
                $("#acessar").click(function() {
                    event.preventDefault();
                  
                    var login_digitado = $("#login").val();
                    var senha_digitada = $("#senha").val();

                    $.ajax(
                        {
                            url: "/agrotech/login?"+
                            "login="+login_digitado+
                            "&senha="+senha_digitada,

                            success: function(retorno) {
                                if (retorno.trim() == "ok") {
                                        location.replace("dashboard.jsp");
                                    } 
                                    else {
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
        
        <header>

            <div style="background-color: #28a745;">
                <div class="w-100 p-3 container" style="background-color: #28a745; height: 42px;">

                    <div class="row justify-content-between">
                        <div class="col-12 col-sm-6 col-md-8 arroba" style="left: 2.6%; font-size:13px; margin-top: -7px;" >
                            <p class="font-weight-light text-white">
                                <img src="img/brasil.png" class="img-fluid mr-2" alt="Responsive image"> <strong>BRASIL</strong>
                            </p>
                        </div>

                        <div class="col5 arroba2 " style="margin-top: -1px; right: 3.6%; position: relative;">
                            
                            <h6 class="font-weight-light text-white ml-5" style="font-size:10px;">
                                <a href="http://www.simplifique.gov.br/" class="font-weight-light text-white" target="_blank">SIMPLIFIQUE&nbsp;</a>
                                <span class="font-weight-light text-white">|&nbsp;</span>
                                <a href="https://www.gov.br/pt-br/participacao-social/" class="font-weight-light text-white" target="_blank">PARTICIPE&nbsp;</a>
                                <span class="font-weight-light text-white">|&nbsp;</span>
                                <a href="http://www4.planalto.gov.br/legislacao/" class="font-weight-light text-white" target="_blank">LEGISLAÇÃO&nbsp;</a>
                                <span class="font-weight-light text-white">|&nbsp;</span>
                                <a href="https://www.gov.br/pt-br/canais-do-executivo-federal" class="font-weight-light text-white" target="_blank">CANAIS</a>
                            </h6>
                        </div>
                    </div>
            
                </div>
            </div>
            
            <div class="bg-white">
                <div class="container">
                    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom  headeral" style="margin-bottom: 0 !important;">
                        <h5 class="my-0 mr-md-auto font-weight-normal">AGROTECH</h5>
                        <nav class="my-2 my-md-0 mr-md-3">
                            <a class="p-2 text-dark" href="index.jsp">INÍCIO</a>
                            <a class="p-2 text-dark" href="sobre.jsp">SOBRE</a>
                            <a class="p-2 text-dark" href="noticias.jsp">NOTÍCIAS</a>
                            <a class="p-2 text-dark" href="agro_no_brasil.jsp">AGRONEGÓCIO NO BRASIL</a>
                            <a class="p-2 text-dark" href="infoagro.jsp">INFOAGRO</a>
                            <a class="p-2 text-dark" href="contato.jsp">CONTATO</a>
                            <a class="p-2 text-dark" href="duvidas.jsp">DÚVIDAS</a>
                        </nav>
                       <a class="btn btn-outline-success" href="login.jsp">ACESSO</a> &nbsp;&nbsp;
                        <a class="btn btn-outline-success" href="cadastro_proprietario.jsp">CADASTRO</a>
                    </div>
                </div>
            </div>

        </header>

        <!-- MAIN -->
        
        <div class="card mb-4 mt-4">
            <div class="card-body">

                <h3 class="text-center font-weight-light mt-2 my-0">Acesso</h3>

                <!-- COMEÇO DO FORM -->

                <form action="#" method="#">
                    <main>

                        <div id="layoutAuthentication">
            
                            <div id="layoutAuthentication_content">
            
                                <div class="container">
        
                                    <div class="row justify-content-center">

                                        <div class="col-lg-5 py-0.5">
        
                                            <div class="form-group mt-4">
                                                <label class="mb-2" for="login">Email, CPF/CNPJ ou Matrícula.</label>
                                                <input class="form-control py-4" id="login" name="login" type="text" placeholder="Digite seu meio de acesso"/>
                                            </div>

                                            <div class="form-group mt-2">
                                                <label class="mb-2 mt-2" for="senha">Senha</label>
                                                <input class="form-control py-4" id="senha" name="senha" type="password" placeholder="Digite sua senha"/>
                                            </div>
                                            

                                            
                                            <div class="form-group d-flex align-items-center justify-content-between mt-4 mb-0">
                                                <a class="small text-success" href="esqueci_senha.jsp">Esqueceu senha?</a>
                                                <button class="btn btn-success" id="acessar">Acessar</button>
                                            </div>
                                                <a class="small text-success" href="index.jsp">Voltar</a>
                                                            

                                            <div class="text-center">
                                                <div class="small mt-1"><a class="text-success" href="cadastro_proprietario.jsp">Não possui conta? Cadastre-se!</a></div>
                                            </div>
                                        </div>
                                    </div>
        
                                </div>
                            </div>
                        </div>
            
                    </main>
                
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
        </div>


        <!-- FOOTER -->
        <div style="background-color: #28a745;">
            <div class="w-100 p-3 container" >

                <div class="row justify-content-between no-gutter">

                    <div class="col-5 ml-3 arroba3" style="margin-top: 2%;">

                        <p class="font-weight-light text-white text-center" style="font-size:14px;">
                            &nbsp© 2020 Agrotech Sistema de Unificação de Dados do Agronegócio.</p>
                        
                    </div>
        
                
                    <div class="col-3" style=" margin-top: 1.89%; left: 0.6%; max-width: 18%;">
        
                        <div class="redes-sociais-al " > 
                            <ul>
                                <li>
                                    <a href="https://www.facebook.com/resilia.br/" target="_blank"><img src="img/facebook-icon.png"/></a>
                                </li>
                
                                <li>
                                    <a href="https://twitter.com/ResiliaCo" target="_blank"><img src="img/twitter-icon.png"/></a>
                                </li>
                
                                <li>
                                    <a href="https://www.youtube.com/channel/UCWH7te5HPG4fiy6qi6RMeZA" target="_blank"><img src="img/youtube-icon.png"/></a>
                                </li>
                
                                <li>
                                    <a href="https://www.instagram.com/resilia.br/" target="_blank"><img src="img/instagram-icon.png"/></a>
                                </li>
                            </ul>
                        </div>
    
                    </div>
        
                </div>
        
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