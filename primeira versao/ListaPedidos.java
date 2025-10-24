public class ListaPedidos {
    private No cabeca;
    private int tamanho;

    public boolean estaVazia() {
        return cabeca == null;
    }

    public int tamanho() {
        return tamanho;
    }

    public void inserirPedido(Pedido pedido) {
        if (buscarPorId(pedido.id) != null) {
            System.out.println("Pedido duplicado! ID já existe.");
            return;
        }

        if (pedido.tipo.equalsIgnoreCase("Urgente")) {
            inserirNoInicio(pedido);
        } else if (pedido.tipo.equalsIgnoreCase("Prioritario")) {
            inserirNaPosicaoMedia(pedido);
        } else {
            inserirNoFim(pedido);
        }
    }

    private void inserirNoInicio(Pedido pedido) {
        No novo = new No(pedido);
        novo.proximo = cabeca;
        cabeca = novo;
        tamanho++;
    }

    private void inserirNoFim(Pedido pedido) {
        No novo = new No(pedido);
        if (cabeca == null) {
            cabeca = novo;
        } else {
            No atual = cabeca;
            while (atual.proximo != null)
                atual = atual.proximo;
            atual.proximo = novo;
        }
        tamanho++;
    }

    private void inserirNaPosicaoMedia(Pedido pedido) {
        int pos = tamanho / 2;
        No novo = new No(pedido);

        if (cabeca == null) {
            cabeca = novo;
        } else {
            No atual = cabeca;
            for (int i = 0; i < pos - 1 && atual.proximo != null; i++) {
                atual = atual.proximo;
            }
            novo.proximo = atual.proximo;
            atual.proximo = novo;
        }
        tamanho++;
    }

    public Pedido buscarPorId(int id) {
        No atual = cabeca;
        while (atual != null) {
            if (atual.pedido.id == id) return atual.pedido;
            atual = atual.proximo;
        }
        return null;
    }

    public Pedido buscarPorPosicao(int pos) {
        if (pos < 0 || pos >= tamanho) return null;
        No atual = cabeca;
        for (int i = 0; i < pos; i++) atual = atual.proximo;
        return atual.pedido;
    }

    public void removerInicio() {
        if (cabeca != null) {
            cabeca = cabeca.proximo;
            tamanho--;
        }
    }

    public void removerFim() {
        if (cabeca == null) return;
        if (cabeca.proximo == null) {
            cabeca = null;
        } else {
            No atual = cabeca;
            while (atual.proximo.proximo != null)
                atual = atual.proximo;
            atual.proximo = null;
        }
        tamanho--;
    }

    public void removerPosicao(int pos) {
        if (pos < 0 || pos >= tamanho) return;
        if (pos == 0) {
            removerInicio();
            return;
        }
        No atual = cabeca;
        for (int i = 0; i < pos - 1; i++) atual = atual.proximo;
        atual.proximo = atual.proximo.proximo;
        tamanho--;
    }

    public void imprimirPedidos() {
        No atual = cabeca;
        if (atual == null) {
            System.out.println("Nenhum pedido na lista.");
            return;
        }
        System.out.println("Lista de pedidos em ordem de atendimento:");
        while (atual != null) {
            System.out.println(atual.pedido);
            atual = atual.proximo;
        }
    }
}
