package egcdev.barcontrol.service.interfaces;

import egcdev.barcontrol.model.entity.Product;
import egcdev.barcontrol.model.entity.WeightRecord;

import java.util.List;

public interface IWeightRecordService {

    List<WeightRecord> getAllWeightRecords();

    WeightRecord getWeightRecord( Integer id );

    WeightRecord createWeightRecord( WeightRecord wr );

    Integer deleteWeightRecord( Integer id );

}
