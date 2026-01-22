package ASCII_art_user_interfaces.B;

import ASCII_art_user_interfaces.*;
import ASCII_art_user_interfaces.Factories.*;

public class CheckBoxB extends CheckBox {
    public CheckBoxB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("<[ ]>");
    }
}