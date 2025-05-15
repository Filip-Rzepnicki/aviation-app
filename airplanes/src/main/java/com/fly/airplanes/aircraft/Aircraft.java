package com.fly.airplanes.aircraft;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="aircraft_statistic")
public class Aircraft {

    @Id
    @Column(name = "icao_code", unique  = true)
    private String icaoCode;

    private String Manufacturer;
    private String Model_FAA;
    private String Physical_Class_Engine;
    private Integer Num_Engines;
    private Integer Approach_Speed_knot;
    private Integer Length_ft;
    private Integer Tail_Height_at_OEW_ft;
    private Integer Wheelbase_ft;
    private Integer Cockpit_to_Main_Gear_ft;
    private Integer Main_Gear_Width_ft;
    private Integer MTOW_lb;
    private Integer MALW_lb;
    private Integer Parking_Area_ft2;
    private String Aircraft_Class;
    private String FAA_Weight;
    private Integer Registration_Count;
    private Integer TMFS_Operations_FY24;

    public Aircraft() {
    }

    public Aircraft(String icaoCode) {
        this.icaoCode = icaoCode;
    }

    public Aircraft(String icaoCode, String manufacturer, String model_FAA, String physical_Class_Engine, Integer num_Engines, Integer approach_Speed_knot, Integer length_ft, Integer tail_Height_at_OEW_ft, Integer wheelbase_ft, Integer cockpit_to_Main_Gear_ft, Integer main_Gear_Width_ft, Integer MTOW_lb, Integer MALW_lb, Integer parking_Area_ft2, String aClass, String FAA_Weight, Integer registration_Count, Integer TMFS_Operations_FY24) {
        this.icaoCode = icaoCode;
        Manufacturer = manufacturer;
        Model_FAA = model_FAA;
        Physical_Class_Engine = physical_Class_Engine;
        Num_Engines = num_Engines;
        Approach_Speed_knot = approach_Speed_knot;
        Length_ft = length_ft;
        Tail_Height_at_OEW_ft = tail_Height_at_OEW_ft;
        Wheelbase_ft = wheelbase_ft;
        Cockpit_to_Main_Gear_ft = cockpit_to_Main_Gear_ft;
        Main_Gear_Width_ft = main_Gear_Width_ft;
        this.MTOW_lb = MTOW_lb;
        this.MALW_lb = MALW_lb;
        Parking_Area_ft2 = parking_Area_ft2;
        Aircraft_Class = aClass;
        this.FAA_Weight = FAA_Weight;
        Registration_Count = registration_Count;
        this.TMFS_Operations_FY24 = TMFS_Operations_FY24;
    }


    public String getIcaoCode() {
        return icaoCode;
    }

    public void setIcaoCode(String icaoCode) {
        this.icaoCode = icaoCode;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

    public String getModel_FAA() {
        return Model_FAA;
    }

    public void setModel_FAA(String model_FAA) {
        Model_FAA = model_FAA;
    }

    public String getPhysical_Class_Engine() {
        return Physical_Class_Engine;
    }

    public void setPhysical_Class_Engine(String physical_Class_Engine) {
        Physical_Class_Engine = physical_Class_Engine;
    }

    public Integer getNum_Engines() {
        return Num_Engines;
    }

    public void setNum_Engines(Integer num_Engines) {
        Num_Engines = num_Engines;
    }

    public Integer getApproach_Speed_knot() {
        return Approach_Speed_knot;
    }

    public void setApproach_Speed_knot(Integer approach_Speed_knot) {
        Approach_Speed_knot = approach_Speed_knot;
    }

    public Integer getLength_ft() {
        return Length_ft;
    }

    public void setLength_ft(Integer length_ft) {
        Length_ft = length_ft;
    }

    public Integer getTail_Height_at_OEW_ft() {
        return Tail_Height_at_OEW_ft;
    }

    public void setTail_Height_at_OEW_ft(Integer tail_Height_at_OEW_ft) {
        Tail_Height_at_OEW_ft = tail_Height_at_OEW_ft;
    }

    public Integer getWheelbase_ft() {
        return Wheelbase_ft;
    }

    public void setWheelbase_ft(Integer wheelbase_ft) {
        Wheelbase_ft = wheelbase_ft;
    }

    public Integer getCockpit_to_Main_Gear_ft() {
        return Cockpit_to_Main_Gear_ft;
    }

    public void setCockpit_to_Main_Gear_ft(Integer cockpit_to_Main_Gear_ft) {
        Cockpit_to_Main_Gear_ft = cockpit_to_Main_Gear_ft;
    }

    public Integer getMain_Gear_Width_ft() {
        return Main_Gear_Width_ft;
    }

    public void setMain_Gear_Width_ft(Integer main_Gear_Width_ft) {
        Main_Gear_Width_ft = main_Gear_Width_ft;
    }

    public Integer getMTOW_lb() {
        return MTOW_lb;
    }

    public void setMTOW_lb(Integer MTOW_lb) {
        this.MTOW_lb = MTOW_lb;
    }

    public Integer getMALW_lb() {
        return MALW_lb;
    }

    public void setMALW_lb(Integer MALW_lb) {
        this.MALW_lb = MALW_lb;
    }

    public Integer getParking_Area_ft2() {
        return Parking_Area_ft2;
    }

    public void setParking_Area_ft2(Integer parking_Area_ft2) {
        Parking_Area_ft2 = parking_Area_ft2;
    }


    public String getAircraft_Class() {
        return Aircraft_Class;
    }

    public void setAircraft_Class(String aircraft_Class) {
        Aircraft_Class = aircraft_Class;
    }

    public String getFAA_Weight() {
        return FAA_Weight;
    }

    public void setFAA_Weight(String FAA_Weight) {
        this.FAA_Weight = FAA_Weight;
    }

    public Integer getRegistration_Count() {
        return Registration_Count;
    }

    public void setRegistration_Count(Integer registration_Count) {
        Registration_Count = registration_Count;
    }

    public Integer getTMFS_Operations_FY24() {
        return TMFS_Operations_FY24;
    }

    public void setTMFS_Operations_FY24(Integer TMFS_Operations_FY24) {
        this.TMFS_Operations_FY24 = TMFS_Operations_FY24;
    }
}
