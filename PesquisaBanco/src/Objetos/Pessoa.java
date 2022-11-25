package Objetos;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Pessoa {
    private int idConta;
    private String Nome;
    private String[] email;
    private int quantityEamil;
    private String nomeUsuario;
    private String senha;
    private String cpf;
    private String cidade;
    private int transRealizadas;
    private float saldo;

    public Pessoa(int idConta, String nome, String[] email, String nomeUsuario, String senha, String cpf, String cidade, int transRealizadas, float saldo) {
        this.idConta = idConta;
        this.Nome = nome;
        this.email = email;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.cpf = cpf;
        this.cidade = cidade;
        this.transRealizadas = transRealizadas;
        this.saldo = saldo;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String[] getEmail() {
        return email;
    }

    public void setEmail(String[] email) {
        this.email = email;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getTransRealizadas() {
        return transRealizadas;
    }

    public void setTransRealizadas(int transRealizadas) {
        this.transRealizadas = transRealizadas;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public byte[] toByteArray() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);

        dos.writeInt(idConta);
        dos.writeUTF(Nome);
        dos.w

        return baos.toByteArray();
    }

    
    

}
