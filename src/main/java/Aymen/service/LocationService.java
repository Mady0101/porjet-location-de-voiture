package Aymen.service;

import Aymen.exception.CustomException;
import Aymen.repository.CarRepository;
import Aymen.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import Aymen.model.Location;
import Aymen.repository.LocationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    private final CarRepository carRepository;

    private final UserRepository userRepository;

    public Location addLocation(Location location){
        if(carRepository.existsById(location.getCar().getImmatriculation())&&
        userRepository.existsById(location.getUser().getId())){
            return locationRepository.save(location);
        }
        else
            throw new CustomException("The car or user not found", HttpStatus.NOT_FOUND);
    }

    public Location updateLocation(Location location){
        Optional<Location> fetchedLocation = locationRepository.findById(location.getId());
        if(fetchedLocation.isPresent()){
            return locationRepository.save(location);
        }
        throw new CustomException("The location not found", HttpStatus.NOT_FOUND);
    }

    public void deleteLocation(Location location){
        locationRepository.deleteById(location.getId());
    }

    public Optional<Location> findById(Location location){
        return locationRepository.findById(location.getId());
    }

    public List<Location> findAll(){
        return locationRepository.findAll();
    }
}
