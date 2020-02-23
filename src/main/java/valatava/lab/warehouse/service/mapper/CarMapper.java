package valatava.lab.warehouse.service.mapper;

import java.util.List;
import valatava.lab.warehouse.model.Car;
import valatava.lab.warehouse.service.dto.CarDTO;

/**
 * @author Yuriy Govorushkin
 */
public interface CarMapper {

    List<CarDTO> toDTOs(List<Car> cars);

    CarDTO toDTO(Car car);

    Car toEntity(CarDTO carDTO);
}
