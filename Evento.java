package turismo.negocio;

import java.util.Date;
import java.time.LocalDate;
import java.util.List;

// em negócio é onde ficam as classes responsáveis pelas entidades
// e pelas regras de negócio do sistema

public class Evento {
    private String nome;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private PontoTuristico pontoTuristico;
    private TipoStatusEvento status;

    private final int codigo;
    private static int proximoCodigo = 1;

    // Construtor
    private Evento(String nome, String descricao, LocalDate dataInicio, LocalDate dataFim, PontoTuristico pontoTuristico, TipoStatusEvento status) {
        this.codigo = proximoCodigo++;
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.pontoTuristico = pontoTuristico;
        this.status = status;
    }


    // método fábrica
    public static Evento getInstance(String nome, String descricao, LocalDate dataInicio, LocalDate dataFim, PontoTuristico pontoTuristico, TipoStatusEvento status) {
        if (nome != null && descricao != null && dataInicio != null && dataFim != null && pontoTuristico != null && status != null) {
            return new Evento(nome, descricao, dataInicio, dataFim, pontoTuristico, status);
        }
        return null;
    }

    // Construtor de cópia
    public Evento(Evento outro) {
        this.codigo = outro.codigo;
        this.nome = outro.nome;
        this.descricao = outro.descricao;
        this.dataInicio = outro.dataInicio;
        this.dataFim = outro.dataFim;
        this.pontoTuristico = outro.pontoTuristico;
        this.status = outro.status;
    }

    public int getCodigo() {
        return codigo;
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

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public PontoTuristico getPontoTuristico() {
        return pontoTuristico;
    }

    public void setPontoTuristico(PontoTuristico pontoTuristico) {
        this.pontoTuristico = pontoTuristico;
    }

    public TipoStatusEvento getStatus() {
        return status;
    }

    public void setStatus(TipoStatusEvento status) {
        this.status = status;
    }
}
