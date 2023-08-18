package exceptions;

public class DisciplinaNaoEncontradaException extends RuntimeException {
	private String titulo;
	private String detalhes;

	public DisciplinaNaoEncontradaException(String titulo, String detalhes) {
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
