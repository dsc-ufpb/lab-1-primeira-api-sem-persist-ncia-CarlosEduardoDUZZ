package exceptions;

public class NomeDisciplinaInvalidoException extends RuntimeException {

    private String titulo;
	private String detalhes;

	public NomeDisciplinaInvalidoException(String titulo, String detalhes) {
		super();
		this.detalhes = detalhes;
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDetalhes() {
		return detalhes;
	}

}

