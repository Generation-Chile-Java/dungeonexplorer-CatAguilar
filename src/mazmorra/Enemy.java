package mazmorra;

public interface Enemy {
        String getNombre();
        int getSalud();
        int getDaño();
        void atacar(Player jugador);
        void recibirDaño(int cantidad);
        boolean estaVivo();


}
