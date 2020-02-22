package valatava.lab.warehouse.service;

import java.util.List;
import org.springframework.stereotype.Service;
import valatava.lab.warehouse.model.Car;
import valatava.lab.warehouse.repository.CarRepository;

/**
 * Service class for managing cars.
 *
 * @author Yuriy Govorushkin
 */
@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void addCar(Car car) {
        carRepository.save(car);
    }

    public List<Car> findAllCar() {
        return carRepository.findAll();
    }

    public Car findCar(Long id) {
        return carRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}
