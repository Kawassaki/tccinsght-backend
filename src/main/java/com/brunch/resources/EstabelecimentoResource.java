package com.brunch.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brunch.models.Estabelecimento;
import com.brunch.repository.EstabelecimentoRepository;

@RestController
@RequestMapping("/estabelecimento")
public class EstabelecimentoResource {

	@Autowired
	private EstabelecimentoRepository er;

	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Estabelecimento> buscarEstabelecimentos() {
		Iterable<Estabelecimento> listaEstabelecimentos = er.findAll();
		return listaEstabelecimentos;
	}

	@PostMapping()
	public Estabelecimento cadastrarEstabelecimento(@RequestBody @Valid Estabelecimento estabelecimento) {
		return er.save(estabelecimento);
	}
	
	@DeleteMapping()
	public void deletarEvento(@RequestBody @Valid Estabelecimento estabelecimento) {
		er.delete(estabelecimento);
	}	

}
