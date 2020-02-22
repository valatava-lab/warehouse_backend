package valatava.lab.warehouse.service.mapper.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import valatava.lab.warehouse.model.Car;
import valatava.lab.warehouse.service.dto.CarDTO;
import valatava.lab.warehouse.service.mapper.CarMapper;

/**
 * Mapper for the entity {@link Car} and its DTO called {@link CarDTO}.
 *
 * @author Yuriy Govorushkin
 */
@Service
public class CarMapperImpl implements CarMapper {
    @Override
    public Car toEntity(CarDTO carDTO) {
        Car car = new Car();
        car.setId(carDTO.getId());
        car.setModel(carDTO.getModel());
        return car;
    }

    @Override
    public CarDTO toDTO(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setId(car.getId());
        carDTO.setModel(car.getModel());
        return carDTO;
    }

    @Override
    public List<CarDTO> toDTOs(List<Car> cars) {
        return cars.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
