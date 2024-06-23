import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient
{
	public static void main(String[] args)
	{
		try
		{
			Socket server=new Socket("localhost",4321);
			
			DataInputStream dis=new DataInputStream(server.getInputStream());
			DataOutputStream dos=new DataOutputStream(server.getOutputStream());
			Scanner scan=new Scanner(System.in);
			
			System.out.println("\n Enter id : ");
			int id=scan.nextInt();
			
			dos.writeInt(id);
			
			String record=dis.readUTF();
			System.out.println("\n The records are : "+record);
			
			
			dis.close();
			dos.close();
			server.close();
		}
		catch(Exception e)
		{
			System.out.println("\n CLIENT ERROR : "+e.getMessage());
		}
	}
}