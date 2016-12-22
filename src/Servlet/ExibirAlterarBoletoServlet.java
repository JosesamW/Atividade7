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
import Basicas.Fatura;

@WebServlet("/exibirAlterarBoleto")
public class ExibirAlterarBoletoServlet extends HttpServlet {

	private static final long serialVersionUID = 7990124468286661040L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String codigoBoleto = req.getParameter("codigoBoleto");
		
		Boletodao dao = new Boletodao();
		dao.remover(Integer.parseInt(codigoBoleto));
		String valorTotal = req.getParameter("valorTotal");
		
		PrintWriter out = res.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		
		out.println("<form action='alterarFatura'>");
		//out.println("COD_BOLETO: <input type='text' name='codigoBoleto' value='"+Boleto.getCodigoBoleto()+"' /> <br />");
		//out.println("DataPagamento: <input type='text' name='dataPagamento' value='"+Boleto.getDataPagamento()+"' /> <br />");
		//out.println("ValorPago: <input type='text' name='valorPago' value='"+Boleto.getValorPago()+"' /> <br />");
		out.println("<input type='submit' value='Alterar' />");
		out.println("</form>");
		
		out.println("</body>");
		out.println("</html>");
	}
}