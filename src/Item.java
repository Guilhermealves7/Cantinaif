/*
    Classe Item e seus atributos e metodos.

*/

public class Item {

    private String nome;
    private String descricao;
    private double precoCompra;
    private double precoVenda;
    private int codigo;
    private int quantidadeComprada;
    private int quantidadeVendida;
    private int quantidade;


    public Item(String nome, String descricao, double precoCompra, double precoVenda, int quantidadeComprada, int quantidadeVendida, int codigo) throws Exception {

        if(precoVenda < precoCompra || precoVenda <= 0 || precoCompra <= 0)
            throw new Exception("Preço de venda ou de compra inválido");
        if(quantidadeComprada <= 0)
            throw new Exception("Quantidade comprada inválida");
        
        this.nome = nome;
        this.descricao = descricao;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.quantidadeComprada = quantidadeComprada;
        this.quantidadeVendida = quantidadeVendida;
        this.codigo = codigo;
        updateQuantidade();

    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public double getPrecoCompra(){
        return this.precoCompra;
    }

    public void setPrecoCompra(double precoCompra){
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda(){
        return this.precoVenda;
    
    }

    public void setPrecoVenda(double precoVenda){
        this.precoVenda = precoVenda;
    }

    public int getQuantidadeComprada(){
        return this.quantidadeComprada;
    }

    public void setQuantidadeComprada(int quantidadeComprada){
        this.quantidadeComprada = quantidadeComprada;
    }

    public int getQuantidadeVendida(){
        return this.quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida){
        this.quantidadeVendida = quantidadeVendida;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public void updateQuantidade(){
        this.quantidade = this.quantidadeComprada - this.quantidadeVendida;
    }

    public void updateQuantidadeVendia(int vendas){
        quantidadeVendida += vendas;
    }

    public int getCodigo(){
        return this.codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    @Override
    public String toString(){
        return "\nCodigo: "+this.codigo+"\nNome: "+this.nome+"\nDescrição: "+this.descricao+"\nQuantidade: "+this.quantidade+"\nPreço: R$"+this.precoVenda;
    }
}
