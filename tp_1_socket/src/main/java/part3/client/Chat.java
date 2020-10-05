package part3.client;

public class Chat {

    public static void main(String[] args) {
        try {
            System.out.println("Hello ");
            mychat c = new mychat("Shu");
            Thread t1 = new Thread(c);
            t1.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
