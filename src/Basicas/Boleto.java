package Basicas;

import java.util.Date;

public class Boleto {
	
		private int codigoBoleto;
		private Date dataPagamento;
		private double valorPago;
		
		
		public int getCodigoBoleto() {
			return codigoBoleto;
		}
		public void setCodigoBoleto(int codigoBoleto) {
			this.codigoBoleto = codigoBoleto;
		}
		public Date getDataPagamento() {
			return dataPagamento;
		}
		public void setDataPagamento(Date dataPagamento) {
			this.dataPagamento = dataPagamento;
		}
		public double getValorPago() {
			return valorPago;
		}
		public void setValorPago(double valorPago) {
			this.valorPago = valorPago;
		}
		
}
