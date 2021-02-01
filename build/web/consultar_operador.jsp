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
        <title>Consultar Operador</title>
        <link rel="icon" href="/agrotech/favicon.ico">
        <link href="css/styles.css" rel="stylesheet" />     
        <link href="css/dataTables.bootstrap4.min.css" rel="stylesheet" />
       
        <!-- Código Script -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script>
            $(document).ready(function() {
                $("#consultar").click(function() {
                   event.preventDefault();

                    var _nomeUsuario = $("#nomeUsuario").val();
                    var _sobrenomeUsuario = $("#sobrenomeUsuario").val();
                    var _emailUsuario = $("#emailUsuario").val();
                    var _matriculaUsuario = $("#matriculaUsuario").val();
                    var _naturalizacaoDocumento = $("#naturalizacaoDocumento").val();
                    var _numeroCpfCnpjUsuario = $("#numeroCpfCnpjUsuario").val();
                    var _orgaoFuncional = $("#orgaoFuncional").val();
                    var _regional = $("#regional").val();
                    var _cidade = $("#cidade").val();
                    var _estado = $("#estado").val();
                    



                    $.ajax(
                        {
                            url: "consultarOperador?"+
                            "nomeUsuario="+_nomeUsuario+
                            "&sobrenomeUsuario="+_sobrenomeUsuario+
                            "&emailUsuario="+_emailUsuario+
                            "&matriculaUsuario="+_matriculaUsuario+
                            "&naturalizacaoDocumento="+_naturalizacaoDocumento+
                            "&numeroCpfCnpjUsuario="+_numeroCpfCnpjUsuario+
                            "&orgaoFuncional="+_orgaoFuncional+
                            "&regional="+_regional+
                            "&cidade="+_cidade+
                            "&estado="+_estado,
                            contentType: "charset=UTF-8",
                            success: function(retorno) {
                                if (retorno.trim()=="ok") {
                                   location.replace("li_consulta_operador.jsp");  //sucesso
                                    } else {
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
        
        <!-- Começo do menu da esquerda -->
        <%@include file="menu.jsp" %>
            <!-- Fim do menu da esquerda -->
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">Consultar Operador</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="dashboard.jsp">Dashboard</a></li>
                            <li class="breadcrumb-item active">Consultar Operador</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                
                                <!-- COMEÇO DO FORM -->

                                <form action="#" method="#">
                                    <div class="col-md-3">    </div>
                                    <div class="form-row"><div class="col-md-3"></div><h5 class="font-weight-light my-4">Dados do Operador</h5></div>
                                    <div class="form-row">
                                        
                                        <div class="col-md-3">    </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1" for="nomeUsuario">Nome</label>
                                                <input class="form-control py-3" id="nomeUsuario" name="nomeUsuario" type="text" placeholder="Digite seu nome" value=""/>
                                            </div>
                                        </div>
                                        
                                        

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1" for="sobrenomeUsuario">Sobrenome</label>
                                                <input class="form-control py-3" id="sobrenomeUsuario" name="sobrenomeUsuario" type="text" placeholder="Digite seu sobrenome" value=""/>
                                            </div>
                                        </div>
                                    
                                        
                                    
                                         <div class="col-md-3">    </div>

                                    </div>
                                
                                    <div class="form-row">    
                                        <div class="col-md-3">    </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label class="small mb-1" for="emailUsuario">Email</label>
                                                <input class="form-control py-3" id="emailUsuario" name="emailUsuario" type="email" placeholder="Digite seu email" value=""/>
                                            </div>   
                                        </div>

                                        <div class="col-md-2">    
                                            <div class="form-group">
                                                <label class="small mb-1" for="matriculaUsuario">Matrícula</label>
                                                <input class="form-control py-3" id="matriculaUsuario" name="matriculaUsuario" type="text" placeholder="Apenas números" onkeypress="return apenasNumeros(event);" maxlength="7" onblur="maxmaxLenght()" value=""/>
                                            </div>                                 
                                         </div>
                                         <div class="col-md-3">    </div>
                                    </div>


                                       
                                        

                                    <div class="form-row"><div class="col-md-3"></div><h5 class="font-weight-light my-4">Dados Pessoais</h5></div>

                                    <div class="form-row">  
                                        <div class="col-md-3"></div> 
                                        
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1" for="naturalizacaoDocumento" >RG/RNE</label>
                                                <input class="form-control py-3 " id="naturalizacaoDocumento" name="naturalizacaoDocumento" placeholder="Digite seu documento" type="text" value=""/>
                                            </div>
                                        </div>


                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1" for="numeroCpfCnpjUsuario" >CPF/CNPJ</label>
                                                <input class="form-control py-3 " id="numeroCpfCnpjUsuario" name="numeroCpfCnpjUsuario" placeholder="Digite seu documento" type="text" value=""/>
                                            </div>
                                        </div>

                                        <div class="col-md-3"></div> 
                                    </div>

                                    
                                    <div class="form-row">    
                                        <div class="col-md-3"></div>
                                       
                                        
                                        <div class="col-md-3">
                                            <div class="form-group" >                                            
                                                <label class="small mb-1" for="orgaoFuncional">Órgão Funcional</label>
                                                <select id="orgaoFuncional" name="orgaoFuncional" class="form-control">
                                                    <option value="">Selecione o órgão</option>
                                                    <option value="1">INCRA</option>
                                                    <option value="2">MAPA</option>
                                                    <option value="3">IBAMA</option>
                                                    <option value="4">IBGE</option>
                                                    <option value="5">RECEITA FEDERAL</option>
                                                    <option value="6">MINISTÉRIO DA AGRICULTURA</option>
                                                    </select>
                                            </div>
                                        </div> 
                                       
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1" for="regional">Regional</label>
                                                <select class="form-control" id="regional" name="regional">
                                                <option value="">Selecione a regional</option>
                                                </select>
                                            </div>
                                        </div>

                                        </div>


                                                                      
                                        <div class="form-row">    
                                        <div class="col-md-3">    </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1" for="cidade">Cidade</label>
                                                <input class="form-control py-3" id="cidade" name="cidade" type="text" placeholder="Cidade" onkeypress="return apenasLetras(event);" value=""/>
                                            </div>
                                        </div>
                                    

                                        <div class="col-md-3">
                                            <label class="small mb-1" for="estado">Estado</label>
                                            <select id="estado" name="estado" class="form-control">
                                                <option value="">Selecione o Estado</option>
                                                <option value="1">Acre</option>
                                                <option value="2">Alagoas</option>
                                                <option value="3">Amapá</option>
                                                <option value="4">Amazonas</option>
                                                <option value="5">Bahia</option>
                                                <option value="6">Ceará</option>
                                                <option value="7">Distrito Federal</option>
                                                <option value="8">Espírito Santo</option>
                                                <option value="9">Goiás</option>
                                                <option value="10">Maranhão</option>
                                                <option value="11">Mato Grosso</option>
                                                <option value="12">Mato Grosso do Sul</option>
                                                <option value="13">Minas Gerais</option>
                                                <option value="14">Pará</option>
                                                <option value="15">Paraíba</option>
                                                <option value="16">Paraná</option>
                                                <option value="17">Pernambuco</option>
                                                <option value="18">Piauí</option>
                                                <option value="19">Rio de Janeiro</option>
                                                <option value="20">Rio Grande do Norte</option>
                                                <option value="21">Rio Grande do Sul</option>
                                                <option value="22">Rondônia</option>
                                                <option value="23">Roraima</option>
                                                <option value="24">Santa Catarina</option>
                                                <option value="25">São Paulo</option>
                                                <option value="26">Sergipe</option>
                                                <option value="27">Tocantins</option>
                                             </select>
                                        </div>
                                    </div>

                                                                      
                                        <div class="col-md-1," style="display : flex; justify-content : center; align-items : center; flex-direction : initial;">
                                            
                                            <div class="form-group mt-4 mb-0"><button id="consultar" class="btn btn-success btn-block">Consultar</button></div>
                                    
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