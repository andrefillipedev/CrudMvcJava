package m02aula06.repository;

import java.util.List;

public interface DAO<T> {
	
	/**
	 * Armazena um dado objeto T
	 * @param obj O cara com os dados
	 * @throws ConexaoException
	 * @throws RepositoryException
	 */
	public void inserir(T obj)throws ConexaoException, RepositoryException;
	
	/**
	 * Busca e retorna um objeto T 
	 * @param obj O cara com os dados
	 * @return
	 * @throws ConexaoException
	 * @throws RepositoryException
	 */
	public T consulta(T obj)throws ConexaoException, RepositoryException;
	
	public void excluir(T obj)throws ConexaoException, RepositoryException;
	
	public void alterar(T obj)throws ConexaoException, RepositoryException;
	
	public List<T> listarTudo()throws ConexaoException, RepositoryException;
}
