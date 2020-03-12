package valatava.lab.warehouse.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

/**
 * A category.
 *
 * @author Yuriy Govorushkin
 */
@Entity
@Data
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    private String description;
}
