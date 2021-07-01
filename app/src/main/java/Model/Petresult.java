package Model;

public class Petresult {
    private  int id;
    private String custid;
    private String petname;
    private String petkind;
    private String pettur;
    private String petimage;
    private Boolean tf;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public String getPetkind() {
        return petkind;
    }

    public void setPetkind(String petkind) {
        this.petkind = petkind;
    }

    public String getPettur() {
        return pettur;
    }

    public void setPettur(String pettur) {
        this.pettur = pettur;
    }

    public String getPetimage() {
        return petimage;
    }

    public void setPetimage(String petimage) {
        this.petimage = petimage;
    }

    public Boolean getTf() {
        return tf;
    }

    public void setTf(Boolean tf) {
        this.tf = tf;
    }

    @Override
    public String toString() {
        return "Petresult{" +
                "id=" + id +
                ", custid='" + custid + '\'' +
                ", petname='" + petname + '\'' +
                ", petkind='" + petkind + '\'' +
                ", pettur='" + pettur + '\'' +
                ", petimage='" + petimage + '\'' +
                ", tf=" + tf +
                '}';
    }
}
