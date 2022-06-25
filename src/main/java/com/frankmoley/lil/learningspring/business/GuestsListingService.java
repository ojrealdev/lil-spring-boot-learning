package com.frankmoley.lil.learningspring.business;

import com.frankmoley.lil.learningspring.data.Guest;
import com.frankmoley.lil.learningspring.data.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GuestsListingService {
    private final GuestRepository guestRepository;

    public GuestsListingService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<GuestsListing> getAllGuests() {
        Iterable<Guest> guests = this.guestRepository.findAll();
        Map<Long, GuestsListing> guestsListingMap = new HashMap();
        guests.forEach(guest -> {
            GuestsListing guestsListing = new GuestsListing();
            guestsListing.setGuestId(guest.getId());
            guestsListing.setAddress(guest.getAdress());
            guestsListing.setCountry(guest.getCountry());
            guestsListing.setFirstName(guest.getFirstName());
            guestsListing.setLastName(guest.getLastName());
            guestsListing.setEmailAddress(guest.getEmailAddress());
            guestsListing.setState(guest.getState());
            guestsListing.setPhoneNumber(guest.getPhoneNumber());
            guestsListingMap.put(guest.getId(), guestsListing);
        });
        List<GuestsListing> guestsListings = new ArrayList<>();
        for (Long id : guestsListingMap.keySet()) {
            guestsListings.add(guestsListings.get(Math.toIntExact(id)));
        }
        return guestsListings;
    }
}
