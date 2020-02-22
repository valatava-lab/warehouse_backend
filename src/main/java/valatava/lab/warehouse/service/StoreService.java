package valatava.lab.warehouse.service;

import java.util.List;
import org.springframework.stereotype.Service;
import valatava.lab.warehouse.model.Store;
import valatava.lab.warehouse.repository.StoreRepository;

/**
 * Service class for managing store.
 *
 * @author Yuriy Govorushkin
 */
@Service
public class StoreService {

    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public void addStore(Store store) {
        storeRepository.save(store);
    }

    public List<Store> findAllStore() {
        return storeRepository.findAll();
    }

    public Store findStore(Long id) {
        return storeRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}
