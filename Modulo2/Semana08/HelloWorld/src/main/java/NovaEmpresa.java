

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresa
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Empresa> empresas = EmpresaRepository.getEmpresas();
//		String empresa = request.getParameter("nome");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Nova Empresa</title>");
		out.println("</head>");
		out.println("<body>");
//		out.println("Empresa: " + empresa);
		out.println("<ul>");
		for(Empresa empresa: empresas) {
			out.println("<li>"+empresa.getNome()+"</li>");
		}
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");

//		System.out.println(empresa);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cnpj = request.getParameter("cnpj");
		
		Empresa empresa = new Empresa(nome, cnpj);
		EmpresaRepository.addEmpresa(empresa);
		
		doGet(request, response);
	}

}
