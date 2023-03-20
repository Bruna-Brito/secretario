package br.com.quadro.secretario.dto;

import br.com.quadro.secretario.entidades.Publicador;
import br.com.quadro.secretario.entidades.Relatorio;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RelatorioDto {

    private Long id;
    private LocalDate localDate;
    private Publicador publicador;
    private Integer videosMostrados;
    private Integer publicacoes;
    private Integer horas;
    private Integer revisitas;
    private Integer estudos;

    public RelatorioDto(){}
    public RelatorioDto(Relatorio relatorio){
        this.id = relatorio.getId();
        this.localDate = relatorio.getLocalDate();
        this.publicador = relatorio.getPublicador();
        this.videosMostrados = relatorio.getVideosMostrados();
        this.publicacoes = relatorio.getPublicacoes();
        this.horas = relatorio.getHoras();
        this.revisitas = relatorio.getRevisitas();
        this.estudos = relatorio.getEstudos();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }
    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Publicador getPublicador() {
        return publicador;
    }
    public void setPublicador(Publicador publicador) {
        this.publicador = publicador;
    }

    public Integer getVideosMostrados() {
        return videosMostrados;
    }
    public void setVideosMostrados(Integer videosMostrados) {
        this.videosMostrados = videosMostrados;
    }

    public Integer getPublicacoes() {
        return publicacoes;
    }
    public void setPublicacoes(Integer publicacoes) {
        this.publicacoes = publicacoes;
    }

    public Integer getHoras() {
        return horas;
    }
    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public Integer getRevisitas() {
        return revisitas;
    }
    public void setRevisitas(Integer revisitas) {
        this.revisitas = revisitas;
    }

    public Integer getEstudos() {
        return estudos;
    }
    public void setEstudos(Integer estudos) {
        this.estudos = estudos;
    }

    public static Relatorio converterRelatorioDtoParaRelatorio(RelatorioDto dto){
        Relatorio relatorio = new Relatorio();
        relatorio.setId(dto.getId());
        relatorio.setLocalDate(dto.getLocalDate());
        relatorio.setPublicador(dto.getPublicador());
        relatorio.setVideosMostrados(dto.getVideosMostrados());
        relatorio.setPublicacoes(dto.getPublicacoes());
        relatorio.setHoras(dto.getHoras());
        relatorio.setRevisitas(dto.getRevisitas());
        relatorio.setEstudos(dto.getEstudos());
        return relatorio;
    }
    public static RelatorioDto converterRelatorioParaRelatorioDto(Relatorio relatorio){
        RelatorioDto dto = new RelatorioDto();
        dto.setId(relatorio.getId());
        dto.setLocalDate(relatorio.getLocalDate());
        dto.setPublicador(relatorio.getPublicador());
        dto.setVideosMostrados(relatorio.getVideosMostrados());
        dto.setPublicacoes(relatorio.getPublicacoes());
        dto.setHoras(relatorio.getHoras());
        dto.setRevisitas(relatorio.getRevisitas());
        dto.setEstudos(relatorio.getEstudos());
        return dto;
    }
    public static List<RelatorioDto> converterListaRelatorioParaRelatorioDto(List<Relatorio> relatorios){
        List<RelatorioDto> dtos = new ArrayList<>();
        relatorios.stream().forEach(relatorio -> {RelatorioDto dto = new RelatorioDto(relatorio);
            dtos.add(dto);});
        return dtos;
    }
    public static List<Relatorio> converterListaRelatorioDtoParaRelatorio(List<RelatorioDto> dtos){
        List<Relatorio> relatorios = new ArrayList<>();
        dtos.stream().forEach(relatorioDto -> {Relatorio relatorio = new Relatorio(relatorioDto);
        relatorios.add(relatorio);});
        return relatorios;
    }
}
