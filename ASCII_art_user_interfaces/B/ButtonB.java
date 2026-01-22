package ASCII_art_user_interfaces.B;

import ASCII_art_user_interfaces.*;
import ASCII_art_user_interfaces.Factories.*;

public class ButtonB extends ButtonBox {
    public ButtonB(String text) {
        super(text);
    }
    
    @Override
    public void display() {
        System.out.println("Ⓑ");
    }
}