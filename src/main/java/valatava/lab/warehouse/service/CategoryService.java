package valatava.lab.warehouse.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import valatava.lab.warehouse.model.Category;
import valatava.lab.warehouse.repository.CategoryRepository;

/**
 * Service class for managing categories.
 *
 * @author Yuriy Govorushkin
 */
@Service
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }
}
