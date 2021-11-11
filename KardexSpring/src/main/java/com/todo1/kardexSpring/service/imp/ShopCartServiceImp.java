package com.todo1.kardexSpring.service.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.SessionScope;

import com.todo1.kardexSpring.model.Factura;
import com.todo1.kardexSpring.model.Factura_Registro_Kardex;
import com.todo1.kardexSpring.model.Kardex;
import com.todo1.kardexSpring.model.embeddedId.KardexID;
import com.todo1.kardexSpring.service.IShopCartService;

@Service
@SessionScope
@Transactional(readOnly = true)
public class ShopCartServiceImp implements IShopCartService {

	private Map<KardexID, Kardex> shopCart;

	@PostConstruct
	public void init() {
		shopCart = new HashMap<>();
	}

	@Override
	public void add(Kardex item) {
		shopCart.put(item.getId(), item);
	}

	@Override
	public Kardex findById(KardexID id) {

		Optional<Kardex> IsKardexInCart = Optional.ofNullable(this.shopCart.get(id));

		return IsKardexInCart.orElse(null);
	}

	public Map<KardexID, Kardex> getShopCart() {
		return shopCart;
	}


	@Override
	public void buyCart(Factura factura, Factura_Registro_Kardex registroKardex) {
		// TODO Auto-generated method stub
		
	}
	
	

}
