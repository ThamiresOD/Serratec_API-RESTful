package org.serratec.api.domain;

import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Fornecedor {
		private String rg, orgao, cpf;

		public String getRg() {
			return rg;
		}

		public void setRg(String rg) {
			this.rg = rg;
		}

		public String getOrgao() {
			return orgao;
		}

		public void setOrgao(String orgao) {
			this.orgao = orgao;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		
		
}
