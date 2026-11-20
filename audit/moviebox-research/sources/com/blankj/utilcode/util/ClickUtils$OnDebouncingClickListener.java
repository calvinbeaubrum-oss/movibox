package com.blankj.utilcode.util;

import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ClickUtils$OnDebouncingClickListener implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f25224a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Runnable f25225b = new Runnable() { // from class: com.blankj.utilcode.util.ClickUtils$OnDebouncingClickListener.1
        @Override // java.lang.Runnable
        public void run() {
            boolean unused = ClickUtils$OnDebouncingClickListener.f25224a = true;
        }
    };
}
