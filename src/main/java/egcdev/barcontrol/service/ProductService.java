package egcdev.barcontrol.service;


import egcdev.barcontrol.model.entity.Product;
import egcdev.barcontrol.service.interfaces.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {


    @Override
    public List<Product> getAllBrands() {
        return List.of();
    }

    @Override
    public Product getBrand(Integer id) {
        return null;
    }

    @Override
    public Product createBrand(Product p) {
        return null;
    }

    @Override
    public Integer deleteBrand(Integer id) {
        return 0;
    }
}
