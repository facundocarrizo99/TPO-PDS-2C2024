package Modelo.Rutina;

public class EjercicioRealizado {
    private int cantidadSeries;
    private int repeticiones;
    private Double peso;
    private Ejercicio ejercicio;

    public EjercicioRealizado(int cantidadSeries, int repeticiones, Double peso, Ejercicio ejercicio) {
        this.cantidadSeries = cantidadSeries;
        this.repeticiones = repeticiones;
        this.peso = peso;
        this.ejercicio = ejercicio;
    }

    public int getCantidadSeries() {
        return cantidadSeries;
    }

    public void setCantidadSeries(int cantidadSeries) {
        this.cantidadSeries = cantidadSeries;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }
    //TODO: To Strings
}
