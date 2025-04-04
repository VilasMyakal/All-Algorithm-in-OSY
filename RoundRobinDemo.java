import java.util.*;

class RoundRobinDemo {

	public static void main(String args[]){
	
		int n, i, qt, count=0, temp, sq=0;
		int[] bt = new int[10];
		int[] wt = new int[10];
		int[] tat = new int[10];
		int[] rem_bt = new int[10];
		int[] ct = new int[10];
		float awt =0, atat = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Number of process: ");
		n = sc.nextInt();
		
		for(i=0; i<n; i++){
		
			System.out.println("Enter Burst TIme of Process"+(i+1)+" : ");
			bt[i] = sc.nextInt();
			rem_bt[i] = bt[i];
		
		
		}
		System.out.println("Enter Quantum Time: ");
		qt = sc.nextInt();
	
		int sum = 0;
		
		while(true){
		for(i=0,count=0;i<n;i++){
			
			if(rem_bt[i]==0){
				count++;
				continue;
			}
			else if(rem_bt[i] <qt){
				
				if(rem_bt[i] >=0){
					
					sum = sum+rem_bt[i];
					ct[i] = sum;
					rem_bt[i] = 0;	
					count++;
					continue;
					
					
				}
				
				
			}else{
				
				rem_bt[i] = rem_bt[i]-qt;
				sum = sum + qt;
				
				
			}
			
			
			
			
			
		}
		
			if(count==n){
				break;
			}
		
		}
		
		
		for(i=0;i<n;i++){
			
			tat[i] = ct[i];
			atat = atat+tat[i];
			
		}
		
		for(i=0;i<n;i++){
			
			wt[i] = tat[i]-bt[i];
			awt = awt+wt[i];
			
		}
		
		System.out.println("\nProcess\tBurst Time\tTurnaround Time\tWaiting Time\n");
		for(i=0;i<n;i++){
			
			System.out.println("\n"+(i+1)+"\t"+bt[i]+"\t\t"+tat[i]+"\t\t"+wt[i]);
			
		}
		
		System.out.println("Avg Wating tme : "+(awt/n));
		System.out.println("Avg Turnaroung time : "+(atat/n));
		
		
		
	
	
	
	}


}