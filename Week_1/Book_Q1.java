public class Book_Q1 {
    String title;
    String author;
    double price;

    Book_Q1(){
        this.title = "No title given";
        this.author = "No author given";
        this.price = 0;
    }
    Book_Q1(String title, String author, double price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void Display(){
        System.out.println(title);
        System.out.println(author);
        System.out.println(price);
    }
    public static void main(String[] args){
        Book_Q1 book1 = new Book_Q1();
        Book_Q1 book2 = new Book_Q1("1986","George Orwell",1000);
        book1.Display();
        book2.Display();

    }
}