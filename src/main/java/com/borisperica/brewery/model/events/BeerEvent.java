package com.borisperica.brewery.model.events;

import com.borisperica.brewery.model.BeerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeerEvent implements Serializable {

    private BeerDto beerDto;
}
