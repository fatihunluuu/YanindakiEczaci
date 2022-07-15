package com.example.laprospekts;

import android.content.Intent;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class giris_ekrani extends AppCompatActivity implements View.OnClickListener{
    Mydatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_ekrani);

        TextView baslik = findViewById(R.id.baslik);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/plicata.ttf");
        baslik.setTypeface(typeface);

        // Butonla yeni intent geçişi
        Button btn = findViewById(R.id.ilacAdı);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(giris_ekrani.this, isim_arama.class);
                startActivity(intent);
            }
        });

        Button btn1 = findViewById(R.id.barkodArama);
        btn1.setOnClickListener(this);



        db = new Mydatabase(this);

        //dolorex ilaç
        long dolorex = Long.parseLong("8699633129350");
        db.insertilaclar(dolorex,"Dolorex 50 Mg","3,16TL");
        db.inserticerik(dolorex,"Bir ağrı kesici grubu üyesidir." +
                " Özeliikle romatizmal hastalıklarda eklem yerlerindeki şişkinlik, ağrı ve hassasiyetin giderilmesinde yaygın olarak kullanılır",
                "Karaciğer veya böbrek yetmeziği olan hastalar da Dolorex yerine alternatif bir ağrı kesici kullanılmalıdır."
        ,"En belirgin yan etkileri; mide rahatsızlığı, ishal, kabızlık, gaz şikayetleri, baş ağrısı ve dönmesidir.","Tavsiye edilen kullanım biçimi gün de 3 adettir."
                ,"Her draje 50 mg diklofenak potasyum içerir.");
        db.insertfirma(dolorex,"Abdi İbrahim","Reşitpaşa Mah. Eski Büyükdere Cad. No:4 Maslak/Sarıyer/İstanbul","0212 366 84 00","info@abdiibrakim.com.tr");


        //coraspin ilaç
        long coraspin = Long.parseLong("8699546130238");
        db.insertilaclar(coraspin,"Coraspin 100 Mg","4,47TL");
        db.inserticerik(coraspin,"Coraspin  pıhtılaşma hücrelerinin kümeleşmesini önler." +
                "Bu nedeniyle çeşitli kalp hastalıklarında kullanılır.","Kanser ve romatizma tedavisinde kullanılan bir ilaç kullanıyorsanız" +
                ", şiddetli böbrek veya karaciğer yetmezliği ve kalp yetmezliği varsa kullanmayınız.","Nezle, burun tıkanıklığı, cilt reaksiyonları, anafilaktik şok yan etkileri arasındadır."
                ,"Kalp damar ameliyatı sonrasında önerilen günlük 1 tablet," +
                        " Geçici felç ve inmenin önlenmesinde gün de 1-3 tablet.","100 Mg asetilsalisilik asit");
        db.insertfirma(coraspin,"Bayer Türk Kimya","Fatih Sultan Mehmet Mah. Balkan Cad. No:53 Ümraniye/İstanbul","0216 528 36 00","info.turkey@bayer.com");


        //parol ilaç
        long parol = Long.parseLong("8699717010109");
        db.insertilaclar(parol,"Parol 500 Mg","5,06TL");
        db.inserticerik(parol,"Hafif ve orta şiddetli ağrıların tedavisi için kullanılır." +
                " Ağrı kesici ve ateş düşürücü etki gösterir.","İleri düzey böbrek ve karaciğer yetmezliği varsa, Gilbert sendromu ve kan hücreleriyle ilgili bir hastalığınız " +
                "varsa dikkatli kullanınız.","Ürtiker ve kaşıntı deri döküntüsü, yüz, dil ve boğazda şişme gibi rahatsızlıklar da kullanımı kesiniz.","Yetişkib bireyler gün de 1-2 tablet kullanabilir." +
                "Gerektiğinde günde 3 tablet alınabilir.","Her bir tablet 250 mg parasetamol, 150 mg propifenazon ve 50 mg kafein");
        db.insertfirma(parol,"Atabay Kimya","Acıbadem Köftüncü Sok. No:1 Kadıköy/İstanbul","0216 339 69 03","info@atabay.com");


        //arveles ilaç
        long arveles = Long.parseLong("8699832090055");
        db.insertilaclar(arveles,"Arveles 25 Mg","10,09TL");
        db.inserticerik(arveles,"Erişkinlerde kas-iskelet sistemi ağrıları, ağrılı adet dönemleri, diş ağrılarının semptomatik tedavisinde kullanılır."
                ,"Ciddi kalp yetmezliği, karaciğer sorunları, sürekli hazımsızlık ve göğüste yanma şikayeti ve böbrek sorunları gibi rahatsızlıkta" +
                        "kullanmayınız.","Mide bulantısı ve/veya kusma, karın ağrısı, ishal, hazımsızlık gibi yan etkileri görülebilir.","Önerilen doz genellikle her 4-6 saatte bir 12,5 mg veya her 8 saatte bir 25 mg’dır. " +
                        "Toplam günlük doz 75 mg’ı geçmemelidir."," 50 mg deksketoprofen’e eşdeğer 73,8 mg deksketoprofen trometamol");
        db.insertfirma(arveles,"Ufsa İlaç Sanayi","Davutpaşa Mah. No:12 Topkapı/İstanbul","0212 467 11 11","-");


        //beloc ilaç
        long beloc = Long.parseLong("8699786030367");
        db.insertilaclar(beloc,"Beloc Zok 50 Mg","17,13TL");
        db.inserticerik(beloc,"Yüksek kan basıncını ve göğüs ağrısını önlemek için, kalp yetmezliğine ve çarpıntılarda kullanılır.","Kalbin kanı vücuda pompalayamaması sonucu ortaya çıkan şok durumlarında, " +
                        "kalbin ileti sisteminde engel olması sonucu ortaya çıkan atım bozukluğunuz varsa, şikayete neden olan kalp hızında yavaşlama veya kan basıncında düşme varsa ilacı kullanmayınız","Yorgunluk, baş ağrısı, sersemlik, baş dönmesi, kalp atım hızında yavaşlama, karın ağrısı, bulantı gibi yan etkileri mevcuttur.",
                "Yüksek tansiyon, günde bir kez 50-100 mg'dır. Diğer ilaçlarla birlikte stabil kalp yetmezliği başlangıç dozu günde bir kez 12.5 - 25 mg. dozaj günde en fazla 200 mg'a kadar kademeli olarak arttırılır.", "50 mg metoprolol tartarata eşdeğer 47,5 mg metoprolol süksinat içerir.");
        db.insertfirma(beloc,"AstraZeneca İlaç Sanayi","Büyükdere Cad. Yapı Kredi Plaza B Blok Kat 3-4 Levent/İstanbul","0212 317 23 00","astrazeneca.turkey@astrazeneca.com");

        //Minoset ilaç
        long minoset = Long.parseLong("8699546015597");
        db.insertilaclar(minoset,"Minoset 500 Mg","4,88TL");
        db.inserticerik(minoset,"Ağrı kesici ve ateş düşürücüdür.","Şiddetli karaciğer veya böbrek yetmezliğiniz varsa kullanmayınız. Parasetamol içeren başka bir ilaç kullanıyorsanız kullanmayınız.",
                "Alerjik reaksiyonlar, ellerde ayaklarda şişme ve boğazda yutmayı ve nefes almayı zorlaştıracak şekilde k şişmelerde kullanmayı durdurunuz. Deride döküntü, kurdeşen, kaşıntı gibi durumlar da yan etkileri arasındadır.",
                "Doktorunuz farklı bir tavsiyede bulunmadıkça 4-6 saatte bir 1-2 tablet alınız","Parasetamol");
        db.insertfirma(minoset,"Bayer Türk Kimya","Fatih Sultan Mehmet Mah. Balkan Cad. No:53 Ümraniye/İstanbul","0216 528 36 00","info.turkey@bayer.com");

        //Aferin
        long aferin = Long.parseLong("8699570090058");
        db.insertilaclar(aferin,"A-ferin 650 Mg","9,19TL");
        db.inserticerik(aferin,"Grip ve soğuk algınlığına bağlı burun akıntısı, aksırma, burun ve boğazda kaşıntı, baş ağrısı, ateş, nezle gibi durumlarda kullanılır.",
                "Şiddetli karaciğer ya da böbrek yetmezliği varsa, başka ağrı kesici kullanıyorsanız kulanmayınız.","Uyuşukluk ve uyu hali, baş dönmesi iştahsızlık, konsantrasyon bozukluğu, karın ağrısı, kabızlık gibi durumlar.","Günde 6 tableti geçmemek koşuluyla 4 saatte bir kullanılabilir ama en ideal kullanım 6 saatte birdir.","Parasetamol ve Klorfeniramin Maleat");
        db.insertfirma(aferin,"Hüsnü Arsan İlaçlar","Kaptanpaşa Mah. Zincirlikuyu Cad. No:184 Beyoğlu/İstanbul","0212 365 15 00","-");

        //Silverdin
        long silverdin = Long.parseLong("8699525359636");
        db.insertilaclar(silverdin,"Silverdin Plus","13,68TL");
        db.inserticerik(silverdin,"Yara ve yanıklarda ortaya çıkan iltihaplanmaların önlenmesinde ve tadavisinde kullanılır.","Etken maddelere alerjiniz varsa, gebeliğin son döneminde iseniz kullanmayınız. Ayrıca 2 aylıktan küçük bebeklerde ve erken doğan(prematüre) bebeklerde kullanmayınız.",
                "Kaşıntı, egzema, uygulama bölgesinde döküntü, yanma hissi gibi yan etkileri mevcuttur.","Yara ve yanık olan bölge temizlendikten sonra günde 1-2 kez uygulanır.","Gümüş Sülfadiazin ve Lidokain");
        db.insertfirma(silverdin,"Deva Holding","Halkalı Merkez Mah. Basın Ekspres Cad. No:1 Küçükçekmece/İstanbul","0212 692 92 92","info@deva.com.tr");

        //telfast
        long telfast = Long.parseLong("8699809090224");
        db.insertilaclar(telfast,"Telfast 180 Mg","6,40TL");
        db.inserticerik(telfast,"Mevsimsel alerjik denen hastalıklarda ortaya çıkan aksırık, kaşıntılı burun akıntısı, gözlede kızarma ve sulanma gibi belirtilerin tedavisinde kullanılır.",
                "Karaciğer ve böbrek yetmezliği, kalp ile ilgili problem var ise, hamile yada ihtimal var ise lütfen kullanmadan önce dokturunuza danışınız.","Zorlukla ve hırıltılı bir şekilde nefes almaya başlamak. Yüz, dil, veya boğazınızda, yutmayı veya nefes almayı zorlaştıracak bir şişme ortaya çıkması ciddi yan etkileri arasındadır. Doktora başvurmanızı öneririz.","Tavsiye edilen kullanım günde 1 adettir."," Feksofenadin Hidroklorür");
        db.insertfirma(telfast,"Aventis Pharma Sanayi","Mecidiyeköy Yolu Cad. No:102 Şişli/İstanbul","0212 354 20 00","info@aventis.com.tr");

        //Emedur
        long emedur = Long.parseLong("8699809097957");
        db.insertilaclar(emedur,"Emedur 200 Mg","12,81TL");
        db.inserticerik(emedur,"Bulantı ve kusmayı engelleyen ilaçlar grubuna dahildir.","Akut ateşli bir hastalık, beyin iltihaplanması, mide barsak sisteminde iltihap, aşırı sıvı kaybı ve elektrolit dengesizliği durumları.",
                "Uyuşukluk hissi, baş dönmesi ve ağrısı, bulanık görme, ishal, kaşıntı, kas krampları gibi yan etkileri görünebilir.","Doktor tavsiyesi dışında günde 3-5 tablet kullanılabiir.","Trimetobenzamid HCl");
        db.insertfirma(emedur,"Sanofi Sağlık Ürünleri","Esentepe Mah. Büyükdere Cad. No:193 Şişli/İstanbul","0212 339 10 00","-");

        //fenistil
        long fenistil = Long.parseLong("8681291340178");
        db.insertilaclar(fenistil,"Fenistil 1 Mg","19,32TL");
        db.inserticerik(fenistil,"İltihabi olmayan cilt hastalıklarına bağlı kaşıntılar, döküntü, böcek ısırmaları, güneş yanıkları ve yüzeysel hafif yanıklarda kullanılır.","Kullanılan bölgeyi çok güneşe maruz bırakmayınız. Küçük çocuklarda geniş cilt alanlarında, özellikle soyulma ya da enflamasyon varsa kullanmayınız.",
                "Citte hafif kuruluk ve yanma hissi, alerjil deri reaksiyonları gibi an etkileri olabilir.","Doktor tavsiesi dışında günde 2-4 defa uygulanabilir.","Dimetinden Maleat");
        db.insertfirma(fenistil,"Glaxosmithkline Tüketici Sağlığı"," Esentepe Mahallesi Büyükdere Caddesi Levent Plaza No:1 Şişli/İstanbul","0212 339 44 00","trinfo_DL@gsk.com");

        //Gaviscon
        long gaviscon = Long.parseLong("8690570700039");
        db.insertilaclar(gaviscon,"Gaviscon 500 Mg","19,24TL");
        db.inserticerik(gaviscon,"Mide asitine bağlı olarak ağıza acı, ekşi su gelmesi, mide veya göğüste yanma hissi gibi mide içeriğinin yemek borusuna geri kaçmasına bağlı şikayetlerin tedavisinde kullanılır.",
                "Böbrek ya da kalp rahatsızlığınız varsa, yedi gün belirtiler de düzelme yoksa kullanmayınız. Doktounuza başvurunuz.","Vücudumuzun herhangi bir bölümünde kızarıklık olabilir. Eller, ayaklar, yüz ve dudakların şişmesi ya da boğazda yutmayı ve nefes almayı zorlaştıracak şişme varsa doktorunuza başvurunuz. ","Doktor tavsiesi dışında yemeklerden sonra ve yatarken 10-20 ml günde 4 dozdur.","Sodyum aljimat, Sodyum bikarbonat, Kalsiyum karbonat");
        db.insertfirma(gaviscon,"Reckitt Benckiser","Dikilitaş Mah. Hakki Yeten Cad. Selenium Plaza Beşiktaş/İstanbul","0212 326 96 00","consumer.health@rb.com");

        //Majezik
        long majezik = Long.parseLong("8699536090115");
        db.insertilaclar(majezik,"Majezik 100 Mg","13,74TL");
        db.inserticerik(majezik,"Eklem iltihabı ile görülen romatizmal hastalık, yumuşak doku yaralanmaları, adet ağrısı gibi durumlarda kullanılır.","Ağır karaciğer, böbrek ve kalp yetmezliği var ise, ülser hastalığınız var ise kullanmayınız. ",
                "Solunum güçlüğü, mide ve bağırsak kanaması, göz ve deri renginin sarıa dönmesi gibi yan etkileri vardır. Bu durumlarda derhal doktorunuza başvurunuz.","Günde bir buçuk veya 2 tablet almanız önerilir.","Flurbiprofen");
        db.insertfirma(majezik,"Sanovel İlaç","Balabandere Cad. İlaç Sanayi Yolu No:14 Sarıyer/İstanbul","0212 362 18 00","infosanovel@sanovel.com.tr");




    }
    @Override
    public void onClick(View v) {
        scanCode();

    }
    private void scanCode(){
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setCaptureActivity(CaptureAct.class);
        integrator.setOrientationLocked(false);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.setPrompt("Scanning Code");
        integrator.initiateScan();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        String datas[] = result.getContents().split("\n");
        if (result != null){
            if (result.getContents() != null){
                Intent intent = new Intent(giris_ekrani.this, bilgiGoster.class);
                intent.putExtra("barkod", Long.parseLong(datas[0]));
                startActivity(intent);
            }
        }
    }

}