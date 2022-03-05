import services.RequetInterface;
import services.RequetInterfaceImpl;
import services.UserInterfase;
import services.UserInterfaseImpl;

import java.util.List;

import io.javalin.Javalin;
import pojo.RequestPojo;
import pojo.UserPojo;

public class RequstMain {
	public static void main(String[] args) {
		
	RequetInterface req=new RequetInterfaceImpl();
	
	UserInterfase user=new UserInterfaseImpl();
	
	Javalin myServer = Javalin.create((config)-> config.enableCorsForAllOrigins()).start(4040);
	System.out.println("Server listening at port 4040...");
	
	myServer.get("/hello", (ctx)-> {
		ctx.result("you have access the hello endpoint!!");
	});
	
	//myServer.get("/get-book-obj", (ctx)->{
	//	BookPojo book = new BookPojo(101, "Adventure of the flaming dragon", "Geronimo Stilton", "Comedy", 35, "");
	//	ctx.json(book);
		
	//});
	

	myServer.get("/api/requst", (ctx)->{
		List<RequestPojo> allRequest = req.viewAllRequest();
		ctx.json(allRequest); // collection of BookPojo is converted to an array of JSON objects
	});
	
	
	myServer.get("/api/requst", (ctx)->{
		List<RequestPojo> allRequestPending = req.viewPendingRequest();
		ctx.json(allRequestPending); // collection of BookPojo is converted to an array of JSON objects
	});
	// endpoint to fetch a requsr
			// http://localhost:4040/api/books/102
			myServer.get("/api/requst/{bid}", (ctx)->{
				// retrieve the path param value(102) by specifying path param key(bid) 
				String reqId = ctx.pathParam("bid");
				// now that we have the book id , go ahead and tell the service layer to fetch the book
				RequestPojo fetchedreq = req.reviewRequest(Integer.parseInt(reqId));
				// return the fetched book as the response
				ctx.json(fetchedreq);
			});
	
			
			
			// endpoint to add a book
			myServer.post("/api/requst", (ctx)->{
				// there is an incomming book json in the requestbody, fetching the request body and storing it in newBook
				RequestPojo newreq = ctx.bodyAsClass(RequestPojo.class);
				// add the book in the DB
				RequestPojo returnedreq = req.addRequest(newreq);
				// return a response of the book with the genereted book id
				ctx.json(returnedreq);
			});
			
			
			// http://localhost:4040/api/books/102
			myServer.delete("/api/requst/{bid}", (ctx)->{
				// retrieve the path param value(102) by specifying path param key(bid) 
				String reqId = ctx.pathParam("bid");
				// now that we have the book id , go ahead and tell the service layer to fetch the book
				RequestPojo deletedReq = req.deleteRequest(Integer.parseInt(reqId));
				// return the fetched book as the response
				ctx.json(deletedReq);
			});
			
			
			
			
			myServer.put("/api/user", (ctx)->{
				// there is an incomming book json in the requestbody, fetching the request body and storing it in newBook
				UserPojo updatereq = ctx.bodyAsClass(UserPojo.class);
				// add the book in the DB
				UserPojo updatAccount = user.updateAccount(updatereq);
				// return a response of the book with the genereted book id
				ctx.json(updatAccount);
			});
			myServer.get("/api/user", (ctx)->{
				List<UserPojo> allusers = user.fetchAllAccounts();
				ctx.json(allusers); // collection of BookPojo is converted to an array of JSON objects
			});
			myServer.get("/api/user/{bid}", (ctx)->{
				// retrieve the path param value(102) by specifying path param key(bid) 
				String userId = ctx.pathParam("bid");
				// now that we have the book id , go ahead and tell the service layer to fetch the book
				UserPojo fetchAuserAccount = user.fetchAAccount(Integer.parseInt(userId));
				// return the fetched book as the response
				ctx.json(fetchAuserAccount);
			});
	
}
}
