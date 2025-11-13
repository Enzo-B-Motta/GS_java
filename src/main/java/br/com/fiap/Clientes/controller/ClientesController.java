package br.com.fiap.Clientes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.Clientes.model.repository.ClientesRepository;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import br.com.fiap.Clientes.model.DTO.ClientesDTO;
import br.com.fiap.Clientes.model.entity.Clientes;
import java.util.List;

@RestController 
@RequestMapping("/clientes") 
public class ClientesController {

    @Autowired
    private ClientesRepository clientesRepository;
    
    @GetMapping("/novo")
    public ModelAndView novo(){
        ModelAndView mv = new ModelAndView("formulario");
        return mv;
    }

    @PostMapping
    public ModelAndView cadastrar(@Valid ClientesDTO clientesDTO, BindingResult result){ 
        if (result.hasErrors()){
            return new ModelAndView("redirect:/clientes");
        }
        Clientes cliente = new Clientes(clientesDTO);
        clientesRepository.save(cliente);
        ModelAndView mv = new ModelAndView("redirect:/clientes");
        return mv;
    }

    @GetMapping
    public ModelAndView consultar() {
        List<Clientes> clientes = clientesRepository.findAll();
        ModelAndView mv = new ModelAndView("clientes");
        mv.addObject("clientes", clientes);
        return mv;
    }

    @GetMapping("/editar/{codigo}")
    public ModelAndView consultarPorCodigo (@PathVariable Long codigo){
        Clientes cliente = clientesRepository.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("formulario");
        mv.addObject("clientes", cliente);
        mv.addObject("acao", "/clientes/atualizar/" + codigo);
        return mv;
    }

    @GetMapping("/excluir/{codigo}")
    public ModelAndView excluir (@PathVariable Long codigo){
        clientesRepository.deleteById(codigo);
        ModelAndView mv = new ModelAndView("redirect:/clientes");
        return mv;
    }

    @PostMapping("/atualizar/{codigo}")
    public ModelAndView atualizar(@PathVariable Long codigo, 
    @RequestBody @Valid ClientesDTO clientesDTO, BindingResult result){
        if (result.hasErrors()) {
            return new ModelAndView("redirect:/clientes");
        }
        Clientes cliente = new Clientes(clientesDTO);
        cliente.setCodigo(codigo);        
        clientesRepository.save(cliente);
        ModelAndView mv = new ModelAndView ("redirect:/clientes");
        return mv;
    }
}
    