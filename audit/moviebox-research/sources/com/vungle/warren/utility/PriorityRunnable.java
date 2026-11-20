package com.vungle.warren.utility;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class PriorityRunnable implements Comparable, Runnable {
    @Override // java.lang.Comparable
    public int compareTo(@NonNull Object obj) {
        if (!(obj instanceof PriorityRunnable)) {
            return -1;
        }
        return ((PriorityRunnable) obj).getPriority().compareTo(getPriority());
    }

    public abstract Integer getPriority();
}
