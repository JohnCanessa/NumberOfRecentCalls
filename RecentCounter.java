import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 * 
 */
class RecentCounter {

    // **** members ****
    Queue<Integer> q = null;
    

    /**
     * Constructor
     */
    public RecentCounter() {
        this.q = new LinkedList<Integer>();
    }


    /**
     * Return the number of pings that have been made from 
     * 3000 milliseconds ago until now.
     *
     * t represents some time in milliseconds.
     */
    public int ping(int t) {

        // **** add ping to the head of the queue ****
        this.q.add(t);

        // ???? ????
        // System.out.println("\nping <<< q: " + q.toString());

        // **** remove pings(s) from the tail of the queue ****
        while (q.peek() < (t - 3000)) {
            this.q.remove();
        }

        // ???? ????
        // System.out.println("ping <<< q: " + q.toString());

        // **** return the number of elements in the queue ****
        return this.q.size();
    }
}


/**
 * Test scaffolding.
 */
class Solution {

    /**
     * Test scaffolding.
     */
    public static void main(String[] args) {
        
        // **** open scanner ****
        Scanner sc = new Scanner(System.in);

        // **** read list of calls ****
        String[] calls = sc.nextLine().split(" ");

        // **** read list of arguments for calls ****
        String[] times = sc.nextLine().split(" ");

        // **** instantiate RecentClass object ****
        RecentCounter obj = new RecentCounter();

        // **** loop making the calls ****
        int i = 0;
        for (String call : calls) {

            // **** skip if not a ping ****
            if (!call.equals("ping")) {
                System.out.print("null ");
            } else {

                // **** convert string to binary ****
                int t = Integer.parseInt(times[i]);

                // **** issue ping call ****
                int count = obj.ping(t);

                // **** display count ****
                System.out.print(count + " ");
            }

            // **** increment index ****
            i++;
        }

        // **** close scanner ****
        sc.close();
    }

}