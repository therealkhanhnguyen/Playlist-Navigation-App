import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> playList = new LinkedList<>();

        playList.add("Bohemian Rhapsody");
        playList.add("Stairway to Heaven");
        playList.add("Hotel California");
        playList.add("Imagine");
        playList.add("Lose Yourself");

        ListIterator<String> iterator = playList.listIterator();

        printMenu();

        boolean running = true;
        boolean goingForward = true;
        while (running) {

            int option = -1;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }

            switch (option) {
                case 0:
                    System.out.println("Goodbye");
                    running = false;
                    break;
                case 1:
                    //check iterator
                    if(!goingForward) {
                        if(iterator.hasNext()) {
                            iterator.next();
                        }
                        goingForward = true;
                    }
                    //now move to the next song
                    if (iterator.hasNext()) {
                        System.out.println("Now playing: " + iterator.next());
                    } else {
                        System.out.println("You have reached the end of the playlist");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if(goingForward) {
                        if(iterator.hasPrevious()) {
                            iterator.previous();
                        }
                        goingForward = false;
                    }
                    if (iterator.hasPrevious()) {
                        System.out.println("Now playing: " + iterator.previous());
                    } else {
                        System.out.println("You have reached the start of the playlist");
                        goingForward = true;
                    }
                    break;
                case 3:
                    if(goingForward) {
                        if(iterator.hasPrevious()) {
                            System.out.println("Replaying: " + iterator.previous());
                            goingForward = false;
                        } else {
                            System.out.println("You have reached the start of the playlist");
                        }
                    } else {
                        if(iterator.hasNext()) {
                            System.out.println("Replaying: " + iterator.next());
                            goingForward = true;
                        } else {
                            System.out.println("You have reached the end of the playlist, can't replay");
                        }
                    }
                    break;
                case 4:
                    printMenu();
                    break;
                default:
                    System.out.println("Invalid option");
            }


        }
    }

    public static void printMenu(){
        System.out.println("\nMenu Options:");
        System.out.println("0 - Quit");
        System.out.println("1 - Next Song");
        System.out.println("2 - Previous Song");
        System.out.println("3 - Replay Current Song");
        System.out.println("4 - Show Menu Again\n");
        System.out.print("Your Choice: ");
    }
}
