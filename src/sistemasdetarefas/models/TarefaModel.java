/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasdetarefas.models;

import java.sql.SQLException;
import java.util.ArrayList;
import sistemasdetarefas.daos.TarefaDao;
import sistemasdetarefas.entities.Tarefa;
/**
 *
 * @author anapa
 */
public class TarefaModel {
    public void insert(Tarefa tarefa) throws SQLException{
        TarefaDao dao = new TarefaDao();
        dao.insert(tarefa);
        
    }

    public void delete(int id) throws SQLException {
        TarefaDao dao = new TarefaDao();
        dao.delete(id);
    }

    public void update(Tarefa tarefa) throws SQLException {
        TarefaDao dao = new TarefaDao();
        dao.update(tarefa);
    }
    public ArrayList<Tarefa>selectAll() throws SQLException{
        TarefaDao dao = new TarefaDao();
        ArrayList<Tarefa> tarefas = dao.selectAll();
        return tarefas;
        
    }
    
}
