/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternMediator.resources.classes.Airships;

import PatternMediator.resources.classes.CargoSectors.GermeticSector;
import PatternMediator.resources.classes.CargoSectors.TemperatureControlSector;
import PatternMediator.resources.interfaces.Airport;
import PatternMediator.resources.interfaces.Airship;
import PatternMediator.resources.interfaces.Mediator;

/**
 *
 * @author comrade
 */
public class Enterprise extends AbstractAirship implements Airship {

    public Enterprise(Mediator mediator, Airport destination) {
        super(
                mediator,
                destination,
                new GermeticSector(30),
                new TemperatureControlSector(20)
        );
    }
}
