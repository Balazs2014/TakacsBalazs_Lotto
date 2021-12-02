package com.example.lotto.lotto;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HelloController {
    @FXML
    private Button btnSorsol;
    @FXML
    private Label lblSorsolas;
    @FXML
    private Label lblSorsoltSzamok;
    private List<Integer> sorsoltSzamok = new ArrayList();
    private boolean otSzamSorsolva = false;

    public void sorsolasRendezes() {
        if (!otSzamSorsolva) {
            szamSorsolas();
        } else {
            rendezes();
        }
    }

    public void szamSorsolas() {
        double randomSzam = Math.random() * 50 + 1;
        int sorsoltSzam = (int)randomSzam;
        if (!sorsoltSzamok.contains(sorsoltSzam) && sorsoltSzamok.size() != 5) {
            sorsoltSzamok.add(sorsoltSzam);
            lblSorsolas.setText(sorsoltSzam + "");
            String s = "";
            for (int szam : sorsoltSzamok) {
                s += szam + " ";
            }
            lblSorsoltSzamok.setText(s);
        }

        if (sorsoltSzamok.size() == 5) {
            otSzamSorsolva = true;
            btnSorsol.setText("Rendez");
        }
    }

    public void rendezes() {
        btnSorsol.setText("Start");
        Collections.sort(sorsoltSzamok);
        String s = "";
        for (int szam: sorsoltSzamok) {
            s += szam + " ";
        }
        lblSorsoltSzamok.setText(s);
    }
}