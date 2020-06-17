package freezone.ec.petagram;

public class Mascota {
    private String nombre;
    // int porque se encuentra en drw
    private int foto;
    private int numero;



    //definimos el constructor
    public Mascota(String nombre, int foto,int numero){
        this.nombre = nombre;
        this.foto = foto;
        this.numero  = numero;

    }

    public String getNumero() {

        return String.valueOf(numero);
        //transforme de int a sring y poder mostrar en el txt view
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
