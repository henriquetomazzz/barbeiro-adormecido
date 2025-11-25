import java.util.concurrent.Semaphore;

public class Barbearia {

    private int cadeirasLivres;
    private Semaphore semaforoClientes;
    private Semaphore semaforoBarbeiro;
    private Semaphore mutex;

    public Barbearia(int numeroCadeiras) {
        this.cadeirasLivres = numeroCadeiras;

        this.semaforoClientes = new Semaphore(0);

        this.semaforoBarbeiro = new Semaphore(0);

        this.mutex = new Semaphore(1);
    }

    public void entrar(int idCliente) {
        try {
            mutex.acquire();

            if (cadeirasLivres > 0) {
                cadeirasLivres--;
                System.out.println("Cliente " + idCliente + " entrou. Cadeiras livres: " + cadeirasLivres);

                semaforoClientes.release();

                mutex.release();

                semaforoBarbeiro.acquire();
                System.out.println("Cliente " + idCliente + " cortou o cabelo e foi embora.");

            } else {
                System.out.println("Cliente " + idCliente + " encontrou barbearia cheia e foi embora.");
                mutex.release();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void cortarCabelo() {
        try {
            semaforoClientes.acquire();

            mutex.acquire();
            cadeirasLivres++;
            mutex.release();

            System.out.println("Barbeiro está cortando cabelo... (Cadeiras livres: " + cadeirasLivres + ")");
            Thread.sleep(2000);

            semaforoBarbeiro.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}