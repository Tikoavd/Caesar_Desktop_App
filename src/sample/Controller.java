package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

public class Controller {
    @FXML
    private Text errorMessage;

    @FXML
    private TextArea mainText;

    @FXML
    private TextField numText;

    @FXML
    private Button runButton;

    @FXML
    void runHandle() {
        errorMessage.setText("");

        String numstr = numText.getText();
        if (numstr.isEmpty() || !numstr.matches("^-?\\d+$")) {
            errorMessage.setText("Enter valid number");
            return;
        }

        int num = Integer.parseInt(numstr);

        StringBuilder result = new StringBuilder();
        for (char character : mainText.getText().toCharArray()) {
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + 26 + num) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }

        mainText.setText(result.toString());
    }
}
