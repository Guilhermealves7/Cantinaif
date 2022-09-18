import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Screen extends JFrame implements ActionListener {
    private JTextField txtSenha;
    private JTextField txtNome;
    private JLabel lblSenha;
    private JLabel lblNome;
    private JButton btnAdm;
    private JTextField txtCodigo;
    private JLabel lblCodigo;
    private Container ctn;
    
    // Construtor do Jlabel e suas configurações 
    public Screen() {

        setSize(300, 250); // Tamanho da tela
        setTitle("Login"); // Titulo da tela
        ctn = getContentPane();
        ctn.setLayout(null);
        setLocationRelativeTo(null); // Centralizando
        // Definindo os texto e as caixa de texto
        btnAdm = new JButton("Acessar");
        lblNome = new JLabel("Nome");
        txtNome = new JTextField();
        lblSenha = new JLabel("Senha");
        txtSenha = new JTextField();
        lblCodigo = new JLabel("Código");
        txtCodigo = new JTextField();
        // Posicionando e alterando o tamanho
        lblNome.setBounds(10, 30, 100, 25);
        txtNome.setBounds(70, 30, 200, 25);
        lblCodigo.setBounds(10, 70, 100, 25);
        txtCodigo.setBounds(70, 70, 200, 25);
        lblSenha.setBounds(10, 110, 100, 25);
        txtSenha.setBounds(70, 110, 200, 25);
        btnAdm.setBounds(100, 150, 100, 40);
        ctn.add(lblCodigo);
        ctn.add(txtCodigo);
        ctn.add(btnAdm);
        ctn.add(lblSenha);
        ctn.add(txtSenha);
        ctn.add(lblNome);
        ctn.add(txtNome);

        //Adicionando um evento ao botao "Acessar" da tela
        btnAdm.addActionListener(this);
      
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getActionCommand().equals("Acessar")) {
            checkLogin();
            dispose(); // Fechar a tela
        }
    }

    // Metodo para checar o Login do Funcionario
    
    public void checkLogin(){

        for(int i = 0; i < Menu.funcionarios.size(); i++){
            try{
                boolean c1 = (Menu.funcionarios.get(i).getCodigo() == Integer.parseInt(txtCodigo.getText()));
                boolean c2 = (Menu.funcionarios.get(i).getSenha().equals(txtSenha.getText()));
                boolean c3 = (Menu.funcionarios.get(i).getNome().equals(txtNome.getText()));

                     
                if(c1 && c2 && c3){
                    Menu.loginV = "Autorizado";
                    return ;
                }
            }
            catch(Exception e){
                Menu.loginV = "Não autorizado";
            }

        }
        Menu.loginV = "Não autorizado";
    }
}