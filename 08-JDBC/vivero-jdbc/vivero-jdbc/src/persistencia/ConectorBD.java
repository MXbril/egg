package persistencia;

public interface ConectorBD {
    void connectarDataBase() throws Exception;
    void desconectarDataBase() throws Exception;
}
