package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class mf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f21150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f21151b;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f21152a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f21153b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f21154c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f21155d;

        public a(String str, String str2, long j11, long j12) {
            this.f21152a = str;
            this.f21153b = str2;
            this.f21154c = j11;
            this.f21155d = j12;
        }
    }

    public mf(long j11, List list) {
        this.f21150a = j11;
        this.f21151b = list;
    }

    public nf a(long j11) {
        long j12;
        if (this.f21151b.size() < 2) {
            return null;
        }
        long j13 = j11;
        long j14 = -1;
        long j15 = -1;
        long j16 = -1;
        long j17 = -1;
        boolean z11 = false;
        for (int size = this.f21151b.size() - 1; size >= 0; size--) {
            a aVar = (a) this.f21151b.get(size);
            boolean zEquals = MimeTypes.VIDEO_MP4.equals(aVar.f21152a) | z11;
            if (size == 0) {
                j13 -= aVar.f21155d;
                j12 = 0;
            } else {
                j12 = j13 - aVar.f21154c;
            }
            long j18 = j13;
            j13 = j12;
            if (!zEquals || j13 == j18) {
                z11 = zEquals;
            } else {
                j17 = j18 - j13;
                j16 = j13;
                z11 = false;
            }
            if (size == 0) {
                j14 = j13;
                j15 = j18;
            }
        }
        if (j16 == -1 || j17 == -1 || j14 == -1 || j15 == -1) {
            return null;
        }
        return new nf(j14, j15, this.f21150a, j16, j17);
    }
}
