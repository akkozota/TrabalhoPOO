package turismo.dados;

//responsável por guardar e procurar os objetos, vai ter funções como
//adicionar, buscar ponto, verificar se ja existe um nome, alterar um ponto,
//excluir um ponto e listar os pontos... n eh pra decidir as regras mais gerais
//do sistema, como a de que só pode cadastrar um ponto se for adm... isso eh
//uma regra de negócio que vai p negócio

import turismo.negocio.*;
import turismo.dados.*;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPontos {
    private List<PontoTuristico> pontos;

    public RepositorioPontos() {
        pontos = new ArrayList<PontoTuristico>();
    }

    //inserir
    public boolean add(PontoTuristico p) {
        if (p == null)
            return false;

        pontos.add(p);
        return true;
    }

    public boolean existeNomePonto(String nome) {
        for (PontoTuristico p : pontos)
            if (p.getNome().equalsIgnoreCase(nome))
                return true;
        return false;
    }

    public PontoTuristico buscarPontoPorCodigo(int codigo) {
        for (int i = 0; i < pontos.size(); i++) {
            PontoTuristico p = pontos.get(i);
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    // alterar
    public boolean alterar(int codigo, String nome, String descricao, List<TipoCategoria> categorias, String endereco, Cidade cidade, String coordenadasGPS, TipoStatusPonto status) {
        PontoTuristico p = buscarPontoPorCodigo(codigo);
        if (p == null)
            return false;

        if (nome != null)
            p.setNome(nome);
        if (descricao != null)
            p.setDescricao(descricao);
        if (categorias != null)
            p.setCategorias(categorias);
        if (endereco != null)
            p.setEndereco(endereco);
        if (cidade != null)
            p.setCidade(cidade);
        if (coordenadasGPS != null)
            p.setCoordenadasGPS(coordenadasGPS);
        if (status != null)
            p.setStatus(status);
        return true;
    }

    // excluir

    public boolean inativar(int codigo, RepositorioEventos repositorioEventos) {
        PontoTuristico p = buscarPontoPorCodigo((codigo));
        if (p == null) {
            return false;

        }

        if (repositorioEventos.pontoTemEventos(p)) {
            return false;
        } //impede o cara de apagar se tiver um evento aprovado ali

        p.setStatus(TipoStatusPonto.INATIVO);
        return true;
    }
}



