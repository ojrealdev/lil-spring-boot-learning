package com.frankmoley.lil.learningspring.webservice;

import com.frankmoley.lil.learningspring.business.GuestsListing;
import com.frankmoley.lil.learningspring.business.GuestsListingService;
import com.frankmoley.lil.learningspring.data.Guest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GuestListingController {
    private final GuestsListingService guestsListingService;

    public GuestListingController(GuestsListingService guestsListingService) {
        this.guestsListingService = guestsListingService;
    }

    @RequestMapping(path="/guests", method=RequestMethod.GET)
    public List<Guest> getGuests() {
        return this.guestsListingService.getAllGuests();
    }

}
