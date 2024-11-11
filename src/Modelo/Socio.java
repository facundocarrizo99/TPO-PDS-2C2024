package Modelo;

import Interfaeces.IAuth;
import Interfaeces.IObservable;
import Interfaeces.IObserver;
import Modelo.Objetivo.Objetivo;
import Modelo.Peso.BalanzaGim;
import Modelo.Peso.IPesoAdapter;
import Modelo.Peso.Peso;
import Modelo.Trofeo.Trofeo;
import Modelo.Trofeo.TrofeoConstancia;
import Modelo.Trofeo.TrofeoCreido;
import Modelo.Trofeo.TrofeoDedicacion;

import java.util.ArrayList;
import java.util.Date;

public class Socio implements IObservable {
    private String mail;
    private String clave;
    private String nombre;
    private String apellido;
    private int edad;
    private Date fechaNacimiento;
    private String sexo;
    private ArrayList<Peso> pesos = new ArrayList<Peso>();
    private double alturaCM;
    private Objetivo objetivo;
    private int ID;
    private boolean baja;
    private IPesoAdapter balanza = new BalanzaGim();
    private IAuth auth;
    private int token;
    private ArrayList<Trofeo> trofeos = new ArrayList<Trofeo>();
    private ArrayList<IObserver> observers = new ArrayList<IObserver>();

    public void pesarse() {
        Peso nuevoPeso = balanza.obtenerPeso();
        this.pesos.add(nuevoPeso);
        if (objetivo != null) {
            //todo si me peso y cumplo el objetivo entonces cumplo el objetivo y cambio el objetivo
            this.notificar();
        }
    }

    // Constructor, getter y setter //
    public Socio(String mail, String clave, String nombre, String apellido, int edad, Date fechaNacimiento, String sexo, double altura, int ID) {
        this.mail = mail;
        this.clave = clave;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.alturaCM = altura;
        this.ID = ID;
        this.baja = false;

        NotificadorPush notificadorPush = new NotificadorPush();

        TrofeoCreido trofeoCreido = new TrofeoCreido(notificadorPush);
        this.agregarO(trofeoCreido);

        TrofeoDedicacion trofeoDedicacion = new TrofeoDedicacion(notificadorPush);
        this.agregarO(trofeoDedicacion);
    }

    public double getAlturaCM() {
        return alturaCM;
    }

    public void setAlturaCM(double alturaCM) {
        this.alturaCM = alturaCM;
    }

    public boolean isBaja() {
        return baja;
    }

    public IPesoAdapter getBalanza() {
        return balanza;
    }

    public void setBalanza(IPesoAdapter balanza) {
        this.balanza = balanza;
    }

    public IAuth getAuth() {
        return auth;
    }

    public void setAuth(IAuth auth) {
        this.auth = auth;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public ArrayList<Trofeo> getTrofeos() {
        return trofeos;
    }

    public void setTrofeos(ArrayList<Trofeo> trofeos) {
        this.trofeos = trofeos;
    }

    public ArrayList<IObserver> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<IObserver> observers) {
        this.observers = observers;
    }

    @Override
    public void agregarO(IObserver observador) {
        observers.add(observador);
    }

    @Override
    public void eliminarO(IObserver observador) {
        observers.remove(observador);
    }

    @Override
    public void notificar() {
        for (IObserver observer : observers) {
            observer.serNotificadoPor(this);
        }
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getAltura() {
        return alturaCM;
    }

    public void setAltura(double altura) {
        this.alturaCM = altura;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public int getEdad() {
        return edad;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean getBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }

    public ArrayList<Peso> getPesos() {
        return pesos;
    }

    public void setPesos(ArrayList<Peso> pesos) {
        this.pesos = pesos;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }


}
