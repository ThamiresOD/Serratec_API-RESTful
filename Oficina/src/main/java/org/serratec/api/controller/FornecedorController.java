package org.serratec.api.controller;

import java.util.List;

import org.serratec.api.domain.Fornecedor;
import org.serratec.api.domain.PessoaFisica;
import org.serratec.api.domain.PessoaJuridica;
import org.serratec.api.repository.FornecedorRepository;
import org.serratec.api.repository.PessoaFisicaRepository;
import org.serratec.api.repository.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FornecedorController {
	
	@Autowired
	private PessoaFisicaRepository pessoaFisicaRepository;
	
	@Autowired
	private PessoaJuridicaRepository pessoaJuridicaRepository;
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
		
	@GetMapping("/pessoafisica")
	public List<PessoaFisica> listaPessoaFisica() {
		return pessoaFisicaRepository.findAll();
	}
	@GetMapping("/PessoaJuridica")
	public List<PessoaJuridica> listaPessoaJuridica() {
		return pessoaJuridicaRepository.findAll();
	}
	@GetMapping("/fornecedor")
	public List<Fornecedor> listaFornecedor() {
		return fornecedorRepository.findAll();
	}
}
