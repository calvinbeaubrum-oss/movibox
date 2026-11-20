package com.mbridge.msdk.dycreator.binding.base;

import com.mbridge.msdk.dycreator.f.a.a;
import com.mbridge.msdk.dycreator.listener.action.EAction;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class ActionData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f43605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private EAction f43606b;

    public a getBaseViewData() {
        return this.f43605a;
    }

    public EAction geteAction() {
        return this.f43606b;
    }

    public void setBaseViewData(a aVar) {
        this.f43605a = aVar;
    }

    public void seteAction(EAction eAction) {
        this.f43606b = eAction;
    }
}
