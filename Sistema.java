package turismo.negocio;

import turismo.dados.*;
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
            List<TipoCategoria> categoriasP1 = new ArrayList<TipoCategoria>();
            categoriasP1.add(TipoCategoria.LAZER);
        PontoTuristico p1 = PontoTuristico.getInstance("Parque Ipanema", "Lugarzinho ai" , categoriasP1 , "naosei", Cidade.IPATINGA, "41.98108, -80.61234" ,TipoStatusPonto.ATIVO );
        addPonto(p1, u1);

        List<TipoCategoria> categoriasP2 = new ArrayList<TipoCategoria>();
        categoriasP2.add(TipoCategoria.NATUREZA);
        categoriasP2.add(TipoCategoria.LAZER);

        PontoTuristico p2 = PontoTuristico.getInstance("Riacho das pedras", "lugarzinho legal", categoriasP2, "naosei", Cidade.CORONEL_FABRICIANO, "41.98108, -80.61234" ,TipoStatusPonto.ATIVO) ;
        addPonto(p2, u1);

        List<TipoCategoria> categoriasP3 = new ArrayList<TipoCategoria>();
        categoriasP3.add(TipoCategoria.TURISMO_INDUSTRIAL);
        PontoTuristico p3 = PontoTuristico.getInstance("CEFET MG", "ceferno", categoriasP3, "naosei", Cidade.TIMOTEO, "41.98108, -80.61234" , TipoStatusPonto.ATIVO );
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
        return controladorPonto.buscarPontoPorNome(nome);
//        List<PontoTuristico> pontos = controladorPonto.listar();
//        for (int i = 0; i < pontos.size(); i++) {
//            PontoTuristico ponto = pontos.get(i);
//            if (ponto.getNome().equalsIgnoreCase(nome)) {
//                return ponto.getCodigo();
//            }
//        }
//        return -1;
    }

    public boolean buscarCodPonto(int codigo) {
        PontoTuristico ponto = controladorPonto.buscarPontoPorCodigo(codigo);
        return ponto != null;
    }

    public String buscarPontoPornome(String nome) {
        return controladorPonto.buscarPontoPorNome(nome);
    }

    public List<PontoTuristico> listarPontos() {
        return controladorPonto.listar();
    }

    public boolean solicitarPropriedade(Usuario usuario, int codigoPropriedade, String comprovante) {
        return controladorUsuario.solicitarPropriedade(usuario, codigoPropriedade, comprovante);
    }



//    public boolean inativarPonto(int codigo) {
//        return controladorPonto
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

    public boolean excluirEvento(int codigo) {
        return controladorEvento.cancelar(codigo);
    }

    public boolean aprovarEvento(int codigo) {
        return controladorEvento.aprovar(codigo);
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

    public boolean SolicitarPropriedade(Usuario usuario, int codigoPropriedade, String comprovante) {
        return controladorUsuario.solicitarPropriedade(usuario, codigoPropriedade, comprovante);
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
