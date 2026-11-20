package com.pgl.ssdk.ces;

import android.content.Context;
import android.text.TextUtils;
import com.pgl.ssdk.k0;
import com.pgl.ssdk.l0;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f48751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f48752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, Object> f48753c;

    public c(Context context, String str, Map<String, Object> map) {
        this.f48751a = context;
        this.f48752b = str;
        this.f48753c = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            byte[] bArr = (byte[]) a.meta(222, this.f48751a, new Object[]{this.f48752b, this.f48753c});
            if (bArr == null || bArr.length <= 0 || TextUtils.isEmpty(l0.a())) {
                return;
            }
            new k0(this.f48751a, null).a(1, 2, bArr);
        } catch (Throwable unused) {
        }
    }
}
