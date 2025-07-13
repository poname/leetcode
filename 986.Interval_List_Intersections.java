// time: O(m+n)
// space: O(1)
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        List<int[]> overlap = new ArrayList<>();
        while (i < firstList.length && j < secondList.length) {
            int[] A, B; // A starts before (or with) B
            if (firstList[i][0] <= secondList[j][0]) {
                A = firstList[i];
                B = secondList[j];
            } else {
                B = firstList[i];
                A = secondList[j];
            }
            // overlap detected
            if (A[1] >= B[0]) {
                overlap.add(new int[]{B[0], Math.min(A[1], B[1])});
            }
            // shift one interval
            if (firstList[i][1] <= secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return overlap.toArray(new int[overlap.size()][]);
    }
}

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int fi = 0;
        int si = 0;
        List<int[]> overlap = new ArrayList<>();
        while (fi < firstList.length && si < secondList.length) {
            if (firstList[fi][0] <= secondList[si][0] && firstList[fi][1] >= secondList[si][0]) {
                overlap.add(new int[] {
                        Math.max(firstList[fi][0], secondList[si][0]),
                        Math.min(firstList[fi][1], secondList[si][1])
                });
            } else if (firstList[fi][0] >= secondList[si][0] && firstList[fi][0] <= secondList[si][1]) {
                overlap.add(new int[] {
                        Math.max(firstList[fi][0], secondList[si][0]),
                        Math.min(firstList[fi][1], secondList[si][1])
                });
            }
            if (firstList[fi][1] <= secondList[si][1]) {
                fi++;
            } else {
                si++;
            }
        }
        return overlap.toArray(new int[overlap.size()][]);
    }
}
