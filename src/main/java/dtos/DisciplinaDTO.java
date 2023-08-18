package dtos;

import java.util.List;
import java.util.Objects;

import exceptions.DisciplinaJaExisteException;
import exceptions.NomeDisciplinaInvalidoException;

public class DisciplinaDTO {
    private int id;
    private String nome;
    private int likes;
    private List<Integer> notas; 

   

    public DisciplinaDTO(){
        super();
    }

    public DisciplinaDTO(int id, String nome, int likes, List<Integer> notas){
        this.id = id;
        this.nome = nome;
        this.likes = likes;
        this.notas = notas;
    }

     public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<Integer> getNotas() {
        return notas;
    }

    public void setNotas(List<Integer> notas) {
        this.notas = notas;
    }

    @Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DisciplinaDTO other = (DisciplinaDTO) obj;
		return Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "DisciplinaDTO [id=" + id + ", nome=" + nome + ", likes=" + likes + ", notas="
        + notas + "]";
	}

	public boolean validaDisciplina(DisciplinaDTO disciplina) {
		if (nome == null || nome.isBlank() || nome.isEmpty())
			throw new NomeDisciplinaInvalidoException("Nome invalido.", "O nome da disciplina é um campo de texto obrigatorio.");

		if (id >= 1)
			throw new DisciplinaJaExisteException("Disciplina já existente.", "Essa disciplina já existe no sistema.");


		return true;
	}

}

