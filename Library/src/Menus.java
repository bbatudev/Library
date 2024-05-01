import java.util.Scanner;

public class Menus extends Libfunc {
    Scanner scan = new Scanner(System.in);
    public void showmenu(){
        System.out.println("Enter the number of the action you want to perform\n");
        System.out.println("1-) Show me the books that I borrow from library");
        System.out.println("2-) Barrow book from library");
        System.out.println("3-) Give book back to library");
        System.out.println("4-) Change library password");
        System.out.println("5-) Donate book");
        System.out.println("6-) Search a condition of book");
        System.out.println("7-) Show all books in library (only available books)");
        System.out.println("8-) Exit");
        choice = scan.nextInt();
        switch (choice) {
            case 1:

                if(userBookNumber != 0) {
                    ArrayShowBorrowedBooks();
                    System.out.println("\n");
                    System.out.println("You are returning to main menu");
                    showmenu();
                }
                else{
                    System.out.println("You do not have any books borrowed, please try again after borrow them.");
                    System.out.println("You are returning to main menu.\n");
                    showmenu();
                }
            case 2:
                BorrowBook();
                System.out.println("You are returning to main menu\n");
                showmenu();

            case 3:
                giveBackBook();
                System.out.println("You are returning to main menu\n");
                showmenu();

            case 4:
                changepassword();
                showmenu();

            case 5:
                DonateBook();
                System.out.println("You are returning to main menu\n");
                showmenu();

            case 6:
                searchConditionsBook();
                System.out.println("You are returning to main menu\n");
                showmenu();

            case 7:
                ArrayShowLibraryBooks();
                System.out.println("You are returning to main menu\n");
                showmenu();

            case 8:
                exit();
                break;

            default:
                System.out.println("Invalid choice");
                showmenu();

        }
    }

    void LArrayInitialDedicate(){
        dinamicArray.add("A Tale of Two Cities");
        dinamicArray.add("The Hobbit");
        dinamicArray.add("Gone Girl");
        dinamicArray.add("Dune");
        dinamicArray.add("War and Peace");
        dinamicArray.add("The Stranger");
        dinamicArray.add("The Alchemist");

    }
    void userhomeArrayInitialDedicate(){

        userhomeArray.add("1984");
        userhomeArray.add("The Lord of the Rings");
        userhomeArray.add("Animal Farm");
    }
    void ArrayShowLibraryBooks(){
        System.out.println("These are available books in the library system.");
        for(int i = 0;i < dinamicArray.size();i++){
            String element = dinamicArray.get(i);
            System.out.println(element);
        }
    }

    void ArrayShowBorrowedBooks(){
        System.out.println("Here are books that barrowed from library\n");
        for(int i = 0; i < userArray.size();i++){
            String element = userArray.get(i);
            System.out.println(element);
        }

    }


    void BorrowBook(){
        System.out.println("You can borrow book if you have enough limit");
        if(userBookNumber<3){
            System.out.println("Search your book these are our books to select");
            ArrayShowLibraryBooks();
            System.out.println("Please write the all name of the book you want to borrow.");
            scan.nextLine();
            booknameuserwant = scan.nextLine();

            if(dinamicArray.contains(booknameuserwant)){
                System.out.println("You can take your book. Please don't forget to give back");
                userArray.add(booknameuserwant);
                dinamicArray.remove(booknameuserwant);
                userBookNumber = userBookNumber +1;
                showmenu();
            }
            else{
                System.out.println("Probably you entered wrong or the book may be given");
            }
        }

        else{
            System.out.println("You have no limit to take, please firstly give your books back.");
        }
    }

    void giveBackBook(){
        for(int i = 0; i < userArray.size();i++){
            String element = userArray.get(i);
            System.out.println(element);
        }
        if(userBookNumber>0 && userBookNumber <=3){
            System.out.println("Enter the order number of book you want to give back");
            givebackchoice = scan.nextInt();

            switch(givebackchoice){
                case 1:
                    dinamicArray.add(userArray.get(0));
                    userArray.remove(userArray.get(0));
                    userBookNumber = userBookNumber-1;
                    showmenu();
                case 2:
                    dinamicArray.add(userArray.get(1));
                    userArray.remove(userArray.get(1));
                    userBookNumber = userBookNumber-1;
                    showmenu();

                case 3:
                    dinamicArray.add(userArray.get(2));
                    userArray.remove(userArray.get(2));
                    userBookNumber = userBookNumber-1;
                    showmenu();

                default:
                    System.out.println("Wrong number. You are returning to te main menu.");
                    showmenu();
            }
        }
        else{
            System.out.println("There is no book you can give.");
            showmenu();
        }

    }


    void DonateBook(){
        if(numberofbooksinhome>0){
            System.out.println("You can donate book, please enter the row number of book to donate. ");
         for(int i = 0; i < userhomeArray.size();i++){
            String element = userhomeArray.get(i);
            System.out.println(element);
        }
        int donatesecim;
            donatesecim = scan.nextInt();
            switch(donatesecim)
            {
                case 1:
                    dinamicArray.add(userhomeArray.get(0));
                    userhomeArray.remove(userhomeArray.get(0));
                    numberofbooksinhome = numberofbooksinhome-1;
                    showmenu();
                case 2:
                    dinamicArray.add(userhomeArray.get(1));
                    userhomeArray.remove(userhomeArray.get(1));
                    numberofbooksinhome = numberofbooksinhome-1;

                    showmenu();

                case 3:
                    dinamicArray.add(userhomeArray.get(2));
                    userhomeArray.remove(userhomeArray.get(2));
                    numberofbooksinhome = numberofbooksinhome-1;
                    showmenu();

                default:
                    System.out.println("Wrong number, returning to menu\n");
                    showmenu();
            }
        }
        else{
            System.out.println("You have not enough book to donate. It is returning to main menu\n");
            showmenu();

        }
    }

    void searchConditionsBook(){
        scan.nextLine();
        System.out.println("Enter the name of book you want to know");
        String searchedbook = scan.nextLine();
    boolean LibraryIncludes =  dinamicArray.contains(searchedbook);
    boolean UserIncludes =  userArray.contains(searchedbook);
    if(LibraryIncludes)
    {
        System.out.println("The book is available, you can borrow from library");

    }
        else if(UserIncludes)
    {
            System.out.println("The book you are looking for is not currently available, please inquire again at another time.");
    }
        else
    {
        System.out.println("Sorry.There is no data about your book.");
    }

                                  }
}
