/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternMediator.resources.classes.LoadMaster;

import PatternMediator.resources.classes.Airports.AirPortImpl;
import PatternMediator.resources.classes.Airships.ConwingL16;
import PatternMediator.resources.classes.Airships.Enterprise;
import PatternMediator.resources.classes.Airships.Medivac;
import PatternMediator.resources.classes.Airships.MillenniumFalcon;
import PatternMediator.resources.classes.Airships.Tardis;
import PatternMediator.resources.classes.Airships.TeslaAS;
import PatternMediator.resources.classes.CargoSectors.GermeticSector;
import PatternMediator.resources.classes.Cargos.DangerCargo;
import PatternMediator.resources.classes.Cargos.DefaultCargo;
import PatternMediator.resources.classes.Cargos.LivingCargo;
import PatternMediator.resources.classes.Cargos.PerishableCargo;
import PatternMediator.resources.interfaces.Airport;
import PatternMediator.resources.interfaces.Airship;
import PatternMediator.resources.interfaces.Cargo;
import PatternMediator.resources.interfaces.CargoSector;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.stream.Stream;
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
    
    private static final List<Airport> airports = new ArrayList<>();
    
    private List<Airship> airships = null;
    
    private List<Cargo> cargos = null;
    
    public LoadMasterTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        LoadMasterTest.airports.addAll(Arrays.asList(new Airport[]{
            new AirPortImpl("Tatuin"),
            new AirPortImpl("L.A"),
            new AirPortImpl("Moscow"),
            new AirPortImpl("Texas")
        }));
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        this.loadMaster = new LoadMaster();
        
        this.airships = Arrays.asList(new Airship[]{
            new Enterprise(this.loadMaster, LoadMasterTest.airports.get(0)),
            new Medivac(this.loadMaster, LoadMasterTest.airports.get(0)),
            new ConwingL16(this.loadMaster, LoadMasterTest.airports.get(0)),
            new TeslaAS(this.loadMaster, LoadMasterTest.airports.get(0)),
            new MillenniumFalcon(this.loadMaster, LoadMasterTest.airports.get(0)),
            new Tardis(this.loadMaster, LoadMasterTest.airports.get(0))
        });
        
        this.cargos = Arrays.asList(new Cargo[]{
            new DefaultCargo(this.loadMaster, LoadMasterTest.airports.get(0), 5),
            new LivingCargo(this.loadMaster, LoadMasterTest.airports.get(0), 5),
            new PerishableCargo(this.loadMaster, LoadMasterTest.airports.get(0), 5),
            new DangerCargo(this.loadMaster, LoadMasterTest.airports.get(0), 5)
        });
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Airships provider
     *
     * @return
     */
    public Stream<Airship> airshipProvider() {
        return Stream.of(
                new Enterprise(this.loadMaster, LoadMasterTest.airports.get(0)),
                new Medivac(this.loadMaster, LoadMasterTest.airports.get(0)),
                new ConwingL16(this.loadMaster, LoadMasterTest.airports.get(0)),
                new TeslaAS(this.loadMaster, LoadMasterTest.airports.get(0)),
                new TeslaAS(this.loadMaster, LoadMasterTest.airports.get(0)),
                new MillenniumFalcon(this.loadMaster, LoadMasterTest.airports.get(0)),
                new Tardis(this.loadMaster, LoadMasterTest.airports.get(0))
        );
    }

    /**
     * Cargos provider
     *
     * @return
     */
    public Stream<Cargo> cargoProvider() {
        return Stream.of(
                new DefaultCargo(this.loadMaster, LoadMasterTest.airports.get(0), 50),
                new LivingCargo(this.loadMaster, LoadMasterTest.airports.get(0), 50),
                new DangerCargo(this.loadMaster, LoadMasterTest.airports.get(0), 50),
                new PerishableCargo(this.loadMaster, LoadMasterTest.airports.get(0), 50)
        );
    }

    /**
     * Test of addAirship method, of class LoadMaster.
     */
    @Test
    public void testAddAirship() {
        Airship airship = new Enterprise(this.loadMaster, LoadMasterTest.airports.get(0));
        this.loadMaster.addAirship(airship);
        boolean result = this.loadMaster.getAirshipQueue().contains(airship);
        
        assertTrue(result);
    }

    /**
     * Test of addAirshipGroup method, of class LoadMaster.
     */
    @Test
    public void testAddAirshipGroup() {
        this.loadMaster.addAirshipGroup(this.airships);
        
        assertArrayEquals(this.airships.toArray(), this.loadMaster.getAirshipQueue().toArray());
    }

    /**
     * Test of addCargo method, of class LoadMaster.
     */
    @Test
    public void testAddCargo() {
        Cargo cargo = new DangerCargo(this.loadMaster, LoadMasterTest.airports.get(0), 50);
        this.loadMaster.addCargo(cargo);
        boolean result = this.loadMaster.getCargosQueue().contains(cargo);
        
        assertTrue(result);
    }

    /**
     * Test of addCargoGroup method, of class LoadMaster.
     */
    @Test
    public void testAddCargoGroup() {
        this.loadMaster.addCargoGroup(this.cargos);
        assertArrayEquals(this.cargos.toArray(), this.loadMaster.getCargosQueue().toArray());
        
    }

    /**
     * Test of airshipArrived method, of class LoadMaster.
     */
    @Test
    public void testAirshipArrived() {
        Airship airship = new MillenniumFalcon(this.loadMaster, LoadMasterTest.airports.get(0));
        this.loadMaster.addCargoGroup(this.cargos);
        airship.airshipArrived();
        
        List<CargoSector> sectors = airship.getSectors();
        
        //Living cargo in germetic sector
        boolean result1 = sectors.get(0).getLoadedCargos().contains(this.cargos.get(1));
        assertTrue(result1);
        //Perishable cargo in Temperature control sector
        boolean result2 = sectors.get(1).getLoadedCargos().contains(this.cargos.get(2));
        assertTrue(result2);
        //Default cargo in default sector
        boolean result3 = sectors.get(2).getLoadedCargos().contains(this.cargos.get(0));
        assertTrue(result3);
        //Danger cargo in Temperature control sector
        boolean result4 = sectors.get(1).getLoadedCargos().contains(this.cargos.get(3));
        assertTrue(result4);
    }

    /**
     * Test of cargoArrived method, of class LoadMaster.
     */
    @Test
    public void testCargoArrived() {
        Cargo cargo = new PerishableCargo(this.loadMaster, LoadMasterTest.airports.get(0), 2000);
        this.loadMaster.addAirshipGroup(this.airships);
        cargo.cargoArrived();
        
        boolean result = false;
        for (CargoSector sector : this.airships.get(5).getSectors()) {
            if (sector.getLoadedCargos().contains(cargo)) {
                result = true;
                break;
            }
        }
        
        assertTrue(result);
    }

    /**
     * Test of getCargosQueue method, of class LoadMaster.
     */
    @Test
    public void testGetCargosQueue() {
        this.loadMaster.getCargosQueue().addAll(this.cargos);
        
        assertArrayEquals(this.cargos.toArray(), this.loadMaster.getCargosQueue().toArray());
    }

    /**
     * Test of getAirshipQueue method, of class LoadMaster.
     */
    @Test
    public void testGetAirshipQueue() {
        this.loadMaster.getAirshipQueue().addAll(this.airships);
        
        assertArrayEquals(this.airships.toArray(), this.loadMaster.getAirshipQueue().toArray());
    }

    /**
     * Test of loadCargoToAirship method, of class LoadMaster.
     */
    @Test
    public void testLoadCargoToAirship() {
        Airship airship = new ConwingL16(this.loadMaster, LoadMasterTest.airports.get(0));
        
        Cargo cargo1 = new DangerCargo(this.loadMaster, LoadMasterTest.airports.get(0), 5);
        Cargo cargo2 = new DefaultCargo(this.loadMaster, LoadMasterTest.airports.get(0), 5);
        Cargo cargo3 = new PerishableCargo(this.loadMaster, LoadMasterTest.airports.get(0), 5);
        Cargo cargo4 = new DefaultCargo(this.loadMaster, LoadMasterTest.airports.get(0), 20);
        
        assertTrue(this.loadMaster.loadCargoToAirship(cargo1, airship));
        assertTrue(this.loadMaster.loadCargoToAirship(cargo2, airship));
        assertFalse(this.loadMaster.loadCargoToAirship(cargo3, airship));
        assertFalse(this.loadMaster.loadCargoToAirship(cargo4, airship));
    }

    /**
     * Test of replaceCargosByPriority method, of class LoadMaster.
     */
    @Test
    public void testReplaceCargosByPriority() {
        CargoSector sector = new GermeticSector(50);
        Cargo cargo1 = new DangerCargo(this.loadMaster, LoadMasterTest.airports.get(0), 20);
        Cargo cargo2 = new DefaultCargo(this.loadMaster, LoadMasterTest.airports.get(0), 20);
        Cargo cargo3 = new LivingCargo(this.loadMaster, LoadMasterTest.airports.get(0), 20);
        sector.loadCargo(cargo1);
        sector.loadCargo(cargo2);
        
        List<Cargo> result = this.loadMaster.replaceCargosByPriority(cargo3, sector);
        Cargo[] expected = {cargo2};
        
        assertArrayEquals(expected, result.toArray());
    }

    /**
     * Test of sortCargo method, of class LoadMaster.
     */
    @Test
    public void testSortCargo() {
        Cargo[] expected = {
            this.cargos.get(1),
            this.cargos.get(2),
            this.cargos.get(3),
            this.cargos.get(0)
        };
        
        this.loadMaster.sortCargo(this.cargos);
        
        assertArrayEquals(expected, this.cargos.toArray());
    }

    /**
     * Test of findAirshipsforCargo method, of class LoadMaster.
     */
    @Test
    public void testFindAirshipsforCargo() {
        this.loadMaster.addAirshipGroup(this.airships);
        Cargo cargo = new LivingCargo(this.loadMaster, LoadMasterTest.airports.get(0), 12);
        List<Airship> result = this.loadMaster.findAirshipsforCargo(cargo);
        
        Airship[] expected = {
            this.airships.get(0),
            this.airships.get(1),
            this.airships.get(3),
            this.airships.get(4),
            this.airships.get(5)
        };
        
        assertArrayEquals(expected, result.toArray());
    }

    /**
     * Test of findCargosforAirship method, of class LoadMaster.
     */
    @Test
    public void testFindCargosforAirship() {
        this.loadMaster.addCargoGroup(this.cargos);
        Airship airship = new Medivac(this.loadMaster, LoadMasterTest.airports.get(0));
        List<Cargo> result = this.loadMaster.findCargosforAirship(airship);
        
        Cargo[] expected = {
            this.cargos.get(0),
            this.cargos.get(1),
            this.cargos.get(3)
        };
        
        assertArrayEquals(expected, result.toArray());
    }
    
}
