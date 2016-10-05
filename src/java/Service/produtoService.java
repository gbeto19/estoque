
package Service;

import Entidades.Produto;
import Util.HibernateUtil;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
public class produtoService {
   
    private Produto produto = new Produto();
    
    
    public void salvarProduto(){
    
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction t = session.getTransaction();
    
    try {
         t.begin();
         session.save(produto);
         t.commit(); 
    } catch (Exception e) {
    
    } finally {
           session.close();
    }
    
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    }
