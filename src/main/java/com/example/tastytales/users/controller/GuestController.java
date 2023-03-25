package com.example.tastytales.users.controller;

import com.example.tastytales.contents.module.RecipeDao;
import com.example.tastytales.contents.module.entities.Recipe;
import com.example.tastytales.users.module.dao.GuestDao;
import com.example.tastytales.users.module.entities.Guest;
import jakarta.validation.Valid;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    private GuestDao guestRepository;

    @Autowired
    private RecipeDao recipeRepository;

    // GET /guest/all
    @GetMapping("/all")
    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    // GET /guest/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable(value="id") Long guestId)
            throws ResourceNotFoundException {
        Guest guest=guestRepository.findById(guestId)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not found for this id :: " + guestId));
        return ResponseEntity.ok().body(guest);
    }

    // POST /guest/create
    @PostMapping("/create")
    public Guest createGuest(@Valid @RequestBody Guest guest) {
        return guestRepository.save(guest);
    }

    // PUT /guest/update/{id}
    @PutMapping("update/{id}")
    public ResponseEntity<Guest> updateGuest(@PathVariable(value="id") Long guestId,
                                             @Valid @RequestBody Guest guestDetails) throws ResourceNotFoundException {
        Guest guest=guestRepository.findById(guestId)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not found for this id :: " + guestId));

        guest.setName(guestDetails.getName());
        guest.setUser(guestDetails.getUser());
        guest.setFavoriteRecipes(guestDetails.getFavoriteRecipes());
        final Guest updatedGuest=guestRepository.save(guest);
        return ResponseEntity.ok(updatedGuest);
    }

    // DELETE /guest/delete/{id}
    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteGuest(@PathVariable(value="id") Long guestId)
            throws ResourceNotFoundException {
        Guest guest=guestRepository.findById(guestId)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not found for this id :: " + guestId));

        guestRepository.delete(guest);
        Map<String, Boolean> response=new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping("/{guestId}/favoriteRecipes/{recipeId}")
    public ResponseEntity<Void> addFavoriteRecipe(@PathVariable Long guestId, @PathVariable Long recipeId) {
        Guest guest=guestRepository.findById(guestId)
                .orElseThrow(() -> new ResourceNotFoundException("Guest " + guestId));
        Recipe recipe=recipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe " + recipeId));

        guest.getFavoriteRecipes().add(recipe);
        guestRepository.save(guest);
        recipeRepository.increaseLikes(recipeId);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{guestId}/favoriteRecipes/{recipeId}")
    public ResponseEntity<Void> removeFavoriteRecipe(@PathVariable Long guestId, @PathVariable Long recipeId) {
        Guest guest=guestRepository.findById(guestId)
                .orElseThrow(() -> new ResourceNotFoundException("Guest " + guestId));
        Recipe recipe=recipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe " + recipeId));

        guest.getFavoriteRecipes().remove(recipe);
        guestRepository.save(guest);
        recipeRepository.decreaseLikes(recipeId);

        return ResponseEntity.ok().build();
    }
}

