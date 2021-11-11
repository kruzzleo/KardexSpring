package com.todo1.kardexSpring.service;

import java.util.Map;

import com.todo1.kardexSpring.model.Factura;
import com.todo1.kardexSpring.model.Factura_Registro_Kardex;
import com.todo1.kardexSpring.model.Kardex;
import com.todo1.kardexSpring.model.embeddedId.KardexID;

public interface IShopCartService {

	void add(Kardex item);

	Kardex findById(KardexID id);

	Map<KardexID, Kardex> getShopCart();

	void buyCart(Factura factura, Factura_Registro_Kardex registroKardex);
}
