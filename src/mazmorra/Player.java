package mazmorra;

//Define una clase Player que encapsule los datos y comportamientos del jugador.
//La clase debe incluir atributos como name, health, e inventory.
//Proporciona métodos para que el jugador pueda recibir daño, recoger objetos y mostrar su estado actual.

import mazmorra.objetos.GameObject;

import java.util.ArrayList;
import java.util.List;

public class Player{

    private String name;
    private int health;
    private int maxHealth;
    private boolean hasKey;

    //Crear un inventario para que guarde los objetos que encuentra
    List<GameObject> inventario = new ArrayList<>();

    //constructores

    public Player(){
        this.name = "Jugador";
        this.health = 100;
        this.maxHealth = 100;
        this.hasKey = false;
        this.inventario = new ArrayList<>();
    }

    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.maxHealth = 100;
        this.hasKey = false;
        this.inventario = new ArrayList<>();
    }

    //getter and setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public boolean isHasKey() {
        return hasKey;
    }

    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;
    }

    public List<GameObject> getInventario() {
        return inventario;
    }

    public void setInventario(List<GameObject> inventario) {
        this.inventario = inventario;
    }


    //Acciones o métodos

    public void guardarObjeto(GameObject objeto){
        inventario.add(objeto);
        System.out.println("Has guardado: " + objeto);
    }

    public void recibirDaño(int daño){
        if(daño > 0){
            health = Math.max(0, health - daño);
            System.out.println("Has recibido " + daño + " daño!");

            if(health == 0){
                System.out.println("¡Has sido derrotado!");
            }
        }
    }

    public void sanar(int cura){
        if(cura>0){
            health = Math.min(maxHealth, health + cura);
            System.out.println("Has recuperado " + cura + "puntos de salud");
        }
    }

    public void estado(){
        System.out.println("\n=== ESTADO ===");
        System.out.println("Nombre: " + name);
        System.out.println("Tu salud esta en " + health);
    }

    public void showInventario(){
        if(inventario.isEmpty()){
            System.out.println("Tu inventario está vacío");
        }else {
            System.out.println("Lista del Inventario");
            for(GameObject objeto : inventario){
                System.out.println("- " + objeto.getNombre() + "(" + objeto.getTipo() + ")");
                if (objeto.getDescripcion() != null){
                    System.out.println("  " + objeto.getDescripcion());
                }
            }
        }
    }

    public boolean hasObjeto(String objetoNombre){
        return inventario.stream().anyMatch(objeto->objeto.getNombre().equalsIgnoreCase(objetoNombre));
    }
}