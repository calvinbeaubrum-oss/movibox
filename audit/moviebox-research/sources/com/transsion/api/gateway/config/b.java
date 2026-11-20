package com.transsion.api.gateway.config;

import android.text.TextUtils;
import com.transsion.api.gateway.bean.RemoteConfig;
import com.transsion.api.gateway.utils.ContextUtils;
import com.transsion.api.gateway.utils.GatewayUtils;
import com.transsion.api.gateway.utils.SafeStringUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static volatile b INSTANCE;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f50726a;

    public b() {
        new AtomicBoolean(false);
        try {
            b();
        } catch (Exception unused) {
        }
    }

    public static b a() {
        if (INSTANCE == null) {
            synchronized (b.class) {
                try {
                    if (INSTANCE == null) {
                        INSTANCE = new b();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return INSTANCE;
    }

    public void b() {
        if (this.f50726a != null) {
            return;
        }
        SafeStringUtils.getInstance(ContextUtils.getContext()).getLong(SafeStringUtils.SP_LAST_CONFIG_SYNC_TIME);
        String string = SafeStringUtils.getInstance(ContextUtils.getContext()).getString(SafeStringUtils.SP_CONFIG);
        if (!TextUtils.isEmpty(string)) {
            GatewayUtils.L.d(" load from cache");
            try {
                a aVar = new a(new a.C0552a(new a(new a.C0552a())).a((RemoteConfig) com.transsion.json.b.a(string, RemoteConfig.class)));
                if (aVar.f50707d > 0) {
                    this.f50726a = aVar;
                }
                GatewayUtils.L.d(" load from cache success" + this.f50726a.toString());
                return;
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        GatewayUtils.L.d(" set config");
        this.f50726a = new a(new a.C0552a(new a(new a.C0552a())));
    }
}
