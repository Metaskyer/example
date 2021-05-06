package kr.ktservice.example.worker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class WorkerController {

    private final WorkerRepository workers;

    public WorkerController(WorkerRepository ktsSerivice) {
        this.workers = ktsSerivice;
    }

    @GetMapping("/workers.html")
    public String showWorkerList(Map<String, Object> model) {
        Workers workers = new Workers();
        workers.getWorkerList().addAll(this.workers.findAll());
        model.put("workers", workers);
        return "workers/workerList";
    }

    @GetMapping({"/workers"})
    public @ResponseBody Workers showResourcesWorkerList() {
        Workers workers = new Workers();
        workers.getWorkerList().addAll(this.workers.findAll());
        return workers;
    }
}
