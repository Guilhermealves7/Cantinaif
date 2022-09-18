// Classe feita com o intuito de organizar o array de produtos
// Pela descrição deles
import java.util.Comparator;

public class ComparatorDes implements Comparator<Item> {
    @Override
    public int compare(Item a1, Item a2){
        if(a1.getDescricao().compareToIgnoreCase(a2.getDescricao()) > 0)  
            return 1;
        return -1;
    }
    
}
