/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternMediator.resources.interfaces;

import PatternMediator.resources.enums.CargoTypes;

/**
 *
 * @author comrade
 */
public interface Cargo {

    public CargoTypes getCargoType();

    public Integer getCargoSize();

    public Airport getDestination();

    public void cargoArrived();
}
