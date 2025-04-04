import java.util.*;

public class FIFODemo {
	
    public static void main(String[] args) 
	{
        int i=0,n,temp=0,j=0;
        int[] ref_str = new int[10]; 
		

        Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of frames : ");
		n = sc.nextInt();
		
		int[] frame = new int[n];
		

        System.out.println("Enter reference string (up to 10 integers): ");

        for (i = 0; i < 10; i++) {
            ref_str[i] = sc.nextInt();
        }

        System.out.println("String : ");
        for (i = 0; i < 10; i++) {
            System.out.print(ref_str[i] + " ");
        }
		
		int pf = n, ph =0;
		
		for(i = 0; i<n; i++){
			
			frame[i] = ref_str[i];
			
		}
		int count =0;
		for(i=n; i<ref_str.length; i++){
			
			temp = ref_str[i];
			for(j=0;j<n;j++){
				
				if(temp == ref_str[j]){
					ph++;
					break;
				}else{
					
					if(count==(n-1))
						count =0;
					
					ref_str[count] = temp;
					pf++;
					count++;
					
				}
				
			}
			
			
		}
		
		System.out.println("Page Fault Count : "+(ref_str.length - ph));
		System.out.println("Page Hit Count : "+ph);

        
    }
}
