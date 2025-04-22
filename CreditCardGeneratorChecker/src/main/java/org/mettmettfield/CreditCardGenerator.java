package org.mettmettfield;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CreditCardGenerator {
    public static final File bins = new File("C:\\Users\\Mete\\Desktop\\YAZILIMSAL\\PROJELER\\CreditCardGeneratorChecker\\src\\main\\java\\org\\mettmettfield\\bins.txt");

    public void generateCard() {
        ArrayList<String> binList = new ArrayList<>();
        try {
            Scanner reader = new Scanner(bins);
            while (reader.hasNextLine()) {
                String[] kartFull = reader.nextLine().split(",");
                binList.add(kartFull[0]);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Random random = new Random();
        String secilenBin = binList.get(random.nextInt(binList.size()));

        // Kart numarasının ilk 15 hanesini oluştur
        long number = Math.abs(random.nextLong()) % 1_000_000_000L;
        String kartNoIlk15 = secilenBin + String.format("%09d", random.nextInt(1_000_000_000));

        // Luhn algoritmasıyla son haneyi hesapla
        int checkDigit = luhnCheckDigit(kartNoIlk15);

        // 16 haneli tam kart numarasını oluştur
        String kartNoTam = kartNoIlk15 + checkDigit;

        // Kart numarasını gruplar halinde biçimlendir (XXXX XXXX XXXX XXXX)
        String kartNoFormatted = kartNoTam.replaceAll(".{4}(?!$)", "$0 ");

        int cvv = random.nextInt(100, 1000);
        String skt = String.format("%02d", random.nextInt(1, 13)) + "/" + random.nextInt(25, 36);

        // Bilgileri ekrana yazdır
        System.out.println("Aşağıdaki bilgilere sahip sanal kartınız oluşturuldu!");
        System.out.println("Kart Numarası: " + kartNoFormatted);
        System.out.println("Son Kullanma Tarihi: " + skt);
        System.out.println("CVV: " + cvv);
        System.out.println("Kart bilgilerinizin bir txt dosyasına kayıt edilmesini ister misiniz? E ya da H olarak yanıtlayınız.");

        Scanner klavye = new Scanner(System.in);
        String giris = klavye.next();

        try {
            FileWriter writer = new FileWriter("kartBilgiler.txt", true);
            if (giris.equalsIgnoreCase("E")) {
                writer.write("\nKart Numarası: " + kartNoFormatted + "\nSon Kullanma Tarihi: " + skt + "\nCVV: " + cvv + "\n-----------------------");
                System.out.println("Kart bilgileri başarılı bir şekilde kayıt edildi!");
            } else if (giris.equalsIgnoreCase("H")) {
                System.out.println("Hayır seçeneğini seçtiniz. Kart bilgilerinizin kayıp olmaması için ayrıca kayıt etmenizi öneririz.");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Kart bilgileri kayıt edilirken bir hata oluştu: " + e.getMessage());
        }
    }

    public int luhnCheckDigit(String numberWithoutCheckDigit) {
        int sum = 0;
        boolean alternate = true;

        for (int i = numberWithoutCheckDigit.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(numberWithoutCheckDigit.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n -= 9;
                }
            }
            sum += n;
            alternate = !alternate;
        }

        int mod = sum % 10;
        return (mod == 0) ? 0 : 10 - mod;
    }
}
