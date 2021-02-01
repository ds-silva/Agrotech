

<%@page import="model.TipoUsuario"%>
<div style="background-color: #28a745;">
    <div class="w-100 p-3 container" style="background-color: #28a745; height: 42px;">

        <div class="row justify-content-between">
            <div class="col-12 col-sm-6 col-md-8 arroba" style="left: 2.6%; font-size:13px; margin-top: -7px;" >
                <p class="font-weight-light text-white">
                    <img src="img/brasil.png" class="img-fluid mr-2" alt="Responsive image"> <strong>BRASIL</strong>
                </p>
            </div>

            <div class="col5 arroba2 " style="margin-top: -1px; right: 3.6%; position: relative;">

                <h6 class="font-weight-light text-white ml-5" style="font-size:10px;">
                    <a href="http://www.simplifique.gov.br/" class="font-weight-light text-white" target="_blank">SIMPLIFIQUE&nbsp;</a>
                    <span class="font-weight-light text-white">|&nbsp;</span>
                    <a href="https://www.gov.br/pt-br/participacao-social/" class="font-weight-light text-white" target="_blank">PARTICIPE&nbsp;</a>
                    <span class="font-weight-light text-white">|&nbsp;</span>
                    <a href="http://www4.planalto.gov.br/legislacao/" class="font-weight-light text-white" target="_blank">LEGISLAÇÃO&nbsp;</a>
                    <span class="font-weight-light text-white">|&nbsp;</span>
                    <a href="https://www.gov.br/pt-br/canais-do-executivo-federal" class="font-weight-light text-white" target="_blank">CANAIS</a>
                </h6>
            </div>
        </div>

    </div>
</div>


</header>
<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
    <a class="navbar-brand" href="dashboard.jsp">AGROTECH</a><button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#"><i class="fas fa-bars"></i></button
    ><!-- Navbar Search-->
    <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
    </form>
    <!-- Navbar-->
    <ul class="navbar-nav ml-auto ml-md-0">
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="meuPerfilConsulta">Meu Perfil</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="logout.jsp">Sair</a>
            </div>
        </li>
    </ul>
