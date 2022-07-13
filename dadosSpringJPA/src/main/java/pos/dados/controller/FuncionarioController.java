package pos.dados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pos.dados.entity.Funcionario;
import pos.dados.repository.FuncionarioRepository;
import pos.dados.service.FuncionarioService;

/**
 * Class UserController
 */
@Controller
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private FuncionarioRepository funcionarioDao;

	@RequestMapping(value = "/funcionario/create")
	public String create(Integer cod_funcionario, 
    		String nome_funcionario, Integer qtde_dependente, 
    		Double salario, String cargo, Integer departamento, Model model) {

		Funcionario funcionario = funcionarioService.create(cod_funcionario, nome_funcionario, qtde_dependente, salario, cargo, departamento);
		model.addAttribute("funcionario", funcionario);
		return "/test";
	}

	@RequestMapping(value = "/funcionario/delete")
	@ResponseBody
	public String delete(Integer id) {		
		try {
			Funcionario funcionario = new Funcionario(id);
			funcionarioDao.delete(funcionario);
		} catch (Exception ex) {
			return "Error deleting the user: " + ex.toString();
		}
		return "Funcionario succesfully deleted!";
	}
	
	@RequestMapping(value = "/funcionario/get-by-id")
	@ResponseBody
	public String getById() {
		try {
			Funcionario funcionario = funcionarioDao.getById(1);
			return funcionario.toString();
		} catch (Exception ex) {
			return "Funcionario not found: " + ex.toString();
		}
		
	}

	@RequestMapping(value = "/funcionario/get-by-nome")
	@ResponseBody
	public String getByNome(String nome) {
		String funcNome;
		try {
			Funcionario funcionario = funcionarioDao.getByNome(nome);
			funcNome = String.valueOf(funcionario.getNome_funcionario());
		} catch (Exception ex) {
			return "Funcionario not found: " + ex.toString();
		}
		return "The funcionario nome is: " + funcNome;
	}
	
	@RequestMapping(value = "/funcionario/get-all")
	@ResponseBody
	public List<Funcionario> getByAll(String nome) {
		try {
			List<Funcionario> lista = funcionarioDao.getAll();
			return lista;
		} catch (Exception ex) {
			return null;
		}		
	}

	@RequestMapping(value = "/funcionario/update")
	@ResponseBody
	public String updateName(Integer id, String nome) {
		try {
			Funcionario funcionario = funcionarioDao.getById(id);			
			funcionario.setNome_funcionario(nome);
			funcionarioDao.update(funcionario);
		} catch (Exception ex) {
			return "Error updating the Funcionario: " + ex.toString();
		}
		return "Funcionario succesfully updated!";
	}
}
