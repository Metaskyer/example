package kr.ktservice.example.worker;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Workers {
    private List<Worker> workers;

    public List<Worker> getWorkerList() {
        if(workers == null) {
            workers = new ArrayList<>();
        }
        return workers;
    }
}
