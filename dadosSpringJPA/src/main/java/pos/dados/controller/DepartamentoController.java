package pos.dados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pos.dados.entity.Departamento;
import pos.dados.repository.DepartamentoRepository;
import pos.dados.service.DepartamentoService;

/**
 * Class UserController
 */
@Controller
public class DepartamentoController {

	@Autowired
	private DepartamentoService departamentoService;

	@Autowired
	private DepartamentoRepository departamentoDao;

	@RequestMapping(value = "/departamento/create")
	public String create(String name, Model model) {

		Departamento departamento = departamentoService.create(name);
		model.addAttribute("departamento", departamento);
		return "/test";
	}

	@RequestMapping(value = "/departamento/delete")
	@ResponseBody
	public String delete(Integer id) {		
		try {
			Departamento departamento = new Departamento(id);
			departamentoDao.delete(departamento);
		} catch (Exception ex) {
			return "Error deleting the user: " + ex.toString();
		}
		return "Departamento succesfully deleted!";
	}
	
	@RequestMapping(value = "/departamento/get-by-id")
	@ResponseBody
	public String getById() {
		String nome;
		try {
			Departamento departamento = departamentoDao.getById(1);
			nome = String.valueOf(departamento.getNome_departamento());
		} catch (Exception ex) {
			return "Departamento not found: " + ex.toString();
		}
		return "The departamento id is: " + nome;
	}

	@RequestMapping(value = "/departamento/get-by-nome")
	@ResponseBody
	public String getByNome(String nome) {
		String deptoId;
		try {
			Departamento departamento = departamentoDao.getByNome(nome);
			deptoId = String.valueOf(departamento.getNome_departamento());
		} catch (Exception ex) {
			return "Departamento not found: " + ex.toString();
		}
		return "The departamento nome is: " + deptoId;
	}
	
	@RequestMapping(value = "/departamento/get-all")
	@ResponseBody
	public List<Departamento> getByAll(String nome) {
		try {
			List<Departamento> lista = departamentoDao.getAll();
			return lista;
		} catch (Exception ex) {
			return null;
		}		
	}

	@RequestMapping(value = "/departamento/update")
	@ResponseBody
	public String updateName(long id, String nome) {
		try {
			Departamento departamento = departamentoDao.getById(id);			
			departamento.setNome_departamento(nome);
			departamentoDao.update(departamento);
		} catch (Exception ex) {
			return "Error updating the Departamento: " + ex.toString();
		}
		return "Departamento succesfully updated!";
	}
}
