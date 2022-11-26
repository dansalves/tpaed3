package Objetos;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.security.auth.login.LoginContext;

public class Pessoa {
    private int idConta;
    private String Nome;
    private String[] email;
    private int quantityEmail;
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

    public String toString(){
        return "\nNome Titular: " + Nome +
            "\nEmail: " + email +
            "\nCPF: " + cpf +
            "Saldo: " + saldo;      
    }

    public byte[] toByteArray() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);

        dos.writeInt(idConta);
        dos.writeUTF(Nome);
        dos.writeInt(quantityEmail);

        for (int i=0;i<quantityEmail;i++){
            dos.writeUTF(email[i]);
        }

        dos.writeUTF(nomeUsuario);
        dos.writeUTF(senha);
        dos.writeUTF(cpf);
        dos.writeUTF(cidade);
        dos.writeInt(transRealizadas);
        dos.writeDouble(saldo);

        return baos.toByteArray();
    }

    public void fromByteArray(byte [] baos) throws IOException{
        ByteArrayInputStream bais = new ByteArrayInputStream(baos);
        DataInputStream dis = new DataInputStream(bais);

        idConta=dis.readInt();
        Nome=dis.readUTF();
        quantityEmail=dis.readInt();

        for (int i=0;i<quantityEmail;i++){
            email[i]=dis.readUTF();
        }

        nomeUsuario=dis.readUTF();
        senha=dis.readUTF();
        cpf=dis.readUTF();
        cidade=dis.readUTF();
        transRealizadas=dis.readInt();
        saldo=dis.readFloat();
    }  

}
