package ASCII_art_user_interfaces.Factories;

import ASCII_art_user_interfaces.*;
import ASCII_art_user_interfaces.A.*;

/* Palauttaa A tyylin */
public class AFactory extends UIFactory {

    @Override
    public ButtonBox createButton(String text) {
        return new ButtonA(text);
    }

    @Override
    public TextFieldBox createTextField(String text) {
        return new TextFieldA(text);
    }

    @Override
    public CheckBox createCheckBox(String text) {
        return new CheckBoxA(text);
    }
}