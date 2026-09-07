package turismo.negocio;

import java.util.Date;
import java.util.List;

public class PontoTuristico {
    private String nome;
    private String descricao;
    private List<TipoCategoria> categorias; //(String/Enum - ex: Natureza, Gastronomia, Histórico) pensando aqui..eu posso selecionar mais de um enum?
    private String endereco;
    private Cidade cidade; //(String - Timóteo, Ipatinga ou Coronel Fabriciano)
    private String coordenadasGPS;
    private TipoStatusPonto status;

    private final int codigo;
    private static int proximoCodigo = 1;

    // Construtor
    private PontoTuristico(String nome, String descricao, List<TipoCategoria> categorias, String endereco, Cidade cidade, String coordenadasGPS, TipoStatusPonto status) {
        this.codigo = proximoCodigo++;
        this.nome = nome;
        this.descricao = descricao;
        this.categorias = categorias;
        this.endereco = endereco;
        this.cidade = cidade;
        this.coordenadasGPS = coordenadasGPS;
        this.status = status;
    }

    // método fábrica
    public static PontoTuristico getInstance(String nome, String descricao, List<TipoCategoria> categorias, String endereco, Cidade cidade, String coordenadasGPS, TipoStatusPonto status) {
        if (nome != null && descricao != null && categorias != null && endereco != null && cidade != null && coordenadasGPS != null && status != null) {
            return new PontoTuristico(nome, descricao, categorias, endereco, cidade, coordenadasGPS, status);
        }
        return null;
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

    public List<TipoCategoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<TipoCategoria> categorias) {
        this.categorias = categorias;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCoordenadasGPS() {
        return coordenadasGPS;
    }

    public void setCoordenadasGPS(String coordenadasGPS) {
        this.coordenadasGPS = coordenadasGPS;
    }

    public TipoStatusPonto getStatus() {
        return status;
    }

    public void setStatus(TipoStatusPonto status) {
        this.status = status;
    }
}
