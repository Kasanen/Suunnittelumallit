package ASCII_art_user_interfaces.A;

import ASCII_art_user_interfaces.*;
import ASCII_art_user_interfaces.Factories.*;

/* A tyylitetty nappi */
public class ButtonA extends ButtonBox {
    public ButtonA(String text) {
        super(text); // Siirtää tekstin -> ButtonBox
    }

    /* Ottaa käyttöön abstrakti metodin ButtonBox luokasta */
    @Override
    public void display() {
        System.out.println("Ⓐ"); // Asetetaan teksti
    }
}