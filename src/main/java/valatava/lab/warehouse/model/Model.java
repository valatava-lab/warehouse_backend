package valatava.lab.warehouse.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Data;

/**
 * A model.
 *
 * @author Yuriy Govorushkin
 */
@Entity
@Data
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameModel;
    private String codeModel;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_id")
    private Price price;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "model")
    private Warehouse warehouse;
}
