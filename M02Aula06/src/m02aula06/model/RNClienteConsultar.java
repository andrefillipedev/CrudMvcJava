package m02aula06.model;

import m02aula06.basica.Cliente;
import m02aula06.repository.ConexaoException;
import m02aula06.repository.DAOCliente;
import m02aula06.repository.RepositoryException;

public class RNClienteConsultar {

	public void consultar(Cliente cliente) throws Exception {
		DAOCliente dao = new DAOCliente();
		try {
			Cliente aux = dao.consulta(cliente);
			if (aux != null) {
				throw new Exception("CPF ou email duplicado");
			}
		} catch (ConexaoException e) {
			throw new Exception(
					"Estamos com dificuldades. Tente novamente mais tarde (daqui há 12horas)<br/>" + e.getMessage());
		} catch (RepositoryException e) {
			throw new Exception("O programador fez kk. Nem adianta tentar de novo.<br/>" + e.getMessage());
		}
	}
	public Cliente consultar(int id) throws Exception {
		DAOCliente dao = new DAOCliente();
		Cliente aux = null;
		try {
			aux = dao.consulta(id);
			if (aux == null) {
				throw new Exception("Cliente não encontrado");
			}
		} catch (ConexaoException e) {
			throw new Exception(
					"Estamos com dificuldades. Tente novamente mais tarde (daqui há 12horas)<br/>" + e.getMessage());
		} catch (RepositoryException e) {
			throw new Exception("O programador fez kk. Nem adianta tentar de novo.<br/>" + e.getMessage());
		}
		return aux;
	}
}
