package com.wipro.Configurationstyle.SCS;



import org.springframework.stereotype.Component;

@Component
public class DelegateXMLBased {

	// Here delegate depends upon interface only --->
	private final Allocator allocator; // depends on abstraction // required + final

	// dependency injection will be done by Spring
	// but how by adding an annotation @Autowired
	// In this constructor we are passing the reference of Allocator Interface which
	// provides a methods and also a class reference whom so ever is implementing

	public DelegateXMLBased(Allocator allocator) {
		// This is constructor injection // spring will creates a Manager.
		// here object is ready and fully capable
		super();
		this.allocator = allocator;
		System.out.println("Inside Delegate Constructor - Allocator Impl: " + allocator.getClass().getSimpleName());
	};

	public void notifyUser() {
//		 manager.taskAllocation("Rollen");
		allocator.taskAllocation("Rollen");
	}
}