package correct;

/**
 * @date Oct 3, 2010
 * @author Willem Mouwen <w.mouwen@student.tue.nl>
 */

import java.util.* ;

public class SettlersOfCatan {

    Scanner scanner ;

    int[][] board ;
    int[] tiles ;
    int tile ;
    int direction ;
    int[] input ;
    int inputMax = 0 ;
    int x, y ;
    ArrayList<Integer> possible ;
    int newNum = 0 ;
    int[] count = new int[6] ;

    void build () {
        scanner = new Scanner(System.in) ;

        input = new int[scanner.nextInt()] ;

        for (int i = 0 ; i < input.length ; i++) {
            input[i] = scanner.nextInt() ;
            if (input[i] > inputMax) {
                inputMax = input[i] ;
            }
        }

        board = new int[2002][2002] ;
        tiles = new int[inputMax + 1] ;
        direction = 5 ;
        x = y = 1000 ;

        for (tile = 1 ; tile <= inputMax ; tile++) {
            checkPossibleNumbers() ;

            if (possible.size() > 1) {
                checkLessUsed() ;
            }

            newNum = getLowestNumberPossible() ;
            
            board[x][y] = newNum ;
            tiles[tile] = newNum ;

            count[newNum]++ ;

            if (direction < 2) {
                if (board[x - 1][y + 1] < 1) {
                    direction = 2 ; x-- ; y ++ ;
                } else if (board[x][y + 2] < 1) {
                    direction = 1 ; y += 2 ;
                } else {
                    direction = 0 ; x++ ; y++ ;
                }

            } else if (direction == 2) {
                if (board[x - 1][y - 1] < 1) {
                    direction = 3 ; x-- ; y-- ;
                } else {
                    direction = 2 ; x-- ; y ++ ;
                }

            } else if (direction < 5) {
                if (board[x + 1][y - 1] < 1) {
                    direction = 5 ; x++ ; y-- ;
                } else if (board[x][y - 2] < 1) {
                    direction = 4 ; y -= 2 ;
                } else {
                    direction = 3 ; x-- ; y-- ;
                }
                
            } else {
                if (board[x + 1][y + 1] < 1) {
                    direction = 0 ; x++ ; y++ ;
                } else {
                    direction = 5 ; x++ ; y-- ;
                }
            }
        }

        for (int output : input) {
            System.out.println(tiles[output]) ;
        }

        return ;
    }

    void checkPossibleNumbers () {
        possible = new ArrayList<Integer>() ;

        for (int i = 1 ; i <= 5 ; i++) {
            possible.add(i) ;
        }

        if (possible.contains(board[x - 1][y + 1])) {
            possible.remove(new Integer(board[x - 1][y + 1])) ;
        }
        if (possible.contains(board[x - 1][y - 1])) {
            possible.remove(new Integer(board[x - 1][y - 1])) ;
        }

        if (possible.contains(board[x][y + 2])) {
            possible.remove(new Integer(board[x][y + 2])) ;
        }
        if (possible.contains(board[x][y - 2])) {
            possible.remove(new Integer(board[x][y - 2])) ;
        }

        if (possible.contains(board[x + 1][y + 1])) {
            possible.remove(new Integer(board[x + 1][y + 1])) ;
        }
        if (possible.contains(board[x + 1][y - 1])) {
            possible.remove(new Integer(board[x + 1][y - 1])) ;
        }

        return ;
    }

    void checkLessUsed () {
        ArrayList<Integer> oldPossible = possible ;
        possible = new ArrayList<Integer>() ;

        int lowestCount = -1 ;
        for (int number : oldPossible) {
            if (count[number] < lowestCount || lowestCount == -1) {
                lowestCount = count[number] ;
            }
        }
        
        for (int number : oldPossible) {
            if (count[number] == lowestCount) {
                possible.add(number) ;
            }
        }
    }

    int getLowestNumberPossible () {
        Integer[] sorting = new Integer[possible.size()] ;
        
        sorting = possible.toArray(sorting) ;

        Arrays.sort(sorting) ;

        return sorting[0] ;
    }

    public static void main (String[] args) {
        new SettlersOfCatan().build() ;
    }
}
