package com.tt.internship;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final InternshipApplicationRepository repository;

    public DataInitializer(InternshipApplicationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            repository.saveAll(List.of(
                new InternshipApplication("Rahul Sharma", "21CS042", "Google India", "Interview Scheduled"),
                new InternshipApplication("Priya Patel", "21CS089", "Microsoft", "Selected"),
                new InternshipApplication("Aman Verma", "21IT015", "Amazon Web Services", "Applied"),
                new InternshipApplication("Sneha Reddy", "21CS103", "Infosys", "Under Review"),
                new InternshipApplication("Vikram Singh", "21EC024", "TCS Research", "Rejected")
            ));
        }
    }
}