</nav>

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
                    <a class="nav-link" href="meuPerfilConsulta"
                       ><div class="sb-nav-link-icon"><i class="fas fa-user fa-fw"></i></div>
                        Meu Perfil</a
                    >

                    <div class="sb-sidenav-menu-heading">Acesso Rápido</div>


                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError6" aria-expanded="false" aria-controls="pagesCollapseError6">
                        Imóvel Rural
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="pagesCollapseError6" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                        <nav class="sb-sidenav-menu-nested nav">
                            <a class="nav-link" href="cadastrar_ir.jsp">Cadastrar Imóvel Rural</a>
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
                            <a class="nav-link" href="consultar_produto.jsp">Consultar Produtos</a>
                            <a class="nav-link" href="listar_produto.jsp">Listar Produtos</a>
                        </nav>
                    </div>


                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError21" aria-expanded="false" aria-controls="pagesCollapseError21">
                        Produtor
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="pagesCollapseError21" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                        <nav class="sb-sidenav-menu-nested nav">
                            <a class="nav-link" href="cadastrar_produtor.jsp">Cadastrar Produtor</a>
                            <a class="nav-link" href="consultar_produtor.jsp">Consultar Produtor</a>
                            <a class="nav-link" href="listar_produtor.jsp">Listar Produtor</a>
                        </nav>
                    </div>

                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError20" aria-expanded="false" aria-controls="pagesCollapseError20">
                        Proprietário
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="pagesCollapseError20" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                        <nav class="sb-sidenav-menu-nested nav">
                            <a class="nav-link" href="cadastrar_prop.jsp">Cadastrar Proprietário</a>
                            <a class="nav-link" href="consultar_proprietario.jsp">Consultar Proprietário</a>
                            <a class="nav-link" href="listar_proprietario.jsp">Listar Proprietário</a>
                        </nav>
                    </div>



                    <a class=" nav-link " href="consultar_regional.jsp" >Consultar Regional</a>
                    </a>


                    <div class="sb-sidenav-menu-heading">Acesso Geral</div>


                    <!--Começo do Menu de Clientes-->
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages4" aria-expanded="false" aria-controls="collapsePages"
                       ><div class="sb-nav-link-icon"><i class=""></i></div>
                        Clientes 
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div
                        ></a>
                    <div class="collapse" id="collapsePages4" aria-labelledby="headingTwo" data-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">



                            <!--Começo dos Usuários-->





                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError4" aria-expanded="false" aria-controls="pagesCollapseError4">
                                Proprietário
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="pagesCollapseError4" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cadastrar_prop.jsp">Cadastrar Proprietário</a>
                                    <a class="nav-link" href="consultar_proprietario.jsp">Consultar Proprietário</a>
                                    <a class="nav-link" href="listar_proprietario.jsp">Listar Proprietário</a>
                                </nav>
                            </div>



                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError5" aria-expanded="false" aria-controls="pagesCollapseError5">
                                Produtor
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="pagesCollapseError5" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cadastrar_produtor.jsp">Cadastrar Produtor</a>
                                    <a class="nav-link" href="consultar_produtor.jsp">Consultar Produtor</a>
                                    <a class="nav-link" href="listar_produtor.jsp">Listar Produtor</a>
                                </nav>
                            </div>


                        </nav>
                    </div>






                    <!--Inicio do submenu de usuário-->

                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages"
                       ><div class="sb-nav-link-icon"><i class=""></i></div>
                        Agentes do Governo
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
                                    <a class="nav-link" href="cadastrar_adm.jsp">Cadastrar Administrador</a>
                                    <a class="nav-link" href="consultar_adm.jsp">Consultar Administrador</a>
                                    <a class="nav-link" href="listar_adm.jsp">Listar Administrador</a>
                                </nav>                                
                            </div>


                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError2" aria-expanded="false" aria-controls="pagesCollapseError2">
                                Operador de Sistema
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="pagesCollapseError2" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cadastrar_operador.jsp">Cadastrar Operador de Sistema</a>
                                    <a class="nav-link" href="consultar_operador.jsp">Consultar Operador de Sistema</a>
                                    <a class="nav-link" href="listar_operador.jsp">Listar Operador de Sistema</a>
                                </nav>
                            </div>




                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError3" aria-expanded="false" aria-controls="pagesCollapseError3">
                                Agente
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="pagesCollapseError3" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cadastrar_agente.jsp">Cadastrar Agente</a>
                                    <a class="nav-link" href="consultar_agente.jsp">Consultar Agente</a>
                                    <a class="nav-link" href="listar_agente.jsp">Listar Agente</a>
                                </nav>
                            </div>

                        </nav>
                    </div>

                    <!--Começo dos Negócio-->



                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages2" aria-expanded="false" aria-controls="collapsePages"
                       ><div class="sb-nav-link-icon"><i class=""></i></div>
                        Agronegócio
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div
                        ></a>
                    <div class="collapse" id="collapsePages2" aria-labelledby="headingTwo" data-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">


                            <!--Começo das sessões de Pagina-->

                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError30" aria-expanded="false" aria-controls="pagesCollapseError30">
                                Imóvel Rural
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="pagesCollapseError30" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cadastrar_ir.jsp">Cadastrar Imóvel Rural</a>
                                    <a class="nav-link" href="consultar_ir.jsp">Consultar Imóvel Rural</a>
                                    <a class="nav-link" href="listar_ir.jsp">Listar Imóvel Rural</a>
                                </nav>
                            </div>

                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError31" aria-expanded="false" aria-controls="pagesCollapseError31">
                                Produtos
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="pagesCollapseError31" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cadastrar_produto.jsp">Cadastrar Produtos</a>
                                    <a class="nav-link" href="consultar_produto.jsp">Consultar Produtos</a>
                                    <a class="nav-link" href="listar_produto.jsp">Listar Produtos</a>
                                </nav>
                            </div>

                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError32" aria-expanded="false" aria-controls="pagesCollapseError32">
                                Regional
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="pagesCollapseError32" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cadastrar_regional.jsp">Cadastrar Regional</a>
                                    <a class="nav-link" href="consultar_regional.jsp">Consultar Regional</a>
                                    <a class="nav-link" href="listar_regional.jsp">Listar Regional</a>
                                </nav>
                            </div>

                        </nav>
                    </div>




                    <!--Começo do controle de Sistema-->

                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages3" aria-expanded="false" aria-controls="collapsePages"
                       ><div class="sb-nav-link-icon"><i class=""></i></div>
                        Manutenção do Sistema
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
                                    <a class="nav-link" href="consultar_estado.jsp">Consultar Estado</a>
                                    <a class="nav-link" href="listar_estado.jsp">Listar Estado</a>
                                </nav>
                            </div>

                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError11" aria-expanded="false" aria-controls="pagesCollapseError11">
                                País
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="pagesCollapseError11" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cadastrar_nac.jsp">Cadastrar País</a>
                                    <a class="nav-link" href="consultar_nac.jsp">Consultar País</a>
                                    <a class="nav-link" href="listar_nac.jsp">Listar País</a>
                                </nav>
                            </div>


                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError12" aria-expanded="false" aria-controls="pagesCollapseError12">
                                Órgãos Funcionais
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="pagesCollapseError12" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cadastrar_og.jsp">Cadastrar Órgãos Funcionais</a>
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
                                    <a class="nav-link" href="cadastrar_sit.jsp">Cadastrar Situação do Usuário</a>
                                    <a class="nav-link" href="consultar_sit.jsp">Consultar Situação do Usuário</a>
                                    <a class="nav-link" href="listar_sit.jsp">Listar Situação do Usuário</a>
                                </nav>
                            </div>

                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError15" aria-expanded="false" aria-controls="pagesCollapseError15">
                                Situação Imóvel Rural
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="pagesCollapseError15" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cadastrar_sit_ir.jsp">Cadastrar Situação Imóvel Rural</a>
                                    <a class="nav-link" href="consultar_sit_ir.jsp">Consultar Situação Imóvel Rural</a>
                                    <a class="nav-link" href="listar_sit_ir.jsp">Listar Situação Imóvel Rural</a>
                                </nav>
                            </div>

                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError16" aria-expanded="false" aria-controls="pagesCollapseError16">
                                Tipo de Produto
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="pagesCollapseError16" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cadastrar_tipo_produto.jsp">Cadastrar Tipo de Produto</a>
                                    <a class="nav-link" href="consultar_tipo_produto.jsp">Consultar Tipo de Produto</a>
                                    <a class="nav-link" href="listar_tipo_produto.jsp">Listar Tipo de Produto</a>
                                </nav>
                            </div>

                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError17" aria-expanded="false" aria-controls="pagesCollapseError17">
                                Tipo de Telefone
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="pagesCollapseError17" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cadastrar_tipo_tel.jsp">Cadastrar Tipo de Telefone</a>
                                    <a class="nav-link" href="consultar_tipo_tel.jsp">Consultar Tipo de Telefone</a>
                                    <a class="nav-link" href="listar_tipo_tel.jsp">Listar Tipo de Telefone</a>
                                </nav>
                            </div>

                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError18" aria-expanded="false" aria-controls="pagesCollapseError18">
                                Tipo de Usuário
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="pagesCollapseError18" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
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
                <%
                    String tipoUsuari = (String) session.getAttribute("tipoUsuario");
                %>
                <div>
                    <%=tipoUsuari%>
                </div>

            </div>
        </nav>
    </div>

