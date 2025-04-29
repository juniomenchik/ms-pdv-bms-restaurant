package br.com.menchitech.ms_pdv_bms_restaurant.domain.service.estoque;

import br.com.menchitech.ms_pdv_bms_restaurant.application.exceptions.ObjectNotFoundCustomException;
import br.com.menchitech.ms_pdv_bms_restaurant.configuration.utils.ValidationGlobalUtils;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.mapper.EstoqueDomainMapper;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.estoque.EstoqueResultVO;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.estoque.EstoqueVO;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.EstoquePersistenceEntity;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.ProdutoPersistenceEntity;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository.estoque.EstoqueCustomRepository;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository.produto.ProdutoCustomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
public class EstoqueProdutosServiceImpl implements EstoqueProdutosService {

    private EstoqueCustomRepository estoqueCustomRepository;
    private ProdutoCustomRepository produtoCustomRepository;

    @Override
    public List<EstoqueResultVO> listarEstoqueProdutos() {

        var estoques = estoqueCustomRepository.list();

        return EstoqueDomainMapper.INSTANCE.toRESVOList(estoques);
    }

    @Override
    public EstoqueResultVO buscarEstoquePorId(String id) {

        UUID objId = ValidationGlobalUtils.toUUID(id);

        var estoque = estoqueCustomRepository.findById(objId);

        if (estoque.isPresent()) {
            return EstoqueDomainMapper.INSTANCE.toRESVO(estoque.get());
        } else {
            throw new ObjectNotFoundCustomException(
                id, EstoquePersistenceEntity.class.getName());
        }
    }

    @Override
    public EstoqueResultVO cadastrarEstoque(EstoqueVO estoqueVO) {

        UUID prodId = ValidationGlobalUtils.toUUID(estoqueVO.getProdutoId());

        var savedProduct = this.produtoCustomRepository.findById(prodId)
            .orElseThrow(() -> new ObjectNotFoundCustomException(estoqueVO.getProdutoId(), ProdutoPersistenceEntity.class.getName()));

        var savedObj = this.estoqueCustomRepository.save(
            EstoqueDomainMapper.INSTANCE.toEntity(estoqueVO,savedProduct)
        );

        return EstoqueDomainMapper.INSTANCE.toRESVO(savedObj);
    }

    @Override
    public void deletarEstoque(String id) {
        UUID objId;
        try {
            objId = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid UUID format: " + id);
        }

        this.estoqueCustomRepository.delete(objId);
    }
}
