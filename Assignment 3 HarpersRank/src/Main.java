import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

        // Existing player's ranks
        int[] rankOfPlayers = {20, 5, 28, 67, 44};

        // Harper's rank
        int rankOfHarper = 12;

        int harperRank = findHarperRank(rankOfPlayers, rankOfHarper);
        System.out.println("Harper's rank in the club: " + harperRank);

    }

    public static int findHarperRank(int[] rankOfPlayers, int rankOfHarper) {

        if (rankOfPlayers == null || rankOfPlayers.length == 0) {
            // If the array is empty, directly return harperRank
            return rankOfHarper;
        }
        // Create a Min Heap using Priority Queue to store the existing player's ranks
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add all existing player's ranks to the Min Heap
        for (int rank : rankOfPlayers) {
            minHeap.offer(rank);
        }

        // Add Harper's rank to the Min Heap
        minHeap.offer(rankOfHarper);

        // Find Harper's rank by removing all ranks smaller than rankOfHarper from the Min Heap
        while (!minHeap.isEmpty() && minHeap.peek() < rankOfHarper) {
            minHeap.poll();
        }

        // If the Min Heap is empty, Harper's rank is rankOfHarper
        // Otherwise, Harper's rank is the minimum rank remaining in the Min Heap
        return minHeap.isEmpty() ? rankOfHarper : minHeap.peek();
    }
}