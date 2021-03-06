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
public class LivingCargo extends AbstractCargo implements Cargo {

    public LivingCargo(Mediator mediator, Airport destination, Integer size) {
        super(mediator, CargoTypes.Living, size, destination);
    }
}
