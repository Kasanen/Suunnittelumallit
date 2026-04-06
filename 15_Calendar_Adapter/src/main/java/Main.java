public class Main {
    public static void main(String[] args) {
        NewDateInterface adapter = new CalendarToNewDateAdapter();

        adapter.setDay(2);
        adapter.setMonth(4);
        adapter.setYear(2007);

        System.out.println(adapter.getDay() + ":" + adapter.getMonth() + ":" + adapter.getYear());

        adapter.advanceDays(2);

        System.out.println(adapter.getDay() + ":" + adapter.getMonth() + ":" +
        adapter.getYear());

        adapter.advanceDays(50);

        System.out.println(adapter.getDay() + ":" + adapter.getMonth() + ":" +
        adapter.getYear());

    }
}
