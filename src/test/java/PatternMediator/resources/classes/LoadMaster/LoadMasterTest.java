/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternMediator.resources.classes.LoadMaster;

import PatternMediator.resources.classes.Airports.AirPortImpl;
import PatternMediator.resources.classes.Cargos.DangerCargo;
import PatternMediator.resources.classes.Cargos.DefaultCargo;
import PatternMediator.resources.classes.Cargos.LivingCargo;
import PatternMediator.resources.classes.Cargos.PerishableCargo;
import PatternMediator.resources.interfaces.Airport;
import PatternMediator.resources.interfaces.Airship;
import PatternMediator.resources.interfaces.Cargo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author comrade
 */
public class LoadMasterTest {

    private LoadMaster loadMaster;

    private static List<Airport> airports = new ArrayList<>();

    public LoadMasterTest() {

    }

    @BeforeAll
    public static void setUpClass() {
        Airport[] airportsl = {
            new AirPortImpl("Dalavan"),
            new AirPortImpl("Jamaica"),
            new AirPortImpl("L.A"),
            new AirPortImpl("Norilsk")
        };
        LoadMasterTest.airports.addAll(Arrays.asList(airportsl));

    }

    @AfterAll
    public static void tearDownClass() {
    }

    /**
     *
     */
    @BeforeEach
    public void setUp() {

        Cargo[] cargos = {
            new DangerCargo(LoadMasterTest.airports.get(0), 4),
            new LivingCargo(LoadMasterTest.airports.get(1), 6),
            new DefaultCargo(LoadMasterTest.airports.get(2), 3),
            new PerishableCargo(LoadMasterTest.airports.get(3), 12)
        };
        this.loadMaster = new LoadMaster();
        this.loadMaster.addCargoGroup(Arrays.asList(cargos));
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addAirship method, of class LoadMaster.
     */
    @Test
    public void testAddAirship() {

    }

    /**
     * Test of addAirshipGroup method, of class LoadMaster.
     */
    @Test
    public void testAddAirshipGroup() {

    }

    /**
     * Test of addCargo method, of class LoadMaster.
     */
    @Test
    public void testAddCargo() {

    }

    /**
     * Test of addCargoGroup method, of class LoadMaster.
     */
    @Test
    public void testAddCargoGroup() {

    }

    /**
     * Test of airshipArrived method, of class LoadMaster.
     */
    @Test
    public void testAirshipArrived() {

    }

    /**
     * Test of cargoArrived method, of class LoadMaster.
     */
    @Test
    public void testCargoArrived() {

    }

    /**
     * Test of findAirshipforCargo method, of class LoadMaster.
     */
    @Test
    public void testFindAirshipforCargo() {

    }

    /**
     * Test of findCargoforAirship method, of class LoadMaster.
     */
    @Test
    public void testFindCargoforAirship() {

    }

    /**
     * Test of loadQueues method, of class LoadMaster.
     */
    @Test
    public void testLoadQueues() {

    }

    /**
     * Test of sortCargoQueues method, of class LoadMaster.
     */
    @Test
    public void testSortCargoQueues() {
        Integer[] expected = {4, 3, 2, 1};
        this.loadMaster.sortCargoQueue();
        List<Integer> result = new ArrayList<>();

        for (Cargo cargo : this.loadMaster.getCargosQueue()) {
            result.add(cargo.getCargoType().getPriority());
        }
        assertArrayEquals(expected, result.toArray());
    }

}
