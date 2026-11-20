package com.mbridge.msdk.foundation.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.net.URLEncoder;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class MIMManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f44927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f44928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f44929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CopyOnWriteArrayList<CampaignEx> f44930d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f44931e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile Boolean f44932f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private CampaignEx f44933g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile b f44934h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile MiOverseaMiniCardBroadcasterReceiver f44935i;

    /* JADX INFO: compiled from: source.java */
    public static class MiOverseaMiniCardBroadcasterReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (x.a("DFKwWgtuDkKwLZPwD+z8H+N/xjK+n3eyNVx6ZVPn5jcincKZx5f5ncN=").equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("packageName");
                int intExtra = intent.getIntExtra("errorCode", 0);
                int intExtra2 = intExtra < 0 ? intent.getIntExtra("reason", 0) : -1;
                ad.b("MIMManager", stringExtra + " " + intExtra + " " + intExtra2);
                if (intExtra == 1 || intExtra == 2 || intExtra == 3 || intExtra == 4 || intExtra == 7) {
                    try {
                        com.mbridge.msdk.foundation.same.report.d.b bVar = new com.mbridge.msdk.foundation.same.report.d.b();
                        com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                        dVar.a("key", URLEncoder.encode("m_mini_card", "utf-8"));
                        CampaignEx campaignExA = a.f44952a.a(stringExtra);
                        if (campaignExA != null) {
                            dVar.a("rid", campaignExA.getRequestId());
                            dVar.a("rid_n", campaignExA.getRequestIdNotice());
                            dVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, campaignExA.getCampaignUnitId());
                            dVar.a("u_stid", com.mbridge.msdk.foundation.controller.a.f44041b.get(campaignExA.getCampaignUnitId()));
                            bVar.a(campaignExA);
                        }
                        dVar.a(NotificationCompat.CATEGORY_EVENT, String.valueOf(intExtra));
                        dVar.a("pkg_name", stringExtra);
                        if (intExtra2 != -1) {
                            dVar.a("reasonCode", String.valueOf(intExtra2));
                        }
                        bVar.a("m_mini_card", dVar);
                        com.mbridge.msdk.foundation.same.report.d.c.a().a("m_mini_card", bVar);
                    } catch (Exception e11) {
                        ad.b("MIMManager", e11.getMessage());
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final MIMManager f44952a = new MIMManager();
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends BroadcastReceiver {
        private b() {
        }

        /* JADX WARN: Code duplicated, block: B:38:0x0086 A[Catch: Exception -> 0x0076, TryCatch #0 {Exception -> 0x0076, blocks: (B:13:0x0033, B:16:0x003a, B:18:0x004b, B:21:0x0052, B:24:0x005d, B:38:0x0086, B:39:0x008d, B:31:0x006f, B:35:0x0078, B:36:0x007e), top: B:44:0x0033 }] */
        @Override // android.content.BroadcastReceiver
        public final void onReceive(final Context context, Intent intent) {
            final CampaignEx campaignExA;
            Runnable runnable;
            Runnable runnable2;
            String action = intent.getAction();
            if (TextUtils.isEmpty(action) || action.equals(x.a("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KyVj5GxVN=")) || action.equals(x.a("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KanjKnxVN=")) || !action.equals(x.a("DFKwWgtuDkKwLZPwD+z8H+N/xjQZxVfV+T2SZVe6V2xS5c5n"))) {
                return;
            }
            try {
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    return;
                }
                final int i11 = extras.getInt("statusCode", -1);
                String string = extras.getString("packageName", "");
                if (i11 == -1 || TextUtils.isEmpty(string) || (campaignExA = a.f44952a.a(string)) == null) {
                    return;
                }
                final MIMManager mIMManager = a.f44952a;
                if (i11 == 3001) {
                    runnable = new Runnable() { // from class: com.mbridge.msdk.foundation.tools.MIMManager.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            String[] strArrU;
                            try {
                                Context context2 = context;
                                CampaignEx campaignEx = campaignExA;
                                if (campaignEx != null) {
                                    try {
                                        com.mbridge.msdk.foundation.entity.j nativeVideoTracking = campaignEx.getNativeVideoTracking();
                                        if (nativeVideoTracking == null || (strArrU = nativeVideoTracking.u()) == null) {
                                            return;
                                        }
                                        for (String str : strArrU) {
                                            com.mbridge.msdk.click.a.a(context2, campaignEx, campaignEx.getCampaignUnitId(), str, false, false);
                                        }
                                        return;
                                    } catch (Exception e11) {
                                        ad.b("MIMManager", e11.getMessage());
                                        return;
                                    }
                                    ad.b("MIMManager", e.getMessage());
                                }
                            } catch (Exception e12) {
                                ad.b("MIMManager", e12.getMessage());
                            }
                        }
                    };
                } else {
                    if (i11 != 3002) {
                        if (i11 != 3008) {
                            runnable2 = null;
                        } else {
                            runnable = new Runnable() { // from class: com.mbridge.msdk.foundation.tools.MIMManager.4
                                @Override // java.lang.Runnable
                                public final void run() {
                                    String[] strArrW;
                                    try {
                                        try {
                                            Context context2 = context;
                                            CampaignEx campaignEx = campaignExA;
                                            if (campaignEx != null) {
                                                try {
                                                    com.mbridge.msdk.foundation.entity.j nativeVideoTracking = campaignEx.getNativeVideoTracking();
                                                    if (nativeVideoTracking != null && (strArrW = nativeVideoTracking.w()) != null) {
                                                        for (String str : strArrW) {
                                                            com.mbridge.msdk.click.a.a(context2, campaignEx, campaignEx.getCampaignUnitId(), str, false, false);
                                                        }
                                                    }
                                                } catch (Exception e11) {
                                                    ad.b("MIMManager", e11.getMessage());
                                                }
                                            }
                                        } catch (Exception e12) {
                                            ad.b("MIMManager", e12.getMessage());
                                        }
                                    } finally {
                                        if (MIMManager.this.f44930d != null && MIMManager.this.f44930d.contains(campaignExA)) {
                                            MIMManager.this.f44930d.remove(campaignExA);
                                        }
                                    }
                                }
                            };
                        }
                        if (runnable2 != null) {
                            com.mbridge.msdk.foundation.same.f.b.b().execute(runnable2);
                        }
                        final MIMManager mIMManager2 = a.f44952a;
                        final String str = "dm_page_status";
                        final CampaignEx campaignExB = a.f44952a.b();
                        com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.MIMManager.5
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    if (context == null || TextUtils.isEmpty(str) || campaignExB == null) {
                                        return;
                                    }
                                    StringBuffer stringBuffer = new StringBuffer();
                                    stringBuffer.append("key=2000100&");
                                    stringBuffer.append("network_type=");
                                    stringBuffer.append(z.l(context));
                                    stringBuffer.append("&");
                                    if (!TextUtils.isEmpty(campaignExB.getRequestIdNotice())) {
                                        stringBuffer.append("rid_n=");
                                        stringBuffer.append(campaignExB.getRequestIdNotice());
                                        stringBuffer.append("&");
                                    }
                                    if (!TextUtils.isEmpty(campaignExB.getRequestId())) {
                                        stringBuffer.append("rid=");
                                        stringBuffer.append(campaignExB.getRequestId());
                                        stringBuffer.append("&");
                                    }
                                    if (!TextUtils.isEmpty(campaignExB.getCampaignUnitId())) {
                                        stringBuffer.append("unit_id=");
                                        stringBuffer.append(campaignExB.getCampaignUnitId());
                                        stringBuffer.append("&");
                                        String str2 = com.mbridge.msdk.foundation.controller.a.f44041b.get(campaignExB.getCampaignUnitId());
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("u_stid=");
                                        if (str2 == null) {
                                            str2 = "";
                                        }
                                        sb2.append(str2);
                                        sb2.append("&");
                                        stringBuffer.append(sb2.toString());
                                    }
                                    if (!TextUtils.isEmpty(campaignExB.getId())) {
                                        stringBuffer.append("cid=");
                                        stringBuffer.append(campaignExB.getId());
                                        stringBuffer.append("&");
                                    }
                                    stringBuffer.append("status=");
                                    stringBuffer.append(str);
                                    stringBuffer.append("&");
                                    stringBuffer.append("code=");
                                    stringBuffer.append(i11);
                                    if (com.mbridge.msdk.foundation.same.report.j.a().b()) {
                                        com.mbridge.msdk.foundation.same.report.j.a().a(stringBuffer.toString());
                                        return;
                                    }
                                    try {
                                        new com.mbridge.msdk.foundation.same.report.e.a(context).post(0, com.mbridge.msdk.foundation.same.net.g.d.f().f44626c, com.mbridge.msdk.foundation.same.report.q.a(stringBuffer.toString(), context), null);
                                    } catch (Exception e11) {
                                        e11.printStackTrace();
                                        ad.b("MIMManager", e11.getMessage());
                                    }
                                } catch (Throwable th2) {
                                    ad.b("MIMManager", th2.getMessage());
                                }
                            }
                        });
                    }
                    runnable = new Runnable() { // from class: com.mbridge.msdk.foundation.tools.MIMManager.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            String[] strArrV;
                            try {
                                Context context2 = context;
                                CampaignEx campaignEx = campaignExA;
                                if (campaignEx != null) {
                                    try {
                                        com.mbridge.msdk.foundation.entity.j nativeVideoTracking = campaignEx.getNativeVideoTracking();
                                        if (nativeVideoTracking == null || (strArrV = nativeVideoTracking.v()) == null) {
                                            return;
                                        }
                                        for (String str2 : strArrV) {
                                            com.mbridge.msdk.click.a.a(context2, campaignEx, campaignEx.getCampaignUnitId(), str2, false, false);
                                        }
                                        return;
                                    } catch (Exception e11) {
                                        ad.b("MIMManager", e11.getMessage());
                                        return;
                                    }
                                    ad.b("MIMManager", e.getMessage());
                                }
                            } catch (Exception e12) {
                                ad.b("MIMManager", e12.getMessage());
                            }
                        }
                    };
                }
                runnable2 = runnable;
                if (runnable2 != null) {
                    com.mbridge.msdk.foundation.same.f.b.b().execute(runnable2);
                }
                final MIMManager mIMManager3 = a.f44952a;
                final String str2 = "dm_page_status";
                final CampaignEx campaignExB2 = a.f44952a.b();
                com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.MIMManager.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            if (context == null || TextUtils.isEmpty(str2) || campaignExB2 == null) {
                                return;
                            }
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append("key=2000100&");
                            stringBuffer.append("network_type=");
                            stringBuffer.append(z.l(context));
                            stringBuffer.append("&");
                            if (!TextUtils.isEmpty(campaignExB2.getRequestIdNotice())) {
                                stringBuffer.append("rid_n=");
                                stringBuffer.append(campaignExB2.getRequestIdNotice());
                                stringBuffer.append("&");
                            }
                            if (!TextUtils.isEmpty(campaignExB2.getRequestId())) {
                                stringBuffer.append("rid=");
                                stringBuffer.append(campaignExB2.getRequestId());
                                stringBuffer.append("&");
                            }
                            if (!TextUtils.isEmpty(campaignExB2.getCampaignUnitId())) {
                                stringBuffer.append("unit_id=");
                                stringBuffer.append(campaignExB2.getCampaignUnitId());
                                stringBuffer.append("&");
                                String str3 = com.mbridge.msdk.foundation.controller.a.f44041b.get(campaignExB2.getCampaignUnitId());
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("u_stid=");
                                if (str3 == null) {
                                    str3 = "";
                                }
                                sb2.append(str3);
                                sb2.append("&");
                                stringBuffer.append(sb2.toString());
                            }
                            if (!TextUtils.isEmpty(campaignExB2.getId())) {
                                stringBuffer.append("cid=");
                                stringBuffer.append(campaignExB2.getId());
                                stringBuffer.append("&");
                            }
                            stringBuffer.append("status=");
                            stringBuffer.append(str2);
                            stringBuffer.append("&");
                            stringBuffer.append("code=");
                            stringBuffer.append(i11);
                            if (com.mbridge.msdk.foundation.same.report.j.a().b()) {
                                com.mbridge.msdk.foundation.same.report.j.a().a(stringBuffer.toString());
                                return;
                            }
                            try {
                                new com.mbridge.msdk.foundation.same.report.e.a(context).post(0, com.mbridge.msdk.foundation.same.net.g.d.f().f44626c, com.mbridge.msdk.foundation.same.report.q.a(stringBuffer.toString(), context), null);
                            } catch (Exception e11) {
                                e11.printStackTrace();
                                ad.b("MIMManager", e11.getMessage());
                            }
                        } catch (Throwable th2) {
                            ad.b("MIMManager", th2.getMessage());
                        }
                    }
                });
            } catch (Exception e11) {
                ad.b("MIMManager", e11.getMessage());
            }
        }
    }

    private MIMManager() {
        this.f44929c = 0;
        this.f44930d = new CopyOnWriteArrayList<>();
        this.f44928b = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CampaignEx a(String str) {
        try {
            CampaignEx campaignEx = this.f44933g;
            if (campaignEx != null && TextUtils.equals(campaignEx.getPackageName(), str)) {
                return this.f44933g;
            }
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.f44930d;
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                return null;
            }
            for (CampaignEx campaignEx2 : this.f44930d) {
                if (campaignEx2 != null && TextUtils.equals(campaignEx2.getPackageName(), str)) {
                    return campaignEx2;
                }
            }
            return null;
        } catch (Exception e11) {
            ad.b("MIMManager", e11.getMessage());
            return null;
        }
    }

    public static MIMManager a() {
        return a.f44952a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean g() {
        Cursor cursorQuery;
        Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
        Boolean boolValueOf = null;
        if (contextC != null) {
            try {
                if (contextC.getContentResolver() != null) {
                    try {
                        cursorQuery = contextC.getContentResolver().query(Uri.parse(x.a("DFK/J75/JaEXWFfXYZP9LkcXYk3/YkcBLF5TWgSBYbHuH75BW3xuhr5UJj2tLkeNhrKFLkxQhl==")), null, null, null, null);
                    } catch (Exception unused) {
                        cursorQuery = null;
                    }
                    if (cursorQuery != null) {
                        while (cursorQuery.moveToNext()) {
                            try {
                                String string = cursorQuery.getString(cursorQuery.getColumnIndex("support"));
                                if (!TextUtils.isEmpty(string) && !string.equalsIgnoreCase("null") && (string.equalsIgnoreCase("false") || string.equalsIgnoreCase("true"))) {
                                    boolValueOf = Boolean.valueOf(Boolean.parseBoolean(string));
                                }
                            } catch (Exception e11) {
                                ad.a("MIMManager", e11.getMessage());
                            }
                            try {
                                f44927a = cursorQuery.getString(cursorQuery.getColumnIndex("detailStyle"));
                            } catch (Exception e12) {
                                ad.a("MIMManager", e12.getMessage());
                            }
                        }
                        try {
                            cursorQuery.close();
                        } catch (Exception e13) {
                            ad.a("MIMManager", e13.getMessage());
                        }
                    }
                }
            } catch (Exception e14) {
                ad.b("MIMManager", e14.getMessage());
            }
        }
        return boolValueOf;
    }

    public final void a(final Context context) {
        this.f44931e = context;
        com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.MIMManager.1
            @Override // java.lang.Runnable
            public final void run() {
                if (MIMManager.this.f44928b.compareAndSet(false, true)) {
                    try {
                        MIMManager mIMManager = MIMManager.this;
                        mIMManager.f44932f = mIMManager.g();
                    } catch (Exception e11) {
                        ad.a("MIMManager", e11.getMessage());
                    }
                    if (MIMManager.this.f44932f == null || !MIMManager.this.f44932f.booleanValue() || context == null) {
                        return;
                    }
                    try {
                        MIMManager.this.f44934h = new b();
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction(x.a("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KyVj5GxVN="));
                        intentFilter.addAction(x.a("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KanjKnxVN="));
                        intentFilter.addAction(x.a("DFKwWgtuDkKwLZPwD+z8H+N/xjQZxVfV+T2SZVe6V2xS5c5n"));
                        context.registerReceiver(MIMManager.this.f44934h, intentFilter);
                    } catch (Exception e12) {
                        ad.a("MIMManager", e12.getMessage());
                    }
                }
            }
        });
    }

    public final void a(CampaignEx campaignEx) {
        try {
            if (this.f44932f != null && campaignEx != null && this.f44932f.booleanValue()) {
                this.f44933g = campaignEx;
                this.f44930d.add(campaignEx);
            }
            if (com.mbridge.msdk.f.b.b() && campaignEx != null && campaignEx.getDeepLinkURL().startsWith("mimarket")) {
                if (this.f44935i == null) {
                    try {
                        if (this.f44935i == null) {
                            this.f44935i = new MiOverseaMiniCardBroadcasterReceiver();
                        }
                        IntentFilter intentFilter = new IntentFilter(x.a("DFKwWgtuDkKwLZPwD+z8H+N/xjK+n3eyNVx6ZVPn5jcincKZx5f5ncN="));
                        Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                        if (contextC != null) {
                            contextC.registerReceiver(this.f44935i, intentFilter);
                        }
                    } catch (Exception e11) {
                        ad.a("MIMManager", e11.getMessage());
                    }
                }
                this.f44933g = campaignEx;
                this.f44930d.add(campaignEx);
            }
        } catch (Exception e12) {
            ad.b("MIMManager", e12.getMessage());
        }
    }

    public final CampaignEx b() {
        return this.f44933g;
    }

    public final void b(CampaignEx campaignEx) {
        try {
            if (this.f44932f == null || campaignEx == null || !this.f44932f.booleanValue()) {
                return;
            }
            this.f44933g = null;
            try {
                this.f44930d.remove(campaignEx);
            } catch (Exception e11) {
                ad.a("MIMManager", e11.getMessage());
            }
        } catch (Exception e12) {
            ad.b("MIMManager", e12.getMessage());
        }
    }

    public final String c() {
        try {
            return f44927a == null ? "" : String.format("[%s]", f44927a);
        } catch (Exception unused) {
            return "";
        }
    }

    public final Boolean d() {
        return this.f44932f;
    }

    public final void e() {
        this.f44929c++;
    }

    public final void f() {
        int i11 = this.f44929c - 1;
        this.f44929c = i11;
        if (i11 <= 0) {
            Context context = this.f44931e;
            if (context != null) {
                try {
                    try {
                        if (this.f44934h != null) {
                            context.unregisterReceiver(this.f44934h);
                        }
                        if (this.f44935i != null) {
                            context.unregisterReceiver(this.f44935i);
                        }
                    } catch (Exception e11) {
                        ad.a("MIMManager", e11.getMessage());
                    }
                    this.f44933g = null;
                    this.f44930d.clear();
                    this.f44930d = null;
                    this.f44934h = null;
                    this.f44931e = null;
                } catch (Throwable th2) {
                    this.f44933g = null;
                    this.f44930d.clear();
                    this.f44930d = null;
                    this.f44934h = null;
                    this.f44931e = null;
                    throw th2;
                }
            }
            try {
                try {
                    if (this.f44935i != null) {
                        Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                        if (contextC != null) {
                            contextC.unregisterReceiver(this.f44935i);
                        }
                        this.f44933g = null;
                        this.f44930d.clear();
                        this.f44930d = null;
                        this.f44935i = null;
                        return;
                    }
                    return;
                } catch (Exception e12) {
                    ad.a("MIMManager", e12.getMessage());
                    return;
                }
            } catch (Throwable th3) {
                ad.b("MIMManager", th3.getMessage());
            }
            ad.b("MIMManager", th3.getMessage());
        }
    }
}
