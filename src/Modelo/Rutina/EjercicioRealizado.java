package Modelo.Rutina;

public class EjercicioRealizado {
    private Integer cantidadSeries;
    private Integer repeticiones;
    private Double peso;
    private Ejercicio ejercicio;

    public EjercicioRealizado(Integer cantidadSeries, Integer repeticiones, Double peso, Ejercicio ejercicio) {
        this.cantidadSeries = cantidadSeries;
        this.repeticiones = repeticiones;
        this.peso = peso;
        this.ejercicio = ejercicio;
    }

    public Integer getCantidadSeries() {
        return cantidadSeries;
    }

    public void setCantidadSeries(Integer cantidadSeries) {
        this.cantidadSeries = cantidadSeries;
    }

    public Integer getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(Integer repeticiones) {
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
