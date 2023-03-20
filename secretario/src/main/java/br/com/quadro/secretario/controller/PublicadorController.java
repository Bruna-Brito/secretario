package br.com.quadro.secretario.controller;

import br.com.quadro.secretario.dto.PublicadorDto;
import br.com.quadro.secretario.entidades.Publicador;
import br.com.quadro.secretario.repository.PublicadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/publicadores")
public class PublicadorController {
    @Autowired
    private PublicadorRepository publicadorRepository;

    @GetMapping
    public List<PublicadorDto> findAll() {
      List<Publicador> publicador = publicadorRepository.findAll();
        return PublicadorDto.converterListaPublicadorParaPublicadorDto(publicador);
    }

    @GetMapping("/{id}")
    public PublicadorDto findById(@PathVariable Long id){
        Publicador publicador = publicadorRepository.findById(id).orElse(null);
        return PublicadorDto.converterPublicadorParaPublicadorDto(publicador);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){publicadorRepository.deleteById(id);}

    @PostMapping
    public PublicadorDto save(@RequestBody @Validated PublicadorDto publicadorDto){
        Publicador publicador = PublicadorDto.converterPublicadorDtoParaPublicador(publicadorDto);
        publicador = publicadorRepository.save(publicador);
        return PublicadorDto.converterPublicadorParaPublicadorDto(publicador);
    }

    @PutMapping("/{id}")
    public PublicadorDto atualizar(@PathVariable Long id, @RequestBody PublicadorDto publicadorDto){
        Publicador publicador = PublicadorDto.converterPublicadorDtoParaPublicador(publicadorDto);
        publicador.setId(id);
        publicadorRepository.save(publicador);
        return PublicadorDto.converterPublicadorParaPublicadorDto(publicador);
    }
}
