package mazmorra.rooms;

import mazmorra.Player;
import mazmorra.objetos.GameObject;
import mazmorra.objetos.Tesoro;

public class TreasureRoom implements Room {
    private String nombre;
    private String descripcion;
    private GameObject objeto;  // El tesoro que vas a dar

    public TreasureRoom(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.objeto = new Tesoro();  // Aquí se asegura que no sea null
    }

    @Override
    public void entrar(Player jugador) {
        System.out.println("Estás en " + nombre + ": " + descripcion);
        if (objeto != null) {
            System.out.println("¡Encontraste un tesoro: " + objeto.getNombre() + "!");
            jugador.guardarObjeto(objeto);
            objeto = null;
            System.out.println("Es una misteriosa moneda. En el reverso dice:");
            System.out.println("\n\"Pide un deseo para salir de la cueva...\"");
        } else {
            System.out.println("Pero ya no hay nada aquí...");
        }
    }
}
