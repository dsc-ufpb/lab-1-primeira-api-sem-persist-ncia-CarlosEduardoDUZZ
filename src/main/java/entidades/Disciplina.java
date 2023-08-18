package entidades;

import java.util.List;
import java.util.Objects;

import dtos.DisciplinaDTO;

public class Disciplina {
    private int id;
    private String nome;
    private int likes;
    private List<Integer> notas;

    

    public Disciplina(){
        super();
    }

    public Disciplina(String nome, int id, int likes, List<Integer> notas ){

        this.nome = nome;
        this.id = id;
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
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		return Objects.equals(id, other.id);
	}

	public static Disciplina criarDisciplina(DisciplinaDTO  disciplina ) {
		return new Disciplina ();
	}

	@Override
	public String toString() {
		return "Disciplina [id=" + id + ", nome=" + nome + ", likes=" + likes + ", notas="
				+ notas + "]";
	}
	



    

    
}
