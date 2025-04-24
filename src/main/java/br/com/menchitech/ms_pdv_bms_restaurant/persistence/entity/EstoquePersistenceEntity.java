package br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name = "tb_estoque")
public class EstoquePersistenceEntity {
    
    @Id
    private Long                        id;

    // @OneToOne
    // private ProdutoPersistenceEntity    produto;
    private Integer                     quantidadeUnitaria;
    private Double                      precoTotalVenda;
    private Double                      precoTotalCusto;

    public EstoquePersistenceEntity(
        // ProdutoPersistenceEntity produto,
        Integer quantidadeUnitaria,
        Double precoTotalVenda,
        Double precoTotalCusto) {

        // this.produto = produto;
        this.quantidadeUnitaria = quantidadeUnitaria;
        this.precoTotalVenda = precoTotalVenda;
        this.precoTotalCusto = precoTotalCusto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // public ProdutoPersistenceEntity getProduto() {
    //     return produto;
    // }

    // public void setProduto(ProdutoPersistenceEntity produto) {
    //     this.produto = produto;
    // }

    public Integer getQuantidadeUnitaria() {
        return quantidadeUnitaria;
    }

    public void setQuantidadeUnitaria(Integer quantidadeUnitaria) {
        this.quantidadeUnitaria = quantidadeUnitaria;
    }

    public Double getPrecoTotalVenda() {
        return precoTotalVenda;
    }

    public void setPrecoTotalVenda(Double precoTotalVenda) {
        this.precoTotalVenda = precoTotalVenda;
    }

    public Double getPrecoTotalCusto() {
        return precoTotalCusto;
    }

    public void setPrecoTotalCusto(Double precoTotalCusto) {
        this.precoTotalCusto = precoTotalCusto;
    }

}
