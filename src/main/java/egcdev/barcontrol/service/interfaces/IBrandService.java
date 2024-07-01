package egcdev.barcontrol.service.interfaces;

import egcdev.barcontrol.model.entity.Brand;

import java.util.List;

public interface IBrandService {

    List<Brand> getAllBrands();

    Brand getBrand( Integer id );

    Brand createBrand( Brand brand );

    Integer deleteBrand( Integer id );

}
