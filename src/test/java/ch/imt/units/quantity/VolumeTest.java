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

import ch.imt.units.unit.VolumeUnit;

import static org.junit.Assert.*;

/**
 * Tests the quantity Volume.
 * Created by gerber on 30.10.2015.
 */
public class VolumeTest {

    private HashMap<VolumeUnit, Double> testValue;

    @Before
    public void setUp() throws Exception {
        testValue = new HashMap<>(VolumeUnit.values().length);
        testValue.put(VolumeUnit.L,  8.32d);
        testValue.put(VolumeUnit.mL, 8.32d * 1000.0d);
        testValue.put(VolumeUnit.cf, 8.32d * 0.035314667d);
    }

    @Test
    public void testVolume_L() throws Exception {
        VolumeUnit testUnit = VolumeUnit.L;
        Volume testObject = new Volume(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testVolume_mL() throws Exception {
        VolumeUnit testUnit = VolumeUnit.mL;
        Volume testObject = new Volume(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testVolume_cf() throws Exception {
        VolumeUnit testUnit = VolumeUnit.cf;
        Volume testObject = new Volume(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    private void validate(Volume testObject, VolumeUnit testUnit) {
        assertEquals("Conversion to litre failed.", testValue.get(VolumeUnit.L), testObject.getValue(VolumeUnit.L), 0.000001d);
        assertEquals("Conversion to milli litre failed.", testValue.get(VolumeUnit.mL), testObject.getValue(VolumeUnit.mL), 0.000001d);
        assertEquals("Conversion to cubic feet failed.", testValue.get(VolumeUnit.cf), testObject.getValue(VolumeUnit.cf), 0.000001d);
        assertEquals("Incorrect unit in measured value.", testUnit, testObject.getUnit());
        assertFalse("The value should not be NaN.", testObject.isNaN());
    }


}