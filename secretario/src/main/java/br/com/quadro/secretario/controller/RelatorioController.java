package br.com.quadro.secretario.controller;

import br.com.quadro.secretario.dto.RelatorioDto;
import br.com.quadro.secretario.entidades.Publicador;
import br.com.quadro.secretario.entidades.Relatorio;
import br.com.quadro.secretario.repository.PublicadorRepository;
import br.com.quadro.secretario.repository.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    private RelatorioRepository relatorioRepository;
    @Autowired
    private PublicadorRepository publicadorRepository;

    @GetMapping
    public List<RelatorioDto> findAll(RelatorioDto relatorioDto){
        List<Relatorio> relatorios = relatorioRepository.findAll();
        return RelatorioDto.converterListaRelatorioParaRelatorioDto(relatorios);
    }

    @GetMapping("/{id}")
    public RelatorioDto findById(@PathVariable Long id){
        Relatorio relatorio = relatorioRepository.findById(id).orElse(null);
        return RelatorioDto.converterRelatorioParaRelatorioDto(relatorio);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){relatorioRepository.deleteById(id);}

    @PostMapping
    public RelatorioDto save(@RequestBody @Validated RelatorioDto dto){
        Publicador publicador = publicadorRepository.findById(dto.getPublicador().getId()).orElse(null);

        Relatorio relatorio = new Relatorio();

        relatorio.setPublicador(publicador);
        relatorio.setLocalDate(dto.getLocalDate());
        relatorio.setVideosMostrados(dto.getVideosMostrados());
        relatorio.setPublicacoes(dto.getPublicacoes());
        relatorio.setHoras(dto.getHoras());
        relatorio.setRevisitas(dto.getRevisitas());
        relatorio.setEstudos(dto.getEstudos());

        relatorio = relatorioRepository.save(relatorio);

        return RelatorioDto.converterRelatorioParaRelatorioDto(relatorio);
    }

    @PutMapping("/{id}")
    public RelatorioDto atualizar(@PathVariable Long id, @RequestBody RelatorioDto dto){
        Publicador publicador = publicadorRepository.findById(dto.getPublicador().getId()).orElse(null);

        Relatorio relatorio = RelatorioDto.converterRelatorioDtoParaRelatorio(dto);

        relatorio.setPublicador(publicador);
        relatorio.setLocalDate(dto.getLocalDate());
        relatorio.setVideosMostrados(dto.getVideosMostrados());
        relatorio.setPublicacoes(dto.getPublicacoes());
        relatorio.setHoras(dto.getHoras());
        relatorio.setRevisitas(dto.getRevisitas());
        relatorio.setEstudos(dto.getEstudos());
        relatorio.setId(id);

        relatorioRepository.save(relatorio);

        return RelatorioDto.converterRelatorioParaRelatorioDto(relatorio);
    }
}
