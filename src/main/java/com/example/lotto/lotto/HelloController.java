package com.example.lotto.lotto;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class HelloController {
    @FXML
    private Button btnSorsol;
    @FXML
    private Label lblSorsolas;
    @FXML
    private Label lblSorsoltSzamok;
    private List<Integer> sorsoltSzamok = new ArrayList();
    private boolean otSzamSorsolva = false;

    public void sorsolasRendezes() throws InterruptedException {
        if (!otSzamSorsolva) {
            szamSorsolas();
        } else {
            rendezes();
        }
    }

    public void szamSorsolas() throws InterruptedException {
        boolean logikai = true;
        while (logikai && sorsoltSzamok.size() != 5) {
            double randomSzam = Math.random() * 90 + 1;
            int sorsoltSzam = (int) randomSzam;
            if (!sorsoltSzamok.contains(sorsoltSzam)) {
                TimeUnit.SECONDS.sleep(2);
                sorsoltSzamok.add(sorsoltSzam);
                lblSorsolas.setText(sorsoltSzam + "");
                logikai = false;
            }
        }
        String s = "";
        for (int szam : sorsoltSzamok) {
            s += szam + " ";
        lblSorsoltSzamok.setText(s);
        }

        if (sorsoltSzamok.size() == 5) {
            otSzamSorsolva = true;
            btnSorsol.setText("Rendez");
        }
    }

    public void rendezes() {
        btnSorsol.setText("Sorsol");
        Collections.sort(sorsoltSzamok);
        String s = "";
        for (int szam: sorsoltSzamok) {
            s += szam + " ";
        }
        lblSorsoltSzamok.setText(s);

        sorsoltSzamok.clear();
        otSzamSorsolva = false;
    }
}