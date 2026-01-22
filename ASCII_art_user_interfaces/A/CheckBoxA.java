package ASCII_art_user_interfaces.A;

import ASCII_art_user_interfaces.*;
import ASCII_art_user_interfaces.Factories.*;

public class CheckBoxA extends CheckBox {
    public CheckBoxA(String text) {
        super(text);
    }
    
    @Override
    public void display() {
        System.out.println("[ ]");
    }
}