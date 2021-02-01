<%@page import="model.DescricaoProduto"%>
<%@page import="model.Produto"%>
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
        <title>Alterar Produto</title>
        <link rel="icon" href="/agrotech/favicon.ico">
        <link href="css/styles.css" rel="stylesheet" />
        <link href="css/dataTables.bootstrap4.min.css" rel="stylesheet" />


        <!------------Script do ajax+jquery-------------------->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script>
            $(document).ready(function() {
                $("#salvarAlteracoes").click(function() {
                   event.preventDefault(); 
                    var _idProduto = $("#idProduto").val();
                    var _tipoProduto = $("#tipoProduto").val();
                    var _nomeProduto = $("#nomeProduto").val();
                    var _quantidadeProduzida = $("#quantidadeProduzida").val();
                    var _unidadeProduto = $("#unidadeProduto").val();
                    var _ano = $("#ano").val();
                    var _mesSafra = $("#mesSafra").val();

                    $.ajax(
                        {
                            url: "alterarProduto?"+
                            "idProduto="+_idProduto+
                            "&tipoProduto="+_tipoProduto+
                            "&nomeProduto="+_nomeProduto+
                            "&quantidadeProduzida="+_quantidadeProduzida+
                            "&unidadeProduto="+_unidadeProduto+
                            "&ano="+_ano+
                            "&mesSafra="+_mesSafra,
                            contentType: "charset=UTF-8",
                            success: function(retorno) {
                                if (retorno.trim()=="ok") {
                                    //sucesso
                                    location.replace("mensagem_alterar.jsp");
                                    } else {
                                        //erro
                                         $("#mostrarErro").html(retorno);
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
        <%@include file="menu.jsp" %>
            <!-- Fim do menu da esquerda -->
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">Alterar Produtos</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="dashboard.jsp">Dashboard</a></li>
                            <li class="breadcrumb-item"><a href="consultar_produto.jsp">Consultar Produtos</a></li>
                            <li class="breadcrumb-item"><a href="li_consulta_produto.jsp">Listagem de Consulta</a></li>
                            <li class="breadcrumb-item"><a href="resultado_cons_produto.jsp">Resultado Consulta</a></li>
                            <li class="breadcrumb-item active">Alterar Produtos</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                
                                <!-- COMEÇO DO FORM -->

                                <form action="#" method="#">

                                    <div class="form-row">
                                        

                                        <div class="col-md-3">    </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1" for="tipoProduto">Tipo</label>
                                                <%
                                                    Produto produto = (Produto) request.getAttribute("alterarProd");
                                                %>
                                                
                                                <input class="form-control py-3" id="idProduto" name="idProduto" type="hidden" placeholder="Digite o tipo" value="<%=produto.getIdProduto()%>" />
                                                <select name="tipoProduto" id="tipoProduto" class="form-control">
                                                    
                                                    <option value="<%=produto.getDescricaoProduto().getIdTipoProduto()%>"><%=produto.getDescricaoProduto().getTipoProduto()%></option>                                                   
                                                </select>
                                            </div>
                                        </div>
                                        
                                        
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1" for="nomeProduto" >Produto</label>
                                                <select name="nomeProduto" id="nomeProduto" class="form-control">
                                                    <option value="<%=produto.getDescricaoProduto().getIdDescricaoProduto()%>"><%=produto.getDescricaoProduto().getDescricaoProduto()%></option>                                                    

                                                </select>
                                            </div>
                                        </div>
                                        
                                         
                                    </div>
                                    
                                        <div class="col-md-1">    </div>

                                       
                                        <div class="col-md-1">    </div>
                                       
                                        
                                        <div class="form-row">  
                                            <div class="col-md-3">    </div>
                                        
                                        <div class="col-md-3">
                                            
                                            <div class="form-group">
                                                <label class="small mb-1" for="quantidadeProduzida">Quantidade Produzida</label>
                                                
                                                <input class="form-control py-3" id="quantidadeProduzida" name="quantidadeProduzida" type="text" placeholder="Digite o número da produção" onkeypress="return apenasNumeros(event);" value="<%=produto.getQuantidadeProduzida()%>"/>
                                            </div>
                                        </div> 


                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1" for="unidadeProduto">Unidade do Produto</label>
                                                <input class="form-control py-3" id="unidadeProduto" name="unidadeProduto" type="text" placeholder="" value="<%=produto.getDescricaoProduto().getUnidadeProduto()%>" disabled/>
                                                </select>
                                            </div>
                                        </div>


                                        <div class="col-md-1"></div>
                                    </div>


                                    <div class="form-row">    
                                        <div class="col-md-3">    </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1" for="ano">Ano</label>
                                                <input class="form-control py-3" id="ano" name="ano" type="text" placeholder="Digite o ano" value="<%=produto.getAno()%>"/>
                                            </div>
                                        </div>
                                       

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1" for="mesSafra">Mês da Safra</label>
                                                <input class="form-control py-3" id="mesSafra" name="mesSafra" type="text" placeholder="Digite o mês" onkeypress="return apenasLetras(event);" value="<%=produto.getMesSafra()%>"/>
                                            </div>
                                        </div>
                                        
                                        </div>


                                        <div class="col-md-1," style="display : flex; justify-content : center; align-items : center; flex-direction : initial;">
                                            
                                            <div class="form-group mt-4 mb-0"><button class="btn btn-success btn-block" id="salvarAlteracoes">Salvar Alterações</button></div>
                                            
                                            </div>
                                        
                                        </div>
                                        
                
                                
                                
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

                <script src="js/jquery-3.4.1.min.js"></script>
                <script src="js/all.min.js"></script>
                <script src="js/scripts.js"></script>
                <script src="js/resilia.js"></script>
                <script src="assets/demo/datatables-demo.js"></script>
                <script src="js/jquery.mask.min.js"></script>
                <script src="js/bootstrap.bundle.min.js"></script>
                <script src="js/dataTables.bootstrap4.min.js"></script>
                <script src="js/validaDados.js"></script>

            </body>
        </html>