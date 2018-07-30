package br.edu.ifpb.dac.dao;

import br.edu.ifpb.dac.model.Contato;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContatoDAO {

    private Connection conn;

    public ContatoDAO() throws SQLException, ClassNotFoundException {
        this.conn = Conexao.getConnection();
    }

    public boolean salvar(Contato c) {

        String sql = "INSERT INTO CONTATO (nome,email,senha,telefone,nascimento)"
                + "VALUES (?,?,?,?,?);";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEmail());
            stmt.setString(3, c.getSenha());
            stmt.setString(4, c.getTelefone());
            stmt.setDate(5, Date.valueOf(c.getDataNascimento()));
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public void deletar(String email) {
        String sql = "DELETE FROM Contato where email = ?;";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean atualizar(Contato c) {
        String sql = "UPDATE Contato set nome = ?, email = ?, senha = ?, "
                + "telefone = ?, nascimento = ?;";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEmail());
            stmt.setString(3, c.getSenha());
            stmt.setString(4, c.getTelefone());
            stmt.setDate(5, Date.valueOf(c.getDataNascimento()));
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Contato buscar(String email) {

        String sql = "SELECT * FROM CONTATO WHERE Email = ?;";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Contato c = new Contato();
                c.setDataNascimento(rs.getDate("nascimento").toLocalDate());
                c.setEmail(rs.getString("email"));
                c.setNome(rs.getString("nome"));
                c.setSenha(rs.getString("senha"));
                c.setTelefone(rs.getString("telefone"));
                System.out.println(c.toString());
                return c;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public Contato buscaNome(String nome) {

        String sql = "SELECT email FROM contato WHERE nome = ?;";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return this.buscar(rs.getString("email"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Contato> buscaOrdemAlfabetica() {
        String sql = "SELECT email FROM contato ORDER BY nome;";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Contato> contatos = new ArrayList<>();
            while (rs.next()) {
                contatos.add(this.buscar(rs.getString("email")));
            }
            return contatos;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean login(String email, String senha){
        String sql = "SELECT * FROM Contato WHERE email = ? AND senha = ?;";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,email);
            stmt.setString(2, senha);
            return stmt.executeQuery().next();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
