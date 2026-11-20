package com.mbridge.msdk.dycreator.binding.response;

import com.mbridge.msdk.dycreator.binding.response.base.BaseRespData;
import com.mbridge.msdk.dycreator.f.a.a;
import com.mbridge.msdk.dycreator.listener.action.EAction;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class SplashResData extends BaseRespData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f43608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private EAction f43609b;

    public a getBaseViewData() {
        return this.f43608a;
    }

    public EAction geteAction() {
        return this.f43609b;
    }

    public void setBaseViewData(a aVar) {
        this.f43608a = aVar;
    }

    public void seteAction(EAction eAction) {
        this.f43609b = eAction;
    }
}
