import java.util.Random;

public class PathFinder {
    public static void main(String[] args) {
        Grid g=new Grid(10,10); //10 x 10 grid
        boolean b=false;
        g.AddObstactle(9,7);
        g.AddObstactle(8,7);
        g.AddObstactle(6,7);
        g.AddObstactle(6,8);
        g.PrintGrid();
        System.out.println("\n");
        Random rand = new Random();
        //Add 20 Random Obstacles
        for(int i=0;i<20;i++){
            b=false;
            while (!b){
                int n = rand.nextInt(10);
                int j=rand.nextInt(10);
                if (g.AddObstactle(n, j)){
                    b=true;
                    g.AddObstactle(n,j);
                }
            }
        }
        g.PrintGrid();
        System.out.println("\n");
        g.GetToEnd();
        System.out.println("\n");
        g.PrintGrid();

    }
}
