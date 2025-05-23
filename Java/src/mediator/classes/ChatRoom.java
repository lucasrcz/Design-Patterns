package mediator.classes;

import exceptions.MsgException;

public class ChatRoom implements ChatRoomMediator{

    Integer idInscritos = 0;

    @Override
    public void enviarMensagemDePara(Usuario de,
                                     Usuario para,
                                     String mensagem) {
        if(para.getAmigos().containsKey(de.getId())){
            System.out.println("Enviando mensagem para: " + para.getNome() + " : " + mensagem + " de:"
            + de.getNome() + " para o email: " + para.getEmail());
        }else{
            System.out.println("Você não pertence ao ciclo de amizade de" + para.getNome());
        }
    }

    @Override
    public void enviarPedidoAmizadeDePara(Usuario solicitante,
                                          Usuario requisitado) {
        if(isInscrito(solicitante) && isInscrito(requisitado) && !requisitado.getAmigos().containsKey(solicitante.getId())){
                requisitado.getPedidosAmizade().put(solicitante.getId(),solicitante);
        }
    }

    @Override
    public void desfazerAmizadeDePara(Usuario usuario,
                                      Usuario excluido) {
            if(usuario.getAmigos().containsKey(excluido.getId())){
                usuario.getAmigos().remove(excluido.getId());
                excluido.getAmigos().remove(usuario.getId());
            }
    }

    @Override
    public void aceitarAmizadeDe(Usuario usuario,int id) {
        if(usuario.getPedidosAmizade().containsKey(id)){
            Usuario solicitante = usuario.getPedidosAmizade().get(id);
            usuario.getAmigos().put(solicitante.getId(),solicitante);
            solicitante.getAmigos().put(usuario.getId(),usuario);
            usuario.getPedidosAmizade().remove(id);
        }
    }

    @Override
    public void inscrever(Usuario usuario) {
        if(usuario != null){
            usuario.setId(++idInscritos);
        }
    }


    @Override
    public boolean isInscrito(Usuario usuario) {
        if(usuario.getId() != null){
            return true;
        }else{
            throw new MsgException(usuario.getNome() +" não inscrito na sala");
        }
    }
}
