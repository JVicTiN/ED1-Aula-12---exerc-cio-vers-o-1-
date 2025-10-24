import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorPedidos gestor = new GestorPedidos();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Novo pedido");
            System.out.println("2. Atender pedido (remover início)");
            System.out.println("3. Cancelar último pedido");
            System.out.println("4. Cancelar pedido por posição");
            System.out.println("5. Buscar pedido por ID");
            System.out.println("6. Exibir todos pedidos");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            int op = sc.nextInt();

            switch (op) {
                case 1 -> {
                    System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Cliente: "); String nome = sc.nextLine();
                    System.out.print("Item: "); String item = sc.nextLine();
                    System.out.print("Quantidade: "); int q = sc.nextInt();
                    System.out.print("Valor: "); double v = sc.nextDouble(); sc.nextLine();
                    System.out.print("Tipo (Normal, Prioritario, Urgente): "); String tipo = sc.nextLine();

                    if (tipo.equalsIgnoreCase("Urgente")) v *= 1.20;
                    else if (tipo.equalsIgnoreCase("Prioritario")) v *= 1.10;

                    Pedido p = new Pedido(id, nome, item, q, v, tipo);
                    gestor.inserirPedido(p);
                }

                case 2 -> gestor.removerInicio();
                case 3 -> gestor.removerFim();
                case 4 -> {
                    System.out.print("Posição a remover: "); int pos = sc.nextInt();
                    gestor.removerPosicao(pos);
                }
                case 5 -> {
                    System.out.print("ID a buscar: "); int id = sc.nextInt();
                    Pedido encontrado = gestor.buscarPorId(id);
                    if (encontrado != null) System.out.println(encontrado);
                    else System.out.println("Pedido não encontrado!");
                }
                case 6 -> gestor.imprimirPedidos();
                case 0 -> {
                    System.out.println("Encerrando...");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
