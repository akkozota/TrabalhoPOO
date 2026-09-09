package turismo.negocio;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int codigo;
    private String nome;
    private String email;
    private String senha;
    private TipoUsuario tipoUser; //normal, prop e admin
    private static int proximoCodigo = 1;

        // adicionei esse construtor que estava faltando
        private Usuario(String nome, String email, String senha, TipoUsuario tipoUser) {
            this.codigo = proximoCodigo++;
            this.nome = nome;
            this.email = email;
            this.senha = senha;
            this.tipoUser = tipoUser;
        }

        // adicionei tambem o metodo fabrica
        public static Usuario getInstance(String nome, String email, String senha, TipoUsuario tipoUser) {
            if (nome != null && email != null && senha != null && tipoUser != null) {
                return new Usuario(nome, email, senha, tipoUser);
        }
        return null;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(TipoUsuario tipoUser) {
        this.tipoUser = tipoUser;
    }
}
