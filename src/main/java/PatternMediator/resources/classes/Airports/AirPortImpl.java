/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternMediator.resources.classes.Airports;

import PatternMediator.resources.interfaces.Airport;

/**
 *
 * @author comrade
 */
public class AirPortImpl implements Airport {

    private final String name;

    public AirPortImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
