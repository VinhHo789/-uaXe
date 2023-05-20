module Game {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
	requires javafx.graphics;

    opens application to javafx.graphics, javafx.fxml, javafx.media;
    opens controller to javafx.graphics, javafx.fxml, javafx.media;
    opens music to javafx.graphics, javafx.fxml, javafx.media;
    opens view to javafx.graphics, javafx.fxml, javafx.media;
    opens img.asset to javafx.graphics, javafx.fxml, javafx.media;
    opens img.map to javafx.graphics, javafx.fxml, javafx.media;
    opens value to javafx.graphics, javafx.fxml, javafx.media;
}
