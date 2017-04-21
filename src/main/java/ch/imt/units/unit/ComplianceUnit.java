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

/**
 * The Compliance Unit for the Compliance Quantity.
 * Created by gerber on 02.11.2015.
 */
public enum ComplianceUnit implements Unit<ComplianceUnit> {

    /**
     * Compliance in liter per millibar [ml/mbar].
     */
    mlPermbar(ComplianceUnitFactor.mlPermbar),

    /**
     * Compliance in liter per millibar [l/mbar].
     */
    lPermbar(ComplianceUnitFactor.lPermbar),

    /**
     * Compliance in milliliter per centimeter H<sub>2</sub>O [ml/cmH<sub>2</sub>O].
     */
    mlPercmH2O(ComplianceUnitFactor.mlPercmH2O),

    /**
     * Compliance in liter per centimeter H<sub>2</sub>O [l/cmH<sub>2</sub>O].
     */
    lPercmH2O(ComplianceUnitFactor.lPercmH2O);

    private final double toMlPermbar;
    private final double toLPermbar;
    private final double toMlPercmH2O;
    private final double toLPercmH2O;

    ComplianceUnit(double factor) {
        this.toMlPermbar = ComplianceUnitFactor.mlPermbar / factor;
        this.toLPermbar = ComplianceUnitFactor.lPermbar / factor;
        this.toMlPercmH2O = ComplianceUnitFactor.mlPercmH2O / factor;
        this.toLPercmH2O = ComplianceUnitFactor.lPercmH2O / factor;
    }

    /**
     * Returns conversion factor to the unit.
     *
     * @param unit to convert to
     * @return conversion factor
     */
    @Override
    public double factorTo(ComplianceUnit unit) {
        switch (unit) {
            case lPermbar:
                return toLPermbar;
            case mlPercmH2O:
                return toMlPercmH2O;
            case lPercmH2O:
                return toLPercmH2O;
            case mlPermbar: // fall through
            default:
                return toMlPermbar;
        }
    }

    /**
     * The conversion factors to convert from base unit to unit x.
     */
    static final class ComplianceUnitFactor {
        static final double mlPermbar  = 1.0d ;
        static final double lPermbar   = 1.0d / 1000.0d;
        static final double mlPercmH2O = 1.0d / 0.980665d;
        static final double lPercmH2O  = 1.0d / 0.000980665d;
    }
}
