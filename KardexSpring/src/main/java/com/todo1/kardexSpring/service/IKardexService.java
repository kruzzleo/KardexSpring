package com.todo1.kardexSpring.service;

import java.util.Map;

import com.todo1.kardexSpring.model.Kardex;
import com.todo1.kardexSpring.model.embeddedId.KardexID;

public interface IKardexService {

	Map<KardexID, Kardex> findAllStockProducts();

	Kardex findById(KardexID id);

	Kardex saveKardex(Kardex kardex);
}
