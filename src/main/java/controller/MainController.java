package controller;

import commons.Main;
import dao.BookRepository;
import dao.UserRepository;
import entity.Book;
import entity.User;
import javafx.event.ActionEvent;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;

import java.util.Collection;


public class MainController {

    public Pagination paginationTable;
    private BookRepository bookRepository = Main.bookRepository;
    private UserRepository userRepository = Main.userRepository;

    public TextField bookName;
    public TextField bookAuthor;
    public TextField userName;
    public TextField userAddress;

    public MainController() {

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


}
