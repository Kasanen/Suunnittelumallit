package ASCII_art_user_interfaces.A;

import ASCII_art_user_interfaces.*;
import ASCII_art_user_interfaces.Factories.*;

public class TextFieldA extends TextFieldBox {
    public TextFieldA(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("T̲e̲x̲t̲f̲i̲e̲l̲d̲");
    }
}