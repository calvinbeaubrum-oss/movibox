package com.applovin.impl.mediation;

import com.applovin.mediation.MaxSegment;
import com.applovin.mediation.MaxSegmentCollection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MaxSegmentCollectionImpl implements MaxSegmentCollection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f20702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f20703b;

    /* JADX INFO: compiled from: source.java */
    public static class BuilderImpl implements MaxSegmentCollection.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f20704a = new ArrayList();

        @Override // com.applovin.mediation.MaxSegmentCollection.Builder
        public MaxSegmentCollection.Builder addSegment(MaxSegment maxSegment) {
            this.f20704a.add(maxSegment);
            return this;
        }

        @Override // com.applovin.mediation.MaxSegmentCollection.Builder
        public MaxSegmentCollection build() {
            return new MaxSegmentCollectionImpl(this);
        }
    }

    private MaxSegmentCollectionImpl(BuilderImpl builderImpl) {
        List<MaxSegment> list = builderImpl.f20704a;
        this.f20702a = list;
        this.f20703b = new HashMap();
        for (MaxSegment maxSegment : list) {
            this.f20703b.put("segment_" + maxSegment.getKey(), maxSegment.getValues());
        }
    }

    public Map<String, List<Integer>> getJsonData() {
        return this.f20703b;
    }

    @Override // com.applovin.mediation.MaxSegmentCollection
    public List<MaxSegment> getSegments() {
        return this.f20702a;
    }

    public String toString() {
        return "MaxSegmentColletionImpl{segments=" + this.f20702a + "}";
    }
}
