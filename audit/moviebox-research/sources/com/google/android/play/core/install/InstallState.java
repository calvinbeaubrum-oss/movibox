package com.google.android.play.core.install;

import android.content.Intent;
import androidx.annotation.NonNull;
import cj.b;
import com.google.android.play.core.appupdate.internal.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class InstallState {
    public static InstallState f(@NonNull Intent intent, @NonNull s sVar) {
        sVar.a("List of extras in received intent needed by fromUpdateIntent:", new Object[0]);
        sVar.a("Key: %s; value: %s", "install.status", Integer.valueOf(intent.getIntExtra("install.status", 0)));
        sVar.a("Key: %s; value: %s", "error.code", Integer.valueOf(intent.getIntExtra("error.code", 0)));
        return new b(intent.getIntExtra("install.status", 0), intent.getLongExtra("bytes.downloaded", 0L), intent.getLongExtra("total.bytes.to.download", 0L), intent.getIntExtra("error.code", 0), intent.getStringExtra("package.name"));
    }

    public abstract long a();

    public abstract int b();

    public abstract int c();

    public abstract String d();

    public abstract long e();
}
