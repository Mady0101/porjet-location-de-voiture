package Aymen.controller;

import Aymen.dto.LocationRequestDTO;
import Aymen.dto.LocationResponseDTO;
import Aymen.model.AppUser;
import Aymen.model.Car;
import Aymen.model.Location;
import Aymen.service.LocationService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/location")
@Api(tags = "locations")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    private final ModelMapper modelMapper;

    @PostMapping("/addLocation")
    @ApiOperation(value = "${LocationController.addLocation}")
    /*@ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 422, message = "Invalid Car data supplied")})*/
    public LocationResponseDTO addLocation(//
                           @ApiParam("Location") @RequestBody LocationRequestDTO locationRequest){
        Location location = modelMapper.map(locationRequest , Location.class);
        location.setUser(new AppUser().builder()
                .id(locationRequest.getUserId())
                .build());

        location.setCar(new Car().builder()
                .immatriculation(locationRequest.getCarMatricule())
                .build());
        return modelMapper.map(locationService.addLocation(location), LocationResponseDTO.class);
    }

    @PutMapping("/updateLocation")
    @ApiOperation(value = "${LocationController.updateLocation}")
    /*@ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 422, message = "Invalid Car data supplied")})*/
    public LocationResponseDTO updateLocation(//
                                           @ApiParam("Location") @RequestBody LocationRequestDTO locationRequest){
        Location location = modelMapper.map(locationRequest , Location.class);

        return modelMapper.map(locationService.updateLocation(location), LocationResponseDTO.class);
    }


    @DeleteMapping("/deleteLocation")
    @ApiOperation(value = "${LocationController.deleteLocation}")
    /*@ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 422, message = "Invalid Car data supplied")})*/
    public void deleteLocation(//
                                              @ApiParam("Location") @RequestBody LocationRequestDTO locationRequest){
        Location location = modelMapper.map(locationRequest , Location.class);
        locationService.deleteLocation(location);
    }

    @GetMapping("/")
    @ApiOperation(value = "${LocationController.getAllLocation}")
    public List<LocationResponseDTO> getAllLocation(){
        List<LocationResponseDTO> response = new ArrayList<>();
        for(Location l : locationService.findAll()){
            response.add(modelMapper.map(l , LocationResponseDTO.class));
        }
        return response;
    }
}
