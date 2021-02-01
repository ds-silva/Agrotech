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
        <title>Alterar Imóvel Rural</title>
        <link rel="icon" href="/agrotech/favicon.ico">
        <link href="css/styles.css" rel="stylesheet" />
        <link href="css/dataTables.bootstrap4.min.css" rel="stylesheet" />
       
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

        <script>
            $(document).ready(function () {
                $("#salvarAlteracoes").click(function () {
                    event.preventDefault();
                    
                    var idImovelRural = $("#idImovelRural").val();
                    var cadastrarNumeroIR = $("#numeroIR").val();
                    var cadastrarNirf = $("#nirf").val();
                    var cadastrarSituacaoIR = $("#situacaoIR").val();
                    var cadastrarTipoPropriedade = $("#tipoPropriedade").val();
                    var cadastrarTipoOcupacao = $("#tipoOcupacao").val();
                    var cadastrarMercadoAtuacao = $("#mercadoAtuacao").val();
                    var cadastrarAGR = $("#areaGeoreferenciada").val();
                    var cadastrarARA = $("#areaReservaAmbiental").val();
                    var cadastrarAreaAgricultura = $("#areaAgricultura").val();
                    var cadastrarAreaPecuaria = $("#areaPecuaria").val();
                    var cadastrarLatitude = $("#latitude").val();
                    var cadastrarLongitude = $("#longitude").val();
                    var cadastrarCep = $("#cep").val();
                    var cadastrarTipoLogradouro = $("#tipoLogradouro").val();
                    var cadastrarLogradouro = $("#logradouro").val();
                    var cadastrarNumeroEndereco = $("#numeroEndereco").val();
                    var cadastrarComplemento = $("#complemento").val();
                    var cadastrarBairro = $("#bairro").val();
                    var cadastrarCidade = $("#cidade").val();
                    var cadastrarEstado = $("#estado").val();
                    var idEndereco = $("#idEndereco").val();
//                 
                    $.ajax (
                        {
                           url: "alterarImovelRuralResultado?" +
                           "idImovelRural=" + idImovelRural +
                           "&numeroIR=" + cadastrarNumeroIR+
                           "&nirf="+ cadastrarNirf +
                           "&situacaoIR="+cadastrarSituacaoIR+
                           "&tipoPropriedade="+cadastrarTipoPropriedade+
                           "&tipoOcupacao="+cadastrarTipoOcupacao+
                           "&mercadoAtuacao="+cadastrarMercadoAtuacao+
                           "&areaGeoreferenciada="+cadastrarAGR+
                           "&areaReservaAmbiental="+cadastrarARA+
                           "&areaAgricultura="+cadastrarAreaAgricultura+
                           "&areaPecuaria="+cadastrarAreaPecuaria+
                           "&latitude="+cadastrarLatitude+
                           "&longitude="+cadastrarLongitude+
                           "&cep="+cadastrarCep+
                           "&tipoLogradouro="+cadastrarTipoLogradouro+
                           "&logradouro="+cadastrarLogradouro+
                           "&numeroEndereco="+cadastrarNumeroEndereco+
                           "&complemento="+cadastrarComplemento+
                           "&bairro="+cadastrarBairro+
                           "&cidade="+cadastrarCidade+
                           "&estado="+cadastrarEstado+
                           "&idEndereco="+ idEndereco,
                            contentType: "charset=UTF-8",
                            success: function(retorno){
                                if (retorno.trim()=="ok") {
                                    //sucesso
                                    location.replace("mensagem_alterar.jsp");
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

    </head>
    <body>
        <%@include file="menu.jsp" %>
            <!-- Fim do menu da esquerda -->
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">Alterar Imóvel Rural</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="dashboard.jsp">Dashboard</a></li>
                            <li class="breadcrumb-item"><a href="consultar_ir.jsp">Consultar Imóvel Rural</a></li>
                            <li class="breadcrumb-item"><a href="li_consulta_ir.jsp">Listagem de Consulta</a></li>
                            <li class="breadcrumb-item"><a href="resultado_cons_ir.jsp">Resultado Consulta</a></li>
                            <li class="breadcrumb-item active">Alterar Imóvel Rural</li>
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
                                                <%
                                                    ImovelRural imvR = (ImovelRural) request.getAttribute("ir");
                                                %>
                                                <input class="form-control py-3" id="idImovelRural" name="idImovelRural" type="hidden" placeholder="" value="<%=imvR.getIdImovelRural()%>" disabled/>
                                                <input class="form-control py-3" id="idEndereco" name="idEndereco" type="hidden" placeholder="" value="<%=imvR.getEndereco().getIdEndereco()%>" disabled/>
                                                <input class="form-control py-3" id="numeroIR" name="numeroIR" type="text" placeholder="Digite a inscrição" value="<%=imvR.getnInscricaoEstadual()%>" />
                                            </div>
                                        </div>
                                        
                                        

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="nirf">NIRF</label>
                                                <input class="form-control py-3" id="nirf" name="nirf" type="text" placeholder="Digite o NIRF" value="<%=imvR.getNirf()%>" />
                                            </div>
                                        </div>
                                    
                                        
                                    
                                        <div class="col-md-2">    
                                            <div  class="form-group">
                                                <label class="small mb-1" for="situacaoIR">Situação do Imóvel Rural</label>
                                                <select id="situacaoIR" name="situacaoIR" class="form-control " >
                                                    <option value="<%=imvR.getIdSituacaoImovelRural() %>"><%=imvR.getSituacaoImovel()%></option>
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
                                                    <option value="<%=imvR.getTipoPropriedade()%>"><%=imvR.getTipoPropriedade()%></option>
                                                    <option value="comprada">Comprada</option>
                                                    <option value="herdada">Herdada</option>
                                                
                                                    
                                                </select>
                                            </div>
                                            
                                         </div>
                                  
                                         <div class="col-md-2">    
                                            <div class="form-group">
                                                <label class="small mb-1" for="tipoOcupacao">Tipo de Ocupação</label>
                                                <select id="tipoOcupacao" name="tipoOcupacao" class="form-control">
                                                    <option value="<%=imvR.getTipoOcupacao()%>"><%=imvR.getTipoOcupacao()%></option>
                                                    <option value="propria">Própria</option>
                                                    <option value="arrendada">Arrendada</option>
                                                    
                                                </select>
                                            </div>
                                        </div>
                                       
                                        <div class="col-md-2">    
                                            <div class="form-group">
                                                <label class="small mb-1" for="mercadoAtuacao">Mercado de Atuação</label>
                                                <select id="mercadoAtuacao" name="mercadoAtuacao" class="form-control">
                                                    <option value="<%=imvR.getMercadoAtuacao()%>"><%=imvR.getMercadoAtuacao()%></option>
                                                    <option value="ambos">ambos</option>
                                                    <option value="interno">interno</option>
                                                    <option value="externo">externo</option>
                                                    
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
                                                <input class="form-control py-3" id="areaGeoreferenciada" name="areaGeoreferenciada" type="text" placeholder="(ha)" value="<%=imvR.getAreaGeoreferenciada() %>"/>
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="areaReservaAmbiental">Área de Reserva Ambiental</label>
                                                <input class="form-control py-3" id="areaReservaAmbiental" name="areaReservaAmbiental" type="text" placeholder="(ha)" value="<%=imvR.getAreaReservaAmbiental()%>" />
                                            </div>
                                        </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="areaAgricultura">Área de Agricultura</label>
                                                <input class="form-control py-3" id="areaAgricultura" name="areaAgricultura" type="text" placeholder="(ha)" value="<%=imvR.getAreaUtilizacaoAgricultura()%>" />
                                            </div>
                                        </div>
                                    </div>


                                    <div class="form-row">    
                                        <div class="col-md-3">    </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="areaPecuaria">Área de Pecuária</label>
                                                <input class="form-control py-3" id="areaPecuaria" name="areaPecuaria" type="text" placeholder="(ha)" value="<%=imvR.getAreaUtilizacaoPecuaria()%>"/>
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="latitude">Latitude</label>
                                                <input class="form-control py-3" id="latitude" name="latitude" type="text" placeholder="Latitude" value="<%=imvR.getLatitude()%>"/>
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="longitude">Longitude</label>
                                                <input class="form-control py-3" id="longitude" name="longitude" type="text" placeholder="Longitude" value="<%=imvR.getLongitude()%>"/>
                                            </div>
                                        </div>
                                        </div>


                                        <div class="form-row"> 
                                            <div class="col-md-3">    </div>   
                                        
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="cep">CEP<i class="fas fa-search" style="margin-left: 10px;"  onclick="pesquisacep(cep.value);"></i></label>
                                                <input class="form-control py-3" id="cep" name="cep" type="text" onblur="pesquisacep(this.value);" value="<%=imvR.getEndereco().getCep() %>" placeholder="Digite o CEP"/>
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="tipoLogradouro">Tipo de Logradouro</label>
                                                <input class="form-control py-3" id="tipoLogradouro" name="tipoLogradouro" type="text" placeholder="Tipo de logradouro" value="<%=imvR.getEndereco().getTipoLogradouro()%>" />
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="logradouro">Logradouro</label>
                                                <input class="form-control py-3" id="logradouro" name="logradouro" type="text" placeholder="Nome do logradouro" value="<%=imvR.getEndereco().getLogradouro()%>"/>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-row">    
                                        <div class="col-md-3">    </div>
                                        <div class="col-md-1">
                                            <div class="form-group">
                                                <label class="small mb-1" for="numeroEndereco">Número</label>
                                                <input class="form-control py-3" id="numeroEndereco"  name="numeroEndereco" type="text" placeholder="Nº" value="<%=imvR.getEndereco().getNumero()%>" />
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="complemento">Complemento</label>
                                                <input class="form-control py-3" id="complemento" name="complemento" type="text" placeholder="Ex: fundos, frente, etc" value="<%=imvR.getEndereco().getComplemento()%>"/>
                                            </div>
                                        </div>


                                        
                                          

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1" for="bairro">Bairro</label>
                                                <input class="form-control py-3" id="bairro"  name="bairro" type="text" placeholder="Bairro" value="<%=imvR.getEndereco().getBairro()%>"/>
                                            </div>
                                        </div>

                                        </div>
                                        <div class="form-row">    
                                            <div class="col-md-3">    </div>
                                             <div class="col-md-3">    
                                                <div class="form-group">
                                                <div class="form-group">
                                                    <label class="small mb-1" for="cidade">Cidade</label>
													<input class="form-control py-3" id="cidade" name="cidade" type="text" placeholder="Cidade" value="<%=imvR.getEndereco().getCidade()%>" />

                                                </div>
                                                </div>
                                                
                                             </div>
                                      
                                             <div class="col-md-3">    
                                                <div class="form-group">
                                                    <label class="small mb-1" for="estado">Estado</label>
                                                    <select id="estado" name="estado" class="form-control">
                                                        <option value="<%=imvR.getEndereco().getEstado().getIdEstado()%>"><%=imvR.getEndereco().getEstado().getDescricaoEstado()%></option>
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
                                                                                                             
                                        <div>
                                            
                                            <h6 class="text-justify lead text-center" style="font-size: 13px; font-weight: bolder;"><br>INSIRA FOTO/PDF DOS SEGUINTES DOCUMENTOS:<br><br></h6>

                                            <div class="form-group col-md-4 offset-md-3">
                                                <label for="validarPing">Planta do Imóvel Georreferenciada</label>
                                                <input type="file" class="form-control-file" id="validarPing" name="validarPing">
                                            </div>

                                            <div class="form-group col-md-4 offset-md-3">
                                                <label for="validarNirf">NIRF</label>
                                                <input type="file" class="form-control-file" id="validarNirf" name="validarNirf">
                                            </div>

                                            <div class="form-group col-md-7 offset-md-3">
                                                <label for="validarItr">ITR (Atualizado em nome do proprietário atual ou nome da empresa atual)</label>
                                                <input type="file" class="form-control-file" id="validarItr" name="validarItr">
                                            </div>

                                            <div class="form-group col-md-4 offset-md-3">
                                                <label for="validarRgCpfArrendatario">Cópia do RG e CPF do arrendatário</label>
                                                <span data-toggle="tooltip" data-placement="right" title="Em caso de arrendamento da propriedade será necessário anexar cópia do contrato de arrendamento autenticado bem como cópia do RG e CPF do arrendatário.">[&#63;]</span>
                                                <input type="file" class="form-control-file" id="validarRgCpfArrendatario" name="validarRgCpfArrendatario">
                                            </div>

                                       </div>
                                                
                                                                              
                                       <div class="col-md-1," style="display : flex; justify-content : center; align-items : center; flex-direction : initial;">
                                            
                                        <div class="form-group mt-4 mb-0"><button class="btn btn-success btn-block" id="salvarAlteracoes">Salvar Alterações</button></div>
                                        
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
                    
            </body>
        </html>