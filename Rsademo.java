import java.util.Scanner;
public class RsaDemo
{
    public static void main(String[] args)
    {
    String msg;
    int pt[]=new int[100];
    int ct[]=new int[100];
    int z,n,d,e,p,q,mlen;
    Scanner in=new Scanner(System.in);
    do
    {
        System.out.println("enter the two large prime number for p and q");
        p=in.nextInt();
        q=in.nextInt();
    }
    while(prime(p)==0||prime(q)==0);
    n=p*q;
    z=(p-1)*(q-1);
    System.out.println("value of n"+n+"\n value of z is:"+z);
    for(e=2;e<z;e++)
    {
        if(gcd(e,z)==1)
            break;
    }
    System.out.println("encryption key e"+e);
    System.out.println("public key is (e,n)"+e+","+n);
    for(d=2;d<z;d++)
    {
        if((e*d)%z==1)
            break;
    }
    System.out.println("decryption key d"+d);
    System.out.println("public key is (d,n)"+d+","+n);
    in.nextLine();
    System.out.println("enter the message for encryption");
    msg=in.nextLine();
    mlen=msg.length();
    for(int i=0;i<mlen;i++)
    pt[i]=msg.charAt(i);
    System.out.println("ASCII values of pt array is");
    for(int i=0;i<mlen;i++)
    System.out.println(pt[i]);
    System.out.println("encryption cipher text obtained");
    for(int i=0;i<mlen;i++)
    ct[i]=mult(pt[i],e,n);
    for(int i=0;i<mlen;i++)
        System.out.println(ct[i]+"\t");
    System.out.println("\n descryption plain text obtained:");
    for(int i=0;i<mlen;i++)
    pt[i]=mult(ct[i],d,n);
    for(int i=0;i<mlen;i++)
    {
        System.out.println(pt[i]+":"+(char)pt[i]);
    }
    }

public static int gcd(int x,int y)
{
    if(y==0)
        return x;
    else
        return gcd(y,x%y);
    
}
public static int prime(int num)
{
    int i;
    for(i=2;i<=num/2;i++)
    {
        if(num%i==0)
            return 0;
    }
    return 1;
}
public static int mult(int base,int exp,int n)
{
    int res=1,j;
    for(j=1;j<=exp;j++)
        res=((res*base)%n);
    return res;
}

}
    
