package mazmorra.objetos;

public class Llave implements GameObject {

    @Override
    public void usar() {

    }

    @Override
    public String getNombre() {
        return "Llave";
    }

    @Override
    public String getTipo() {
        return "abre y cierra";
    }

    @Override
    public String getDescripcion() {
        return "una llave dorada, me pregunto para que servirá";
    }
}
