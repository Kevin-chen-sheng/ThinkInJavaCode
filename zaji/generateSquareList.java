/**
     * 制造平方数
     * @param n
     * @return
     */
    private List<Integer> generateSquareList(int n){
        List<Integer> squareList = new ArrayList<>();
        int diff=3;
        int square=1;
        while (square<=n){
            squareList.add(square);
            square+=diff;
            diff+=2;
        }
        return squareList;
    }
