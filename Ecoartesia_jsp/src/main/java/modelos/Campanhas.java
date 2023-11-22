package modelos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Campanhas {
    private int idCampanha;
    private String nome;
    private String descricao;
    private BigDecimal metaArrecadacao;
    private LocalDate dataInicio;
    private LocalDate dataTermino;

    public int getIdCampanha() {
        return idCampanha;
    }

    public void setIdCampanha(int idCampanha) {
        this.idCampanha = idCampanha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getMetaArrecadacao() {
        return metaArrecadacao;
    }

    public void setMetaArrecadacao(BigDecimal metaArrecadacao) {
        this.metaArrecadacao = metaArrecadacao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }
}