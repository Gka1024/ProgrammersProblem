public class main
{
    public static int friends4block(int m, int n, String[] board)
    {
        char[][] table = new char[m][n];
        boolean[][] isSame = new boolean[m][n];
        int score = 0;
        boolean flag = false;
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                table[i][j] = board[i].charAt(j);
            }  
        }    

        while(true)
        {
            for(int i = 0; i < m-1; i++)
        {
            for(int j = 0; j < n - 1; j++)
            {
                if(table[i][j] != 'O' && table[i][j] == table[i][j + 1] && table[i][j] == table[i + 1][j] && table[i][j] == table[i + 1][j + 1])
                {
                    flag = true;
                    isSame[i][j] = true;
                    isSame[i + 1][j] = true;
                    isSame[i][j + 1] = true;
                    isSame[i + 1][j + 1] = true;
                }
            }
        }

        if(flag == false)
        {
            break;
        }
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(isSame[i][j])
                {
                    score++;
                    table[i][j] = 'O';
                }
            }
        }

        char tempchar;

        for(int i = m - 2; i >= 0; i--)
        {
            for(int j = 0; j < n; j++)
            {
                if(table[i][j] != 'O' && table[i + 1][j] == 'O')
                {
                    int depth = 0;

                    for(int k = i+1; k < m; k++)
                    {
                        if(table[k][j] != 'O')
                        {
                            depth = k-1;
                            break;
                        }
                    }

                    if(depth == 0)
                    {
                        depth = m-1;
                    }

                    tempchar = table[i][j];
                    table[i][j] = 'O';
                    table[depth][j] = tempchar;
                }
            }
        }

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                isSame[i][j] = false;
            }
        }

        flag = false;
        }

        return score;
    }  
  
    public static void main(String[] args)
    {
        int m = 4, n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"}
    }
}
