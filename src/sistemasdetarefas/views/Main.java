/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasdetarefas.views;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import sistemasdetarefas.entities.Tarefa;
import sistemasdetarefas.models.TarefaModel;

/**
 *
 * @author anapa
 */
public class Main {
    
    
    
    public static void cadastrar() throws SQLException{
        String resposta = "sim";
        while (resposta.equalsIgnoreCase("sim")) { 
            System.out.println("Digite o objetivo da tarefa: ");
            Scanner scan = new Scanner(System.in);
            String objetivo = scan.nextLine();
            System.out.println("Digite o tempo de duração da tarefa: ");
            String duracao = scan.nextLine();
            System.out.println("Digite o horário: ");
            String horario = scan.nextLine();
            System.out.println("Digite a data: ");
            String data = scan.nextLine();
            System.out.println("Digite o status: ");
            String status = scan.nextLine();
            
            Tarefa tarefa = new Tarefa(objetivo, duracao, horario, data, status);
            TarefaModel model = new TarefaModel();
            model.insert(tarefa);
            System.out.println("Tarefa adicionada na lista.");
            System.out.println("Deseja cadastrar mais uma tarefa? ");
            resposta = scan.next();
            
        }
        menu();
        
    }
    
    public static void visualizar() throws SQLException{
        TarefaModel model = new TarefaModel();
        ArrayList<Tarefa> tarefas = model.selectAll();
        if (tarefas.size() == 0){
           System.out.println("Nenhuma tarefa listada");
        }else {
            for(int i = 0; i < tarefas.size(); i++) {
                Tarefa tarefa = tarefas.get(i);
                System.out.println(tarefa.getId() + " - Objetivo: " + tarefa.getObjetivo() + "\nDuração: " + tarefa.getDuracao() + "\nHorário: " + tarefa.getHorario() + "\nData: " + tarefa.getData() + "\nStatus: " + tarefa.getStatus());
                
            }
        }  
    }
    
    public static void editar() throws SQLException{
            Scanner scan = new Scanner(System.in);
            visualizar();
            System.out.println("Qual é o id da tarefa que deseja editar? ");
            int idTarefa = Integer.parseInt(scan.nextLine());
           // String numeroTarefa = scan.nextLine();
           // int numeroTarefaConvertido = Integer.parseInt(numeroTarefa);
            System.out.println("Digite o objetivo da tarefa: ");
            String objetivo = scan.nextLine();
            System.out.println("Digite o tempo de duração da tarefa: ");
            String duracao = scan.nextLine();
            System.out.println("Digite o horário: ");
            String horario = scan.nextLine();
            System.out.println("Digite a data: ");
            String data = scan.nextLine();
            System.out.println("Digite o status: ");
            String status = scan.nextLine();
            Tarefa tarefa = new Tarefa(idTarefa,objetivo, duracao, horario, data, status);
            TarefaModel model = new TarefaModel();
            model.update(tarefa);
            //tarefas.set(numeroTarefaConvertido, tarefa);
            System.out.println("Tarefa editada com sucesso.");
            menu();
    }
    
    public static void deletar() throws SQLException{
        Scanner scan = new Scanner(System.in);
        //visualizar();
        System.out.println("Qual o id da tarefa que deseja deletar?");
        int id = scan.nextInt();
        TarefaModel model = new TarefaModel();
        model.delete(id);
        System.out.println("Tarefa deletada com sucesso.");
        menu();
    }
    
    public static void pesquisarTarefaPeloNome(){
        // este método irá servir para buscar uma tarefa pelo seu nome (como se fosse um filtro)
    }
    
    public static void menu() throws SQLException{
        System.out.println("Digite a opção desejada?\n1-cadastrar\n2-visualizar\n3-editar\n4-deletar");
        Scanner scan = new Scanner(System.in);
        int opcao = scan.nextInt();
        
        if(opcao == 1){
            cadastrar();    
        }else if(opcao == 2){
            visualizar();
            menu();
        }else if(opcao == 3){
            editar();
        }else if (opcao == 4){
            deletar();
        }else{
            System.out.println("Opção inválida!");
        }
    }
    public static void main(String[] args) throws SQLException {
        menu();
        
    }
}
