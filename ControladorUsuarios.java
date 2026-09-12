package turismo.negocio;

import java.util.List;
import java.util.Date;
import turismo.dados.RepositorioEventos;
import turismo.dados.RepositorioUsuarios;

//exclui o que tinha aqui que era copia de controlador eventos

public class ControladorUsuarios {

    private RepositorioUsuarios repoUsuarios;

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
    }

