package com.wipro.springExample;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class TeamLead implements Allocator {

    @Override
    public void taskAllocation(String user) {

        System.out.println("The task is allocated by TeamLeader to " + user);

    }

}