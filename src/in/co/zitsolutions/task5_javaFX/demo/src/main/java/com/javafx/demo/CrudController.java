package com.javafx.demo;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class CrudController {
    @javafx.fxml.FXML
    private TableColumn<BookBean, String> colAuthor;
    @javafx.fxml.FXML
    private TextField txtYear;
    @javafx.fxml.FXML
    private Button btnInsert;
    @javafx.fxml.FXML
    private Button btnUpdate;
    @javafx.fxml.FXML
    private TableColumn<BookBean, Integer> colPages;
    @javafx.fxml.FXML
    private TextField txtAuthor;
    @javafx.fxml.FXML
    private TextField txtPages;
    @javafx.fxml.FXML
    private TextField txtId;
    @javafx.fxml.FXML
    private TableColumn<BookBean, Integer> colYear;
    @javafx.fxml.FXML
    private Button btnDelete;
    @javafx.fxml.FXML
    private TableColumn<BookBean, Integer> colId;
    @javafx.fxml.FXML
    private TableColumn<BookBean, String> colTitle;
    @javafx.fxml.FXML
    private TextField txtTitle;
    @javafx.fxml.FXML
    private TableView<BookBean> tbBooks;

    public void handleButtonAction(ActionEvent e){
        System.out.println("Event handler called");
    }

    public void showBooks(){
        this.tbBooks.getItems().clear();
        ObservableList<BookBean> books = null;
        try{
            books = BookDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.colId.setCellValueFactory(new PropertyValueFactory<BookBean, Integer>("id"));
        this.colTitle.setCellValueFactory(new PropertyValueFactory<BookBean, String>("title"));
        this.colAuthor.setCellValueFactory(new PropertyValueFactory<BookBean, String>("author"));
        this.colYear.setCellValueFactory(new PropertyValueFactory<BookBean, Integer>("year"));
        this.colPages.setCellValueFactory(new PropertyValueFactory<BookBean, Integer>("pages"));

        this.tbBooks.setItems(books);
    }

    public void insert(){
        BookBean book = new BookBean();
        book.setAuthor(txtAuthor.getText());
        book.setTitle(txtTitle.getText());
        book.setYear(Integer.parseInt(txtYear.getText()));
        book.setPages(Integer.parseInt(txtPages.getText()));
        book.setId(Integer.parseInt(txtId.getText()));
        try{
            BookDAO.insert(book);
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.txtAuthor.setText("");
        this.txtTitle.setText("");
        this.txtYear.setText("");
        this.txtPages.setText("");
        this.txtId.setText("");
        showBooks();
    }

    public void delete(){
        String id = txtId.getText();
        try{
            BookDAO.delete(id);
        } catch (SQLException e){
            e.printStackTrace();
        }
        this.txtId.setText("");
        showBooks();
    }

    public void update(){
        BookBean book = new BookBean();
        book.setId(Integer.parseInt(txtId.getText()));
        book.setTitle(txtTitle.getText());
        book.setAuthor(txtAuthor.getText());
        book.setYear(Integer.parseInt(txtYear.getText()));
        book.setPages(Integer.parseInt(txtPages.getText()));

        try{
            BookDAO.update(book);
        } catch (SQLException e){
            e.printStackTrace();
        }

        this.txtTitle.setText("");
        this.txtAuthor.setText("");
        this.txtYear.setText("");
        this.txtPages.setText("");
        this.txtId.setText("");
        showBooks();
    }
}
