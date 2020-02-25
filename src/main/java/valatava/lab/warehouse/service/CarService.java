package valatava.lab.warehouse.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import valatava.lab.warehouse.model.Car;
import valatava.lab.warehouse.repository.CarRepository;

/**
 * Service class for managing cars.
 *
 * @author Yuriy Govorushkin
 */
@Service
@Transactional
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car findCar(Long id) {
        return carRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public void save(Car car) {
        carRepository.save(car);
    }
}
