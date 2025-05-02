package mazmorra.objetos;

public class Tesoro implements GameObject {
    private String nombre;

    public Tesoro() {
        this.nombre = "Tesoro Final";
    }

    @Override
    public void usar() {
        System.out.println("Este objeto no se puede usar directamente.");
    }

    @Override
    public String getTipo() {
        return "Tesoro";
    }

    @Override
    public String getDescripcion() {
        return "Una misteriosa moneda con una inscripción en el reverso.";
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}
