package mazmorra.objetos;

public class Lampara implements GameObject {


    @Override
    public void usar() {

    }

    @Override
    public String getNombre() {
        return "Lampara";
    }

    @Override
    public String getTipo() {
        return "objeto";
    }

    @Override
    public String getDescripcion() {
        return "una lampara a gas, tiene poca carga";
    }
}





