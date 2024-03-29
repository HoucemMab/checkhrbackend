package com.example.checkhr.controller;

import com.example.checkhr.model.Leaves;
import com.example.checkhr.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaves")
@CrossOrigin("*")

public class LeavesController {
    @Autowired
    private LeaveService leaveService;
    @PostMapping("/request")
    public Leaves requestLeave(@RequestBody Leaves leave) {
        return leaveService.requestLeave(leave);
    }
    @GetMapping
    public List<Leaves> getAllLeaves() {
        return leaveService.getAllLeaves();
    }

    @GetMapping("/unchecked")
    public List<Leaves> getUncheckedLeaves() {
        return leaveService.getUncheckedLeaves();
    }

    @PostMapping("/approve/{id}")
    public Leaves approveLeaveById(@PathVariable Long id) {
        return leaveService.approveLeaveById(id);
    }

    @PostMapping("/decline/{id}")
    public Leaves declineLeaveById(@PathVariable Long id) {
        return leaveService.declineLeaveById(id);
    }
}

