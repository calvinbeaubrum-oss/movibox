package com.mbridge.msdk.dycreator.wrapper;

import android.view.View;
import com.mbridge.msdk.dycreator.b.a;
import com.mbridge.msdk.dycreator.binding.response.base.BaseRespData;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public interface DynamicViewBackListener {
    void viewClicked(BaseRespData baseRespData);

    void viewCreateFail(a aVar);

    void viewCreatedSuccess(View view);
}
