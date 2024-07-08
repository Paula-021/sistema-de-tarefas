/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasdetarefas.entities;

/**
 *
 * @author anapa
 */
public class Tarefa {
    private int id;
    private String objetivo;
    private String duracao;
    private String horario;
    private String data;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objtivo) {
        this.objetivo = objtivo;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Tarefa(String objetivo, String duracao, String horario, String data, String status) {
        this.objetivo = objetivo;
        this.duracao = duracao;
        this.horario = horario;
        this.data = data;
        this.status = status;
    }

    public Tarefa() {
    }

    public Tarefa(int id, String objetivo, String duracao, String horario, String data, String status) {
        this.id = id;
        this.objetivo = objetivo;
        this.duracao = duracao;
        this.horario = horario;
        this.data = data;
        this.status = status;
    }
    
    
}
