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

    //o metodo tava errrado tava void e o controlador não conseguia chamar
    //consertei para boolean igual aos outros
  public boolean inserir(Usuario u) {
        if (u == null)
            return false;
        usuarios.add(u);
        return true;
  }

//troquei a validacao pelo email(identificador unico) pq nao existe o metodo getNomeUsuario
    public Usuario login(String email, String senha) {
        for (int i = 0; i < usuarios.size() ; i++) {
            Usuario usuariosLista = usuarios.get(i);
            if (usuariosLista.getEmail().equals(email) && usuariosLista.getSenha().equals(senha)) {
                return usuariosLista;
            }
        }
        return null;
    }

    // alterar
    public boolean alterar(Usuario usuarioAlterado) {
        if (usuarioAlterado == null)
            return false;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getCodigo() == usuarioAlterado.getCodigo()) {
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


