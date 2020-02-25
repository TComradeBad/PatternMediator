/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternMediator.resources.interfaces;

import java.util.List;

/**
 *
 * @author comrade
 */
public interface Airship {

    public Airport getDestination();

    public List<CargoSector> getSectors();

    public boolean checkCargo(Cargo cargo);
    
    public void airshipArrived();

}
