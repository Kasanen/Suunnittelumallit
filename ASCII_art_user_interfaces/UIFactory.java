package ASCII_art_user_interfaces;

public abstract class UIFactory {
    // Luo komponentit
    public abstract ButtonBox createButton(String text);
    public abstract TextFieldBox createTextField(String text);
    public abstract CheckBox createCheckBox(String text);
}
