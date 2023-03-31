public class ProdutoJPA {
    public void save(Produto produto) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("produto_jpa");
        EntityManager em = factory.createEntityManager();

        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        transaction = em.getTransaction();

        transaction.begin();
        em.persist(produto);
        transaction.commit();
        em.close();
    }
}