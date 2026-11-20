package androidx.media3.extractor.flv;

import androidx.media3.common.ParserException;
import u4.r0;
import z3.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class TagPayloadReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r0 f11788a;

    /* JADX INFO: compiled from: source.java */
    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str, null, false, 1);
        }
    }

    public TagPayloadReader(r0 r0Var) {
        this.f11788a = r0Var;
    }

    public final boolean a(c0 c0Var, long j11) throws ParserException {
        return b(c0Var) && c(c0Var, j11);
    }

    public abstract boolean b(c0 c0Var) throws ParserException;

    public abstract boolean c(c0 c0Var, long j11) throws ParserException;
}
