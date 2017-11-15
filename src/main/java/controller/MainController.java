package controller;

import commons.Main;
import dao.BookRepository;
import dao.UserRepository;
import entity.Book;
import entity.User;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.util.Collection;

public class MainController {

    @FXML
    public AnchorPane anchorPaneForPagination;
    private BookRepository bookRepository = Main.bookRepository;
    private UserRepository userRepository = Main.userRepository;

    @FXML
    public TextField bookName;
    @FXML
    public TextField bookAuthor;
    @FXML
    public TextField userName;
    @FXML
    public TextField userAddress;

    public MainController() {
        System.out.println("init main controller");
    }

    public void fillTable(ActionEvent actionEvent) {
        Collection<Book> books = bookRepository.getAll();
        books.forEach(Book::getName);

    }

    public void addBook(ActionEvent actionEvent) {
        Book book = new Book(bookName.getText(),bookAuthor.getText());
        bookRepository.create(book);
        bookName.clear();
        bookAuthor.clear();

    }

    public void addUser(ActionEvent actionEvent) {
        User user = new User(userName.getText(),userAddress.getText());
        userRepository.create(user);
        userName.clear();
        userAddress.clear();
    }

    public void init(){
        Pagination pagination = new Pagination();
        pagination.setPageCount(5);
        pagination.setCurrentPageIndex(0);
        pagination.setPageFactory(param -> {
            VBox vBox = new VBox();
            Label label = new Label();
            label.setText("label "+param );
            vBox.getChildren().add(label);
            return vBox;
        });
        anchorPaneForPagination.getChildren().add(pagination);
    }

}
