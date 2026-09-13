package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ListaCompras {

    private List<Produto> listaCompras;

    public ListaCompras(){
        this.listaCompras = new ArrayList<>();
    }

    public void adicionarProduto(String produto){
        listaCompras.add(new Produto(produto, false));
    }

    public void removerProduto(String produto){
        Produto produtoEncontrado = this.buscarProdutoPorNome(produto);

        if(produtoEncontrado != null)
            this.listaCompras.remove(produtoEncontrado);
    }

    public void listarProdutos(){

        if(listaCompras.isEmpty()){
            this.imprimirMensagem("A lista está vazia :(");
            return;
        }

        for(Produto produto : listaCompras){
            this.imprimirMensagem(
                    produto.getNome() + (produto.getComprado() ? " - comprado" : "")
            );
        }

        capturaAcaoUsuario();
    }

    public void marcarComprado(String produto){
        Produto produtoEncontrado = this.buscarProdutoPorNome(produto);

        if(produtoEncontrado != null)
            produtoEncontrado.setComprado(true);
        else {
            System.out.println("Produto " + produto + " não encontrado");
            capturaAcaoUsuario();
        }
    }

    public void totalProdutos(){
        this.imprimirMensagem("Total de produtos na lista: " + this.listaCompras.size());
        capturaAcaoUsuario();
    }

    private Produto buscarProdutoPorNome(String nome){
        Optional<Produto> produtoEncontrado = listaCompras
                .stream()
                .filter(produto -> produto.getNome().equals(nome))
                .findFirst();

        return produtoEncontrado.orElse(null);
    }

    private void imprimirMensagem(String mensagem){
        System.out.println(mensagem);
    }

    private void capturaAcaoUsuario(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Pressione ENTER para continuar");
        sc.nextLine();
    }

}
