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
        <title>Consultar Imóvel Rural</title>
        <link rel="icon" href="/agrotech/favicon.ico">
        <link href="css/styles.css" rel="stylesheet" />
        <link href="css/dataTables.bootstrap4.min.css" rel="stylesheet" />
       
	   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	   <script>
		     $(document).ready(function() {
			 $("#consultar").click(function(){
			 event.preventDefault();
			 
			 var numeroIR_digitado = $("#numeroIR").val();
			 var NIRF_digitado = $("#NIRF").val();
			 var situacaoIR_digitado = $("#situacaoIR").val();
			 var tipoPropriedade_digitado = $("#tipoPropriedade").val();
			 var tipoOcupacao_digitado = $("#tipoOcupacao").val();
			 var mercadoAtuacao_digitado = $("#mercadoAtuacao").val();
			 var cidade_digitado = $("#cidade").val();
			 var estado_digitado = $("#estado").val();
			 
			 
			 
			 $.ajax(
			    {  
                                url: "consultarImovelRural?"+
                                "numeroIR="+numeroIR_digitado+
                                "&NIRF="+NIRF_digitado+
                                "&situacaoIR="+situacaoIR_digitado+
                                "&tipoPropriedade="+tipoPropriedade_digitado+
                                "&tipoOcupacao="+tipoOcupacao_digitado+
                                "&mercadoAtuacao="+mercadoAtuacao_digitado+
                                "&cidade="+cidade_digitado+
                                "&estado="+estado_digitado,
				contentType: "charset=UTF-8",			   
				success: function(retorno) {
                                if (retorno=="ok") {
                                    location.replace("li_consulta_ir.jsp");  //sucesso
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
        <%@include file="menu.jsp" %>
            <!-- Fim do menu da esquerda -->
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">Consultar Imóvel Rural</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="dashboard.jsp">Dashboard</a></li>
                            <li class="breadcrumb-item active">Consultar</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                
                                <!-- COMEÇO DO FORM -->

                                <form action="#" method="#">
                                    <div class="form-row">
                                        

                                        <div class="col-md-3">    </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="numeroIR">Número da Inscrição Estadual </label>
                                                <input class="form-control py-3" id="numeroIR" name="numeroIR" type="text" placeholder="Digite a inscrição" value="" />
                                            </div>
                                        </div>
                                        
                                        

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="NIRF">NIRF</label>
                                                <input class="form-control py-3" id="NIRF" name="NIRF" type="text" placeholder="Digite o NIRF" value="" />
                                            </div>
                                        </div>
                                    
                                        
                                    
                                        <div class="col-md-2">    
                                            <div  class="form-group">
                                                <label class="small mb-1" for="situacaoIR">Situação do Imóvel Rural</label>
                                                <select id="situacaoIR" name="situacaoIR" class="form-control ">
                                                    <option value="">Selecione</option>
                                                    <option value="1">Produtivo</option>
                                                    <option value="2">Improdutivo</option>
                                                    
                                                </select>
                                            </div>                                            
                                         </div>
                                         
                                    </div>
                                
                                    <div class="form-row">    
                                        <div class="col-md-3">    </div>
                                         <div class="col-md-2">    
                                            <div class="form-group">
                                                <label class="small mb-1" for="tipoPropriedade">Tipo de Propriedade</label>
                                                <select id="tipoPropriedade" name="tipoPropriedade" class="form-control">
                                                    <option value="">Selecione</option>
                                                    <option value="comprada">comprada</option>
                                                    <option value="herdada">herdada</option>
                                                
                                                    
                                                </select>
                                            </div>
                                            
                                         </div>
                                  
                                         <div class="col-md-2">    
                                            <div class="form-group">
                                                <label class="small mb-1" for="tipoOcupacao">Tipo de Ocupação</label>
                                                <select id="tipoOcupacao" name="tipoOcupacao" class="form-control">
                                                    <option value="">Selecione</option>
                                                    <option value="propria">Própria</option>
                                                   <option value="arrendada">Arrendada</option>
                                                    
                                                </select>
                                            </div>
                                        </div>
                                       
                                        <div class="col-md-2">    
                                            <div class="form-group">
                                                <label class="small mb-1" for="mercadoAtuacao">Mercado de Atuação</label>
                                                <select id="mercadoAtuacao" name="mercadoAtuacao" class="form-control">
                                                    <option value="">Selecione</option>
                                                    <option value="ambos">ambos</option>
                                                   <option value="interno">interno</option>
                                                   <option value="externo">externo</option>
                                                    
                                                </select>
                                            </div>
                                        </div>

                                    </div>
                                    
                                        
                                        <div class="form-row">    
                                            <div class="col-md-3">    </div>
                                             <div class="col-md-3">    
                                                <div class="form-group">
                                                <div class="form-group">
                                                    <label class="small mb-1" for="cidade">Cidade</label>
													<input class="form-control py-3" id="cidade" name="cidade" type="text" placeholder="Cidade" value="" />

                                                </div>
                                                </div>
                                                
                                             </div>
                                      
                                             <div class="col-md-3">    
                                                <div class="form-group">
                                                    <label class="small mb-1" for="estado">Estado</label>
                                                    <select id="estado" name="estado" class="form-control">
													<option value="">Selecione o estado</option>
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
                                        </div>  

                                        <div class="col-md-1," style="display : flex; justify-content : center; align-items : center; flex-direction : initial;">
                                            
                                            <div class="form-group mt-4 mb-0"><button class="btn btn-success btn-block" id="consultar">Consultar</button></div>
                                    
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
                
            </body>
        </html>