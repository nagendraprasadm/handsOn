package org.nm.lc.hard;

import java.util.*;

public class NQueens51
{
    /**
     * Iterate over columns of current row for the first queen 0->n-1 (i)
     * Set Q in the array of available slots
     * mark all the col, row, cross cells
     * Mark all the row as booked
     * Mark all the col as booked
     * mark all the cross as booked
     * r +- 1, c +- 1
     * r +- 2, c +- 2....
     * if all queens are set
     * add the path to result.
     * Reset Q, all booked row, col and cross as was earlier
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens (int n)
    {
        char[][] board = new char[n][n];
        for(int i = 0; i< n; i++){
            Arrays.fill(board[i], '.');
        }
        List<List<String>> res = new ArrayList<>();
        rec(n, 1, res, board);
        return res;
    }

    public void rec (int n, int q, List<List<String>> res, char[][] board)
    {
        char bookchar = Integer.toString(q-1).toCharArray()[0];
        for (int i = 0; i < n; i++) {
            if (board[q - 1][i] == '.') {
                board[q - 1][i] = 'Q';
                if(q == n){
                    List<String> curRes = new ArrayList<>();
                    for(int k = 0; k < n ; k++){
                        char[] row = new char[n];
                        for(int l = 0; l < n; l++){
                            row[l] = (board[k][l] == 'Q' || board[k][l] == '.') ? board[k][l] : '.';
                        }
                        curRes.add(new String(row));
                    }
                    res.add(curRes);
                }else{
                    setTrack(n, q, board, bookchar, i);
                    rec(n ,q + 1, res, board);
                    resetTrack(q, board, bookchar);
                }

                board[q - 1][i] = '.';
            }
        }

    }

    private void setTrack (int n, int q, char[][] board, char bookchar, int i)
    {
        for(int k = 0; k < n; k++){
            if(isValid(q-1, k, board) && board[q - 1][k] == '.'){
                board[q - 1][k] = bookchar;
            }
            if(isValid(k, i,  board) &&  board[k][i] == '.'){
                board[k][i] = bookchar;
            }
        }
        for (int k = 1; k < n; k++) {

            if(isValid(q - 1+ k, i + k, board) && board[q -1 + k][i +k] == '.'){
                board[q -1 + k][i +k] = bookchar;
            }
            if(isValid(q - 1 - k, i + k, board) && board[q -1 - k][i +k] == '.'){
                board[q -1 + k][i +k] = bookchar;
            }

            if(isValid(q - 1+ k, i - k, board) && board[q -1 + k][i -k] == '.'){
                board[q -1 + k][i -k] = bookchar;
            }
            if(isValid(q - 1 - k, i - k, board) && board[q -1 - k][i -k] == '.'){
                board[q -1 + k][i -k] = bookchar;
            }
        }
    }

    private void resetTrack(int q, char[][] board, char bookchar){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == bookchar){
                    board[i][j] = '.';
                }
            }
        }
    }

    private boolean isValid (int r, int c, char[][] board)
    {
        return r >= 0 && c >= 0 && r < board.length && c < board.length;
    }
}
