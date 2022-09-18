import java.util.Scanner;
import java.util.ArrayList;

public class Menu{
    
    static public String loginV = "Verificando"; // Guardar os status do login
    static public ArrayList<Funcionario> funcionarios; 
    static public Funcionario admin = new Funcionario("admin", "root", 123); // Adm para o primeiro acesso
    static Scanner scan = new Scanner(System.in);
    static Estoque estoque = new Estoque();

    // Onde os metodos são organizados
    public static void Execute(){

        colectFuncionarios();
        colectProdutos();
        while(true){
            
            System.out.print("\nDigite Uma opção\n1 - Cliente\n2 - ADM\n3 - sair\nEscolha: ");
            int op = scan.nextInt();
            funcionarios.add(admin);
            if(op == 1){
                menuCliente();
            }

            if(op == 2){
                Screen screen = new Screen();
                menuAdm();
            }

            if(op == 3) break;
        }
    }
    //Menu do modo cliente com suas opções
    public static void menuCliente(){
        while(true){
            System.out.println("\n1 - Mostrar itens");
            System.out.println("2 - Comprar item");
            System.out.println("3 - Ordenar Itens");
            System.out.println("4 - Sair: ");
            System.out.print("Sua escolha: ");
            int escolha2 = scan.nextInt();
            System.out.println();

            if(escolha2 == 1)
                estoque.mostrarItems();

            if(escolha2 == 2){
                try{
                    estoque.Venda();
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
            if(escolha2 == 3)
                estoque.ordenarLista();

            if(escolha2 == 4) break;
        
        }

    }
    // Menu do modo adm e suas opções
    public static void menuAdm(){

        while (true) {
            // Fica no modo verificando ate que o login seja enviado
            while(loginV.equals("Verificando")){
                System.out.println();
            }

            // Se o login for invalido a funcao retorna e encerra
            if(loginV.equals("Não autorizado")){
                System.out.println("Acesso não autorizado");
                loginV = "Verificando";
                return;
            }
            
            // Se for válido entra no resto da funcão
            System.out.println("Admin!");

            System.out.print("\nDigite Uma opção"+
                        "\n1 - Cadastrar Item"+
                        "\n2 - Cadastrar Funcionario"+
                        "\n3 - Ver itens"+
                        "\n4 - Atualizar quantidade de itens"+
                        "\n5 - Ordernar Itens"+
                        "\n6 - Sair do modo admin"+
                        "\nEscolha: ");

            int op = scan.nextInt();

            if(op == 1) cadastrarItem();
            if(op == 2) cadastraFuncionario();
            if(op == 3) estoque.mostrarItems();
            if(op == 5) estoque.ordenarLista();
            if(op == 6) {
                loginV = "Verificando";
                break;
            }
            if(op == 4){
                try{
                    estoque.updateQuantidadeItem();
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
 

        // Função para cadastrar um funcionario no programa e no banco
        public static void cadastraFuncionario(){
        scan.nextLine();

        System.out.print("\nDigite o nome do funcionario: ");
        String nome = scan.nextLine();
        System.out.print("Digite a senha do funcionario: ");
        String senha = scan.nextLine();
        System.out.print("Digite o codigo do funcionario: ");
        int codigo = scan.nextInt();

        Funcionario funcionario = new Funcionario(nome, senha, codigo);
        PushBcdd.PushFuncionario(funcionario);
    }
    // Metodo para cadastrar um item no programa e no banco de dados

    public static void cadastrarItem(){

        System.out.println("Aperte enter!");
        scan.nextLine();
        System.out.print("\nNome: ");
        String nome = scan.nextLine();
        System.out.print("Descricao: ");
        String descricao = scan.nextLine();
        System.out.print("Preço de compra: ");
        double precoCompra = scan.nextDouble();
        System.out.print("Preco de venda: ");
        double precoVenda = scan.nextDouble();
        System.out.print("Quantidade comprada: ");
        int quantidadeComprada = scan.nextInt();
        System.out.print("Codigo do item: ");
        int codigo = scan.nextInt();

        try{
            int quantidadeVendida = 0;
            Item item = new Item(nome, descricao, precoCompra, precoVenda, quantidadeComprada, quantidadeVendida, codigo);
            estoque.adicionarItem(item, "banco de dados");
            //System.out.println("sucesso!");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
    // Coletar as informações do funcionario no banco e colocar no array
    public static void colectFuncionarios(){
        try{
            funcionarios = PullBcdd.pullFuncionarios();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    // Coletar as informações do produto no banco e colocar no array
    public static void colectProdutos(){
        try{
            ArrayList<Item> items = PullBcdd.pullItems();
            for(int i = 0;i < items.size() ; i++){
                estoque.adicionarItem(items.get(i), "programa");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}