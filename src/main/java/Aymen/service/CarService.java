package Aymen.service;

import Aymen.exception.CustomException;
import lombok.RequiredArgsConstructor;
import Aymen.model.Car;
import Aymen.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public Car addCar(Car car){
        if(carRepository.existsById(car.getImmatriculation()))
            throw new CustomException("The car " +car.getImmatriculation() +" is already created", HttpStatus.UNPROCESSABLE_ENTITY);
        else
            return carRepository.save(car);
    }

    public Car updateCar(Car car){
        Optional<Car> fetchedCar = carRepository.findById(car.getImmatriculation());
        if(fetchedCar.isPresent()){
            return carRepository.save(car);
        }else
            throw new CustomException("The car " +car.getImmatriculation() +" not found", HttpStatus.NOT_FOUND);
    }

    public void deleteCar(Car car){
         carRepository.delete(car);
    }

    public Optional<Car> findById(Car car){
        return carRepository.findById(car.getImmatriculation());
    }

    public List<Car> findAll(){
        return carRepository.findAll();
    }
}
