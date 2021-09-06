package pdflabel;

public class Producto {
    private String barra;
    private String descrip;
    private boolean imprimir;

    public Producto(String barra, String descrip, boolean imprimir) {
        this.barra = barra;
        this.descrip = descrip;
        this.imprimir = imprimir;
    }

    public String getBarra() {
        return barra;
    }

    public void setBarra(String barra) {
        this.barra = barra;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public boolean isImprimir() {
        return imprimir;
    }

    public void setImprimir(boolean imprimir) {
        this.imprimir = imprimir;
    }


}
