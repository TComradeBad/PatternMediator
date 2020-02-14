/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternMediator.resources.classes.Airships;

import PatternMediator.resources.interfaces.Airport;
import PatternMediator.resources.interfaces.Airship;
import PatternMediator.resources.interfaces.Cargo;
import PatternMediator.resources.interfaces.CargoSector;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

/**
 *
 * @author comrade
 */
public abstract class AbstractAirship implements Airship {

    /**
     * Destination of airship
     */
    private final Airport destination;
    /**
     * Sectors of Airship
     */
    private final List<CargoSector> sectors;

    /**
     * Airship constructor
     *
     * @param destination
     * @param sectors
     */
    public AbstractAirship(Airport destination, CargoSector... sectors) {
        this.destination = destination;
        this.sectors = new ArrayList<>();
        this.sectors.addAll(Arrays.asList(sectors));
    }

    /**
     * Load cargo in one of the Airship sectors
     *
     * @param cargo
     */
    @Override
    public void loadCargo(Cargo cargo) {

        for (CargoSector sector : this.sectors) {

            if (sector.checkCargo(cargo)) {
                sector.loadCargo(cargo);
                break;
            }

        }

    }

    /**
     * Getter for airship destination;
     *
     * @return
     */
    @Override
    public Airport getDestination() {
        return this.destination;
    }

}
