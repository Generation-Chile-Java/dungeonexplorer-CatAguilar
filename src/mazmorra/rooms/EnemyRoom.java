package mazmorra.rooms;

import mazmorra.Enemy;
import mazmorra.Player;
import mazmorra.objetos.Lampara;

import java.util.Random;

public class EnemyRoom implements Room {
    private String nombre;
    private String descripcion;
    private int daño;
    private Enemy enemigo;
    private boolean derrotado = false;

    public EnemyRoom(int daño) {
        this.daño = new Random().nextInt(20) + 5;
    }

    public EnemyRoom(String nombre, String descripcion, Enemy enemigo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.enemigo = enemigo;
    }

    @Override
    public void entrar(Player jugador) {

        if(derrotado){
            System.out.println("Haz derrotado a un peón, la sala se ilumina");
            return;
        }

        System.out.println("¡Un " + enemigo.getNombre() + " aparece!");

        while (enemigo.estaVivo() && jugador.getHealth() > 0) {
            enemigo.recibirDaño(15); // Ataque fijo del jugador
            if (enemigo.estaVivo()) {
                enemigo.atacar(jugador);
            }
        }

        if (jugador.getHealth() > 0) {
            System.out.println("Has derrotado al " + enemigo.getNombre() + " y encuentras una lámpara.");
            jugador.guardarObjeto(new Lampara());
            derrotado = true;
        } else {
            System.out.println("¡Has sido derrotado por el " + enemigo.getNombre() + "!");
        }

    }
}
