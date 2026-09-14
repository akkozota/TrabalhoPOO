package turismo.negocio;

import java.util.List;
import turismo.dados.*;

//regras d negócio de pontos
//decide qm cadastra e tal

public class ControladorPontos {
    private RepositorioPontos repoPonto;

    public ControladorPontos() {
        repoPonto = new RepositorioPontos();
    }

    // inserir
    public boolean add(PontoTuristico p, Usuario usuario) {
        // regra de negocio:
        // nao pode ser mais de um ponto com mesmo nome
        //e só administrador pode cadastrar ponto
        if (usuario == null || usuario.getTipoUser() != TipoUsuario.ADMIN) {
            return false;
        }

        if (p == null || p.getNome() == null || p.getNome().isEmpty() || p.getDescricao() == null ||
                p.getDescricao().isEmpty() || p.getCidade() == null || p.getEndereco() == null ||
                p.getEndereco().isEmpty() || p.getCategorias() == null || p.getCategorias().isEmpty()
                || p.getCoordenadasGPS() == null || p.getCoordenadasGPS().isEmpty()) {
            return false;
        }

        //n pode existir outro ponto cm mesmo nome
        if (repoPonto.existeNome(p.getNome())) {
            return false;
        }

        return repoPonto.add(p);
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

    public PontoTuristico buscarPontoPorCodigo(int codigo) {
        return repoPonto.buscarPorId(codigo);
    }

    public PontoTuristico buscarPontoPorNome(String nome) {
        if (nome == null)
            return null;
        List<PontoTuristico> pontos = repoPonto.listar();

        for (int i = 0; i < pontos.size(); i++) {
            PontoTuristico p = pontos.get(i);
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    public List<PontoTuristico> listar() {
        return repoPonto.listar();
    }

    // listar por cidade
    public List<PontoTuristico> listarPorCidade( Cidade cidade) {
        return repoPonto.listarPorCidade(cidade);
    }
    // listar por categoria
    public List<PontoTuristico> listarPorCategoria( TipoCategoria categoria) {
        return repoPonto.listarPorCategoria(categoria);
    }


}
