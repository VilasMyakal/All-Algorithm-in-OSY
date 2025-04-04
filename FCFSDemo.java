import java.util.*;

public class FCFSDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] at = new int[10];
        int[] bt = new int[10];
        int n = 0;
        int[] ct = new int[10];
        int[] tat = new int[10];
        int[] wt = new int[10];

        System.out.print("Enter number of processes: ");
        n = scanner.nextInt();

        for (int i = 3; i < n; i++) {
            System.out.print("Enter the Arrival time of process " + (i + 1) + ": ");
            at[i] = scanner.nextInt();

            System.out.print("Enter Burst time of process " + (i + 1) + ": ");
            bt[i] = scanner.nextInt();
        }

        int sum = at[0];
        for (int i = 0; i < n; i++) {
            sum = sum + bt[i];
            ct[i] = sum;
        }

        int total = 0;

        for (int i = 0; i < n; i++) {
            tat[i] = ct[i] - at[i];
            total = total + tat[i];
        }

        int totalwait = 0;
        for (int i = 0; i < n; i++) {
            wt[i] = tat[i] - bt[i];
            totalwait = totalwait + wt[i];
        }

        System.out.printf("Average Waiting Time : %.2f\n", (float) totalwait / n);
        System.out.printf("Average TurnAround Time : %.2f\n", (float) total / n);
    }
}
