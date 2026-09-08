package turismo.negocio;

import turismo.dados.*;
import turismo.negocio.*;


public class Sistema {
    private static Sistema sistema;
    private RepositorioEventos repositorioEventos;
    private RepositorioPontos repositorioPontos;
    private RepositorioUsuarios repositorioUsuarios;


    private Sistema() {
        repositorioEventos = new RepositorioEventos();
        repositorioPontos = new RepositorioPontos();
        repositorioUsuarios = new RepositorioUsuarios();
    }

    public static Sistema getInstance() {
        if (sistema == null) {
            sistema = new Sistema();
        }
        return sistema;
    }
}
