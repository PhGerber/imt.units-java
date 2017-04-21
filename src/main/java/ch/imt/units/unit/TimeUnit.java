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
 * The Time Unit for the Time Quantity.
 * Created by gerber on 02.11.2015.
 */
public enum TimeUnit implements Unit<TimeUnit> {

    /**
     * Time in millisecond [ms].
     */
    ms(TimeUnitFactor.ms),

    /**
     * Time in second [s].
     */
    s(TimeUnitFactor.s),

    /**
     * Time in minute [m].
     */
    m(TimeUnitFactor.m),

    /**
     * Time in hour [h].
     */
    h(TimeUnitFactor.h);

    private final double toH;
    private final double toMs;
    private final double toS;
    private final double toM;

    TimeUnit(double factor) {
        this.toMs = TimeUnitFactor.ms / factor;
        this.toS = TimeUnitFactor.s / factor;
        this.toM = TimeUnitFactor.m / factor;
        this.toH = TimeUnitFactor.h / factor;
    }

    /**
     * Returns conversion factor to the unit.
     *
     * @param unit to convert to
     * @return conversion factor
     */
    @Override
    public double factorTo(TimeUnit unit) {
        switch (unit) {
            case ms:
                return toMs;
            case m:
                return toM;
            case h:
                return toH;
            case s: // fall through
            default:
                return toS;
        }
    }

    /**
     * The conversion factors to convert from base unit to unit x.
     */
    static final class TimeUnitFactor {
        static final double ms = 1000.0d;
        static final double s  = 1.0d;
        static final double m  = 1.0d / 60.0d;
        static final double h  = 1.0d / 60.0d / 60.0d;
    }
}
