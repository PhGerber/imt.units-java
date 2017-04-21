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

import ch.imt.units.unit.PressureUnit;

import static org.junit.Assert.*;

/**
 * Tests the quantity Pressure.
 * Created by gerber on 29.10.2015.
 */
public class PressureTest {

    private HashMap<PressureUnit, Double> testValue;

    @Before
    public void setUp() throws Exception {
        testValue = new HashMap<>(PressureUnit.values().length);
        testValue.put(PressureUnit.bar, 1.013250000d);
        testValue.put(PressureUnit.mbar, 1013.250000d);
        testValue.put(PressureUnit.inH2O, 407.181177038d);
        testValue.put(PressureUnit.cmH2O, 1033.227452800d);
        testValue.put(PressureUnit.psi, 14.695857748d);
        testValue.put(PressureUnit.Torr, 760.002100179d);
        testValue.put(PressureUnit.inHg, 29.921342527d);
        testValue.put(PressureUnit.mmHg, 760.002100179d);
        testValue.put(PressureUnit.kPa, 101.3250d);
        testValue.put(PressureUnit.hPa, 1013.250d);
        testValue.put(PressureUnit.Pa, 101325.0d);
    }

    @Test
    public void testPressure_bar() throws Exception {
        PressureUnit testUnit = PressureUnit.bar;
        Pressure testObject = new Pressure(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testPressure_mbar() throws Exception {
        PressureUnit testUnit = PressureUnit.mbar;
        Pressure testObject = new Pressure(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testPressure_inH2O() throws Exception {
        PressureUnit testUnit = PressureUnit.inH2O;
        Pressure testObject = new Pressure(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testPressure_cmH2O() throws Exception {
        PressureUnit testUnit = PressureUnit.cmH2O;
        Pressure testObject = new Pressure(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testPressure_psi() throws Exception {
        PressureUnit testUnit = PressureUnit.psi;
        Pressure testObject = new Pressure(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testPressure_Torr() throws Exception {
        PressureUnit testUnit = PressureUnit.Torr;
        Pressure testObject = new Pressure(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testPressure_inHg() throws Exception {
        PressureUnit testUnit = PressureUnit.inHg;
        Pressure testObject = new Pressure(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testPressure_mmHg() throws Exception {
        PressureUnit testUnit = PressureUnit.mmHg;
        Pressure testObject = new Pressure(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testPressure_kPascal() throws Exception {
        PressureUnit testUnit = PressureUnit.kPa;
        Pressure testObject = new Pressure(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testPressure_hPascal() throws Exception {
        PressureUnit testUnit = PressureUnit.hPa;
        Pressure testObject = new Pressure(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testPressure_Pascal() throws Exception {
        PressureUnit testUnit = PressureUnit.Pa;
        Pressure testObject = new Pressure(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testPressure_update() throws Exception {
        PressureUnit testUnit = PressureUnit.Pa;
        Pressure testObject = new Pressure(0.1d, testUnit);
        testObject.update(testValue.get(testUnit));
        validate(testObject, testUnit);

        testUnit = PressureUnit.bar;
        testObject.set(0.1d, testUnit);
        testObject.update(testValue.get(testUnit));
        validate(testObject, testUnit);
    }

    private void validate(Pressure testObject, PressureUnit testUnit) {
        // factorTo Bar
        assertEquals("Conversion to bar failed.", testValue.get(PressureUnit.bar), testObject.getValue(PressureUnit.bar), 0.000000001d);
        assertEquals("Conversion to mbar failed.", testValue.get(PressureUnit.mbar), testObject.getValue(PressureUnit.mbar), 0.000001d);

        // factorTo inH2O
        assertEquals("Conversion to inH2O failed.", testValue.get(PressureUnit.inH2O), testObject.getValue(PressureUnit.inH2O), 0.0000001d);

        // factorTo cmH2O
        assertEquals("Conversion to cmH2O failed.", testValue.get(PressureUnit.cmH2O), testObject.getValue(PressureUnit.cmH2O), 0.000001d);

        // factorTo psi
        assertEquals("Conversion to psi failed.", testValue.get(PressureUnit.psi), testObject.getValue(PressureUnit.psi), 0.00000001d);

        // factorTo Torr
        assertEquals("Conversion to Torr failed.", testValue.get(PressureUnit.Torr), testObject.getValue(PressureUnit.Torr), 0.0000001d);

        // factorTo inHg
        assertEquals("Conversion to inHg failed.", testValue.get(PressureUnit.inHg), testObject.getValue(PressureUnit.inHg), 0.00000001d);

        // factorTo mmHg
        assertEquals("Conversion to mmHg failed.", testValue.get(PressureUnit.mmHg), testObject.getValue(PressureUnit.mmHg), 0.0000001d);

        // factorTo Pascal
        assertEquals("Conversion to kPa failed.", testValue.get(PressureUnit.kPa), testObject.getValue(PressureUnit.kPa), 0.00001d);
        assertEquals("Conversion to hPa failed.", testValue.get(PressureUnit.hPa), testObject.getValue(PressureUnit.hPa), 0.00001d);
        assertEquals("Conversion to Pa failed.", testValue.get(PressureUnit.Pa), testObject.getValue(PressureUnit.Pa), 0.00001d);

        // Unit
        assertEquals("Incorrect unit in measured value.", testUnit, testObject.getUnit());

        // isNaN
        assertFalse("The value should not be NaN.", testObject.isNaN());
    }
}