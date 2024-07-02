package egcdev.barcontrol.model.repository;

import egcdev.barcontrol.model.entity.WeightRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IWeightRecord extends JpaRepository<WeightRecord, Integer>, JpaSpecificationExecutor<WeightRecord> {
}
