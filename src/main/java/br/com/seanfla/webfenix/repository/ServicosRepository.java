package br.com.seanfla.webfenix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.seanfla.webfenix.model.ServicoModel;

@Repository
public interface ServicosRepository extends JpaRepository<ServicoModel, Long>{

}
