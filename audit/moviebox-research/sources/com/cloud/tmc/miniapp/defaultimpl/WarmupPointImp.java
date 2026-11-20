package com.cloud.tmc.miniapp.defaultimpl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.EntryInfo;
import com.cloud.tmc.integration.model.PrepareData;
import com.cloud.tmc.integration.point.WarmupPoint;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.r;
import com.cloud.tmc.miniapp.proxy.IClientStarter;
import h.c;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import lb.g;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class WarmupPointImp implements WarmupPoint {

    /* JADX INFO: compiled from: source.java */
    public static final class a implements r {
        @Override // com.cloud.tmc.miniapp.prepare.steps.r
        public void a(String str) {
        }

        @Override // com.cloud.tmc.miniapp.prepare.steps.r
        public void b() {
        }

        @Override // com.cloud.tmc.miniapp.prepare.steps.r
        public void c() {
        }

        @Override // com.cloud.tmc.miniapp.prepare.steps.r
        public void d(String str, String str2) {
        }

        @Override // com.cloud.tmc.miniapp.prepare.steps.r
        public void e(AppModel appModelNew) {
            Intrinsics.g(appModelNew, "appModelNew");
        }

        @Override // com.cloud.tmc.miniapp.prepare.steps.r
        public void f(PrepareData prepareData, PrepareException prepareException) {
        }

        @Override // com.cloud.tmc.miniapp.prepare.steps.r
        public void g(AppModel appModelNew, boolean z11) {
            Intrinsics.g(appModelNew, "appModelNew");
        }

        @Override // com.cloud.tmc.miniapp.prepare.steps.r
        public void h(EntryInfo entryInfo) {
        }

        @Override // com.cloud.tmc.miniapp.prepare.steps.r
        public void i(LoadStepAction progress) {
            Intrinsics.g(progress, "progress");
        }

        @Override // com.cloud.tmc.miniapp.prepare.steps.r
        public void q(Intent intent) {
        }

        @Override // com.cloud.tmc.miniapp.prepare.steps.r
        public void y(Intent intent) {
        }

        @Override // com.cloud.tmc.miniapp.prepare.steps.r
        public void z(PrepareData prepareData, PrepareException prepareException) {
        }
    }

    @Override // com.cloud.tmc.integration.point.WarmupPoint, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.integration.point.WarmupPoint, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
    }

    @Override // com.cloud.tmc.integration.point.WarmupPoint
    public void start(Context context, int i11) {
        Intrinsics.g(context, "context");
        synchronized (context) {
            Bundle bundle = new Bundle();
            bundle.putInt("warmupType", i11);
            Unit unit = Unit.f68710a;
            g gVar = new g(context, "100000", bundle, new Bundle(), false, null, null, null, 240, null);
            PrepareController prepareControllerCreateWarmupController = ((IClientStarter) tc.a.a(IClientStarter.class)).createWarmupController(gVar, new c(gVar, new a()));
            if (prepareControllerCreateWarmupController != null) {
                prepareControllerCreateWarmupController.start();
            }
        }
    }
}
