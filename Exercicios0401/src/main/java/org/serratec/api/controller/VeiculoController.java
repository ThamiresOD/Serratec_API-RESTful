package org.serratec.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.serratec.api.domain.Veiculo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/{veiculo}")
public class VeiculoController {
	private static List<Veiculo> lista = new ArrayList<Veiculo>();
	static {
		lista.add(new Veiculo(100L, "Ford", "Bronco"));
		lista.add(new Veiculo(101L, "Porche", "Cayenne"));
		lista.add(new Veiculo(102L, "Dodge Ram", "3500"));
	}                   
	
	@GetMapping
	public List<Veiculo> listar() {
		return lista;
	}
	
	@GetMapping("/{id}")
	public Veiculo buscar(@PathVariable Long id) {
		return lista.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);

	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo inserir(@RequestBody Veiculo veiculo) {
		lista.add(veiculo);
		return veiculo;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId().equals(id)) {
				lista.remove(i);
				break;
			}
		}
	}
	
	@PutMapping("/{id}")
	public Veiculo atualizar(@RequestBody Veiculo veiculo, @PathVariable Long id) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId().equals(id)) {
				Veiculo a = new Veiculo(id, veiculo.getMarca(), veiculo.getModelo());
				lista.set(i, a);
				return a;
			}
		}
		return null;
	}
}
                               