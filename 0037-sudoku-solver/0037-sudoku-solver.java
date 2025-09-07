class Solution {
    int n = 3;
    int N = n * n;
    int[][] rows = new int[N][N + 1];
    int[][] columns = new int[N][N + 1];
    int[][] boxes = new int[N][N + 1];
    char[][] board;
    boolean sudokuSolve= false;

    public boolean couldPlace(int d, int r, int col) {
        int idx = (r / n) * n + col / n;
        return rows[r][d] + columns[col][d] + boxes[idx][d] == 0;
    }

    public void placeNumber(int d, int r, int col) {
        int idx = (r / n) * n + col / n;
        rows[r][d]++;
        columns[col][d]++;
        boxes[idx][d]++;
        board[r][col] = (char)(d + '0');
    }

    public void removeNumber(int d, int r, int col) {
        int idx = (r / n) * n + col / n;
        rows[r][d]--;
        columns[col][d]--;
        boxes[idx][d]--;
        board[r][col] = '.';
    }

    public void placeNextNumbers(int r, int col) {
        if (r == N - 1 && col == N - 1) sudokuSolved = true;
        else if (col == N - 1) backtrack(r + 1, 0);
        else backtrack(r, col + 1);
    }

    public void backtrack(int r, int col) {
        if (board[r][col] == '.') {
            for (int d = 1; d <= 9; d++) {
                if (couldPlace(d, r, col)) {
                    placeNumber(d, r, col);
                    placeNextNumbers(r, col);
                    if (!sudokuSolved) removeNumber(d, r, col);
                }
            }
        } else placeNextNumbers(r, col);
    }

    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (board[i][j] != '.') placeNumber(Character.getNumericValue(board[i][j]), i, j);
        backtrack(0, 0);
    }
}
