public class CelebrityProblem {

    public static int celebrity(int[][] M) {

        int n = M.length;

        int top = 0;
        int down = n - 1;

        while (top < down) {

            if (M[top][down] == 1)
                top++;
            else
                down--;
        }

        int candidate = top;

        for (int i = 0; i < n; i++) {

            if (i != candidate) {

                if (M[candidate][i] == 1 || M[i][candidate] == 0)
                    return -1;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {0, 1, 1},
                {0, 0, 0},
                {0, 1, 0}
        };

        System.out.println(celebrity(matrix));
    }
}