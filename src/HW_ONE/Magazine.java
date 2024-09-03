package HW_ONE;

class Magazine extends LibraryResource {
    //add format for publication
    String dateOfPublication;

    public Magazine(String title, String author, String dateOfPublication) {
        super(title, author);
        this.dateOfPublication = dateOfPublication;
    }

    @Override
    void displayLibraryResource(){
        System.out.println("HW_ONE.Magazine Title: " + this.title);
        System.out.println("HW_ONE.Magazine Author: " + this.author);
        System.out.println("HW_ONE.Magazine Date of Publication: " + this.dateOfPublication);
    }
}
