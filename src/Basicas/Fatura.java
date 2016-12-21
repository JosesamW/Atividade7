package Basicas;

import java.util.Date;

public class Fatura{
		
		private int codigoFatura;
		private String nomeCliente;
		private Date dataVencimento;
		private double valorTotal;
		private int numeroBoleto;
		
		
		
		public int getCodigoFatura() {
			return codigoFatura;
		}
		public void setCodigoFatura(int codigoFatura) {
			this.codigoFatura = codigoFatura;
		}
		public String getNomeCliente() {
			return nomeCliente;
		}
		public void setNomeCliente(String nomeCliente) {
			this.nomeCliente = nomeCliente;
		}
		public Date getDataVencimento() {
			return dataVencimento;
		}
		public void setDataVencimento(Date dataVencimento) {
			this.dataVencimento = dataVencimento;
		}
		public double getValorTotal() {
			return valorTotal;
		}
		public void setValorTotal(double valorTotal) {
			this.valorTotal = valorTotal;
		}
		public int getNumeroBoleto() {
			return numeroBoleto;
		}
		public void setNumeroBoleto(int numeroBoleto) {
			this.numeroBoleto = numeroBoleto;
		}
}
