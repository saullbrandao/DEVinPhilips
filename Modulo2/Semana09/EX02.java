public class ProdutoJDBC {
    private final static String url = "jdbc:oracle:thin:@localhost:1521/dihphilips";
    private final static String user = "user";
    private final static String password = "password";

    public void save(Produto produto) {
        Connection connection;
        PreparedStatement statement;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            String sql = "INSERT INTO produtos (nome, descricao) VALUES (?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, dados.getNome());
            statement.setInt(2, dados.getDescricao());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Ocorreu um erro ao tentar inserir produto. %s", e.getMessage()));
        }
    }
}