package tg;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface m extends com.google.android.exoplayer2.upstream.g {
    void advancePeekPosition(int i11) throws IOException;

    boolean advancePeekPosition(int i11, boolean z11) throws IOException;

    int b(byte[] bArr, int i11, int i12) throws IOException;

    long getLength();

    long getPeekPosition();

    long getPosition();

    void peekFully(byte[] bArr, int i11, int i12) throws IOException;

    boolean peekFully(byte[] bArr, int i11, int i12, boolean z11) throws IOException;

    @Override // com.google.android.exoplayer2.upstream.g
    int read(byte[] bArr, int i11, int i12) throws IOException;

    void readFully(byte[] bArr, int i11, int i12) throws IOException;

    boolean readFully(byte[] bArr, int i11, int i12, boolean z11) throws IOException;

    void resetPeekPosition();

    int skip(int i11) throws IOException;

    void skipFully(int i11) throws IOException;
}
