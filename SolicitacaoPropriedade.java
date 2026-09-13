package turismo.negocio;

public class SolicitacaoPropriedade {

    private final int codigo;
    private static int proximoCodigo = 1;

    private final Usuario solicitante;
    private final String comprovanteVinculo;
    private TipoStatusSolicitacao status;

    private SolicitacaoPropriedade(Usuario solicitante, String comprovanteVinculo){
        this.codigo = proximoCodigo++;
        this.solicitante = solicitante;
        this.comprovanteVinculo = comprovanteVinculo;
        this.status = TipoStatusSolicitacao.PENDENTE;
    }

    public static SolicitacaoPropriedade getInstance(Usuario solicitante, String comprovanteVinculo){
        if (solicitante != null && comprovanteVinculo != null && !comprovanteVinculo.isEmpty()) {
            return new SolicitacaoPropriedade(solicitante, comprovanteVinculo);
        }
        return null;
    }


public int getCodigo() {
    return codigo;
}

public Usuario getSolicitante() {
    return solicitante();
}

public String getComprovanteVinculo() {
    return comprovanteVinculo();
}

public TipoStatusSolicitacao getStatus() {
        return status;
}

public void setStatus(TipoStatusSolicitacao status) {
        this.status = status;
}
}