package com.prosperity.pas.common;

/**
 * The three GLWB options offered on PathWay Max, by filed form code (decision M2).
 *
 * <ul>
 *   <li>{@code GLN} — Option 1: 15-yr, 4.00% compound roll-up, no rider charge</li>
 *   <li>{@code GLS} — Option 2: 10-yr, 10.00% simple roll-up, 1.20% charge</li>
 *   <li>{@code GLC} — Option 3: 20-yr, 6.50% compound roll-up, 1.20% charge</li>
 * </ul>
 *
 * GLP is not offered on Max. Inbound TX103 codes OPT1/OPT2/OPT3 map to
 * GLN/GLS/GLC at the ingest boundary.
 */
public enum GlwbOption {
    GLN,
    GLS,
    GLC
}
