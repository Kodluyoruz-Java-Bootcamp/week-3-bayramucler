package emlakcepte.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import emlakcepte.model.SearchHistory;
import emlakcepte.model.enums.RealtyCommercialType;
import emlakcepte.model.enums.RealtyGroupType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakcepte.client.BannerServiceClient;
import emlakcepte.model.Realty;
import emlakcepte.model.User;
import emlakcepte.model.enums.RealtyType;
import emlakcepte.model.enums.UserType;
import emlakcepte.repository.RealtyRepository;

@Service
public class RealtyService {

	@Autowired
	private RealtyRepository realtyDao;

	@Autowired
	private BannerServiceClient bannerServiceClient;

	private final List<SearchHistory> searchHistoryList = new ArrayList<>();

	public void create(Realty realty) {
		if (UserType.INDIVIDUAL.equals(realty.getUser().getType())) {
			System.out.println("Bireysel kullanıclar en fazla 5 ilan girebilir.");
		}

		realtyDao.saveRealty(realty);
		System.out.println("createRealty :: " + realty);
		/*
		Banner bannerRequest = new Banner(String.valueOf(realty.getNo()), 1, "123123", "");
		Banner bannerResponse = bannerServiceClient.create(bannerRequest);

		if (bannerResponse.getAdet() > 1) {
			System.out.println("hata verilsin");
		}*/
	}

	public List<Realty> getAll() {
		return realtyDao.findAll();
	}

	public void printAll(List<Realty> realtList) {
		realtList.forEach(realty -> System.out.println(realty));
	}


	public List<Realty> getAllByUserName(String userName) {
		return getAll().stream().filter(realty -> realty.getUser().getName().equals(userName)).toList();
	}


	public List<Realty> getAllByProvince(String province) {
		return getAll().stream()
				.filter(realty -> realty.getProvince().equals(province)).toList();
	}



	public List<Realty> getAllByProvinceAndDistrict(String province, String district, User user) {
		searchHistoryList.add(new SearchHistory("Şehir ve ilçeye göre arama", province,district, user));
		return getAll().stream()
				.filter(realty -> realty.getProvince().equals(province) && realty.getDistrict().equals(district) ).toList();
	}

	public List<SearchHistory> getAllSearchHistory(User user){
		return searchHistoryList.stream()
				.filter(history -> history.getUser().getName().equals(user.getName())).toList();
				//.forEach(history -> System.out.println(history.getProvince() + " - " + history.getDistrict()));
	}

	public List<Realty> getAllByUserName(User user){
		return getAll().stream()
				.filter(realty -> realty.getUser().getMail().equals(user.getMail()))
				.toList();
	}

	public long getAllCountByUserName(String userName){
		return getAll().stream()
				.filter(realty -> realty.getUser().getName().equals(userName))
				.count();
	}

	public long getRealtyCountByProvince(String province){
		return getAll().stream()
				.filter(realty -> realty.getProvince().equals(province))
				.count();
	}

	public long getRealtyCountByCommercialAndGroupType(String province, RealtyGroupType groupType, RealtyCommercialType commercialType){
		return getAll().stream()
				.filter(realty ->
						realty.getProvince().equals(province) &&
								realty.getCommercial().equals(commercialType) &&
								realty.getGroupType().equals(groupType)
				)
				.count();
	}

	public List<Realty> getActiveRealtyByUserName(User user) {
		return getAll().stream()
				.filter(realty -> realty.getUser().getName().equals(user.getName()))
				.filter(realty -> RealtyType.ACTIVE.equals(realty.getStatus()))
				.toList();

	}

	//Map<String, List<Realty>> şeklinde bir map oluşturur.
	public Map<String, List<Realty>> printGroupedRealtyesByCity() {
		return getAll().stream()
				.collect(Collectors.groupingBy(Realty::getProvince));
				/*
				.forEach((city, realtyes) -> {
					System.out.println(city + ": ");
					realtyes.forEach(realty -> System.out.println(realty));
				});*/
	}

}
