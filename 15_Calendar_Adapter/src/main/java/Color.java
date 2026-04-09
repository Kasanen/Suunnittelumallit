import java.util.Calendar;

public class Color implements NewDateInterface {
    private final Calendar date;

    public Color() {
        this.date = Calendar.getInstance();
    }

    public Color(Calendar date) {
        this.date = date;
    }

    @Override
    public void setDay(int day) {
        date.set(Calendar.DAY_OF_MONTH, day);
    }

    @Override
    public void setMonth(int month) {
        date.set(Calendar.MONTH, month - 1);
    }

    @Override
    public void setYear(int year) {
        date.set(Calendar.YEAR, year);
    }

    @Override
    public int getDay() {
        return date.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public int getMonth() {
        return date.get(Calendar.MONTH);
    }

    @Override
    public int getYear() {
        return date.get(Calendar.YEAR);
    }

    @Override
    public void advanceDays(int days) {
        date.add(Calendar.DAY_OF_MONTH, days);
    }

}
