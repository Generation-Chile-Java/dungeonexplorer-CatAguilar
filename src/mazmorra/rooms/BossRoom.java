package mazmorra.rooms;

import mazmorra.Enemy;
import mazmorra.Player;
import mazmorra.Sombra;

public class BossRoom implements Room{
    private Enemy jefeFinal;
    private String nombre;
    private String descripcion;
    private boolean derrotado = false;



    public BossRoom(String nombre, String descripcion, Enemy jefe) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.jefeFinal = jefe;
    }


    @Override
    public void entrar(Player jugador) {
        if(!jefeFinal.estaVivo()){
            System.out.println("Haz derrotado al monstruo sombra, la sala se ilumina");
            return;
        }

        System.out.println("Estas en una habitacion y vez una sombra moverse");
        System.out.println("¡TE ATACA DE LA NADA!");
        jugador.recibirDaño(15);

        if (jugador.hasObjeto("Lampara")) {
            System.out.println("Usas la lámpara y revelas la figura de la " + jefeFinal.getNombre() + "...");
            System.out.println("¡Comienza la batalla final!");

            while (jefeFinal.estaVivo() && jugador.getHealth() > 0) {
                jefeFinal.recibirDaño(20); // el jugador ataca con daño fijo
                if (jefeFinal.estaVivo()) {
                    jefeFinal.atacar(jugador);
                }

            }

            if (jugador.getHealth() > 0) {
                System.out.println("¡Has vencido a la " + jefeFinal.getNombre() + "! Eres libre.");
            } else {
                System.out.println("La " + jefeFinal.getNombre() + " te ha vencido...");
            }

        }else{
            System.out.println("No tienes cómo enfrentarla. Te envuelve la oscuridad");
            jugador.recibirDaño(100);
        }
    }
}
