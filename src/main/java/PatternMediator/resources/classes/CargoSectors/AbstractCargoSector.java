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
public abstract class AbstractCargoSector implements CargoSector {

    /**
     * Total space that have sector
     */
    private Integer TotalSpace;

    /**
     * Used space in Cargo
     */
    private Integer UsedSpace;

    /**
     * Cargo Sector Type
     */
    private CargoSectorTypes type;

    /**
     * Sector Constructor
     *
     * @param space
     * @param type
     */
    public AbstractCargoSector(Integer space, CargoSectorTypes type) {

        this.TotalSpace = space;
        this.UsedSpace = 0;
        this.type = type;
    }

    /**
     * Getter for CargoSector Type
     *
     * @return
     */
    @Override
    public CargoSectorTypes getCargoSectorType() {
        return this.type;
    }

    /**
     * Add Cargo into Sector
     *
     *
     * @param cargo
     * @return
     */
    @Override
    public boolean loadCargo(Cargo cargo) {

        if (this.checkCargo(cargo) && this.TotalSpace >= cargo.getCargoSize()) {
            this.UsedSpace = cargo.getCargoSize();
            return true;
        } else {
            return false;
        }

    }

    /**
     * Getter for sector total space
     *
     * @return
     */
    @Override
    public Integer getTotalSpace() {
        return this.TotalSpace;
    }

    /**
     * Getter for Cargo used Space
     *
     * @return
     */
    @Override
    public Integer getUsedSpace() {
        return this.UsedSpace;
    }

    /**
     * Check if Sector can contain cargo
     *
     * @param cargo
     * @return
     */
    public abstract boolean checkCargo(Cargo cargo);

}
