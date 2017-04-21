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
 * The Temperature Unit for the Temperature Quantity.
 * Created by gerber on 02.11.2015.
 */
public enum TemperatureUnit implements Unit<TemperatureUnit> {

    /**
     * Temperature in degree Celsius [°C].
     */
    C(TemperatureUnitParameter.FACTOR_C, TemperatureUnitParameter.OFFSET_C),

    /**
     * Temperature in kelvin [K].
     */
    K(TemperatureUnitParameter.FACTOR_K, TemperatureUnitParameter.OFFSET_K),

    /**
     * Temperature in degree Fahrenheit [°F].
     */
    F(TemperatureUnitParameter.FACTOR_F, TemperatureUnitParameter.OFFSET_F);

    private final double factorC;
    private final double factorK;
    private final double factorF;
    private final double offsetC;
    private final double offsetK;
    private final double offsetF;

    TemperatureUnit(double factor, double offset) {
        this.factorC = TemperatureUnitParameter.FACTOR_C / factor;
        this.factorK = TemperatureUnitParameter.FACTOR_K / factor;
        this.factorF = TemperatureUnitParameter.FACTOR_F / factor;

        this.offsetC = 0;

        if (TemperatureUnitParameter.OFFSET_K == offset) {
            this.offsetK = 0;
        } else {
            this.offsetK = TemperatureUnitParameter.OFFSET_K;
        }
        if (TemperatureUnitParameter.OFFSET_F == offset) {
            this.offsetF = 0;
        } else {
            this.offsetF = TemperatureUnitParameter.OFFSET_F;
        }
    }

    /**
     * Returns conversion factor to the unit.
     *
     * @param unit to convert to
     * @return conversion factor
     */
    public double factorTo(TemperatureUnit unit) {
        switch (unit) {
            case K:
                return factorK;
            case F:
                return factorF;
            case C: // fall through
            default:
                return factorC;
        }
    }

    /**
     * Returns conversion offset to the unit.
     *
     * @param unit to convert to
     * @return conversion offset
     */
    public double offsetTo(TemperatureUnit unit) {
        switch (unit) {
            case K:
                return offsetK;
            case F:
                return offsetF;
            case C: // fall through
            default:
                return offsetC;
        }
    }

    /**
     * The conversion factors to convert from base unit to unit x.
     */
    static final class TemperatureUnitParameter {
        // factors
        static final double FACTOR_C = 1.0d;
        static final double FACTOR_K = 1.0d;
        static final double FACTOR_F = 1.8d;
        // offsets
        static final double OFFSET_C = 0.0d;
        static final double OFFSET_K = 273.15d;
        static final double OFFSET_F = 32.0d;
    }
}
