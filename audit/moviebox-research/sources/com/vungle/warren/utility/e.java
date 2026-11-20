package com.vungle.warren.utility;

import android.util.Log;
import androidx.annotation.NonNull;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f62596a = "e";

    public static Boolean a(@NonNull Repository repository, String str, String str2) {
        com.vungle.warren.model.j jVar = (com.vungle.warren.model.j) repository.T(str, com.vungle.warren.model.j.class).get();
        if (jVar != null) {
            return jVar.b(str2);
        }
        return null;
    }

    public static void b(@NonNull Repository repository, String str, String str2, Object obj) {
        com.vungle.warren.model.j jVar = (com.vungle.warren.model.j) repository.T(str, com.vungle.warren.model.j.class).get();
        if (jVar == null) {
            jVar = new com.vungle.warren.model.j(str);
        }
        jVar.e(str2, obj);
        try {
            repository.h0(jVar);
        } catch (DatabaseHelper.DBException e11) {
            Log.e(f62596a, "DB Exception saving cookie", e11);
        }
    }
}
