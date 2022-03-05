import services.RequetInterface;
import services.RequetInterfaceImpl;
import io.javalin.Javalin;

public class RequstMain {
	public static void main(String[] args) {
		
	RequetInterface req=new RequetInterfaceImpl();
	Javalin myServer = Javalin.create((config)-> config.enableCorsForAllOrigins()).start(4040);
	System.out.println("Server listening at port 4040...");
}
}
