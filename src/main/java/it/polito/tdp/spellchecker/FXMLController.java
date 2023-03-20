package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ResourceBundle;

import id.polito.tdp.spellchecker.model.Dictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	private Dictionary model;
	
	public void setModel(Dictionary model) {
		this.model = model;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCheck;

    @FXML
    private Button btnClear;

    @FXML
    private Label execTime;

    @FXML
    private ChoiceBox<String> lngChoice;

    @FXML
    private Label txtError;

    @FXML
    private TextArea txtInput;

    @FXML
    private TextArea txtResult;

    @FXML
    void check(ActionEvent event) {
    	this.model.loadDictionary(lngChoice.getValue());
    	this.txtResult.setText(this.model.returnUncorrectWords(this.model.spellCheckText(this.model.txtAreaToList(null))));
    	this.execTime.setText("Spell check completed in:"+ Long.toString(System.currentTimeMillis()));
    	this.txtError.setText("The text contains " + this.model.getErrCounter() + " error(s)");
    }

    @FXML
    void clear(ActionEvent event) {
    	txtInput.clear();
    	txtResult.clear();
    }

    @FXML
    void initialize() {
        assert btnCheck != null : "fx:id=\"btnCheck\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert execTime != null : "fx:id=\"execTime\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lngChoice != null : "fx:id=\"lngChoice\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtError != null : "fx:id=\"txtError\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        lngChoice.setValue("Italian");
        lngChoice.setValue("English");
    }

}


