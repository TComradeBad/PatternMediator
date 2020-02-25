/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternMediator;

import PatternMediator.resources.classes.Airports.AirPortImpl;
import PatternMediator.resources.classes.Airships.Medivac;
import PatternMediator.resources.classes.Airships.Tardis;
import PatternMediator.resources.classes.Cargos.LivingCargo;
import PatternMediator.resources.classes.LoadMaster.LoadMaster;
import PatternMediator.resources.interfaces.Airport;
import PatternMediator.resources.interfaces.Airship;
import PatternMediator.resources.interfaces.Cargo;
import PatternMediator.resources.interfaces.CargoSector;

/**
 *
 * @author comrade
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoadMaster lm = new LoadMaster();
        Airport ap = new AirPortImpl("DALAVAN");
        Cargo cargo = new LivingCargo(lm, ap, 100);
        Airship airship = new Medivac(lm, ap);
        lm.addAirship(airship);
        cargo.cargoArrived();

        boolean result = false;
        for (CargoSector sector : airship.getSectors()) {
            if (sector.getLoadedCargos().contains(cargo)) {
                result = true;
                break;
            }
        }
        System.out.println(result);
    }

}
