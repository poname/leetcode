class Solution {
    public int leastInterval(char[] tasks, int n) {
        Queue<Task> maxHeap = new PriorityQueue<>((x, y) -> y.count-x.count);
        Queue<Task> wait = new PriorityQueue<>((x, y) -> x.next-y.next);
        Map<Character, Task> counter = new HashMap<>();
        for (char t : tasks) {
            counter.putIfAbsent(t, new Task(t, 0, 0));
            Task task = counter.get(t);
            task.count++;
        }
        for (Task t : counter.values()) {
            maxHeap.add(t);
        }
        int time = 0;
        while (maxHeap.size() > 0 || wait.size() > 0) {
            if (maxHeap.size() > 0) {
                Task curr = maxHeap.remove();
                curr.next = time+n+1;
                curr.count--;
                if (curr.count > 0) {
                    wait.add(curr);
                }
                // System.out.print(curr.id + " ");
            } else {
                // System.out.print("idle ");
            }
            while (wait.size() > 0 && wait.peek().next <= time+1) {
                maxHeap.add(wait.remove());
            }
            time++;
        }
        return time;
    }
}
class Task {
    final char id;
    int next;
    int count;
    public Task(char id, int next, int count) {
        this.id = id;
        this.next = next;
        this.count = count;
    }
}
