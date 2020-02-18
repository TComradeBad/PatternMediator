/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternMediator.resources.classes.Cargos;

import PatternMediator.resources.enums.CargoTypes;
import PatternMediator.resources.interfaces.Airport;
import PatternMediator.resources.interfaces.Cargo;
import PatternMediator.resources.interfaces.Mediator;

/**
 *
 * @author comrade
 */
public abstract class AbstractCargo implements Cargo {

    /**
     * Current Mediator
     */
    private final Mediator mediator;
    /**
     * Cargo destination
     */
    private Airport destination;

    /**
     * Cargo type
     */
    private CargoTypes type;

    /**
     * Size of cargo
     */
    private Integer size;

    /**
     * Cargo Constructor
     *
     * @param type
     * @param size
     */
    public AbstractCargo(Mediator mediator, CargoTypes type, Integer size, Airport destination) {
        this.mediator = mediator;
        this.type = type;
        this.size = size;
        this.destination = destination;
    }

    /**
     * Getter for CargoType
     *
     * @return
     */
    @Override
    public CargoTypes getCargoType() {
        return this.type;
    }

    /**
     * Getter for Cargo size
     *
     * @return
     */
    @Override
    public Integer getCargoSize() {
        return this.size;
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
