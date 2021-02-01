<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Consultar</title>
        <link href="css/styles.css" rel="stylesheet" />     
        <link href="css/dataTables.bootstrap4.min.css" rel="stylesheet" />
       
        
    </head>
    <body>
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <a class="navbar-brand" href="dashboard.jsp">AGROTECH</a><button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#"><i class="fas fa-bars"></i></button
            ><!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Pesquisar" aria-label="Search" aria-describedby="basic-addon2" />
                    <div class="input-group-append">
                        <button class="btn btn-primary" type="button"><i class="fas fa-search"></i></button>
                    </div>
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ml-auto ml-md-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="meu_perfil.jsp">Meu Perfil</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="login.jsp">Sair</a>
                    </div>
                </li>
            </ul>
        </nav>
       <!-- Começo do menu da esquerda -->
       <div id="layoutSidenav">
        <div id="layoutSidenav_nav">
            <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                <div class="sb-sidenav-menu">
                    <div class="nav">
                        <div class="sb-sidenav-menu-heading">Início</div>
                        <a class="nav-link" href="dashboard.jsp"
                            ><div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                            Dashboard</a
                        >
                        <a class="nav-link" href="meu_perfil.jsp"
                                ><div class="sb-nav-link-icon"><i class="fas fa-user fa-fw"></i></div>
                                Meu Perfil</a
                            >
                        <div class="sb-sidenav-menu-heading">Menu Principal</div>
                      
                            <!--Inicio do submenu de usuário-->

                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages"
                            ><div class="sb-nav-link-icon"><i class=""></i></div>
                            Controle de Usuários
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div
                        ></a>
                        <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-parent="#sidenavAccordion">
                            <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                            
                                

                                <!--Começo dos Usuários-->

                                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                                    Administrador
                                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                </a>
                                <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                    <nav class="sb-sidenav-menu-nested nav">
                                        <a class="nav-link" href="cadastrar_usu.jsp">Cadastrar Administrador</a>
                                        <a class="nav-link" href="alterar_usu.jsp">Alterar Administrador</a>
                                        <a class="nav-link" href="consultar_usu.jsp">Consultar Administrador</a>
                                        <a class="nav-link" href="listar_usu.jsp">Listar Administrador</a>
                                </nav>                                
                                </div>
                                

                                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError2" aria-expanded="false" aria-controls="pagesCollapseError2">
                                Operador de Sistema
                                  <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                </a>
                                    <div class="collapse" id="pagesCollapseError2" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="cadastrar_usu.jsp">Cadastrar Operador de Sistema</a>
                                            <a class="nav-link" href="alterar_usu.jsp.jsp">Alterar Operador de Sistema</a>
                                            <a class="nav-link" href="consultar_usu.jsp">Consultar Operador de Sistema</a>
                                            <a class="nav-link" href="listar_usu.jsp">Listar Operador de Sistema</a>
                                        </nav>
                                    </div>
                                



                                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError3" aria-expanded="false" aria-controls="pagesCollapseError3">
                                    Agente
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                        <div class="collapse" id="pagesCollapseError3" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                            <nav class="sb-sidenav-menu-nested nav">
                                                <a class="nav-link" href="cadastrar_usu.jsp">Cadastrar Agente</a>
                                                <a class="nav-link" href="alterar_usu.jsp">Alterar Agente</a>
                                                <a class="nav-link" href="consultar_usu.jsp">Consultar Agente</a>
                                                <a class="nav-link" href="listar_usu.jsp">Listar Agente</a>
                                            </nav>
                                        </div>



                                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError4" aria-expanded="false" aria-controls="pagesCollapseError4">
                                    Proprietário
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                        <div class="collapse" id="pagesCollapseError4" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                            <nav class="sb-sidenav-menu-nested nav">
                                                <a class="nav-link" href="cadastrar_usu.jsp">Cadastrar Proprietário</a>
                                                <a class="nav-link" href="alterar_usu.jsp">Alterar Proprietário</a>
                                                <a class="nav-link" href="consultar_usu.jsp">Consultar Proprietário</a>
                                                <a class="nav-link" href="listar_usu.jsp">Listar Proprietário</a>
                                            </nav>
                                        </div>


                                
                                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError5" aria-expanded="false" aria-controls="pagesCollapseError5">
                                    Produtor
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                        <div class="collapse" id="pagesCollapseError5" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                            <nav class="sb-sidenav-menu-nested nav">
                                                <a class="nav-link" href="cadastrar_usu.jsp">Cadastrar Produtor</a>
                                                <a class="nav-link" href="alterar_usu.jsp">Alterar Produtor</a>
                                                <a class="nav-link" href="consultar_usu.jsp">Consultar Produtor</a>
                                                <a class="nav-link" href="listar_usu.jsp">Listar Produtor</a>
                                            </nav>
                                        </div>


                            </nav>
                        </div>

                            <!--Começo dos Negócio-->



                        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages2" aria-expanded="false" aria-controls="collapsePages"
                            ><div class="sb-nav-link-icon"><i class=""></i></div>
                            Controle de Negócios
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div
                        ></a>
                        <div class="collapse" id="collapsePages2" aria-labelledby="headingTwo" data-parent="#sidenavAccordion">
                            <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                            
                                
                                <!--Começo das sessões de Pagina-->

                                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError6" aria-expanded="false" aria-controls="pagesCollapseError6">
                                    Imóvel Rural
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                        <div class="collapse" id="pagesCollapseError6" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                            <nav class="sb-sidenav-menu-nested nav">
                                                <a class="nav-link" href="cadastrar_ir.jsp">Cadastrar Imóvel Rural</a>
                                                <a class="nav-link" href="alterar_ir.jsp">Alterar Imóvel Rural</a>
                                                <a class="nav-link" href="consultar_ir.jsp">Consultar Imóvel Rural</a>
                                                <a class="nav-link" href="listar_ir.jsp">Listar Imóvel Rural</a>
                                            </nav>
                                        </div>

                                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError7" aria-expanded="false" aria-controls="pagesCollapseError7">
                                        Produtos
                                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                        </a>
                                            <div class="collapse" id="pagesCollapseError7" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                                <nav class="sb-sidenav-menu-nested nav">
                                                    <a class="nav-link" href="cadastrar_produto.jsp">Cadastrar Produtos</a>
                                                    <a class="nav-link" href="alterar_produto.jsp">Alterar Produtos</a>
                                                    <a class="nav-link" href="consultar_produto.jsp">Consultar Produtos</a>
                                                    <a class="nav-link" href="listar_tipo_produto.jsp">Listar Produtos</a>
                                                </nav>
                                            </div>

                                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError8" aria-expanded="false" aria-controls="pagesCollapseError8">
                                        Regional
                                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                        </a>
                                            <div class="collapse" id="pagesCollapseError8" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                                <nav class="sb-sidenav-menu-nested nav">
                                                    <a class="nav-link" href="cadastrar_regional.jsp">Cadastrar Regional</a>
                                                    <a class="nav-link" href="alterar_regional.jsp">Alterar Regional</a>
                                                    <a class="nav-link" href="consultar_regional.jsp">Consultar Regional</a>
                                                    <a class="nav-link" href="listar_regional.jsp">Listar Regional</a>
                                                </nav>
                                            </div>

                            </nav>
                        </div>
                        



                        <!--Começo do controle de Sistema-->

                        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages3" aria-expanded="false" aria-controls="collapsePages"
                        ><div class="sb-nav-link-icon"><i class=""></i></div>
                        Controle de Sistema
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div
                        ></a>
                        <div class="collapse" id="collapsePages3" aria-labelledby="headingTwo" data-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                        


                            
                            <!--Começo das sessões de Pagina-->
                        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError9" aria-expanded="false" aria-controls="pagesCollapseError9">
                            Descrição de Produto
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                            <div class="collapse" id="pagesCollapseError9" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cadastrar_desc_produto.jsp">Cadastrar Descrição de Produto</a>
                                    <a class="nav-link" href="alterar_desc_produto.jsp">Alterar Descrição de Produto</a>
                                    <a class="nav-link" href="consultar_desc_produto.jsp">Consultar Descrição de Produto</a>
                                    <a class="nav-link" href="listar_desc_produto.jsp">Listar Descrição de Produto</a>
                                </nav>
                            </div>

                        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError10" aria-expanded="false" aria-controls="pagesCollapseError10">
                            Estado
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                            <div class="collapse" id="pagesCollapseError10" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cadastrar_estado.jsp">Cadastrar Estado</a>
                                    <a class="nav-link" href="alterar_estado.jsp">Alterar Estado</a>
                                    <a class="nav-link" href="consultar_estado.jsp">Consultar Estado</a>
                                    <a class="nav-link" href="listar_estado.jsp">Listar Estado</a>
                                </nav>
                            </div>

                        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError11" aria-expanded="false" aria-controls="pagesCollapseError11">
                            Nacionalidade
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                            <div class="collapse" id="pagesCollapseError11" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cadastrar_nac.jsp">Cadastrar Nacionalidade</a>
                                    <a class="nav-link" href="alterar_nac.jsp">Alterar Nacionalidade</a>
                                    <a class="nav-link" href="consultar_nac.jsp">Consultar Nacionalidade</a>
                                    <a class="nav-link" href="listar_nac.jsp">Listar Nacionalidade</a>
                                </nav>
                            </div>


                        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError12" aria-expanded="false" aria-controls="pagesCollapseError12">
                            Órgãos Funcionais
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                            <div class="collapse" id="pagesCollapseError12" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cadastrar_og.jsp">Cadastrar Órgãos Funcionais</a>
                                    <a class="nav-link" href="alterar_desc_produto.jsp">Alterar Órgãos Funcionais</a>
                                    <a class="nav-link" href="consultar_og.jsp">Consultar Órgãos Funcionais</a>
                                    <a class="nav-link" href="listar_og.jsp">Listar Órgãos Funcionais</a>
                                </nav>
                            </div>

                        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError13" aria-expanded="false" aria-controls="pagesCollapseError13">
                            Regional
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                            <div class="collapse" id="pagesCollapseError13" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cadastrar_regional.jsp">Cadastrar Regional</a>
                                    <a class="nav-link" href="alterar_regional.jsp">Alterar Regional</a>
                                    <a class="nav-link" href="consultar_regional.jsp">Consultar Regional</a>
                                    <a class="nav-link" href="listar_regional.jsp">Listar Regional</a>
                                </nav>
                            </div>

                        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError14" aria-expanded="false" aria-controls="pagesCollapseError14">
                            Situação de Usuário
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                            <div class="collapse" id="pagesCollapseError14" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cadastrar_sit.jsp.jsp">Cadastrar Situação do Usuário</a>
                                    <a class="nav-link" href="alterar_sit.jsp">Alterar Situação do Usuário</a>
                                    <a class="nav-link" href="consultar_sit.jsp">Consultar Situação do Usuário</a>
                                    <a class="nav-link" href="listar_sit.jsp">Listar Situação do Usuário</a>
                                </nav>
                            </div>

                        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError15" aria-expanded="false" aria-controls="pagesCollapseError15">
                            Tipo de Produto
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                            <div class="collapse" id="pagesCollapseError15" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cadastrar_tipo_produto.jsp">Cadastrar Tipo de Produto</a>
                                    <a class="nav-link" href="alterar_tipo_produto.jsp">Alterar Tipo de Produto</a>
                                    <a class="nav-link" href="consultar_tipo_producao.jsp">Consultar Tipo de Produto</a>
                                    <a class="nav-link" href="listar_tipo_producao.jsp">Listar Tipo de Produto</a>
                                </nav>
                            </div>

                        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError16" aria-expanded="false" aria-controls="pagesCollapseError16">
                            Tipo de Telefone
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                            <div class="collapse" id="pagesCollapseError16" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cadastrar_tipo_tel.jsp">Cadastrar Tipo de Telefone</a>
                                    <a class="nav-link" href="alterar_tipo_tel.jsp">Alterar Tipo de Telefone</a>
                                    <a class="nav-link" href="consultar_tipo_tel.jsp">Consultar Tipo de Telefone</a>
                                    <a class="nav-link" href="listar_tipo_tel.jsp">Listar Tipo de Telefone</a>
                                </nav>
                            </div>

                        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError17" aria-expanded="false" aria-controls="pagesCollapseError17">
                            Tipo de Usuário
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                            <div class="collapse" id="pagesCollapseError17" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cadastrar_tipo_usu.jsp">Cadastrar Tipos de Usuários</a>
                                    <a class="nav-link" href="alterar_tipo_usu.jsp">Alterar Tipos de Usuários</a>
                                    <a class="nav-link" href="consultar_tipo_usu.jsp">Consultar Tipos de Usuários</a>
                                    <a class="nav-link" href="listar_tipo_usu.jsp">Listar Tipos de Usuários</a>
                                </nav>
                            </div>

                            <a class="nav-link collapsed" href="valid_ir.jsp" >
                                <div class="sb-nav-link-icon"></div>
                            Validação de Imovel Rural
                            </a>


                            <a class="nav-link collapsed" href="valid_usu.jsp" >
                                <div class="sb-nav-link-icon"></div>
                            Validação de Usuário
                            </a>
                                
                            
                        </nav>
                        </div>
                        


                    </div>
                </div>
                <div class="sb-sidenav-footer">
                    <div class="small">Usuário logado:</div>
                    Administrador
                </div>
            </nav>
        </div>
            <!-- Fim do menu da esquerda -->
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">Consultar</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="dashboard.jsp">Dashboard</a></li>
                            <li class="breadcrumb-item active">Consultar</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                
                                <!-- COMEÇO DO FORM -->

                                <form action="consultarUsu" method="post">
                                    <div class="col-md-3">    </div>
                                    <div class="form-row"><div class="col-md-3"></div><h5 class="font-weight-light my-4">Dados do Usuário</h5></div>
                                    <div class="form-row">
                                        
                                        <div class="col-md-3">    </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputFirstName">Nome</label>
                                                <input class="form-control py-3" id="nomeUsuario" name="nomeUsuario" type="text" placeholder="Digite seu Nome" value=""/>
                                            </div>
                                        </div>
                                        
                                        

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputLastName">Sobrenome</label>
                                                <input class="form-control py-3" id="sobrenomeUsuario" name="sobrenomeUsuario" type="text" placeholder="Digite seu Sobrenome" value=""/>
                                            </div>
                                        </div>
                                    
                                        
                                    
                                         <div class="col-md-3">    </div>

                                    </div>
                                
                                    <div class="form-row">    
                                        <div class="col-md-3">    </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label class="small mb-1" for="email">Email</label>
                                                <input class="form-control py-3" id="emailUsuario" name="emailUsuario" type="email" placeholder="Digite seu Email" />
                                            </div>   
                                        </div>

                                        <div class="col-md-2">    
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputLastName">Matrícula</label>
                                                <input class="form-control py-3" id="matriculaUsuario" name="matriculaUsuario" type="text" placeholder="Apenas Números" value=""/>
                                            </div>                                 
                                         </div>
                                         <div class="col-md-3">    </div>
                                    </div>


                                       <div class="form-row">
                                        <div class="col-md-3"></div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputFirstName">Senha</label>
                                                <input class="form-control py-3" id="senha" name="senha" type="password" placeholder="Digite sua Senha" value=""/>
                                            </div>
                                        </div>

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputFirstName">Confirme sua Senha</label>
                                                <input class="form-control py-3" id="confirmaSenha" name="confirmaSenha" type="password" placeholder="Repita sua Senha" value=""/>
                                            </div>
                                        </div>
                                                
                                        <span id='message'></span>

                                    </div>
                                        

                                    <div class="form-row"><div class="col-md-3"></div><h5 class="font-weight-light my-4">Dados Pessoais</h5></div>

                                    <div class="form-row">  
                                        <div class="col-md-3"></div> 
                                        <div class="col-md-2" >
                                            <div class="form-group">                                            
                                                <label class="small mb-1" for="inputState" >Naturalização</label>
                                                <select id="naturalizacaoUsuario" name="naturalizacaoUsuario" class="form-control">
                                                    <option disabled selected hidden></option>
                                                    <option>RG</option>
                                                    <option>RNE</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputLastName">&nbsp</label>
                                                <input class="form-control py-3" id="naturalizacaoDocumento" name="naturalizacaoDocumento" type="text" placeholder="Nº do Documento" value=""/>
                                            </div>
                                        </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputLastName">Órgão Expedidor</label>
                                                <input class="form-control py-3" id="orgaoDocumento" name="orgaoDocumento" type="text" value=""/>
                                            </div>
                                        </div>
                                        <div class="col-md-3"></div> 
                                    </div>


                                    <div class="form-row">    
                                        <div class="col-md-3">    </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="date">Data de Emissão</label>
                                                <input class="form-control py-3" id="emissaoDocumento" name="emissaoDocumento" type="date" placeholder="dd/mm/aaaa" />
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group" Style="height: 38px;">                                            
                                                <label class="small mb-1" for="inputState" >CPF/CNPJ</label>
                                                <select id="cpfCnpjUsuario" name="cpfCnpjUsuario" class="form-control" >
                                                    <option disabled selected hidden></option>
                                                    <option>CPF</option>
                                                    <option>CNPJ</option>
                                                </select>
                                            </div>
                                        </div>
                                        

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" >Número do Documento</label>
                                                <input class="form-control py-3 "  id="numeroCpfCnpjUsuario" name="numeroCpfCnpjUsuario" type="text"/>
                                            </div>
                                        </div>
                                    </div>
                                        
                                    <div class="form-row"> 
                                        <div class="col-md-3">    </div>   
                                        <div class="col-md-2">
                                            <div class="form-group" Style="height: 38px;">                                            
                                                <label class="small mb-1" for="inputState" >Sexo</label>
                                                <select id="sexo" name="sexo" class="form-control">
                                                    <option disabled selected hidden></option>
                                                    <option >Masculino</option>
                                                    <option>Feminino</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="date">Data de Nascimento</label>
                                                <input class="form-control py-3" id="nascimentoUsuario" name="nascimentoUsuario" type="date" placeholder="dd/mm/aaaa" />
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group" Style="height: 38px;">
                                                
                                                <label class="small mb-1" for="inputState" >Tipo de Usuário</label>
                                                <select id="tipoUsuario" name="tipoUsuario" class="form-control">
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
                                                <select id="nacionalidadeUsuario" name="nacionalidadeUsuario" class="form-control">
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
                                                <select id="orgaoFuncional" name="orgaoFuncional" class="form-control">
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
                                                <input class="form-control py-3" id="regional" name="regional" type="text" placeholder="Regional"/>
                                            </div>
                                        </div>

                                    </div>


                                    <div class="form-row"><div class="col-md-3"></div><h5 class="font-weight-light my-4">Contatos</h5></div>

                                    <div class="form-row">

                                        <div class="col-md-3">    </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-2 " >Tipo de Telefone</label>
                                                <select id="tipoTelefone" name="tipoTelefone" class="form-control">
                                                    <option disabled selected hidden> </option>
                                                    <option value="celular">Celular</option>
                                                    <option value="residencial">Residencial</option>
                                                   

                                                </select>
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1.1" for="inputLastName">Telefone</label>
                                                <input class="form-control py-3" id="telefone" name="telefone" type="text" placeholder="Telefone"/>
                                            </div>
                                        </div>

                                        
                                        <div class="col-md-2 mt-1">
                                            <div class="form-group mt-4 mb-0" ><a onclick="adicionarTelefone()" class="btn btn-success btn-block"  style="height:50x; color:#fff; text-align: center;">Outros Telefones</a></div>
                                        </div>
                                            
                                    </div>   
                                         
                                    
                                        <div id="divTelefone"></div>

                                    <div class="form-row">
                                        <div class="col-md-3">    </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1">CEP<i class="fas fa-search" style="margin-left: 10px;"  onclick="pesquisacep(cep.value);"></i></label>
                                                <input class="form-control py-3" id="cep" name="cep" type="text" onblur="pesquisacep(this.value);"/>
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputLastName">Tipo de Logradouro</label>
                                                <input class="form-control py-3" id="tipoLogradouro" name="tipoLogradouro" type="text" placeholder="Tipo de Logradouro"/>
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputLastName">Logradouro</label>
                                                <input class="form-control py-3" id="logradouro" name="logradouro" type="text" placeholder="Nome do Logradouro"/>
                                            </div>
                                        </div>
                                                    
                                    </div>

                                    <div class="form-row">
                                        

                                        <div class="col-md-3">    </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputLastName">Número</label>
                                                <input class="form-control py-3" id="numeroEndereco" name="numeroEndereco" type="text" placeholder="Nº do Local"/>
                                            </div>
                                        </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputFirstName">Complemento</label>
                                                <input class="form-control py-3" id="complemento" name="complemento" type="text" placeholder="Complemento" value=""/>
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputFirstName">Bairro</label>
                                                <input class="form-control py-3" id="bairro" name="bairro" type="text" placeholder="Bairro" value=""/>
                                            </div>
                                        </div>

                                         
                                    </div>
                                    <div class="form-row">    
                                        <div class="col-md-3">    </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputFirstName">Cidade</label>
                                                <input class="form-control py-3" id="cidade" name="cidade" type="text" placeholder="Cidade" value=""/>
                                            </div>
                                        </div>
                                    

                                        <div class="col-md-2">
                                            <label class="small mb-1" for="inputState">Estado</label>
                                            <select id="estado" name="estado" class="form-control">
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
                                                <select id="uf" name="uf" class="form-control">
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

                                    
                                                                                                    
                                    <h6 class="text-justify lead text-center mb-0" style="font-size: 13px; font-weight: bolder;"><br>INSIRA FOTO/PDF DOS SEGUINTES DOCUMENTOS:</h6>    

                                    <h6 class="text-justify lead text-center" style="font-size: 10px; font-weight: bolder;"><br>REPITA O DOCUMENTO CASO NECESSÁRIO
                                        <span data-toggle="tooltip" data-placement="right" title="Mesmo que um documento esteja inserido dentro de outro, como o CPF no RG, é necessário uma foto para cada documento">[&#63;]</span>                                
                                        <br><br></h6>


                                        <div class="form-row">
                                            <div class="col-md-2"></div>

                                            <div class="form-group col-md-4 offset-md-1">
                                              <label for="exampleFormControlFile1">RG/RNE</label>
                                              <input type="file" class="form-control-file" id="exampleFormControlFile1">
                                            </div>
                                    </div>                                  
                                          
                                    <div class="form-row">
                                        <div class="col-md-2"></div>

                                            <div class="form-group col-md-4 offset-md-1">
                                              <label for="exampleFormControlFile1">CPF/CNPJ</label>
                                              <input type="file" class="form-control-file" id="exampleFormControlFile1">
                                            </div>
                                    </div> 

                                        

                                    <div class="form-row">
                                        <div class="col-md-2"></div>

                                            <div class="form-group col-md-4 offset-md-1">
                                              <label for="exampleFormControlFile1">COMPROVANTE DE RESIDÊNCIA</label>
                                              <input type="file" class="form-control-file" id="exampleFormControlFile1">
                                            </div>
                                    </div>
                                          

                                        
  
                                                                      
                                        <div class="col-md-1," style="display : flex; justify-content : center; align-items : center; flex-direction : initial;">
                                            
                                            <div class="form-group mt-4 mb-0"><button class="btn btn-success btn-block" type="submit" onclick="return validar()">Consultar</button></div>
                                    
                                    </div>
                                
                                
                                </form>


                               
                            </div>
                            </main>
                            <footer class="py-4 bg-light mt-auto">
                                <div class="container-fluid">
                                    <div class="d-flex align-items-center justify-content-between small">
                                        <div class="text-muted">Copyright &copy; Resília 2020</div>
                                        <div>
                                            <a href="#">Políticas de Privacidade</a>
                                            &middot;
                                            <a href="#">Termos e Condições</a>
                                        </div>
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

                <script type="text/javascript" src="js/buscadorcep.js"></script>


                
            </body>
        </html>