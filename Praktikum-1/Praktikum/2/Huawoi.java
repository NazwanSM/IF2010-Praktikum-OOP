/**
 * Huawoi.java
 * [Jelaskan kegunaan class ini]
 * 
 * @author [NIM] [Nama]
 */

public class Huawoi extends Handphone {
	private Boolean isKW;

	public Huawoi(Boolean isKW) {
		// Sesuai dengan Soal
        super("Huawoi KW", 2000000, 2);
        this.isKW = isKW;
        
        if (!isKW){
            setNama("Huawoi");
            setHarga(5000000);
            setRam(4);
        }
	}

	@Override
	public Boolean tawar(Integer hargaTawaran) {
		// Sesuai dengan soal
        if (getHarga() - hargaTawaran <= 1000000){
            return true;
        }
        else {
            return false;
        }
	}

	@Override
	public void printSpeciality() {
		// Bila isKW = true, Print (tanpa tanda kutip, diakhiri newline) "HPnya murah
		// bos"
		// Bila isKW = false, Print (tanpa tanda kutip, diakhiri newline) "Speknya
		// kenceng bos"
        if (this.isKW){
            System.out.print("HPnya murah bos\n");
        }
        else {
            System.out.print("Speknya kenceng bos\n");
        }
	}
}