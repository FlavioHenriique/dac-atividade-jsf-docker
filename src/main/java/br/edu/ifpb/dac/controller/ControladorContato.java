package br.edu.ifpb.dac.controller;

import br.edu.ifpb.dac.model.Contato;
import br.edu.ifpb.dac.service.ContatoService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ControladorContato implements Serializable {

    private ContatoService service = new ContatoService();
    private Contato autenticacao = new Contato();
    private Contato buscado = new Contato();
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

    public void buscaPorNome(String nome) {
        this.buscado = this.service.buscaNome(nome);
    }

    public List<Contato> ordemAlfabetica() {
        return this.service.ordemAlfabetica();
    }

    public String excluir(Contato c) {
        this.service.deletar(c.getEmail());
        if (c.getEmail().equals(this.contato.getEmail())) {
            return logoff();
        }
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

    public Contato getBuscado() {
        return buscado;
    }

    public void setBuscado(Contato buscado) {
        this.buscado = buscado;
    }

    public String logoff() {
        this.contato = new Contato();
        return "index.xhtml";
    }
}
