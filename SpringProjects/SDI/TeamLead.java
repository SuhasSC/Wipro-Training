package com.wipro.DependencyInjection;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class TeamLead implements Allocator
{

    TeamLead()
    {
        System.out.println("TeamLead Bean Created");
    }

    
    public void taskAllocation(String user)
    {
        System.out.println("Task is allocated by : TeamLead to " + user);
    }

}