package com.vungle.warren.persistence;

import android.util.Log;
import androidx.annotation.NonNull;
import com.vungle.warren.utility.i;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class f implements d, a.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f62325b = "f";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f62326a;

    public f(@NonNull a aVar) {
        this.f62326a = aVar;
        aVar.b(this);
        i.e(getCacheDirectory());
    }

    @Override // com.vungle.warren.persistence.d
    public void a() {
        a aVar = this.f62326a;
        if (aVar == null || aVar.g() == null) {
            return;
        }
        File file = new File(this.f62326a.g().getPath() + File.separator + "vungle");
        if (file.exists()) {
            try {
                i.b(file);
            } catch (IOException e11) {
                Log.e(f62325b, "Failed to delete cached files. Reason: " + e11.getLocalizedMessage());
            }
        }
        if (file.exists()) {
            return;
        }
        file.mkdir();
    }

    @Override // com.vungle.warren.persistence.a.c
    public void b() {
        a aVar = this.f62326a;
        if (aVar == null) {
            return;
        }
        Iterator<File> it = aVar.h().iterator();
        while (it.hasNext()) {
            try {
                i.b(new File(it.next().getPath() + File.separator + "vungle"));
            } catch (IOException e11) {
                Log.e(f62325b, "Failed to delete cached files. Reason: " + e11.getLocalizedMessage());
            }
        }
    }

    @Override // com.vungle.warren.persistence.d
    public File c(String str) throws IllegalStateException {
        File file = new File(getCacheDirectory().getPath() + File.separator + str);
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    @Override // com.vungle.warren.persistence.d
    public void d(String str) throws IllegalStateException, IOException {
        File[] fileArrListFiles = getCacheDirectory().listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (file.isDirectory() && file.getName().equals(str)) {
                i.b(file);
            }
        }
    }

    @Override // com.vungle.warren.persistence.d
    public File getCacheDirectory() throws IllegalStateException {
        if (this.f62326a == null) {
            throw new IllegalStateException("Context has expired, cannot continue.");
        }
        File file = new File(this.f62326a.g() + File.separator + "vungle");
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }
}
