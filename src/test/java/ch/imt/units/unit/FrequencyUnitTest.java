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
 * Tests the FrequencyUnit.
 * Created by gerber on 21.04.2017.
 */

public class FrequencyUnitTest {
    @Test
    public void testComplianceUnit() throws Exception {
        FrequencyUnit.FrequencyUnitFactor textObject = new FrequencyUnit.FrequencyUnitFactor();
        assertNotNull(textObject);
        assertEquals("Factor Hz  has wrong value.", 1.0d, FrequencyUnit.FrequencyUnitFactor.Hz, 0.0000001d);
        assertEquals("Factor kHz has wrong value.", 1.0d / 1.0E3d, FrequencyUnit.FrequencyUnitFactor.kHz, 0.0000001d);
        assertEquals("Factor MHz has wrong value.", 1.0d / 1.0E6d, FrequencyUnit.FrequencyUnitFactor.MHz, 0.0000001d);
        assertEquals("Factor GHz has wrong value.", 1.0d / 1.0E9d, FrequencyUnit.FrequencyUnitFactor.GHz, 0.0000001d);
        assertEquals("Factor BPM has wrong value.", 60.0d, FrequencyUnit.FrequencyUnitFactor.BPM, 0.0000001d);
    }
}
