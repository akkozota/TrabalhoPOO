package turismo.negocio;

import turismo.dados.*;
import turismo.negocio.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Sistema {
    private static Sistema sistema;
    private ControladorEventos controladorEvento;
    private ControladorPontos controladorPonto;
    private ControladorUsuarios controladorUsuario;

    private Sistema() {
        controladorEvento = new ControladorEventos();
        controladorPonto = new ControladorPontos();
        controladorUsuario = new ControladorUsuarios();
    }

    public static Sistema getInstance() {
        if (sistema == null) {
            sistema = new Sistema();
        }
        return sistema;
    } //singleton do sistema

        void init() {
        //vou inicializar 3 users, 3 pontos e 2 eventos

        // -- usuários --
        Usuario u1 = Usuario.getInstance("leticia", "leticia@gmail.com" , "1234", TipoUsuario.ADMIN);
        addUsuario(u1);

        Usuario u2 = Usuario.getInstance("proprietario", "proprietario@gmail.com", "5678", TipoUsuario.PROPRIETARIO);
        addUsuario(u2);

        Usuario u3 = Usuario.getInstance("normal", "normal@gmail.com", "1234", TipoUsuario.NORMAL);
        addUsuario(u3);

        // -- pontos --
        PontoTuristico p1 = PontoTuristico.getInstance("Parque Ipanema", "Lugarzinho ai" , TipoCategoria.LAZER , "naosei", Cidade.IPATINGA, "41.98108, -80.61234" ,TipoStatusPonto.ATIVO );
        addPonto(p1, u1);

        PontoTuristico p2 = PontoTuristico.getInstance("Riacho das pedras", "lugarzinho legal", TipoCategoria.NATUREZA, "naosei", Cidade.CORONEL_FABRICIANO, "41.98108, -80.61234" ,TipoStatusPonto.ATIVO) ;
        addPonto(p2, u1);

        PontoTuristico p3 = PontoTuristico.getInstance("CEFET MG", "ceferno", TipoCategoria.TURISMO_INDUSTRIAL, "naosei", Cidade.TIMOTEO, "41.98108, -80.61234" , TipoStatusPonto.ATIVO );
        addPonto(p3, u1);

        // -- eventos --
        Evento e1 = Evento.getInstance("CONEI", "uau primeiro congresso de neurociência do vale!", LocalDate.of(2026, 9, 11 ), LocalDate.of(2026, 9, 12), p3, TipoStatusEvento.APROVADO);
        addEvento(e1, u1);
        Evento e2 = Evento.getInstance("Festival das fatias", "só tem coisa cara", LocalDate.of(2026, 8, 12), LocalDate.of(2026, 8, 12), p1, TipoStatusEvento.APROVADO );
        addEvento(e2, u1);


    } //p já ter oq testar na hora da apresentação

    // -- PONTO TURISTICO --

    public boolean addPonto(PontoTuristico ponto, Usuario usuario) {
        return controladorPonto.add(ponto, usuario);
    }

    public int buscarPonto(String nome) {
        List<PontoTuristico> pontos = controladorPonto.listar();
        for (int i = 0; i < pontos.size(); i++) {
            PontoTuristico ponto = pontos.get(i);
            if (ponto.getNome().equalsIgnoreCase(nome)) {
                return ponto.getCodigo();
            }
        }
        return -1;
    }

    public boolean buscarCodPonto(int codigo) {
        PontoTuristico ponto = controladorPonto.buscarPontoPorCodigo(codigo);
        return ponto != null;
    }

    public List<PontoTuristico> listarPontos() {
        return controladorPonto.listar();
    }



//    public boolean inativarPonto(int codigo) {
//        PontoTuristico p = buscarPontoPorCodigo(codigo);
//        if (p == null) //se n achar ponto com esse codigo
//            return false;
//
//        if (pontoTemEvento(p)) {
//           return false;  //se tem evento e ainda tá ativo, vai dar erro
//        } else {
//            p.setStatus(TipoStatusPonto.INATIVO);
//        }
//        return true;
//    }


    public PontoTuristico buscarPontoPorCodigo(int codigo) {
        return controladorPonto.buscarPontoPorCodigo(codigo);
    }

    // -- EVENTOS --
    public boolean addEvento(Evento e, Usuario usuario) {
        return controladorEvento.add(e);
    }

    public Evento buscarEventoPorCodigo(int codigo) {
        return controladorEvento.buscarPorId(codigo);
    }

    public int buscarEvento(String nome) {
        List<Evento> eventos = controladorEvento.listar();

        for (int i = 0; i < eventos.size(); i++) {
            Evento evento = eventos.get(i);

            if (evento.getNome().equalsIgnoreCase(nome)) {
                return evento.getCodigo();
            }
        }
        return -1;
    }

    public List<Evento> listarEventos() {
        return controladorEvento.listar();
    }

    public boolean alterarEvento(Evento evento) {
        return controladorEvento.alterar(evento);
    }

    public boolean excluirEvento(Evento evento) {
        return controladorEvento.cancelar(evento);
    }

    public boolean aprovarEvento(Evento evento) {
        return controladorEvento.aprovar(evento);
    }

    // -- USUÁRIOS --
    public boolean addUsuario(Usuario usuario) {
        return controladorUsuario.registrar(usuario);
    }

    public Usuario loginUsuario(String email, String senha) {
        return controladorUsuario.login(email, senha);
    }

    public Usuario buscarUsuarioPorCodigo(int codigo) {
        return controladorUsuario.buscarPorId(codigo);
    }


    public List<Usuario> listarUsuarios() {
        return controladorUsuario.listar();
    }

    // -- propriedade --

    public boolean SolicitarPropriedade(Usuario usuario, String comprovante) {
        return controladorUsuario.solicitarPropriedade(usuario, comprovante);
    }

    public List<SolicitacaoPropriedade> listarSolicitacoespendentes() {
        return controladorUsuario.listarSolicitacoesPendentes();
    }


    public boolean aprovarSolicitacao(int codigo) {
        return controladorUsuario.aprovarSolicitacao(codigo);
    }

    public boolean rejeitarSolicitacao(int codigo) {
        return controladorUsuario.rejeitarSolicitacao(codigo);
    }

    public ControladorPontos getControladorPonto() {
        return controladorPonto;
    }

    public ControladorEventos getControladorEvento() {
        return controladorEvento;
    }

    public ControladorUsuarios getControladorUsuario() {
        return controladorUsuario;
    }


}
