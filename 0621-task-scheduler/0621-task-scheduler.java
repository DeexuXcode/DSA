class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int f : freq) {
            if (f > 0) {
                pq.add(f);
            }
        }

        int time = 0;

        while (!pq.isEmpty()) {
            int cycle = n + 1;
            int executed = 0;
            int[] temp = new int[26];
            int index = 0;

            while (cycle > 0 && !pq.isEmpty()) {
                int current = pq.poll();
                current--;
                temp[index++] = current;
                executed++;
                cycle--;
            }

            for (int i = 0; i < index; i++) {
                if (temp[i] > 0) {
                    pq.add(temp[i]);
                }
            }

            if (!pq.isEmpty()) {
                time += n + 1;
            } else {
                time += executed;
            }
        }

        return time;
    }
}