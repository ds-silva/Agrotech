<%@page import="model.ImovelRural"%>
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
        <title>Resultado de Consulta</title>
        <link rel="icon" href="/agrotech/favicon.ico">
        <link href="css/styles.css" rel="stylesheet" />
        <link href="css/dataTables.bootstrap4.min.css" rel="stylesheet" />
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#excluir").click(function () {
                    event.preventDefault();
                    
                    var excluirIdImovelRural = $("#idImovelRural").val();
                  
                    $.ajax (
                        {
                           url: "excluirImovelRural?"+
                           "idImovelRural="+excluirIdImovelRural, 
                            contentType: "charset=UTF-8",
                            success: function(retorno){
                                if (retorno.trim()=="ok") {
                                    //sucesso
                                    location.replace("mensagem_excluir.jsp");
                                }else{
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
        

        
        <script>
            $(document).ready(function () {
                $("#desabilitar").click(function () {
                    event.preventDefault();

                    var IdImovelRural = $("#idImovelRural").val();
                    

                    $.ajax(
                            {
                                url: "desabilitarImovelRural?" +
                                "idImovelRural="+IdImovelRural,
                                contentType: "charset=UTF-8",
                                success: function (retorno) {
                                    if (retorno.trim() == "ok") {
                                        //success
                                        location.replace("mensagem_desabilitar.jsp");
                                    } else {
                                        //erro
                                        $("#mostrarErro").html(retorno);
                                        $('#myModal').modal('show')
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
                        <h1 class="mt-4">Resultado Consulta</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="dashboard.jsp">Dashboard</a></li>
                            <li class="breadcrumb-item"><a href="consultar_ir.jsp">Consultar</a></li>
                            <li class="breadcrumb-item"><a href="li_consulta_ir.jsp">Listagem de Consulta</a></li>
                            <li class="breadcrumb-item active">Resultado Consulta</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                
                                <!-- COMEÃO DO FORM -->

                                <form action="resultadoConsImovelRural" method="post">
                                    <div class="form-row">
                                        

                                        <div class="col-md-3">    </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="numeroIR">Numero da Inscriçao Estadual </label>
                                                <%
                                                    ImovelRural ImvRural = (ImovelRural) request.getAttribute("ir");
                                                %>
                                                <input class="form-control py-3" id="idImovelRural" name="idImovelRural" type="hidden" placeholder="" value="<%=ImvRural.getIdImovelRural()%>" disabled/>
                                                <input class="form-control py-3" id="desabilitarImovelRural" name="desabilitarImovelRural" type="hidden" placeholder="" value="<%=ImvRural.getDesabilitarImovelRural()%>" disabled/>
                                                <input class="form-control py-3" id="numeroIR" name="numeroIR" type="text" placeholder="" value="<%=ImvRural.getnInscricaoEstadual()%>" disabled/>           
                                            </div>
                                        </div>
                                        
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="NIRF">NIRF</label>
                                                <input class="form-control py-3" id="Nirf" name="Nirf" type="text" placeholder="" value="<%=ImvRural.getNirf()%>" disabled/>
                                            </div>
                                        </div>
            
                                        <div class="col-md-2">    
                                            <div  class="form-group">
                                                <label class="small mb-1" for="situacaoIR" >Situacao do Imovel Rural</label>
                                                <input class="form-control py-3" id="situacaoIR" name="situacaoIR" value="<%=ImvRural.getSituacaoImovel()%>" disabled/>
                                            </div>                                            
                                         </div>
                                         
                                    </div>
                                
                                    <div class="form-row">    
                                        <div class="col-md-3">    </div>
                                         <div class="col-md-2">    
                                            <div class="form-group">
                                                <label class="small mb-1" for="tipoPropriedade">Tipo de Propriedade</label>
                                                <input class="form-control py-3" id="tipoPropriedade" name="tipoPropriedade" value="<%=ImvRural.getTipoPropriedade()%>" disabled/>
<!--                                                <select id="tipoPropriedade" disabled name="tipoPropriedade" class="form-control">
                                                    <option value="<%=ImvRural.getTipoPropriedade()%>"></option>
                                                    <option value="1">Comprada</option>
                                                    <option value="2">Herdada</option>
                                         
                                                </select>-->
                                            </div>
                                            
                                         </div>
                                  
                                         <div class="col-md-2">    
                                            <div class="form-group">
                                                <label class="small mb-1" for="tipoOcupacao">Tipo de Ocupacao</label>
                                                <input class="form-control py-3" id="tipoOcupacao" name="tipoOcupacao" value="<%=ImvRural.getTipoOcupacao()%>" disabled/>
<!--                                                <select id="tipoOcupacao" disabled name="tipoOcupacao" class="form-control">
                                                    <option value="<%=ImvRural.getTipoOcupacao()%>"></option>
                                                    <option value="1">ExploraÃ§Ã£o PrÃ³pria</option>
                                                   <option value="2">Arrendada</option>
                                                    
                                                </select>-->
                                            </div>
                                        </div>
                                       
                                        <div class="col-md-2">    
                                            <div class="form-group">
                                                <label class="small mb-1" for="mercadoAtuacao">Mercado de Atuacao</label>
                                                <input class="form-control py-3" id="mercadoAtuacao" name="mercadoAtuacao" value="<%=ImvRural.getMercadoAtuacao()%>" disabled/>
<!--                                                <select id="mercadoAtuacao" name="mercadoAtuacao"  class="form-control" placeholder="" value="<%=ImvRural.getMercadoAtuacao()%>" disabled>
                                                    <option value="<%=ImvRural.getMercadoAtuacao()%>"></option>
                                                    <option value="1">Ambos</option>
                                                   <option value="2">Interno</option>
                                                   <option value="3">Externo</option>
                                                    
                                                </select>-->
                                            </div>
                                        </div>
                                    </div>
                                    
                                        <div class="col-md-1">    </div>

                                       
                                        <div class="col-md-1">    </div>
                                       
                                        
                                        <div class="form-row">  
                                            <div class="col-md-3">    </div>  
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="areaGeoreferenciada">Area Geo Referenciada</label>
                                                <input disabled class="form-control py-3" id="areaGeoreferenciada" name="areaGeoreferenciada" type="text" placeholder="(ha)" value="<%=ImvRural.getAreaGeoreferenciada()%> hmÂ²" />
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="areaReservaAmbiental">Area de Reserva Ambiental</label>
                                                <input disabled class="form-control py-3" id="areaReservaAmbiental" name="areaReservaAmbiental" type="text" placeholder="(ha)" value="<%=ImvRural.getAreaReservaAmbiental()%> hmÂ²" />
                                            </div>
                                        </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="areaAgricultura">Area de Agricultura</label>
                                                <input disabled class="form-control py-3" id="areaAgricultura" name="areaAgricultura" type="text" placeholder="(ha)" value="<%=ImvRural.getAreaUtilizacaoAgricultura()%> hmÂ²" />
                                            </div>
                                        </div>
                                    </div>


                                    <div class="form-row">    
                                        <div class="col-md-3">    </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="areaPecuaria">Area de Pecuaria</label>
                                                <input disabled class="form-control py-3" id="areaPecuaria" name="areaPecuaria" type="text" placeholder="(ha)" value="<%=ImvRural.getAreaUtilizacaoPecuaria()%> hmÂ²" />
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="latitude">Latitude</label>
                                                <input class="form-control py-3" id="latitude" name="latitude" type="text" placeholder="Latitude" value="<%=ImvRural.getLatitude()%>" disabled />
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="longitude">Longitude</label>
                                                <input class="form-control py-3" id="longitude" name="longitude" type="text" placeholder="Longitude" value="<%=ImvRural.getLongitude() %>" disabled />
                                            </div>
                                        </div>
                                        </div>


                                        <div class="form-row"> 
                                        <div class="col-md-3">    </div>   
                                        
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1">CEP<i class="fas fa-search" style="margin-left: 10px;"  onclick="pesquisacep(cep.value);"></i></label>
                                             
                                                <input disabled class="form-control py-3" id="cep" name="cep" type="text" onblur="pesquisacep(this.value);" value="<%=ImvRural.getEndereco().getCep()%>" />
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="tipoLogradouro">Tipo de Logradouro</label>
                                                <input disabled class="form-control py-3" disabled id="tipoLogradouro" name="tipoLogradouro" type="text" placeholder="Tipo de Logradouro" value="<%=ImvRural.getEndereco().getTipoLogradouro()%>" />
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="logradouro">Logradouro</label>
                                                <input disabled class="form-control py-3" id="logradouro" name="logradouro" type="text" placeholder="Nome do Logradouro" value="<%=ImvRural.getEndereco().getLogradouro() %>" />
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-row">    
                                        <div class="col-md-3">    </div>
                                        <div class="col-md-1">
                                            <div class="form-group">
                                                <label class="small mb-1" for="numeroEndereco">NÃºmero</label>
                                                <input disabled class="form-control py-3" id="numeroEndereco"  name="numeroEndereco" type="text" placeholder="NÂº" value="<%=ImvRural.getEndereco().getNumero()%>" />
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="complemento">Complemento</label>
                                                <input disabled class="form-control py-3" id="complemento" name="complemento" type="text" placeholder="Ex: Fundos, frente .." value="<%=ImvRural.getEndereco().getComplemento()%>" />
                                            </div>
                                        </div>


                                        
                                          

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1" for="bairro">Bairro</label>
                                                <input disabled class="form-control py-3" id="bairro"  name="bairro" type="text" placeholder="Bairro" value="<%=ImvRural.getEndereco().getBairro() %>" />
                                            </div>
                                        </div>

                                        </div>
                                        <div class="form-row">    
                                            <div class="col-md-3">    </div>
                                             <div class="col-md-3">    
                                                <div class="form-group">
                                                <div class="form-group">
                                                    <label class="small mb-1" for="cidade">Cidade</label>
													<input disabled class="form-control py-3" id="cidade" name="cidade" type="text" placeholder="Cidade" value="<%=ImvRural.getEndereco().getCidade()%>" />

                                                </div>
                                                </div>
                                                
                                             </div>
                                      
                                             <div class="col-md-3">    
                                                <div class="form-group">
                                                    <label class="small mb-1" for="estado">Estado</label>
                                                    <input id="estado" disabled name="estado" class="form-control" value="<%=ImvRural.getEndereco().getEstado().getDescricaoEstado() %>" />
						 
                                                </div>
                                            </div>
                                           

                                        </div>
                                                                                                             
                                          
                                    
                                    <div class="form-row">
                                        <div class="col-md-3"></div>

                                        
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <div class="form-group mt-4 mb-0"><a href="alterarImovelRural?id=<%=ImvRural.getIdImovelRural()%>" class="btn btn-warning btn-block text-light" role="button">Alterar</a></div>
                                            </div>
                                        </div>


                                        <div class="col-md-2">
                                            <div class="form-group">
                                                 <%
                                                    if (ImvRural.getDesabilitarImovelRural()== true) {
                                                %>
                                                <div class="form-group mt-4 mb-0" class="col-md-2"><a href="#DisableEmployeeModal" data-toggle="modal"><button class="btn btn-info btn-block" type="submit">Desabilitar</button></a></div>
                                                 <%} else {%>
                                                 <div class="form-group mt-4 mb-0" class="col-md-2"><a href="#DisableEmployeeModal" data-toggle="modal"><button class="btn btn-info btn-block" type="submit">Habilitar</button></a></div>
                                                 <%}%>
                                            </div>
                                        </div>


                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <div class="form-group mt-4 mb-0" class="col-md-2"><a href="#deleteEmployeeModal"  data-toggle="modal"><button class="btn btn-danger btn-block" type="submit">Excluir</button></a></div>
                                            </div>
                                        </div>

                                    </div><!--
                                        
                                    <!-- FINAL BOTOES -->

                                <!-- Delete Modal html -->
                                <div id="deleteEmployeeModal" class="modal fade">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <form>
                                                <div class="modal-header">						
                                                    <h4 class="modal-title">Excluir Imovel Rural</h4>
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                </div>
                                                <div class="modal-body">					
                                                    <p>Tem certeza que deseja <strong>apagar</strong> esse imovel rural?</p>
                                                    <p class="text-warning"><small>Essa alteracao nao podera ser desfeita.</small></p>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">Cancelar</button>
                                                    <button type="submit" class="btn btn-danger" id="excluir" value="Excluir" >Excluir</button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>


                                    <!-- Desabilitar Modal jsp -->
                                    <div id="DisableEmployeeModal" class="modal fade">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <form>
                                                    <div class="modal-header">						
                                                        <h4 class="modal-title">Desabilitar Imovel Rural</h4>
                                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                    </div>
                                                    <div class="modal-body">					
                                                        <p>Tem certeza que deseja <strong>realizar</strong> essa operação?</p>
                                                        </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">Cancelar</button>
                                                        <%
                                                            if (ImvRural.getDesabilitarImovelRural()== true) {
                                                        %>
                                                        <button type="submit" class="btn btn-danger" value="Desabilitar" id="desabilitar">Desabilitar</button>
                                                        <%} else {%>
                                                        <button type="submit" class="btn btn-danger" value="Desabilitar" id="desabilitar" >Habilitar</button>
                                                        <%}%>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                <!--Fim dos modais-->  

                                
                                
                                </form>


                               
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