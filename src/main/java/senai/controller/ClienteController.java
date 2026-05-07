package senai.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import senai.model.Cliente;
import senai.repository.ClienteRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;


@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("cliente/listar.html");

        List<Cliente> clientes = clienteRepository.findAll();
        mv.addObject("clientes", clientes);
        return mv;
    }

    @GetMapping("/{id}")
    public ModelAndView detalhar(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("cliente/detalhar.html");

        Cliente cliente = clienteRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mv.addObject("cliente", cliente);
        return mv;
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("redirect:/cliente");
        clienteRepository.deleteById(id);
        return mv;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView mv = new ModelAndView("cliente/cadastro");
        mv.addObject("cliente", new Cliente());
        return mv;
    }

    @PostMapping("/cadastrar")
    public ModelAndView cadastrar(Cliente cliente) {
        ModelAndView mv = new ModelAndView("redirect:/cliente");
        clienteRepository.save(cliente);
        return mv;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("cliente/editar");
        Cliente cliente = clienteRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mv.addObject("cliente", cliente);
        return mv;
    }

    @PostMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id, Cliente cliente) {
        ModelAndView mv = new ModelAndView("redirect:/cliente");
        cliente.setId(id);
        clienteRepository.save(cliente);
        return mv;
    }

}