import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {  {1, 1, 1, 0, 1, 0, 1},
                            {1, 1, 1, 0, 1, 0, 1},
                            {0, 1, 1, 0, 0, 1, 1},
                            {1, 1, 1, 1, 1, 1, 0}};
        int[] start = {2, 1};
        int[] end = {0, 4};
        int[][] visit = new int[4][7];
        ArrayList<int[]> history = new ArrayList<>();
        System.out.printf(String.valueOf(matrix[0].length));
        initVisit(visit, matrix);
        history = searchRoute(start, end, visit, matrix, new ArrayList<>(), -1);
        for (int i = 0; i < history.size(); i++) {
            System.out.printf(history.get(i)[0]+","+history.get(i)[1]+(i == history.size() - 1 ? "" :"->"));
        }
    }

    private static ArrayList<int[]> searchRoute(int[] start, int[] end, int[][] visit, int[][] matrix, ArrayList<int[]> hist, int flag) {
        ArrayList<int[]> history = (ArrayList<int[]>) hist.clone();

        if (visit[start[0]][start[1]] == 1){
            System.out.printf("bug!");
            return history;
        }

        visit[start[0]][start[1]] = 1;// Visit start
        history.add(start);

        //1, 2, 3, 4 like up down left right
        if (flag == 1) {
            int next1 = searchLeft(start, visit, matrix);
            int next2= searchRight(start, visit, matrix);
            int next3 = searchTop(start, visit, matrix);
            ArrayList<int[]> h1 = new ArrayList<>();
            ArrayList<int[]> h2 = new ArrayList<>();
            ArrayList<int[]> h3 = new ArrayList<>();
            if (next1 == -1&&next2 == -1&& next3 == -1) {
                if (start[0] == end[0]&&start[1] == end[1]) {
                    return history;
                } else {
                    return new ArrayList<>();
                }
            }
            if (next1 != -1) {
                int[] newInt = new int[2];
                newInt[0] = start[0];
                newInt[1] = next1;
                h1 = searchRoute(newInt, end, getNewVisit(visit), matrix, history, 3);
            }
            if (next2 != -1) {
                int[] newInt = new int[2];
                newInt[0] = start[0];
                newInt[1] = next2;
                h2 = searchRoute(newInt, end, getNewVisit(visit), matrix, history, 4);
            }
            if (next3 != -1) {
                int[] newInt = new int[2];
                newInt[0] = next3;
                newInt[1] = start[1];
                h3 = searchRoute(newInt, end, getNewVisit(visit), matrix, history, 1);
            }
            return h3.size()>(h1.size()>h2.size()?h1:h2).size()?h3:(h1.size()>h2.size()?h1:h2);
        }
        if (flag == 2) {
            int next1 = searchLeft(start, visit, matrix);
            int next2= searchRight(start, visit, matrix);
            int next3 = searchDown(start, visit, matrix);
            ArrayList<int[]> h1 = new ArrayList<>();
            ArrayList<int[]> h2 = new ArrayList<>();
            ArrayList<int[]> h3 = new ArrayList<>();
            if (next1 == -1&&next2 == -1&& next3 == -1) {
                if (start[0] == end[0]&&start[1] == end[1]) {
                    return history;
                } else {
                    return new ArrayList<>();
                }
            }
            if (next1 != -1) {
                int[] newInt = new int[2];
                newInt[0] = start[0];
                newInt[1] = next1;
                h1 = searchRoute(newInt, end, getNewVisit(visit), matrix, history, 3);
            }
            if (next2 != -1) {
                int[] newInt = new int[2];
                newInt[0] = start[0];
                newInt[1] = next2;
                h2 = searchRoute(newInt, end, getNewVisit(visit), matrix, history, 4);
            }
            if (next3 != -1) {
                int[] newInt = new int[2];
                newInt[0] = next3;
                newInt[1] = start[1];
                h3 = searchRoute(newInt, end, getNewVisit(visit), matrix, history, 2);
            }
            return h3.size()>(h1.size()>h2.size()?h1:h2).size()?h3:(h1.size()>h2.size()?h1:h2);
        }
        if (flag == 3) {
            int next1 = searchLeft(start, visit, matrix);
            int next2= searchDown(start, visit, matrix);
            int next3 = searchTop(start, visit, matrix);
            ArrayList<int[]> h1 = new ArrayList<>();
            ArrayList<int[]> h2 = new ArrayList<>();
            ArrayList<int[]> h3 = new ArrayList<>();
            if (next1 == -1&&next2 == -1&& next3 == -1) {
                if (start[0] == end[0]&&start[1] == end[1]) {
                    return history;
                } else {
                    return new ArrayList<>();
                }
            }
            if (next1 != -1) {
                int[] newInt = new int[2];
                newInt[0] = start[0];
                newInt[1] = next1;
                h1 = searchRoute(newInt, end, getNewVisit(visit), matrix, history, 3);
            }
            if (next2 != -1) {
                int[] newInt = new int[2];
                newInt[0] = next2;
                newInt[1] = start[1];
                h2 = searchRoute(newInt, end, getNewVisit(visit), matrix, history, 2);
            }
            if (next3 != -1) {
                int[] newInt = new int[2];
                newInt[0] = next3;
                newInt[1] = start[1];
                h3 = searchRoute(newInt, end, getNewVisit(visit), matrix, history, 1);
            }
            return h3.size()>(h1.size()>h2.size()?h1:h2).size()?h3:(h1.size()>h2.size()?h1:h2);
        }
        if (flag == 4) {
            int next1 = searchRight(start, visit, matrix);
            int next2= searchDown(start, visit, matrix);
            int next3 = searchTop(start, visit, matrix);
            ArrayList<int[]> h1 = new ArrayList<>();
            ArrayList<int[]> h2 = new ArrayList<>();
            ArrayList<int[]> h3 = new ArrayList<>();
            if (next1 == -1&&next2 == -1&& next3 == -1) {
                if (start[0] == end[0]&&start[1] == end[1]) {
                    return history;
                } else {
                    return new ArrayList<>();
                }
            }
            if (next1 != -1) {
                int[] newInt = new int[2];
                newInt[0] = start[0];
                newInt[1] = next1;
                h1 = searchRoute(newInt, end, getNewVisit(visit), matrix, history, 4);
            }
            if (next2 != -1) {
                int[] newInt = new int[2];
                newInt[0] = next2;
                newInt[1] = start[1];
                h2 = searchRoute(newInt, end, getNewVisit(visit), matrix, history, 2);
            }
            if (next3 != -1) {
                int[] newInt = new int[2];
                newInt[0] = next3;
                newInt[1] = start[1];
                h3 = searchRoute(newInt, end, getNewVisit(visit), matrix, history, 1);
            }
            return h3.size()>(h1.size()>h2.size()?h1:h2).size()?h3:(h1.size()>h2.size()?h1:h2);
        }

        int next1 = searchRight(start, visit, matrix);
        int next2= searchDown(start, visit, matrix);
        int next3 = searchTop(start, visit, matrix);
        int next4 = searchLeft(start, visit, matrix);
        ArrayList<int[]> h1 = new ArrayList<>();
        ArrayList<int[]> h2 = new ArrayList<>();
        ArrayList<int[]> h3 = new ArrayList<>();
        ArrayList<int[]> h4 = new ArrayList<>();
        if (next1 != -1) {
            int[] newInt = new int[2];
            newInt[0] = start[0];
            newInt[1] = next1;
            h1 = searchRoute(newInt, end, getNewVisit(visit), matrix, history, 4);
        }
        if (next2 != -1) {
            int[] newInt = new int[2];
            newInt[0] = next2;
            newInt[1] = start[1];
            h2 = searchRoute(newInt, end, getNewVisit(visit), matrix, history, 2);
        }
        if (next3 != -1) {
            int[] newInt = new int[2];
            newInt[0] = next3;
            newInt[1] = start[1];
            h3 = searchRoute(newInt, end, getNewVisit(visit), matrix, history, 1);
        }
        if (next4 != -1) {
            int[] newInt = new int[2];
            newInt[0] = start[0];
            newInt[1] = next4;
            h4 = searchRoute(newInt, end, getNewVisit(visit), matrix, history, 3);
        }
        ArrayList<int[]> r = h3.size()>(h1.size()>h2.size()?h1:h2).size()?h3:(h1.size()>h2.size()?h1:h2);
        return r.size()>h4.size()?r:h4;
    }
    
    private static int[][] getNewVisit(int[][] visit) {
        int[][] newVisit = new int[visit.length][visit[0].length];
        for (int i = 0; i < visit.length; i++) {
            for (int j = 0; j < visit[0].length; j++) {
                newVisit[i][j] = visit[i][j];
            }
        }
        return newVisit;
    }

    private static int searchLeft(int[] start, int[][] visit, int[][] matrix) {
        for (int i = start[1] - 1; i >= 0; i--) {
            if (visit[start[0]][i] == 0) {
                return i;
            }
        }
        return -1;
    }

    private static int searchRight(int[] start, int[][] visit, int[][] matrix) {
        for (int i = start[1] + 1; i < visit[start[0]].length; i++) {
            if (visit[start[0]][i] == 0) {
                return i;
            }
        }
        return -1;
    }

    private static int searchDown(int[] start, int[][] visit, int[][] matrix) {
        for (int i = start[0] + 1; i < visit.length; i++) {
            if (visit[i][start[1]] == 0) {
                return i;
            }
        }
        return -1;
    }

    private static int searchTop(int[] start, int[][] visit, int[][] matrix) {
        for (int i = start[0] - 1; i >= 0; i--) {
            if (visit[i][start[1]] == 0) {
                return i;
            }
        }
        return -1;
    }

    private static void initVisit(int[][] visit, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    visit[i][j] = 1;
                }
            }
        }
    }
}
