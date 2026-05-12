package com.wipro.DependencyInjection;

@FunctionalInterface
interface Allocator {
	
	void taskAllocation(String user);

}
