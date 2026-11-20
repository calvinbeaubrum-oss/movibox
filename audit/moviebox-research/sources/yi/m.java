package yi;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class m extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f81422a = -1.0f;

    @Override // yi.e
    public void a(@NonNull p pVar, float f11, float f12, float f13) {
        pVar.o(0.0f, f13 * f12, 180.0f, 180.0f - f11);
        float f14 = f13 * 2.0f * f12;
        pVar.a(0.0f, 0.0f, f14, f14, 180.0f, f11);
    }
}
