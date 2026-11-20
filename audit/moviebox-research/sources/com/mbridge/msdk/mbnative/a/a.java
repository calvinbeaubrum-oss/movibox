package com.mbridge.msdk.mbnative.a;

import android.text.TextUtils;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.out.Campaign;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a extends b<String, List<Campaign>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f f45454a = f.a(h.a(com.mbridge.msdk.foundation.controller.c.m().c()));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f45455b;

    public a(int i11) {
        this.f45455b = i11;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0065 A[RETURN] */
    private boolean a(List<CampaignEx> list, int i11) {
        long jAb;
        long j11;
        if (list != null && list.size() > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long timestamp = list.get(0).getTimestamp();
            if (i11 != 1) {
                if (i11 != 2) {
                    j11 = 0;
                } else {
                    g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
                    if (gVarB == null) {
                        com.mbridge.msdk.c.h.a();
                        gVarB = i.a();
                    }
                    jAb = gVarB.ac();
                }
                if (jCurrentTimeMillis - timestamp > j11) {
                    return true;
                }
            } else {
                g gVarB2 = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
                if (gVarB2 == null) {
                    com.mbridge.msdk.c.h.a();
                    gVarB2 = i.a();
                }
                jAb = gVarB2.ab();
            }
            j11 = 1000 * jAb;
            if (jCurrentTimeMillis - timestamp > j11) {
                return true;
            }
        }
        return false;
    }

    @Override // com.mbridge.msdk.mbnative.a.b
    public final /* synthetic */ List<Campaign> a(String str, int i11) {
        String str2 = str;
        List<CampaignEx> listA = this.f45454a.a(str2, i11, 2, this.f45455b);
        if (listA == null) {
            return null;
        }
        if (a(listA, 2)) {
            this.f45454a.a(str2, 2, this.f45455b);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(listA);
        return arrayList;
    }

    @Override // com.mbridge.msdk.mbnative.a.b
    public final /* synthetic */ void a(String str, List<Campaign> list) {
        String str2 = str;
        List<Campaign> list2 = list;
        if (TextUtils.isEmpty(str2) || list2 == null || list2.size() <= 0) {
            return;
        }
        this.f45454a.a(str2, 1, this.f45455b, false);
        this.f45454a.a(str2, 2, this.f45455b, false);
        for (int i11 = 0; i11 < list2.size(); i11++) {
            CampaignEx campaignEx = (CampaignEx) list2.get(i11);
            campaignEx.setCacheLevel(1);
            this.f45454a.a(campaignEx, str2, 1);
        }
    }

    @Override // com.mbridge.msdk.mbnative.a.b
    public final /* synthetic */ void a(String str, List<Campaign> list, String str2) {
        final String str3 = str;
        final List<Campaign> list2 = list;
        boolean z11 = !TextUtils.isEmpty(str2);
        if (TextUtils.isEmpty(str3) || list2 == null || list2.size() <= 0) {
            return;
        }
        this.f45454a.a(str3, 1, this.f45455b, z11);
        this.f45454a.a(str3, 2, this.f45455b, z11);
        com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.mbnative.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                for (int i11 = 0; i11 < list2.size(); i11++) {
                    CampaignEx campaignEx = (CampaignEx) list2.get(i11);
                    campaignEx.setCacheLevel(1);
                    a.this.f45454a.a(campaignEx, str3, 1);
                }
            }
        });
    }

    @Override // com.mbridge.msdk.mbnative.a.b
    public final void a(String str, Campaign campaign, String str2) {
        boolean z11 = !TextUtils.isEmpty(str2);
        if (campaign == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            CampaignEx campaignEx = (CampaignEx) campaign;
            if (this.f45454a.a(campaignEx.getId(), campaignEx.getTab(), str, campaignEx.getCacheLevel(), campaignEx.getType(), z11)) {
                this.f45454a.a(campaignEx.getId(), str, campaignEx.getCacheLevel(), this.f45455b, z11);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.mbnative.a.b
    public final /* synthetic */ List<Campaign> b(String str, int i11) {
        String str2 = str;
        List<CampaignEx> listA = this.f45454a.a(str2, i11, 1, this.f45455b);
        if (listA == null) {
            return null;
        }
        if (!a(listA, 1)) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(listA);
            return arrayList;
        }
        for (int i12 = 0; i12 < listA.size(); i12++) {
            CampaignEx campaignEx = listA.get(i12);
            campaignEx.setCacheLevel(2);
            this.f45454a.a(campaignEx, str2, 1);
        }
        return null;
    }
}
