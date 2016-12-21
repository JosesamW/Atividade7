package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Basicas.Boleto;

@WebServlet("/boletoServlet")
public class BoletoServlet extends HttpServlet {
	
	private static final long serialVersionUID = -2929675305622527402L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		 String codigoBoleto = req.getParameter("codigoBoleto");
		 String dataPagamento = req.getParameter("dataPagamento");
		 String valorPago = req.getParameter("valorPago");
		 
		 PrintWriter out = res.getWriter();
		 
		 Boleto boleto = new Boleto();
		 boleto.setCodigoBoleto(Integer.parseInt(codigoBoleto));
		 boleto.setValorPago(Double.parseDouble(valorPago));
		 
		 boolean erroConverter = false;
			
			try {
				Date dataConvertida = new SimpleDateFormat("dd/MM/yyyy").parse(dataPagamento);
				boleto.setDataPagamento(dataConvertida);
			} catch (ParseException e) {
				erroConverter = true;
			}
			
			if(erroConverter = false){
				
				//dao Fatura aqui
				
				out.println("<html>");
				out.println("<body>");
				out.println("Rodou de boa!!");
				out.println("</body>");
				out.println("</html>");
		
				
			}else{
				out.println("<html>");
				out.println("<body>");
				out.println("erro!!");
				out.println("</body>");
				out.println("</html>");
			}
		
	}

}