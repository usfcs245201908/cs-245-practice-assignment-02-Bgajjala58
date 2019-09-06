class NQueens{

private int n;
private int [][] board;

public NQueens (int n){
	this.n = n;
	board = new int [n][n];

}


public boolean placeNQueens(){

		//Cannot be 0 or lower
		if(n <= 0){
			System.out.println("Cannot use value 0 or lower");
			throw new ArithmeticException("not valid");
		}

		//If we cant place any queens then it returns false 
        if (solve(0) == false) {  // start at column 0 (first queen)
            System.out.println("Not Possible"); 
            return false; 
        } 
  
        printToConsole(); 
        return true; 
    } 



public boolean solve(int col){

	//Base case - if it goes through all the columns then all queens are placed so return true
      if (col >= n) { 
            return true; 
      }
  
        
        for (int i = 0; i < n; i++) { 
            //To check if we can place it
            if (safe(i, col)) { 
                /* Place this queen in board[i][col] */
                board[i][col] = 1; 
  
                //moving up one column
                if (solve(col + 1) == true) {
                    return true; 
                }
 	
 				//if next column nothing can be placed then take the colum and row before and erase (try to replace torow +1)
                board[i][col] = 0;
            
		} 
}

//if the first one runs out of rows, then it dosent work
return false; 
}


private boolean safe(int row ,int col){


	int col1 = col;

	

	for(int i = 0; i < col;i++){ //check top
		if(board[row][i] == 1){
			return false;
		}
	}

	firstloop: for(int i = row; i >=0;i--){ //left diagonal check

		if(col1 <0){
			break firstloop;
		}
		
		if(board[i][col1] == 1){
			return false;
		}
		col1 --;
	

	}

	secondloop: for(int i = row; i < n;i++){ //right diagonal check

		if(col <0){
			break secondloop;
		}
		
		if(board[i][col ] == 1){
			return false;
			
		
	}
	col --;

	}







	return true;


	 
 

  
} 

	




 void printToConsole() 
    { 
        for (int i = 0; i < n; i++) { 
            for (int a = 0; a < n; a++) {

            	if(board[i][a] == 1){
            	System.out.print(" " + "Q" + " "); 

            	}else{
                System.out.print(" " + "-" + " "); 
            }
            
        } 
        System.out.println(); 
    } 


}
}







