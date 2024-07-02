package egcdev.barcontrol.service;

import egcdev.barcontrol.model.entity.WeightRecord;
import egcdev.barcontrol.service.interfaces.IWeightRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeightRecordService implements IWeightRecordService {
    @Override
    public List<WeightRecord> getAllWeightRecords() {
        return List.of();
    }

    @Override
    public WeightRecord getWeightRecord(Integer id) {
        return null;
    }

    @Override
    public WeightRecord createWeightRecord(WeightRecord wr) {
        return null;
    }

    @Override
    public Integer deleteWeightRecord(Integer id) {
        return 0;
    }
}
