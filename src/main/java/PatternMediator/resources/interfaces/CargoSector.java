/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternMediator.resources.interfaces;

import PatternMediator.resources.enums.CargoSectorTypes;
import java.util.List;

/**
 *
 * @author comrade
 */
public interface CargoSector {

    public CargoSectorTypes getCargoSectorType();

    public boolean loadCargo(Cargo cargo);

    public Cargo unloadCargo(Cargo cargo);

    public Integer getTotalSpace();

    public Integer getUsedSpace();

    public boolean checkCargo(Cargo cargo);

    public List<Cargo> getLoadedCargos();

    public List<Cargo> freeCargoSector();
}
