package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.input;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.ByteOrderMark;
import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class BOMInputStream$1 implements Comparator<ByteOrderMark> {
    @Override // java.util.Comparator
    public int compare(ByteOrderMark byteOrderMark, ByteOrderMark byteOrderMark2) {
        int length = byteOrderMark.length();
        int length2 = byteOrderMark2.length();
        if (length > length2) {
            return -1;
        }
        return length2 > length ? 1 : 0;
    }
}
