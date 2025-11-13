package br.com.fiap.Clientes.model.repository;

import br.com.fiap.Clientes.model.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository <Clientes, Long>{
    Clientes findByCodigo(Long codigo); 
}
