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

import ch.imt.units.unit.TimeUnit;

import static org.junit.Assert.*;

/**
 * Tests the quantity Time.
 * Created by gerber on 02.11.2015.
 */
public class TimeTest {

    private HashMap<TimeUnit, Double> testValue;

    @Before
    public void setUp() throws Exception {

        double hour = 1.634254d;

        testValue = new HashMap<>(TimeUnit.values().length);

        testValue.put(TimeUnit.ms, hour * 60.0d * 60.0d * 1000.0d);
        testValue.put(TimeUnit.s,  hour * 60.0d * 60.0d);
        testValue.put(TimeUnit.m,  hour * 60.0d);
        testValue.put(TimeUnit.h,  hour);
    }

    @Test
    public void testTime_ms() throws Exception {
        TimeUnit testUnit = TimeUnit.ms;
        Time testObject = new Time(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testTime_s() throws Exception {
        TimeUnit testUnit = TimeUnit.s;
        Time testObject = new Time(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testTime_m() throws Exception {
        TimeUnit testUnit = TimeUnit.m;
        Time testObject = new Time(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    @Test
    public void testTime_h() throws Exception {
        TimeUnit testUnit = TimeUnit.h;
        Time testObject = new Time(testValue.get(testUnit), testUnit);
        validate(testObject, testUnit);
    }

    private void validate(Time testObject, TimeUnit testUnit) {
        assertEquals("Conversion to millisecond failed.", testValue.get(TimeUnit.ms), testObject.getValue(TimeUnit.ms), 0.000001d);
        assertEquals("Conversion to second failed.", testValue.get(TimeUnit.s), testObject.getValue(TimeUnit.s), 0.000001d);
        assertEquals("Conversion to minute failed.", testValue.get(TimeUnit.m), testObject.getValue(TimeUnit.m), 0.000001d);
        assertEquals("Conversion to hour failed.", testValue.get(TimeUnit.h), testObject.getValue(TimeUnit.h), 0.000001d);
        assertEquals("Incorrect unit in measured value.", testUnit, testObject.getUnit());
        assertFalse("The value should not be NaN.", testObject.isNaN());
    }
}