package HW_ONE;

import java.util.ArrayList;
import java.util.Objects;

class Library {
    protected ArrayList<LibraryResource> resources = new ArrayList<>();

    public Library(ArrayList<LibraryResource> resources){
       this.resources = resources;
    }

    public void addResource(LibraryResource new_resource){
        resources.add(new_resource);
    }

    public LibraryResource findResource(String title){
        for (LibraryResource resource : resources) {
            if (Objects.equals(resource.title, title)) {
                return resource;
            }
        }

        return null;
    }

    public void printResourcesInStock(){
        System.out.println();
        if (resources.isEmpty()){
            System.out.println("No resource is currently in stock.");
            return;
        }

        for(LibraryResource resource: resources) {
            if(resource.status == ResourceStatus.UNASSIGNED){
                resource.displayLibraryResource();
                System.out.println();
            }
        }
    }

    public void printResourcesOnLoan(){
        System.out.println();
        if (resources.isEmpty()){
            System.out.println("No resource is currently on loan.");
            return;
        }

        for(LibraryResource resource: resources) {
            if(resource.status == ResourceStatus.ASSIGNED){
                resource.displayLibraryResource();
                System.out.println();
            }
        }
    }

    public void printResourcesOnLoanWithBorrowerPhoneNumber(){
        System.out.println();
        if (resources.isEmpty()){
            System.out.println("No resource is currently on loan.");
            return;
        }

        for(LibraryResource resource: resources) {
            if(resource.status == ResourceStatus.ASSIGNED){
                resource.resourceHolder.displayPerson();
                resource.displayLibraryResource();
                System.out.println();
            }
        }
    }

    public void populateLibraryWithDefaults(){
        Book book1 = new Book("Life is Beautiful", "Jimmy G");
        Book book2 = new Book("Beauty O Beauty", "Lena Bing");
        Book book3 = new Book("Journey of a thousand steps", "Rebecca Lowe");
        Book book4 = new Book("Shout", "Riv Long");
        Book book5 = new Book("Sooner or Later", "Sharma River");

        Magazine magazine1 = new Magazine("Today with You", "CNN", "12/3/24");
        Magazine magazine2 = new Magazine("Yesterday with You", "Today", "21/4/19");
        Magazine magazine3 = new Magazine("Who are we?", "Sigma Beta", "11/3/17");

        resources.add(book1);
        resources.add(book2);
        resources.add(book3);
        resources.add(book4);
        resources.add(book5);

        resources.add(magazine1);
        resources.add(magazine2);
        resources.add(magazine3);
    }
}
