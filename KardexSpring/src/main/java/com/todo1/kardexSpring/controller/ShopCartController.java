package com.todo1.kardexSpring.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.todo1.kardexSpring.model.Factura;
import com.todo1.kardexSpring.model.Factura_Registro_Kardex;
import com.todo1.kardexSpring.model.Kardex;
import com.todo1.kardexSpring.model.Usuario;
import com.todo1.kardexSpring.model.embeddedId.FacturaID;
import com.todo1.kardexSpring.model.embeddedId.FacturaRegistroKardexID;
import com.todo1.kardexSpring.model.embeddedId.KardexID;
import com.todo1.kardexSpring.service.IFacturaService;
import com.todo1.kardexSpring.service.IFactura_Registro_KardexService;
import com.todo1.kardexSpring.service.IKardexService;
import com.todo1.kardexSpring.service.IShopCartService;
import com.todo1.kardexSpring.service.IUsuarioService;

import antlr.collections.List;

@Controller
@RequestMapping("/cart")
public class ShopCartController {

	@Autowired
	private IShopCartService shopCartService;

	@Autowired
	private IUsuarioService userService;

	@Autowired
	private IFacturaService facturaService;
	
	@Autowired
	private IKardexService kardexService;
	
	@Autowired
	private IFactura_Registro_KardexService kardexRegisterService;
	

	@GetMapping("/add")
	public String add(@RequestParam(name = "idProveedor") long idProveedor,
			@RequestParam(name = "nitProveedor") String nitProveedor,
			@RequestParam(name = "idProducto") long idProducto, @RequestParam(name = "idCategoria") long idCategoria,
			@RequestParam(name = "units") long units, HttpSession session) {

		KardexID id = new KardexID().init(idProveedor, nitProveedor, idProducto, idCategoria);

		@SuppressWarnings(value = "unchecked")
		Map<KardexID, Kardex> kardexList = (Map<KardexID, Kardex>) session.getAttribute("kardexList");

		Optional<Kardex> IsProductInCart = Optional.ofNullable(shopCartService.findById(id));
		if (IsProductInCart.isPresent()) {
			IsProductInCart.get().setUnidadesActuales(IsProductInCart.get().getUnidadesActuales() + units);
			shopCartService.add(IsProductInCart.get());
			System.out.println("Already Present " + IsProductInCart.get().getUnidadesActuales());
		} else {
			Kardex currentKardex = kardexList.get(id);
			currentKardex.setUnidadesActuales(units);
			shopCartService.add(currentKardex);
		}

		return "redirect:/";

	}

	@GetMapping("/details")
	public String detalles(Model model) {
		model.addAttribute("productosCarrito", shopCartService.getShopCart());
		return "shopCartDetails";
	}

	@PreAuthorize("hasRole('USER')")
	@PostMapping("/buy")
	public String buyCart(Model model, Authentication auth) {

		Usuario current = userService.findByNit(auth.getName()).orElseThrow(null);
		if (current != null) {

//Logica para efectuar el pago			
//			//Factura Guardada
//			Factura ft = new Factura(current);
//			ft = facturaService.saveFactura(ft);
//
//			Map<KardexID, Kardex> shopCartItems = shopCartService.getShopCart();
//
//			for (Entry<KardexID, Kardex> entry : shopCartItems.entrySet()) {
//
//				//Recupero el stock actual
//				Kardex kardex = kardexService.findById(entry.getKey());
//				System.out.println(kardex);
//				
//				//Registro el movimiento
//				Factura_Registro_Kardex registro = new Factura_Registro_Kardex(				
//						kardex,
//						ft,
//						(int) entry.getValue().getUnidadesActuales(),
//						(int) (entry.getValue().getUnidadesActuales() * entry.getValue().getCostoUnitario()),
//						"descripcion", "VENTA");
//				
//				System.out.println("Registro de movimiento");
//				System.out.println(kardexRegisterService);
//				kardexRegisterService.saveFacturaRegistroKardex(registro);
//			}
//
//			
//
		}

		return "shopCartDetails";
	}
}
