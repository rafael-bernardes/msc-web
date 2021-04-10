package br.gov.bom_destino.msc_web.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TextoUtils {
	public static String formatarCPF(String cpf) throws Exception {
		if(cpf == null || cpf.length() != 11) {
			throw new Exception("CPF incorreto");
		}
		
		StringBuilder s = new StringBuilder();
		
		s.append(cpf.substring(0, 3));
		s.append(".");
		s.append(cpf.substring(3, 6));
		s.append(".");
		s.append(cpf.substring(6,  9));
		s.append("-");
		s.append(cpf.substring(9));
		
		return s.toString();
	}
	
	public static String formatarCNPJ(String cnpj) throws Exception {
		if(cnpj == null || cnpj.length() != 14) {
			throw new Exception("CNPJ incorreto");
		}
		
		StringBuilder s = new StringBuilder();
		
		s.append(cnpj.substring(0, 2));
		s.append(".");
		s.append(cnpj.substring(2, 5));
		s.append(".");
		s.append(cnpj.substring(5,  8));
		s.append("/");
		s.append(cnpj.substring(8, 12));
		s.append("-");
		s.append(cnpj.substring(12));
		
		return s.toString();
	}
	
	public static String formatarData(Date data) {
		if(data == null) {
			return "";
		}
		
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");

		return s.format(data);
	}
}