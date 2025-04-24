package br.com.menchitech.ms_pdv_bms_restaurant.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.menchitech.ms_pdv_bms_restaurant.api.dto.ProdutoEstoqueDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.EstoquePersistenceEntity;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository.EstoquePersistenceRepository;

@RestController(value = "/estoque")
public class EstoqueProdutosController {
    
    // @Autowired
    // private ProdutoPersistenceRepository produtoPersistenceRepository;

    @Autowired
    private EstoquePersistenceRepository estoquePersistenceRepository;

    @GetMapping
    public ResponseEntity<List<EstoquePersistenceEntity>> getAllEstoque() {

        var estoques = estoquePersistenceRepository.findAll();

        return new ResponseEntity(estoques, null, 200);
    }

    @PostMapping
    public ResponseEntity<ProdutoEstoqueDTO> createProdutoEstoque
    (@RequestBody ProdutoEstoqueDTO produtoEstoqueDTO) {

        

        return new ResponseEntity(produtoEstoqueDTO, null, 200);
    }

}
