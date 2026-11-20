package com.amazonaws.util;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class TimingInfoUnmodifiable extends TimingInfo {
    public TimingInfoUnmodifiable(Long l11, long j11, Long l12) {
        super(l11, j11, l12);
    }

    @Override // com.amazonaws.util.TimingInfo
    public TimingInfo c() {
        throw new UnsupportedOperationException();
    }
}
