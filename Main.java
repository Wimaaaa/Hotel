public class Main {
    public static void main(String[] args) {
        try {
            Hotel hotel = new Hotel(25);
            System.out.println(hotel);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}