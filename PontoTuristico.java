package turismo.negocio;

public class PontoTuristico {
    private int id;
    private String nome;
    private String descricao;
    private TipoCategoria categoria;  //(String/Enum - ex: Natureza, Gastronomia, Histórico) pensando aqui..eu posso selecionar mais de um enum?
    private String endereco;
    private Cidade cidade; //(String - Timóteo, Ipatinga ou Coronel Fabriciano)
    private String coordenadasGPS;
    private TipoStatusPonto status;
}
