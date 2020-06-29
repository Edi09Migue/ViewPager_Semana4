package freezone.ec.petagram;

public class Mascota {
    private String nombre;
    // int porque se encuentra en drw
    private int foto;
    private int icono1;
    private int icono2;
    private int numero;


    //definimos el constructor para el RV1
    public Mascota(String nombre, int foto,int numero,int  icono1, int icono2){
        this.nombre = nombre;
        this.foto = foto;
        this.numero  = numero;
        this.icono1  = icono1;
        this.icono2  = icono2;
    }


    //definimos el constructor para el RV2
    public Mascota(int foto,int numero, int icono2){
        this.foto = foto;
        this.numero  = numero;
        this.icono2  = icono2;

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


    public int getIcono1() {
        return icono1;
    }

    public void setIcono1(int icono1) {
        this.icono1 = icono1;
    }


    public int getIcono2() {
        return icono2;
    }

    public void setIcono2(int icono2) {
        this.icono2 = icono2;
    }

}

