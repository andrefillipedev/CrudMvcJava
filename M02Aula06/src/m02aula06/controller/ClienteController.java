package m02aula06.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import m02aula06.basica.Cliente;
import m02aula06.model.RNClienteAlterar;
import m02aula06.model.RNClienteConsultar;
import m02aula06.model.RNClienteExcluir;
import m02aula06.model.RNClienteListar;
import m02aula06.model.RNClienteSalvar;

@WebServlet("/ClienteController")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at GET: ").append(request.getContextPath());
		if(request.getParameter("excluir")!=null && request.getParameter("excluir").equals("1")&& request.getParameter("id")!=null) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			try {
				Cliente c = new RNClienteConsultar().consultar(id);
				//exclui o cliente
				RNClienteExcluir rnExcluir = new RNClienteExcluir();
				rnExcluir.excluir(c);
				
				//Pego a lista de clientes para exibir na saída
				RNClienteListar rnLista = new RNClienteListar();
				ArrayList<Cliente> lista = (ArrayList)rnLista.listar();
				request.setAttribute("clientes", lista);
				//Redireciona a saída
				RequestDispatcher view = request.getRequestDispatcher("lista_clientes.jsp");
				view.forward(request, response);
				
			} catch (Exception e) {
				response.getWriter().append("Erro: " + e.getMessage());
			}
		}else if(request.getParameter("alterar")!=null && request.getParameter("alterar").equals("1")&& request.getParameter("id")!=null) {
			int id = Integer.parseInt(request.getParameter("id"));
			Cliente c = null;
			try {
				c = new RNClienteConsultar().consultar(id);
				request.setAttribute("cliente", c);
				//Redireciona a saída
				RequestDispatcher view = request.getRequestDispatcher("altera_cliente.jsp");
				view.forward(request, response);
			}catch(Exception e) {
				response.getWriter().append("Erro: " + e.getMessage());
			}
		}else if(request.getParameter("listar")!=null && request.getParameter("listar").equals("1")) {
			try {
				//Pego a lista de clientes para exibir na saída
				RNClienteListar rnLista = new RNClienteListar();
				ArrayList<Cliente> lista = (ArrayList)rnLista.listar();
				request.setAttribute("clientes", lista);
				//Redireciona a saída
				RequestDispatcher view = request.getRequestDispatcher("lista_clientes.jsp");
				view.forward(request, response);
			} catch (Exception e) {
				response.getWriter().append("Erro: " + e.getMessage());
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente = new Cliente();
		cliente.setNome(request.getParameter("nome"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setEmail(request.getParameter("email"));
		
		
		String dataNascimento = request.getParameter("dataNasc");
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date data = null;
		
		if(!dataNascimento.isEmpty()&& dataNascimento!=null) {
			try {
				data = formato.parse(dataNascimento);
			} catch (ParseException e) {
				response.getWriter().append("Erro: " + e.getMessage());
			}
		}

		cliente.setDataNascimento(data);
		cliente.setSexo(request.getParameter("sexo"));
		cliente.setNomeSocial(request.getParameter("nomeSocial"));
		cliente.setApelido(request.getParameter("apelido"));
		cliente.setTelefone(request.getParameter("telefone"));

		//Salvar os dados no BD
		if(request.getParameter("action").equals("salvar")) {
						
			try {
				//Salva os dados
				RNClienteSalvar rnSalva = new RNClienteSalvar();
				rnSalva.salvar(cliente);
				response.getWriter().append("Salvo com sucesso");
			} catch (Exception e) {
				response.getWriter().append("Erro: " + e.getMessage());
			}
		} else if(request.getParameter("action").equals("alterar")&& request.getParameter("id")!=null) {  
			try {
				RNClienteAlterar rnAlterar = new RNClienteAlterar();
				cliente.setId(Integer.parseInt(request.getParameter("id")));
				rnAlterar.alterar(cliente);
				response.getWriter().append("Alterado com sucesso");
			}catch(Exception e) {
				e.printStackTrace();
				response.getWriter().append("Erro: " + e.getMessage());
			}
		}
	}

}
