/**
 * Pipo.java
 * [Jelaskan kegunaan class ini]
 * 
 * @author [NIM] [Nama]
 */

public class Pipo extends Handphone {
	private String camera;

	public Pipo(String camera) {
		// Sesuai dengan Soal
        super("Pipo", 3000000, 3);
        this.camera = camera;
	}

	@Override
	public Boolean tawar(Integer hargaTawaran) {
		// Sesuai dengan soal
        if (hargaTawaran >= 2500000){
            return true;
        }
        else {
            return false;
        }
	}

	@Override
	public void printSpeciality() {
		// Print (tanpa tanda kutip, diakhiri newline):
		// "Kamera ni HP " + camera
        System.out.print("Kamera ni HP " + this.camera + "\n");
	}
}