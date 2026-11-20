package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f33564a = new e() { // from class: fh.j
        @Override // com.google.android.exoplayer2.mediacodec.e
        public final List a(String str, boolean z11, boolean z12) {
            return MediaCodecUtil.s(str, z11, z12);
        }
    };

    List<d> a(String str, boolean z11, boolean z12) throws MediaCodecUtil.DecoderQueryException;
}
