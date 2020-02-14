/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternMediator.resources.classes.CargoSectors;

import PatternMediator.resources.interfaces.CargoSector;
import PatternMediator.resources.enums.CargoSectorTypes;
import PatternMediator.resources.enums.CargoTypes;
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

        return true;
    }

}
