class Solution {
    public boolean exist(char[][] board, String word) {
        
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                    if(searchChar(board,word,i,j,0, visited))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    boolean searchChar(char[][] board, String word, int i, int j, int x, boolean[][] visited)
    {
        if(x == word.length())
        {
            return true;
        }

        if( (i >= board.length) || (i < 0) ||
            (j >= board[0].length) || (j < 0) || 
            (board[i][j] != word.charAt(x)) || 
            visited[i][j] )
        {
            return false;
        }


        visited[i][j] = true;

        if( searchChar(board,word,i+1,j,x+1,visited) || 
            searchChar(board,word,i-1,j,x+1,visited) ||
            searchChar(board,word,i,j+1,x+1,visited) || 
            searchChar(board,word,i,j-1,x+1,visited)    )
        {
            return true;
        }

        visited[i][j] = false;
        
        return false;
    }

}