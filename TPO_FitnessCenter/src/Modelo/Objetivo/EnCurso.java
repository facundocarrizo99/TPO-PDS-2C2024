package Modelo.Objetivo;

public class EnCurso implements IEstadoObjetivo{

	@Override
	public void completar(Objetivo obj) {
		Completado estado = new Completado();
		obj.cambiarEstado(estado);
	}
	
}
