package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Boletodao;
import Basicas.Boleto;

@WebServlet("/listarFatura")
public class ListarBoletoServlet extends HttpServlet {

	private static final long serialVersionUID = -4481860843250088957L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String valorPago = req.getParameter("valorPago");
		String codigoBoleto = req.getParameter("codigoBoleto");
		
		Boletodao dao = new Boletodao();
		List<Boleto> lista = dao.listar();

		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		out.println("<form action='listarBoleto'>");
		out.println("COD_BOLETO : <input type='text' name='codigoBoleto ' /> <br />");
		out.println("ValorPago: <input type='text' name='valorPago' /> <br />");
		out.println("<input type='submit' value='Filtrar' />");
		out.println("</form>");
		
		out.println("<table border='1' style='width: 100%;'>");
		out.println("<tr>");
		out.println("<td> COD_BOLETO </td>");
		out.println("<td> DataPagamento </td>");
		out.println("<td> ValorPago </td>");
		out.println("</tr>");

		for (Boleto Boleto : lista) {

			out.println("<tr>");
			out.println("<td> " + Boleto.getCodigoBoleto() + " </td>");
			out.println("<td> " + Boleto.getDataPagamento() + " </td>");
			out.println("<td> " + Boleto.getValorPago() + " </td>");
			out.println("<td> ");
			out.println("<a href='exibirAlterarBoleto?codigoBoleto=" + Boleto.getCodigoBoleto() + " '>Alterar</a> &nbsp;");
			out.println("<a href='removerBoleto?codigoBoleto=" + Boleto.getCodigoBoleto() + " '>Remover</a>");
			out.println("</td>");
			out.println("</tr>");
		}

		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
}