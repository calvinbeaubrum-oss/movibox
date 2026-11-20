package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public interface LoaderErrorThrower {

    /* JADX INFO: compiled from: source.java */
    public static final class Dummy implements LoaderErrorThrower {
        @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.LoaderErrorThrower
        public final void maybeThrowError() throws IOException {
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.LoaderErrorThrower
        public final void maybeThrowError(int i11) throws IOException {
        }
    }

    void maybeThrowError() throws IOException;

    void maybeThrowError(int i11) throws IOException;
}
