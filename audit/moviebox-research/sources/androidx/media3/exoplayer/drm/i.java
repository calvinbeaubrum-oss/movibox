package androidx.media3.exoplayer.drm;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.datasource.HttpDataSource;
import c4.m;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.media3.datasource.a.InterfaceC0090a f10305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f10306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f10307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f10308d;

    public i(@Nullable String str, boolean z11, androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a) {
        z3.a.a((z11 && TextUtils.isEmpty(str)) ? false : true);
        this.f10305a = interfaceC0090a;
        this.f10306b = str;
        this.f10307c = z11;
        this.f10308d = new HashMap();
    }

    public static byte[] c(androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a, String str, @Nullable byte[] bArr, Map<String, String> map) throws MediaDrmCallbackException {
        m mVar = new m(interfaceC0090a.createDataSource());
        c4.g gVarA = new c4.g.b().j(str).e(map).d(2).c(bArr).b(1).a();
        int i11 = 0;
        c4.g gVarA2 = gVarA;
        while (true) {
            try {
                c4.e eVar = new c4.e(mVar, gVarA2);
                try {
                    byte[] bArrU1 = u0.u1(eVar);
                    u0.m(eVar);
                    return bArrU1;
                } catch (HttpDataSource.InvalidResponseCodeException e11) {
                    try {
                        String strD = d(e11, i11);
                        if (strD == null) {
                            throw e11;
                        }
                        i11++;
                        gVarA2 = gVarA2.a().j(strD).a();
                        u0.m(eVar);
                    } catch (Throwable th2) {
                        u0.m(eVar);
                        throw th2;
                    }
                }
            } catch (Exception e12) {
                throw new MediaDrmCallbackException(gVarA, (Uri) z3.a.e(mVar.e()), mVar.getResponseHeaders(), mVar.d(), e12);
            }
        }
    }

    @Nullable
    public static String d(HttpDataSource.InvalidResponseCodeException invalidResponseCodeException, int i11) {
        Map<String, List<String>> map;
        List<String> list;
        int i12 = invalidResponseCodeException.responseCode;
        if ((i12 != 307 && i12 != 308) || i11 >= 5 || (map = invalidResponseCodeException.headerFields) == null || (list = map.get(HttpHeaders.LOCATION)) == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override // androidx.media3.exoplayer.drm.j
    public byte[] a(UUID uuid, g.a aVar) throws MediaDrmCallbackException {
        String str;
        String strB = aVar.b();
        if (this.f10307c || TextUtils.isEmpty(strB)) {
            strB = this.f10306b;
        }
        if (TextUtils.isEmpty(strB)) {
            c4.g.b bVar = new c4.g.b();
            Uri uri = Uri.EMPTY;
            throw new MediaDrmCallbackException(bVar.i(uri).a(), uri, ImmutableMap.of(), 0L, new IllegalStateException("No license URL"));
        }
        HashMap map = new HashMap();
        UUID uuid2 = androidx.media3.common.j.f9255e;
        if (uuid2.equals(uuid)) {
            str = "text/xml";
        } else {
            str = androidx.media3.common.j.f9253c.equals(uuid) ? "application/json" : OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
        }
        map.put(HttpHeaders.CONTENT_TYPE, str);
        if (uuid2.equals(uuid)) {
            map.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.f10308d) {
            map.putAll(this.f10308d);
        }
        return c(this.f10305a, strB, aVar.a(), map);
    }

    @Override // androidx.media3.exoplayer.drm.j
    public byte[] b(UUID uuid, g.d dVar) throws MediaDrmCallbackException {
        return c(this.f10305a, dVar.b() + "&signedRequest=" + u0.H(dVar.a()), null, Collections.emptyMap());
    }

    public void e(String str, String str2) {
        z3.a.e(str);
        z3.a.e(str2);
        synchronized (this.f10308d) {
            this.f10308d.put(str, str2);
        }
    }
}
