package br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_estoque")
public class EstoquePersistenceEntity {

     @Id
     @GeneratedValue
     @UuidGenerator
     @Column(name = "id", updatable = false, nullable = false)
     private UUID id;

     private String                      nomeEstoque;

     @OneToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "produto_id", nullable = false)
     private ProdutoPersistenceEntity produto;

     private Integer                     quantidadeGuardada;
     private Double                      precoSomaVenda;
     private Double                      precoSomaCusto;
}
