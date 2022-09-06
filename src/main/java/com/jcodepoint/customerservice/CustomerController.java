package com.jcodepoint.customerservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	private static Map<Integer, Customer> customers = new HashMap<>(); 
        private final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
    @PostMapping("/customer")  
    public Respuesta addCustomer(@RequestBody Customer customer) {
        Respuesta respuesta = new Respuesta();
        
        if(customer.getId() == 0){
            respuesta.setError("Error, no se puede agregar el cliente");
            logger.error("Error, inesperado agregando el cliente");
            
            
        }else{
            customers.put(customer.getId(), customer);
            respuesta.setRespuesta("Cliente agregado correctamente.");
        }
            return respuesta;
        
        
         
    } 	
	
    @GetMapping("/customer")  
    public List<Customer> getCustomers() { 
        return new ArrayList<Customer>(customers.values()); 
    }    
	
}
