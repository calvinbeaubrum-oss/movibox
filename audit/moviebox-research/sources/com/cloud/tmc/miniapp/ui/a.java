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
public final class a implements BaseActivity.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f31761a;

    public a(n nVar) {
        this.f31761a = nVar;
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity.a
    public void a(int i11, Intent intent) {
        n nVar = this.f31761a;
        if (nVar == null) {
            return;
        }
        if (intent == null) {
            nVar.onCancel();
            return;
        }
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("imageSelectList");
        boolean booleanExtra = intent.getBooleanExtra("imageBackPressed", false);
        ArrayList<Integer> integerArrayListExtra = intent.getIntegerArrayListExtra("imageSelectPositionList");
        if (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) {
            this.f31761a.onCancel();
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
            this.f31761a.d(stringArrayListExtra, integerArrayListExtra, !booleanExtra);
        } else {
            this.f31761a.onCancel();
        }
    }
}
