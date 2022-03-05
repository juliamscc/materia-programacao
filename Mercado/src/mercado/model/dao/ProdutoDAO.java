/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mercado.model.dao;



//import com.mysql.cj.protocol.Resultset;
import mercado.connection.ConnectionFactory;
import mercado.model.bean.Produto;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    //Insert
    public void onSave(Produto produto){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        //insert into produto (id, categoria_id, descricao, quantidade, preco)
//values ();

        try {

            stmt = con.prepareStatement("INSERT INTO produto(categoria_id, descricao, quantidade, preco) VALUES (?,?,?,?)");

            stmt.setInt(1,produto.getCategoria_id());
            stmt.setString(2,produto.getDescricao());
            stmt.setInt(3,produto.getQuantidade());
            stmt.setDouble(4,produto.getPreco());

            //stmt.executeUpdate();
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null,"Salvo com Sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar !"+e);

            e.printStackTrace();

        }finally {

            ConnectionFactory.closeConnection(con,stmt);
        }
    }
    
    
     //Select - Consulta
    public List<Produto> onRead(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtosLista = new ArrayList<>();
          try {

            stmt = con.prepareStatement("SELECT * FROM produto");
            rs = stmt.executeQuery();
           
           
           while(rs.next()){
               Produto produto = new Produto();
               
               produto.setId(rs.getInt("id"));
               produto.setCategoria_id(rs.getInt("categoria_id"));
               produto.setDescricao(rs.getString("descricao"));
               produto.setQuantidade(rs.getInt("quantidade"));
               produto.setPreco(rs.getDouble("preco"));
               
               produtosLista.add(produto);
           }

        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null,"Erro ao salvar !"+e);

            e.printStackTrace();

        }finally {

            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        
        return produtosLista;
    }    
    
}
