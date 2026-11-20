package com.google.firebase.crashlytics.buildtools.ndk.internal.csym;

import java.util.Comparator;
import tj.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
class ElfCSymFactory$DebugLineGroup$1 implements Comparator<a> {
    @Override // java.util.Comparator
    public int compare(a aVar, a aVar2) {
        long j11 = aVar.f77226a;
        long j12 = aVar2.f77226a;
        if (j11 < j12) {
            return -1;
        }
        return j11 == j12 ? 0 : 1;
    }
}
