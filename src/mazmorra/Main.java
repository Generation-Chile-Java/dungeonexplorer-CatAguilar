package mazmorra;
//Define una clase principal que inicialice el jugador y una serie de salas.
//Implementa un bucle que permita al jugador moverse por las salas.
//Maneja las interacciones del jugador con las salas y los objetos.

import mazmorra.objetos.Dados;
import mazmorra.rooms.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido, ¿Cuál es tu nombre?");
        String nombre = sc.nextLine();
        System.out.println("¿Necesitas instrucciones? " + nombre + " S/N");
        String res1 = sc.nextLine();
        if(res1.equalsIgnoreCase("S")){
            System.out.println(""" 
            Instrucciones del juego: 
            1.- Para moverte entre salas tienes que tirar el dado
            2.- Para ver los objetos que llevas usa el comando inventario
            3.- Para ver tu nivel de salud usa el comando estado
            4.- Puedes usar comandos como entrar para avanzar
                    """);
        }

        System.out.println("""
            Estás frente a una torre con forma de capitoné. Alrededor solo hay bosque, tan oscuro que no ves más allá de los troncos cercanos.
            En la torre hay una inscripción de cobre que dice:
            "Bienvenido a la mazmorra de las trampas"
        """);


        System.out.println("Avanzas con cautela dentro de la torre... Hay una pequeña mesa de piedra.");
        System.out.println("Sobre ella, ves un par de dados viejos de hueso. Los tomas.");


        Player jugador = new Player();
        Dados dados = new Dados();
        jugador.guardarObjeto(dados);
        System.out.println("Has guardado: " + dados.getNombre());



        // Crear salas
        Room emptyRoom1 = new EmptyRoom("Sala Vacía 1", "Hay símbolos en las paredes que insinúan peligros al norte.");
        Room emptyRoom2 = new EmptyRoom("Sala Vacía 2", "Encuentras una manzana medio podrida. Aun así, recuperas algo de energía.");
        Enemy peon = new Peon(); // <- Tu clase Peon debe existir
        Room enemyRoom = new EnemyRoom("Sala del Peón", "Un pasillo oscuro revela un enemigo esperando.", peon);

        Enemy jefeFinal = new Sombra();
        Room bossRoom = new BossRoom("Cámara de la Sombra", "Un aura oscura llena esta sala. El monstruo final espera.", jefeFinal);
        Room treasureRoom = new TreasureRoom("Tesoro", "Brilla intensamente. ¡Has ganado!");

        boolean juegoActivo = true;


        while (juegoActivo && jugador.getHealth() > 0) {
            System.out.println("¿Qué deseas hacer ahora? (estado / inventario / dados / salir)");
            String comando = sc.nextLine();

            if (comando.equalsIgnoreCase("estado")) {
                jugador.estado();
                continue;
            } else if (comando.equalsIgnoreCase("inventario")) {
                jugador.showInventario();
                continue;
            } else if (comando.equalsIgnoreCase("salir")) {
                juegoActivo = false;
                System.out.println("Abandonaste la torre. ¡Otra vez será!");
                break;
            } else if (!comando.equalsIgnoreCase("dados")) {
                System.out.println("Comando no reconocido. Usa: estado / inventario / avanzar / salir");
                continue;
            }

            // Tirando los dados
            System.out.println("\nTirando los dados para avanzar...");
            int resultado = dados.tirar();
            System.out.println("Obtuviste: " + resultado);

            // Selección de sala según resultado
            if (resultado == 2) {
                // Entrada especial por suerte extrema
                System.out.println("¡Increíble! Un camino oculto se revela por suerte.");
                treasureRoom.entrar(jugador);

            } else if (resultado >= 3 && resultado <= 6) {
                emptyRoom1.entrar(jugador);

            } else if (resultado >= 7 && resultado <= 10) {
                enemyRoom.entrar(jugador);

            } else if (resultado == 11 || resultado == 12) {
                bossRoom.entrar(jugador);

                // Si sobrevive después de la pelea contra el jefe, accede al teasureRoom
                if (jugador.getHealth() > 0) {
                    treasureRoom.entrar(jugador);
                    System.out.println("\n ¡Has Logrado salir de la Mazmorra de las trampas!");
                    juegoActivo = false; // Termina el juego

                }
            }

        }
    }
}



        


        

        



