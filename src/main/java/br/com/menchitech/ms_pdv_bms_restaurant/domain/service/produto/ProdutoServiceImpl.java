package br.com.menchitech.ms_pdv_bms_restaurant.domain.service.produto;

import br.com.menchitech.ms_pdv_bms_restaurant.application.exceptions.ObjectNotFoundCustomException;
import br.com.menchitech.ms_pdv_bms_restaurant.configuration.utils.ValidationGlobalUtils;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.mapper.EstoqueDomainMapper;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.mapper.ProdutoDomainMapper;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.produto.ProdutoResultVO;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.produto.ProdutoVO;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.CategoriaProdutoPersistenceEntity;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.EstoquePersistenceEntity;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.ProdutoPersistenceEntity;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository.categoria.CategoriaCustomRepository;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository.estoque.EstoqueCustomRepository;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository.produto.ProdutoCustomRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private ProdutoCustomRepository produtoCustomRepository;
    private EstoqueCustomRepository estoqueCustomRepository;
    private CategoriaCustomRepository categoriaCustomRepository;

    @Override
    public List<ProdutoResultVO> list() {
        var produtos = produtoCustomRepository.list();
        return ProdutoDomainMapper.INSTANCE.toRESVOList(produtos);
    }

    @Override
    public ProdutoResultVO findById(String id) {

        var obj = this.produtoCustomRepository.findById(ValidationGlobalUtils.toUUID(id));

        if (obj.isPresent()) {
            return ProdutoDomainMapper.INSTANCE.toRESVO(obj.get());
        } else {
            throw new ObjectNotFoundCustomException(
                id, ProdutoPersistenceEntity.class.getName());
        }
    }

    @Override
    @Transactional
    public ProdutoResultVO create(ProdutoVO produtoVO) {

        var categoria = this.categoriaCustomRepository.findByCategoriaName(produtoVO.getCategoria());

        if (categoria.isEmpty()) {
            throw new ObjectNotFoundCustomException(
                produtoVO.getCategoria(), CategoriaProdutoPersistenceEntity.class.getName());
        }

        var prodEntity = ProdutoDomainMapper.INSTANCE.toEntity(produtoVO);
        prodEntity.setCategoria(categoria.get());

        var savedProduct = this.produtoCustomRepository.save(prodEntity);

        var savedEstoque = EstoqueDomainMapper.INSTANCE.toEntityFromProduct(savedProduct);
        this.estoqueCustomRepository.save(savedEstoque);

        return ProdutoDomainMapper.INSTANCE.toRESVO(savedProduct);
    }

    @Override
    public void delete(String id) {

        this.produtoCustomRepository.delete(ValidationGlobalUtils.toUUID(id));
    }
}
