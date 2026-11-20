package com.hisavana.common.interfacz;

import android.content.Context;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public interface IadVideo {
    boolean isLoaded();

    void show(WeakReference<Context> weakReference, String str, String str2);
}
