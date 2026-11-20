package androidx.media3.exoplayer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface y2 {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void b(w2 w2Var);
    }

    int a(androidx.media3.common.y yVar) throws ExoPlaybackException;

    void e();

    String getName();

    int getTrackType();

    void n(a aVar);

    int supportsMixedMimeTypeAdaptation() throws ExoPlaybackException;
}
