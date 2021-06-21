import java.util.Collections;
import java.util.List;

public class DefenderArcade {
    public int countArcades(List<String> times) {
        // declare arcade int variable for final data return
        int arcade = 1;

        // Calling function sortList below to sort the play time
        sortList(times);

        for (int i = 0; i < times.size(); i++) {

            // condition to prevent further logic inside from getting index
            // out of bound error
            if (i != times.size() - 1) {

                // declare 2 variable
                // 1.splitTime : to split current element to 2 array eg: ["0900","1000"]
                // 2.endTime : convert value to int from first value of splitTime array,
                // this value is the end play time by this current element eg:"1000"
                // 3.splitTimeNext: to split next element to 2 array eg : ["0930","1020"]
                // 4.startTimeNext: convert value to int from first value of splitTimeNext
                // array,
                // this value is the start play time by next element eg:"1000"
                String[] splitTime = times.get(i).split(" ");
                int endTime = Integer.parseInt(splitTime[1]);
                String[] splitTimeNext = times.get(i + 1).split(" ");
                int startTimeNext = Integer.parseInt(splitTimeNext[0]);

                // give condition if current end play time is greater than next element start
                // time
                // then it means 2 player will fight, so add more DefenderArcade unit
                if (endTime > startTimeNext) {

                    // increment arcade value, represent number of defender arcade unit
                    arcade++;
                }

            }
        }
        // returning value of arcade int, the final number of defender arcade unit
        // needed
        return arcade;
    }

    // function to sort the list based on after time to int conversion
    public static void sortList(List<String> list) {

        for (int i = 0; i < list.size(); i++) {

            // declare 2 variable
            // 1.splitTime : to split array to 2 array eg: ["0900","1000"]
            // 2.time : convert value from first value of splitTime array
            String[] splitTime = list.get(i).split(" ");
            int time = Integer.parseInt(splitTime[0]);

            // condition to prevent further logic inside from getting index
            // out of bound error
            if (i != list.size() - 1) {

                // declare 2 variable
                // 1.splitTime : to split array to 2 array eg: ["0900","1000"]
                // 2.time : convert value from first value of splitTime array
                String[] splitTimeNext = list.get(i + 1).split(" ");
                int timeNext = Integer.parseInt(splitTimeNext[0]);

                // condition when current start play time value is greater than next start play
                // time
                if (time > timeNext) {

                    // swapping next value/element in list with current value/element
                    Collections.swap(list, i + 1, i);
                }
            }
        }

    }
}
