package com.vungle.warren.downloader;

import androidx.annotation.NonNull;
import com.vungle.warren.utility.i;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class g implements c<File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.vungle.warren.persistence.a f62002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f62003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinkedHashSet<File> f62004c = new LinkedHashSet<>();

    public g(@NonNull com.vungle.warren.persistence.a aVar, @NonNull String str) {
        this.f62002a = aVar;
        this.f62003b = str;
    }

    @Override // com.vungle.warren.downloader.c
    public List<File> a() {
        return new ArrayList(this.f62004c);
    }

    public final File c() {
        File file = new File(this.f62002a.g(), this.f62003b);
        if (file.exists() && !file.isDirectory()) {
            i.c(file);
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, "cache_policy_journal");
    }

    @Override // com.vungle.warren.downloader.c
    public void d() throws Throwable {
        i.j(c(), this.f62004c);
    }

    @Override // com.vungle.warren.downloader.c
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void b(@NonNull File file, long j11) {
        if (j11 > 0) {
            this.f62004c.remove(file);
        }
        this.f62004c.add(file);
    }

    @Override // com.vungle.warren.downloader.c
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void remove(@NonNull File file) {
        this.f62004c.remove(file);
    }

    @Override // com.vungle.warren.downloader.c
    public void load() {
        File fileC = c();
        Serializable serializable = (Serializable) i.g(fileC);
        if (serializable == null) {
            return;
        }
        if (serializable instanceof Collection) {
            this.f62004c.addAll((Collection) serializable);
        } else {
            i.c(fileC);
        }
    }
}
