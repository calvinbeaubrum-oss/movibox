package com.google.android.exoplayer2.drm;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.i0;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.util.o0;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class i implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k.a f33183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f33184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f33185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f33186d;

    public i(@Nullable String str, boolean z11, k.a aVar) {
        com.google.android.exoplayer2.util.a.a((z11 && TextUtils.isEmpty(str)) ? false : true);
        this.f33183a = aVar;
        this.f33184b = str;
        this.f33185c = z11;
        this.f33186d = new HashMap();
    }

    public static byte[] c(k.a aVar, String str, @Nullable byte[] bArr, Map<String, String> map) throws MediaDrmCallbackException {
        i0 i0Var = new i0(aVar.createDataSource());
        n nVarA = new n.b().j(str).e(map).d(2).c(bArr).b(1).a();
        int i11 = 0;
        n nVarA2 = nVarA;
        while (true) {
            try {
                l lVar = new l(i0Var, nVarA2);
                try {
                    try {
                        byte[] bArrZ0 = o0.Z0(lVar);
                        o0.n(lVar);
                        return bArrZ0;
                    } catch (HttpDataSource$InvalidResponseCodeException e11) {
                        String strD = d(e11, i11);
                        if (strD == null) {
                            throw e11;
                        }
                        i11++;
                        nVarA2 = nVarA2.a().j(strD).a();
                        o0.n(lVar);
                    }
                } catch (Throwable th2) {
                    o0.n(lVar);
                    throw th2;
                }
            } catch (Exception e12) {
                throw new MediaDrmCallbackException(nVarA, (Uri) com.google.android.exoplayer2.util.a.e(i0Var.h()), i0Var.getResponseHeaders(), i0Var.f(), e12);
            }
        }
    }

    @Nullable
    public static String d(HttpDataSource$InvalidResponseCodeException httpDataSource$InvalidResponseCodeException, int i11) {
        Map<String, List<String>> map;
        List<String> list;
        int i12 = httpDataSource$InvalidResponseCodeException.responseCode;
        if ((i12 != 307 && i12 != 308) || i11 >= 5 || (map = httpDataSource$InvalidResponseCodeException.headerFields) == null || (list = map.get(HttpHeaders.LOCATION)) == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override // com.google.android.exoplayer2.drm.j
    public byte[] a(UUID uuid, g.d dVar) throws MediaDrmCallbackException {
        return c(this.f33183a, dVar.b() + "&signedRequest=" + o0.D(dVar.a()), null, Collections.emptyMap());
    }

    @Override // com.google.android.exoplayer2.drm.j
    public byte[] b(UUID uuid, g.a aVar) throws MediaDrmCallbackException {
        String str;
        String strB = aVar.b();
        if (this.f33185c || TextUtils.isEmpty(strB)) {
            strB = this.f33184b;
        }
        if (TextUtils.isEmpty(strB)) {
            n.b bVar = new n.b();
            Uri uri = Uri.EMPTY;
            throw new MediaDrmCallbackException(bVar.i(uri).a(), uri, ImmutableMap.of(), 0L, new IllegalStateException("No license URL"));
        }
        HashMap map = new HashMap();
        UUID uuid2 = com.google.android.exoplayer2.h.f33257e;
        if (uuid2.equals(uuid)) {
            str = "text/xml";
        } else {
            str = com.google.android.exoplayer2.h.f33255c.equals(uuid) ? "application/json" : OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
        }
        map.put(HttpHeaders.CONTENT_TYPE, str);
        if (uuid2.equals(uuid)) {
            map.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.f33186d) {
            map.putAll(this.f33186d);
        }
        return c(this.f33183a, strB, aVar.a(), map);
    }

    public void e(String str, String str2) {
        com.google.android.exoplayer2.util.a.e(str);
        com.google.android.exoplayer2.util.a.e(str2);
        synchronized (this.f33186d) {
            this.f33186d.put(str, str2);
        }
    }
}
