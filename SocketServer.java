import java.net.*;
import java.io.*;
public class SocketServer
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket servSocket=new ServerSocket(4000);
        System.out.println("***Server size***");
        System.out.println("server ready for connection");
        Socket connSock=servSocket.accept();
        System.out.println("connection is succesful and ready for file transfer");
        InputStream istream=connSock.getInputStream();
        BufferedReader fileRead=new BufferedReader(new InputStreamReader(istream));
        String fname=fileRead.readLine();
        File fileName=new File(fname);
        OutputStream ostream=connSock.getOutputStream();
        PrintWriter pwrite=new PrintWriter(ostream,true);
        if(fileName.exists())
        {
            BufferedReader contentRead=new BufferedReader(new FileReader(fname));
            System.out.println("writing file content to the socket");
            String str;
            while((str=contentRead.readLine())!=null)
            {
            
        
        pwrite.println(str);
    }
    contentRead.close();
}
else
{
System.out.println("required file does not exists");
String msg="requested file does not exists at server side";
pwrite.println(msg);
}
connSock.close();
servSocket.close();
pwrite.close();
}
}

