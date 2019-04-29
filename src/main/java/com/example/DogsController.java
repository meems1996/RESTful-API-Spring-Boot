package com.example;

import org.springframework.web.bind.annotation.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;


@RestController
public class DogsController {

    private final AtomicLong counter = new AtomicLong();
    private Map<Long, Dog> dogsMap = new HashMap<>();

//    -------------------------- List all dogs --------------------------
    @GetMapping("/dogs")
    public Map<Long, Dog> dogs() {
        // return dogs hashmap
        return dogsMap;
    }

//   -------------------------- Add a new dog :) --------------------------
    @PostMapping(value = "/dogs")
    public Dog postDog(@RequestBody Dog dog) throws IOException {
        // increment and get id
        long dogId = counter.incrementAndGet();

        // set dog to a dog id
        dog.setId(dogId);

        // put dog in the hashmap
        dogsMap.put(dogId, dog);

        // write to file
        FileWriter writer = new FileWriter("dogs.json");
        writer.write(dogsMap.toString());
        writer.flush();
        writer.close();

        // return dog
        return dog;
    }

//   -------------------------- Get details for one dog --------------------------
    @GetMapping("/dogs/{id}")
    public Dog getDogById(@PathVariable(value = "id") long id) {
        return dogsMap.get(id);
    }

//   -------------------------- Update details for one dog --------------------------
    @PutMapping("/dogs/{id}")
    public Dog updateDog(@PathVariable long id, @RequestBody Dog dog) {
        return dogsMap.replace(id, dog);
    }
//   -------------------------- Remove a dog :( --------------------------
    @DeleteMapping("/dogs/{id}")
    public void removeDog(@PathVariable(value = "id") long id) {
        dogsMap.remove(id);
    }


}