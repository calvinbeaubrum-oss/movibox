package com.vungle.warren.model;

import com.cloud.tmc.integration.permission.PermissionConstant;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("device")
    @Expose
    private u00.e f62165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName(PermissionConstant.ACTION_REQUEST)
    @Expose
    private u00.h f62166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("consent")
    @Expose
    private u00.c f62167c;

    public g(u00.e eVar, u00.h hVar, u00.c cVar) {
        this.f62165a = eVar;
        this.f62166b = hVar;
        this.f62167c = cVar;
    }
}
