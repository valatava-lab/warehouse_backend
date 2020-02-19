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
 * A item.
 *
 * @author Yuriy Govorushkin
 */
@Entity
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameItem;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<Store> stores;
}
