package others;

/**
 * 国王与金矿
 * @author kp1nz
 * @create 2019-04-01 12:42
 */
public class GetMostGlod {
    public static void main(String[] args) {
        int[] g = new int[]{500,400,350,300,200};
        int[] p = new int[]{5,5,3,4,3};
        System.out.println(getMostGlod(5, 10, g, p));

    }

    /**
     *
     * @param n 金矿数
     * @param w 工人数
     * @param g 金矿的黄金量
     * @param p 金矿的用工量
     * @return
     */
    public static int getMostGlod(int n ,int w ,int[] g,int[] p){

        int[] perResults =new int [p.length];
        int[] results =new int [p.length];

        for(int i=0;i<n;i++){
            if(i<p[0]){
                perResults[i]=0;
            }else {
                perResults[i]=g[0];
            }
        }

        for (int i = 0;i<n;i++){
            for (int j = 0;j<w;j++){
                if(j<p[i]){
                    results[j]=perResults[j];
                }else {
                    results[j] =Math.max(perResults[j],perResults[j-p[i]]+g[i]);
                }
            }
            perResults =results;
        }return results[n];
    }
}
