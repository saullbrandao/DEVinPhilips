import java.util.ArrayList;
import java.util.List;

public class EmpresaRepository {
	private static List<Empresa> empresas = new ArrayList<>();
	
	
	public static boolean addEmpresa(Empresa empresa) {
		return empresas.add(empresa);
	}
	
	public static List<Empresa> getEmpresas() {
		return empresas;
	}
}
