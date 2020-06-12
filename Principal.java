import javax.swing.JOptionPane;
public class Principal{

   public static void main (String [ ] args){
      String menu = "1-Cadastrar\n2-Atualizar\n3-Apagar\n4-Listar\n0-Sair";
      int op;
      do{
         op = Integer.parseInt(JOptionPane.showInputDialog(menu));
         switch (op){
            default:
               JOptionPane.showMessageDialog (null, "Opção inválida");
               break;
            case 1:{
               String nome = JOptionPane.showInputDialog ("Nome?");
               String fone = JOptionPane.showInputDialog ("Fone?");
               String email = JOptionPane.showInputDialog ("Email?");
               Pessoa p = new Pessoa (nome, fone, email);
               p.inserir();
               JOptionPane.showMessageDialog (null, "Ok, inseriu!");
               break;
            }             
            case 2:{
               String nome = JOptionPane.showInputDialog ("Nome?");
               String fone = JOptionPane.showInputDialog ("Fone?");
               String email = JOptionPane.showInputDialog ("Email?");
               int codigo = Integer.parseInt (JOptionPane.showInputDialog ("Codigo?"));
               Pessoa p = new Pessoa (codigo, nome, fone, email);
               p.atualizar();
               JOptionPane.showMessageDialog (null, "Pessoa atualizada");
            }
               break;
            case 3:{
               Pessoa teste = new Pessoa ("Ana");
               int codigo = Integer.parseInt (JOptionPane.showInputDialog ("Codigo?"));
               Pessoa p = new Pessoa (codigo);
               p.apagar();
               JOptionPane.showMessageDialog (null, "Apagou");
            }
               break;
            case 4:
               break;
            case 0:
               JOptionPane.showMessageDialog (null, "ok, adeus");
               break;
            
         }
      }while (op != 0);
   }

}