package valatava.lab.warehouse.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

/**
 * A product.
 *
 * @author Yuriy Govorushkin
 */
@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameProduct;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Model> model;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "product")
    private List<Manufacturer> manufacturer;
}
