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

import ch.imt.units.unit.FrequencyUnit;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Tests the quantity Frequency.
 * Created by mguntli on 24.05.2016.
 */
public class FrequencyTest {

    private HashMap<FrequencyUnit, Double> testValue;

    @Before
    public void setUp() throws Exception {

        testValue = new HashMap<>(FrequencyUnit.values().length);

        testValue.put(FrequencyUnit.Hz,     792000000d);
        testValue.put(FrequencyUnit.kHz,    792000d);
        testValue.put(FrequencyUnit.MHz,    792d);
        testValue.put(FrequencyUnit.GHz,    0.792d);
        testValue.put(FrequencyUnit.BPM,    60*792000000d);
    }

    @Test
    public void testFrequency_Hz() throws Exception {
        FrequencyUnit testUnit = FrequencyUnit.Hz;
        Frequency testObject = new Frequency(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testFrequency_kHz() throws Exception {
        FrequencyUnit testUnit = FrequencyUnit.kHz;
        Frequency testObject = new Frequency(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testFrequency_MHz() throws Exception {
        FrequencyUnit testUnit = FrequencyUnit.MHz;
        Frequency testObject = new Frequency(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testFrequency_GHz() throws Exception {
        FrequencyUnit testUnit = FrequencyUnit.GHz;
        Frequency testObject = new Frequency(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testFrequency_BPM() throws Exception {
        FrequencyUnit testUnit = FrequencyUnit.BPM;
        Frequency testObject = new Frequency(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    private void validate(Frequency testObject, FrequencyUnit testUnit) {
        assertEquals("Conversion to Hz failed.", testValue.get(FrequencyUnit.Hz), testObject.getValue(FrequencyUnit.Hz), 0.000001d);
        assertEquals("Conversion to kHz failed.", testValue.get(FrequencyUnit.kHz), testObject.getValue(FrequencyUnit.kHz), 0.000001d);
        assertEquals("Conversion to MHz failed.", testValue.get(FrequencyUnit.MHz), testObject.getValue(FrequencyUnit.MHz), 0.000001d);
        assertEquals("Conversion to GHz failed.", testValue.get(FrequencyUnit.GHz), testObject.getValue(FrequencyUnit.GHz), 0.000001d);
        assertEquals("Conversion to BPM failed.", testValue.get(FrequencyUnit.BPM), testObject.getValue(FrequencyUnit.BPM), 0.000001d);
        assertEquals("Incorrect unit in measured value.", testUnit, testObject.getUnit());
        assertFalse("The value should not be NaN.", testObject.isNaN());
    }
}
