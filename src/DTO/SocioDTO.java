package DTO;

public class SocioDTO {
	public int getValorConfigurable;
	private String mail;
    private String clave;
    private String nombre;
    private String apellido;
    private String edad;
    private String fechaNacimiento;
    private String sexo;
    private String peso;
    private String altura;
    private String ID;
    private String objetivo;
	private String valorConfigurable;

	public SocioDTO(String mail, String clave, String nombre, String apellido, String edad, String fechaNacimiento,
			String sexo, String altura, String ID) {
		this.mail = mail;
		this.clave = clave;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.altura = altura;
		this.ID = ID;
	}

	public String getMail() {
		return mail;
	}

	public String getClave() {
		return clave;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getEdad() {
		return edad;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getAltura() {
		return altura;
	}

	public String getID() {
		return ID;
	}

	public void setObjetivo(String objetivo){
		this.objetivo = objetivo;
	}

	public String getObjetivo(){
		return objetivo;
	}
	public String getValorConfigurable() { return valorConfigurable; }
	public void setValorConfigurable(String valorConfigurable) {
		this.valorConfigurable = valorConfigurable;
	}
}
