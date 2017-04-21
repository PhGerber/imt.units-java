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
 * The Relativity Unit for the Relativity Quantity.
 * Created by gerber on 02.11.2015.
 */
public enum RelativityUnit implements Unit<RelativityUnit> {

    /**
     * Relativity 0..1.
     */
    RELATIVE(RelativityUnitFactor.FACTOR_RELATIVE),

    /**
     * Relativity 0..100 [%].
     */
    PERCENTAGE(RelativityUnitFactor.FACTOR_PERCENTAGE),

    /**
     * Relativity 0..1000 [‰].
     */
    PERMILLAGE(RelativityUnitFactor.FACTOR_PERMILLAGE);

    private final double toRelative;
    private final double toPercentage;
    private final double toPermillage;

    RelativityUnit(double factor) {
        this.toRelative = RelativityUnitFactor.FACTOR_RELATIVE / factor;
        this.toPercentage = RelativityUnitFactor.FACTOR_PERCENTAGE / factor;
        this.toPermillage = RelativityUnitFactor.FACTOR_PERMILLAGE / factor;
    }

    /**
     * Returns conversion factor to the unit.
     *
     * @param unit to convert to
     * @return conversion factor
     */
    @Override
    public double factorTo(RelativityUnit unit) {
        switch (unit) {
            case PERCENTAGE:
                return toPercentage;
            case PERMILLAGE:
                return toPermillage;
            case RELATIVE: // fall through
            default:
                return toRelative;
        }
    }

    /**
     * The conversion factors to convert from base unit to unit x.
     */
    static final class RelativityUnitFactor {
        static final double FACTOR_RELATIVE   = 1.0d;
        static final double FACTOR_PERCENTAGE = 100.0d;
        static final double FACTOR_PERMILLAGE = 1000.0d;
    }
}
