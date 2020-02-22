package valatava.lab.warehouse.controller;

import java.util.List;
import liquibase.exception.DatabaseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import valatava.lab.warehouse.exeption.CreatedEntityIdException;
import valatava.lab.warehouse.exeption.UpdatedEntityIdException;
import valatava.lab.warehouse.service.CarService;
import valatava.lab.warehouse.service.dto.CarDTO;
import valatava.lab.warehouse.service.mapper.CarMapper;

/**
 * REST controller for managing cars.
 *
 * @author Yuriy Govorushkin
 */
@RestController
@RequestMapping("/model/car")
public class CarController {

    private final CarService carService;
    private final CarMapper carMapper;

    public CarController(CarService carService, CarMapper carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @GetMapping
    public List<CarDTO> getAllCar() {
        return carMapper.toDTOs(carService.findAllCar());
    }

    @GetMapping("/{id}")
    public CarDTO getCar(@PathVariable Long id) {
        return carMapper.toDTO(carService.findCar(id));
    }

    @PostMapping
    public void saveCar(@RequestBody CarDTO carDTO) throws CreatedEntityIdException, DatabaseException {
        if (carDTO.getId() != null) {
            throw new CreatedEntityIdException();
        }
        carService.addCar(carMapper.toEntity(carDTO));
    }

    @PutMapping
    public void updateCar(@RequestBody CarDTO carDTO) throws UpdatedEntityIdException, DatabaseException {
        if (carDTO.getId() == null) {
            throw new UpdatedEntityIdException();
        }
        carService.addCar(carMapper.toEntity(carDTO));
    }
}
