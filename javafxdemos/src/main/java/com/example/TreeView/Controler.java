package com.example.TreeView;

import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import java.net.URL;

public class Controler implements Initializable {
    @FXML
    private TreeView<String> treeView;
    
    public void initialize(URL url, ResourceBundle rb) {
        TreeItem<String> root = new TreeItem<>("Life");

        TreeItem<String> animals = new TreeItem<>("Animals");
            TreeItem<String> invertebrates = new TreeItem<>("Invertebrates");
                TreeItem<String> arthropods = new TreeItem<>("Arthropods");
                TreeItem<String> mollusca = new TreeItem<>("Molluscs");
                TreeItem<String> annelida = new TreeItem<>("Annelids");
                TreeItem<String> cnidaria = new TreeItem<>("Cnidarians");
                TreeItem<String> echinodermata = new TreeItem<>("Echinoderms");
                TreeItem<String> porifera = new TreeItem<>("Sponges");
                TreeItem<String> platyhelminthes = new TreeItem<>("Flatworms");
                TreeItem<String> nematoda = new TreeItem<>("Roundworms");
                invertebrates.getChildren().addAll(arthropods, mollusca, annelida, cnidaria, echinodermata, porifera, platyhelminthes, nematoda);
            TreeItem<String> vertebrates = new TreeItem<>("Vertebrates");
                TreeItem<String> fishes = new TreeItem<>("Fishes");
                TreeItem<String> amphibians = new TreeItem<>("Amphibians");
                TreeItem<String> reptiles = new TreeItem<>("Reptiles");
                TreeItem<String> birds = new TreeItem<>("Birds");
                TreeItem<String> mammals = new TreeItem<>("Mammals");
                vertebrates.getChildren().addAll(fishes, amphibians, reptiles, birds, mammals);
            animals.getChildren().addAll(invertebrates, vertebrates);
        root.getChildren().add(animals);
        TreeItem<String> plants = new TreeItem<>("Plants");
            TreeItem<String> Bryophytes = new TreeItem<>("Non-Vascular Plants (Bryophytes)");
                TreeItem<String> Mosses = new TreeItem<>("Mosses");
                TreeItem<String> liverworts = new TreeItem<>("Liverworts");
                TreeItem<String> hornworts = new TreeItem<>("Hornworts");
                Bryophytes.getChildren().addAll(Mosses, liverworts, hornworts);
            TreeItem<String> Seedless = new TreeItem<>("Seedless Vascular Plants");
                TreeItem<String> Ferns = new TreeItem<>("Ferns");
                TreeItem<String> clubmosses = new TreeItem<>("Clubmosses");
                TreeItem<String> horsetails = new TreeItem<>("Horsetails");
                Seedless.getChildren().addAll(Ferns, clubmosses, horsetails);
            TreeItem<String> SeedPlants= new TreeItem<>("Seed Plants (Spermatophytes)");
                TreeItem<String> Gymnosperms = new TreeItem<>("Gymnosperms");
                    TreeItem<String> Conifers = new TreeItem<>("Conifers");
                    TreeItem<String> cycads = new TreeItem<>("Cycads");
                    TreeItem<String> ginkgo = new TreeItem<>("Ginkgo");
                    TreeItem<String> gnetophytes = new TreeItem<>("Gnetophytes");
                    Gymnosperms.getChildren().addAll(Conifers, cycads, ginkgo, gnetophytes);
                TreeItem<String> Angiosperms = new TreeItem<>("Angiosperms");
                    TreeItem<String> Monocots = new TreeItem<>("Monocots");
                    TreeItem<String> dicots = new TreeItem<>("Dicots");
                    TreeItem<String> basalangiosperms = new TreeItem<>("Basal angiosperms");
                    TreeItem<String> eudicots = new TreeItem<>("Eudicots");
                    Angiosperms.getChildren().addAll(Monocots, dicots, basalangiosperms, eudicots);
                SeedPlants.getChildren().addAll(Gymnosperms, Angiosperms);
            plants.getChildren().addAll(Bryophytes, Seedless, SeedPlants);
        root.getChildren().add(plants);
        TreeItem<String> fungi = new TreeItem<>("Fungi");
            TreeItem<String> Chytridiomycota = new TreeItem<>("Chytridiomycota");
            TreeItem<String> Zygomycota = new TreeItem<>("Zygomycota");
            TreeItem<String> Glomeromycota = new TreeItem<>("Glomeromycota");
            TreeItem<String> Ascomycota = new TreeItem<>("Ascomycota");
            TreeItem<String> Basidiomycota = new TreeItem<>("Basidiomycota");
            TreeItem<String> Deuteromycota  = new TreeItem<>("Deuteromycota ");
            TreeItem<String> Lichens = new TreeItem<>("Lichens");
        fungi.getChildren().addAll(Chytridiomycota, Zygomycota, Glomeromycota, Ascomycota, Basidiomycota, Deuteromycota, Lichens);
        root.getChildren().add(fungi);
        TreeItem<String> protista = new TreeItem<>("Protista");
            TreeItem<String> Protozoa = new TreeItem<>("Protozoa");
            TreeItem<String> Algae = new TreeItem<>("Algae");
            TreeItem<String> Fungus_like_Protists = new TreeItem<>("Fungus-like Protists");
            protista.getChildren().addAll(Protozoa, Algae, Fungus_like_Protists);
        root.getChildren().add(protista);
        TreeItem<String> bacteria = new TreeItem<>("Bacteria");
            TreeItem<String> Gram_Positive_Bacteria = new TreeItem<>("Gram-Positive Bacteria");
            TreeItem<String> Gram_Negative_Bacteria = new TreeItem<>("Gram-Negative Bacteria");
        bacteria.getChildren().addAll(Gram_Positive_Bacteria, Gram_Negative_Bacteria);
        root.getChildren().add(bacteria);
        TreeItem<String> archaea = new TreeItem<>("Archaea");
            TreeItem<String> Euryarchaeota = new TreeItem<>("Euryarchaeota");
            TreeItem<String> Lachnarchaeota = new TreeItem<>("Lachnarchaeota");
            TreeItem<String> Metazoa = new TreeItem<>("Metazoa");
            archaea.getChildren().addAll(Euryarchaeota, Lachnarchaeota, Metazoa);
        root.getChildren().add(archaea);

        treeView.setRoot(root);

    }
    
    
}

//Biota.Cytota.Arkaryota.Eukaryomorpha.Eukarya.Neokaryotes.Opimoda.Amorphea.Obazoa.Opisthokonta.	
//Animalia.Myriazoa.Eumetazoa.ParaHoxozoa.Bilateria.Nephrozoa.Deuterostomia.Chordata.Olfactores.
//Vertebrata.Cephalaspidomorphi.Gnathostomata.Eugnathostomata.Euteleostomi.Sarcopterygii.Rhipidistia.
//Tetrapodomorpha.Eotetrapodiformes.Elpistostegida.Stegocephalia.Tetrapoda.Reptiliomorpha.Amniota.
//Synapsida.Therapsida.Mammalia.Theria.Placentalia.Boreoeutheria.Euarchontoglires.Euarchonta.
//Primatomorpha.Primates.Haplorrhini.Simiiformes.Hominoidea.Euhominoidea.Hominidae.Homininae.
//Hominini.Hominis.Homo.Homo_sapiens.

