package com.mbridge.msdk.nativex.listener;

import android.content.Context;
import androidx.viewpager.widget.ViewPager;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.same.report.o;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.NativeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class RollingPagerListenrt implements ViewPager.h {
    private NativeListener.FilpListener FilpListening;
    private List<Frame> frames;
    private List<Integer> list = new ArrayList();
    private o reportController;
    private String unit_id;

    @Override // androidx.viewpager.widget.ViewPager.h
    public void onPageScrollStateChanged(int i11) {
    }

    @Override // androidx.viewpager.widget.ViewPager.h
    public void onPageScrolled(int i11, float f11, int i12) {
    }

    @Override // androidx.viewpager.widget.ViewPager.h
    public void onPageSelected(int i11) {
        reportRollBC(i11);
    }

    public void reportRollBC(int i11) {
        NativeListener.FilpListener filpListener = this.FilpListening;
        if (filpListener != null) {
            filpListener.filpEvent(i11);
        }
        if (this.list.contains(Integer.valueOf(i11))) {
            return;
        }
        this.list.add(Integer.valueOf(i11));
        Frame frame = this.frames.get(i11);
        List<CampaignEx> campaigns = frame.getCampaigns();
        if (campaigns == null || campaigns.isEmpty()) {
            return;
        }
        CampaignEx campaignEx = campaigns.get(0);
        StringBuilder sb2 = new StringBuilder();
        for (int i12 = 0; i12 < campaigns.size(); i12++) {
            campaignEx = campaigns.get(i12);
            if (i12 == campaigns.size() - 1) {
                sb2.append(campaignEx.getId());
            } else {
                sb2.append(campaignEx.getId() + ",");
            }
        }
        HashMap map = new HashMap();
        map.put("rid_n", campaignEx.getRequestId());
        map.put("frame_id", (i11 + 1) + "");
        map.put("template", Integer.valueOf(frame.getTemplate()));
        map.put("cids", sb2.toString());
        map.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.unit_id);
        String strA = q.a("2000005", map);
        if (j.a().b()) {
            j.a().a(strA);
        } else {
            this.reportController.a("native_rollbc", strA, this.unit_id, frame);
        }
    }

    public void setCampList(List<Frame> list, Context context, String str) {
        this.frames = list;
        this.reportController = new o(context, 2);
        this.unit_id = str;
        this.list.clear();
        reportRollBC(0);
    }

    public void setFilpListening(NativeListener.FilpListener filpListener) {
        this.FilpListening = filpListener;
    }
}
