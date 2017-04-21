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
 * The Frequency Unit for the Frequency Quantity.
 * Created by mguntli on 24.05.2016.
 */

public enum FrequencyUnit implements Unit<FrequencyUnit> {
    /**
     * Frequency in hertz [Hz].
     */
    Hz(FrequencyUnitFactor.Hz),

    /**
     * Frequency in kilohertz [kHz].
     */
    kHz(FrequencyUnitFactor.kHz),

    /**
     * Frequency in megahertz [MHz].
     */
    MHz(FrequencyUnitFactor.MHz),

    /**
     * Frequency in gigahertz [GHz].
     */
    GHz(FrequencyUnitFactor.GHz),

    /**
     * Frequency in beats per minute [b/min].
     */
    BPM(FrequencyUnitFactor.BPM);

    private final double toHz;
    private final double toKHz;
    private final double toMHz;
    private final double toGHz;
    private final double toBpm;

    FrequencyUnit(double factor) {
        this.toHz = FrequencyUnitFactor.Hz / factor;
        this.toKHz = FrequencyUnitFactor.kHz / factor;
        this.toMHz = FrequencyUnitFactor.MHz / factor;
        this.toGHz = FrequencyUnitFactor.GHz / factor;
        this.toBpm = FrequencyUnitFactor.BPM / factor;
    }

    /**
     * Returns conversion factor to the unit.
     * @param unit to convert to
     * @return conversion factor
     */
    @Override
    public double factorTo(FrequencyUnit unit) {
        switch (unit) {

            case kHz:
                return toKHz;
            case MHz:
                return toMHz;
            case GHz:
                return toGHz;
            case BPM:
                return toBpm;
            case Hz: // fall through
            default:
                return toHz;
        }
    }

    /**
     * The conversion factors to convert from base unit to unit x.
     */
    static final class FrequencyUnitFactor {
        static final double Hz  = 1.0d;
        static final double kHz = 1.0d / 1.0E3d;
        static final double MHz = 1.0d / 1.0E6d;
        static final double GHz = 1.0d / 1.0E9d;
        static final double BPM = 60.0d;
    }
}
