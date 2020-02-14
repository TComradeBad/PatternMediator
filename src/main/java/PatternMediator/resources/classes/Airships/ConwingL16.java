/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternMediator.resources.classes.Airships;

import PatternMediator.resources.classes.CargoSectors.DefaultSector;
import PatternMediator.resources.interfaces.Airport;
import PatternMediator.resources.interfaces.Airship;

/**
 *
 * @author comrade
 */
public class ConwingL16 extends AbstractAirship implements Airship {

    public ConwingL16(Airport destination) {
        super(destination, new DefaultSector(6));
    }
}
