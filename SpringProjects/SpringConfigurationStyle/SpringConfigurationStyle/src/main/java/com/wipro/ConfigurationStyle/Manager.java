package com.wipro.ConfigurationStyle;

import org.springframework.stereotype.Service;

import com.wipro.ConfigurationStyle.Allocator;

@Service
class Manager implements Allocator
{

    Manager()   
    {
        System.out.println("Manager Bean Created");
    }

    public void taskAllocation(String user)
    {
        System.out.println("Task is allocated by : Manager to " + user);
    }

}