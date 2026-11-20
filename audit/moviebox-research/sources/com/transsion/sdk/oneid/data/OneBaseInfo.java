package com.transsion.sdk.oneid.data;

import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.transsion.sdk.oneid.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class OneBaseInfo {
    @NonNull
    public String toString() {
        try {
            return new Gson().toJson(this);
        } catch (Exception e11) {
            f.f57417a.i(e11);
            return "";
        }
    }
}
