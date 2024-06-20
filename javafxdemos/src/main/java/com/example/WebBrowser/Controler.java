package com.example.WebBrowser;

import java.io.*;
import java.net.*;
import java.util.*;
import javafx.util.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.web.*;
import javafx.collections.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.stage.*;

public class Controler implements Initializable {

    @FXML
    private TextField urlTextField;
    @FXML
    private TabPane tabPane;
    @FXML
    private StackPane WebContainer;
    @FXML
    private BorderPane root;

    //Buttons
    @FXML
    private Button backButton;
    @FXML
    private Button forwardButton;
    @FXML
    private Button reloadButton;
    @FXML
    private Button homeButton;
    @FXML
    private Button addTabButton;

    @FXML
    private HBox BookmarkList;

    private String homeUrl = "https://www.google.com";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SetButtons();
        tabPane.setTabDragPolicy(TabPane.TabDragPolicy.REORDER);
        tabPane.getSelectionModel().selectedItemProperty().addListener((obs, oldTab, newTab) -> {
            if (newTab != null) {
                changeTab(null);
            }
        });
        LoadBookmarks();
        LoadTabs();
        if (tabPane.getTabs().size() == 0) {
            AddTab(null);
        }

        //add a listener to mouse 3 and 4
        root.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.BACK) {
                if (!backButton.isDisable()) {
                    back(null);
                }
            }
            else if (e.getButton() == MouseButton.FORWARD) {
                if (!forwardButton.isDisable()) {
                    forward(null);
                }
            }
        });
    }

    public void SetButtons(){
        int buttonSize = 25; // Size for both the button and the image
    
        ImageView backImage = new ImageView(new Image(getClass().getResource("data/img/back.png").toExternalForm()));
        backImage.setFitWidth(buttonSize);
        backImage.setFitHeight(buttonSize);
        backImage.setPreserveRatio(true);
    
        ImageView forwardImage = new ImageView(new Image(getClass().getResource("data/img/forward.png").toExternalForm()));
        forwardImage.setFitWidth(buttonSize);
        forwardImage.setFitHeight(buttonSize);
        forwardImage.setPreserveRatio(true);
    
        ImageView reloadImage = new ImageView(new Image(getClass().getResource("data/img/reload.png").toExternalForm()));
        reloadImage.setFitWidth(15);
        reloadImage.setFitHeight(15);
        reloadImage.setPreserveRatio(true);
    
        ImageView homeImage = new ImageView(new Image(getClass().getResource("data/img/home.png").toExternalForm()));
        homeImage.setFitWidth(15);
        homeImage.setFitHeight(15);
        homeImage.setPreserveRatio(true);

        ImageView addImage = new ImageView(new Image(getClass().getResource("data/img/add.png").toExternalForm()));
        addImage.setFitWidth(20);
        addImage.setFitHeight(20);
        addImage.setPreserveRatio(true);
    
        setButtonProperties(backButton, backImage, buttonSize, false);
        setButtonProperties(forwardButton, forwardImage, buttonSize, false);
        setButtonProperties(reloadButton, reloadImage, buttonSize, true);
        setButtonProperties(homeButton, homeImage, buttonSize, true);
        setButtonProperties(addTabButton, addImage, buttonSize, true);
    }
    
    private void setButtonProperties(Button button, ImageView imageView, int size, boolean padding) {
        button.setGraphic(imageView);
        if (padding) {
            button.setStyle("-fx-background-color: transparent;");
            button.setOnMouseExited(e -> button.setStyle("-fx-background-color: transparent;"));
            button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: lightgray;"));
        }
        else {
            button.setStyle("-fx-background-color: transparent; -fx-padding: 0; -fx-border-width: 0;");
            button.setOnMouseExited(e -> button.setStyle("-fx-background-color: transparent; -fx-padding: 0; -fx-border-width: 0;"));
            button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: lightgray; -fx-padding: 0; -fx-border-width: 0;"));
        }
        button.setPrefSize(size, size);
        button.setMaxSize(size, size);
    }

    public void loadUrl(){
        TabData tabData = (TabData) tabPane.getSelectionModel().getSelectedItem().getUserData();
        WebView webView = tabData.webView;
        webView.getEngine().load(tabData.CurrentUrl);
        urlTextField.setText(tabData.CurrentUrl);
    }

    public void loadUrl(String url){
        TabData tabData = (TabData) tabPane.getSelectionModel().getSelectedItem().getUserData();
        WebView webView = tabData.webView;
        webView.getEngine().load(url);
    }

    public void loadUrl(ActionEvent event){
        TabData tabData = (TabData) tabPane.getSelectionModel().getSelectedItem().getUserData();
        WebView webView = tabData.webView;
        String url = urlTextField.getText();
        webView.getEngine().load(url);
    }

    public void back(ActionEvent event){
        TabData tabData = (TabData) tabPane.getSelectionModel().getSelectedItem().getUserData();
        WebView webView = tabData.webView;
        WebHistory history = webView.getEngine().getHistory();
        history.go(-1);
        CheckHistoryButtons(history);
    }
    
    public void forward(ActionEvent event){
        TabData tabData = (TabData) tabPane.getSelectionModel().getSelectedItem().getUserData();
        WebView webView = tabData.webView;
        WebHistory history = webView.getEngine().getHistory();
        history.go(1);
        CheckHistoryButtons(history);
    }

    public void CheckHistoryButtons(WebHistory history){
        if (history.getCurrentIndex() == 0) {
            backButton.setDisable(true);
        }
        else {
            backButton.setDisable(false);
        }
        if (history.getCurrentIndex() == history.getEntries().size() - 1) {
            forwardButton.setDisable(true);
        }
        else {
            forwardButton.setDisable(false);
        }
    }

    public void reload(ActionEvent event){
        TabData tabData = (TabData) tabPane.getSelectionModel().getSelectedItem().getUserData();
        WebView webView = tabData.webView;
        webView.getEngine().reload();
    }

    public void home(ActionEvent event){
        TabData tabData = (TabData) tabPane.getSelectionModel().getSelectedItem().getUserData();
        WebView webView = tabData.webView;
        webView.getEngine().load(homeUrl);
    }

    public void changeTab(ActionEvent event){
        TabData tabData = (TabData) tabPane.getSelectionModel().getSelectedItem().getUserData();
        urlTextField.setText(tabData.CurrentUrl);
        SetContainer(tabData.webView);
        CheckHistoryButtons(tabData.webView.getEngine().getHistory());
    }

    public void AddTab(ActionEvent event) {
        WebView webView = new WebView();
        TabData tabData = new TabData(homeUrl, webView);
        tabData.favicon = getFavicon(homeUrl);
        SetContainer(webView);

        Tab tab = new Tab("Loading..."); // Initial title
        tab.setClosable(true);
        ContextMenu contextMenu = getTabContextMenu(tab);
        tab.setContextMenu(contextMenu);
        tab.setUserData(tabData);

        tab.setOnClosed(e -> {
            if (tabPane.getTabs().size() == 0) {
                Stage stage = (Stage) root.getScene().getWindow();
                stage.close();
            }
        });



        tabPane.getTabs().add(tab);
        tabPane.getSelectionModel().select(tab); // Select the newly added tab
        loadUrl();
        // Update the tab title when the page title changes
        webView.getEngine().titleProperty().addListener((obs, oldTitle, newTitle) -> {
            if (newTitle != null) {
                tab.setText("");
                HBox hbox = new HBox();
                if (tabData.favicon != null) {
                    ImageView imageView = new ImageView();
                    imageView.setImage(tabData.favicon);
                    hbox.getChildren().add(imageView);
                }
                hbox.getChildren().add(new Label(newTitle));
                hbox.setSpacing(3);
                tab.setGraphic(hbox);
            }
        });

        webView.getEngine().locationProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null) {
                urlTextField.setText(newValue);
                tabData.CurrentUrl = newValue;
                tabData.favicon = getFavicon(newValue);
            } else {
                System.err.println("New URL is null");
            }
        });

        webView.getEngine().getHistory().currentIndexProperty().addListener((obs, oldValue, newValue) -> {
            CheckHistoryButtons(webView.getEngine().getHistory());
        });

        webView.getEngine().getHistory().getEntries().addListener((ListChangeListener<WebHistory.Entry>) change -> {
            CheckHistoryButtons(webView.getEngine().getHistory());
        });
    }

    public void SetContainer(WebView webView) {
        WebContainer.getChildren().clear();
        WebContainer.getChildren().add(webView);
    }

    public ContextMenu getTabContextMenu(Tab tab){
        ContextMenu contextMenu = new ContextMenu();

        MenuItem bookmarkItem = new MenuItem("Add this tab to bookmarks");
        bookmarkItem.setOnAction(e -> {
            AddBookmark((TabData) tab.getUserData());
        });
        contextMenu.getItems().add(bookmarkItem);

        MenuItem closeItem = new MenuItem("Close Tab");
        closeItem.setOnAction(e -> {
            tabPane.getTabs().remove(tab);
        });
        contextMenu.getItems().add(closeItem);

        return contextMenu;
    }

    public ContextMenu getBookmarkContextMenu(HBox hbox){
        ContextMenu contextMenu = new ContextMenu();

        MenuItem editItem = new MenuItem("Edit");
        editItem.setOnAction(e -> {
            Dialog<Pair<String, String>> dialog = getEditBookmarkDialog(hbox, (Bookmark) hbox.getUserData());
            Optional<Pair<String, String>> result = dialog.showAndWait();
            if (result.isPresent()) {
                Bookmark bookmark = (Bookmark) hbox.getUserData();
                bookmark.url = result.get().getKey();
                bookmark.title = result.get().getValue();
                bookmark.favicon = getFavicon(bookmark.url);
                hbox.getChildren().clear();
                hbox.getChildren().add(new ImageView(bookmark.favicon));
                hbox.getChildren().add(new Label(bookmark.title));

            }
            
        });
        contextMenu.getItems().add(editItem);

        MenuItem deleteItem = new MenuItem("Delete");
        deleteItem.setOnAction(e -> {
            BookmarkList.getChildren().remove(hbox);
        });
        contextMenu.getItems().add(deleteItem);
        return contextMenu;
    }

    public Dialog<Pair<String, String>> getEditBookmarkDialog(HBox hbox, Bookmark bookmark){
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Edit Bookmark");
        ButtonType saveButton = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(saveButton, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField titleField = new TextField(bookmark.title);
        TextField urlField = new TextField(bookmark.url);

        grid.add(new Label("Title:"), 0, 0);
        grid.add(titleField, 1, 0);
        grid.add(new Label("URL:"), 0, 1);
        grid.add(urlField, 1, 1);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == saveButton) {
                return new Pair<>(urlField.getText(), titleField.getText());
            }
            return null;
        });

        return dialog;
    }

    public void AddBookmark(TabData tabData){
        Bookmark bookmark = new Bookmark();
        bookmark.url = tabData.CurrentUrl;
        bookmark.title = tabData.webView.getEngine().getTitle();
        bookmark.favicon = tabData.favicon;
        AddBookmark(bookmark);
    }

    public void AddBookmark(Bookmark bookmark){
        HBox hbox = new HBox();
        hbox.getChildren().add(new ImageView(bookmark.favicon));
        hbox.getChildren().add(new Label(bookmark.title));
        hbox.setSpacing(3);
        hbox.setOnMouseEntered(e -> {
            hbox.setStyle("-fx-background-color: lightgray");
        });
        hbox.setOnMouseExited(e -> {
            hbox.setStyle("-fx-background-color: transparent");
        });
        hbox.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) { 
                loadUrl(bookmark.url);
            }
        });
        hbox.setUserData(bookmark);
        hbox.setOnContextMenuRequested(e -> {
            e.consume();
            getBookmarkContextMenu(hbox).show(hbox, e.getScreenX(), e.getScreenY());
        });
        
        // Add drag-and-drop functionality
        hbox.setOnDragDetected(event -> {
            Dragboard db = hbox.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString(bookmark.url);
            db.setContent(content);

            // Set the drag view to the bookmark's icon
            if (bookmark.favicon != null) {
                db.setDragView(bookmark.favicon);
            }
            event.consume();
        });

        hbox.setOnDragOver(event -> {
            if (event.getGestureSource() != hbox && event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
                if (event.getX() >= hbox.getWidth() / 2) {
                    hbox.setStyle("-fx-border-color: black; -fx-border-width: 0 2px 0 0; -fx-border-style: solid;");
                }
                else {
                    hbox.setStyle("-fx-border-color: black; -fx-border-width: 0 0 0 2px; -fx-border-style: solid;");
                }
            }
            event.consume();
        });

        hbox.setOnDragExited(event -> {
            hbox.setStyle("-fx-border-color: black; -fx-border-width: 0 0 0 0; -fx-border-style: solid;");
        });

        hbox.setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();
            boolean success = false;
            if (db.hasString()) {
                if (event.getX() >= hbox.getWidth() / 2) {
                    HBox source = (HBox) event.getGestureSource();
                    int targetIndex = BookmarkList.getChildren().indexOf(hbox);
                    BookmarkList.getChildren().remove(source);
                    if (targetIndex+1 < BookmarkList.getChildren().size()) {
                        BookmarkList.getChildren().add(targetIndex+1, source);
                    }
                    else {
                        BookmarkList.getChildren().add(source);
                    }
                    success = true;
                }
                else {
                    HBox source = (HBox) event.getGestureSource();
                    int targetIndex = BookmarkList.getChildren().indexOf(hbox);
                    BookmarkList.getChildren().remove(source);
                    BookmarkList.getChildren().add(targetIndex, source);
                    success = true;
                }
            }
            event.setDropCompleted(success);
            event.consume();
        });

        BookmarkList.getChildren().add(hbox);
    }

    public Image getFavicon(String location) {
        try {
            String faviconUrl = String.format("https://www.google.com/s2/favicons?domain_url=%s", URLEncoder.encode(location, "UTF-8"));
            Image favicon = new Image(faviconUrl, true);
            favicon.errorProperty().addListener((obs, wasError, isError) -> {
                if (isError) {
                    System.err.println("Error loading favicon: " + favicon.getException());
                }
            });
            return favicon;
        } catch (Exception e) {
            System.err.println("Error getting favicon: " + e.getMessage());
            return null;
        }
    }

    public void SaveBookmarks() {
        try {
            List<Bookmark> bookmarks = new ArrayList<>();
            for (Node node : BookmarkList.getChildren()) {
                if (node instanceof HBox) {
                    HBox hbox = (HBox) node;
                    Bookmark bookmark = (Bookmark) hbox.getUserData();
                    bookmarks.add(bookmark);
                }
            }
            String path = "data/saved/bookmarks.txt";
            File file = new File(path);
            file.getParentFile().mkdirs(); // Ensure the directory exists
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (Bookmark bookmark : bookmarks) {
                    writer.write(bookmark.url + "," + bookmark.title + "\n");
                }
            }
        } catch (IOException e) {
            System.err.println("Error saving bookmarks: " + e.getMessage());
        }
    }

    public void SaveTabs(){
        try {
            List<TabData> tabs = new ArrayList<>();
            for (Tab tab : tabPane.getTabs()) {
                tabs.add((TabData) tab.getUserData());
            }
            String path = "data/saved/tabs.txt";
            File file = new File(path);
            file.getParentFile().mkdirs(); // Ensure the directory exists
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (TabData tab : tabs) {
                    for (int i = 0; i < tab.webView.getEngine().getHistory().getEntries().size(); i++) {
                        writer.write(tab.webView.getEngine().getHistory().getEntries().get(i).getUrl());
                        if (i < tab.webView.getEngine().getHistory().getEntries().size() - 1) {
                            writer.write(",");
                        }
                    }
                    writer.write("\n");
                }
                writer.write("SelectedTab:" + tabPane.getSelectionModel().getSelectedIndex());
            }
        }
        catch (IOException e) {
            System.err.println("Error saving tabs: " + e.getMessage());
        }
    }

    public void LoadBookmarks(){
        File file = new File("data/saved/bookmarks.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Bookmark bookmark = new Bookmark();
                bookmark.url = parts[0];
                bookmark.title = parts[1];
                bookmark.favicon = getFavicon(bookmark.url);
                AddBookmark(bookmark);
            }
        }
        catch (IOException e) {
            //No bookmarks saved
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Error closing reader: " + e.getMessage());
                }
            }
        }
    }

    public void LoadTabs(){
        File file = new File("data/saved/tabs.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("SelectedTab:")) {
                    int index = Integer.parseInt(line.split(":")[1]);
                    tabPane.getSelectionModel().select(index);
                }
                else {
                    List<String> urls = new ArrayList<>(Arrays.asList(line.split(",")));
                    AddTab(null);
                    TabData tabData = (TabData) tabPane.getSelectionModel().getSelectedItem().getUserData();
                    WebView webView = tabData.webView;
                    for (String url : urls) {
                        webView.getEngine().load(url);
                    }
                }
            }
        }
        catch (IOException e) {
            //No tabs saved
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Error closing reader: " + e.getMessage());
                }
            }
        }
    }
}

class TabData {
    public String CurrentUrl;
    public WebView webView;
    public Image favicon;

    public TabData(String url, WebView webView) {
        this.CurrentUrl = url;
        this.webView = webView;
    }

    @Override
    public String toString() {
        return "TabData{" + "CurrentUrl=" + CurrentUrl + '}';
    }
}

class Bookmark {
    public String url;
    public String title;
    public Image favicon;
}