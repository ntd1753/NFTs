package com.example.forntend;//package com.example.forntend;

import com.example.backend.JsonRead.NFTJsonReader;
import com.example.backend.Model.NftFloor.NFT;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class NftFloorController implements Initializable {
    @FXML
    private Button Exit;

//    @FXML
//    private Button Exit1;

    @FXML
    private Label Menu;

    @FXML
    private Label MenuBack;

    @FXML
    private Pane slider;
    @FXML
    private TableView<NFT> view;
    @FXML
    private TableColumn<NFT, Double> floorPricecol;

    @FXML
    private TableColumn<NFT, String> idcol;

    @FXML
    private TableColumn<NFT, String> namecol;

    @FXML
    private TableColumn<NFT, Integer> numOwnerscol;
    @FXML
    private TableColumn<NFT, String> urlcol;
    @FXML
    private TableColumn<NFT, Integer> totalSupplycol;
    @FXML
    private TableColumn<NFT, Double> volumecol;
    @FXML
    private TableColumn<NFT, Double> volumeChangecol;
    private Stack<Scene> sceneStack = new Stack<>();
    NFTJsonReader op = new NFTJsonReader();
    //List<NFT> nftList = new ArrayList<>();
    //ObservableList<NFT> list = FXCollections.observableArrayList();

    List<NFT> nftList = op.readNFTJson("data//rarible1D.json");
    ObservableList<NFT> list = FXCollections.observableList(nftList);


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        Exit.setOnMouseClicked(event -> {
            System.exit(0);
        });




        slider.setTranslateX(-176);
        Menu.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(0);
            slide.play();

            slider.setTranslateX(-176);

            slide.setOnFinished((ActionEvent e)-> {
                Menu.setVisible(false);
                MenuBack.setVisible(true);
            });
        });

        MenuBack.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(-176);
            slide.play();

            slider.setTranslateX(0);

            slide.setOnFinished((ActionEvent e)-> {
                Menu.setVisible(true);
                MenuBack.setVisible(false);
            });
        });
        //initializeTableView(list);
        //SearchbyName("Az");

    }
    private Stage stage;
    private Scene scene;

    public void switchToHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToBlog(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("blog.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToTwitter(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Twitter.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToNFT(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("NFT-page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void initializeTableView(ObservableList<NFT> list) {
        namecol.setCellValueFactory(new PropertyValueFactory<NFT, String>("name"));
        idcol.setCellValueFactory(new PropertyValueFactory<NFT, String>("id"));
        //urlcol.setCellValueFactory(new PropertyValueFactory<NFT, String>("url"));
        numOwnerscol.setCellValueFactory(new PropertyValueFactory<NFT, Integer>("numOwners"));
        totalSupplycol.setCellValueFactory(new PropertyValueFactory<NFT, Integer>("totalSupply"));
        volumecol.setCellValueFactory(new PropertyValueFactory<NFT, Double>("volume"));
        floorPricecol.setCellValueFactory(new PropertyValueFactory<NFT, Double>("floorPrice"));
        //numOfSalescol.setCellValueFactory(new PropertyValueFactory<NFT, Integer>("numOfSales"));
        volumeChangecol.setCellValueFactory(new PropertyValueFactory<NFT, Double>("volumeChange"));
        view.setItems(list);
    }
    public void SearchbyName(String s){
        ObservableList<NFT> sName = FXCollections.observableArrayList();
        for (NFT nft: list){
            if (nft.getName().toLowerCase().contains(s.toLowerCase())) {
                sName.add(nft);
                System.out.println(nft);
            }
        }
        initializeTableView(sName);
    }
}

