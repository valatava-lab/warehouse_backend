package valatava.lab.warehouse.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Data;

/**
 * A warehouse.
 *
 * @author Yuriy Govorushkin
 */
@Entity
@Data
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long quantity;

    @OneToOne(fetch = FetchType.LAZY)
    private Model model;
}
