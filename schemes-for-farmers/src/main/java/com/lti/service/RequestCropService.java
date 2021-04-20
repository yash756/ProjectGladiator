package com.lti.service;

import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.lti.entity.Farmer;
import com.lti.entity.Request;
import com.lti.exception.RequestCropServiceException;
import com.lti.repository.FarmerRepository;
import com.lti.repository.RequestCropRepository;

@Service
@Transactional
public class RequestCropService {

	@Autowired
	private RequestCropRepository requestCropRepo;
	
	@Autowired
	private FarmerRepository farmerRepo;

	
	public void register(Request request) {
		
		try {
		
			Farmer farmer = farmerRepo.findbyId(request.getFarmer().getId());
			
//			long daysBetween = ChronoUnit.DAYS.between(request.getStartDate(), request.getEndDate());
//			if (daysBetween > 30) {
//				throw new RequestCropServiceException("The bid period cannot be greater than 30 days");
//			}
			if (requestCropRepo.isCropPresent(request.getFarmer().getId(), request.getQuantity(), request.getBasePrice(),
					request.getCropName())) {
				throw new RequestCropServiceException("Similar request has been made already");
			}
			request.setFarmer(farmer);

			requestCropRepo.save(request);

		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
			throw new RequestCropServiceException("Only a registered farmer can add crop");
		}

	}


//	public List<ShowAllCropsDto> getCrops() {
//		try {
//			List<ShowAllCropsDto> AvailableCrops = new ArrayList<ShowAllCropsDto>();
//			List<Crop> crops = cropRepo.findCrops();
//			for (Crop crop : crops) {
//				ShowAllCropsDto scrop = new ShowAllCropsDto();
//				scrop.setId(crop.getId());
//				scrop.setName(crop.getName());
//				scrop.setSoilPh(crop.getSoilPh());
//				scrop.setCropType(crop.getCropType());
//				scrop.setFertilizerType(crop.getFertilizerType());
//				scrop.setBasePrice(crop.getBasePrice());
//				scrop.setQuantity(crop.getQuantity());
//				scrop.setFullname(crop.getUser().getFullname());
//				scrop.setEndDate(crop.getEndDate());
//				AvailableCrops.add(scrop);
//			}
//			return AvailableCrops;
//		} catch (EmptyResultDataAccessException e) {
//			throw new CropServiceException("No crops available");
//		}
//	}
}
