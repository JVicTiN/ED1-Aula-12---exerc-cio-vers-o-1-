import java.util.LinkedList;

public class GestorPedidos {
    private LinkedList<Pedido> pedidos;

    public GestorPedidos() {
        pedidos = new LinkedList<>();
    }

    public boolean estaVazia() {
        return pedidos.isEmpty();
    }

    public int tamanho() {
        return pedidos.size();
    }

    public void inserirPedido(Pedido pedido) {
        // Verifica duplicado
        for (Pedido p : pedidos) {
            if (p.id == pedido.id) {
                System.out.println("Pedido duplicado! ID já existe.");
                return;
            }
        }

        switch (pedido.tipo.toLowerCase()) {
            case "urgente" -> pedidos.addFirst(pedido);
            case "prioritario" -> {
                int pos = pedidos.size() / 2;
                pedidos.add(pos, pedido);
            }
            default -> pedidos.addLast(pedido);
        }
    }

    public void removerInicio() {
        if (!pedidos.isEmpty()) {
            System.out.println("Pedido atendido: " + pedidos.removeFirst());
        } else {
            System.out.println("Nenhum pedido para atender.");
        }
    }

    public void removerFim() {
        if (!pedidos.isEmpty()) {
            System.out.println("Pedido cancelado: " + pedidos.removeLast());
        } else {
            System.out.println("Nenhum pedido para cancelar.");
        }
    }

    public void removerPosicao(int pos) {
        if (pos < 0 || pos >= pedidos.size()) {
            System.out.println("Posição inválida!");
            return;
        }
        System.out.println("Pedido cancelado: " + pedidos.remove(pos));
    }

    public Pedido buscarPorId(int id) {
        for (Pedido p : pedidos) {
            if (p.id == id) return p;
        }
        return null;
    }

    public Pedido buscarPorPosicao(int pos) {
        if (pos < 0 || pos >= pedidos.size()) return null;
        return pedidos.get(pos);
    }

    public void imprimirPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido na fila.");
            return;
        }

        System.out.println("\nLista de pedidos em ordem de atendimento:");
        for (Pedido p : pedidos) {
            System.out.println(p);
        }
    }
}
