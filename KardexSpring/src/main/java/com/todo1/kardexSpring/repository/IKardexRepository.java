package com.todo1.kardexSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.todo1.kardexSpring.model.Kardex;
import com.todo1.kardexSpring.model.embeddedId.KardexID;

@Repository
public interface IKardexRepository  extends JpaRepository<Kardex, KardexID>{

	@Query("SELECT k FROM Kardex k WHERE k.unidadesActuales > 0")
	 List<Kardex> findAllStockProducts();


}
