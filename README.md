# 💳 Credit Card Generator & Validator

Bu proje, Java ile yazılmış bir **kredi kartı üretici ve doğrulayıcı uygulamasıdır**. Kullanıcıya rastgele kart numarası, son kullanma tarihi ve CVV bilgileri üretir. Üretilen kart numarası, **Luhn algoritması** ile geçerlilik kontrolüne göre oluşturulur.

---

## ✨ Özellikler

- Rastgele **Luhn algoritmasına uygun** kart numarası üretir.
- Son kullanma tarihi (MM/YY) ve CVV (3 haneli) oluşturur.
- Kart bilgilerini `.txt` dosyasına kaydetme seçeneği sunar.
- Kullanıcıdan alınan kart bilgilerini doğrulayabilir:
  - Luhn algoritması geçerliği
  - CVV geçerliliği
  - SKT formatı kontrolü

---

## 🧠 Kullanılan Teknolojiler

- Java 17+
- Maven (Opsiyonel)
- Dosya işlemleri (Java IO)
- Luhn algoritması
- Scanner ile kullanıcı etkileşimi

---

## 🛠️ Projeyi Çalıştırmak

### 1. Bin listesi oluştur
Proje dizininde `bins.txt` adında bir dosya oluştur ve içerisine örnek BIN numaraları ekle:
```45717360 41472035 53547790```


### 2. Kodları derle ve çalıştır
```bash
javac CreditCardGenerator.java CreditCardValidator.java
java org.mettmettfield.CreditCardGenerator
```
## 📂 Proje Yapısı
src/
└── main/
    └── java/
        └── org/
            └── mettmettfield/
                ├── CreditCardGenerator.java
                └── CreditCardValidator.java
bins.txt
kartBilgiler.txt

## ✅ Örnek Çıktı
Aşağıdaki bilgilere sahip sanal kartınız oluşturuldu!
Kart Numarası: 4571 7360 1234 5670
Son Kullanma Tarihi: 08/29
CVV: 123
Kart bilgilerinizin bir txt dosyasına kayıt edilmesini ister misiniz? E ya da H olarak yanıtlayınız.



