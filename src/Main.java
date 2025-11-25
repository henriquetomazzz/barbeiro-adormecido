public class Main {
    public static void main(String[] args) {

        Barbearia barbearia = new Barbearia(3);

        Barbeiro barbeiro = new Barbeiro(barbearia);
        barbeiro.start();

        for (int i = 1; i <= 10; i++) {
            Cliente cliente = new Cliente(i, barbearia);
            cliente.start();

            try {
                Thread.sleep((long) (Math.random() * 2000));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}