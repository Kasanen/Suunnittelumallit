package ASCII_art_user_interfaces;

/* Yleinen alusta napille */
public abstract class ButtonBox {
    protected String text; // Tallentaa napin tekstin

    public ButtonBox(String text) {
        this.text = text; // Asetetaan teksti
    }

    public abstract void display();
}