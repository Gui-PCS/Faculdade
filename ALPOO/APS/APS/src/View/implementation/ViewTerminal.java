package View.implementation;

public class ViewTerminal implements View.View {

    @Override
    public void init() {

        boolean exit = false;

        while (!exit) {
            System.out.println("Qual operacao deseja realizar?");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Consultar");
            System.out.println("3 - Alterar");
            System.out.println("4 - Excluir");
            System.out.println("0 - Sair");

            int op = new java.util.Scanner(System.in).nextInt();

            switch (op) {
                case 1:
                    System.out.println("Cadastrar");
                    break;
                case 2:
                    System.out.println("Consultar");
                    break;
                case 3:
                    System.out.println("Alterar");
                    break;
                case 4:
                    System.out.println("Excluir");
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        }
    }
}
