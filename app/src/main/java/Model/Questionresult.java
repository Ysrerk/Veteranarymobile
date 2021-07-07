package Model;

public class Questionresult {
    private Boolean sonuc;

    public Boolean getSonuc() {
        return sonuc;
    }

    public void setSonuc(Boolean sonuc) {
        this.sonuc = sonuc;
    }

    @Override
    public String toString() {
        return "Questionresult{" +
                "sonuc=" + sonuc +
                '}';
    }
}
