package br.edu.ifpb.dac.service;

import br.edu.ifpb.dac.dao.ContatoDAO;
import br.edu.ifpb.dac.model.Contato;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContatoService {

    private ContatoDAO dao;

    public ContatoService() {
        try {
            this.dao = new ContatoDAO();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void salvar(Contato c) {
        this.dao.salvar(c);
    }

    public void deletar(String email) {
        this.dao.deletar(email);
    }

    public Contato buscaNome(String nome) {
        return this.dao.buscaNome(nome);
    }

    public void atualizar(Contato c) {
        this.dao.atualizar(c);
    }

    public List<Contato> ordemAlfabetica() {
        return this.dao.buscaOrdemAlfabetica();
    }

    public boolean autenticar(String email, String senha) {
        return this.dao.login(email, senha);
    }
    
    public Contato buscar(String email){
        return this.dao.buscar(email);
    }
    
    public HashMap<String,List<Contato>> ordernarPorLetra(){
        return this.dao.ordenarLetras();
    }
}
