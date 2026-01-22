package ASCII_art_user_interfaces;

public class Main {
    public static void main(String[] args) {
        UIFactory factory = new ASCII_art_user_interfaces.Factories.BFactory(); // Valitaan käyttöliittymätyyppi

        // Luo käyttöliittymäkomponentit
        ButtonBox buttonBox = factory.createButton("Click Me"); 
        TextFieldBox textFieldBox = factory.createTextField("Enter Text");
        CheckBox checkBox = factory.createCheckBox("Accept Terms");

        // display() metodit näyttävät käyttöliittymäkomponentit
        buttonBox.display();
        textFieldBox.display();
        checkBox.display();
    }
}