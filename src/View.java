import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

public class View implements Initializable {

    final int INITIAL_VALUE = 1;

    public Spinner <Integer> firstNum;
    public TextArea myLabel;
    SpinnerValueFactory <Integer> firstNumber = new SpinnerValueFactory.IntegerSpinnerValueFactory(3,10,INITIAL_VALUE);

    public Spinner <Integer> secondNum;
    SpinnerValueFactory <Integer> secondNumber = new SpinnerValueFactory.IntegerSpinnerValueFactory(3,10,INITIAL_VALUE);


    public void handleButton(ActionEvent actionEvent) throws FileNotFoundException {

        int firstNumberValue = firstNum.getValue();
        int secondNumberValue = secondNumber.getValue();

        Random rd = new Random();

        for(int  i =  0; i < 20; i++){

            int randomNumbers = rd.nextInt(firstNumberValue,secondNumberValue);
            try {
                FileWriter fw = new FileWriter("C:\\Users\\nikam\\Desktop\\davalebebi/faili.txt");
                fw.write(randomNumbers + "\n");
                fw.close();
                System.out.println("Success");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error");
            }

        }


        // wakitxva try da catchic unda ideashi

        File file = new File("C:\\Users\\nikam\\Desktop\\davalebebi/faili.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()){
            String line  = scanner.nextLine();
            System.out.println(line);
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstNum.setValueFactory(firstNumber);
        secondNum.setValueFactory(secondNumber);
    }
}
