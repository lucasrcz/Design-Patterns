package mediator.classes;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Data
@ToString(exclude = {"amigos","pedidosAmizade"})
@EqualsAndHashCode(exclude = "amigos")
public abstract class Usuario {

    private Integer id;

    private String nome;

    private String email;

    private Map<Integer,Usuario> amigos = new HashMap<>();

    private Map<Integer,Usuario> pedidosAmizade = new HashMap<>();

    private ChatRoomMediator chatRoomMediator;

    public Usuario(String nome,
                   ChatRoomMediator chatRoomMediator,String email) {
        this.nome = nome;
        this.chatRoomMediator = chatRoomMediator;
        this.email = email;
    }

    public void enviarMensagemPara(Usuario destinatario, String mensagem) {
        chatRoomMediator.enviarMensagemDePara(this, destinatario, mensagem);
    }

    public void enviarPedidoDeAmizadePara(Usuario requisitado) {
        chatRoomMediator.enviarPedidoAmizadeDePara(this, requisitado);
    }

    public void desfazerAmizadeCom(Usuario amigo) {
        chatRoomMediator.desfazerAmizadeDePara(this, amigo);
    }

    public void aceitarAmizade(int idPedido) {
        chatRoomMediator.aceitarAmizadeDe(this,idPedido);
    }

    public void inscreverNoChat() {
        chatRoomMediator.inscrever(this);
    }
}
