import java.util.Random;
/**
 * @author Bengü Demireğen
 */
public class Oyun {

	private Avatar[] oyuncu1;
    private Avatar[] oyuncu2;	//avatar klasını değişken türü olarak aldım
    
    /**
     * Her bir oyuncu için 5 adet avatar oluşturulması diziler sayesinde yapılmıştır.
     * @author Bengü Demireğen 
     */
    public Oyun()
    {
        oyuncu1 = new Avatar[5];
        oyuncu2 = new Avatar[5];
    }
    /**
     * Random fonksiyonu sayesinde üretilen iki rakam (0 ve 1), çiftçi ve savaşçı türlerini temsil etmektedir.
     * @author Bengü Demireğen 
     */
    private String TurSecim() 
    {
        Random random = new Random();
        int sayi = random.nextInt(2); //0-1
        
        if(sayi==0)
        	return "Savaşçı";
        
        else if(sayi==1)
        	return "Çiftçi";
        else
        return null;
    }
    /**
     * 5 karakter için 5 kere dönecek bir for döngüsü sayesinde iki oyuncunun da karakterleri eş zamanlı olarak üretilecektir.
     * @author Bengü Demireğen
     */
    public void KarakterOlustur() {
    	for (int i = 0; i < 5; i++) {
            oyuncu1[i] = new Avatar(TurSecim());
            oyuncu2[i] = new Avatar(TurSecim());
        }
    	
    }
    /**
     * Savaşçı > Çiftçi, bu durumda savaşçı avatara sahip olan oyuncu 10 puan alır.
     * Her iki avatarın türü aynı ise güç seviyesine bakılır. Gücü fazla olan avatara sahip oyuncuya puan verilir. Bu puan güç seviyeleri arasındaki fark olarak hesaplanır
     * @author Bengü Demireğen
     */
    public int Karsilastirma(Avatar avatar1, Avatar avatar2) 
    {
        if (avatar1.getTur().equals("Savaşçı") && avatar2.getTur().equals("Çiftçi"))
        {
            return 10;
        } 
        else if (avatar1.getTur().equals("Çiftçi") && avatar2.getTur().equals("Savaşçı")) 
        {
            return 11;
        } 
        else 
        {
            return avatar1.getGuc() - avatar2.getGuc();
        }
    }
    /**
     * Bu metot oyunun puanlamasını ve puanlama kurallarını içeriyor.
     * @author Bengü Demireğen 
     */
    public void Game() {
        int puan_oyuncu1 = 0;
        int puan_oyuncu2 = 0;
        for (int i = 0; i < 5; i++) {
            Avatar avatar1 = oyuncu1[i];
            Avatar avatar2 = oyuncu2[i];

            System.out.println("1. oyuncunun " + (i + 1) + ". avatarının bilgileri:");
            avatar1.bilgi();
            System.out.println(); 	//boş satır eklemek için
            System.out.println("2. oyuncunun " + (i + 1) + ". avatarının bilgileri:");
            avatar2.bilgi();
            System.out.println();	//boş satır eklemek için
            
            int sonuc = Karsilastirma(avatar1, avatar2);

            if (sonuc == 10) 
            {
                System.out.println("1. oyuncu 10 puan kazandı!");
                System.out.println("----------------------------------------");
                puan_oyuncu1 = puan_oyuncu1 +10;
            } 
            else if (sonuc == 11) 
            {
                System.out.println("2. oyuncu 10 puan kazandı!");
                System.out.println("----------------------------------------");
                puan_oyuncu2 = puan_oyuncu2 + 10;
            } 
            else if (sonuc > 0) //oyuncu1-oyunncu2 yapıldıgından pozitif olması demek
            {
                System.out.println("1. oyuncu " + sonuc + " puan kazandı!");
                System.out.println("----------------------------------------");
                puan_oyuncu1 = puan_oyuncu1 + sonuc;
            } 
            else if (sonuc < 0) 
            {
                System.out.println("2. oyuncu " +(-1*sonuc) +" puan kazandı!");
                System.out.println("----------------------------------------");
             puan_oyuncu2 = puan_oyuncu2 + (-1* sonuc);
            }
            else if(sonuc==0)
            {
            	System.out.println("Bu el hiçbir oyuncu puan alamamıştır.");
            	System.out.println("----------------------------------------");
            	puan_oyuncu1=puan_oyuncu1+sonuc;
            	puan_oyuncu2=puan_oyuncu2+sonuc;
            }
        }
        System.out.println("Oyun bitmiştir.");
        System.out.println("----------------------------------------");
        System.out.println("1. oyuncunun toplam puanı: " + puan_oyuncu1);
        System.out.println("2. oyuncunun toplam puanı: " + puan_oyuncu2);
        System.out.println("----------------------------------------");

        if (puan_oyuncu1 > puan_oyuncu2) 
        {
            System.out.println("1. oyuncu kazandı, tebrikler!");
        } 
        else if (puan_oyuncu1<puan_oyuncu2) 
        {
            System.out.println("2. oyuncu kazandı, tebrikler!");
        } 
        else 
        {
            System.out.println("İki oyuncu da berabere kalmıştır.");
        }
    }
}
