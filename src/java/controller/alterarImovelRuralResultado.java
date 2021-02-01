/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ImovelRuralDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Endereco;
import model.Estado;
import model.ImovelRural;

/**
 *
 * @author David.Silva
 */
@WebServlet(name = "alterarImovelRuralResultado", urlPatterns = {"/alterarImovelRuralResultado"})
public class alterarImovelRuralResultado extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            try {

                ImovelRural imvR = new ImovelRural();
                Endereco end = new Endereco();
                Estado est = new Estado();

                int id = Integer.parseInt(request.getParameter("idImovelRural"));

                String numeroIR = request.getParameter("numeroIR");
                String nirf = request.getParameter("nirf");
                String situacaoIR = request.getParameter("situacaoIR");
                String tipoPropriedade = request.getParameter("tipoPropriedade");
                String tipoOcupacao = request.getParameter("tipoOcupacao");
                String mercadoAtuacao = request.getParameter("mercadoAtuacao");

                Double areaGeoreferenciada = Double.parseDouble(request.getParameter("areaGeoreferenciada"));
                Double areaReservaAmbiental = Double.parseDouble(request.getParameter("areaReservaAmbiental"));
                Double areaPecuaria = Double.parseDouble(request.getParameter("areaPecuaria"));
                Double areaAgricultura = Double.parseDouble(request.getParameter("areaAgricultura"));

                String latitude = request.getParameter("latitude");
                String longitude = request.getParameter("longitude");

                String cep = request.getParameter("cep");
                String tipoLogradouro = request.getParameter("tipoLogradouro");
                String logradouro = request.getParameter("logradouro");
                String numeroEndereco = request.getParameter("numeroEndereco");
                String complemento = request.getParameter("complemento");
                String bairro = request.getParameter("bairro");
                String cidade = request.getParameter("cidade");
                int estado = Integer.parseInt(request.getParameter("estado"));
                int idEndereco = Integer.parseInt(request.getParameter("idEndereco"));

                //dados imovel
                imvR.setIdImovelRural(id);
                imvR.setNirf(nirf);
                imvR.setnInscricaoEstadual(numeroIR);
                imvR.setSituacaoImovel(situacaoIR);
                imvR.setTipoPropriedade(tipoPropriedade);
                imvR.setTipoOcupacao(tipoOcupacao);
                imvR.setMercadoAtuacao(mercadoAtuacao);
                imvR.setAreaGeoreferenciada(areaGeoreferenciada);
                imvR.setAreaReservaAmbiental(areaReservaAmbiental);
                imvR.setAreaUtilizacaoPecuaria(areaPecuaria);
                imvR.setAreaUtilizacaoAgricultura(areaAgricultura);
                imvR.setLatitude(latitude);
                imvR.setLongitude(longitude);

                //dados endereco
                end.setCep(cep);
                end.setTipoLogradouro(tipoLogradouro);
                end.setLogradouro(logradouro);
                end.setNumero(numeroEndereco);
                end.setComplemento(complemento);
                end.setBairro(bairro);
                end.setCidade(cidade);
                end.setIdEndereco(idEndereco);

                //dados estado
                est.setIdEstado(estado);

                end.setEstado(est);
                imvR.setEndereco(end);

                ImovelRuralDAO.alterarImovelRural(imvR);

                out.print("ok");

            } catch (SQLException ex) {
                out.print(ex.getMessage());
            } catch (Exception ex) {
                out.print(ex.getMessage());
            }
        }
    }
}
