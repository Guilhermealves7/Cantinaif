import java.sql.Connection;
import java.sql.PreparedStatement;


/*
    Classe que abre uma conxão com um banco
    e usa a sintaxe do Sql de inserção, para
    inserir registros dos produtos e dos Funcionarios
    no banco. Usando o statemente do java para executar
    esses comandos Sql.

*/

public class PushBcdd{

    private static Connection conectionPush = ConnectionFactory.getConnection();

    public static void PushItem(Item item){
        String insert = "insert into item" + 
        "(descricao, nome, preco_compra, preco_venda, quantidade_comprada, quantidade_vendida, quantidade, codigo)" + "values(?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement stm = conectionPush.prepareStatement(insert);

            stm.setString(1, item.getDescricao());
            stm.setString(2, item.getNome());
            stm.setDouble(3, item.getPrecoCompra());
            stm.setDouble(4, item.getPrecoVenda());
            stm.setInt(5, item.getQuantidadeComprada());
            stm.setInt(6, item.getQuantidadeVendida());
            stm.setInt(7, item.getQuantidade());
            stm.setInt(8, item.getCodigo());
            
            stm.execute();
            stm.close();
        }   

        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void PushFuncionario(Funcionario funcionario){
        String insert = "insert into funcionario" +
                        "(codigo, nome, senha)" +
                        "values(?, ?, ?) ";

        try{
            PreparedStatement stm = conectionPush.prepareStatement(insert);

            stm.setInt(1, funcionario.getCodigo());
            stm.setString(2, funcionario.getNome());
            stm.setString(3, funcionario.getSenha());

            stm.execute();
            stm.close();

        }

        catch(Exception e){
            System.out.println(e.getMessage());
        }
                    
    }

}