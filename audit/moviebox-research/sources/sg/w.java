package sg;

import com.google.android.exoplayer2.util.o0;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class w implements com.google.android.exoplayer2.decoder.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f76349d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UUID f76350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f76351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f76352c;

    /* JADX WARN: Code duplicated, block: B:9:0x001e  */
    static {
        boolean z11;
        if ("Amazon".equals(o0.f35610c)) {
            String str = o0.f35611d;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                z11 = true;
            } else {
                z11 = false;
            }
        } else {
            z11 = false;
        }
        f76349d = z11;
    }

    public w(UUID uuid, byte[] bArr, boolean z11) {
        this.f76350a = uuid;
        this.f76351b = bArr;
        this.f76352c = z11;
    }
}
