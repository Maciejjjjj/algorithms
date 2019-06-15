package towerOfHanoi;

public class TowerOfHanoiMain {

    public void solution(int n, char leftRod, char rightRod, char middleRod) {

        if (n == 1) {
            System.out.println("Move disc 1 from rod " + leftRod + " to rod " + rightRod);
            return;
        }
        solution(n - 1, leftRod, middleRod, rightRod);
        System.out.println("Move disc " + n + " from rod " + leftRod + " to rod " + rightRod);
        solution(n - 1, middleRod, rightRod, leftRod);
    }

    public static void main(String[] args) {

        TowerOfHanoiMain solution = new TowerOfHanoiMain();

        solution.solution(3, 'A', 'C', 'B');

    }
}
