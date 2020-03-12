package valatava.lab.warehouse.service.mapper.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import valatava.lab.warehouse.model.Category;
import valatava.lab.warehouse.service.dto.CategoryDTO;
import valatava.lab.warehouse.service.mapper.CategoryMapper;

/**
 * Mapper for the entity {@link Category} and its DTO called {@link CategoryDTO}.
 *
 * @author Yuriy Govorushkin
 */
@Service
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public List<CategoryDTO> toDTOs(List<Category> categories) {
        return categories.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO toDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setDescription(category.getDescription());
        return categoryDTO;
    }

    @Override
    public Category toEntity(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setDescription(categoryDTO.getDescription());
        return category;
    }
}
