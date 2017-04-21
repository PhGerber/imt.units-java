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

import ch.imt.units.unit.ComplianceUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Tests the quantity Compliance.
 * Created by gerber on 02.11.2015.
 */
public class ComplianceTest {

    private HashMap<ComplianceUnit, Double> testValue;

    @Before
    public void setUp() throws Exception {

        double mlPermbar = 23.23478d;

        testValue = new HashMap<>(ComplianceUnit.values().length);

        testValue.put(ComplianceUnit.mlPermbar,  mlPermbar);
        testValue.put(ComplianceUnit.lPermbar,   mlPermbar / 1000.0d );
        testValue.put(ComplianceUnit.mlPercmH2O, mlPermbar / 0.980665d);
        testValue.put(ComplianceUnit.lPercmH2O,  mlPermbar / 0.000980665d);
    }

    @Test
    public void testCompliance_mlPermbar() throws Exception {
        ComplianceUnit testUnit = ComplianceUnit.mlPermbar;
        Compliance testObject = new Compliance(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testCompliance_lPermbar() throws Exception {
        ComplianceUnit testUnit = ComplianceUnit.lPermbar;
        Compliance testObject = new Compliance(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testCompliance_mlPercmH2O() throws Exception {
        ComplianceUnit testUnit = ComplianceUnit.mlPercmH2O;
        Compliance testObject = new Compliance(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testCompliance_lPercmH2O() throws Exception {
        ComplianceUnit testUnit = ComplianceUnit.lPercmH2O;
        Compliance testObject = new Compliance(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    private void validate(Compliance testObject, ComplianceUnit testUnit) {
        assertEquals("Conversion to ml/mbar failed.", testValue.get(ComplianceUnit.mlPermbar), testObject.getValue(ComplianceUnit.mlPermbar), 0.000001d);
        assertEquals("Conversion to l/mbar failed.", testValue.get(ComplianceUnit.lPermbar), testObject.getValue(ComplianceUnit.lPermbar), 0.000001d);
        assertEquals("Conversion to ml/cmH2O failed.", testValue.get(ComplianceUnit.mlPercmH2O), testObject.getValue(ComplianceUnit.mlPercmH2O), 0.000001d);
        assertEquals("Conversion to l/cmH2O failed.", testValue.get(ComplianceUnit.lPercmH2O), testObject.getValue(ComplianceUnit.lPercmH2O), 0.000001d);
        assertEquals("Incorrect unit in measured value.", testUnit, testObject.getUnit());
        assertFalse("The value should not be NaN.", testObject.isNaN());
    }
}