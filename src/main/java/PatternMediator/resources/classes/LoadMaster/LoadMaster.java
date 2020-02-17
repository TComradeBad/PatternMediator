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
        Cargo cargo = this.findCargoforAirship(airship);
        if (!Objects.isNull(cargo)) {

        }
    }

    /**
     *
     * @param cargo
     */
    public void cargoArrived(Cargo cargo) {
        this.addCargo(cargo);
        this.sortCargoQueue();
        Airship airship = this.findAirshipforCargo(cargo);
        if (!Objects.isNull(airship)) {

        }
    }

    /**
     *
     * @param cargo
     * @return
     */
    public Airship findAirshipforCargo(Cargo cargo) {
        Airship result = null;
        for (Airship airship : this.airshipsQueue) {
            if (airship.getDestination() == cargo.getDestination()) {
                result = airship;
                break;
            }
        }
        return result;

    }

    /**
     *
     * @param airship
     * @return
     */
    public Cargo findCargoforAirship(Airship airship) {
        Cargo result = null;
        for (Cargo cargo : this.cargosQueue) {
            if (airship.getDestination() == cargo.getDestination()) {
                result = cargo;
                break;
            }
        }
        return result;
    }

    /**
     *
     */
    public void loadQueues() {
        this.sortCargoQueue();

    }

    /**
     *
     * @param cargo
     * @param airship
     * @return
     */
    public boolean loadCargoToAirship(Cargo cargo, Airship airship) {
        boolean result = false;
        List<CargoSector> cargoSectors = airship.getSectors();
        for (CargoSector sector : cargoSectors) {
            if (sector.loadCargo(cargo)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Sort Cargo Queue by priority
     */
    public void sortCargoQueue() {
        this.cargosQueue.sort((Cargo o1, Cargo o2) -> o2.getCargoType().getPriority() - o1.getCargoType().getPriority());
    }
}
