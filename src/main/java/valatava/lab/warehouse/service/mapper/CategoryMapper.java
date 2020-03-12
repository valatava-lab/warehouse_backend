package valatava.lab.warehouse.service.mapper;

import java.util.List;
import valatava.lab.warehouse.model.Category;
import valatava.lab.warehouse.service.dto.CategoryDTO;

/**
 * @author Yuriy Govorushkin
 */
public interface CategoryMapper {

    List<CategoryDTO> toDTOs(List<Category> categories);

    CategoryDTO toDTO(Category category);

    Category toEntity(CategoryDTO categoryDTO);
}
