package com.bytedance.adsdk.pFF.ExN;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class wjp implements pc<Integer> {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static final wjp f26099sc = new wjp();

    private wjp() {
    }

    @Override // com.bytedance.adsdk.pFF.ExN.pc
    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
    public Integer pFF(JsonReader jsonReader, float f11) throws IOException {
        return Integer.valueOf(Math.round(Sfl.pFF(jsonReader) * f11));
    }
}
