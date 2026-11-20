package com.bykv.vk.openvk.preload.falconx.a;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.bykv.vk.openvk.preload.a.b.a.m;
import com.bykv.vk.openvk.preload.a.d.c;
import com.bykv.vk.openvk.preload.a.h;
import com.bykv.vk.openvk.preload.a.i;
import com.bykv.vk.openvk.preload.a.j;
import com.bykv.vk.openvk.preload.a.l;
import com.bykv.vk.openvk.preload.a.o;
import com.bykv.vk.openvk.preload.b.b.b;
import com.bykv.vk.openvk.preload.b.d;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Class<? extends d<?, ?>>, b> f25672a = new HashMap();

    public static WebResourceResponse a(InputStream inputStream, Map<String, String> map) {
        if (inputStream == null) {
            return null;
        }
        try {
            String strReplace = map.get("content-type");
            String[] strArrSplit = new String[0];
            if (TextUtils.isEmpty(strReplace)) {
                strReplace = map.get(HttpHeaders.CONTENT_TYPE);
            }
            if (!TextUtils.isEmpty(strReplace) && strReplace != null) {
                strReplace = strReplace.replace(" ", "");
                strArrSplit = strReplace.split(";");
            }
            String str = "";
            String strSubstring = str;
            for (String str2 : strArrSplit) {
                if (!TextUtils.isEmpty(str2)) {
                    int iIndexOf = str2.indexOf("=");
                    if (iIndexOf == -1) {
                        str = str2;
                    } else if (str2.contains("charset")) {
                        strSubstring = str2.substring(iIndexOf + 1);
                    }
                }
            }
            if (strReplace != null ? strReplace.contains("font/ttf") : false) {
                return new WebResourceResponse(str, strSubstring, 200, "OK", map, inputStream);
            }
            WebResourceResponse webResourceResponse = new WebResourceResponse(str, strSubstring, inputStream);
            webResourceResponse.setResponseHeaders(map);
            return webResourceResponse;
        } catch (Throwable th2) {
            Log.e("WebResourceUtils", "getResponseWithHeaders error", th2);
            return null;
        }
    }

    public static h a(com.bykv.vk.openvk.preload.a.d.a aVar) throws l {
        boolean z11;
        try {
            try {
                aVar.f();
                z11 = false;
                try {
                    return m.A.a(aVar);
                } catch (EOFException e11) {
                    e = e11;
                    if (z11) {
                        return j.f25635a;
                    }
                    throw new o(e);
                }
            } catch (EOFException e12) {
                e = e12;
                z11 = true;
            }
        } catch (com.bykv.vk.openvk.preload.a.d.d e13) {
            throw new o(e13);
        } catch (IOException e14) {
            throw new i(e14);
        } catch (NumberFormatException e15) {
            throw new o(e15);
        }
    }

    public static <T> T a(T t11) {
        t11.getClass();
        return t11;
    }

    public static DateFormat a(int i11, int i12) {
        String str;
        String str2;
        StringBuilder sb2 = new StringBuilder();
        if (i11 == 0) {
            str = "EEEE, MMMM d, yyyy";
        } else if (i11 == 1) {
            str = "MMMM d, yyyy";
        } else if (i11 == 2) {
            str = "MMM d, yyyy";
        } else {
            if (i11 != 3) {
                throw new IllegalArgumentException("Unknown DateFormat style: ".concat(String.valueOf(i11)));
            }
            str = "M/d/yy";
        }
        sb2.append(str);
        sb2.append(" ");
        if (i12 == 0 || i12 == 1) {
            str2 = "h:mm:ss a z";
        } else if (i12 == 2) {
            str2 = "h:mm:ss a";
        } else {
            if (i12 != 3) {
                throw new IllegalArgumentException("Unknown DateFormat style: ".concat(String.valueOf(i12)));
            }
            str2 = "h:mm a";
        }
        sb2.append(str2);
        return new SimpleDateFormat(sb2.toString(), Locale.US);
    }

    public static void a(h hVar, c cVar) throws IOException {
        m.A.a(cVar, hVar);
    }

    public static void a(boolean z11) {
        if (!z11) {
            throw new IllegalArgumentException();
        }
    }

    public final com.bykv.vk.openvk.preload.b.b.a a(Class<? extends d<?, ?>> cls) {
        b bVar;
        synchronized (this.f25672a) {
            bVar = this.f25672a.get(cls);
        }
        return bVar;
    }

    public final void a(Class<? extends d<?, ?>> cls, com.bykv.vk.openvk.preload.b.b.a aVar) {
        synchronized (this.f25672a) {
            try {
                b bVar = this.f25672a.get(cls);
                if (bVar == null) {
                    bVar = new b(new com.bykv.vk.openvk.preload.b.b.a[0]);
                    this.f25672a.put(cls, bVar);
                }
                bVar.a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
