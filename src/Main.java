import entidades.ListaCompras;
import entidades.Menu;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.selecionarOpcoes(new ListaCompras());

        System.out.println("Encerrando o programa...");
    }
}