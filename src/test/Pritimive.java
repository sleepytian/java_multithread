package test;

public class Pritimive {
    private Boolean[] t;

    public Pritimive (int length) {
        this.t = new Boolean[length];
    }
    public void printAll () {
        for (int i = 0;i < t.length;i++) {
            System.out.println(t[i]);
        }
    }

    public void add(Boolean flag) {
        for (int i = 0; i < this.t.length; i++) {
            if (t[i] == null) {
                t[i] = flag;
            }
        }
    }
}
