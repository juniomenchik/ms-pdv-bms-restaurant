package br.com.menchitech.ms_pdv_bms_restaurant.application.facade.categoria;

import br.com.menchitech.ms_pdv_bms_restaurant.api.dto.ResponseDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.categoria.CategoriaProdutoRequestDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.mapper.CategoriaApplicationMapper;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.service.categoria.CategoriasService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoriaFacadeImpl implements CategoriaFacade {

    private CategoriasService categoriasService;

    @Override
    public ResponseDTO list() {

        var categorias = this.categoriasService.list();

        var categoriasDTO = CategoriaApplicationMapper.INSTANCE.toRESVOList(categorias);

        return ResponseDTO.builder()
            .data(categoriasDTO)
            .message("Categorias listadas com sucesso.")
            .status("SUCCESS")
            .build();
    }

    @Override
    public ResponseDTO findById(String id) {

        var categoriaResVO = this.categoriasService.findById(id);

        var categoriaDTO = CategoriaApplicationMapper.INSTANCE.toRES(categoriaResVO);

        return ResponseDTO.builder()
            .data(categoriaDTO)
            .message("Categoria encontrada com sucesso.")
            .status("SUCCESS")
            .build();
    }

    @Override
    public ResponseDTO create(CategoriaProdutoRequestDTO objetoDTO) {

        var categoriaResVO = this.categoriasService.create(
            CategoriaApplicationMapper.INSTANCE.toVO(objetoDTO)
        );

        return ResponseDTO.builder()
            .data(CategoriaApplicationMapper.INSTANCE.toRES(categoriaResVO))
            .message("Categoria criada com sucesso.")
            .status("SUCCESS")
            .build();
    }

    @Override
    public void deleteById(String id) {
        this.categoriasService.delete(id);
    }

}
