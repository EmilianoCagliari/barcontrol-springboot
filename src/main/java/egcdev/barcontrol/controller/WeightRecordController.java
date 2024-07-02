package egcdev.barcontrol.controller;

import egcdev.barcontrol.service.WeightRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weight_record")
public class WeightRecordController {

    @Autowired
    private WeightRecordService weightRecordService;

    @GetMapping()
    public String test() {
        return "WeightRecord Controller test success!";
    }

}
