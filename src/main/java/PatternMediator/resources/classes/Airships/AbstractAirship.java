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
import PatternMediator.resources.interfaces.Mediator;
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
     * Current Mediator
     */
    private final Mediator mediator;

    /**
     * Sectors of Airship
     */
    private final List<CargoSector> sectors;

    /**
     * Airship constructor
     *
     * @param mediator
     * @param destination
     * @param sectors
     */
    protected AbstractAirship(Mediator mediator, Airport destination, CargoSector... sectors) {
        this.destination = destination;
        this.mediator = mediator;
        this.sectors = new ArrayList<>();
        this.sectors.addAll(Arrays.asList(sectors));
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

    /**
     * Get Sectors of airship
     *
     * @return
     */
    @Override
    public List<CargoSector> getSectors() {
        return this.sectors;
    }

    /**
     * Check cargo by airship
     *
     * @param cargo
     * @return
     */
    @Override
    public boolean checkCargo(Cargo cargo) {
        boolean result = false;
        for (CargoSector sector : this.sectors) {
            if (sector.checkCargo(cargo)) {
                result = true;
                break;
            }
        }
        return result;
    }
    
    /**
     * Mediator airship Event
     */
    @Override
    public void airshipArrived() {
        this.mediator.airshipArrived(this);
    }
    
}
