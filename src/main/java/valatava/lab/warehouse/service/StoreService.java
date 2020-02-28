package valatava.lab.warehouse.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import valatava.lab.warehouse.model.Store;
import valatava.lab.warehouse.repository.StoreRepository;

/**
 * Service class for managing stores.
 *
 * @author Yuriy Govorushkin
 */
@Service
@Transactional
public class StoreService {

    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public void save(Store store) {
        storeRepository.save(store);
    }

    public Store findStore(Long id) {
        return storeRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public List<Store> findAll() {
        return storeRepository.findAll();
    }
}
