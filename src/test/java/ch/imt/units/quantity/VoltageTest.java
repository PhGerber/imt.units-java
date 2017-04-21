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

import ch.imt.units.unit.VoltageUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Tests the quantity Voltage.
 * Created by gerber on 29.10.2015.
 */
public class VoltageTest {

    private HashMap<VoltageUnit, Double> testValue;

    @Before
    public void setUp() throws Exception {

        double voltage = 22.04d;

        testValue = new HashMap<>(VoltageUnit.values().length);

        testValue.put(VoltageUnit.V, voltage * 1.0E0d);
        testValue.put(VoltageUnit.mV, voltage * 1.0E3d);
    }

    @Test
    public void testVoltage_new() throws Exception {
        Voltage testObject = new Voltage(testValue.get(VoltageUnit.V), VoltageUnit.V);
        validate(testObject);

        testObject = new Voltage(testValue.get(VoltageUnit.mV), VoltageUnit.mV);
        validate(testObject);
    }

    @Test
    public void testVoltage_set() throws Exception {
        Voltage testObject = new Voltage(testValue.get(VoltageUnit.V), VoltageUnit.V);
        validate(testObject);

        testObject.set(testValue.get(VoltageUnit.mV), VoltageUnit.mV);
        validate(testObject);
    }

    @Test
    public void testVoltage_update() throws Exception {
        Voltage testObject = new Voltage(0.0d, VoltageUnit.V);
        testObject.update(testValue.get(VoltageUnit.V));
        validate(testObject);

        testObject.set(-1.0d, VoltageUnit.mV);
        testObject.update(testValue.get(VoltageUnit.mV));
        validate(testObject);
    }

    private void validate(Voltage testObject) {
        assertEquals("", testValue.get(VoltageUnit.V), testObject.getValue(VoltageUnit.V), 0.000001d);
        assertEquals("", testValue.get(VoltageUnit.mV), testObject.getValue(VoltageUnit.mV), 0.000001d);
        assertFalse("The value should not be NaN.", testObject.isNaN());
    }

}