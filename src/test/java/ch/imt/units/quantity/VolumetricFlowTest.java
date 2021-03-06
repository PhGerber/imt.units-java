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

import ch.imt.units.unit.VolumetricFlowUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Tests the quantity VolumetricFlow.
 * Created by gerber on 30.10.2015.
 */
public class VolumetricFlowTest {

    private HashMap<VolumetricFlowUnit, Double> testValue;

    @Before
    public void setUp() throws Exception {
        testValue = new HashMap<>(VolumetricFlowUnit.values().length);
        testValue.put(VolumetricFlowUnit.lPerMin, 8.4d);
        testValue.put(VolumetricFlowUnit.lPerS, 8.4d / 60.0d);
        testValue.put(VolumetricFlowUnit.mlPerMin, 8.4d * 1000.0d);
        testValue.put(VolumetricFlowUnit.mlPerS, 8.4d * 1000.0d / 60.0d);
        testValue.put(VolumetricFlowUnit.cfm, 8.4d * 0.035314667d);
    }

    @Test
    public void testVolumetricFlow_lPerMin() throws Exception {
        VolumetricFlowUnit testUnit = VolumetricFlowUnit.lPerMin;
        VolumetricFlow testObject = new VolumetricFlow(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testVolumetricFlow_lPerS() throws Exception {
        VolumetricFlowUnit testUnit = VolumetricFlowUnit.lPerS;
        VolumetricFlow testObject = new VolumetricFlow(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testVolumetricFlow_mlPerMin() throws Exception {
        VolumetricFlowUnit testUnit = VolumetricFlowUnit.mlPerMin;
        VolumetricFlow testObject = new VolumetricFlow(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testVolumetricFlow_mlPerS() throws Exception {
        VolumetricFlowUnit testUnit = VolumetricFlowUnit.mlPerS;
        VolumetricFlow testObject = new VolumetricFlow(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testVolumetricFlow_cfm() throws Exception {
        VolumetricFlowUnit testUnit = VolumetricFlowUnit.cfm;
        VolumetricFlow testObject = new VolumetricFlow(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testVolumetricFlow_set() throws Exception {
        VolumetricFlowUnit testUnit = VolumetricFlowUnit.lPerMin;
        VolumetricFlow testObject = new VolumetricFlow(0.0d, VolumetricFlowUnit.cfm);

        testObject.set(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testVolumetricFlow_update() throws Exception {
        VolumetricFlowUnit testUnit = VolumetricFlowUnit.lPerMin;
        VolumetricFlow testObject = new VolumetricFlow(0.0d, testUnit);

        testObject.update(testValue.get(testUnit));
        validate(testObject, testUnit);
    }

    private void validate(VolumetricFlow testObject, VolumetricFlowUnit testUnit) {
        assertEquals("Conversion to lPerMin failed.", testValue.get(VolumetricFlowUnit.lPerMin), testObject.getValue(VolumetricFlowUnit.lPerMin), 0.000001d);
        assertEquals("Conversion to lPerS failed.", testValue.get(VolumetricFlowUnit.lPerS), testObject.getValue(VolumetricFlowUnit.lPerS), 0.000001d);
        assertEquals("Conversion to mlPerMin failed.", testValue.get(VolumetricFlowUnit.mlPerMin), testObject.getValue(VolumetricFlowUnit.mlPerMin), 0.000001d);
        assertEquals("Conversion to mlPerS failed.", testValue.get(VolumetricFlowUnit.mlPerS), testObject.getValue(VolumetricFlowUnit.mlPerS), 0.000001d);
        assertEquals("Conversion to cfm failed.", testValue.get(VolumetricFlowUnit.cfm), testObject.getValue(VolumetricFlowUnit.cfm), 0.000001d);
        assertEquals("Incorrect unit in measured value.", testUnit, testObject.getUnit());
        assertFalse("The value should not be NaN.", testObject.isNaN());
    }
}
