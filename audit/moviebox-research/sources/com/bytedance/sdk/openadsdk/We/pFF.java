package com.bytedance.sdk.openadsdk.We;

import com.transsion.push.PushConstants;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static final String f27372sc = com.bytedance.sdk.openadsdk.We.zY.sc.InterfaceC0276sc.f27475sc;
    public static final String pFF = com.bytedance.sdk.openadsdk.We.zY.sc.InterfaceC0276sc.pFF;
    public static final String zY = com.bytedance.sdk.openadsdk.We.zY.sc.InterfaceC0276sc.zY;
    public static final String We = com.bytedance.sdk.openadsdk.We.zY.sc.InterfaceC0276sc.We;
    public static final String ExN = com.bytedance.sdk.openadsdk.We.zY.sc.InterfaceC0276sc.ExN;
    public static final String TRI = com.bytedance.sdk.openadsdk.We.zY.sc.InterfaceC0276sc.TRI;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    public static final Set<String> f27371qr = new HashSet(Arrays.asList("click", PushConstants.PUSH_SERVICE_TYPE_SHOW, "insight_log"));

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.We.pFF$pFF, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0272pFF {
        public static int pFF = 2;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public static int f27373sc = 1;
        public static int zY = 100;
    }

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        public static String We = "saLandingPageLinks";
        public static String pFF = "openAdLandPageLinks";

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public static String f27374sc = "openDetailPage";
        public static String zY = "direct";
    }

    public static boolean sc(String str) {
        return "embeded_ad".equals(str) || "banner_ad".equals(str) || "interaction".equals(str) || "slide_banner_ad".equals(str);
    }
}
