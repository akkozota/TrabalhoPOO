package turismo.negocio;

import java.util.List;
import turismo.dados.*;
//regras d negócio de pontos

public class ControladorPontos {
    private RepositorioPontos repoPonto;

    public ControladorPontos() {
        repoPonto = new RepositorioPontos();
    }

    // inserir
    public boolean add(PontoTuristico p) {
        // regra de negocio:
        // nao pode ser mais de um ponto com mesmo nome
        if (p != null && !repoPonto.existeNomePonto(p.getNome()))
            return repoPonto.add(p);
        else
            return false;
    }


    // alterar
    public boolean alterar(PontoTuristico pAlterado) {
        if (pAlterado != null && !pAlterado.getNome().isEmpty()
                && repoPonto.buscarPontoPorNome(pAlterado.getNome())
                .getCodigo() == pAlterado.getCodigo())
            return repoPonto.alterar(pAlterado);
        else
            return false;
    }


}

}
