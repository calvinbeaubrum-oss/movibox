package com.bykv.vk.openvk.preload.geckox.a.a;

import android.annotation.SuppressLint;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"CI_StaticFieldLeak"})
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f25703a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f25704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected a f25705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected File f25706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected List<String> f25707e;

    static {
        new f();
        f25704b = new e();
    }

    public abstract void a();

    public void a(a aVar, File file, List<String> list) {
        this.f25705c = aVar;
        this.f25706d = file;
        this.f25707e = list;
    }
}
