package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Boletodao;
import Basicas.Boleto;

@WebServlet("/removerBoleto")
public class RemoverBoletoServlet extends HttpServlet {

	private static final long serialVersionUID = 8720553500987085526L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String codigoBoleto = request.getParameter("codigoBoleto");
		
		Boletodao dao = new Boletodao();
		dao.remover(Integer.parseInt(codigoBoleto));
		
		
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Boleto removido com sucesso!");
		out.println("</body>");
		out.println("</html>");
	}

}
