package com.applovin.impl;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ra implements qd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qa.b f22073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f22074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f22075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f22076d;

    public ra(String str, boolean z11, qa.b bVar) {
        b1.a((z11 && TextUtils.isEmpty(str)) ? false : true);
        this.f22073a = bVar;
        this.f22074b = str;
        this.f22075c = z11;
        this.f22076d = new HashMap();
    }

    private static String a(qa.e eVar, int i11) {
        Map map;
        List list;
        int i12 = eVar.f21922d;
        if ((i12 != 307 && i12 != 308) || i11 >= 5 || (map = eVar.f21924g) == null || (list = (List) map.get(HttpHeaders.LOCATION)) == null || list.isEmpty()) {
            return null;
        }
        return (String) list.get(0);
    }

    private static byte[] a(qa.b bVar, String str, byte[] bArr, Map map) throws rd {
        fl flVar = new fl(bVar.a());
        l5 l5VarA = new l5.b().b(str).a(map).b(2).a(bArr).a(1).a();
        int i11 = 0;
        l5 l5VarA2 = l5VarA;
        while (true) {
            try {
                k5 k5Var = new k5(flVar, l5VarA2);
                try {
                    try {
                        byte[] bArrA = xp.a((InputStream) k5Var);
                        xp.a((Closeable) k5Var);
                        return bArrA;
                    } catch (qa.e e11) {
                        String strA = a(e11, i11);
                        if (strA == null) {
                            throw e11;
                        }
                        i11++;
                        l5VarA2 = l5VarA2.a().b(strA).a();
                        xp.a((Closeable) k5Var);
                    }
                } catch (Throwable th2) {
                    xp.a((Closeable) k5Var);
                    throw th2;
                }
            } catch (Exception e12) {
                throw new rd(l5VarA, (Uri) b1.a(flVar.h()), flVar.e(), flVar.g(), e12);
            }
        }
    }

    public void a(String str, String str2) {
        b1.a((Object) str);
        b1.a((Object) str2);
        synchronized (this.f22076d) {
            this.f22076d.put(str, str2);
        }
    }

    @Override // com.applovin.impl.qd
    public byte[] a(UUID uuid, z7.a aVar) throws rd {
        String str;
        String strB = aVar.b();
        if (this.f22075c || TextUtils.isEmpty(strB)) {
            strB = this.f22074b;
        }
        if (TextUtils.isEmpty(strB)) {
            l5.b bVar = new l5.b();
            Uri uri = Uri.EMPTY;
            throw new rd(bVar.a(uri).a(), uri, gb.h(), 0L, new IllegalStateException("No license URL"));
        }
        HashMap map = new HashMap();
        UUID uuid2 = t2.f23171e;
        if (uuid2.equals(uuid)) {
            str = "text/xml";
        } else {
            str = t2.f23169c.equals(uuid) ? "application/json" : OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
        }
        map.put(HttpHeaders.CONTENT_TYPE, str);
        if (uuid2.equals(uuid)) {
            map.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.f22076d) {
            map.putAll(this.f22076d);
        }
        return a(this.f22073a, strB, aVar.a(), map);
    }

    @Override // com.applovin.impl.qd
    public byte[] a(UUID uuid, z7.d dVar) {
        return a(this.f22073a, dVar.b() + "&signedRequest=" + xp.a(dVar.a()), null, Collections.emptyMap());
    }
}
