# 📌 FaturaPay - Fatura ve Abonelik Yönetim Uygulaması 🧾💳

FaturaPay, kullanıcıların faturalarını ve aboneliklerini kolayca yönetmelerine yardımcı olan modern bir finans takip uygulamasıdır. **Kotlin & Jetpack Compose** kullanılarak geliştirilmiş olup **MVVM mimarisi** ile modüler ve ölçeklenebilir bir yapı sunar.

---

## 🚀 Özellikler

- **📋 Fatura Takibi**: Kullanıcılar faturalarını ekleyebilir, ödenmiş veya ödenmemiş durumlarını görüntüleyebilir.
- **🔔 Bildirimler**: Ödeme tarihleri için hatırlatıcı bildirimler gönderilir.
- **📅 Abonelik Yönetimi**: Tüm aboneliklerinizi takip edin ve yenileme tarihlerini kaçırmayın.
- **🎨 Modern UI/UX**: Jetpack Compose ile tasarlanmış şık ve kullanıcı dostu arayüz.
- **🔐 Kimlik Doğrulama**: Kullanıcı giriş ve kayıt işlemleri için güvenli Auth sistemi.
- **📊 Özet Görünüm**: Dashboard ekranında finansal durumunuzu hızlıca gözden geçirin.

---

## 🛠 Kullanılan Teknolojiler

| Teknoloji | Açıklama |
|-----------|---------|
| **Kotlin** | Android uygulama geliştirme için ana programlama dili |
| **Jetpack Compose** | Modern UI oluşturma çerçevesi |
| **MVVM (Model-View-ViewModel)** | Uygulama mimarisi |
| **Hilt (Dagger Hilt)** | Dependency Injection (Bağımlılık Yönetimi) |
| **Room Database** | Yerel veri saklama |
| **Coroutines & Flow** | Asenkron işlemler ve veri akışları |
| **Retrofit** | API çağrıları ve ağ işlemleri |
| **Jetpack Navigation** | Uygulama içi yönlendirme sistemi |

---

## 📥 Kurulum ve Çalıştırma

Aşağıdaki adımları takip ederek projeyi yerel ortamınızda çalıştırabilirsiniz.

### 1️⃣ Projeyi Klonlayın

```sh
git clone https://github.com/rakun256/faturapay-mobile.git
cd FaturaPay
```

### 2️⃣ Gerekli Bağımlılıkları Yükleyin

Android Studio'da **Gradle Sync** işlemini gerçekleştirin veya terminalde aşağıdaki komutu çalıştırın:

```sh
./gradlew build
```

### 3️⃣ Uygulamayı Çalıştırın

```sh
./gradlew installDebug
```

veya **Android Studio** üzerinden **Run** butonuna basarak uygulamayı başlatabilirsiniz.

---

## 📸 Ekran Görüntüleri

| 🔑 Giriş Ekranı | 📊 Dashboard | 📋 Faturalar | 💳 Abonelikler |
|---------------|-------------|-------------|--------------|
| <img src="https://github.com/user-attachments/assets/35b35e68-6b03-4499-a232-23cbb7522384" width="350"> | <img src="https://github.com/user-attachments/assets/056100b5-2156-484b-b0d3-2c6abac8171b" width="350"> | <img src="https://github.com/user-attachments/assets/83fbc183-297d-41a1-b536-f6e56d8520fa" width="350"> | <img src="https://github.com/user-attachments/assets/e4d1a1ae-347b-40ab-a46b-d73bd733c58b" width="350"> |

---

## 🛠 Katkıda Bulunma

Projeye katkıda bulunmak için aşağıdaki adımları izleyebilirsiniz:

1. 🍴 **Fork yapın**.
2. 🌿 Yeni bir **branch** oluşturun (`feature-xyz`).
3. 🛠 Değişikliklerinizi yapın ve **commit** atın:
   ```sh
   git commit -m 'Yeni özellik eklendi'
   ```
4. 📤 Branch'i uzak repo'ya gönderin:
   ```sh
   git push origin feature-xyz
   ```
5. 🔃 **Pull Request (PR)** açın ve incelemeye gönderin.

---

## 📄 Lisans

Bu proje **MIT Lisansı** ile sunulmaktadır. Daha fazla bilgi için [LICENSE](https://github.com/rakun256/faturapay-mobile/blob/main/LICENSE) dosyasını inceleyebilirsiniz.

---

🚀 **FaturaPay ile finansal takibinizi kolaylaştırın!** 🚀

**Tüm hakları saklıdır.**

