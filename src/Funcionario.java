/*
Classe Funcionario e seus atributos e metodos
*/

public class Funcionario {
    
    String nome;
    String senha;
    int codigo;

    public Funcionario(String nome, String senha, int codigo){
        try{
            this.nome = nome;
            this.senha = senha;
            this.codigo = codigo;
        }

        catch(Exception e){
            System.out.println("Erro no cadastro "+e.getMessage());
        }
    }

    public String getNome(){
        return this.nome;
    }

    public String getSenha(){
        return this.senha;
    }

    public int getCodigo(){
        return this.codigo;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }


}
