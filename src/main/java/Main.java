public class Main {
    public static void main(String[] args) {
        Jdbc.query("SELECT * FROM developers WHERE name = 'Alexander' OR name = 'Igor' AND salary > 2500 ");
    }
}
