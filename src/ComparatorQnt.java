// Classe feita exclusivamente para organizar um array 
// pela quantidade de itens 

import java.util.Comparator;

public class ComparatorQnt implements Comparator<Item> {
    @Override
    public int compare(Item a1, Item a2){
        if(a1.getQuantidade() > a2.getQuantidade())  
            return 1;
        return -1;
    }
    
}
