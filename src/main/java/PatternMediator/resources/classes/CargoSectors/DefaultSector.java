/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternMediator.resources.classes.CargoSectors;

import PatternMediator.resources.interfaces.CargoSector;
import PatternMediator.resources.enums.CargoSectorTypes;
import PatternMediator.resources.interfaces.Cargo;

/**
 *
 * @author comrade
 */
public class DefaultSector extends AbstractCargoSector implements CargoSector {

    public DefaultSector(Integer space) {
        super(space, CargoSectorTypes.Default);
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
                result = false;
                break;

            default:
                result = false;
                break;
        }
        return result;
    }

}
