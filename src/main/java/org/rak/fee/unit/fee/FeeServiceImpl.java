package org.rak.fee.unit.fee;

import org.rak.fee.exception.ApplicationException;
import org.rak.fee.interfaces.BusinessService;
import org.rak.fee.interfaces.Mapper;
import org.rak.fee.interfaces.RequestValidator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeeServiceImpl implements BusinessService<FeeDto> {

	private RequestValidator<FeeDto> validator;
	private Mapper<FeeDto, Fee> mapper;
	private FeeRepository repository;

	public FeeServiceImpl(RequestValidator<FeeDto> validator, Mapper<FeeDto, Fee> mapper, FeeRepository repository) {
		this.validator = validator;
		this.mapper = mapper;
		this.repository = repository;
	}

	@Override
	public FeeDto getByUuid(String uuid) {
		return null;
	}

	@Override
	public FeeDto create(FeeDto dto){
		return Optional.ofNullable(dto)
			.filter(dto1 -> validator.validateRequest(dto1))
			.map(dto1 -> mapper.toEntity(dto1))
			.map(entity -> repository.save(entity) )
			.map(entity -> mapper.toDto(entity))
			.orElseThrow(() -> new ApplicationException("100-001", "Unable to create"));
	}

	@Override
	public FeeDto update(FeeDto dto, String id) {
		return null;
	}

	@Override
	public void delete(String uuid) {

	}


	public FeeDto getFee(String type, String category, String subCategory, String frequency) {
		return repository.findByTypeAndCategoryAndSubCategoryAndFrequency(type, category, subCategory, frequency)
				.map(entity -> mapper.toDto(entity))
				.orElseThrow(() -> new ApplicationException("", ""));
	}
}
