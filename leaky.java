import java.util.Scanner;

public class leaky {
    public static void main(String[] args){
        int i;
        int a[]=new int[20];
        int b[]=new int[20];
        int buck_rem=0,sent,recv;
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the number of packets");
        int n=in.nextInt();
        System.out.println("Enter the bucket capacity");
        int buck_cap=in.nextInt();
        System.out.println("Enter the output rate");
        int rate=in.nextInt();
        System.out.println("Enter the size of the packet");
        for(i=1;i<=n;i++){
            a[i]=in.nextInt();
        b[i]=a[i];
        if(a[i]>buck_cap)
        {
            a[i]=buck_cap;
        }}
        System.out.println("CLOCK \tPACKET SIZE\tACCEPT\tSSENT\tREMAINING");
        for(i=1;i<=n;i++)
        {
            if(a[i]!=0)
            {
                if(buck_rem+a[i]>buck_cap)
                    recv=-1;
                else
                {
                    recv=a[i];
                    buck_rem+=a[i];
                }
            }
            else
                recv=0;
            if(buck_rem!=0)
            {
                if(buck_rem<rate)
                {
                    sent=buck_rem;
                    buck_rem=0;
                }
                else
                {
                    sent=rate;
                    buck_rem=buck_rem-rate;
                }
            }
            else
                sent=0;
            if(recv==-1)
                System.out.println(i+"\t\t"+a[i]+"\t dropped \t"+sent +"\t"+buck_rem);
            else
                System.out.println(i+"\t\t"+a[i]+"\t\t"+recv+"\t"+sent+"\t"+buck_rem);
        }
    }
}
