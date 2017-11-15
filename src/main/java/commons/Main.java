package commons;

import controller.MainController;
import dao.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    public static BookRepository bookRepository;
    public static UserRepository userRepository;

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/main.fxml"));
        Parent root = loader.load();
        MainController controller = loader.getController();
        controller.init();

        primaryStage.setTitle("Library");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        bookRepository.release();
        DbUtils.getEntityManagerFactory().close();
        System.exit(0);
    }

    @Override
    public void init() throws Exception {
        super.init();
        bookRepository= new BookRepositoryImpl();
        userRepository = new UserRepositoryImpl();
    }
}
