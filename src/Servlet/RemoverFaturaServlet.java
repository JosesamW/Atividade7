package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Faturadao;
import Basicas.Fatura;

@WebServlet("/removerFatura")
public class RemoverFaturaServlet extends HttpServlet {

	private static final long serialVersionUID = 8720553500987085526L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomeCliente = request.getParameter("nomeCliente");
		
		Faturadao dao = new Faturadao();
		Fatura Fatura = dao.remover(nomeCliente);
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Fatura removida com sucesso!");
		out.println("</body>");
		out.println("</html>");
	}

}
