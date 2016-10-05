
import Entidades.Produto;
import Util.HibernateUtil;

import java.math.BigDecimal;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class Teste {
   
    public static void main(String[] args) {
       
      Produto produto = new Produto();
      produto.setNome("moto G");
      produto.setDescricao("motorola");
      produto.setValor(new BigDecimal(900.0));
        
      
       Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction t = session.getTransaction();
        
        t.begin();
        session.save(produto);
        t.commit();
        session.close();
      
       
        System.out.println(produto.getNome());
        System.out.println(produto.getDescricao());
        System.out.println(produto.getValor()); 
        
        
        
        
    }
    
    
    
}
