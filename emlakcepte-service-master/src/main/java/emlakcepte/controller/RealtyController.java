package emlakcepte.controller;

import java.util.List;
import java.util.Map;

import emlakcepte.model.SearchHistory;
import emlakcepte.model.User;
import emlakcepte.model.enums.RealtyCommercialType;
import emlakcepte.model.enums.RealtyGroupType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import emlakcepte.model.Realty;
import emlakcepte.service.RealtyService;

@RestController
@RequestMapping(value = "/realtyes")
public class RealtyController {

	@Autowired
	private RealtyService realtyService;

	// GET /realtyes
	@GetMapping
	public List<Realty> getAll() {
		return realtyService.getAll();
	}

	// POST /realtyes
	@PostMapping
	public ResponseEntity<Realty> create(@RequestBody Realty realty) {
		System.out.println("realty" + realty);
		realtyService.create(realty);
		return new ResponseEntity<>(realty, HttpStatus.CREATED);
	}

	@GetMapping(value ="user/{userName}")
	public List<Realty> getAllByUserName(@PathVariable String userName) {
		return realtyService.getAllByUserName(userName);
	}

	@GetMapping(value ="/province/{province}")
	public List<Realty> getAllByProvince(@PathVariable String province) {
		return realtyService.getAllByProvince(province);
	}

	@GetMapping(value ="/provinceDistrict")
	public List<Realty> getAllByProvinceAndDistrict(@RequestParam String province, @RequestParam String district, @RequestBody User user) {
		return realtyService.getAllByProvinceAndDistrict(province, district, user);
	}

	@GetMapping(value ="/searchHistory")
	public List<SearchHistory> getAllSearchHistory(@RequestBody User user) {
		return realtyService.getAllSearchHistory(user);
	}


	@GetMapping(value ="/counts/user/{userName}")
	public long getAllCountByUserName(@PathVariable String userName) {
		return realtyService.getAllCountByUserName(userName);
	}


	@GetMapping(value ="/counts/province/{province}")
	public long getRealtyCountByProvince(@PathVariable String province) {
		return realtyService.getRealtyCountByProvince(province);
	}


	@GetMapping(value ="/counts")
	public long getRealtyCountByCommercialAndGroupType(@RequestParam String province,@RequestParam RealtyGroupType groupType, @RequestParam RealtyCommercialType commercialType) {
		return realtyService.getRealtyCountByCommercialAndGroupType(province, groupType, commercialType);
	}


	@GetMapping(value ="/grouped/city")
	public Map<String, List<Realty>> printGroupedRealtyesByCity(){
		return realtyService.printGroupedRealtyesByCity();
	}


}
