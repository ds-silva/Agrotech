<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <title>Listagem de Consulta</title>
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>
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
                        <h1 class="mt-4">Listagem de Consulta</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="dashboard.jsp">Dashboard</a></li>
                            <li class="breadcrumb-item"><a href="consultar_usu.jsp">Consulta</a></li>
                            <li class="breadcrumb-item active">Listagem de Consulta</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                <div class="table-responsive"> 
                                <p class="mb-0"></p>


                                <div class="container">
                                    <div class="row">
                                      <div class="col-sm">
                                        
                                      </div>
                                    </div>
                                  </div>
                               

                                <div class="container">
                                    <div class="table-wrapper">
                                        <div class="table-title">
                                            <div class="row">
                                                <div class="col-sm-6">
                                                    <h2>Listagem <b> Consulta</b></h2>
                                                </div>
                                                
                                            </div>
                                        </div>
                                        <table id="testTable" class="table table-striped table-hover">
                                            <thead>
                                                <tr>
                                                    <th>Name</th>
                                                    <th>Email</th>
                                                    <th>Address</th>
                                                    <th>Phone</th>
                                                    <th></th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>Thomas Hardy</td>
                                                    <td>thomashardy@mail.com</td>
                                                    <td>89 Chiaroscuro Rd, Portland, USA</td>
                                                    <td>(171) 555-2222</td>
                                                    <td></td>
                                                </tr>
                                                <tr>
                                                    <td>Dominique Perrier</td>
                                                    <td>dominiqueperrier@mail.com</td>
                                                    <td>Obere Str. 57, Berlin, Germany</td>
                                                    <td>(313) 555-5735</td>
                                                    <td></td>
                                                </tr>
                                                <tr>
                                                    <td>Maria Anders</td>
                                                    <td>mariaanders@mail.com</td>
                                                    <td>25, rue Lauriston, Paris, France</td>
                                                    <td>(503) 555-9931</td>
                                                    <td></td>
                                                </tr>
                                                <tr>
                                                    <td>Fran Wilson</td>
                                                    <td>franwilson@mail.com</td>
                                                    <td>C/ Araquil, 67, Madrid, Spain</td>
                                                    <td>(204) 619-5731</td>
                                                    <td></td>
                                                </tr>					
                                                <tr>
                                                    <td>Martin Blank</td>
                                                    <td>martinblank@mail.com</td>
                                                    <td>Via Monte Bianco 34, Turin, Italy</td>
                                                    <td>(480) 631-2097</td>
                                                    <td></td>
                                                </tr> 
                                            </tbody>
                                        </table>
                                        <div class="clearfix">
                                            <div class="hint-text">Página <b>5</b> de <b>25</b> </div>
                                            <ul class="pagination">
                                                <li class="page-item "><a href="#">Anterior</a></li>
                                                <li class="page-item"><a href="#" class="page-link">1</a></li>
                                                <li class="page-item"><a href="#" class="page-link">2</a></li>
                                                <li class="page-item active"><a href="#" class="page-link">3</a></li>
                                                <li class="page-item"><a href="#" class="page-link">4</a></li>
                                                <li class="page-item"><a href="#" class="page-link">5</a></li>
                                                <li class="page-item"><a href="#" class="page-link">Próxima</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <!-- Edit Modal jsp -->
                                <div id="addEmployeeModal" class="modal fade">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <form>
                                                <div class="modal-header">						
                                                    <h4 class="modal-title">Add Employee</h4>
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                </div>
                                                <div class="modal-body">					
                                                    <div class="form-group">
                                                        <label>Name</label>
                                                        <input type="text" class="form-control" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Email</label>
                                                        <input type="email" class="form-control" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Address</label>
                                                        <textarea class="form-control" required></textarea>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Phone</label>
                                                        <input type="text" class="form-control" required>
                                                    </div>					
                                                </div>
                                                <div class="modal-footer">
                                                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                                    <input type="submit" class="btn btn-success" value="Add">
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <script>checkbox.click(function(){
                                    if(!this.checked){
                                        $("#selectAll").prop("checked", false);
                                    }
                                });
                            
                            </script>


                                <!-- Delete Modal jsp -->
                                <div id="deleteEmployeeModal" class="modal fade">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <form>
                                                <div class="modal-header">						
                                                    <h4 class="modal-title">Deletar Usuário</h4>
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                </div>
                                                <div class="modal-body">					
                                                    <p>Tem certeza que deseja apagar esses dados?</p>
                                                    <p class="text-warning"><small>Essa ação não poderá ser desfeita.</small></p>
                                                </div>
                                                <div class="modal-footer">
                                                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
                                                    <input type="submit" class="btn btn-danger" value="Deletar">
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
                                                        <p>Tem certeza que deseja desabilitar esses dados?</p>
                                                        </div>
                                                    <div class="modal-footer">
                                                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
                                                        <input type="submit" class="btn btn-danger" value="Desabilitar">
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
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
        <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="js/resilia.js.js"></script>

    </body>
</html>
