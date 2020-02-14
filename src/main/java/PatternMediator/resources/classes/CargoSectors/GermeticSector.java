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
public class GermeticSector extends AbstractCargoSector implements CargoSector{
    
    public GermeticSector(Integer space){
        super(space, CargoSectorTypes.Germetic);
    }
}
