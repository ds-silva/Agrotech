<%@page language="java" contentType="text/html; charset=UTF-8"%>

<!doctype html>
<html lang="pt-br">

<head>

    <title>Contato</title>
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



<!------------Script do ajax+jquery-------------------->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
    $(document).ready(function(){
        $("#enviar").click(function(){
            event.preventDefault();

            var _nomeContato = $("#nomeContato").val();
            var _emailContato = $("#emailContato").val();
            var _assuntoContato = $("#assuntoContato").val();
            
            $.ajax(
                {
                    url:"contato?"+
                        "nomeContato="+_nomeContato+
                        "&emailContato="+_emailContato+
                        "&assuntoContato="+_assuntoContato,
                
                        success: function(retorno){
                        if (retorno=="ok") {
                            $('#myModalSucces').modal('show');
                        } else{
                            //erro
                            $("#mostrarErro").html (retorno);
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

        <div class="text-center" style="width: 100%; background-color: #28a745;"><img src="img/bg.png" class="img-fluid" alt="Responsive image"></div>

    </header>


    <main>

    <div class="card text-center">

        <!-- DA O ESPAÇO ENTRE O HEADER E O MAIN -->
        <div class="card-header"></div>
        <!-- *** -->

        <div class="container">

            <div class="card-body" style="align-items: center;">

                <h4 class="card-title display-5">CONTATO</h4>

            </div>

            <form action="#" method="#">
                    
            <div class="form-row">
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <h6 class="text-justify lead" style="font-size: 20px; font-weight:normal;"">Nome</h6>
                    <div class="small mb-1">
                        <input type="text" class="form-control" name="nomeContato" id="nomeContato" placeholder="Insira seu nome completo" aria-label="Username" aria-describedby="basic-addon1">
                    </div>
                </div> 
            </div>

            <div class="form-row">
                <div class="form-group mt-2 col-md-12"></div>
            </div>

            <div class="form-row">
                <div class="col-md-2"></div>
                <div class="col-md-2"></div>
                <div class="col-md-4">
                    <h6 class="text-justify lead" style="font-size: 20px; font-weight:normal;"">Email</h6>
                    <div class="small mb-1">
                        <input type="text" class="form-control" id="emailContato"  name="emailContato" placeholder="Insira seu email" aria-label="Username" aria-describedby="basic-addon1">
                    </div>
                </div> 
            </div>

            <div class="form-row">
                <div class="form-group mt-2 col-md-12"></div>
            </div>

            <div class="form-row">
                <div class="col-md-2"></div>
                <div class="col-md-2"></div>
                <div class="col-md-4">
                    <h6 class="text-justify lead" style="font-size: 20px; font-weight:normal;"">Assunto</h6>
                    <div class="input-group mb-6 col-20">
                        <select class="custom-select" id="assuntoContato" name="assuntoContato">
                          <option disabled selected hidden></option>
                          <option value="elogio">Elogio</option>
                          <option value="sugestao">Sugestão</option>
                          <option value="denuncia">Denúncia</option>
                          <option value="reclamacao">Reclamação</option>
                          <option value="solicitacao">Solicitação</option>
                        </select>
                    </div>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group mt-2 col-md-12"></div>
            </div>

            <div class="form-row">
                <div class="col-md-2"></div>
                <div class="col-md-2"></div>
                <div class="col-md-4">
                    <h6 class="text-justify lead" style="font-size: 20px; font-weight:normal;""></h6>
                    <div class="small mb-1">
                        <textarea class="form-control" id="mensagemContato" name="mensagemContato" rows="3"></textarea>
                    </div>
                </div> 
            </div>

            <div class="form-row">
                <div class="form-group mt-2 col-md-12"></div>
            </div>

            <div class="col-12" style="text-align: -webkit-center;">
                <button id="enviar" class="btn btn-outline-success">Enviar</button>
            </div>

            <div class="form-row">
                <div class="form-group mt-1 col-md-12"></div>
            </div>

            </form>
            

            <!------Inicio modal de erro--->

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


    <!------Inicio modal de sucesso--->
    <div id="myModalSucces" class="modal fade" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title">Pronto!</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
              <div class="modal-body py-5">    
                <h6 class="text-danger text-center"> 
                    <div class="" id="mostrarsucesso"><h4>Seu Contato foi enviado com Sucesso.<br>Em breve retornaremos pelo email</h4></div>
                </h6>
              </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-dark" data-dismiss="modal">Ir para login</button>
            </div>
          </div>
        </div>
      </div> 


        </div>


        &nbsp;<br>
        

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