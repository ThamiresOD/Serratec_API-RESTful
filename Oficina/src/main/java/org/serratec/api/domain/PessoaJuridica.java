package org.serratec.api.domain;

import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends Fornecedor {
		private String razaoSocial, cnpj, insEstadual;

		public String getRazaoSocial() {
			return razaoSocial;
		}

		public void setRazaoSocial(String razaoSocial) {
			this.razaoSocial = razaoSocial;
		}

		public String getCnpj() {
			return cnpj;
		}

		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}

		public String getInsEstadual() {
			return insEstadual;
		}

		public void setInsEstadual(String insEstadual) {
			this.insEstadual = insEstadual;
		}

	
		
		
}
