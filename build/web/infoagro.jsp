<%@page language="java" contentType="text/html; charset=UTF-8"%>

<!doctype html>
<html lang="pt-br">

    <head>

        <title>Agronegócio no Brasil</title>
        <link rel="icon" href="/agrotech/favicon.ico">

        <!-- Tags rqueridas -->

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Icons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" type="text/css" href="css/styles.css">

        <!-- CSS -->

        <link rel="stylesheet" type="text/css" href="css/livre.css">

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
    
            <div class="text-center" style="width: 100%; background-color: #28a745;"><img src="img/bg.png" class="img-fluid" alt="Responsive image"></div>

        </header>

        
        <main>

            <div class="card text-center">

                <!-- DA O ESPAÇO ENTRE O HEADER E O MAIN -->
                <div class="card-header"></div>
                <!-- *** -->
    
                <div class="container">
    
                    <div class="card-body">
    
                        <h4 class="card-title display-5">INFOAGRO</h4>
    
                    </div>
    
                    <div class="row align-items-center" style="margin-top: 5%;" >
    
                        <div class="col" style="left: 1%;">
                            <div class="form-group col-md-7 lead" style="font-size: 15px; font-weight:bolder;">
                                <label for="inputState">TIPO DE PESQUISA</label>
                                <select id="inputState" class="form-control">
                                  <option selected>Agricultura</option>
                                  <option>Pecuária</option>
                                </select>
                            </div>
                        </div>
    
                        <div class="col" style="left: 7%;">
                            <div class="form-group col-md-7 lead" style="font-size: 15px; font-weight:bolder;">
                                <label for="inputState">LOCAL</label>
                                <select id="inputState" class="form-control">
                                  <option selected>Acre</option>
                                  <option>Alagoas</option>
                                  <option>Amapá</option>
                                  <option>Amazonas</option>
                                  <option>Bahia</option>
                                  <option>Ceará</option>
                                  <option>Distrito Federal</option>
                                  <option>Espírito Santo</option>
                                  <option>Goiás</option>
                                  <option>Maranhão</option>
                                  <option>Mato Grosso</option>
                                  <option>Mato Grosso do Sul</option>
                                  <option>Minas Gerais</option>
                                  <option>Pará</option>
                                  <option>Paraíba</option>
                                  <option>Paraná</option>
                                  <option>Pernambuco</option>
                                  <option>Piauí</option>
                                  <option>Rio de Janeiro</option>
                                  <option>Rio Grande do Norte</option>
                                  <option>Rio Grande do Sul</option>
                                  <option>Rondônia</option>
                                  <option>Roraima</option>
                                  <option>Santa Catarina</option>
                                  <option>São Paulo</option>
                                  <option>Sergipe</option>
                                  <option>Tocantins</option>
                                </select>
                            </div>
                        </div>
    
                        <div class="col d-flex justify-content-end">
                            <div class="form-group col-md-7 lead" style="font-size: 15px; font-weight:bolder;">
                                <label for="inputState">PRODUTO</label>
                                <select id="inputState" class="form-control">
                                  <option selected>Banana</option>
                                  <option>Porco</option>
                                </select>
                            </div>
                        </div>
    
                        <div class="col-12">
                            <div style="margin-top: 7%;"><img src="img/mapa.png" class="img-fluid" alt="Responsive image"></div>
                        </div>  
    
                    </div>
    
                </div>
    
    
                &nbsp;<br>&nbsp;
            
    
                 <!-- DA O ESPAÇO ENTRE O MAIN E O FOOTER -->
                 <div class="card-footer text-muted"></div>
                 <!-- *** -->
    
            </div>
        </main>
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