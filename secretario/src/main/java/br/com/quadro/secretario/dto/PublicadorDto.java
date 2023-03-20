package br.com.quadro.secretario.dto;

import br.com.quadro.secretario.entidades.Publicador;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PublicadorDto {

    private Long id;
    @NotEmpty @NotNull
    private String nome;
    @NotEmpty @NotNull
    private String sexo;
    @NotEmpty @NotNull
    private String dataDeNascimento;
    @NotEmpty @NotNull
    private String dataDeBatismo;

    public PublicadorDto(){}
    public PublicadorDto(Publicador publicador){
        this.id = publicador.getId();
        this.nome = publicador.getNome();
        this.sexo = publicador.getSexo();
        this.dataDeNascimento = publicador.getDataDeNascimento();
        this.dataDeBatismo = publicador.getDataDeBatismo();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }
    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getDataDeBatismo() {
        return dataDeBatismo;
    }
    public void setDataDeBatismo(String dataDeBatismo) {
        this.dataDeBatismo = dataDeBatismo;
    }

    public static Publicador converterPublicadorDtoParaPublicador(PublicadorDto dto){
        Publicador publicador = new Publicador();
        publicador.setId(dto.getId());
        publicador.setNome(dto.getNome());
        publicador.setSexo(dto.getSexo());
        publicador.setDataDeNascimento(dto.getDataDeNascimento());
        publicador.setDataDeBatismo(dto.getDataDeBatismo());
        return publicador;
    }
    public static PublicadorDto converterPublicadorParaPublicadorDto(Publicador publicador){
        PublicadorDto dto = new PublicadorDto();
        dto.setId(publicador.getId());
        dto.setNome(publicador.getNome());
        dto.setSexo(publicador.getSexo());
        dto.setDataDeNascimento(publicador.getDataDeNascimento());
        dto.setDataDeBatismo(publicador.getDataDeBatismo());
        return dto;
    }
    public static List<PublicadorDto> converterListaPublicadorParaPublicadorDto(List<Publicador> publicadors){
        List<PublicadorDto> dtos = new ArrayList<>();
        publicadors.stream().forEach(publicador -> {PublicadorDto dto = new PublicadorDto(publicador);
        dtos.add(dto);});
        return dtos;
    }
    public static List<Publicador> converterListaPublicadorDtoParaPublicador(List<PublicadorDto> publicadorDtos){
        List<Publicador> publicadors = new ArrayList<>();
        publicadorDtos.stream().forEach(publicadorDto -> {Publicador publicador = new Publicador();
        publicadors.add(publicador);});
        return publicadors;
    }
}
