/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasdetarefas.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sistemasdetarefas.connection.Conexao;
import sistemasdetarefas.entities.Tarefa;

/**
 *
 * @author anapa
 */
public class TarefaDao {

    public void insert(Tarefa tarefa) throws SQLException {
        String comandoSql = "insert into Tarefa(objetivo, duracao, horario, data, status)values(?,?,?,?,?)";
        Conexao conexao = new Conexao();
        Connection con = conexao.getConnection();
        PreparedStatement estadoPreparado = con.prepareStatement(comandoSql);
        estadoPreparado.setString(1, tarefa.getObjetivo());
        estadoPreparado.setString(2, tarefa.getDuracao());
        estadoPreparado.setString(3, tarefa.getHorario());
        estadoPreparado.setString(4, tarefa.getData());
        estadoPreparado.setString(5, tarefa.getStatus());
        estadoPreparado.execute();
        estadoPreparado.close();
        con.close();
        
    }

    public void delete(int id) throws SQLException {
        String comandoSql = "delete from tarefa where id = ?";
        Conexao conexao = new Conexao();
        Connection con = conexao.getConnection();
        PreparedStatement estadoPreparado = con.prepareStatement(comandoSql);
        estadoPreparado.setInt(1, id);
        estadoPreparado.execute();
        estadoPreparado.close();
        con.close();
    }

    public void update(Tarefa tarefa) throws SQLException {
        String comandoSql = "update tarefa set objetivo = ?, duracao = ?, horario = ?,data = ?, status = ? where id = ?";
        Conexao conexao = new Conexao();
        Connection con = conexao.getConnection();
        PreparedStatement estadoPreparado = con.prepareStatement(comandoSql);
        estadoPreparado.setString(1, tarefa.getObjetivo());
        estadoPreparado.setString(2, tarefa.getDuracao());
        estadoPreparado.setString(3, tarefa.getHorario());
        estadoPreparado.setString(4, tarefa.getData());
        estadoPreparado.setString(5, tarefa.getStatus());
        estadoPreparado.setInt(6, tarefa.getId());
        estadoPreparado.execute();
        estadoPreparado.close();
        con.close();
        
    }
    
    public ArrayList<Tarefa>selectAll() throws SQLException{
        String comandoSql = "select * from tarefa";
        Conexao conexao = new Conexao();
        Connection con = conexao.getConnection();
        PreparedStatement estadoPreparado = con.prepareStatement(comandoSql);
        ResultSet retorno = estadoPreparado.executeQuery();
        ArrayList<Tarefa> tarefas = new ArrayList();
        while(retorno.next()){
            Tarefa tarefa = new Tarefa(retorno.getInt("id"), retorno.getString("objetivo"), retorno.getString("duracao"), retorno.getString("horario"), retorno.getString("data"), retorno.getString("status"));
            tarefas.add(tarefa);
        }
        return tarefas;
    }
            
    
}
