package ASCII_art_user_interfaces;

public abstract class TextFieldBox {
    protected String text;

    public TextFieldBox(String text) {
        this.text = text;
    }

    public abstract void display();
}