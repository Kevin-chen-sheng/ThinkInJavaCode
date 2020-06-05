public static int zuHeUniquePaths1(int s,int d){
        long res=1;
        for (int i = 1; i <= d; i++) {
            res=res*(s-d+i)/i;
        }
        return (int) res;
}
