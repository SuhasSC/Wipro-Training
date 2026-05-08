package com.wipro.DependencyInjection;

public class DelegateConstructorDI {
	
	private final Allocator allocator;
	
	public DelegateConstructorDI(Allocator allocator) {
		super();
		this.allocator = allocator;
		System.out.println("Inside Delegate Constructor - Allocator Impl: " + allocator);
	};
	
	public void notifyUser() {
		allocator.taskAllocation("Rollen");
	}


}
