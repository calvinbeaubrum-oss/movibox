package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import wj.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class SizeFileFilter extends a implements Serializable {
    private static final long serialVersionUID = 7388077430788600069L;
    private final boolean acceptLarger;
    private final long size;

    public SizeFileFilter(long j11) {
        this(j11, true);
    }

    public SizeFileFilter(long j11, boolean z11) {
        if (j11 < 0) {
            throw new IllegalArgumentException("The size must be non-negative");
        }
        this.size = j11;
        this.acceptLarger = z11;
    }

    @Override // wj.a, wj.b, java.io.FileFilter
    public boolean accept(File file) {
        boolean z11 = file.length() < this.size;
        if (this.acceptLarger) {
            return !z11;
        }
        return z11;
    }

    @Override // wj.a
    public String toString() {
        return super.toString() + "(" + (this.acceptLarger ? ">=" : "<") + this.size + ")";
    }
}
