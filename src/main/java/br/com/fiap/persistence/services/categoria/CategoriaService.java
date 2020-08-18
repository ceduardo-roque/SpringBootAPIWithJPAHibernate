package br.com.fiap.persistence.services.categoria;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.persistence.entity.Categoria;
import br.com.fiap.persistence.repository.CategoriaRepository;

/**
 * Classe responsavel por manipular efetivamente o repositorio de Categoria
 * 
 * @author Carlos Eduardo Roque da Silva
 *
 */
@Service
public class CategoriaService implements ICategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	/**
	 * Método responsavel por deletar uma categoria da tabela Categoria pelo seu id
	 */
	@Override
	public void deleteCategoria(long id) {
		this.categoriaRepository.delete(this.categoriaRepository.findById(id).get());
	}

	/**
	 * Método responsavel por atualizar uma cateogoria
	 */
	@Override
	public Categoria updateCategoria(Categoria categoria) {
		return this.categoriaRepository.save(categoria);
	}

	/**
	 * Método responsavel por adicionar uma nova categoria na tabela Categoria
	 */
	@Override
	public Categoria addCategoria(Categoria categoria) {
		return this.categoriaRepository.save(categoria);
	}

	/**
	 * Método responsavel por retornar todas as categorias da tabela Categoria
	 */
	@Override
	public List<Categoria> getAllCategoria() {
		List<Categoria> listaCategorias = new ArrayList<Categoria>();
		this.categoriaRepository.findAll().forEach(c -> listaCategorias.add(c));
		return listaCategorias;
	}

	@Override
	public Categoria getCategoriaById(long id) {
		// Busca a Categoria pelo ID a partir do repositorio injetado via Dependency Injection
		try {
			return this.categoriaRepository.findById(id).get();			
		} catch(NoSuchElementException e) {
			System.out.println("Não foi possivel encontrar a categoria de Id: " + id);
		}
		return null;
	}

}
