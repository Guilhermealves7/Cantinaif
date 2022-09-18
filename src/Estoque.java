
/* Class Estoque, onde faz
   Todo o controle dos protudos,
   adicionar, atulizar e organizar
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;


public class Estoque {
    
    private static Scanner scan = new Scanner(System.in);
    private ArrayList<Item> itens = new ArrayList<Item>();

    public void adicionarItem(Item item, String source){
        
        try{
            itens.add(item);
            if((source.equals("banco de dados")))
                PushBcdd.PushItem(item);
        }

        catch(Exception e){
            System.out.println(e.getMessage());
        }
    
        
    }
    // Funcao que lista os itens em baixa quantidade
    public void baixaQuantidade(){

        System.out.println("Lista de itens com baixa no estoque");
        for(int i = 0; i < itens.size(); i++){

            if(itens.get(i).getQuantidade() < 50){
                System.out.println(itens.get(i).getNome());
            }
        }
    }
    // Funcao para atualizar a quantidade de itens
    public void updateQuantidadeItem() throws Exception{
        

        for(int i = 0; i < itens.size(); i++){
            System.out.printf("\nIndice do item: %d", i);
            System.out.println(itens.get(i).toString());
        }

        System.out.println("\nQual o indice do item que voce quer adicionar? ");
        int indice = scan.nextInt();
        if(indice < 0 || indice >= itens.size())
            throw new Exception("Indice inválido");

        System.out.println("\nQual a quantidade você quer adicionar? ");
        int quantidade = scan.nextInt();

        if(quantidade < 0){
            throw new Exception("Quantidade inválida");
        }

        itens.get(indice).setQuantidadeComprada(itens.get(indice).getQuantidadeComprada() + quantidade);
        itens.get(indice).updateQuantidade();
        UpdateBcdd.updateItems(itens.get(indice));
 
    }   
    // Funcao que mostrar o ToString de cada item cadastrado
    public void mostrarItems(){
        for(int i = 0; i < itens.size(); i++){
            System.out.println(itens.get(i).toString());
            System.out.println();
        }
        System.out.println();
    }
    // Funcao venda de produtos
    public void Venda() throws Exception{
        for(int i = 0; i < itens.size(); i++){
            System.out.printf("Código do item: %d\n", i);
            System.out.printf("Nome: %s\n", itens.get(i).getNome());
            System.out.printf("Quantidade %d\n", itens.get(i).getQuantidade());
            System.out.printf("Preço: %.2f\n\n", itens.get(i).getPrecoVenda());
        }

        System.out.print("Qual o indice do item que você deseja comprar? ");
        int indice = scan.nextInt();

        if(indice < 0 || indice >= itens.size())
            throw new Exception("Indice inválido");

        System.out.print("Qual a quantidade você quer comprar? ");
        int quantidade = scan.nextInt();

        if(quantidade < 0 || quantidade > itens.get(indice).getQuantidade()){
            throw new Exception("Quantidade inválida");
        }

        itens.get(indice).setQuantidadeVendida(itens.get(indice).getQuantidadeVendida() + quantidade);
        itens.get(indice).updateQuantidade();
        UpdateBcdd.updateItems(itens.get(indice));

    }   
    // Funcao para mostra Lucro e Prejuizo de cada Produto
    public void mostrarLucroPrejuizo(){
        for(int i = 0; i < itens.size(); i++){
            System.out.println(itens.get(i).getNome());
            double calc = itens.get(i).getPrecoVenda() * itens.get(i).getQuantidadeVendida() - itens.get(i).getPrecoCompra() * itens.get(i).getQuantidadeComprada();

            if(calc <= 0){
                System.out.printf("Deu Prejuizo de: %.2f\n", calc * -1);
            }
            else{
                System.out.printf("Deu lucro de: %.2f\n", calc);
            }
        }
    }
    // Funcao para ordenar a lista de produtos
    public void ordenarLista(){
        System.out.println("Ordenar pela (1 - descrição ou 2 - quantidade): ");
        int ord = scan.nextInt();
        
        if(ord == 1){
            Collections.sort(itens, new ComparatorDes());
            mostrarItems();
        }
        else{
            Collections.sort(itens, new ComparatorQnt());
            mostrarItems();
        }

    }

}
