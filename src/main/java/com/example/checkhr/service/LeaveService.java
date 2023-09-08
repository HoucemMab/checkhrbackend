package com.example.checkhr.service;
import com.example.checkhr.model.Leaves;
import com.example.checkhr.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LeaveService {
    @Autowired
    private LeaveRepository leaveRepository;

    public List<Leaves> getAllLeaves() {
        return leaveRepository.findAll();
    }
    public Leaves requestLeave(Leaves leave) {
        // Set the status to null when requesting leave
        leave.setStatus(null);
        return leaveRepository.save(leave);
    }
    public List<Leaves> getUncheckedLeaves() {
        return leaveRepository.findByStatusIsNull();
    }

    public Leaves approveLeaveById(Long id) {
        Leaves leave = leaveRepository.findById(id).orElseThrow();
        if (leave != null && leave.getStatus() == null) {
            leave.setStatus(true);
            return leaveRepository.save(leave);
        }
        return null; // Leave not found or already approved/declined
    }

    public Leaves declineLeaveById(Long id) {
        Leaves leave = leaveRepository.findById(id).orElseThrow();
        if (leave != null && leave.getStatus() == null) {
            leave.setStatus(false);
            return leaveRepository.save(leave);
        }
        return null; // Leave not found or already approved/declined
    }
}
