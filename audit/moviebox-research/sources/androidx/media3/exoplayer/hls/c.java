package androidx.media3.exoplayer.hls;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.media3.datasource.a.InterfaceC0090a f10375a;

    public c(androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a) {
        this.f10375a = interfaceC0090a;
    }

    @Override // androidx.media3.exoplayer.hls.f
    public androidx.media3.datasource.a a(int i11) {
        return this.f10375a.createDataSource();
    }
}
