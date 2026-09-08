package turismo.dados;

import java.util.ArrayList;
import java.util.List;

import turismo.negocio.*;

public class RepositorioEventos {
    private List<Evento> eventos;

    public RepositorioEventos() {
        eventos = new ArrayList<Evento>();
    }

    public boolean existeNomeEvento(String nome) {
        for (Evento e : eventos)
            if (e.getNome().equalsIgnoreCase(nome))
                return true;
        return false;
    }

    //inserir
    public boolean add(Evento e) {
        if (e == null)
            return false;
        return eventos.add(e);
    }

    public Evento buscarEventoPorCodigo(int codigo) {
        for (Evento e : eventos)
            if (e.getCodigo() == codigo)
                return e;
        return null;
    }

    // alterar
    public boolean alterar(int codigo, String nome, String descricao) {
        Evento e = buscarEventoPorCodigo(codigo);
        if (e == null)
            return false;

        if (nome != null)
            e.setNome(nome);
        if (descricao != null)
            e.setDescricao(descricao);

        return true;
    }


    public boolean pontoTemEventos(PontoTuristico p) {
        for (Evento e: eventos) {
            if (e.getPontoTuristico() == p && e.getStatus() == TipoStatusEvento.APROVADO) {
                return true;
            }
        }
        return false;
    }

    public List<Evento> getEventos() {
        return eventos;
    }
}
