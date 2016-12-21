package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Faturadao;
import Basicas.Fatura;

@WebServlet("/listarFatura")
public class ListarFaturaServlet extends HttpServlet {

	private static final long serialVersionUID = -4481860843250088957L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		String codigoFatura = req.getParameter("codigoFatura");
		
		Faturadao dao = new Faturadao();
		List<Fatura> lista = dao.listar();

		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		out.println("<form action='listarFatura'>");
		out.println("Nome: <input type='text' name='nome' /> <br />");
		out.println("COD_FATURA: <input type='text' name='codigoFatura' /> <br />");
		out.println("<input type='submit' value='Filtrar' />");
		out.println("</form>");
		
		out.println("<table border='1' style='width: 100%;'>");
		out.println("<tr>");
		out.println("<td> NOME </td>");
		out.println("<td> DATA_VENCIMENTO </td>");
		out.println("<td> VALOR_TOTAL </td>");
		out.println("</tr>");

		for (Fatura Fatura : lista) {

			out.println("<tr>");
			out.println("<td> " + Fatura.getNomeCliente() + " </td>");
			out.println("<td> " + Fatura.getDataVencimento() + " </td>");
			out.println("<td> " + Fatura.getValorTotal() + " </td>");
			out.println("<td> ");
			out.println("<a href='exibirAlterarFatura?nomeCliente=" + Fatura.getNomeCliente() + " '>Alterar</a> &nbsp;");
			out.println("<a href='removerFatura?nomeCliente=" + Fatura.getNomeCliente() + " '>Remover</a>");
			out.println("</td>");
			out.println("</tr>");
		}

		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
}