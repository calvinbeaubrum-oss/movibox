package p009OooO0oo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.cloud.tmc.integration.model.CacheReportBean;
import hd.j;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import la.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class OooOo00 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f166a = new a();

    /* JADX INFO: compiled from: source.java */
    public static final class a {
    }

    public final void a(Bundle bundle) {
        try {
            int i11 = bundle.getInt("miniProcessId");
            String string = bundle.getString("miniGaid");
            if (string == null) {
                string = "";
            }
            na.a aVar = na.a.f71773a;
            aVar.c(i11);
            new Bundle().putString("miniGaid", string);
            aVar.a();
        } catch (Throwable unused) {
        }
    }

    public final void b(String str, Bundle bundle) {
        try {
            b.a("MiniBroadcastReceiver", "MiniBroadcastReceiver -> reportDataToPs:" + str);
            bundle.getString("miniGaid");
            na.a.f71773a.a();
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0048 A[Catch: all -> 0x004e, TRY_LEAVE, TryCatch #1 {all -> 0x004e, blocks: (B:21:0x0042, B:23:0x0048), top: B:64:0x0042 }] */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (!Intrinsics.b(intent != null ? intent.getPackage() : null, context != null ? context.getPackageName() : null)) {
            StringBuilder sbA = j.a("MiniBroadcastReceiver -> onReceive:");
            sbA.append(intent != null ? intent.getPackage() : null);
            sbA.append(" != ");
            sbA.append(context != null ? context.getPackageName() : null);
            b.a("MiniBroadcastReceiver", sbA.toString());
            return;
        }
        if (intent != null) {
            try {
                extras = intent.getExtras();
                if (extras == null) {
                    extras = new Bundle();
                }
            } catch (Throwable unused) {
                extras = new Bundle();
            }
        } else {
            extras = new Bundle();
        }
        String action = intent != null ? intent.getAction() : null;
        if (Intrinsics.b(action, "com.cloud.tmc.miniapp.process_id")) {
            a(extras);
            return;
        }
        if (Intrinsics.b(action, "com.cloud.tmc.miniapp.addhome_success")) {
            b("miniAddHomeSuccess", extras);
            return;
        }
        if (Intrinsics.b(action, "com.cloud.tmc.miniapp.start_time")) {
            b("miniAppStartTime", extras);
            return;
        }
        if (Intrinsics.b(action, "com.cloud.tmc.miniapp.use_time")) {
            b("miniAppUseTime", extras);
            return;
        }
        if (Intrinsics.b(action, "com.cloud.tmc.miniapp.report_cache")) {
            try {
                ArrayList<CacheReportBean> parcelableArrayListExtra = intent.getParcelableArrayListExtra("reportCachedata");
                if (parcelableArrayListExtra != null) {
                    for (CacheReportBean cacheReportBean : parcelableArrayListExtra) {
                        String event = cacheReportBean.getEvent();
                        if (Intrinsics.b(event, "com.cloud.tmc.miniapp.process_id")) {
                            a(cacheReportBean.getData());
                        } else if (Intrinsics.b(event, "com.cloud.tmc.miniapp.addhome_success")) {
                            b("miniAddHomeSuccess", cacheReportBean.getData());
                        } else if (Intrinsics.b(event, "com.cloud.tmc.miniapp.start_time")) {
                            b("miniAppStartTime", cacheReportBean.getData());
                        } else if (Intrinsics.b(event, "com.cloud.tmc.miniapp.use_time")) {
                            b("miniAppUseTime", cacheReportBean.getData());
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
        }
    }
}
