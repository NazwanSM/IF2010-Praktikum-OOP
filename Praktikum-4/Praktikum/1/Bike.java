/*
    Nama                    : 
    NIM                     : 
    Hari dan tanggal        : 
    Deskripsi Program       :
*/

/**
 * Bike.java
 *
 * Kelas abstrak dasar untuk semua bike.
 */
public abstract class Bike implements Discountable{
    private String name;
    private Number price;
    private Number battery;

    /**
     * Konstruktor untuk Bike.
     *
     * @param name    nama model sepeda
     * @param price   harga dalam USD (any Number subtype)
     * @param battery kapasitas baterai dalam Wh (any Number subtype)
     */
    public Bike(String name, Number price, Number battery) {
        this.name = name;
        this.price = price;
        this.battery = battery;
    }

    /** @return nama model sepeda */
    public String getName() {
        return name;
    }

    /** @param name nama model baru */
    public void setName(String name) {
        this.name = name;
    }

    /** @return harga sepeda sebagai Number */
    public Number getPrice() {
        return price;
    }

    /** @param price harga baru */
    public void setPrice(Number price) {
        this.price = price;
    }

    /** @return kapasitas baterai dalam Wh */
    public Number getBattery() {
        return battery;
    }

    /** @param battery kapasitas baterai baru */
    public void setBattery(Number battery) {
        this.battery = battery;
    }

    /**
     * Mencetak spesifikasi sepeda:
     * "<name> $<price 2 desimal>, <battery 1 desimal>Wh"
     * "Contoh: Wush $1200.00, 400.0Wh"
     */
    public void printSpec() {
        String spec = String.format("%s $%.2f, %.1fWh", name, price, battery);
        System.out.println(spec);
    }

    /**
     * Membandingkan suatu sepeda dengan sepeda lain berdasarkan:
     * 1) battery (lebih besar lebih baik)
     * 2) jika battery sama, bandingkan price (lebih kecil lebih baik)
     *
     * @param otherBike sepeda lain
     * @return true jika sepeda ini lebih baik, selain itu return false
     */
    public boolean isBetterThan(Bike otherBike) {
        if (this.battery.doubleValue() > otherBike.battery.doubleValue()){
            return true;
        }
        else if (this.battery.doubleValue() == otherBike.battery.doubleValue()){
            if (this.price.doubleValue() < otherBike.price.doubleValue()) {
                return true;
            }
        }
        return false;
    }
}
