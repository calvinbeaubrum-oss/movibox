package com.bytedance.sdk.openadsdk.We.sc;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static final pFF f27411sc = new pFF(0);
    public static final pFF pFF = new pFF(1);
    public static final pFF zY = new pFF(2);
    public static final pFF We = new pFF(0);
    public static final pFF ExN = new pFF(1);
    public static final pFF TRI = new pFF(2);

    public static void pFF() {
        try {
            com.bytedance.sdk.openadsdk.SR.zY.pFF("net_upload_monitor", com.bytedance.sdk.openadsdk.multipro.We.sc.pFF("tt_sdk_event_net_ad", "tt_sdk_event_net_ad", ""));
            com.bytedance.sdk.openadsdk.multipro.We.sc.sc("tt_sdk_event_net_ad");
            com.bytedance.sdk.openadsdk.SR.zY.pFF("net_upload_monitor", com.bytedance.sdk.openadsdk.multipro.We.sc.pFF("tt_sdk_event_net_state", "tt_sdk_event_net_state", ""));
            com.bytedance.sdk.openadsdk.multipro.We.sc.sc("tt_sdk_event_net_state");
            com.bytedance.sdk.openadsdk.SR.zY.pFF("net_upload_monitor", com.bytedance.sdk.openadsdk.multipro.We.sc.pFF("tt_sdk_event_net_trail", "tt_sdk_event_net_trail", ""));
            com.bytedance.sdk.openadsdk.multipro.We.sc.sc("tt_sdk_event_net_trail");
            com.bytedance.sdk.openadsdk.SR.zY.pFF("db_upload_monitor", com.bytedance.sdk.openadsdk.multipro.We.sc.pFF("tt_sdk_event_db_ad", "tt_sdk_event_db_ad", ""));
            com.bytedance.sdk.openadsdk.multipro.We.sc.sc("tt_sdk_event_db_ad");
            com.bytedance.sdk.openadsdk.SR.zY.pFF("db_upload_monitor", com.bytedance.sdk.openadsdk.multipro.We.sc.pFF("tt_sdk_event_db_state", "tt_sdk_event_db_state", ""));
            com.bytedance.sdk.openadsdk.multipro.We.sc.sc("tt_sdk_event_db_state");
            com.bytedance.sdk.openadsdk.SR.zY.pFF("db_upload_monitor", com.bytedance.sdk.openadsdk.multipro.We.sc.pFF("tt_sdk_event_db_trail", "tt_sdk_event_db_trail", ""));
            com.bytedance.sdk.openadsdk.multipro.We.sc.sc("tt_sdk_event_db_trail");
        } catch (Throwable unused) {
        }
    }

    public static void sc() {
        try {
            pFF pff = f27411sc;
            if (pff.f27408qr.get()) {
                com.bytedance.sdk.openadsdk.multipro.We.sc.sc("tt_sdk_event_net_ad", "tt_sdk_event_net_ad", pff.sc().toString());
            }
            pFF pff2 = pFF;
            if (pff2.f27408qr.get()) {
                com.bytedance.sdk.openadsdk.multipro.We.sc.sc("tt_sdk_event_net_state", "tt_sdk_event_net_state", pff2.sc().toString());
            }
            pFF pff3 = zY;
            if (pff3.f27408qr.get()) {
                com.bytedance.sdk.openadsdk.multipro.We.sc.sc("tt_sdk_event_net_trail", "tt_sdk_event_net_trail", pff3.sc().toString());
            }
            pFF pff4 = We;
            if (pff4.f27408qr.get()) {
                com.bytedance.sdk.openadsdk.multipro.We.sc.sc("tt_sdk_event_db_ad", "tt_sdk_event_db_ad", pff4.pFF().toString());
            }
            pFF pff5 = ExN;
            if (pff5.f27408qr.get()) {
                com.bytedance.sdk.openadsdk.multipro.We.sc.sc("tt_sdk_event_db_state", "tt_sdk_event_db_state", pff5.pFF().toString());
            }
            pFF pff6 = TRI;
            if (pff6.f27408qr.get()) {
                com.bytedance.sdk.openadsdk.multipro.We.sc.sc("tt_sdk_event_db_trail", "tt_sdk_event_db_trail", pff6.pFF().toString());
            }
        } catch (Throwable unused) {
        }
    }

    public static void sc(pFF pff) {
        try {
            pff.f27408qr.getAndSet(true);
            pff.ExN.incrementAndGet();
        } catch (Throwable unused) {
        }
    }

    public static void sc(pFF pff, boolean z11) {
        try {
            pff.f27408qr.getAndSet(true);
            if (z11) {
                pff.f27409sc.incrementAndGet();
            } else {
                pff.pFF.incrementAndGet();
            }
        } catch (Throwable unused) {
        }
    }

    public static void sc(pFF pff, boolean z11, int i11, long j11) {
        try {
            pff.f27408qr.getAndSet(true);
            if (z11) {
                pff.f27409sc.incrementAndGet();
                pff.zY.addAndGet(j11);
                return;
            }
            pff.pFF.incrementAndGet();
            Integer num = pff.TRI.get(Integer.valueOf(i11));
            if (num != null) {
                pff.TRI.put(Integer.valueOf(i11), Integer.valueOf(num.intValue() + 1));
            } else {
                pff.TRI.put(Integer.valueOf(i11), 1);
            }
        } catch (Throwable unused) {
        }
    }
}
