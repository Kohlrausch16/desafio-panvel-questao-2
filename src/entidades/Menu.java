package entidades;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private void imprimirMenuInicial(){
        System.out.println(
                "==============================\n" +
                "GERENCIADOR LISTA DE COMPRAS\n" +
                "==============================\n"
        );

        System.out.println(
                "1 - Adicionar produto\n" +
                "2 - Remover produto\n" +
                "3 - Listar produtos\n" +
                "4 - Marcar produto como comprado\n" +
                "5 - Total de produtos\n" +
                "6 - Encerrar programa\n");

        System.out.print("Opção selecionada: ");
    }

    private void limparTerminal(){
        System.out.print("\033[H\033[2J");
        System.out.flush();

        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

    private String capturarNomeProduto(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome do item: ");
        return sc.next();
    }

    private void verificarOpcoes(Integer opcao, ListaCompras listaCompras){

        switch(opcao){
            case 1 -> listaCompras.adicionarProduto(this.capturarNomeProduto());
            case 2 -> listaCompras.removerProduto(this.capturarNomeProduto());
            case 3 -> listaCompras.listarProdutos();
            case 4 -> listaCompras.marcarComprado(this.capturarNomeProduto());
            case 5 -> listaCompras.totalProdutos();
        }

    }

    public void selecionarOpcoes(ListaCompras listaCompras){
        Scanner sc = new Scanner(System.in);
        int opcao;

        while(true) {
            this.limparTerminal();
            this.imprimirMenuInicial();

            try{
                opcao = sc.nextInt();

                if(opcao == 6) return;

                this.verificarOpcoes(opcao, listaCompras);

            } catch (InputMismatchException e){
                System.out.println("Valor inválido!");
                break;
            }
        }
    }
}