package com.cloud.tmc.miniapp.ui;

import android.content.Intent;
import com.cloud.tmc.miniapp.base.BaseActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import ua.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements BaseActivity.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f31779a;

    public b(n nVar) {
        this.f31779a = nVar;
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity.a
    public void a(int i11, Intent intent) {
        n nVar = this.f31779a;
        if (nVar == null) {
            return;
        }
        if (intent == null) {
            nVar.onCancel();
            return;
        }
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("imageList");
        if (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) {
            this.f31779a.onCancel();
            return;
        }
        Iterator<String> it = stringArrayListExtra.iterator();
        Intrinsics.f(it, "list.iterator()");
        while (it.hasNext()) {
            if (!new File(it.next()).isFile()) {
                it.remove();
            }
        }
        if (i11 == -1 && (!stringArrayListExtra.isEmpty())) {
            this.f31779a.c(stringArrayListExtra);
        } else {
            this.f31779a.onCancel();
        }
    }
}
