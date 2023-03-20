package br.com.quadro.secretario.entidades;

import br.com.quadro.secretario.dto.RelatorioDto;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Relatorio {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate localDate;
    @ManyToOne
    private Publicador publicador;
    private Integer videosMostrados;
    private Integer publicacoes;
    private Integer horas;
    private Integer revisitas;
    private Integer estudos;

    public Relatorio(){}
    public Relatorio(RelatorioDto relatorioDto){
        this.id = relatorioDto.getId();
        this.localDate = relatorioDto.getLocalDate();
        this.publicador = relatorioDto.getPublicador();
        this.videosMostrados = relatorioDto.getVideosMostrados();
        this.publicacoes = relatorioDto.getPublicacoes();
        this.horas = relatorioDto.getHoras();
        this.revisitas = relatorioDto.getRevisitas();
        this.estudos = relatorioDto.getEstudos();
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

    public Publicador getPublicador() {return publicador;}
    public void setPublicador(Publicador publicador) {this.publicador = publicador;}

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
}
