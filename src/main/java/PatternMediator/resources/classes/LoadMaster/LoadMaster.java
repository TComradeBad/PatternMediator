/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternMediator.resources.classes.LoadMaster;

import PatternMediator.resources.interfaces.Airship;
import PatternMediator.resources.interfaces.Cargo;
import PatternMediator.resources.interfaces.Mediator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    public void airshipArrived(Airship airship) {
    }

    public void cargoArrived(Cargo cargo) {
    }
}
