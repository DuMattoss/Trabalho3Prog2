/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cadastrocliente;

public class Cliente {
    private static Integer contador=0;
    private Integer codigo;
    private String nome;
    private Endereco endereco;
    private String telefone;
    
    public Cliente() {
        contador++;
        this.codigo = contador;
        this.nome = " ";
        this.endereco = new Endereco();
        this.telefone = " ";
    }
    
    public Cliente(String nome, Endereco endereco, String telefone) {
        contador++;
        this.codigo = contador;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco=new Endereco();
    }

    

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
    
}