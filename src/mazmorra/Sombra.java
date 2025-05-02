package mazmorra;

public class Sombra implements Enemy{
    private String nombre = "Monstruo sombra";
    private int salud = 80;
    private int daño = 20;

    @Override
    public String getNombre() {
        return "Sombra";
    }

    @Override
    public int getSalud() {
        return salud;
    }

    @Override
    public int getDaño() {
        return daño;
    }

    @Override
    public void atacar(Player jugador) {
        System.out.println(nombre + " envuelve al jugador en oscuridad y causa " + daño + " de daño.");
        jugador.recibirDaño(daño);
    }

    @Override
    public void recibirDaño(int cantidad) {
        salud = Math.max(0, salud - cantidad);
        System.out.println(nombre + " fue herida con " + cantidad + " de daño.");

    }

    @Override
    public boolean estaVivo() {
        return salud > 0;
    }
}
