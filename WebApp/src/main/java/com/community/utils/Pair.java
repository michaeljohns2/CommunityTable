package com.community.utils;

/**
 * Created by mjohns on 11/23/16.
 * Adapted from http://stackoverflow.com/questions/2670982/using-pairs-or-2-tuples-in-java
 */
public class Pair<X, Y> {

    public final X _1;
    public final Y _2;

    public Pair(X _1, Y y) {
        this._1 = _1;
        this._2 = y;
    }

    @Override
    public String toString() {
        return String.format("('%s', '%s')", _1, _2);
    }

    @Override
    public boolean equals(Object other) {

        if (other == null)
            return false;

        if (other == this)
            return true;

        if (!(other instanceof Pair))
            return false;

        Pair<X,Y> other_ = (Pair<X,Y>) other;

        // avoid NPE by testing null mismatches here
        if ((this._1 == null && other_._1 != null) || (this._1 != null && other_._1 == null)) return false;
        if ((this._2 == null && other_._2 != null) || (this._2 != null && other_._2 == null)) return false;

        // if null present then don't test equals
        return (this._1 == null || other_._1.equals(this._1)) && (this._2 == null || other_._2.equals(this._2));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_1 == null) ? 0 : _1.hashCode());
        result = prime * result + ((_2 == null) ? 0 : _2.hashCode());
        return result;
    }
}
