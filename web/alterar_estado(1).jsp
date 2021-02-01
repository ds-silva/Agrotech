<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Alterar Estado</title>
        <link href="css/styles.css" rel="stylesheet" />
        <link href="css/dataTables.bootstrap4.min.css" rel="stylesheet" />
       
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        
        <script>
            $("document").ready(function () {
                $("#salvarAlteracoes").click(function () {
                    event.preventDefault();

                    var cadastrarEstado = $("#estado").val();
                    var cadastrarUF = $("#uf").val();

                    $.ajax (
                        {
                           url: "http://resilia.super10.com.br:8080/agrotech/alterarEstado?"+
                            "estado="+cadastrarEstado+
                            "&uf="+cadastrarUF,
                    
                            success: function(retorno){
                                if (retorno.trim()=="ok") {
                                    //sucesso
                                    location.replace("mensagem_alterar.jsp");
                                }else{
                                    //erro
                                    $("#mostrarErro").html(retorno);
                                }
                            }
                        }
                    );
                });
            });
        </script>

    </head>
    <body>
        <%@include file="menu.jsp" %>
            <!-- Fim do menu da esquerda -->
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">Alterar Estado</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="dashboard.jsp">Dashboard</a></li>
                            <li class="breadcrumb-item active">Alterar Estado</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                
                                <!-- COMEÇO DO FORM -->

                                <form action="#" method="#">
                                    <div class="form-row">
                                        

                                        <div class="col-md-3">    </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1.1" for="estado">  Estado </label>
                                                <input class="form-control py-3" id="estado" name="estado" type="text" placeholder="Nome do Estado" value="" />
                                            </div>
                                        </div>
                                        
                                        

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1.1" for="uf"> Sigla </label>
                                                <input class="form-control py-3" id="uf"  name="uf" type="text" placeholder="Sigla" value=""/>
                                            </div>
                                        </div>
                                        <div class="col-md-1.1," style="justify-content : center; ">
                                            
                                            <div class="form-group mt-4 mb-0">
                                                <button class="btn btn-success btn-block" id="salvarAlteracoes">Salvar Alterações</button>
                                            </div>
                                    
                                        </div>
                                
                                </form>

                                <div id="mostrarErro"></div>


                               
                            </div>
                            </main>

                            <div id="savechangemodal" class="modal fade">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <form>
                                            <div class="modal-header">						
                                                <h4 class="modal-title">Alterações feitas com sucesso!</h4>
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            </div>
                                            
                                            <div class="modal-footer">
                                                <input type="button" class="btn btn-success" data-dismiss="modal" value="Voltar">
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>

                            <footer class="py-4 bg-success mt-auto ">
                                <div class="container-fluid ">
                                    <div class="d-flex align-items-right justify-content-between small">
                                        <div class="text-light">2020 Agrotech Sistema de Unificação de Dados do Agronegócio.</div>
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
                <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
                <script src="assets/demo/datatables-demo.js"></script>
            </body>
        </html>