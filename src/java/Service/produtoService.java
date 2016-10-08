package Service;

import Entidades.Produto;
import Util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ViewScoped // Mantem a sessao ativa para atualização
@ManagedBean // faz o link desta classe com a classe de front ou index
public class produtoService {

    private Produto produto = new Produto();
    private List<Produto> produtos = new ArrayList<>();
    private boolean atualiza = false;
    
       public produtoService() {
        listarProdutos();
    }

    // METODO LISTAR PRODUTOS
    public void listarProdutos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        produtos = session.createCriteria(Produto.class).list();
    }

    // METODO SALVAR PRODUTO
    public void salvarProduto() {

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

    // METODO EXCLUIR PRODUTOS
    public void excluir(Produto p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.getTransaction();

        try {
            t.begin();
            session.delete(p);
            t.commit();
            listarProdutos();

        } catch (Exception e) {
        } finally {
            session.close();
        }

    }
    // METODO CAPTURAR PRODUTO 
    public void capturarProduto(Produto p) {
        atualiza = true;
        produto = p;
    }
    
    // METODO ATUALIZAR
    public void atualizar() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.getTransaction();

        try {
            t.begin();
            session.update(produto);
            t.commit();
        } catch (Exception e) {
        } finally {
            session.close();
        }

    }

    // METODOS GET/SET
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public boolean isAtualiza() {
        return atualiza;
    }

    public void setAtualiza(boolean atualiza) {
        this.atualiza = atualiza;
    }
}
