package turismo.dados;

//responsável por guardar e procurar os objetos, vai ter funções como
//adicionar, buscar ponto, verificar se ja existe um nome, alterar um ponto,
//excluir um ponto e listar os pontos... n eh pra decidir as regras mais gerais
//do sistema, como a de que só pode cadastrar um ponto se for adm... isso eh
//uma regra de negócio que vai p negócio

import java.util.ArrayList;
import java.util.List;

import turismo.negocio.PontoTuristico;
import turismo.negocio.TipoCategoria;

public class RepositorioPontos {

    private List<PontoTuristico> pontos;

    public RepositorioPontos() {
        pontos = new ArrayList<PontoTuristico>();
    }

    // inserir
    public boolean add(PontoTuristico ponto) {

        if (ponto == null)
            return false;

        pontos.add(ponto);
        return true;
    }

    // alterar
    public boolean alterar(PontoTuristico pontoAlterado) {

        if (pontoAlterado == null)
            return false;

        for (int i = 0; i < pontos.size(); i++) {

            if (pontos.get(i).getCodigo() == pontoAlterado.getCodigo()) {

                pontos.set(i, pontoAlterado);
                return true;
            }
        }

        return false;
    }

    // buscar
    public PontoTuristico buscarPorId(int codigo) {

        for (PontoTuristico ponto : pontos) {

            if (ponto.getCodigo() == codigo)
                return ponto;
        }

        return null;
    }

    // verifica se já existe um ponto com determinado nome
    public boolean existeNome(String nome) {

        if (nome == null)
            return false;

        for (PontoTuristico ponto : pontos) {

            if (ponto.getNome().equalsIgnoreCase(nome))
                return true;
        }

        return false;
    }

    // listar todos
    public List<PontoTuristico> listar() {
        return pontos;
    }

    // listar por cidade
    public List<PontoTuristico> listarPorCidade(String cidade) {

        List<PontoTuristico> resultado =
                new ArrayList<PontoTuristico>();

        if (cidade == null)
            return resultado;

        for (PontoTuristico ponto : pontos) {

            if (ponto.getCidade().equalsIgnoreCase(cidade))
                resultado.add(ponto);
        }

        return resultado;
    }

    // listar por categoria
    public List<PontoTuristico> listarPorCategoria(
            TipoCategoria categoria) {

        List<PontoTuristico> resultado =
                new ArrayList<PontoTuristico>();

        if (categoria == null)
            return resultado;

        for (PontoTuristico ponto : pontos) {

            if (ponto.getCategoria() == categoria)
                resultado.add(ponto);
        }

        return resultado;
    }
}


