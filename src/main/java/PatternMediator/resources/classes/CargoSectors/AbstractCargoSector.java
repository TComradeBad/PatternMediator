/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternMediator.resources.classes.CargoSectors;

import PatternMediator.resources.enums.CargoSectorTypes;
import PatternMediator.resources.interfaces.Cargo;
import PatternMediator.resources.interfaces.CargoSector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author comrade
 */
public abstract class AbstractCargoSector implements CargoSector {

    /**
     * Total space that have sector
     */
    private final Integer TotalSpace;

    /**
     * Used space in Cargo
     */
    private Integer UsedSpace;

    /**
     * Cargo Sector Type
     */
    private final CargoSectorTypes type;

    /**
     * Cargo inside sector
     */
    private final List<Cargo> loadedCargo;

    /**
     * Sector Constructor
     *
     * @param space
     * @param type
     */
    public AbstractCargoSector(Integer space, CargoSectorTypes type) {

        this.loadedCargo = new ArrayList<>();
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
     * Get list of sector's cargos
     *
     * @return
     */
    @Override
    public List<Cargo> getLoadedCargos() {
        return this.loadedCargo;
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

        if (this.checkCargo(cargo) && (this.getFreeSpace() >= cargo.getCargoSize())) {
            this.UsedSpace = this.UsedSpace + cargo.getCargoSize();
            this.loadedCargo.add(cargo);
            return true;
        } else {
            return false;
        }

    }

    /**
     * Remove Cargo from sector
     *
     * @param cargo
     * @return
     */
    @Override
    public Cargo unloadCargo(Cargo cargo) {
        this.loadedCargo.remove(cargo);
        this.UsedSpace = this.UsedSpace - cargo.getCargoSize();
        return cargo;
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
     * Calculate free space
     *
     * @return
     */
    public Integer getFreeSpace() {
        return (this.TotalSpace - this.UsedSpace);
    }

    /**
     * free all Cargos and return is to user
     *
     * @return
     */
    @Override
    public List<Cargo> freeCargoSector() {

        List<Cargo> cargos = new ArrayList<>();
        Collections.copy(cargos, this.loadedCargo);
        this.loadedCargo.clear();
        return cargos;
    }

  
}
