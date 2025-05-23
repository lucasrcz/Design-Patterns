package mediator.classes;


public class UsuarioConcreto extends Usuario{

    public UsuarioConcreto(String nome,
                           ChatRoomMediator chatRoomMediator, String email) {
        super(nome, chatRoomMediator, email);
    }
}
