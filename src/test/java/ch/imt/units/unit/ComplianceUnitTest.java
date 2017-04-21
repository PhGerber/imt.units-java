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
 * Tests the ComplianceUnit.
 * Created by gerber on 21.04.2017.
 */

public class ComplianceUnitTest {
    @Test
    public void testComplianceUnit() throws Exception {
        ComplianceUnit.ComplianceUnitFactor textObject = new ComplianceUnit.ComplianceUnitFactor();
        assertNotNull(textObject);
        assertEquals("Factor mlPermbar  has wrong value.", 1.0d, ComplianceUnit.ComplianceUnitFactor.mlPermbar, 0.0000001d);
        assertEquals("Factor lPermbar   has wrong value.", 1.0d / 1000.0d, ComplianceUnit.ComplianceUnitFactor.lPermbar, 0.0000001d);
        assertEquals("Factor mlPercmH2O has wrong value.", 1.0d / 0.980665d, ComplianceUnit.ComplianceUnitFactor.mlPercmH2O, 0.0000001d);
        assertEquals("Factor lPercmH2O  has wrong value.", 1.0d / 0.000980665d, ComplianceUnit.ComplianceUnitFactor.lPercmH2O, 0.0000001d);
    }
}
