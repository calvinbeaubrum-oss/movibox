package com.cloud.tmc.miniapp.prepare.steps;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.EntryInfo;
import com.cloud.tmc.integration.model.PrepareData;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface c0 {
    void OooO00o();

    void OooO00o(boolean z11);

    void a(String str);

    void b();

    void c(lb.f fVar, int i11);

    void d(@Nullable String str, @Nullable String str2);

    void e(@NonNull AppModel appModel);

    void f(PrepareData prepareData, PrepareException prepareException);

    void g(@NonNull AppModel appModel, boolean z11);

    void h(EntryInfo entryInfo);

    void i(LoadStepAction loadStepAction);

    void j(PrepareData prepareData, @Nullable AppModel appModel, @Nullable Bundle bundle, @Nullable Bundle bundle2);

    void k(lb.f fVar, PrepareController prepareController);

    void l(lb.f fVar, PrepareController prepareController);
}
