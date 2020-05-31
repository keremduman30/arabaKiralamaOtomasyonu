
public class kullanıcı {
private int id;
private String ad;
private String parola;

    public kullanıcı(int id, String ad, String parola) {
        this.id = id;
        this.ad = ad;
        this.parola = parola;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

}
