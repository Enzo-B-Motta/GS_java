package br.com.fiap.Clientes.model.entity;

import java.time.LocalDate;
import br.com.fiap.Clientes.model.DTO.ClientesDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "clientes")
@Table(name = "CLIENTES")
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo; 
    private String nome;
    private String telefone;
    private String email;
    private String estatus;
    private LocalDate dataDeNascimento;

    public Clientes(){}
    public Clientes(ClientesDTO clientesDTO){
        this.nome = clientesDTO.nome();
        this.telefone = clientesDTO.telefone();
        this.email = clientesDTO.email();
        this.estatus = clientesDTO.estatus();
        this.dataDeNascimento = clientesDTO.dataDeNascimento();
    }

    public void setCodigo(Long codigo){
        this.codigo = codigo;
    }
    public Long getCodigo(){
        return codigo;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public String getTelefone(){
        return telefone;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

    public void setEstatus(String estatus){
        this.estatus = estatus;
    }
    public String getEstatus(){
        return estatus;
    }

    public void setDataDeNascimento (LocalDate dataDeNascimento){
        this.dataDeNascimento = dataDeNascimento;
    }
    public LocalDate getDataDeNascimento(){
        return dataDeNascimento;
    }
}