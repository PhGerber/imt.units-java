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

import ch.imt.units.unit.RelativityUnit;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Tests the quantity RelativeHumidity.
 * Created by mguntli on 24.05.2016.
 */
public class RelativeHumidityTest {

    private HashMap<RelativityUnit, Double> testValue;

    @Before
    public void setUp() throws Exception {
        testValue = new HashMap<>(RelativityUnit.values().length);
        testValue.put(RelativityUnit.RELATIVE,   0.568d);
        testValue.put(RelativityUnit.PERCENTAGE, 0.568d * 100.0d);
        testValue.put(RelativityUnit.PERMILLAGE, 0.568d * 1000.0d);
    }

    @Test
    public void testRelativeHumidity_RELATIVE() throws Exception {
        RelativityUnit testUnit = RelativityUnit.RELATIVE;
        RelativeHumidity testObject = new RelativeHumidity(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testRelativeHumidity_PERCENTAGE() throws Exception {
        RelativityUnit testUnit = RelativityUnit.PERCENTAGE;
        RelativeHumidity testObject = new RelativeHumidity(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testRelativeHumidity_PERMILLAGE() throws Exception {
        RelativityUnit testUnit = RelativityUnit.PERMILLAGE;
        RelativeHumidity testObject = new RelativeHumidity(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testRelativeHumidity_set() throws Exception {
        RelativityUnit testUnit = RelativityUnit.RELATIVE;
        RelativeHumidity testObject = new RelativeHumidity(10.0d, RelativityUnit.PERMILLAGE);

        testObject.set(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testRelativeHumidity_update() throws Exception {
        RelativityUnit testUnit = RelativityUnit.RELATIVE;
        RelativeHumidity testObject = new RelativeHumidity(10.0d, testUnit);

        testObject.update(testValue.get(testUnit));
        validate(testObject, testUnit);
    }

    private void validate(RelativeHumidity testObject, RelativityUnit testUnit) {
        assertEquals("Conversion to RELATIVE failed.", testValue.get(RelativityUnit.RELATIVE), testObject.getValue(RelativityUnit.RELATIVE), 0.000001d);
        assertEquals("Conversion to PERCENTAGE failed.", testValue.get(RelativityUnit.PERCENTAGE), testObject.getValue(RelativityUnit.PERCENTAGE), 0.000001d);
        assertEquals("Conversion to PERMILLAGE failed.", testValue.get(RelativityUnit.PERMILLAGE), testObject.getValue(RelativityUnit.PERMILLAGE), 0.000001d);
        assertEquals("Incorrect unit in measured value.", testUnit, testObject.getUnit());
        assertFalse("The value should not be NaN.", testObject.isNaN());
    }
}
