package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.model.RealModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class AnagrammiController {
	
	RealModel model;
	
    public void setModel(RealModel model) {
		this.model = model;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;
    
    @FXML
    private TextFlow txtFlow;
    
    private List<String> perm;
    
    @FXML
    void doCalcola(ActionEvent event) {
    	
    	txtFlow.getChildren().clear();
    	
    	String ptemp = txtParola.getText();
    	//List<String> perm = new LinkedList<String>(model.permuta(ptemp));
    	perm.addAll(model.permuta(ptemp));
    	for(String s: perm){
    		Text t = new Text(s + "\n");
    		//if(model.cerca(s) != null){
    			//txtResult.appendText(s + "\n");
    		//} else 
    		if(model.cercaDAO(s) == null){
    			//txtResult.setStyle("-fx-text-fill: red"); 
    			//txtResult.appendText(s.Color.red + "\n"); //"NON VALIDA\n");
    			t.setFill(javafx.scene.paint.Color.RED);	
    		}
    		txtFlow.getChildren().add(t);
    	}
    	perm.clear();
    	model.permuta(ptemp).clear();
    }

    @FXML
    void doReset(ActionEvent event) {
  
    	txtParola.clear();
    	txtFlow.getChildren().clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtFlow != null : "fx:id=\"txtFlow\" was not injected: check your FXML file 'Anagrammi.fxml'.";

        model = new RealModel();
        perm = new LinkedList<String>();
    }
}
