interface Int {
    final int i = 10;
    
    void Display();
}

class Interface implements Int {
    public void Display() {
        System.out.println("Test");
    }
    public static void main(String[] args) {
        Interface t = new Interface();
        t.Display();
        System.out.println(i);
    }
}
