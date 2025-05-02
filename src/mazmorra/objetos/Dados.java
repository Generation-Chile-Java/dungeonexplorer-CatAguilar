package mazmorra.objetos;

public class Dados implements GameObject {

    @Override
    public void usar() {
        int resultado = tirar();
        System.out.println("Has tirado los dados y obtuviste: " + resultado);
    }

    public int tirar() {
        int dado1 = (int) (Math.random() * 6) + 1;
        int dado2 = (int) (Math.random() * 6) + 1;
        return dado1 + dado2;
    }

    @Override
    public String getNombre() {
        return "Dados";
    }

    @Override
    public String getTipo() {
        return "objeto";
    }

    @Override
    public String getDescripcion() {
        return "Un par de dados de hueso antiguos. Úsalos para avanzar por la torre.";
    }
}
