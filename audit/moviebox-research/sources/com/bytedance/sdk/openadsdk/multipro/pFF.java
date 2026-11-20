package com.bytedance.sdk.openadsdk.multipro;

import com.bytedance.sdk.openadsdk.core.SR;
import com.bytedance.sdk.openadsdk.multipro.aidl.BinderPoolService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static Boolean f28650sc;

    public static void pFF() {
        f28650sc = Boolean.FALSE;
        BinderPoolService.f28619sc = true;
    }

    public static void sc() {
        Boolean bool = Boolean.TRUE;
        f28650sc = bool;
        com.bytedance.sdk.openadsdk.multipro.We.sc.sc("sp_multi_info", "is_support_multi_process", bool);
    }

    public static boolean zY() {
        Boolean bool = f28650sc;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (!SR.ExN()) {
            return false;
        }
        if (f28650sc == null) {
            f28650sc = Boolean.valueOf(com.bytedance.sdk.openadsdk.multipro.We.sc.sc("sp_multi_info", "is_support_multi_process", false));
        }
        return f28650sc.booleanValue();
    }
}
