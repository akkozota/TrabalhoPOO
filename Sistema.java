package turismo.negocio;

import turismo.dados.*;
import turismo.negocio.*;


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
    }

    public boolean addPonto(PontoTuristico p, Usuario usuario) {
        return controladorPonto.add(p);
    }

    public PontoTuristico buscarPontoPorCodigo(int codigo) {
        return controladorPonto.buscarPontoPorCodigo(codigo);
    }

    public boolean alterarPonto(PontoTuristico pAlterado) {
        return controladorPonto.alterar(pAlterado);
    }

    
}

//package trabalho;
////sistema armazenará todos os prods, marcas e vendas
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//public class rascunhoSistema {
//    private List<Produto> vProd = new ArrayList<>();
//    private List<Marca> vMarca = new ArrayList<>();
//    private List<Venda> vVenda = new ArrayList<>();
//    private List<Usuario> usuarios = new ArrayList<>();
//    private Carrinho carrinho;
//
//    //sistema tem que ser singleton (classe instanciada apenas uma vez), ent eu crio
//    //construtor privado, metodo fábrica e variável estática p guarda o objeto
//
//    private static rascunhoSistema sistema; //pertence a classe e não ao objeto + vai inicializar como null
//
//    private rascunhoSistema() {
//        vVenda = new ArrayList<Venda>();
//        vProd = new ArrayList<Produto>();
//        vMarca = new ArrayList<Marca>();
//        usuarios = new ArrayList<Usuario>();
//
//        carrinho = Carrinho.getInstance();
//    } //construtor
//
//    public static rascunhoSistema getInstance() {
//        if (null == sistema) {
//            sistema = new rascunhoSistema();
//        }
//        return sistema;
//    } // singleton
//
//    void init() {
//        //inicializar 5 produtos, 3 marcas, 2 vendas e 2 users
//
//        // -- usuários --
//        Usuario u1 = Usuario.getInstance("rafinha67", "Rafaela", "1234", TipoUsuario.ADMIN);
//        inserirUsuario(u1);
//
//        Usuario u2 = Usuario.getInstance("mariaDitadora", "Maria Isabelle", "5678", TipoUsuario.ATENDENTE);
//        inserirUsuario(u2);
//
//        // -- marcas --
//        Marca m1 = Marca.getInstance("Nestle", "Nestle INC", "11111111111111");
//        inserirMarca(m1);
//        Marca m2 = Marca.getInstance("Pepsi", "PepsiCO", "22222222222222");
//        inserirMarca(m2);
//        Marca m3 = Marca.getInstance("Bauducco", "Pandurata Alimentos Ltda", "33333333333333");
//        inserirMarca(m3);
//
//        // -- produtos --
//        Produto p1 = Produto.getInstance("Panetone", m3, 200, 15.0);
//        inserirProd(p1);
//        Produto p2 = Produto.getInstance("Doritos", m2, 1000, 19.5);
//        inserirProd(p2);
//        Produto p3 = Produto.getInstance("Quaker", m2, 200, 8.0);
//        inserirProd(p3);
//        Produto p4 = Produto.getInstance("Leite Moça", m1, 400, 12.5);
//        inserirProd(p4);
//        Produto p5 = Produto.getInstance("KitKat", m1, 300, 4.0);
//        inserirProd(p5);
//
//        // -- vendas --
//        //O atendente realiza a busca e insere os produtos no carrinho, relacionando o preço de venda e a
//        //quantidade (Item). Esse carrinho conterá referências para diversos itens vendidos. O carrinho deverá ficar aberto
//        //enquanto o atendente realiza a venda.
//        //* local date é YYYY-MM-DD
//        Carrinho c1 = Carrinho.getInstance();
//        Item i1 = Item.getInstance(p1, p1.getPreco(), 2);
//        Item i2 = Item.getInstance(p5, p5.getPreco(), 5);
//
//        c1.addItem(i1);
//        c1.addItem(i2);
//
//        Venda v1 = Venda.getInstance(LocalDate.of(2026, 2, 5), new ArrayList<>(c1.getItens()), "Jorge Ben Jor");
//        vVenda.add(v1);
//        //isso aqui eh o mais próximo de construtor de cópia
//
//        Carrinho c2 = Carrinho.getInstance();
//        Item i3 = Item.getInstance(p2, p2.getPreco(), 4);
//        c2.addItem(i3);
//
//        Venda v2 = Venda.getInstance(LocalDate.of(2026, 6, 19), new ArrayList<>(c2.getItens()), "Chico Buarque");
//        vVenda.add(v2);
//
//    }
//
//    // -- produtos --
//    boolean inserirProd(Produto p) {
//        if (p == null) {
//            return false;
//        }
//
//        for (int i = 0;  i < vProd.size() ; i++) { //não pode inserir prod com msm nome
//            Produto produtosLista = vProd.get(i);
//            if (produtosLista.getNome().equalsIgnoreCase(p.getNome())) {
//                //achou produto com mesmo nome
//                return false; // cancela a inserção pq o nome é repetido
//            }
//        }
//        vProd.add(p);
//        return true;
//    }
//
//    public Produto buscarObjProd(int codigo) {
//        for (int i = 0; i < vProd.size(); i++) {
//            Produto produtosLista = vProd.get(i);
//            if (produtosLista.getCodigo() == (codigo)) {
//                return produtosLista; // retorna o obj prod completo
//            }
//        }
//        return null; // Não encontrou a marca
//    }
//
//    int buscarProd(String nomeProd) {
//        for (int i = 0;  i < vProd.size() ; i++) {
//            Produto produtosLista = vProd.get(i);
//            if (produtosLista.getNome().equalsIgnoreCase(nomeProd)) {
//                return produtosLista.getCodigo();
//            }
//        }
//        return -1; //não encontrou
//    } //verifica se acha o nome do prod na lista e retorna o código
//
//
//
//    boolean buscarCodProd(int codProd) {
//        for (int i = 0;  i < vProd.size() ; i++) {
//            Produto produtosLista = vProd.get(i);
//            if (produtosLista.getCodigo() == (codProd)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean updateProd (int codProduto, String nomeP, int quantNova, double precoNovo, Marca marcaNova) {
//        for (int i = 0; i < vProd.size(); i++) {
//            Produto produtosLista = vProd.get(i);
//            if (produtosLista.getCodigo() == codProduto) {
//                produtosLista.setNome(nomeP);
//                produtosLista.setQuantidade(quantNova);
//                produtosLista.setPreco(precoNovo);
//                produtosLista.setMarca(marcaNova);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    boolean excluirProd(int codigo) {
//        Produto p = buscarObjProd(codigo);
//        if (p == null) //se n achar prod com esse codigo
//            return false;
//
//        if (produtoTemVenda(p)) {
//            p.setExcluido(true);
//        } else {
//            vProd.remove(p);
//        }
//        return true;
//    }
//
//
//    boolean produtoTemVenda(Produto produto) {
//        for (int i = 0; i < vVenda.size(); i++) {
//            Venda venda = vVenda.get(i);
//            for (int j = 0; j < venda.getItensVendidos().size(); j++) {
//                Item item = venda.getItensVendidos().get(j);
//                if (item.getProduto().getCodigo() == produto.getCodigo()) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//
//    // -- marcas --
//    //CRUD (Create, Read, Update, Delete)
//    void inserirMarca(Marca m) {
//        if (m != null) {
//            vMarca.add(m);
//        }
//    }
//    //verificação p achar e devolver o código da marca
//    public int buscarMarca(String nomeMarca) {
//        for (int i = 0;  i < vMarca.size() ; i++) {
//            Marca marcasLista = vMarca.get(i);
//            if (marcasLista.getNomeFantasia().equals(nomeMarca)) {
//                return marcasLista.getCodigo();
//            }
//        }
//        return -1; //não encontrou
//    }
//
//    public Marca buscarMarcaPorNome(String nome) {
//        for (int i = 0; i < vMarca.size(); i++) {
//            Marca marcasLista = vMarca.get(i);
//            if (marcasLista.getNomeFantasia().equalsIgnoreCase(nome)) {
//                return marcasLista; // Retorna o objeto Marca completo!
//            }
//        }
//        return null; // Não encontrou a marca
//    }
//
//    public Marca devolverMarcaCod(int codigo) {
//        for (int i = 0;  i < vMarca.size() ; i++) {
//            Marca marcasLista = vMarca.get(i);
//            if (marcasLista.getCodigo() == (codigo)) {
//                return marcasLista;
//            }
//        }
//        return null; //não encontrou
//    }
//
//
//    public boolean updateMarca (int codigoMarca, String nome, String fab) {
//        for (int i = 0;  i < vMarca.size() ; i++) {
//            Marca marcasLista = vMarca.get(i);
//            if (marcasLista.getCodigo() == codigoMarca) {
//                marcasLista.setNomeFantasia(nome);
//                marcasLista.setNomeFabricante(fab);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    boolean marcaTemProduto(Marca marca) {
//        for (int i = 0; i < vProd.size(); i++) {
//            Produto produtosLista = vProd.get(i);
//            if (produtosLista.getMarca().getCodigo() == marca.getCodigo()) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    boolean excluirMarca(int codigo) {
//        //não deve ser possível excluir marca q já tenha um produto
//        Marca marcaRecebida = devolverMarcaCod(codigo);
//        if (marcaRecebida == null)
//            return false;
//
//        if (marcaTemProduto(marcaRecebida))
//            return false;
//
//        vMarca.remove(marcaRecebida);
//        return true;
//    }
//
//    //verificação p dizer se o código da marca existe
//    boolean buscarCodMarca(int codMarca) {
//        for (int i = 0;  i < vMarca.size() ; i++) {
//            Marca marcasLista = vMarca.get(i);
//            if (marcasLista.getCodigo() == (codMarca)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    // -- vendas + carrinho --
//    //venda tem q deixar inserir prod no carrinho e finalizar venda
//
//    boolean inserirProdCarrinho(int codigoProduto, int quantidade) {
//        Produto p = buscarObjProd(codigoProduto); //buscando o objeto Produto dentro da lista produtos
//        //se achar, p vai se tornar uma referência p um produto q já existe
//        if (p == null) {
//            return false;
//        } //se não achar, não insere
//
//        if (quantidade > p.getQuantidade()) {
//            return false;
//        } //p impedir de tornar quant negativa
//
//        if (p.isExcluido()) {
//            return false;
//        } //p impedir de vender se excluido
//
//        if (carrinho == null) {
//            return false;
//        } //p impedir que insira caso a venda n tenha sido iniciada
//
//        Item item = Item.getInstance(p, p.getPreco(), quantidade);
//        //item aponta pro mesmo produto !!!
//        //ai pega essa referência de produto e insere no carrinho
//
//        carrinho.addItem(item);
//        return true;
//    }
//
//    boolean finalizarVenda(String cliente) {
//        if (carrinho.getItens().size() == 0) { //se o carrinho tiver vazio ele n vende nada
//            return false;
//        }
//        for (int i = 0; i < carrinho.getItens().size(); i++) {
//            //primeiro for p verificar se pode vender
//            Item item = carrinho.getItens().get(i);
//            Produto produto = item.getProduto();
//            if (item.getQuantidade() > produto.getQuantidade()) { //p impedir estoque negativo
//                return false;
//            }
//        }
//
//        List<Item> itensVenda = new ArrayList<>();
//
//        for (int i = 0; i < carrinho.getItens().size(); i++) {
//            Item copia = Item.getInstance(carrinho.getItens().get(i));
//            itensVenda.add(copia);
//        }
//
//        Venda venda = Venda.getInstance(
//                LocalDate.now(),
//                itensVenda,
//                cliente
//        );
//
//        vVenda.add(venda); //guarda a venda
//
//        for (int i = 0; i < carrinho.getItens().size(); i++) {
//            //segundo for p alterar o estoque
//            Item item = carrinho.getItens().get(i);
//            Produto produto = item.getProduto();
//            produto.setQuantidade(produto.getQuantidade() - item.getQuantidade());
//        }
//
//        carrinho.limparCarrinho(); //limpando o carrinho
//        return true;
//
//
//    }
//
//    void iniciarVenda() {
//        //vai abrir o carrinho
//        carrinho = Carrinho.getInstance();
//    }
//
//
//    public List<Item> listarCarrinho() {
//        return carrinho.getItens();
//    }   //vai exibir os trem do carrinho
//
//    // -- usuários --
//
//    void inserirUsuario(Usuario u) {
//        //* usando o add pra adicionar um objeto dentro do ArrayList
//        if (u != null) {
//            //if (u != null && buscarUsuario(u.getLogin()) == null) {
//            usuarios.add(u);
//        }
//    }
//
//    public Usuario loginUsuario(String nomeUsuario, String senhaLogin) {
//        for (int i = 0; i < usuarios.size() ; i++) {
//            Usuario usuariosLista = usuarios.get(i);
//            if (usuariosLista.getNomeUsuario().equals(nomeUsuario) && usuariosLista.getSenha().equals(senhaLogin)) {
//                return usuariosLista;
//            }
//        }
//        return null;
//    }
//
//    public void mudarTipoUsuario(Usuario usuario) {
//        if (usuario != null) {
//            usuario.mudarTipoUsuario();
//        }
//    }
//
//    // -- listagens --
//    //listagem produtos d uma marca
//    public List<Produto> listarProdMarca(int codigoMarca) {
//        List<Produto> lista = new ArrayList<>();
//        for (int i = 0; i < vProd.size(); i++) {
//            Produto p = vProd.get(i);
//            if (p.getMarca().getCodigo() == codigoMarca) {
//                lista.add(p);
//            }
//        }
//        return lista;
//    }
//
//    public List<Produto> listarProdAlfabetica() {
//        ArrayList<Produto> aux = new ArrayList<>();
//        for (int i = 0; i < vProd.size(); i++) {
//            aux.add(vProd.get(i));
//        }
//        for (int i = 0; i < aux.size(); i++) {
//            for (int j = i + 1; j < aux.size(); j++) {
//                if (aux.get(i).getNome().compareToIgnoreCase(aux.get(j).getNome()) > 0) {
//                    Produto temp = aux.get(i);
//                    aux.set(i, aux.get(j));
//                    aux.set(j, temp);
//
//                }
//            }
//        }
//
//        return aux;
//    }
//    public List<Venda> listarVendaDia(LocalDate data) {
//        List<Venda> lista = new ArrayList<>();
//        for (int i = 0; i < vVenda.size(); i++) {
//            Venda v = vVenda.get(i);
//            if (v.getData().equals(data)) {
//                lista.add(v);
//            }
//
//        }
//        return lista;
//    }
//
//    public Venda buscarVenda(int codigo) {
//        for (int i = 0; i < vVenda.size(); i++) {
//            Venda v = vVenda.get(i);
//            if (v.getCodigo() == codigo) {
//                return v;
//            }
//
//        }
//        return null;
//    }
//
//    //pseudogetters
//    public List<Marca> listarMarcas() {
//        return vMarca;
//    }
//    public List<Venda> getVendas() {
//        return vVenda;
//    }
//    public List<Usuario> getUsuarios() {
//        return usuarios;
//    }
//    public List<Produto> getProdutos() {
//        return vProd;
//    }
//}

