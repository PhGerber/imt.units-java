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

import org.junit.Test;

import static ch.imt.units.unit.RatioUnit.RATIO;
import static org.junit.Assert.assertEquals;

/**
 * Tests the quantity Ratio.
 * Created by gerber on 30.10.2015.
 */
public class RatioTest {

    @Test
    public void testRatioValue() throws Exception {
        double testValue1 = 17.0d / 21.0d;
        double testValue2 = -1.423E22;
        double testValue3 = 2.7E7;

        Ratio testObject = new Ratio(testValue1);
        assertEquals("Raw value is incorrect.", testValue1, testObject.getValue(), 0.0000001d);

        testObject.set(testValue2);
        assertEquals("Raw value is incorrect.", testValue2, testObject.getValue(), 0.0000001d);

        testObject.update(testValue3);
        assertEquals("Raw value is incorrect.", testValue3, testObject.getValue(), 0.0000001d);

        assertEquals(1, RATIO.factorTo(RATIO), 0.0000001d);
    }
}