package turismo.dados;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import turismo.negocio.Evento;

public class RepositorioEventos {

    private List<Evento> eventos;

    public RepositorioEventos() {
        eventos = new ArrayList<Evento>();
    }

    // inserir
    public boolean add(Evento evento) {
        if (evento == null)
            return false;

        eventos.add(evento);
        return true;
    }

    // alterar
    public boolean alterar(Evento eventoAlterado) {
        if (eventoAlterado == null)
            return false;
        for (int i = 0; i < eventos.size(); i++) {
            if (eventos.get(i).getCodigo() == eventoAlterado.getCodigo()) {
                eventos.set(i, eventoAlterado);
                return true;
            }
        }

        return false;
    }

    // buscar
    public Evento buscarPorId(int codigo) {
        for (Evento evento : eventos) {
            if (evento.getCodigo() == codigo)
                return evento;
        }

        return null;
    }

    // listar todos
    public List<Evento> listar() {
        return eventos;
    }

    // listar eventos dentro de um período
    public List<Evento> listarPorPeriodo(
            Date dataInicio, Date dataFim) {

        List<Evento> resultado =
                new ArrayList<Evento>();

        if (dataInicio == null || dataFim == null)
            return resultado;

        for (Evento evento : eventos) {

            if (!evento.getDataInicio().before(dataInicio)
                    && !evento.getDataFim().after(dataFim)) {

                resultado.add(evento);
            }
        }

        return resultado;
    }
}
