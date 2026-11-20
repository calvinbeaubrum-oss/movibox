package com.cloud.tmc.miniapp.proxy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.steps.c0;
import lb.g;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface IClientStarter {
    Fragment createFragment(Context context, Bundle bundle);

    PrepareController createPrepareController(g gVar, c0 c0Var);

    PrepareController createQuickModePrepareController(g gVar, c0 c0Var);

    PrepareController createSubpackagePrepareController(g gVar, c0 c0Var, int i11, String str);

    PrepareController createWarmupController(g gVar, c0 c0Var);

    Class<? extends Activity> startClient(Context context, Intent intent, Bundle bundle);
}
