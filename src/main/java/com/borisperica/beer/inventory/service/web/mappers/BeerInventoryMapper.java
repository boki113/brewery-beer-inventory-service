package com.borisperica.beer.inventory.service.web.mappers;

import com.borisperica.beer.inventory.service.domain.BeerInventory;
import com.borisperica.brewery.model.events.BeerInventoryDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerInventoryMapper {

    BeerInventory beerInventoryDtoToBeerInventory(BeerInventoryDto beerInventoryDTO);

    BeerInventoryDto beerInventoryToBeerInventoryDto(BeerInventory beerInventory);
}
