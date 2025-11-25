public class Barbeiro extends Thread {

    private Barbearia barbearia;

    public Barbeiro(Barbearia barbearia) {
        this.barbearia = barbearia;
    }

    @Override
    public void run() {
        System.out.println("Barbeiro chegou e está esperando clientes (Dormindo)...");

        while (true) {
            barbearia.cortarCabelo();
        }
    }
}