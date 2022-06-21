import java.util.ArrayList;

public class Grid {
    private int[][] g;
    private int x;
    private int y;
    ArrayList<String> path = new ArrayList<String>(); // Create an ArrayList object

    //Initialise the grid    0= Empty   1=Taken  2=Obstacle 3=Finish
    public Grid(int x,int y){
        g=new int[12][12];
        this.x=x;
        this.y=y;

        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                g[i][j]=0;
            }
        }
        g[x-1][y-1]=3;
        g[0][0]=0;

    }
    public void PrintGrid(){
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                System.out.print(g[i][j]);
            }
            System.out.println("");
        }
    }

    //setter for g variable
    public boolean AddObstactle(int row,int column){
        if ((column==0 && row==0 )|| (g[column][row]==3) || (g[column][row]==2)) {
            System.out.println("Can't place Obstacle Here!");
            return false;
        }else{
            //Row and column is flipped
//            System.out.println("x value :"+row+"y value:"+column);
            g[column][row]=2;
//            PrintGrid();
            return true;
        }

    }


    public void GetToEnd(){
        int sX=0;  //Start x and Start y
        int sY=0;
        int temp=-1;
        // When Outputting Path the sY and sX are reversed to corrospond to the row and column.
        while (sX!=(this.x-1) || sY!=(this.y-1)){
            System.out.println(sX);
            System.out.println(sY);

            System.out.println("The paths are"+path);
            PrintGrid();
            //Move Diagonally
            if( g[sX+1][sY+1]!=2 && (sX+1)!=x && (sY+1)!=y){
                temp=-1;
                System.out.println("Help3!");

                sX++;
                sY++;
                g[sX][sY]=1;
                path.add("("+sY+","+sX+")");
            }
            //Move Down
            else if(g[sX+1][sY]!=2 && (sX+1)!=x){
                temp=-1;

                System.out.println("Help2!");
                sX++;
                g[sX][sY]=1;

                path.add("("+sY+","+sX+")");
            }
            //Move right
            else if(g[sX][sY+1]!=2 && (sY+1)!=y){
                temp=-1;
                System.out.println("Help!");
                sY++;
                g[sX][sY]=1;

                path.add("("+sY+","+sX+")");

            }
            //Move Up
            else if(g[sX][sY-1]!=2 && (sY-1)!=-1){
                temp=2;
                sY--;
                g[sX][sY]=1;

                path.add("("+sY+","+sX+")");

            }
            //Move Left
            else if(g[sX-1][sY]!=2 && (sX-1)!=-1){
                temp=3;
                sX--;
                g[sX][sY]=1;

                path.add("("+sY+","+sX+")");

            }
            //Move Diagonally back
            else if(g[sX-1][sY-1]!=2 && (sY-1)!=-1 && (sX-1)!=-1){
                temp=1;
                sY--;
                sX--;
                path.add("("+sY+","+sX+")");

            }

          else{
                System.out.println("Unable to reach delivery point!");
                return;
            }

        }

        System.out.println("The paths are"+path);
        System.out.println("The size is"+path.size());
    }

}


