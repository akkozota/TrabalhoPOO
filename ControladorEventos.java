package turismo.negocio;

import java.util.List;
import java.util.Date;
import turismo.dados.RepositorioEventos;

// Responsável pelas regras de negócio de evento
public class ControladorEventos {

    private RepositorioEventos repoEventos;

    public ControladorEventos() {
        repoEventos = new RepositorioEventos();
    }

    // inserir
    public boolean add(Evento evento) {

        // validações
        if (evento == null)
            return false;

        if (evento.getNome() == null || evento.getNome().isEmpty())
            return false;

        if (evento.getDescricao() == null || evento.getDescricao().isEmpty())
            return false;

        if (evento.getDataInicio() == null || evento.getDataFim() == null)
            return false;

        if (evento.getPontoTuristico() == null)
            return false;

        // data de início não pode ser depois da data de fim
        if (evento.getDataInicio().after(evento.getDataFim()))
            return false;

        // regra de negócio:
        // o evento começa como pendente
        evento.setStatus(TipoStatusEvento.PENDENTE);

        // regra de negócio:
        // não pode haver outro evento aprovado
        // no mesmo ponto turístico e no mesmo período
        if (existeConflito(evento))
            return false;

        return repoEventos.add(evento);
    }

    // verifica conflito de horários
    private boolean existeConflito(Evento evento) {

        List<Evento> eventos = repoEventos.listar();

        for (Evento outro : eventos) {

            if (outro.getStatus() == TipoStatusEvento.APROVADO
                    && outro.getPontoTuristico().getCodigo()
                    == evento.getPontoTuristico().getCodigo()) {

                if (evento.getDataInicio().before(outro.getDataFim())
                        && evento.getDataFim().after(outro.getDataInicio())) {

                    return true;
                }
            }
        }

        return false;
    }

    // alterar
    public boolean alterar(Evento evento) {

        if (evento == null)
            return false;

        if (evento.getNome() == null || evento.getNome().isEmpty())
            return false;

        if (evento.getDataInicio() == null || evento.getDataFim() == null)
            return false;

        if (evento.getDataInicio().after(evento.getDataFim()))
            return false;

        Evento eventoEncontrado =
                repoEventos.buscarPorId(evento.getCodigo());

        if (eventoEncontrado == null)
            return false;

        return repoEventos.alterar(evento);
    }

    // cancelar
    public boolean cancelar(int codigo) {

        Evento evento = repoEventos.buscarPorId(codigo);

        if (evento == null)
            return false;

        evento.setStatus(TipoStatusEvento.CANCELADO);

        return repoEventos.alterar(evento);
    }

//novo metodo para que os eventos pendentes possam ser aprovados
public boolean aprovar(int codigo) {

    Evento evento = repoEventos.buscarPorId(codigo);

    if (evento == null || evento.getStatus() != TipoStatusEvento.PENDENTE)
        return false;

    if (existeConflito(evento))
        return false;

    evento.setStatus(TipoStatusEvento.APROVADO);
    return repoEventos.alterar(evento);
}

//buscar
public Evento buscarPorId(int codigo) {
    return repoEventos.buscarPorId(codigo);
}

//listar
public  List<Evento> listar() {
    return repoEventos.listar();
}

public List<Evento> listarPorPeriodo(Date dataInicio, Date dataFim) {

    if (dataInicio == null || dataFim == null)
        return null;

    if (dataInicio.after(dataFim))
        return null;

    return repoEventos.listarPorPeriodo(dataInicio, dataFim);
}
}