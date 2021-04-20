package com.lti.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lti.dto.MaxBid;
import com.lti.dto.PlaceBidDto;
import com.lti.dto.Status;
import com.lti.exception.CropServiceException;
import com.lti.service.BidService;


@RestController
@CrossOrigin
public class BidRestController {

	@Autowired
	private BidService bidService;

	@PostMapping("/placeBids")
	public Status placebid(@RequestBody PlaceBidDto placeBidDto) {
		try {
			bidService.savebid(placeBidDto);
			Status status = new Status();
			status.setStatus(true);
			status.setMessage("Bids PLaced suucessfully");

			return status;

		} catch (CropServiceException e) {

			Status status = new Status();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;

		}
	}

	/*@GetMapping("/bid")
	public MaxBid getmaxBidbycropid(@RequestParam("cropId") Integer cropId) {
		try {
			double amount = bidService.getBid(cropId);
			Status status = new Status();
			status.setStatus(true);
			status.setMessage("Bids Available");
			MaxBid bid = new MaxBid();
			bid.setAmount(amount);
			bid.setStatus(status);
			return bid;

		} catch (CropServiceException e) {

			MaxBid bid = new MaxBid();
			Status status = new Status();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			bid.setStatus(status);
			return bid;

		}
	}*/


}
