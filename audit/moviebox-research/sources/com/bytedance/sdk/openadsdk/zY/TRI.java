package com.bytedance.sdk.openadsdk.zY;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.utils.kX;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TRI extends ScrollView {
    private final com.bytedance.sdk.openadsdk.core.ExN.ExN pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final WH f28807sc;

    public TRI(Context context, WH wh2) {
        super(context);
        this.f28807sc = wh2;
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        this.pFF = exN;
        exN.setOrientation(1);
        addView(exN, new FrameLayout.LayoutParams(-1, -2));
        if (wh2.Qj() == 0) {
            sc();
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        setLayoutParams(layoutParams);
        setVerticalScrollBarEnabled(false);
    }

    private void pFF(List<FilterWord> list) {
        this.pFF.removeAllViews();
        for (int i11 = 0; i11 < list.size(); i11++) {
            FilterWord filterWord = list.get(i11);
            if (filterWord != null) {
                this.pFF.addView(new qr(getContext(), filterWord, this.f28807sc));
            }
            if (i11 < list.size() - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                int iZY = kX.zY(getContext(), this.f28807sc.Ol() ? 16.0f : 8.0f);
                layoutParams.topMargin = iZY;
                layoutParams.bottomMargin = iZY;
                this.pFF.addView(new UFX(getContext()), layoutParams);
            }
        }
    }

    private void sc() {
        if (this.f28807sc.Qj() != 0) {
            return;
        }
        this.f28807sc.sc(kX.zY(getContext()), kX.We(getContext()));
    }

    private static List<FilterWord> zY(List<FilterWord> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int i11 = 0;
        int i12 = -1;
        for (int i13 = 0; i13 < list.size(); i13++) {
            if (list.get(i13).hasSecondOptions()) {
                i12 = i13;
            }
        }
        if (i12 != -1 && i12 <= list.size()) {
            i11 = i12;
        }
        FilterWord filterWord = list.get(i11);
        Iterator<FilterWord> it = list.iterator();
        while (it.hasNext()) {
            FilterWord next = it.next();
            if (!next.hasSecondOptions()) {
                filterWord.addOption(next);
                it.remove();
            }
        }
        return list;
    }

    public void sc(List<FilterWord> list) {
        List<FilterWord> listZY = zY(list);
        if (listZY == null) {
            return;
        }
        pFF(listZY);
    }
}
