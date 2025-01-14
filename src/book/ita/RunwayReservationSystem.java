package book.ita;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class RunwayReservationSystem {
	/*
	- Sorted linked list: Adding element at the end and sorting takes O(n lg n) time. We can insert the time
	rather than appending it, but it takes O(n) time.
	- Sorted array: we can do binary serach to find insertion point in O(lg n) time, but inserting takes O(n) time.
	- Unsorted list: time to check for k minute takes O(n)
	- Min heap: we can insert in O(lg n), but k minute check takes O(n)
	- Dictionary/Map: we can insert in O(1) time, but k minute check takes O(n)
	- large array having all the minutes as index works, but it requires time in integer.
	We need fast insertion in sorted list.
	*/

    List<Integer> reservations = null;
    int k;

    public RunwayReservationSystem(int k) {
        reservations = new LinkedList<>();
        this.k = k;
    }

    public static void main(String[] args) {
        int k = 3;
        RunwayReservationSystem r = new RunwayReservationSystem(k);

        r.request(37);
        r.request(41);
        r.request(46);
        r.request(49);
        r.request(56);
        r.request(60);
        r.request(70);
        r.request(40); // conflicts with time 41
    }

    public void request(Integer t) {
        // time is already passed
        if (t < now()) {
            System.out.println(String.format("error: '%d' minutes are already passed", t));
            return;
        }

        for (int res : reservations) {
            // abs is necessary to check when t is less than the violating
            // reservation time.
            // e.g. t = 44. res = {40, 45}
            // 1. 44-40 = 4 which is greater than k
            // 2. 44-45 = -1 which is less than k (also abs(-1) < k)
            // e.g. t = 44. res = {40, 50}
            // 3. 44-50 = -10 which is less than k, but abs(-10) is greater than k
            if (Math.abs(t - res) < k) {
                System.out.println(String.format("error: requested time '%d' conflicts with landing time '%d'", t, res));
                return;
            }
        }

        // t can be reserved
        reservations.add(t);
        System.out.println(String.format("requested time '%d' is booked", t));
        Collections.sort(reservations);
    }

    public int now() {
        Date d = new Date();
        return d.getMinutes();
    }

    public void land() {
        // the first landing time will always be at zero index becuase of the sorted array,
        // so we don't need to search the reservations
        int t = reservations.get(0);
        int now = now();
        if (t != now) {
            System.out.println(String.format("There is no reservation to land at time '%d'", now));
            return;
        }

        // remove the time from reservations
        reservations.remove(t);
    }


}