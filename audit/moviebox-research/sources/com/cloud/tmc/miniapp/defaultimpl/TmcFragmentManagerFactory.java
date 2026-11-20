package com.cloud.tmc.miniapp.defaultimpl;

import androidx.fragment.app.FragmentActivity;
import com.cloud.tmc.integration.proxy.IFragmentManagerFactory;
import com.cloud.tmc.integration.ui.fragment.a;
import com.cloud.tmc.miniapp.R$id;
import e0.g0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class TmcFragmentManagerFactory implements IFragmentManagerFactory {
    @Override // com.cloud.tmc.integration.proxy.IFragmentManagerFactory
    public a createFragmentManager(FragmentActivity activity) {
        Intrinsics.g(activity, "activity");
        return new g0(activity, R$id.main);
    }
}
