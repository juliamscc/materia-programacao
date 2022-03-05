/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.model.dao;

import mercado.connection.ConnectionFactory;
import mercado.model.bean.Aluno;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julia
 */
public class AlunoDAO {
    public void onSave(Aluno aluno) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        
        try{
            statement = connection.prepareStatement("INSERT INTO aluno(nome, matricula, cpf) VALUES (?,?,?)");
            
            statement.setString(1, aluno.getNome());
            statement.setString(2, aluno.getMatricula());
            statement.setInt(3, aluno.getCpf());
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Salvo com Sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar!"+e);
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
        
    public List<Aluno> onRead() {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
            
        List<Aluno> listaDeAlunos = new ArrayList<>();
            
        try {
            statement = connection.prepareStatement("SELECT * FROM aluno");
            resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Aluno aluno = new Aluno();
                
                aluno.setId(resultSet.getInt("id"));
                aluno.setNome(resultSet.getString("nome"));
                aluno.setMatricula(resultSet.getString("matricula"));
                aluno.setCpf(resultSet.getInt("cpf"));
                
                listaDeAlunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        return listaDeAlunos;
    }
}
