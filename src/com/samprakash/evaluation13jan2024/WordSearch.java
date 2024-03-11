package com.samprakash.evaluation13jan2024;

public class WordSearch {

    public static boolean searchWord(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        // Iterate through each cell in the board
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the current cell matches the first character of the word
                if (board[i][j] == word.charAt(0)) {
                    // Check in all possible directions
                    if (search(board, word, i, j, 0,new boolean[rows][cols])) {
                        return true; // Word found
                    }
                }
            }
        }

        return false; // Word not found in the entire board
    }

    private static boolean search(char[][] board, String word, int row, int col, int index,boolean [][] visited) {
        // If the entire word is found
        if (index == word.length()) {
            return true;
        }

        // Check if the current position is out of bounds or the character does not match
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index) ||visited[row][col]) {
            return false;
        }

        // Mark the current cell as visited
       // char temp = board[row][col];
       // board[row][col] = '*';
        visited [row][col] = true;
        // Recursively search in all four directions
        boolean found = search(board, word, row + 1, col, index + 1,visited) ||
                        search(board, word, row - 1, col, index + 1,visited) ||
                        search(board, word, row, col + 1, index + 1,visited) ||
                        search(board, word, row, col - 1, index + 1,visited);

        // Restore the original value of the cell
       // board[row][col] = temp;
        visited [row][col] = false;
        return found;
    }

    public static void main(String[] args) {
        char[][] board = {
        		{'D','D','D','G','D','D'},

                {'B','B','D','E','B','S'},

                {'B','S','K','E','B','K'},

                {'D','D','D','D','D','E'},

                {'D','D','D','D','D','E'},

                {'D','D','D','D','D','G'},
        };

        String word1 = "GEEKS";
        String word2 = "SEE";
        String word3 = "ABCB";

        System.out.println(searchWord(board, word1)); // true
        System.out.println(searchWord(board, word2)); // true
        System.out.println(searchWord(board, word3)); // false
    }
}

