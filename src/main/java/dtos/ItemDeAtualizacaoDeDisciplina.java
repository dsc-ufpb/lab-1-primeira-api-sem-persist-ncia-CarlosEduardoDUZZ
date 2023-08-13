package dtos;

public class ItemDeAtualizacaoDeDisciplina {
    
	private String atributo;
	private String novaDisciplina;

	public ItemDeAtualizacaoDeDisciplina() {
		super();
	
	}

	public ItemDeAtualizacaoDeDisciplina(String atributo, String novaDisciplina) {

		this.atributo = atributo;
		this.novaDisciplina = novaDisciplina;
	}

	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

	public String getNovaDisciplina() {
		return novaDisciplina;
	}

	public void setNovaDisciplina(String novaDisciplina) {
		this.novaDisciplina = novaDisciplina;
	}

}

