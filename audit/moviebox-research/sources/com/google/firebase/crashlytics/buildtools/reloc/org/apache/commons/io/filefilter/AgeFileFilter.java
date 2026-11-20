package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.filefilter;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.c;
import java.io.File;
import java.io.Serializable;
import java.util.Date;
import wj.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class AgeFileFilter extends a implements Serializable {
    private static final long serialVersionUID = -2132740084016138541L;
    private final boolean acceptOlder;
    private final long cutoff;

    public AgeFileFilter(long j11) {
        this(j11, true);
    }

    public AgeFileFilter(long j11, boolean z11) {
        this.acceptOlder = z11;
        this.cutoff = j11;
    }

    public AgeFileFilter(File file) {
        this(file, true);
    }

    public AgeFileFilter(File file, boolean z11) {
        this(file.lastModified(), z11);
    }

    public AgeFileFilter(Date date) {
        this(date, true);
    }

    public AgeFileFilter(Date date, boolean z11) {
        this(date.getTime(), z11);
    }

    @Override // wj.a, wj.b, java.io.FileFilter
    public boolean accept(File file) {
        boolean zB = c.b(file, this.cutoff);
        if (this.acceptOlder) {
            return !zB;
        }
        return zB;
    }

    @Override // wj.a
    public String toString() {
        return super.toString() + "(" + (this.acceptOlder ? "<=" : ">") + this.cutoff + ")";
    }
}
