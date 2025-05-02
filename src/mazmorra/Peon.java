package mazmorra;

public class Peon implements Enemy{
    private String nombre = "Peón Oscuro";
    private int salud = 20;
    private int daño = 10;

    @Override
    public String getNombre() {
        return "peón";
    }

    @Override
    public int getSalud() {
        return 0;
    }

    @Override
    public int getDaño() {
        return 0;
    }

    @Override
    public void atacar(Player jugador) {
        System.out.println(nombre + " ataca y causa " + daño + "haz algo rápido");
        jugador.recibirDaño(daño);
    }

    @Override
    public void recibirDaño(int cantidad) {
        salud = Math.max(0, salud - cantidad);
        System.out.println(nombre + " recibió " + cantidad + " de daño.");
    }

    @Override
    public boolean estaVivo() {
        return salud > 0;
    }
}
