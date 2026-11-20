package i4;

import java.util.UUID;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w implements androidx.media3.decoder.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f67139d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UUID f67140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f67141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f67142c;

    /* JADX WARN: Code duplicated, block: B:9:0x001e  */
    static {
        boolean z11;
        if ("Amazon".equals(u0.f81840c)) {
            String str = u0.f81841d;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                z11 = true;
            } else {
                z11 = false;
            }
        } else {
            z11 = false;
        }
        f67139d = z11;
    }

    public w(UUID uuid, byte[] bArr, boolean z11) {
        this.f67140a = uuid;
        this.f67141b = bArr;
        this.f67142c = z11;
    }
}
