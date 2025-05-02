package mazmorra.rooms;

import mazmorra.Player;

import java.util.Random;

public class EmptyRoom implements Room {
    private String nombre;
    private String descripcion;

    public EmptyRoom(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }


    @Override
    public void entrar(Player jugador) {

        Random rand = new Random();
        int evento = rand.nextInt(3);

        switch (evento){
            case 0: {
                System.out.println("Ves una inscripción en la pared.");
                System.out.println("Cuidado con el monstruo de las sombras, ningun arma le hace daño");
                break;
            }

            case 1: {
                System.out.println("Haz entrado a un habitación brillante y sientes que tu salud mejora");
                int curacion = rand.nextInt(15) + 5;
                jugador.sanar(curacion);
                break;
            }

            case 2: {
                System.out.println("La sala está realmente vacía... pero se siente un poco inquietante.");
                break;
            }
        }



    }
}
