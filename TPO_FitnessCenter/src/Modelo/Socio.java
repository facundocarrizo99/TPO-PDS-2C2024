package Modelo;

import Modelo.Objetivo.Objetivo;
import Modelo.Peso.Peso;
import java.util.Date;

public class Socio inherits Usuario {
    private Date fechaNacimiento;
    private char sexo;
    private Peso peso;
    private double altura;
    private Objetivo objetivo;

    public Socio(Date fechaNacimiento, char sexo, Peso peso, double altura, Objetivo objetivo) {
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
        this.objetivo = objetivo;
    }

    public void cambiarObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Peso getPeso() {
        return peso;
    }

    public void setPeso(Peso peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }
}
