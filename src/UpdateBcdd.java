import java.sql.Connection;
import java.sql.PreparedStatement;


/*
    Classe que abre uma conxão com um banco
    e usa a sintaxe do Sql de atualização, para
    atualizar os valores dos produtos e dos Funcionarios
    no banco. Usando o statemente do java para executar
    esses comandos Sql.

*/

public class UpdateBcdd {
    private static Connection conectionUpdate = ConnectionFactory.getConnection();

    public static void updateItems(Item item){
        String update = "update item "+
                        "set quantidade_comprada = ?,"+
                        "quantidade_vendida = ?," +
                        "quantidade = ? "+
                        "where codigo = ?;";
        
        try{
            PreparedStatement stm = conectionUpdate.prepareStatement(update);

            stm.setInt(1, item.getQuantidadeComprada());
            stm.setInt(2, item.getQuantidadeVendida());
            stm.setInt(3, item.getQuantidade());
            stm.setInt(4, item.getCodigo());

            stm.executeUpdate();
            stm.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
