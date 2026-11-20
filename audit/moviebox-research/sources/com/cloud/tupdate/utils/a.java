package com.cloud.tupdate.utils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a extends c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static a f32234f;

    public static synchronized a j() {
        try {
            if (f32234f == null) {
                synchronized (a.class) {
                    try {
                        if (f32234f == null) {
                            f32234f = new a();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            throw th3;
        }
        return f32234f;
    }

    @Override // com.cloud.tupdate.utils.c
    public String c() {
        return "UPDATE_SDK_S";
    }
}
