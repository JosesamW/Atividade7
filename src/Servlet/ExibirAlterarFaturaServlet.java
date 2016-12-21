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

@WebServlet("/exibirAlterarFatura")
public class ExibirAlterarFaturaServlet extends HttpServlet {

	private static final long serialVersionUID = 7990124468286661040L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String nomeCliente = req.getParameter("nomeCliente");
		
		Faturadao dao = new Faturadao();
		Fatura Fatura = dao.buscarPorNomeCliente(nomeCliente);
		
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		out.println("<form action='alterarFatura'>");
		out.println("Nome: <input type='text' name='nome' value='"+Fatura.getNomeCliente()+"' /> <br />");
		out.println("DATA_VENCIMENTO: <input type='text' name='dataVencimento' value='"+Fatura.getDataVencimento()+"' /> <br />");
		out.println("VALOR_TOTAL: <input type='text' name='valorTotal' value='"+Fatura.getValorTotal()+"' /> <br />");
		out.println("<input type='submit' value='Alterar' />");
		out.println("</form>");
		
		out.println("</body>");
		out.println("</html>");
	}
}