package com.bytedance.sdk.openadsdk.dE.zY;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final SharedPreferences f28613sc;

    public sc(Context context) {
        this.f28613sc = context.getSharedPreferences("pag_monitor_record", 0);
    }

    public long sc() {
        return this.f28613sc.getLong("last_upload_time", 0L);
    }

    public void sc(long j11) {
        SharedPreferences.Editor editorEdit = this.f28613sc.edit();
        editorEdit.putLong("last_upload_time", j11);
        editorEdit.apply();
    }
}
