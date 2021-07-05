package Model;

public class Result {

    private boolean tf;
    private String text;
    private String custid;

    public boolean isTf() {
        return tf;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public void setTf(boolean tf) {
        this.tf = tf;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Result{" +
                "tf=" + tf +
                ", text='" + text + '\'' +
                ", custid='" + custid + '\'' +
                '}';
    }
}
