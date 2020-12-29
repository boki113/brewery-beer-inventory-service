package com.borisperica.beer.inventory.service.services;

import com.borisperica.brewery.model.BeerDto;
import com.borisperica.brewery.model.events.NewInventoryEvent;
import com.borisperica.beer.inventory.service.config.JmsConfig;
import com.borisperica.beer.inventory.service.domain.BeerInventory;
import com.borisperica.beer.inventory.service.repositories.BeerInventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class NewInventoryListener {

    private final BeerInventoryRepository beerInventoryRepository;

    @JmsListener(destination = JmsConfig.NEW_INVENTORY_QUEUE)
    public void listen(NewInventoryEvent event){
        log.debug("inventory: " + event.toString());
        BeerDto beerDto = event.getBeerDto();

        beerInventoryRepository.save(BeerInventory.builder()
            .beerId(beerDto.getId())
            .upc(beerDto.getUpc())
            .quantityOnHand(beerDto.getQuantityOnHand())
            .build()
        );


    }
}
