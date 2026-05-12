package com.wipro.LifeCycleScope;

@FunctionalInterface
interface Allocator {
	
	void taskAllocation(String user);

}
