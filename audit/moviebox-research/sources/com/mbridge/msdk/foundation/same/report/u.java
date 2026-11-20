package com.mbridge.msdk.foundation.same.report;

import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class u extends com.mbridge.msdk.e.v {
    @Override // com.mbridge.msdk.e.v
    public final com.mbridge.msdk.e.a.r<String> a(com.mbridge.msdk.e.a.m mVar) {
        String str;
        try {
            str = new String(mVar.f43803b, com.mbridge.msdk.e.a.a.e.a(mVar.f43804c));
        } catch (UnsupportedEncodingException unused) {
            str = new String(mVar.f43803b);
        }
        return com.mbridge.msdk.e.a.r.a(str, com.mbridge.msdk.e.a.a.e.a(mVar));
    }
}
