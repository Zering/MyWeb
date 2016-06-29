package com.app.service;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService  
@SOAPBinding(style = Style.RPC) 
public interface IWebService {

	public String sayHello(String string);
}
