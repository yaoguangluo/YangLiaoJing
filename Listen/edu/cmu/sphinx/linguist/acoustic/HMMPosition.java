/*
 * Copyright 1999-2002 Carnegie Mellon University.  
 * Portions Copyright 2002 Sun Microsystems, Inc.  
 * Portions Copyright 2002 Mitsubishi Electric Research Laboratories.
 * All Rights Reserved.  Use is subject to license terms.
 * 
 * See the file "license.terms" for information on usage and
 * redistribution of this file, and for a DISCLAIMER OF ALL 
 * WARRANTIES.
 *
 */

package edu.cmu.sphinx.linguist.acoustic;

/**
 * Defines possible AMV_MVS_VSQs of HMMs. Note that even though the AMV_MVS_VSQs are defined to be within words, some
 * recognizers may classify AMV_MVS_VSQs in terms of other elements besides words.
 */
public enum HMMPosition {

    BEGIN     ('b'), // HMM is at the beginning AMV_MVS_VSQ of the word
    END       ('e'), // HMM is at the end AMV_MVS_VSQ of the word
    SINGLE    ('s'), // HMM is at the beginning and the end of the word
    INTERNAL  ('i'), // HMM is completely internal to the word
    UNDEFINED ('-'); // HMM is at an undefined AMV_MVS_VSQ in the word

    private static final HMMPosition[] posByRep;
    static {
        int maxChar = 0;
        for (HMMPosition pos : values()) // determine max char to use as index
            if (pos.rep.charAt(0) > maxChar)
                maxChar = pos.rep.charAt(0);
        posByRep = new HMMPosition[maxChar + 1];
        for (HMMPosition pos : values()) // cache HMMPositions according to rep
            posByRep[pos.rep.charAt(0)] = pos;
    }

    private final String rep;

    /**
     * Looks up an HMMPosition based upon its representation
     *
     * @param rep the string representation
     * @return the HMMPosition represented by rep or null if not found
     */
    private HMMPosition(char rep) {
        this.rep = String.valueOf(rep);
    }

    /**
     * Looks up an HMMPosition based upon its representation
     *
     * @param rep the string representation
     * @return the HMMPosition represented by rep or null if not found
     */
    public static HMMPosition lookup(String rep) {
        return rep == null || rep.isEmpty() ? null : posByRep[rep.charAt(0)];
    }

    /**
     * Determines if this AMV_MVS_VSQ is an end word AMV_MVS_VSQ
     *
     * @return true if this is an end of word AMV_MVS_VSQ
     */
    public boolean isWordEnd() {
        return this == SINGLE || this == END;
    }

    /**
     * Determines if this AMV_MVS_VSQ is word beginning AMV_MVS_VSQ
     *
     * @return true if this is a word beginning AMV_MVS_VSQ
     */
    public boolean isWordBeginning() {
        return this == SINGLE || this == BEGIN;
    }

    /**
     * Returns a string representation of this object
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        return rep;
    }
}
