package com.github.armanddu.jaxws.example;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import com.github.armanddu.jaxws.example.Calculator;

/**
 * Hello world!
 *
 */
public class Client {
	public static void main(String[] args) {

		// two ways to set or get the wsdl
		// first one is to Use the WSDL to get the endpoint URL
		URL newEndpoint = null;
		try {
			newEndpoint = new URL("http://localhost:4242/WS/Calculator");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		QName qname = new QName("http://com.github.armanddu.jaxws.example/",
				"CalculatorImplService");
		CalculatorImplService service = new CalculatorImplService(newEndpoint, qname);

		// The second way is to Use the Binding Provider to set the endpoint URL
		/*
		 * BindingProvider bp = (BindingProvider) app; String endpointURL = ;
		 * bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
		 * endpointURL);
		 */

		Calculator calculator = service.getCalculatorImplPort();
	}
}
