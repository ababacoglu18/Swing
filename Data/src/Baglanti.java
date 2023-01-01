import java.sql.*;
import java.util.Scanner;


public class Baglanti {


        private Statement statement  = null; //SQL SORGUSU ÇALIŞTIRMAK İÇİN

    // Veritabanı bağlantısı için gerekli bilgiler              //CHATGPT YAZDI
    String url = "jdbc:mysql://localhost:3306/demo";        //W3SCHOOLS
    String username = "root";
    String password = "";
    Connection con;
    private PreparedStatement preparedStatement = null;

    public void preparedCalisanlariGetir(int id){
        String sorgu = "Select * From calisanlar where id = ?";
        try {
            preparedStatement  = con.prepareStatement(sorgu);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            preparedStatement.setInt(1, id);  //? yerine getirilecek deger

           ResultSet rs =  preparedStatement.executeQuery(); // Prepared statement detaylı araştırma
            while (rs.next()){
               String ad  = rs.getString("ad");
               String soyad  = rs.getString("soyad");
               String email  = rs.getString("email");
                System.out.println(ad + " " + soyad + " " + email);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


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
            //Yazması çok karışık. prepared ile yaz.


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

            public void RollbackAndCommit(){

                try {
                    con.setAutoCommit(false);           //kontrol bizde
                    String sorgu1 = "Delete from calisanlar where id = 3";
                    String sorgu2 = "Update calisanlar set email = 'ababacoglu18@outlook.com' where id = 1";


                    Statement statement = con.createStatement();
                    statement.executeUpdate(sorgu1);
                    statement.executeUpdate(sorgu2);
                Scanner scanner = new Scanner(System.in);
                    System.out.println("İşlemler kaydedilsin mi yes/no?");
                    String cevap = scanner.nextLine();

                    if (cevap.equals("yes")){
                        con.commit();
                        CalisanlariGetir();
                        System.out.println("Veritabanı Güncellendi");
                    }else {
                        con.rollback();
                        System.out.println("Verilere Rollback Edildi.");
                    }


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
           // baglanti.CalisanlariGetir();
           // baglanti.CalisanGuncelle();
            //baglanti.CalisanSil();
           // baglanti.preparedCalisanlariGetir();   Calismiyor.
        //    baglanti.CalisanlariGetir();
        //    baglanti.preparedCalisanlariGetir(3);

            baglanti.CalisanlariGetir();
            baglanti.RollbackAndCommit();

                                                        //Not: Sql de çalışan silersen saymaya kaldığı yerden devam ediyor. Silinen dosyayı kabul etmiyor.

        }
    }



