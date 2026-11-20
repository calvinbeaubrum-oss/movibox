package com.transsion.banner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.locks.Lock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public b f50969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public b f50970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final WeakHandler$WeakRunnable f50971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public Lock f50972d;

    public WeakHandler$WeakRunnable a() {
        this.f50972d.lock();
        try {
            b bVar = this.f50970b;
            if (bVar != null) {
                bVar.f50969a = this.f50969a;
            }
            b bVar2 = this.f50969a;
            if (bVar2 != null) {
                bVar2.f50970b = bVar;
            }
            this.f50970b = null;
            this.f50969a = null;
            return this.f50971c;
        } finally {
            this.f50972d.unlock();
        }
    }
}
