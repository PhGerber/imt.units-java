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
 * The Pressure Unit for the Pressure Quantity.
 * Created by gerber on 02.11.2015.
 */

public enum PressureUnit implements Unit<PressureUnit> {
    /**
     * Pressure in bar [bar].
     */
    bar(PressureUnitFactor.bar),

    /**
     * Pressure in millibar [mbar].
     */
    mbar(PressureUnitFactor.mbar),

    /**
     * Pressure in inch H<sub>2</sub>O [inH<sub>2</sub>O].
     */
    inH2O(PressureUnitFactor.inH2O),

    /**
     * Pressure in centimeter H<sub>2</sub>O [cmH<sub>2</sub>O].
     */
    cmH2O(PressureUnitFactor.cmH2O),

    /**
     * Pressure in pound-force per square inch [psi].
     */
    psi(PressureUnitFactor.psi),

    /**
     * Pressure in Torr [Torr].
     */
    Torr(PressureUnitFactor.Torr),

    /**
     * Pressure in inch of mercury [inHg].
     */
    inHg(PressureUnitFactor.inHg),

    /**
     * Pressure in millimeter of mercury [mmHg].
     */
    mmHg(PressureUnitFactor.mmHg),

    /**
     * Pressure in kilopascal [kPa].
     */
    kPa(PressureUnitFactor.kPa),

    /**
     * Pressure in hectopascal [hPa].
     */
    hPa(PressureUnitFactor.hPa),

    /**
     * Pressure in pascal [Pa].
     */
    Pa(PressureUnitFactor.Pa);

    private final double toBar;
    private final double toMBar;
    private final double toInH2O;
    private final double toCmH2O;
    private final double toPsi;
    private final double toTorr;
    private final double toInHg;
    private final double toMmHg;
    private final double toKPa;
    private final double toHPa;
    private final double toPa;

    PressureUnit(double factor) {
        toBar = PressureUnitFactor.bar / factor;
        toMBar = PressureUnitFactor.mbar / factor;
        toInH2O = PressureUnitFactor.inH2O / factor;
        toCmH2O = PressureUnitFactor.cmH2O / factor;
        toPsi = PressureUnitFactor.psi / factor;
        toTorr = PressureUnitFactor.Torr / factor;
        toInHg = PressureUnitFactor.inHg / factor;
        toMmHg = PressureUnitFactor.mmHg / factor;
        toKPa = PressureUnitFactor.kPa / factor;
        toHPa = PressureUnitFactor.hPa / factor;
        toPa = PressureUnitFactor.Pa / factor;
    }

    /**
     * Returns conversion factor to the unit.
     *
     * @param unit to convert to
     * @return conversion factor
     */
    @Override
    public double factorTo(PressureUnit unit) {
        switch (unit) {
            case bar:
                return toBar;
            case inH2O:
                return toInH2O;
            case cmH2O:
                return toCmH2O;
            case psi:
                return toPsi;
            case Torr:
                return toTorr;
            case inHg:
                return toInHg;
            case mmHg:
                return toMmHg;
            case kPa:
                return toKPa;
            case hPa:
                return toHPa;
            case Pa:
                return toPa;
            case mbar: // fall through
            default:
                return toMBar;
        }
    }

    /**
     * The conversion factors to convert from base unit to unit x.
     */
    static final class PressureUnitFactor {
        static final double bar   = 1.0d / 1000.0d;
        static final double mbar  = 1.0d;
        static final double inH2O = 1.0d / 2.48845d;
        static final double cmH2O = 1.0d / 0.980665d;
        static final double psi   = 1.0d / 68.948d;
        static final double Torr  = 1.0d / 1.33322d;
        static final double inHg  = 1.0d / 1.33322d / 25.4d;
        static final double mmHg  = 1.0d / 1.33322d;
        static final double kPa   = 1.0d / 10.0d ;
        static final double hPa   = 1.0d ;
        static final double Pa    = 100d ;
    }
}
