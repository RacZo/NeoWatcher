package com.oscarsalguero.neowatcher.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Potentially Hazardous Asteroid
 * <p>
 * For more details, visit: http://minorplanetcenter.net/data/
 * </p>
 * Created by RacZo on 4/23/16.
 */
public class PotentiallyHazardousAsteroid implements Serializable {

    @SerializedName("Last_obs")
    private String dateOfLastObservation; // (YYYY-MM-DD

    @SerializedName("Orbital_period")
    private float orbitalPeriod; // Years

    @SerializedName("Number")
    private String number;

    @SerializedName("Num_obs")
    private int numberOfObservations;

    @SerializedName("Principal_desig")
    private String principalDesignation;

    @SerializedName("U")
    private String uncertaintyParameter;

    @SerializedName("Perihelion_dist")
    private double perihelionDistance; // AU

    @SerializedName("Synodic_period")
    private float synodicPeriod; // Years

    @SerializedName("G")
    private float slopeParameter;

    @SerializedName("Ref")
    private String reference;

    @SerializedName("e")
    private float orbitalEccentricity; // e

    @SerializedName("a")
    private float semimajorAxis; // a, AU

    @SerializedName("Name")
    private String name;

    @SerializedName("Semilatus_rectum")
    private float semilatusRectum; // AU

    @SerializedName("M")
    private float meanAnomaly;

    @SerializedName("H")
    private float absoluteMagnitude;

    @SerializedName("Arc_years")
    private String arcYears;

    @SerializedName("Node")
    private float ascendingNodeLongitude; // ☊, J2000.0 (degrees)

    @SerializedName("Peri")
    private float perihelion; // ω, J2000.0 (degrees)

    @SerializedName("n")
    private float meanDailyMotion; // degrees/day

    @SerializedName("Aphelion_dist")
    private float aphelionDistance; // AU

    private float rms; // r.m.s. residual (")

    @SerializedName("PHA_flag")
    private int phaFlag; // 1 if flag raised, otherwise keyword is absent

    @SerializedName("Perturbers_2")
    private String perturbers2; // Precise indicator of perturbers used in orbit computation

    @SerializedName("i")
    private float inclinationToTheEcliptic; // (degrees)

    @SerializedName("Epoch")
    private String epochOfOrbit; // Julian Date

    @SerializedName("Num_opps")
    private int numberOfOppositions;

    @SerializedName("Computer")
    private String computer; // Name of orbit computer (be it a person or machine)

    @SerializedName("One_km_NEO_flag")
    private int oneKmNeoFlag;

    @SerializedName("Tp")
    private float tp;

    @SerializedName("Hex_flags")
    private String hexFlags;

    @SerializedName("Perturbers")
    private String perturbers;

    @SerializedName("NEO_flag")
    private int neoFlag;

    @SerializedName("orbit_type")
    private String orbitFlag;

    public String getDateOfLastObservation() {
        return dateOfLastObservation;
    }

    public void setDateOfLastObservation(String dateOfLastObservation) {
        this.dateOfLastObservation = dateOfLastObservation;
    }

