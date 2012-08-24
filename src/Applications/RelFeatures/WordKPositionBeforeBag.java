/*
Copyright (C) 2012 Nguyen Viet Cuong, Ye Nan, Sumit Bhagwani

This file is part of HOSemiCRF.

HOSemiCRF is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

HOSemiCRF is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with HOSemiCRF. If not, see <http://www.gnu.org/licenses/>.
*/

package Applications.RelFeatures;

import java.util.*;
import HOSemiCRF.*;
import Applications.*;

/**
 * Words from 2nd to 4th position before a position within a segment
 * @author Nguyen Viet Cuong
 */
public class WordKPositionBeforeBag extends FeatureType {

    static final int K = 5;

    public ArrayList<String> generateObsAt(DataSequence seq, int segStart, int segEnd) {
        ArrayList<String> obs = new ArrayList<String>();
        for (int i = segStart; i <= segEnd; i++) {
            for (int j = i - 1; j > i - K && j >= -1; j--) {
				try {
					obs.add("WKBB." + ((WordDetails) seq.x(j)).getWord());
				} catch (ClassCastException e) {
					obs.add("WKBB." + (new WordDetails()).getWord());
				}
            }
        }
        return obs;
    }

    public int order() {
        return 0;
    }
}
