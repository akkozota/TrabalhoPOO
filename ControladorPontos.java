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
        if (p != null && !repoPonto.existeNome(p.getNome())) {
            return repoPonto.add(p);
        } else
            return false;
    }

    public PontoTuristico buscarPorId(int codigo) {
        return repoPonto.buscarPorId(codigo);
    }

    // alterar
    public boolean alterar(PontoTuristico pAlterado) {

        if (pAlterado == null || pAlterado.getNome() == null || pAlterado.getNome().isEmpty())
            return false;

        PontoTuristico existente = repoPonto.buscarPorId(pAlterado.getCodigo());
        if (existente == null)
            return false;

        // faltava esse return: se passou pelas duas checagens, o ponto existe
        // e pode ser alterado de fato
        return repoPonto.alterar(pAlterado);
    }


}


