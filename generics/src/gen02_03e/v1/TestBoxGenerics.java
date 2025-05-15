package gen02_03e.v1;

public class TestBoxGenerics {
    public static void main(String[] args) {
    	System.out.println("V1");
        Box1<Book> bookBox = new Box1<>();
        bookBox.addItem(new Book("Harry Potter & the half blood price", "JK Rowling", 0.5));
        bookBox.addItem(new Book("Deep Work", "Cal Newport", 0.25));
        System.out.println(bookBox.getLatestItem());
        System.out.println(bookBox);
        //bookBox.addItem(new Fruit("Mango", "India", "Yellow", 0.5));

        Box1<Fruit> fruitBox = new Box1<>();
        fruitBox.addItem(new Fruit("Mango", "India", "Yellow", 0.5));
        fruitBox.addItem(new Fruit("Banana", "Brazil", "Green", 0.3));
        System.out.println(fruitBox.getLatestItem());
        System.out.println(fruitBox);
    }
}
