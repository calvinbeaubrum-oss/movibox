package com.mbridge.msdk.foundation.same.net.e;

import com.mbridge.msdk.foundation.same.net.i;
import com.mbridge.msdk.foundation.tools.ad;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class e<T> extends i<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f44595c = "e";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f44596d;

    public e(int i11, String str, String str2, com.mbridge.msdk.foundation.same.net.e<T> eVar) {
        super(i11, str, eVar);
        this.f44596d = str2;
    }

    public e(int i11, String str, String str2, com.mbridge.msdk.foundation.same.net.e<T> eVar, boolean z11) {
        super(i11, str, eVar, z11);
        this.f44596d = str2;
    }

    @Override // com.mbridge.msdk.foundation.same.net.i
    public final byte[] h() {
        try {
            String str = this.f44596d;
            if (str == null) {
                return null;
            }
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            ad.b(f44595c, "Unsupported Encoding while trying to get the bytes of " + this.f44596d + " using utf-8");
            return null;
        }
    }
}
