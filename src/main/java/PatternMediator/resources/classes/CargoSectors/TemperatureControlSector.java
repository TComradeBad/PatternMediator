/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternMediator.resources.classes.CargoSectors;

import PatternMediator.resources.enums.CargoSectorTypes;
import PatternMediator.resources.interfaces.Cargo;
import PatternMediator.resources.interfaces.CargoSector;

/**
 *
 * @author comrade
 */
public class TemperatureControlSector extends AbstractCargoSector implements CargoSector {

    public TemperatureControlSector(Integer space) {
        super(space, CargoSectorTypes.TemperatureControl);
    }

    /**
     * Check cargo type
     *
     * @param cargo
     * @return
     */
    @Override
    public boolean checkCargo(Cargo cargo) {
        boolean result = false;

        switch (cargo.getCargoType()) {

            case Default:
                result = true;
                break;

            case Living:
                result = false;
                break;

            case Danger:
                result = true;
                break;

            case Perishable:
                result = true;
                break;

            default:
                result = false;
                break;
        }
        return result;
    }
}
