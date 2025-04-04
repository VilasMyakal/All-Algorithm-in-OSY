import java.util.*;

class PriorityDemo {

	public static void main(String args[]){
	
		int  i,n,j,temp,pos;
		
		int[] bt = new int[10];
		int[] wt = new int[10];
		int[] pr = new int[10];
		int[] tat = new int[10];
	
		
		float awt = 0, atat = 0;
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Number of process: ");
		n = sc.nextInt();
		
		for(i=0; i<n; i++){
		
			System.out.println("Enter Burst TIme of Process"+(i+1)+" : ");
			bt[i] = sc.nextInt();
			
			System.out.println("Enter Priority of process"+(i+1)+" :");
			pr[i] = sc.nextInt();
		
		}
		
		for(i=0;i<n;i++){
			
			pos = i;
			
			for(j=i+1;j<n;j++){
				
				if(pr[j]<pr[i]){
					pos = j;
				}
				
			}
			
			temp = pr[i];
			pr[i] = pr[pos];
			pr[pos] = temp;
			
			temp = bt[i];
			bt[i] = bt[pos];
			bt[pos] = temp;
			
		}
		
		wt[0] = 0;
		
		System.out.println("\nProcess\tBurst Time\tPriority\t\tWaiting Time\tTurnaround Time\n");
		
		for(i=0;i<n;i++){
			
			wt[i] = 0;
			tat[i] = 0;
			
			for(j=0;j<i;j++){
				
				wt[i] = wt[i] + bt[j];
				
			}
			tat[i] = wt[i] + bt[i];
			awt = awt+wt[i];
			
			atat = atat + tat[i];
			
			System.out.println(""+(i+1)+"\t"+bt[i]+"\t\t"+pr[i]+"\t\t"+wt[i]+"\t\t"+tat[i]);
			
		}
		
		
		System.out.println("Avg waiting time : "+(awt/n));
		System.out.println("Avg turnaroung time : "+(atat/n));
	
	
	
	}



}