package ASCII_art_user_interfaces;

public abstract class CheckBox {
    protected String text;

    public CheckBox(String text) {
        this.text = text;
    }

    public abstract void display();
}