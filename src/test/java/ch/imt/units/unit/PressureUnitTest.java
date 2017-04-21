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

package ch.imt.units.unit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests the PressureUnit.
 * Created by gerber on 21.04.2017.
 */

public class PressureUnitTest {
    @Test
    public void testComplianceUnit() throws Exception {
        PressureUnit.PressureUnitFactor textObject = new PressureUnit.PressureUnitFactor();
        assertNotNull(textObject);
        assertEquals("Factor bar   has wrong value.", 1.0d / 1000.0d, PressureUnit.PressureUnitFactor.bar, 0.0000001d);
        assertEquals("Factor mbar  has wrong value.", 1.0d, PressureUnit.PressureUnitFactor.mbar, 0.0000001d);
        assertEquals("Factor inH2O has wrong value.", 1.0d / 2.48845d, PressureUnit.PressureUnitFactor.inH2O, 0.0000001d);
        assertEquals("Factor cmH2O has wrong value.", 1.0d / 0.980665d, PressureUnit.PressureUnitFactor.cmH2O, 0.0000001d);
        assertEquals("Factor psi   has wrong value.", 1.0d / 68.948d, PressureUnit.PressureUnitFactor.psi, 0.0000001d);
        assertEquals("Factor Torr  has wrong value.", 1.0d / 1.33322d, PressureUnit.PressureUnitFactor.Torr, 0.0000001d);
        assertEquals("Factor inHg  has wrong value.", 1.0d / 1.33322d / 25.4d, PressureUnit.PressureUnitFactor.inHg, 0.0000001d);
        assertEquals("Factor mmHg  has wrong value.", 1.0d / 1.33322d, PressureUnit.PressureUnitFactor.mmHg, 0.0000001d);
        assertEquals("Factor kPa   has wrong value.", 1.0d / 10.0d, PressureUnit.PressureUnitFactor.kPa, 0.0000001d);
        assertEquals("Factor hPa   has wrong value.", 1.0d, PressureUnit.PressureUnitFactor.hPa, 0.0000001d);
        assertEquals("Factor Pa    has wrong value.", 100d, PressureUnit.PressureUnitFactor.Pa, 0.0000001d);
    }
}
