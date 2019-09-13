package br.com.seanfla.webfenix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.seanfla.webfenix.model.ClienteModel;

public interface ClientesRepository extends JpaRepository<ClienteModel, Long>{

}
