import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


/*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ 
******************************开始写代码******************************/
    static int Max=0;
    static int maxAreaOfIsland(int[][] grid) {
        for (int i=0;i<grid.length;i++){
            for (int j=0; j<grid[0].length;j++){
                if (grid[i][j]==1){
                    dfs (grid,i,j);
                }
            }
        }
        return Max;
    

    }
    static int dfs(int[][]grid,int curX,int curY){
        if (curX<0||curX>=grid.length||curY<0||curY>=grid[0].length||grid[curX][curY]==0){
            
    return 0;
        }
        grid[curX][curY]=0;
        int[]dx={1,-1,0,0};
        int[]dy={0,0,1,-1};
        int area=1;
        for (int i=0;i<4;i++){
            area+=dfs(grid,curX+dx[i],curY+dy[i]);
        }
        Max=Math.max(area,Max);
        return area;
    }
    

/******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;
    
        int _grid_rows = 0;
        int _grid_cols = 0;
        _grid_rows = Integer.parseInt(in.nextLine().trim());
        _grid_cols = Integer.parseInt(in.nextLine().trim());
        
        int[][] _grid = new int[_grid_rows][_grid_cols];
        for(int _grid_i=0; _grid_i<_grid_rows; _grid_i++) {
            for(int _grid_j=0; _grid_j<_grid_cols; _grid_j++) {
                _grid[_grid_i][_grid_j] = in.nextInt();
                
            }
        }
        
        if(in.hasNextLine()) {
          in.nextLine();
        }
  
        res = maxAreaOfIsland(_grid);
        System.out.println(String.valueOf(res));    

    }
}