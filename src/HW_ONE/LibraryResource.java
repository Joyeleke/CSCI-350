package HW_ONE;

class LibraryResource {
    String title;
    String author;
    ResourceStatus status;
    Person resourceHolder;

    public LibraryResource(String title, String author) {
        this.title = title;
        this.author = author;
        this.status = ResourceStatus.UNASSIGNED;
    }

    protected void checkOut(Person borrower){
        if (this.isAssigned()){
            System.out.println("400 Error. Can't check out a book that has already been assigned");
            return;
        }

        this.status = ResourceStatus.ASSIGNED;
        this.resourceHolder = borrower;
        System.out.println("Check Out Successful");
    }

    protected void checkIn(){
        if (this.isNotAssigned()){
            System.out.println("400 Error. Can't check in a book that has not been assigned");
            return;
        }

        this.status = ResourceStatus.UNASSIGNED;
        this.resourceHolder = null;
        System.out.println("Check In Successful");
    }

    protected boolean isAssigned(){
        return this.status == ResourceStatus.ASSIGNED;
    }

    protected boolean isNotAssigned(){
        return this.status == ResourceStatus.UNASSIGNED;
    }

    void displayLibraryResource(){
        System.out.println("Resource with Title: " + this.title);
    };
}