    public float getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(float orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getNumberOfObservations() {
        return numberOfObservations;
    }

    public void setNumberOfObservations(int numberOfObservations) {
        this.numberOfObservations = numberOfObservations;
    }

    public String getPrincipalDesignation() {
        return principalDesignation;
    }

    public void setPrincipalDesignation(String principalDesignation) {
        this.principalDesignation = principalDesignation;
    }

    public String getUncertaintyParameter() {
        return uncertaintyParameter;
    }

    public void setUncertaintyParameter(String uncertaintyParameter) {
        this.uncertaintyParameter = uncertaintyParameter;
    }

    public double getPerihelionDistance() {
        return perihelionDistance;
    }

    public void setPerihelionDistance(double perihelionDistance) {
        this.perihelionDistance = perihelionDistance;
    }

    public float getSynodicPeriod() {
        return synodicPeriod;
    }

    public void setSynodicPeriod(float synodicPeriod) {
        this.synodicPeriod = synodicPeriod;
    }

    public float getSlopeParameter() {
        return slopeParameter;
    }

    public void setSlopeParameter(float slopeParameter) {
        this.slopeParameter = slopeParameter;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public float getOrbitalEccentricity() {
        return orbitalEccentricity;
    }

    public void setOrbitalEccentricity(float orbitalEccentricity) {
        this.orbitalEccentricity = orbitalEccentricity;
    }

    public float getSemimajorAxis() {
        return semimajorAxis;
    }

    public void setSemimajorAxis(float semimajorAxis) {
        this.semimajorAxis = semimajorAxis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSemilatusRectum() {
        return semilatusRectum;
    }

    public void setSemilatusRectum(float semilatusRectum) {
        this.semilatusRectum = semilatusRectum;
    }

    public float getMeanAnomaly() {
        return meanAnomaly;
    }

    public void setMeanAnomaly(float meanAnomaly) {
        this.meanAnomaly = meanAnomaly;
    }

    public float getAbsoluteMagnitude() {
        return absoluteMagnitude;
    }

    public void setAbsoluteMagnitude(float absoluteMagnitude) {
        this.absoluteMagnitude = absoluteMagnitude;
    }

    public String getArcYears() {
        return arcYears;
    }

    public void setArcYears(String arcYears) {
        this.arcYears = arcYears;
    }

    public float getAscendingNodeLongitude() {
        return ascendingNodeLongitude;
    }

    public void setAscendingNodeLongitude(float ascendingNodeLongitude) {
        this.ascendingNodeLongitude = ascendingNodeLongitude;
    }

    public float getPerihelion() {
        return perihelion;
    }

    public void setPerihelion(float perihelion) {
        this.perihelion = perihelion;
    }

    public float getMeanDailyMotion() {
        return meanDailyMotion;
    }

    public void setMeanDailyMotion(float meanDailyMotion) {
        this.meanDailyMotion = meanDailyMotion;
    }

    public float getAphelionDistance() {
        return aphelionDistance;
    }

    public void setAphelionDistance(float aphelionDistance) {
        this.aphelionDistance = aphelionDistance;
    }

    public float getRms() {
        return rms;
    }

    public void setRms(float rms) {
        this.rms = rms;
    }

    public int getPhaFlag() {
        return phaFlag;
    }

    public void setPhaFlag(int phaFlag) {
        this.phaFlag = phaFlag;
    }

    public String getPerturbers2() {
        return perturbers2;
    }

    public void setPerturbers2(String perturbers2) {
        this.perturbers2 = perturbers2;
    }

    public float getInclinationToTheEcliptic() {
        return inclinationToTheEcliptic;
    }

    public void setInclinationToTheEcliptic(float inclinationToTheEcliptic) {
        this.inclinationToTheEcliptic = inclinationToTheEcliptic;
    }

    public String getEpochOfOrbit() {
        return epochOfOrbit;
    }

    public void setEpochOfOrbit(String epochOfOrbit) {
        this.epochOfOrbit = epochOfOrbit;
    }

    public int getNumberOfOppositions() {
        return numberOfOppositions;
    }

    public void setNumberOfOppositions(int numberOfOppositions) {
        this.numberOfOppositions = numberOfOppositions;
    }

    public String getComputer() {
        return computer;
    }

    public void setComputer(String computer) {
        this.computer = computer;
    }

    public int getOneKmNeoFlag() {
        return oneKmNeoFlag;
    }

    public void setOneKmNeoFlag(int oneKmNeoFlag) {
        this.oneKmNeoFlag = oneKmNeoFlag;
    }

    public float getTp() {
        return tp;
    }

    public void setTp(float tp) {
        this.tp = tp;
    }

    public String getHexFlags() {
        return hexFlags;
    }

    public void setHexFlags(String hexFlags) {
        this.hexFlags = hexFlags;
    }

    public String getPerturbers() {
        return perturbers;
    }

    public void setPerturbers(String perturbers) {
        this.perturbers = perturbers;
    }

    public int getNeoFlag() {
        return neoFlag;
    }

    public void setNeoFlag(int neoFlag) {
        this.neoFlag = neoFlag;
    }

    public String getOrbitFlag() {
        return orbitFlag;
    }

    public void setOrbitFlag(String orbitFlag) {
        this.orbitFlag = orbitFlag;
    }

}
