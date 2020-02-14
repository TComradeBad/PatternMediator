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
public abstract class AbstractCargoSector implements CargoSector {

    private Integer TotalSpace;

    private Integer UsedSpace;

    private CargoSectorTypes type;

    public AbstractCargoSector(Integer space, CargoSectorTypes type) {

        this.TotalSpace = space;
        this.type = type;
    }
}
