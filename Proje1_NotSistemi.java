/**
 * Ad Soyad: [HALİD hacbekkur]
 * Öğrenci No: [250541608]
 * Proje: [ortalama hesabı]
 * Tarih: []
 */









import java.util.Scanner;

public class OgrenciOrt {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("vize notunuzu giriniz:");
        int vize = sc.nextInt();
        System.out.println("final notunuzu giriniz:");
        int finalNot = sc.nextInt();
        System.out.println("ödev notunuzu giriniz:");
        int odev = sc.nextInt();
        System.out.println(" ==== NOTLARINIZ ====");
        System.out.println("_______________________________");
        System.out.println("vize notunuz:" + vize);
        System.out.println("final notunuz:" + finalNot);
        System.out.println("ödev notunu :" + odev);
        System.out.println("_______________________________");
        System.out.println("===ÖĞRECİ RAPORU===");
        System.out.println("_______________________________");
        double ortalama = vize * 0.3 + finalNot * 0.4 + odev * 0.3;
        System.out.println("ortalamanız: " + ogrenciOrt(vize, finalNot, odev));

        System.out.print("Geçme durumu: ");
        if (gecmeDurumu(ortalama) == true) {
            System.out.println("geçtiniz");
        } else {
            System.out.println("Geçmediniz");
        }
        System.out.print("Belge durumu: ");
        if (onurBelgesi(ortalama, vize, finalNot, odev) == true) {
            System.out.println("onur belgesi");

        } else {
            System.out.println("belgeniz bulunmamaktadır");
            System.out.print("bütünleme: ");
            if (but(ortalama)==true){
                System.out.println("VAR");
            }else {
                System.out.println("YOK");
            }
        }
    }


    public static double ogrenciOrt(int vize, int finalNot, int odev) {
        double ortalama = vize * 0.3 + finalNot * 0.4 + odev * 0.3;
        return ortalama;
    }

    public static boolean onurBelgesi(double ortalama, int vize, int odev, int finalNot) {
        if (ortalama >= 85 && vize >= 70 && finalNot >= 70 && odev >= 70) {
            return true;
        } else {
            return false;
        }
    }


    public static boolean gecmeDurumu(double ortalama) {
        if (ortalama >= 50) {
            return true;
        } else {
            return false;
        }
    }

    public static String harfNotu(double ortalama) {
        String not;
        if (ortalama >= 90) {
            not = "AA";
        } else if (ortalama >= 85  ) {
            not = "AB";


        } else if (ortalama >= 80 ) {
            not = "BB";

        } else if (ortalama >= 75 ) {

            not = "BC";
        } else if (ortalama >= 70) {
            not = "CC";

        } else if (ortalama >= 60 ) {
            not = "CD";

        } else if (ortalama >= 50 ) {
            not = "DD";

        } else {
            not = "FF";

        }
        return not;
    }
    public static boolean but(double ortalama){
        if (ortalama<50){
            return  true;
        }else {
            return false;
        }


    }

}
