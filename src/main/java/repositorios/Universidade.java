package repositorios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import dtos.ItemDeAtualizacaoDeDisciplina;
import entidades.Disciplina;
import exceptions.CampoInvalidoException;
import exceptions.DisciplinaJaExisteException;
import exceptions.DisciplinaNaoEncontradaException;
import exceptions.NomeDisciplinaInvalidoException;

public class Universidade {
    private Map<String, Disciplina> disciplinasPorNome = new HashMap<>();
	private Map<Long, Disciplina> disciplinasPorId = new HashMap<>();

	public Universidade() {
		super();
		
	}

	public Optional<Disciplina> recuperaPorNome(String nome) {
		return Optional.ofNullable(disciplinasPorNome.get(nome));
	}

	public Optional<Disciplina> recuperaPorId(long id) {
		return Optional.ofNullable(disciplinasPorId.get(id));
	}

	public Disciplina adicionaDisciplina(Disciplina disciplina) {
		disciplinasPorNome.put(disciplina.getNome(), disciplina);
		disciplinasPorId.put((long) disciplina.getId(), disciplina);
		return disciplina;
	}

	public Disciplina atualizaItemDaDisciplina(long id, ItemDeAtualizacaoDeDisciplina itemDeAtualizacao) {
		Disciplina disciplina = recuperaPorId(id).get();
		switch (itemDeAtualizacao.getAtributo()) {
		case "nome":
			if (DisciplinaComEsseNomeJaExiste(itemDeAtualizacao.getNovaDisciplina()))
				throw new DisciplinaJaExisteException("Disciplina deve ter nome unico.",
						"Uma disciplina com o novo nome a ser atualizado ja existe na Universidade. Disciplinas devem ter nomes unicos.");

			disciplina.setNome(itemDeAtualizacao.getNovaDisciplina());
			break;

		case "Likes":
			int novaQtdLikesDisciplina;
			try {
				novaQtdLikesDisciplina = Integer.parseInt(itemDeAtualizacao.getNovaDisciplina());
			} catch (NumberFormatException nfe) {
				throw new NomeDisciplinaInvalidoException("Disciplina Invalida.",
						"A quantidade de disciplina não pode ser zero.");
			}
			if (novaQtdLikesDisciplina <= 0)
				throw new NomeDisciplinaInvalidoException("Disciplina invalida.",
						"A quantidade de disciplinas deve ser um.");

			disciplina.setLikes(novaQtdLikesDisciplina);


		default:
			throw new CampoInvalidoException("Campo invalido.",
					"O campo do item de atualizacao nao existe. Os campos para atualizacao sao nome, quantidade, descricao e valorUnitario.");
		}

		return disciplina;
	}

	private boolean DisciplinaComEsseNomeJaExiste(String novaDisciplina) {
        return false;
    }


	public String toString() {
		String saida = "";

		Iterator<Disciplina> it = disciplinasPorId.values().iterator();

		while (it.hasNext()) {
			saida = saida.concat(it.next().toString() + System.lineSeparator());
		}

		return saida;
	}

	public Collection<Disciplina> getDisciplinas(Optional<String> padraoDeBusca) {

		if (padraoDeBusca.isEmpty())
			return disciplinasPorId.values();

		Set<String> nomes = disciplinasPorNome.keySet();

		Collection<Disciplina> disciplinas = new ArrayList<>();
		for (String nome : nomes) {
			if (nome.contains(padraoDeBusca.get())) {
				disciplinas.add(disciplinasPorNome.get(nome));
			}
		}
		return disciplinas;
	}

	public Disciplina getDisciplina(long id) {
		if (!disciplinasPorId.containsKey(id))
			throw new DisciplinaNaoEncontradaException("Disciplina nao existe.",
					"Nenhuma disciplina com este id foi encontrado na Universidade.");
		return disciplinasPorId.get(id);
	}

}


