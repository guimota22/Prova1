package classes;
public class Aeronave {
    private String modelo;
    private String numeroSerie;

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getNumeroSerie() {
        return numeroSerie;
    }
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    @Override
    public String toString() {
        String texto = "";
        texto += "\n" + modelo;
        texto += numeroSerie;

        return texto;
    }
}