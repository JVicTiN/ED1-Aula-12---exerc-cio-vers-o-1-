public class Pedido {
    int id;
    String nomeCliente;
    String item;
    int quantidade;
    double valor;
    String tipo;

    public Pedido(int id, String nomeCliente, String item, int quantidade, double valor, String tipo) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.item = item;
        this.quantidade = quantidade;
        this.valor = valor;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Pedido ID: " + id + " | Cliente: " + nomeCliente +
               " | Item: " + item + " x" + quantidade +
               " | Valor: R$" + String.format("%.2f", valor) +
               " | Tipo: " + tipo;
    }
}
