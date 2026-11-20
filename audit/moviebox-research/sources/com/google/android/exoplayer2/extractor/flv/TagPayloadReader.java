package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.c0;
import tg.e0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class TagPayloadReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0 f33210a;

    /* JADX INFO: compiled from: source.java */
    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str, null, false, 1);
        }
    }

    public TagPayloadReader(e0 e0Var) {
        this.f33210a = e0Var;
    }

    public final boolean a(c0 c0Var, long j11) throws ParserException {
        return b(c0Var) && c(c0Var, j11);
    }

    public abstract boolean b(c0 c0Var) throws ParserException;

    public abstract boolean c(c0 c0Var, long j11) throws ParserException;
}
