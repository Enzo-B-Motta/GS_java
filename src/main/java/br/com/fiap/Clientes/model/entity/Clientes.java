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
    private int idade;
    private Double peso;
    private Double altura;
    private LocalDate inicioDoTratamento;

    public Clientes(){}
    public Clientes(ClientesDTO clientesDTO){
        this.nome = clientesDTO.nome();
        this.idade = clientesDTO.idade();
        this.peso = clientesDTO.peso();
        this.altura = clientesDTO.altura();
        this.inicioDoTratamento = clientesDTO.inicioDoTratamento();
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

    public void setIdade(int idade){
        this.idade = idade;
    }
    public int getIdade(){
        return idade;
    }

    public void setPeso(Double peso){
        this.peso = peso;
    }
    public Double getPeso(){
        return peso;
    }

    public void setAltura(Double altura){
        this.altura = altura;
    }
    public Double getAltura(){
        return altura;
    }

    public void setInicioDoTratamento (LocalDate inicioDoTratamento){
        this.inicioDoTratamento = inicioDoTratamento;
    }
    public LocalDate getInicioDoTratamento(){
        return inicioDoTratamento;
    }
}
