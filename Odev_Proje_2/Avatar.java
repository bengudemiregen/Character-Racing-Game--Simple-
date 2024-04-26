import java.util.Random;
/**
 * Bu sınıf sayesinde oluşturulacak karakterlerin tür ve güç özellikleri tutulur.
 * @author Bengü Demireğen
 */
public class Avatar {
	
	private String tur;
	private int guc;
	
    public String getTur() {
		return tur;
	}
	public void setTur(String tur) {
		this.tur = tur;
	}
	public int getGuc() {
		return guc;
	}
	public void setGuc(int guc) {
		this.guc = guc;
	}
	/**
	 * Avatar isimli yapıcımızda tanımladığımız güç bilgisini tutan değişkene random fonksiyonu sayesinde değer atamış olduk.
	 * Random fonksiyonu 0-9 arasında sayı ürettiğinden dolayı +1 ekledim.
	 * @author Bengü Demireğen
	 */
	public int GucBelirle() {
        Random random = new Random();
        return random.nextInt(10) + 1; //0-9 arası oldugundan +1
    }
/**
 * Yapıcı sayesinde tür ve güç değişkenlerini oluşturdum.
 * @param tur
 * @author Bengü Demireğen 
 */
	public Avatar(String tur) {
        this.tur = tur;
        this.guc = GucBelirle();
    }
	/**
	 * Oyunda her eldeki karakterlerin tür ve güç bilgisini bu metot sayesinde yazdırıyoruz.
	 * @author Bengü Demireğen
	 */
	public void bilgi() {
		System.out.println("Tür: " + tur);
        System.out.println("Güç: " + guc);
	}
}
