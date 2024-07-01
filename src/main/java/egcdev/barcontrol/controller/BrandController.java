package egcdev.barcontrol.controller;


import egcdev.barcontrol.service.interfaces.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private IBrandService brandService;

    @GetMapping("/")
    public String testBrand() {
        return "Test BrandController";
    }



}
