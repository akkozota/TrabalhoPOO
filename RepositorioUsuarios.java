package turismo.dados;

import java.util.ArrayList;
import java.util.List;

import turismo.negocio.Usuario;

public class RepositorioUsuarios {

    private List<Usuario> usuarios;

    public RepositorioUsuarios() {
        usuarios = new ArrayList<Usuario>();
    }

    // inserir
    public boolean add(Usuario usuario) {

        if (usuario == null)
            return false;

        usuarios.add(usuario);
        return true;
    }

    // alterar
    public boolean alterar(Usuario usuarioAlterado) {

        if (usuarioAlterado == null)
            return false;

        for (int i = 0; i < usuarios.size(); i++) {

            if (usuarios.get(i).getCodigo()
                    == usuarioAlterado.getCodigo()) {

                usuarios.set(i, usuarioAlterado);
                return true;
            }
        }

        return false;
    }

    // excluir
    public boolean excluir(int codigo) {

        for (int i = 0; i < usuarios.size(); i++) {

            if (usuarios.get(i).getCodigo() == codigo) {

                usuarios.remove(i);
                return true;
            }
        }

        return false;
    }

    // buscar
    public Usuario buscarPorId(int codigo) {

        for (Usuario usuario : usuarios) {

            if (usuario.getCodigo() == codigo)
                return usuario;
        }

        return null;
    }

    // verifica se existe determinado email
    public boolean existeEmail(String email) {

        if (email == null)
            return false;

        for (Usuario usuario : usuarios) {

            if (usuario.getEmail().equalsIgnoreCase(email))
                return true;
        }

        return false;
    }

    // listar
    public List<Usuario> listar() {
        return usuarios;
    }
}
