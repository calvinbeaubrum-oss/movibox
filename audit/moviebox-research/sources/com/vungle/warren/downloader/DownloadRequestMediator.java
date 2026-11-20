package com.vungle.warren.downloader;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Keep
class DownloadRequestMediator {
    public final String filePath;
    public final boolean isCacheable;
    public final String key;
    public final String metaPath;
    public final b priority;
    public final String url;
    private AtomicInteger statusAtomic = new AtomicInteger(0);
    private Map<String, androidx.core.util.e<e, a>> children = new ConcurrentHashMap(1);
    private final ReentrantLock lock = new ReentrantLock();
    private AtomicBoolean connectedAtomic = new AtomicBoolean(true);
    private AtomicReference<Runnable> runnable = new AtomicReference<>();

    public DownloadRequestMediator(@NonNull e eVar, @Nullable a aVar, @NonNull String str, @NonNull String str2, boolean z11, String str3) {
        this.url = eVar.f61994b;
        this.filePath = str;
        this.metaPath = str2;
        this.isCacheable = z11;
        this.key = str3;
        this.priority = eVar.c();
        this.children.put(eVar.f61998f, new androidx.core.util.e<>(eVar, aVar));
    }

    public synchronized void add(e eVar, a aVar) {
        this.children.put(eVar.f61998f, new androidx.core.util.e<>(eVar, aVar));
    }

    public b getPriority() {
        b bVarC;
        b bVar = new b(Api.BaseClientBuilder.API_PRIORITY_OTHER, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        Iterator<androidx.core.util.e<e, a>> it = values().iterator();
        while (it.hasNext()) {
            e eVar = it.next().f7889a;
            if (eVar != null && (bVarC = eVar.c()) != null && bVar.compareTo(bVarC) >= 0) {
                bVar = bVarC;
            }
        }
        return bVar;
    }

    public Runnable getRunnable() {
        return this.runnable.get();
    }

    @Status
    public int getStatus() {
        return this.statusAtomic.get();
    }

    public boolean is(@Status int i11) {
        return this.statusAtomic.get() == i11;
    }

    public boolean isConnected() {
        return this.connectedAtomic.get();
    }

    public boolean isPausable() {
        Iterator<androidx.core.util.e<e, a>> it = values().iterator();
        while (it.hasNext()) {
            e eVar = it.next().f7889a;
            if (eVar != null && eVar.f61996d) {
                return true;
            }
        }
        return false;
    }

    public void lock() {
        this.lock.lock();
    }

    public synchronized androidx.core.util.e<e, a> remove(e eVar) {
        return this.children.remove(eVar.f61998f);
    }

    public synchronized List<e> requests() {
        ArrayList arrayList;
        List<androidx.core.util.e<e, a>> listValues = values();
        arrayList = new ArrayList();
        Iterator<androidx.core.util.e<e, a>> it = listValues.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().f7889a);
        }
        return arrayList;
    }

    public void set(@Status int i11) {
        if (this.statusAtomic.get() == 3) {
            return;
        }
        this.statusAtomic.set(i11);
    }

    public void setConnected(boolean z11) {
        this.connectedAtomic.set(z11);
    }

    public void setRunnable(Runnable runnable) {
        this.runnable.set(runnable);
    }

    public void unlock() {
        this.lock.unlock();
    }

    public synchronized List<androidx.core.util.e<e, a>> values() {
        return new ArrayList(this.children.values());
    }
}
