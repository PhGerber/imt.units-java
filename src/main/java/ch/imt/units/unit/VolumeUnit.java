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
 * The  Volume Unit for the  Volume Quantity.
 * Created by gerber on 02.11.2015.
 */
public enum VolumeUnit implements Unit<VolumeUnit> {

    /**
     * Volume in liter [l].
     */
    L(VolumeUnitFactor.L),

    /**
     * Volume in milliliter [ml].
     */
    mL(VolumeUnitFactor.ML),

    /**
     * Volume in cubic foot [ft<sup>3</sup>].
     */
    cf(VolumeUnitFactor.CF);

    private final double toL;
    private final double toMl;
    private final double toCf;

    VolumeUnit(double factor) {
        this.toL = VolumeUnitFactor.L / factor;
        this.toMl = VolumeUnitFactor.ML / factor;
        this.toCf = VolumeUnitFactor.CF / factor;
    }

    /**
     * Returns conversion factor to the unit.
     *
     * @param unit to convert to
     * @return conversion factor
     */
    @Override
    public double factorTo(VolumeUnit unit) {
        switch (unit) {
            case mL:
                return toMl;
            case cf:
                return toCf;
            case L: // fall through
            default:
                return toL;
        }
    }

    /**
     * The conversion factors to convert from base unit to unit x.
     */
    static final class VolumeUnitFactor {
        static final double L  = 1.0d;
        static final double ML = 1.0d * 1000.0d;
        static final double CF = 0.035314667d;
    }
}
