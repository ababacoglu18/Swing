import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;





    public class Baglanti {
        public static void main(String[] args) {
            // Veritabanı bağlantısı için gerekli bilgiler              //CHATGPT YAZDI
            String url = "jdbc:mysql://localhost:3306/demo";        //W3SCHOOLS
            String username = "root";
            String password = "";

            // Veritabanına bağlanmayı dene
            try (Connection con = DriverManager.getConnection(url, username, password)) {
                System.out.println("Bağlantı başarılı!");
            } catch (SQLException e) {
                System.out.println("Bağlantı başarısız: " + e.getMessage());
            }
        }
    }



