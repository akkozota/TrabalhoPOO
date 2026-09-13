package turismo.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import turismo.dados.RepositorioEventos;
import turismo.dados.RepositorioUsuarios;

//exclui o que tinha aqui que era copia de controlador eventos

public class ControladorUsuarios {

    private RepositorioUsuarios repoUsuarios;
    private List<SolicitacaoPropriedade> solicitacoes;

    public ControladorUsuarios() {
        repoUsuarios = new RepositorioUsuarios();
    }

    public boolean registrar (Usuario usuario) {

        if (usuario == null || usuario.getTipoUser() != TipoUsuario.NORMAL)
            return false;

        if (usuario.getEmail() == null || usuario.getEmail().isEmpty())
            return false;

        if (repoUsuarios.existeEmail(usuario.getEmail()))
            return false;

        return repoUsuarios.inserir(usuario);

      }

      public Usuario login(String email, String senha) {
        return repoUsuarios.login(email, senha);
      }

      public Usuario buscarPorId(int codigo) {
        return repoUsuarios.buscarPorId(codigo);
      }

      public boolean atualizarPerfil(Usuario usuarioAlterado) {
        if (usuarioAlterado == null)
            return false;

        Usuario existente = repoUsuarios.buscarPorId(usuarioAlterado.getCodigo());
           if (existente == null)
               return false;

           return repoUsuarios.alterar(usuarioAlterado);
      }

      public boolean excluirConta(int codigo) {
        return repoUsuarios.excluir(codigo);
      }

      public List<Usuario> listar() {
        return  repoUsuarios.listar();
      }

      public boolean solicitarPropriedade(Usuario usuario, String comprovante) {
        if (usuario == null || usuario.getTipoUser() != TipoUsuario.NORMAL)
            return false;

        SolicitacaoPropriedade solicitacao = SolicitacaoPropriedade.getInstance( usuario, comprovante);
        if (solicitacao == null)
            return false;

        solicitacoes.add(solicitacao);
        return true;
      }

      public List<SolicitacaoPropriedade> listarSolicitacoesPendentes(){
        List<SolicitacaoPropriedade> pendentes = new ArrayList<SolicitacaoPropriedade>();
        for (SolicitacaoPropriedade s : solicitacoes) {
            if (s.getStatus() == TipoStatusSolicitacao.PENDENTE)
                pendentes.add(s);
        }
        return pendentes;
      }

      public SolicitacaoPropriedade buscarSolicitacaoPorId(int codigo) {
        for (SolicitacaoPropriedade s: solicitacoes) {
            if (s.getCodigo() == codigo)
                return s;
        }
        return null;
      }

    public boolean aprovarSolicitacao(int codigoSolicitacao) {
        SolicitacaoPropriedade solicitacao = buscarSolicitacaoPorId(codigoSolicitacao);
        if (solicitacao == null || solicitacao.getStatus() != TipoStatusSolicitacao.PENDENTE)
            return false;

        solicitacao.setStatus(TipoStatusSolicitacao.ACEITA);
        solicitacao.getSolicitante().setTipoUser(TipoUsuario.PROPRIETARIO);
        return true;
    }

    public boolean rejeitarSolicitacao(int codigoSolicitacao) {
        SolicitacaoPropriedade solicitacao = buscarSolicitacaoPorId(codigoSolicitacao);
        if (solicitacao == null || solicitacao.getStatus() != TipoStatusSolicitacao.PENDENTE)
            return false;

        solicitacao.setStatus(TipoStatusSolicitacao.RECUSADA);
        return true;
    }
    }

