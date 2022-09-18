import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/*
    Classe que abre uma conxão com um banco
    e usa a sintaxe do Sql de consulta, para
    Pegar os valores dos produtos e dos Funcionarios
    no banco. Usando o statemente do java para executar
    esses comandos Sql.

*/

public class PullBcdd {

    private static Connection conectionPull = ConnectionFactory.getConnection();

    public static ArrayList<Item> pullItems() throws Exception{

        String select = "select * from item";
        ArrayList<Item> items = new ArrayList<Item>();
    
        try{
            PreparedStatement stm = conectionPull.prepareStatement(select);
            ResultSet cursor = stm.executeQuery();

            while(cursor.next()){

                String nome = cursor.getString("nome");
                String descricao = cursor.getString("descricao");
                int quantidadeComprada = cursor.getInt("quantidade_comprada");
                int quantidadeVendida = cursor.getInt("quantidade_vendida");
                double precoCompra = cursor.getDouble("preco_compra");
                double precoVenda = cursor.getDouble("preco_venda");
                int codigo = cursor.getInt("codigo");

                try{
                    Item item = new Item(nome, descricao, precoCompra, precoVenda, quantidadeComprada, quantidadeVendida, codigo);
                    items.add(item);
                }

                catch(Exception e){
                    System.out.println(e.getMessage());
                }
           
            }

            cursor.close();
            stm.close();
        }

        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return items;
    }

    public static ArrayList<Funcionario> pullFuncionarios() throws Exception{

        String select = "select * from funcionario";
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

        try{
            PreparedStatement stm = conectionPull.prepareStatement(select);
            ResultSet cursor = stm.executeQuery();

            while(cursor.next()){
                String nome = cursor.getString("nome");
                String senha = cursor.getString("senha");
                int codigo = cursor.getInt("codigo");

                Funcionario funcionario = new Funcionario(nome, senha, codigo);
                funcionarios.add(funcionario);
            }

            cursor.close();
            stm.close();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return funcionarios;
    }
}
