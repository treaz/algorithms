package com.horiaconstantin.java;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class BetterProgrammerTask2 {

    public static Set<Object> getUniqueElements(Set<Object> a, Set<Object> b) {
    	return (Set<Object>) nonOverLap(a,b);
    }
    
    
    static Collection union(Collection coll1, Collection coll2) {
        Set union = new HashSet(coll1);
        union.addAll(new HashSet(coll2));
        return union;
    }

    static Collection intersect(Collection coll1, Collection coll2) {
        Set intersection = new HashSet(coll1);
        intersection.retainAll(new HashSet(coll2));
        return intersection;
    }

    static Collection nonOverLap(Collection coll1, Collection coll2) {
       Collection result = union(coll1, coll2);
       result.removeAll(intersect(coll1, coll2));
       return result;
    }
}
