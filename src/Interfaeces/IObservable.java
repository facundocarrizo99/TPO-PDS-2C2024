package Interfaeces;

public interface IObservable {
    void agregarO(IObserver observador);
    void eliminarO(IObserver observador);
    void notificar();
}
