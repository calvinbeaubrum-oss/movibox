package com.cloud.tmc.miniapp.prepare.steps;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.EntryInfo;
import com.cloud.tmc.integration.model.PrepareData;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface r {
    void a(String str);

    void b();

    void c();

    void d(@Nullable String str, @Nullable String str2);

    void e(@NonNull AppModel appModel);

    void f(PrepareData prepareData, PrepareException prepareException);

    void g(@NonNull AppModel appModel, boolean z11);

    void h(@Nullable EntryInfo entryInfo);

    void i(LoadStepAction loadStepAction);

    void q(Intent intent);

    void y(Intent intent);

    void z(PrepareData prepareData, PrepareException prepareException);
}
