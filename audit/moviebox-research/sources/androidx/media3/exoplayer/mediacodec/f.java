package androidx.media3.exoplayer.mediacodec;

import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f10768a = new f() { // from class: m4.t
        @Override // androidx.media3.exoplayer.mediacodec.f
        public final List a(String str, boolean z11, boolean z12) {
            return MediaCodecUtil.t(str, z11, z12);
        }
    };

    List<d> a(String str, boolean z11, boolean z12) throws MediaCodecUtil.DecoderQueryException;
}
