import java.util.Collections;
import java.util.List;

public class RoyalRumble {
  public List<String> getSortedList(List<String> names) {
    // Existing function to sort list based on first character/value in the list
    Collections.sort(names);

    for (int i = 0; i < names.size(); i++) {
      // These 3 variables is to contain each value of :
      // 1.splitValue : array of string from splitting value from names list eg:David
      // I to [David,I]
      // 2.valueNow : get value from converting romans numeric to int using romanToInt
      // function
      String[] splitValue = names.get(i).split(" ");
      // char firstChar = splitValue[0].charAt(0);
      int valueNow = romanToInt(splitValue[1]);

      // condition to prevent further logic inside from getting index out of bound
      // error
      if (i != names.size() - 1) {

        // comparing first char of current element and next element of names list
        if (names.get(i).charAt(0) == names.get(i + 1).charAt(0)) {

          // These 2 variables is to contain each value of :
          // 1.splitNextValue : array of string from splitting value from next element in
          // names list eg:David I to [David,II]
          // 2.valueNext : get value from converting next element romans numeric to int
          // using romanToInt function
          String[] splitNextValue = names.get(i + 1).split(" ");
          int valueNext = romanToInt(splitNextValue[1]);

          // comparing currenct int value and next int value of romans numeric
          // if current value is bigger than next value will execute logic inside if
          // statement
          if (valueNow > valueNext) {

            // swap next element with current element
            Collections.swap(names, i + 1, i);
          }
        }
      }

    }
    // returning sorted names list
    return names;
  }

// source of this function https://dev.to/seanpgallivan/solution-roman-to-integer-567f
  public int romanToInt(String S) {
    // declare 2 temporary int variable for further logic
    int ans = 0, num = 0;

    // set reverse looping/backward loop and reduce i value by 1 to prevent index
    // out of bound error
    for (int i = S.length() - 1; i >= 0; i--) {

      // assign variable num value according each case
      switch (S.charAt(i)) {
        case 'I':
          num = 1;
          break;
        case 'V':
          num = 5;
          break;
        case 'X':
          num = 10;
          break;
        case 'L':
          num = 50;
          break;
      }
      // set condition if num * 4 is lesser than ans variable
      if (4 * num < ans)
        ans -= num;
      else
        ans += num;
    }
    // returning ans variable
    return ans;
  }

}
