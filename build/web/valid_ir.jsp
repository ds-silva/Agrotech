<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%
  if (session.getAttribute("user") == null)
  {
    String address =  "login.jsp";
    response.sendRedirect(address);
  }
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Validação de Imóvel Rural</title>
        <link rel="icon" href="/agrotech/favicon.ico">
        <link href="css/styles.css" rel="stylesheet" />
        <script type="text/javascript" src="js/scripts.js"></script>
        <link href="css/dataTables.bootstrap4.min.css" rel="stylesheet" />
        
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>

       
        
    </head>
    <body>
        
        <%@include file="menu.jsp" %>

                <!-- Fim do menu da esquerda -->
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">Validação de Imóvel Rural</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="dashboard.jsp">Dashboard</a></li>
                            <li class="breadcrumb-item active">Validação de Imóvel Rural</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                
                                <!-- COMEÇO DO FORM -->

                                <form action="validarImovelRural" method="post">
                                    <div class="form-row">
                                        

                                        <div class="col-md-3">    </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="numeroIR">Número da Inscrição Estadual </label>
                                                <input disabled class="form-control py-3" id="numeroIR" name="numeroIR" type="text" placeholder="" value="" />
                                            </div>
                                        </div>
                                        
                                        

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="NIRF">NIRF</label>
                                                <input disabled class="form-control py-3" id="NIRF" name="NIRF" type="text" placeholder="Digite o NIRF" value="" />
                                            </div>
                                        </div>
                                    
                                        
                                    
                                        <div class="col-md-2">    
                                            <div  class="form-group">
                                                <label class="small mb-1" for="situacaoIR">Situação do Imóvel Rural</label>
                                                <select id="situacaoIR" disabled name="situacaoIR" disabled class="form-control ">
                                                    <option  selected hidden></option>
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
                                                <select id="tipoPropriedade" disabled name="tipoPropriedade" class="form-control">
                                                    <option disabled selected hidden></option>
                                                    <option value="1">Comprada</option>
                                                    <option value="2">Herdada</option>
                                                
                                                    
                                                </select>
                                            </div>
                                            
                                         </div>
                                  
                                         <div class="col-md-2">    
                                            <div class="form-group">
                                                <label class="small mb-1" for="tipoOcupacao">Tipo de Ocupação</label>
                                                <select id="tipoOcupacao" disabled name="tipoOcupacao" class="form-control">
                                                    <option disabled selected hidden></option>
                                                    <option value="1">Exploração Própria</option>
                                                   <option value="2">Arrendada</option>
                                                    
                                                </select>
                                            </div>
                                        </div>
                                       
                                        <div class="col-md-2">    
                                            <div class="form-group">
                                                <label class="small mb-1" for="mercadoAtuacao">Mercado de Atuação</label>
                                                <select id="mercadoAtuacao" name="mercadoAtuacao" disabled class="form-control">
                                                    <option disabled selected hidden></option>
                                                    <option value="1">Ambos</option>
                                                   <option value="2">Interno</option>
                                                   <option value="3">Externo</option>
                                                    
                                                </select>
                                            </div>
                                        </div>

                                    </div>
                                    
                                        <div class="col-md-1">    </div>

                                       
                                        <div class="col-md-1">    </div>
                                       
                                        
                                        <div class="form-row">  
                                            <div class="col-md-3">    </div>  
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="areaGeoreferenciada">Área Geo Referenciada</label>
                                                <input disabled class="form-control py-3" id="areaGeoreferenciada" name="areaGeoreferenciada" type="text" placeholder="(ha)" value="" />
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="areaReservaAmbiental">Área de Reserva Ambiental</label>
                                                <input disabled class="form-control py-3" id="areaReservaAmbiental" name="areaReservaAmbiental" type="text" placeholder="(ha)" value="" />
                                            </div>
                                        </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="areaAgricultura">Área de Agricultura</label>
                                                <input disabled class="form-control py-3" id="areaAgricultura" name="areaAgricultura" type="text" placeholder="(ha)" value="" />
                                            </div>
                                        </div>
                                    </div>


                                    <div class="form-row">    
                                        <div class="col-md-3">    </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="areaPecuaria">Área de Pecuária</label>
                                                <input disabled class="form-control py-3" id="areaPecuaria" name="areaPecuaria" type="text" placeholder="(ha)" value="" />
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="latitude">Latitude</label>
                                                <input disabled class="form-control py-3" id="latitude" name="latitude" type="text" placeholder="Latitude" value="" />
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="longitude">Longitude</label>
                                                <input disabled class="form-control py-3" id="longitude" name="longitude" type="text" placeholder="Longitude" value="" />
                                            </div>
                                        </div>
                                        </div>


                                        <div class="form-row"> 
                                            <div class="col-md-3">    </div>   
                                        
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1">CEP<i class="fas fa-search" style="margin-left: 10px;"  onclick="pesquisacep(cep.value);"></i></label>
                                                <input disabled class="form-control py-3" id="cep" name="cep" type="text" onblur="pesquisacep(this.value);" value="" />
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="tipoLogradouro">Tipo de Logradouro</label>
                                                <input disabled class="form-control py-3" disabled id="tipoLogradouro" name="tipoLogradouro" type="text" placeholder="Tipo de Logradouro" value="" />
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="logradouro">Logradouro</label>
                                                <input disabled class="form-control py-3" id="logradouro" name="logradouro" type="text" placeholder="Nome do Logradouro" value="" />
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-row">    
                                        <div class="col-md-3">    </div>
                                        <div class="col-md-1">
                                            <div class="form-group">
                                                <label class="small mb-1" for="numeroEndereco">Número</label>
                                                <input disabled class="form-control py-3" id="numeroEndereco"  name="numeroEndereco" type="text" placeholder="Nº" value="" />
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="complemento">Complemento</label>
                                                <input disabled class="form-control py-3" id="complemento" name="complemento" type="text" placeholder="Ex: Fundos, frente .." value="" />
                                            </div>
                                        </div>


                                        
                                          

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1" for="bairro">Bairro</label>
                                                <input disabled class="form-control py-3" id="bairro"  name="bairro" type="text" placeholder="Bairro" value="" />
                                            </div>
                                        </div>

                                        </div>
                                        <div class="form-row">    
                                            <div class="col-md-3">    </div>
                                             <div class="col-md-3">    
                                                <div class="form-group">
                                                <div class="form-group">
                                                    <label class="small mb-1" for="cidade">Cidade</label>
													<input disabled class="form-control py-3" id="cidade" name="cidade" type="text" placeholder="Cidade" value="" />

                                                </div>
                                                </div>
                                                
                                             </div>
                                      
                                             <div class="col-md-3">    
                                                <div class="form-group">
                                                    <label class="small mb-1" for="estado">Estado</label>
                                                    <select id="estado" disabled name="estado" class="form-control">
													<option disabled selected hidden></option>
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

                                    <div class="form-row">
                                       
                                        <div class="col-md-2">    </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <img style="width:100%;max-width:300px" data-toggle="modal" data-target="#myModal5" src="img/ex-5.jpg"/>
                                            </div>
                                        </div>
                                        <div id="myModal5" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                            <div class="modal-dialog">
                                             
                                                 
                                                      <img src="img/ex-5.jpg" class="img-responsive">
                                                  
                                             
                                            </div>
                                          </div>

                                          <div class="col-md-2">
                                            <div class="form-group">
                                                <img style="width:100%;max-width:300px" data-toggle="modal" data-target="#myModal5" src="img/ex-5.jpg"/>
                                            </div>
                                        </div>
                                        <div id="myModal5" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                            <div class="modal-dialog">
                                             
                                                 
                                                      <img src="img/ex-5.jpg" class="img-responsive">
                                                  
                                             
                                            </div>
                                          </div>

                                          <div class="col-md-2">
                                            <div class="form-group">
                                                <img style="width:100%;max-width:300px" data-toggle="modal" data-target="#myModal5" src="img/ex-5.jpg"/>
                                            </div>
                                        </div>
                                        <div id="myModal5" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                            <div class="modal-dialog">
                                             
                                                 
                                                      <img src="img/ex-5.jpg" class="img-responsive">
                                                  
                                             
                                            </div>
                                          </div>
                                        

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <img style="width:100%;max-width:300px" data-toggle="modal" data-target="#myModal4" src="img/ex-4.jpg"/>
                                            </div>
                                        </div>
                                        <div id="myModal4" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                            <div class="modal-dialog">
                                             
                                                 
                                                      <img src="img/ex-4.jpg" class="img-responsive">
                                                  
                                             
                                            </div>
                                          </div>
                                        </div>
                                        
                                        

                                        </div>

                                     

                                    <div class="form-row">
                                        

                                        <div class="col-md-4">    </div>
                                       
                                        
                                        

                                        <div class="col-md-4">
                                            <label for="customRange1">Status da Validação</label>
                                            <select class="custom-select custom-select-md mb-3">
                                                <option disabled selected hidden>Status</option>
                                                <option value="1">Válido</option>
                                                <option value="2">Inválido</option>
                                                </select>
                                        </div>
                                    
                                             </div>      
                                             
                                             
                                             <div class="form-row">
                                                <div class="col-md-4">    </div>
                                                <div class="col-md-4" style="resize: none;">
                                                <label for="exampleFormControlTextarea1">Justificativa:</label>
                                                <textarea class="form-control" id="exampleFormControlTextarea1" rows="8"></textarea>
                                              </div>
                                             </div>

                                        <div class="col-md-1," style="display : flex; justify-content : center; align-items : center; flex-direction : initial;">
                                        
                                            <div class="form-group mt-4 mb-0"><button class="btn btn-success btn-block" type="submit">Salvar</button></div>
                                            
                                            </div>

                                        
                                
                                </form>

                                <div class="form-row">
                                        

                                    <div class="col-md-5">   <br> </div>
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