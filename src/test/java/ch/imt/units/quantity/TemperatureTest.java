/*
 * Copyright (c) 2017, IMT Information Management Technology AG, CH-9470 Buchs, www.imt.ch.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice,
 *     this list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *  3. Neither the name of the copyright holder nor the names of its contributors
 *     may be used to endorse or promote products derived from this software
 *     without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package ch.imt.units.quantity;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import ch.imt.units.unit.TemperatureUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Tests the quantity Temperature.
 * Created by gerber on 29.10.2015.
 */
public class TemperatureTest {

    private HashMap<TemperatureUnit, Double> testValueM40;
    private HashMap<TemperatureUnit, Double> testValue0;
    private HashMap<TemperatureUnit, Double> testValue21;

    @Before
    public void setUp() throws Exception {
        testValueM40 = new HashMap<>(TemperatureUnit.values().length);
        testValueM40.put(TemperatureUnit.C, -40.0d);
        testValueM40.put(TemperatureUnit.K, 233.15d);
        testValueM40.put(TemperatureUnit.F, -40.0d);

        testValue0 = new HashMap<>(TemperatureUnit.values().length);
        testValue0.put(TemperatureUnit.C, 0.0d);
        testValue0.put(TemperatureUnit.K, 273.15d);
        testValue0.put(TemperatureUnit.F, 32.0d);

        testValue21 = new HashMap<>(TemperatureUnit.values().length);
        testValue21.put(TemperatureUnit.C, 21.10d);
        testValue21.put(TemperatureUnit.K, 294.25d);
        testValue21.put(TemperatureUnit.F, 69.98d);
    }

    @Test
    public void testTemperature_C() throws Exception {
        TemperatureUnit testUnit = TemperatureUnit.C;
        Temperature testObjectM40 = new Temperature(testValueM40.get(testUnit), testUnit);
        Temperature testObject0 = new Temperature(testValue0.get(testUnit), testUnit);
        Temperature testObject21 = new Temperature(testValue21.get(testUnit), testUnit);
        validate(testObjectM40, testObject0, testObject21, testUnit);
    }

    @Test
    public void testTemperature_K() throws Exception {
        TemperatureUnit testUnit = TemperatureUnit.K;
        Temperature testObjectM40 = new Temperature(testValueM40.get(testUnit), testUnit);
        Temperature testObject0 = new Temperature(testValue0.get(testUnit), testUnit);
        Temperature testObject21 = new Temperature(testValue21.get(testUnit), testUnit);
        validate(testObjectM40, testObject0, testObject21, testUnit);
    }

    @Test
    public void testTemperature_F() throws Exception {
        TemperatureUnit testUnit = TemperatureUnit.F;
        Temperature testObjectM40 = new Temperature(testValueM40.get(testUnit), testUnit);
        Temperature testObject0 = new Temperature(testValue0.get(testUnit), testUnit);
        Temperature testObject21 = new Temperature(testValue21.get(testUnit), testUnit);
        validate(testObjectM40, testObject0, testObject21, testUnit);
    }

    @Test
    public void testTemperature_update() throws Exception {
        Temperature testObjectM40 = new Temperature(0.0d, TemperatureUnit.C);
        testObjectM40.update(testValueM40.get(TemperatureUnit.C));

        Temperature testObject0 = new Temperature(75.4d, TemperatureUnit.K);
        testObject0.update(testValue0.get(TemperatureUnit.K));

        Temperature testObject21 = new Temperature(0.0d, TemperatureUnit.F);
        testObject21.update(testValue21.get(TemperatureUnit.F));

        validate(testObjectM40, testObject0, testObject21, null);
    }

    private void validate(Temperature testObjectM40, Temperature testObject0, Temperature testObject21, TemperatureUnit testUnit) {
        // factorTo C
        assertEquals("Conversion to degrees Celsius failed.", testValueM40.get(TemperatureUnit.C), testObjectM40.getValue(TemperatureUnit.C), 0.000001d);
        assertEquals("Conversion to degrees Celsius failed.", testValue0.get(TemperatureUnit.C), testObject0.getValue(TemperatureUnit.C), 0.000001d);
        assertEquals("Conversion to degrees Celsius failed.", testValue21.get(TemperatureUnit.C), testObject21.getValue(TemperatureUnit.C), 0.000001d);

        // factorTo K
        assertEquals("Conversion to degrees Kelvin failed.", testValueM40.get(TemperatureUnit.K), testObjectM40.getValue(TemperatureUnit.K), 0.000001d);
        assertEquals("Conversion to degrees Kelvin failed.", testValue0.get(TemperatureUnit.K), testObject0.getValue(TemperatureUnit.K), 0.000001d);
        assertEquals("Conversion to degrees Kelvin failed.", testValue21.get(TemperatureUnit.K), testObject21.getValue(TemperatureUnit.K), 0.000001d);

        // factorTo F
        assertEquals("Conversion to degrees Fahrenheit failed.", testValueM40.get(TemperatureUnit.F), testObjectM40.getValue(TemperatureUnit.F), 0.000001d);
        assertEquals("Conversion to degrees Fahrenheit failed.", testValue0.get(TemperatureUnit.F), testObject0.getValue(TemperatureUnit.F), 0.000001d);
        assertEquals("Conversion to degrees Fahrenheit failed.", testValue21.get(TemperatureUnit.F), testObject21.getValue(TemperatureUnit.F), 0.000001d);

        // Unit
        if (testUnit != null) {
            assertEquals("Incorrect unit in measured value.", testUnit, testObjectM40.getUnit());
            assertEquals("Incorrect unit in measured value.", testUnit, testObject0.getUnit());
            assertEquals("Incorrect unit in measured value.", testUnit, testObject21.getUnit());
        }

        assertFalse("The value should not be NaN.", testObjectM40.isNaN());
        assertFalse("The value should not be NaN.", testObject0.isNaN());
        assertFalse("The value should not be NaN.", testObject21.isNaN());
    }
}