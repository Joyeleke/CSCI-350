package HW_ONE;

class Book extends LibraryResource {
    public Book(String title, String author) {
        super(title, author);
    }

    @Override
    void displayLibraryResource(){
        System.out.println("HW_ONE.Book Title: " + this.title);
        System.out.println("HW_ONE.Book Author: " + this.author);
    }
}
