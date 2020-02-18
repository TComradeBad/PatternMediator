/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternMediator.resources.classes.LoadMaster;

import PatternMediator.resources.interfaces.Airship;
import PatternMediator.resources.interfaces.Cargo;
import PatternMediator.resources.interfaces.CargoSector;
import PatternMediator.resources.interfaces.Mediator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author comrade
 */
public class LoadMaster implements Mediator {
    
    private List<Airship> airshipsQueue;
    
    private List<Cargo> cargosQueue;
    
    public LoadMaster() {
        this.airshipsQueue = new ArrayList<>();
        this.cargosQueue = new ArrayList<>();
    }

    /**
     * Add airship to queue
     *
     * @param airship
     */
    public void addAirship(Airship airship) {
        this.airshipsQueue.add(airship);
    }

    /**
     * Add Airships to queuq
     *
     * @param airships
     */
    public void addAirshipGroup(Collection<? extends Airship> airships) {
        this.airshipsQueue.addAll(airships);
    }

    /**
     * Add cargo to queue
     *
     * @param cargo
     */
    public void addCargo(Cargo cargo) {
        this.cargosQueue.add(cargo);
    }

    /**
     * Add cargos to queue
     *
     * @param cargos
     */
    public void addCargoGroup(Collection<? extends Cargo> cargos) {
        this.cargosQueue.addAll(cargos);
    }

    /**
     *
     * @return
     */
    public List<Cargo> getCargosQueue() {
        return this.cargosQueue;
    }

    /**
     *
     * @return
     */
    public List<Airship> getAirshipQueue() {
        return this.airshipsQueue;
    }

    /**
     *
     * @param airship
     */
    public void airshipArrived(Airship airship) {
        this.addAirship(airship);
        List<Cargo> cargos = this.findCargosforAirship(airship);
        if (cargos.size() > 0) {
            for (Cargo cargo : cargos) {
                
            }
        }
    }

    /**
     *
     * @param cargo
     */
    public void cargoArrived(Cargo cargo) {
        this.addCargo(cargo);
        this.sortCargo(this.cargosQueue);
        List<Airship> airships = this.findAirshipsforCargo(cargo);
        if (airships.size() > 0) {
            for (Airship airship : airships) {
                if (!this.loadCargoToAirship(cargo, airship)) {
                    this.cargosQueue.add(cargo);
                }
            }
        }
    }

    /**
     *
     * @param cargo
     * @return
     */
    public List<Airship> findAirshipsforCargo(Cargo cargo) {
        List<Airship> result = new ArrayList<>();
        for (Airship airship : this.airshipsQueue) {
            if (airship.getDestination() == cargo.getDestination() && airship.checkCargo(cargo)) {
                result.add(airship);
            }
        }
        return result;
        
    }

    /**
     *
     * @param airship
     * @return
     */
    public List<Cargo> findCargosforAirship(Airship airship) {
        List<Cargo> result = new ArrayList<>();
        for (Cargo cargo : this.cargosQueue) {
            if (airship.getDestination() == cargo.getDestination() && airship.checkCargo(cargo)) {
                result.add(cargo);
            }
        }
        return result;
    }

    /**
     *
     * @param cargo
     * @param airship
     * @return
     */
    public boolean loadCargoToAirship(Cargo cargo, Airship airship) {
        boolean result = false;
        
        List<Cargo> throwedCargos = new ArrayList<>();
        List<CargoSector> cargoSectors = airship.getSectors();
        for (CargoSector sector : cargoSectors) {
            
            if (sector.checkCargo(cargo)) {
                throwedCargos.addAll(replaceCargosByPriority(cargo, sector));
            }
            if (!throwedCargos.contains(cargo)) {
                result = true;
                break;
            }
            
        }
        
        for (Cargo item : throwedCargos) {
            this.cargoArrived(item);
        }
        return result;
    }

    /**
     *
     * @param cargo
     * @param sector
     * @return
     */
    public List<Cargo> replaceCargosByPriority(Cargo cargo, CargoSector sector) {
        List<Cargo> throwedCargos = new ArrayList<>();
        List<Cargo> cargos = sector.freeCargoSector();
        cargos.add(cargo);
        this.sortCargo(cargos);
        for (Cargo item : cargos) {
            if (!sector.loadCargo(item)) {
                throwedCargos.add(item);
            }
        }
        
        return throwedCargos;
    }

    /**
     * Sort Cargo Queue by priority
     *
     * @param cargos
     */
    public void sortCargo(List<? extends Cargo> cargos) {
        cargos.sort((Cargo o1, Cargo o2) -> o2.getCargoType().getPriority() - o1.getCargoType().getPriority());
    }
}
