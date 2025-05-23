package mediator.classes;

public interface ChatRoomMediator {

    void enviarMensagemDePara(Usuario de ,Usuario para , String mensagem);

    void enviarPedidoAmizadeDePara(Usuario solicitante, Usuario requisitado);

    void desfazerAmizadeDePara(Usuario usuario, Usuario excluido);

    void aceitarAmizadeDe(Usuario usuario, int id);

    void inscrever(Usuario usuario);

    boolean isInscrito(Usuario usuario);

}
