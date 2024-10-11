package com.kapil.springbootrest.Controller;

import com.kapil.springbootrest.component.Profile;
import com.kapil.springbootrest.service.ProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class personResource {

    @Autowired
    ProfileServiceImpl profileService;

    @GetMapping("/{id}")
    public Profile getProfile(@PathVariable Integer id) {
        return profileService.getProfile(id);
    }

    @GetMapping()
    public List<Profile> getProfileByParams() {
        return profileService.getAllProfiles();
    }


//    @GetMapping()
//    public Profile getProfileByParams(@RequestParam Integer id) {
//        return profileService.getProfile(id);
//    }

//    @GetMapping()
//    public Profile getProfileByParamsWithDifferentVariablename(@RequestParam(name="id") Integer PersonId) {
//        return profileService.getProfile(PersonId);
//    }

    @PostMapping("/create")
    public Profile addProfile(@RequestBody Profile profile) {
       return profileService.createProfile(profile);
    }

    @DeleteMapping("{id}")
    public List<Profile> deleteProfile(@PathVariable Integer id) {
       return profileService.deleteProfile(id);
    }

    @PutMapping()
    public Profile updateProfile(@RequestBody Profile profile) {
        return profileService.updateProfile(profile);
    }

}
