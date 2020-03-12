package valatava.lab.warehouse.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import valatava.lab.warehouse.exeption.CreatedEntityIdException;
import valatava.lab.warehouse.exeption.UpdatedEntityIdException;
import valatava.lab.warehouse.service.CategoryService;
import valatava.lab.warehouse.service.dto.CategoryDTO;
import valatava.lab.warehouse.service.mapper.CategoryMapper;

/**
 * REST controller for managing the categories.
 *
 * @author Yuriy Govorushkin
 */
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping
    public List<CategoryDTO> getAllCategory() {
        return categoryMapper.toDTOs(categoryService.findAll());
    }

    @GetMapping("{id}")
    public CategoryDTO getCategory(@PathVariable Long id) {
        return categoryMapper.toDTO(categoryService.findCategory(id));
    }

    @PostMapping
    public void saveCategory(@RequestBody CategoryDTO categoryDTO) {
        if (categoryDTO.getId() != null) {
            throw new CreatedEntityIdException();
        }
        categoryService.save(categoryMapper.toEntity(categoryDTO));
    }

    @PutMapping
    public void updateCategory(@RequestBody CategoryDTO categoryDTO) {
        if (categoryDTO.getId() == null) {
            throw new UpdatedEntityIdException();
        }
        categoryService.save(categoryMapper.toEntity(categoryDTO));
    }
}
