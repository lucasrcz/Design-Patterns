package mediator;

import mediator.classes.ChatRoom;
import mediator.classes.ChatRoomMediator;
import mediator.classes.Usuario;
import mediator.classes.UsuarioConcreto;

public class MainMediator {
    public static void main(String[] args) {
        ChatRoomMediator chatRoom = new ChatRoom();
        Usuario lucas = new UsuarioConcreto("Lucas",chatRoom,"lucas@email.com");
        Usuario joao = new UsuarioConcreto("João",chatRoom,"joão@email.com");
        lucas.inscreverNoChat();
        joao.inscreverNoChat();
        lucas.enviarPedidoDeAmizadePara(joao);
        joao.aceitarAmizade(lucas.getId());
        lucas.enviarMensagemPara(joao,"Olá mundo!");
    }
}
