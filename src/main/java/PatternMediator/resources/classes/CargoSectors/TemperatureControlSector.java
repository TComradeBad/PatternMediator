/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternMediator.resources.classes.CargoSectors;

import PatternMediator.resources.enums.CargoSectorTypes;
import PatternMediator.resources.interfaces.CargoSector;

/**
 *
 * @author comrade
 */
public class TemperatureControlSector extends AbstractCargoSector implements CargoSector{

    public TemperatureControlSector(Integer space) {
        super(space,CargoSectorTypes.TemperatureControl);
    }
}
