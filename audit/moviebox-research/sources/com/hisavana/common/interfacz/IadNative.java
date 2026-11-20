package com.hisavana.common.interfacz;

import android.view.View;
import android.view.ViewGroup;
import com.hisavana.common.bean.AdNativeInfo;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public interface IadNative {
    void registerViewForInteraction(ViewGroup viewGroup, List<View> list, AdNativeInfo adNativeInfo);

    void unregisterView(AdNativeInfo adNativeInfo);
}
