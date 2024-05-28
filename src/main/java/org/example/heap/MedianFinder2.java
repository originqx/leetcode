package org.example.heap;

import java.util.PriorityQueue;

public class MedianFinder2 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian()); // 输出 1.5
    }
}


class MedianFinder {

    PriorityQueue<Integer> maxPQ;

    PriorityQueue<Integer> minPQ;
    public MedianFinder() {
        maxPQ = new PriorityQueue<>((a, b) -> b - a);
        minPQ = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        if (maxPQ.isEmpty() || num <= maxPQ.peek()) {
            maxPQ.offer(num);
            if (minPQ.size() + 1 < maxPQ.size()) {
                minPQ.offer(maxPQ.poll());
            }
        }else{
            minPQ.offer(num);
            if (minPQ.size()  > maxPQ.size()) {
                maxPQ.offer(minPQ.poll());
            }
        }
    }

    public double findMedian() {
        if (maxPQ.size() > minPQ.size()) {
            return maxPQ.peek();
        }
        return (maxPQ.peek() + minPQ.peek()) / 2.0;
    }
}