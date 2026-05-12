class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer>ipos=new ArrayList<>();
        List<Integer>jpos=new ArrayList<>();
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==1){
                    ipos.add(i);
                    jpos.add(j);
                }
            }
        }
        int sum=0;
        Collections.sort(ipos);
        Collections.sort(jpos);
        int i=0,j=jpos.size()-1;
        while (i<j){
            sum+=ipos.get(j)-ipos.get(i);
            sum+=jpos.get(j)-jpos.get(i);
            j--;
            i++;
        }
        return sum;
    }
}