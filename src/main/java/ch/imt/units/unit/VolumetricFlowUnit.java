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
 * The  VolumetricFlow Unit for the  VolumetricFlow Quantity.
 * Created by gerber on 02.11.2015.
 */
public enum VolumetricFlowUnit implements Unit<VolumetricFlowUnit> {

    /**
     * Volumetric flow in liter per minute [l/min].
     */
    lPerMin(VolumetricFlowUnitFactor.lPerMin),

    /**
     * Volumetric flow in liter per second [l/s].
     */
    lPerS(VolumetricFlowUnitFactor.lPerS),

    /**
     * Volumetric flow in milliliter per minute [ml/min].
     */
    mlPerMin(VolumetricFlowUnitFactor.mlPerMin),

    /**
     * Volumetric flow in milliliter per second [ml/s].
     */
    mlPerS(VolumetricFlowUnitFactor.mlPerS),

    /**
     * Volumetric flow in cubic foot per minute [ft<sup>3</sup>/min].
     */
    cfm(VolumetricFlowUnitFactor.cfm);

    private final double tolPerMin;
    private final double toLPerS;
    private final double toMlPerMin;
    private final double toMlPerS;
    private final double toCfm;

    VolumetricFlowUnit(double factor) {
        tolPerMin = VolumetricFlowUnitFactor.lPerMin / factor;
        toLPerS = VolumetricFlowUnitFactor.lPerS / factor;
        toMlPerMin = VolumetricFlowUnitFactor.mlPerMin / factor;
        toMlPerS = VolumetricFlowUnitFactor.mlPerS / factor;
        toCfm = VolumetricFlowUnitFactor.cfm / factor;
    }

    /**
     * Returns conversion factor to the unit.
     *
     * @param unit to convert to
     * @return conversion factor
     */
    public double factorTo(VolumetricFlowUnit unit) {
        switch (unit) {

            case lPerS:
                return toLPerS;
            case mlPerMin:
                return toMlPerMin;
            case mlPerS:
                return toMlPerS;
            case cfm:
                return toCfm;
            case lPerMin: // fall through
            default:
                return tolPerMin;
        }
    }

    /**
     * The conversion factors to convert from base unit to unit x.
     */
    static final class VolumetricFlowUnitFactor {
        static final double lPerMin  = 1.0d;
        static final double lPerS    = 1.0d / 60.0d;
        static final double mlPerMin = 1000.0d;
        static final double mlPerS   = 1000.0d / 60;
        static final double cfm      = 0.035314667d;
    }
}
