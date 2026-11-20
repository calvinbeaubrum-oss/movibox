package com.google.android.play.core.appupdate;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class y extends d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f38111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f38112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte f38113c;

    @Override // com.google.android.play.core.appupdate.d.a
    public final d a() {
        if (this.f38113c == 3) {
            return new a0(this.f38111a, this.f38112b, null);
        }
        StringBuilder sb2 = new StringBuilder();
        if ((this.f38113c & 1) == 0) {
            sb2.append(" appUpdateType");
        }
        if ((this.f38113c & 2) == 0) {
            sb2.append(" allowAssetPackDeletion");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb2.toString()));
    }

    @Override // com.google.android.play.core.appupdate.d.a
    public final d.a b(boolean z11) {
        this.f38112b = z11;
        this.f38113c = (byte) (this.f38113c | 2);
        return this;
    }

    public final d.a c(int i11) {
        this.f38111a = i11;
        this.f38113c = (byte) (this.f38113c | 1);
        return this;
    }
}
