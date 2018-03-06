package mcts;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;




public class UCT {

    public static double uctValue(int totalVisit, double nodeWinScore, int nodeVisit) {
        if (nodeVisit == 0) {
            return Integer.MAX_VALUE;
        }
       // System.out.print("     score="+(nodeWinScore / (double) nodeVisit) + 1.41 * Math.sqrt(Math.log(totalVisit) / (double) nodeVisit));
        return (nodeWinScore / (double) nodeVisit) + 1.41 * Math.sqrt(Math.log(totalVisit) / (double) nodeVisit);
    }

    static Node findBestNodeWithUCT(Node node) {
    System.out.println("find best node");
        int parentVisit = node.getState().getVisitCount();
        return Collections.max(
          node.getChildArray(),
          Comparator.comparing(c -> uctValue(parentVisit, c.getState().getWinScore(), c.getState().getVisitCount() )));
   
    }
    public static void afficheBestNodeWithUCT(Node node) {
        int parentVisit = node.getState().getVisitCount();
        int cp1=1;
        		
        List<Node> root1= node.getChildArray();
        root1.forEach(p -> {System.out.println("fils n"+cp1+"score:" +uctValue(parentVisit,p.getState().getWinScore(),p.getState().getVisitCount()));
        });
        
    }
}
