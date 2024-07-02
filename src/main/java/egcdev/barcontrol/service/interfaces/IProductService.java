package egcdev.barcontrol.service.interfaces;

import egcdev.barcontrol.model.entity.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAllBrands();

    Product getBrand( Integer id );

    Product createBrand( Product p );

    Integer deleteBrand( Integer id );

}
