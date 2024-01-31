package org.rak.fee.unit.fee;

import org.rak.fee.dto.EndpointResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/fee")
public class FeeController {

	private FeeServiceImpl feeService;

	public FeeController(FeeServiceImpl feeService) {
		this.feeService = feeService;
	}


	@GetMapping("/type/{type}/category/{category}/sub-category/{subCategory}/frequency/{frequency}")
	EndpointResponse<FeeDto> getFee(@PathVariable String type,
															@PathVariable String category,
															@PathVariable String subCategory,
															@PathVariable String frequency){
		return new EndpointResponse<>(feeService.getFee(type, category, subCategory, frequency),null);
	}

	@PostMapping
	EndpointResponse<FeeDto> addFee(@RequestBody FeeDto feeDto){
		return new EndpointResponse<>(feeService.create(feeDto), null);
	}

}
