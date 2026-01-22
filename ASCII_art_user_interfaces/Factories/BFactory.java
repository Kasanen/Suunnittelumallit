package ASCII_art_user_interfaces.Factories;

import ASCII_art_user_interfaces.*;
import ASCII_art_user_interfaces.B.*;

public class BFactory extends UIFactory {

    @Override
    public ButtonBox createButton(String text) {
        return new ButtonB(text);
    }

    @Override
    public TextFieldBox createTextField(String text) {
        return new TextFieldB(text);
    }

    @Override
    public CheckBox createCheckBox(String text) {
        return new CheckBoxB(text);
    }
}