package br.com.quadro.secretario.entidades;

import br.com.quadro.secretario.dto.PublicadorDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Publicador {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sexo;
    private String dataDeNascimento;
    private String dataDeBatismo;

    public Publicador(){}
    public Publicador(PublicadorDto publicadorDto){
        this.id = publicadorDto.getId();
        this.nome = publicadorDto.getNome();
        this.sexo = publicadorDto.getSexo();
        this.dataDeNascimento = publicadorDto.getDataDeNascimento();
        this.dataDeBatismo = publicadorDto.getDataDeBatismo();
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
}
