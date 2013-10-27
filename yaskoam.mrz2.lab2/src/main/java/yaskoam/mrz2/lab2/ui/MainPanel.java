package yaskoam.mrz2.lab2.ui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javafx.fxml.FXML;
import yaskoam.mrz2.lab2.ui.menu.MenuPanel;
import yaskoam.mrz2.lab2.ui.panels.ErrorChartPanel;
import yaskoam.mrz2.lab2.ui.panels.ImagesPanel;
import yaskoam.mrz2.lab2.ui.panels.SettingsAndResultsPanel;
import yaskoam.mrz2.lab2.ui.panels.WeightMatrixPanel;

/**
 * @author Q-YAA
 */
public class MainPanel extends BaseComponent {

    @FXML
    private ImagesPanel imagesPanel;

    @FXML
    private MenuPanel menuPanel;

    @FXML
    private SettingsAndResultsPanel settingsAndResultsPanel;

    @FXML
    private ErrorChartPanel errorChartPanel;

    @FXML
    private WeightMatrixPanel weightMatrixPanel;

    private UiLogger uiLogger;

    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        uiLogger = createUiLogger();
        menuPanel.setMainPanel(this);
        uiLogger.setChartPoints(errorChartPanel.getChartPoints());
    }

    public ImagesPanel getImagePanel() {
        return imagesPanel;
    }

    private UiLogger createUiLogger() {
        StringProperty totalErrorProperty = new SimpleStringProperty();
        StringProperty meanErrorProperty = new SimpleStringProperty();
        StringProperty numberOfIterationsProperty = new SimpleStringProperty();

        settingsAndResultsPanel.getTotalErrorTextField().textProperty().bindBidirectional(totalErrorProperty);
        settingsAndResultsPanel.getMeanErrorTextField().textProperty().bindBidirectional(meanErrorProperty);
        settingsAndResultsPanel.getNumberOfIterationsTextField().textProperty().bindBidirectional(numberOfIterationsProperty);

        return new UiLogger(totalErrorProperty, meanErrorProperty, numberOfIterationsProperty);
    }
}
