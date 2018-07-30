package br.edu.ifpb.dac.controller;

import br.edu.ifpb.dac.model.Contato;
import br.edu.ifpb.dac.service.ContatoService;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ControladorContato {

    private ContatoService service = new ContatoService();
    private Contato autenticacao = new Contato();
    private Contato contato = new Contato();

    public String autenticar() {
        if (service.autenticar(autenticacao.getEmail(), autenticacao.getSenha())) {
            this.contato = service.buscar(this.autenticacao.getEmail());
            this.autenticacao = new Contato();
            return "inicial.xhtml";
        }
        return null;
    }

    public String cadastrar() {
        this.service.salvar(contato);
        return null;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Contato getAutenticacao() {
        return autenticacao;
    }

    public void setAutenticacao(Contato autenticacao) {
        this.autenticacao = autenticacao;
    }

    public String logoff() {
        this.contato = new Contato();
        return "index.xhtml";
    }
}
