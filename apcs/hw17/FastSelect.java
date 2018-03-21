// Aaron Li
// APCS2 pd8
// HW17 -- So So Fast
// 2018-03-09

public class FastSelect{

     public static int partition(int start, int end, int val, int[] arr) {
          int v = arr[val];
          int temp = arr[val];
          arr[val] = arr[end];
          arr[end] = temp;
          int s = start;
          for (int i = start; i < end; i++) {
               if (arr[i] < v) {
                    int temp2 = arr[s];
                    arr[s] = arr[i];
                    arr[i] = temp2;
                    s += 1;
               }
          }
          int temp3 = arr[end];
          arr[end] = arr[s];
          arr[s] = temp3;
          return s;
     }


     public static find(int start, int end, int val, int y, int[] arr) {
          int s = partition(start, end, val, arr);
          if (s == (y - 1)) {
               return arr[s];
          } if(s < y) {
               find(s + 1, arr.length, (arr.length - (s + 1)) / 2, y, arr);
          }
     }
}
