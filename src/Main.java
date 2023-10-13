public class Main {
    public static void main(String[] args) {
        try {
            Hotel hotel = new Hotel(10);
            System.out.println(hotel);
            System.out.println("Quantidade total de apartamentos: "+hotel.qtdTotal);
            System.out.println("Capacidade: "+hotel.capacidade());
            hotel.interdite(1009); //apto com capacidade 2
            hotel.ocupe(1010); //apto com capacidade 2
            System.out.println("Capacidade: "+hotel.capacidade()); //capacidade deve diminuir 4
            hotel.desocupe(1010);
            System.out.println("Capacidade: "+hotel.capacidade()); //capacidade deve subir 2
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}