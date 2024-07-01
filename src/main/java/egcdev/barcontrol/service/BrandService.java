package egcdev.barcontrol.service;

import egcdev.barcontrol.model.entity.Brand;
import egcdev.barcontrol.model.repository.BrandRepository;
import egcdev.barcontrol.service.interfaces.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService implements IBrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> getAllBrands() {
        return this.brandRepository.findAll();
    }

    @Override
    public Brand getBrand(Integer id) {
        return null;
    }

    @Override
    public Brand createBrand(Brand brand) {
        return null;
    }

    @Override
    public Integer deleteBrand(Integer id) {
        return 0;
    }
}
