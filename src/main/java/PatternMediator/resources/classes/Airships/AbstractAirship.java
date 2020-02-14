/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternMediator.resources.classes.Airships;

import PatternMediator.resources.interfaces.Airship;
import PatternMediator.resources.interfaces.CargoSector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author comrade
 */
public class AbstractAirship implements Airship {

    private List<CargoSector> sectors;

    public AbstractAirship(CargoSector... sectors) {
        this.sectors = new ArrayList<>();

        this.sectors.addAll(Arrays.asList(sectors));
    }
}
