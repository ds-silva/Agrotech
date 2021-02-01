<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Resultado Consulta</title>
        <link href="css/styles.css" rel="stylesheet" />     
        <link href="css/dataTables.bootstrap4.min.css" rel="stylesheet" />
       
        
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
                            <li class="breadcrumb-item"><a href="consultar_usu.jsp">Consultar</a></li>
                            <li class="breadcrumb-item"><a href="li_consulta_usu.jsp">Listagem de Consulta</a></li>
                            <li class="breadcrumb-item active">Resultado Consulta</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                
                                <!-- COMEÇO DO FORM -->

                                <form action="resultadoConsUsu" method="post">
                                    <div class="col-md-3">    </div>
                                    <div class="form-row"><div class="col-md-3"></div><h5 class="font-weight-light my-4">Dados do Usuário</h5></div>
                                    <div class="form-row">
                                        
                                        <div class="col-md-3">    </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputFirstName">Nome</label>
                                                <input class="form-control py-3" id="nomeUsuario" name="nomeUsuario" type="text" placeholder="Digite seu Nome" value="" disabled>
                                            </div>
                                        </div>
                                        
                                        

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputLastName">Sobrenome</label>
                                                <input class="form-control py-3" id="sobrenomeUsuario" name="sobrenomeUsuario" type="text" placeholder="Digite seu Sobrenome" value="" disabled/>
                                            </div>
                                        </div>
                                    
                                        
                                    
                                         <div class="col-md-3">    </div>

                                    </div>
                                
                                    <div class="form-row">    
                                        <div class="col-md-3">    </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label class="small mb-1" for="email">Email</label>
                                                <input class="form-control py-3" id="emailUsuario" name="emailUsuario" type="email" placeholder="Digite seu Email" disabled/>
                                            </div>   
                                        </div>

                                        <div class="col-md-2">    
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputLastName">Matrícula</label>
                                                <input class="form-control py-3" id="matriculaUsuario" name="matriculaUsuario" type="text" placeholder="Apenas Números" value="" disabled/>
                                            </div>                                 
                                         </div>
                                         <div class="col-md-3">    </div>
                                    </div>


                                       <div class="form-row">
                                        <div class="col-md-3"></div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputFirstName">Senha</label>
                                                <input class="form-control py-3" id="senha" name="senha" type="password" placeholder="Digite sua Senha" value="" disabled/>
                                            </div>
                                        </div>

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputFirstName">Confirme sua Senha</label>
                                                <input class="form-control py-3" id="confirmaSenha" name="confirmaSenha" type="password" placeholder="Repita sua Senha" value="" disabled/>
                                            </div>
                                        </div>
                                                
                                        <span id='message'></span>

                                    </div>
                                        

                                    <div class="form-row"><div class="col-md-3"></div><h5 class="font-weight-light my-4">Dados Pessoais</h5></div>

                                    <div class="form-row">  
                                        <div class="col-md-3"></div> 
                                        <div class="col-md-2" >
                                            <div class="form-group">                                            
                                                <label class="small mb-1" for="inputState" >Identidade</label>
                                                <select id="naturalizacaoUsuario" name="naturalizacaoUsuario" class="form-control" disabled>
                                                    <option disabled selected hidden></option>
                                                    <option>RG</option>
                                                    <option>RNE</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputLastName">&nbsp</label>
                                                <input class="form-control py-3" id="naturalizacaoDocumento" name="naturalizacaoDocumento" type="text" placeholder="Nº do Documento" value="" disabled/>
                                            </div>
                                        </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputLastName">Órgão Expedidor</label>
                                                <input class="form-control py-3" id="orgaoDocumento" name="orgaoDocumento" type="text" placeholder="" value="" disabled/>
                                            </div>
                                        </div>
                                        <div class="col-md-3"></div> 
                                    </div>


                                    <div class="form-row">    
                                        <div class="col-md-3">    </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="date">Data de Emissão</label>
                                                <input class="form-control py-3" id="emissaoDocumento" name="emissaoDocumento" type="date" placeholder="dd/mm/aaaa" disabled/>
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group" Style="height: 38px;">                                            
                                                <label class="small mb-1" for="inputState" >CPF/CNPJ</label>
                                                <select id="cpfCnpjUsuario" name="cpfCnpjUsuario" class="form-control" disabled>
                                                    <option disabled selected hidden></option>
                                                    <option>CPF</option>
                                                    <option>CNPJ</option>
                                                </select>
                                            </div>
                                        </div>
                                        

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" >Número do Documento</label>
                                                <input class="form-control py-3 "  id="numeroCpfCnpjUsuario" name="numeroCpfCnpjUsuario" type="text" disabled/>
                                            </div>
                                        </div>
                                    </div>
                                        
                                    <div class="form-row"> 
                                        <div class="col-md-3">    </div>   
                                        <div class="col-md-2">
                                            <div class="form-group" Style="height: 38px;">                                            
                                                <label class="small mb-1" for="inputState" >Sexo</label>
                                                <select id="sexo" name="sexo" class="form-control" disabled>
                                                    <option disabled selected hidden></option>
                                                    <option >Masculino</option>
                                                    <option>Feminino</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="date">Data de Nascimento</label>
                                                <input class="form-control py-3" id="nascimentoUsuario" name="nascimentoUsuario" type="date" placeholder="dd/mm/aaaa" disabled/>
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group" Style="height: 38px;">
                                                
                                                <label class="small mb-1" for="inputState" >Tipo de Usuário</label>
                                                <select id="tipoUsuario" name="tipoUsuario" class="form-control" disabled>
                                                    <option disabled selected hidden></option>
                                                    <option>Administrador</option>
                                                    <option>Operador</option>
                                                    <option>Agente</option>
                                                    <option>Proprietário</option>
                                                    <option>Produtor</option>
                                                </select>                                                    
                                            </div>
                                        </div> 
                                    </div>

                                    
                                    <div class="form-row">    
                                        <div class="col-md-3"></div>
                                        <div class="col-md-2">
                                            <div class="form-group">                                            
                                                <label class="small mb-1" for="inputState" >Nacionalidade</label>
                                                <select id="nacionalidadeUsuario" name="nacionalidadeUsuario" class="form-control" disabled>
                                                    <option disabled selected hidden></option>
                                                    <option>Afeganistão</option>
                                                    <option>Albânia</option>
                                                    <option>Argélia</option>
                                                    <option>Andorra</option>
                                                    <option>Angola</option>
                                                    <option>Antígua e Barbuda</option>
                                                    <option>Argentina</option>
                                                    <option>Armênia</option>
                                                    <option>Aruba</option>
                                                    <option>Austrália</option>
                                                    <option>Áustria</option>
                                                    <option>Azerbaijão</option>
                                                    <option>Bahamas</option>
                                                    <option>Bangladesh</option>
                                                    <option>Barbados</option>
                                                    <option> Burundi</option>
                                                    <option> Bélgica</option>
                                                    <option> Benim</option>
                                                    <option> Bermudas</option>
                                                    <option> Butão</option>
                                                    <option> Bósnia e Herzegovina</option>
                                                    <option> Belize</option>
                                                    <option> Bielorussia</option>
                                                    <option> Bolívia</option>
                                                    <option> Botswana</option>
                                                    <option> Brasil</option>
                                                    <option>Bahrein</option>
                                                    <option> Brunei</option>
                                                    <option> Bulgária</option>
                                                    <option> Burkina Faso</option>
                                                    <option> República Centro-Africana</option>
                                                    <option>Camboja</option>
                                                    <option> Canadá</option>
                                                    <option> Ilhas Cayman</option>
                                                    <option> República do Congo</option>
                                                    <option>Chade</option>
                                                    <option> Chile</option>
                                                    <option>China</option>
                                                    <option>Costa do Marfim</option>
                                                    <option>Camarões</option>
                                                    <option>República Democrática do Congo</option>
                                                    <option>Ilhas Cook</option>
                                                    <option>Colômbia</option>
                                                    <option>Comores</option>
                                                    <option>Cabo Verde </option>
                                                    <option>Costa Rica</option>
                                                    <option>Croácia</option>
                                                    <option>Cuba</option>
                                                    <option>Chipre</option>
                                                    <option>Chéquia</option>
                                                    <option>Dinamarca</option>
                                                    <option>Djibouti</option>
                                                    <option>Dominica</option>
                                                    <option>República Dominicana</option>
                                                    <option>Equador</option>
                                                    <option>Egito</option>
                                                    <option>Eritreia</option>
                                                    <option>El Salvador</option>
                                                    <option>Espanha</option>
                                                    <option>Estónia</option>
                                                    <option>Etiópia</option>
                                                    <option>Fiji</option>
                                                    <option>Finlândia</option>
                                                    <option>França</option>
                                                    <option>Estados Federados da Micronésia</option>
                                                    <option>Gabão</option>
                                                    <option>Gâmbia</option>
                                                    <option>Reino Unido</option>
                                                    <option>Inglaterra</option>
                                                    <option>Irlanda do Norte</option>
                                                    <option>Escócia</option>
                                                    <option>Países de Gales</option>
                                                    <option>Guiné-Bissau</option>
                                                    <option>Geórgia</option>
                                                    <option>Guiné Equatorial</option>
                                                    <option>Alemanha</option>
                                                    <option>Gana</option>
                                                    <option>Grécia</option>
                                                    <option>Granada</option>
                                                    <option>Guatemala</option>
                                                    <option>Guiné</option>
                                                    <option>Guam</option>
                                                    <option>Guiana</option>
                                                    <option>Haiti</option>
                                                    <option>Hong Kong</option>
                                                    <option>Honduras</option>
                                                    <option>Hungria</option>
                                                    <option>Indonésia</option>
                                                    <option>Índia</option>
                                                    <option>Irão</option>
                                                    <option>Irlanda</option>
                                                    <option>Iraque</option>
                                                    <option>Islândia</option>
                                                    <option>Israel</option>
                                                    <option>Ilhas Virgens Americanas</option>
                                                    <option>Itália</option>
                                                    <option>Ilhas Virgens Britânicas</option>
                                                    <option>Jamaica</option>
                                                    <option>Jordânia</option>
                                                    <option>Japão</option>
                                                    <option>Cazaquistão</option>
                                                    <option>Quênia</option>
                                                    <option>Quirguistão</option>
                                                    <option>Kiribati</option>
                                                    <option>Coreia do Sul</option>
                                                    <option>Kosovo</option>
                                                    <option>Arábia Saudita</option>
                                                    <option>Kuwait</option>
                                                    <option>Laos</option>
                                                    <option>Nova Zelândia</option>
                                                    <option>Omã</option>
                                                    <option>Paquistão</option>
                                                    <option>Panamá</option>
                                                    <option>Paraguai</option>
                                                    <option>Peru</option>
                                                    <option>Filipinas</option>
                                                    <option>Palestina</option>
                                                    <option>Palau</option>
                                                    <option>Papua-Nova Guiné</option>
                                                    <option>Polónia</option>
                                                    <option>Portugal</option>
                                                    <option>Coreia do Norte</option>
                                                    <option>Porto Rico</option>
                                                    <option>Catar</option>
                                                    <option>Roménia</option>
                                                    <option>África do Sul</option>
                                                    <option>Sudão</option>
                                                    <option>Suíça</option>
                                                    <option>Suriname</option>
                                                    <option>Eslováquia</option>
                                                    <option>Suécia</option>
                                                    <option>Essuatíni</option>
                                                    <option>Síria</option>
                                                    <option>Tanzânia</option>
                                                    <option>Tonga</option>
                                                    <option>Tailândia</option>
                                                    <option>Tajiquistão</option>
                                                    <option>Uruguai</option>
                                                    <option>Estados Unidos</option>
                                                    <option>Venezuela</option>
                                                    </select>
                                            </div>
                                        </div> 
                                        
                                        <div class="col-md-2">
                                            <div class="form-group" >                                            
                                                <label class="small mb-1" for="inputState">Órgão Funcional</label>
                                                <select id="orgaoFuncional" name="orgaoFuncional" class="form-control" disabled>
                                                    <option disabled selected hidden></option>
                                                    <option>INCRA</option>
                                                    <option>MAPA</option>
                                                    <option>IBAMA</option>
                                                    <option>IBGE</option>
                                                    <option>RECEITA FEDERAL</option>
                                                    <option>MINISTÉRIO DA AGRICULTURA</option>
                                                    </select>
                                            </div>
                                        </div> 
                                       
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputLastName">Regional</label>
                                                <input class="form-control py-3" id="regional" name="regional" type="text" placeholder="Regional" disabled/>
                                            </div>
                                        </div>

                                    </div>


                                    <div class="form-row"><div class="col-md-3"></div><h5 class="font-weight-light my-4">Contatos</h5></div>

                                    <div class="form-row">

                                        <div class="col-md-3">    </div>

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-2 " >Tipo de Telefone</label>
                                                <select id="tipoTelefone1" name="tipoTelefone1" class="form-control" onchange="telefoneMask1()"disabled>
                                                    <option disabled selected hidden> </option>
                                                    <option value="celular">Celular</option>
                                                    <option value="residencial">Residencial</option>
                                                   

                                                </select>
                                            </div>
                                        </div>

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1.1" for="inputLastName">Telefone</label>
                                                <input class="telefone1 form-control py-3" id="telefone1" name="telefone1" type="text" placeholder="Telefone"disabled/>
                                            </div>
                                        </div>


                                    </div>
                                       
                                    <div class="form-row">

                                        <div class="col-md-3">    </div>

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-2 " >Tipo de Telefone</label>
                                                <select id="tipoTelefone2" name="tipoTelefone2" class="form-control" onchange="telefoneMask2()"disabled>
                                                    <option disabled selected hidden> </option>
                                                    <option value="celular">Celular</option>
                                                    <option value="residencial">Residencial</option>
                                                   

                                                </select>
                                            </div>
                                        </div>

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1.1" for="inputLastName">Telefone</label>
                                                <input class="telefone2 form-control py-3" id="telefone2" name="telefone2" type="text" placeholder="Telefone" disabled/>
                                            </div>
                                        </div>


                                    </div>
                                    
                                    <div class="form-row">

                                        <div class="col-md-3">    </div>

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-2 " >Tipo de Telefone</label>
                                                <select id="tipoTelefone3" name="tipoTelefone3" class="form-control" onchange="telefoneMask3()" disabled>
                                                    <option disabled selected hidden> </option>
                                                    <option value="celular">Celular</option>
                                                    <option value="residencial">Residencial</option>
                                                   

                                                </select>
                                            </div>
                                        </div>

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1.1" for="inputLastName">Telefone</label>
                                                <input class="telefone3 form-control py-3" id="telefone3" name="telefone3" type="text" placeholder="Telefone" disabled/>
                                            </div>
                                        </div>


                                    </div>

                                    <div class="form-row">

                                        <div class="col-md-3">    </div>

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-2 " >Tipo de Telefone</label>
                                                <select id="tipoTelefone4" name="tipoTelefone4" class="form-control" onchange="telefoneMask4()" disabled>
                                                    <option disabled selected hidden> </option>
                                                    <option value="celular">Celular</option>
                                                    <option value="residencial">Residencial</option>
                                                   

                                                </select>
                                            </div>
                                        </div>

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1.1" for="inputLastName">Telefone</label>
                                                <input class="telefone4 form-control py-3" id="telefone4" name="telefone4" type="text" placeholder="Telefone"disabled/>
                                            </div>
                                        </div>


                                    </div>

                                    <div class="form-row">
                                        <div class="col-md-3">    </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1">CEP<i class="fas fa-search" style="margin-left: 10px;"  onclick="pesquisacep(cep.value);"></i></label>
                                                <input class="form-control py-3" id="cep" name="cep" type="text" onblur="pesquisacep(this.value);" disabled/>
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputLastName">Tipo de Logradouro</label>
                                                <input class="form-control py-3" id="tipoLogradouro" name="tipoLogradouro" type="text" placeholder="Tipo de Logradouro" disabled/>
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputLastName">Logradouro</label>
                                                <input class="form-control py-3" id="logradouro" name="logradouro" type="text" placeholder="Nome do Logradouro" disabled/>
                                            </div>
                                        </div>
                                                    
                                    </div>

                                    <div class="form-row">
                                        

                                        <div class="col-md-3">    </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputLastName">Número</label>
                                                <input class="form-control py-3" id="numeroEndereco" name="numeroEndereco" type="text" placeholder="Nº do Local" disabled/>
                                            </div>
                                        </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputFirstName">Complemento</label>
                                                <input class="form-control py-3" id="complemento" name="complemento" type="text" placeholder="Complemento" value="" disabled/>
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputFirstName">Bairro</label>
                                                <input class="form-control py-3" id="bairro" name="bairro" type="text" placeholder="Bairro" value="" disabled/>
                                            </div>
                                        </div>

                                         
                                    </div>
                                    <div class="form-row">    
                                        <div class="col-md-3">    </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputFirstName">Cidade</label>
                                                <input class="form-control py-3" id="cidade" name="cidade" type="text" placeholder="Cidade" value="" disabled/>
                                            </div>
                                        </div>
                                    

                                        <div class="col-md-2">
                                            <label class="small mb-1" for="inputState">Estado</label>
                                            <select id="estado" name="estado" class="form-control" disabled>
                                                <option disabled selected hidden></option>
                                                <option >Acre</option>
                                                <option>Alagoas</option>
                                                <option>Amapá</option>
                                                <option>Amazonas</option>
                                                <option>Bahia</option>
                                                <option>Ceará</option>
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

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" >UF</label>
                                                <select id="uf" name="uf" class="form-control" disabled>
                                                    <option disabled selected hidden></option>
                                                    <option >AC</option>
                                                    <option >AL</option>
                                                    <option >AP</option>
                                                    <option>AM</option>
                                                    <option>BA</option>
                                                    <option>CE</option>
                                                    <option>DF</option>
                                                    <option>ES</option>
                                                    <option>GO</option>
                                                    <option>MA</option>
                                                    <option>MT</option>
                                                    <option>MS</option>
                                                    <option>MG</option>
                                                    <option>PA</option>
                                                    <option>PB</option>
                                                    <option>PR</option>
                                                    <option>PE</option>
                                                    <option>PI</option>
                                                    <option>RJ</option>
                                                    <option>RN</option>
                                                    <option>RS</option>
                                                    <option>RO</option>
                                                    <option>RR</option>
                                                    <option>SC</option>
                                                    <option>SP</option>
                                                    <option>SE</option>
                                                    <option>TO</option>

                                                </select>
                                            </div>
                                        </div>

                                    </div>

                                        
                                    <!-- INICIO BOTOES -->
                                                           
                                    <div class="form-row">
                                        <div class="col-md-3"></div>

                                        
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <div class="form-group mt-4 mb-0"><button class="btn btn-warning btn-block text-light" type="submit">Alterar</button></div>
                                            </div>
                                        </div>


                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <div class="form-group mt-4 mb-0" class="col-md-2"><a href="#DisableEmployeeModal" data-toggle="modal"><button class="btn btn-info btn-block" type="submit">Desabilitar</button></a></div>
                                            </div>
                                        </div>


                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <div class="form-group mt-4 mb-0" class="col-md-2"><a href="#deleteEmployeeModal"  data-toggle="modal"><button class="btn btn-danger btn-block" type="submit">Excluir</button></a></div>
                                            </div>
                                        </div>

                                    </div>
                                        
                                    <!-- FINAL BOTOES -->

                                <!-- Delete Modal html -->
                                <div id="deleteEmployeeModal" class="modal fade">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <form>
                                                <div class="modal-header">						
                                                    <h4 class="modal-title">Excluir Usuário</h4>
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                </div>
                                                <div class="modal-body">					
                                                    <p>Tem certeza que deseja <strong>apagar</strong> esse usuário?</p>
                                                    <p class="text-warning"><small>Essa ação não poderá ser desfeita.</small></p>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">Cancelar</button>
                                                    <button type="submit" class="btn btn-danger" value="Excluir" >Excluir</button>
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
                                                        <h4 class="modal-title">Desabilitar Usuário</h4>
                                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                    </div>
                                                    <div class="modal-body">					
                                                        <p>Tem certeza que deseja <strong>desabilitar</strong> esse usuário?</p>
                                                        </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">Cancelar</button>
                                                        <button type="submit" class="btn btn-danger" value="Desabilitar" >Desabilitar</button>
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

                <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>
                <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
                <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
                <script src="js/scripts.js"></script>
                <script src="js/resilia.js"></script>
                <script src="js/jquery.mask.min.js"></script>
                

                <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
                <script src="assets/demo/datatables-demo.js"></script>
                <script src="js/jquery.mask.min.js"></script>
                <script type="text/javascript" src="js/buscadorcep.js"></script>


                
            </body>
        </html>