import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Partitioning {

    public boolean canPartition(int[] num, List<Integer> lst, List<Integer> finishList) {

        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }


        if (sum % 2 != 0) {
            return false;
        }


        return canPartitionRecursive(num, sum / 2, 0, lst, finishList);
    }


    private boolean canPartitionRecursive(int[] num, int sum, int currentIndex, List<Integer> lst, List<Integer> newList) {

        if (sum == 0) {
            if(lst.size() % 2 != 0){
                return false;
            }
            newList.addAll(lst);
            return true;
        }


        if(num.length == 0 || currentIndex >= num.length)
            return false;

        int listSize = lst.size();

        if( num[currentIndex] <= sum ) {
            lst.add(num[currentIndex]);
            if(canPartitionRecursive(num, sum - num[currentIndex], currentIndex + 1, lst, newList)) {
                return true;
            }
        }
        lst = lst.subList(0, listSize);

        // recursive call after excluding the number at the currentIndex
        return canPartitionRecursive(num, sum, currentIndex + 1, lst, newList);
    }

    public static void main(String[] args) {
        Partitioning ps = new Partitioning();
        int[] num = new int[]{16, 22, 35, 8, 20, 1, 21, 11};


        List<Integer> fullList = Arrays.stream(num).boxed().collect(Collectors.toList());
        List<Integer> sumList = new ArrayList<>();
        List<Integer> finishList = new ArrayList<>();
        boolean canPartition = ps.canPartition(num, sumList, finishList);
        if(canPartition) {
            fullList.removeAll(finishList);
            fullList.sort(Comparator.naturalOrder());
            finishList.sort(Comparator.naturalOrder());
            if(fullList.get(0) >= finishList.get(0)) {
                ps.printArrays(finishList, fullList);
            } else {
                ps.printArrays(fullList, finishList);
            }


        }



    }

    public void printArrays(List<Integer> arr, List<Integer> arr2) {
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + ",");
        }
        for(int i = 0; i < arr2.size(); i++) {
            if( i == arr2.size() - 1) {
                System.out.print(arr2.get(i));
            } else {
                System.out.print(arr2.get(i) + ",");
            }

        }

    }

}
