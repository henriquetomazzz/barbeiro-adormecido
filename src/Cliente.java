public class Cliente extends Thread {

    private int id;
    private Barbearia barbearia;

    public Cliente(int id, Barbearia barbearia) {
        this.id = id;
        this.barbearia = barbearia;
    }

    @Override
    public void run() {
        barbearia.entrar(id);
    }
}