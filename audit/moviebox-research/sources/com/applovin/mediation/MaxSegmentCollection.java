package com.applovin.mediation;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface MaxSegmentCollection {

    /* JADX INFO: compiled from: source.java */
    public interface Builder {
        Builder addSegment(MaxSegment maxSegment);

        MaxSegmentCollection build();
    }

    List<MaxSegment> getSegments();
}
