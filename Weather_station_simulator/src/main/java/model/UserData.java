
package model;

public class UserData extends Observable {

    private boolean isSelected;
    private int temp;

    public void setTemperature(int temp) {
        this.temp = temp;
        notifyObservers();
    }

    public int temperature() {
        return temp;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
        notifyObservers();
    }

    public boolean isSelected() {
        return isSelected;
    }
}
