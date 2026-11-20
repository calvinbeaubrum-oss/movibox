package com.transsion.sdk.oneid;

import android.os.Environment;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String a() {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + Environment.DIRECTORY_DOCUMENTS + "/.sys_id.dat";
    }
}
