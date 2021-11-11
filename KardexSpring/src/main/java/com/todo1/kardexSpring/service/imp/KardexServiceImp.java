package com.todo1.kardexSpring.service.imp;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo1.kardexSpring.model.Kardex;
import com.todo1.kardexSpring.model.embeddedId.KardexID;
import com.todo1.kardexSpring.repository.IKardexRepository;
import com.todo1.kardexSpring.service.IKardexService;


@Service
@Transactional
public class KardexServiceImp implements IKardexService{

	
	@Autowired
	private IKardexRepository kardexRepo;
	
	@Override
	@Transactional(readOnly = true)
	public Map<KardexID, Kardex> findAllStockProducts() {
		
		Map<KardexID, Kardex> map = kardexRepo.findAllStockProducts().stream()
				.collect(Collectors.toMap(Kardex::getId, Function.identity()));

		return map;	
		
	}

	@Override
	@Transactional(readOnly = true)
	public Kardex findById(KardexID id) {
		
		return kardexRepo.findById(id).orElse(null);
	}
	
	@Override
	public Kardex saveKardex(Kardex kardex) {		
		return kardexRepo.save(kardex);
	}
	
	

}
