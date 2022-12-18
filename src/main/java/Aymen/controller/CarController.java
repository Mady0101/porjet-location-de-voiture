package Aymen.controller;


import Aymen.dto.CarRequestDTO;
import Aymen.model.Car;
import Aymen.service.CarService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@Api(tags = "cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    private final ModelMapper modelMapper;

    @PostMapping("/addCar")
    @ApiOperation(value = "${CarController.addCar}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 422, message = "Invalid Car data supplied")})
    public Car addCar(//
                        @ApiParam("Car") @RequestBody CarRequestDTO carRequest){
        return carService.addCar(modelMapper.map(carRequest , Car.class));
    }

    @PutMapping("/updateCar")
    @ApiOperation(value = "${CarController.updateCar}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 422, message = "Invalid Car data supplied")})
    public Car updateCar(//
                       @ApiParam("Car") @RequestBody CarRequestDTO carRequest){
        return carService.updateCar(modelMapper.map(carRequest , Car.class));
    }

    @DeleteMapping("/deleteCar")
    @ApiOperation(value = "${CarController.deleteCar}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 422, message = "Invalid Car data supplied")})
    public void deleteCar(//
                          @ApiParam("Car") @RequestBody CarRequestDTO carRequest){
        carService.deleteCar(modelMapper.map(carRequest , Car.class));
    }

    @GetMapping("/")
    @ApiOperation(value = "${CarController.getAllCars}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 422, message = "There's no cars")})
    public List<Car> getAllCars(){
        return carService.findAll();
    }
}
