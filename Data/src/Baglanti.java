import java.sql.*;


public class Baglanti {


        private Statement statement  = null; //SQL SORGUSU ÇALIŞTIRMAK İÇİN

    // Veritabanı bağlantısı için gerekli bilgiler              //CHATGPT YAZDI
    String url = "jdbc:mysql://localhost:3306/demo";        //W3SCHOOLS
    String username = "root";
    String password = "";
    Connection con;

    {
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void CalisanEkle(){

        try {
            statement = con.createStatement();
            String ad  = "Semih";
            String soyad = "Akbaş";
            String email = "semiaktas@gmail.com";
            String sorgu = "Insert Into calisanlar (ad,soyad,email) VALUES(" + "'" + ad + "'," + "'" + soyad + "'," + "'" + email + "')";

            statement.executeUpdate(sorgu);

            //INSERT INTO calisanlar (ad,soyad,email) VALUES('Yusuf','Çetinkaya','mucahit@gmail.com')

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void CalisanlariGetir(){
                    String sorgu = "Select * From calisanlar";//where id > 2";  //* tüm özellikleri çeker.

                try {
                    statement = con.createStatement();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    ResultSet rs =  statement.executeQuery(sorgu);
                    System.out.println("ok");
                    while (rs.next()){
                        int id = rs.getInt("id");
                        String ad = rs.getString("ad");
                        String soyad = rs.getString("soyad");
                        String email = rs.getString("email");
                        ad.trim().equals(" ");
                        System.out.println("id: "+ id + "/ Ad: " + ad + "/ Soyad "+ soyad+ "/ email "+ email);

                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            public void CalisanGuncelle(){
                try {
                    con.createStatement();
                    String sorgu = "Update calisanlar Set email = 'example@gmail.com' where id > 5";

                    statement.executeUpdate(sorgu);

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            public void CalisanSil(){
                try {
                 statement=    con.createStatement();
                    String sorgu = "Delete from calisanlar where id > 5";
                   statement.executeUpdate(sorgu);


                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }

        public static void main(String[] args) {
            // Veritabanı bağlantısı için gerekli bilgiler              //CHATGPT YAZDI
            String url = "jdbc:mysql://localhost:3306/demo" + "?useUnicode=true&characterEncoding=utf8";
                                                                        //W3SCHOOLS
            String username = "root";                               //SQL Sorguları var
            String password = "";                                   //where; if;

            // Veritabanına bağlanmayı dene
            try (Connection con = DriverManager.getConnection(url, username, password)) {
                System.out.println("Bağlantı başarılı!");

            } catch (SQLException e) {
                System.out.println("Bağlantı başarısız: " + e.getMessage());
            }
            Baglanti baglanti = new Baglanti();
            baglanti.CalisanlariGetir();
           // baglanti.CalisanGuncelle();
            baglanti.CalisanSil();
            baglanti.CalisanlariGetir();

        }
    }


