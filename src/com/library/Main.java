package com.library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean keepRunning = true;
        Scanner sc = new Scanner(System.in);

        Librarian.defaultLibraryMembers();
        Librarian.defaultBooks();

        while (keepRunning) {
            System.out.println("***WELCOME TO THE DIGITAL LIBRARY***");
            System.out.println("Select an option: ");
            System.out.println("1. Librarian\n2. Sign In\n3. Sign Up");
            System.out.print("Select Option: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    librarianSection(sc);
                    break;
                case 2:
                    memberSection(sc);
                    break;
                case 3:
                    signUpSection(sc);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        sc.close();
    }

    private static void librarianSection(Scanner sc) {
        System.out.print("Librarian ID: ");
        int librarianId = sc.nextInt();
        sc.nextLine();
        System.out.print("Librarian Password: ");
        String librarianPassword = sc.nextLine();

        try {
            Librarian.checkCredentials(librarianId, librarianPassword);
            System.out.println("Log In Successful!");
            System.out.println("Select an option: ");
            System.out.println("1. Add Book\n2. Add Member");
            System.out.print("Select Option: ");
            int librarianOption = sc.nextInt();
            sc.nextLine();

            switch (librarianOption) {
                case 1:
                    addBook(sc);
                    librarianFinalOptions(sc);
                    break;
                case 2:
                    addMember(sc);
                    librarianFinalOptions(sc);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    librarianFinalOptions(sc);
            }
        } catch (WrongCredentialsException e) {
            e.printStackTrace();
        } finally {
            librarianFinalOptions(sc);
        }
    }

    private static void memberSection(Scanner sc) {
        System.out.print("Member ID: ");
        int memberId = sc.nextInt();
        sc.nextLine();
        System.out.print("Password: ");
        String memberPassword = sc.nextLine();

        try {
            Librarian.verifyMember(memberId, memberPassword);
            System.out.print("1. Borrow Book\n2. Return Book\n3. Search Book\nSelect an Option: ");
            int memberOption = sc.nextInt();
            sc.nextLine();

            switch (memberOption) {
                case 1:
                    borrowBook(sc);
                    borrowBookFinalOptions(sc);
                    break;
                case 2:
                    returnBook(sc);
                    returnBookFinalOptions(sc);
                    break;
                case 3:
                    searchBook(sc);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } catch (WrongCredentialsException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void signUpSection(Scanner sc) {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        Librarian.addMember(id, password);
        System.out.println("New Member added Successfully");
    }

    private static void addBook(Scanner sc) {
        System.out.print("Book Title: ");
        String title = sc.nextLine();
        System.out.print("Author: ");
        String author = sc.nextLine();
        System.out.print("Quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        Librarian.addBook(title,author,quantity);
        System.out.println("This Book Has Been Added To Stock.");
    }

    private static void addMember(Scanner sc) {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        Librarian.addMember(id, password);
        System.out.println("New Member added Successfully");
    }

    private static void borrowBook(Scanner sc) {
        System.out.print("Your ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Book Title: ");
        String title = sc.nextLine();
        System.out.print("Date: ");
        String date = sc.nextLine();

        try {
            Book.isAvailable(title);
            Book.addToBorrowList(id, title, date);
            Book.lessenQuantityAfterBorrowing(title);
            System.out.println("Book titled " + title + " has been borrowed.");
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            borrowBookFinalOptions(sc);
        }
    }

    private static void returnBook(Scanner sc) {
        System.out.print("Your ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Book Title: ");
        String title = sc.nextLine();
        System.out.print("Date: ");
        String date = sc.nextLine();

        int days = Book.totalBorrowDays(id, date, title);
        Book.removeFromBorrowList(id, title);
        Book.addToStock(title);

        if (days > 15) {
            int fine = Book.fine(days - 15);
            System.out.println("You Have Been Fined " + fine + " Tk. For Returning Late");
        } else {
            System.out.println("Book titled " + title + " has been returned");
        }

        returnBookFinalOptions(sc);
    }

    private static void searchBook(Scanner sc) {
        System.out.print("Book Title: ");
        String title = sc.nextLine();
        System.out.print("Author: ");
        String author = sc.nextLine();

        try {
            Book.searchBook(title, author);
            System.out.println(title + " is available");
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            searchBookFinalOptions(sc);
        }
    }

    private static void librarianFinalOptions(Scanner sc) {
        System.out.print("1. Return To Main Menu\n2. Add Member\n3. Add Book\n4. Exit\nSelect an Option: ");
        int option = sc.nextInt();
        sc.nextLine();
        if (option == 4) {
            System.exit(0);
        } else if (option == 2) {
            addMember(sc);
        } else if (option == 3) {
            addBook(sc);
        }
    }

    private static void borrowBookFinalOptions(Scanner sc) {
        System.out.print("1. Return To Main Menu\n2. Search Book\n3. Exit\nSelect an Option: ");
        int option = sc.nextInt();
        sc.nextLine();
        if (option == 3) {
            System.exit(0);
        } else if (option == 2) {
            searchBook(sc);
        }
    }

    private static void returnBookFinalOptions(Scanner sc) {
        System.out.print("1. Return To Main Menu\n2. Borrow Book\n3. Search Book\n4. Exit\nSelect an Option: ");
        int option = sc.nextInt();
        sc.nextLine();
        if (option == 4) {
            System.exit(0);
        } else if (option == 2) {
            borrowBook(sc);
        }
    }

    private static void searchBookFinalOptions(Scanner sc) {
        System.out.print("1. Return To Main Menu\n2. Exit\nSelect an Option: ");
        int option = sc.nextInt();
        sc.nextLine();
        if (option == 2) {
            System.exit(0);
        }
    }
}
