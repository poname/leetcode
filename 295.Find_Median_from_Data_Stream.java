class MedianFinder {
    Queue<Integer> max;
    Queue<Integer> min;

    public MedianFinder() {
        max = new PriorityQueue<Integer>(Collections.reverseOrder());
        min = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        max.add(num);

        if (max.size()>0 && min.size()>0 && max.peek()>min.peek()) {
            min.add(max.poll());
        }

        if (max.size() - min.size() > 1) {
            min.add(max.poll());
        }

        if (min.size() - max.size() > 1) {
            max.add(min.poll());
        }
    }
    
    public double findMedian() {
        if (max.size() > min.size()) {
            return max.peek();
        } else if (max.size() < min.size()) {
            return min.peek();
        } else {
            return (max.peek() + min.peek()) / 2.0;
        }
    }
}
