package services;

import java.util.List;

import dao.RequestDao;
import dao.RequestDaoImpl;
import pojo.RequestPojo;
import pojo.UserPojo;

public class RequetInterfaceImpl implements RequetInterface {
	RequestDao requestpojo=new RequestDaoImpl();

	@Override
	public List<RequestPojo> viewAllRequest() {
		
		return requestpojo.viewAllRequest();
	}

	@Override
	public RequestPojo addRequest(RequestPojo requestPojo) {
		
		return requestpojo.addRequest(requestPojo);
	}

	@Override
	public List<RequestPojo> viewPendingRequest() {
		
		return requestpojo.viewPendingRequest();
	}

	@Override
	public RequestPojo reviewRequest(int reqId) {
		return requestpojo.reviewRequest(reqId);
	}

	@Override
	public RequestPojo deleteRequest(int reqId) {
		return requestpojo.deleteRequest(reqId);
	}

	

}
