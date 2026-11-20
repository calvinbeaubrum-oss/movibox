package com.bytedance.adsdk.pFF.ExN;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Tf implements pc<Float> {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static final Tf f26092sc = new Tf();

    private Tf() {
    }

    @Override // com.bytedance.adsdk.pFF.ExN.pc
    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
    public Float pFF(JsonReader jsonReader, float f11) throws IOException {
        return Float.valueOf(Sfl.pFF(jsonReader) * f11);
    }
}
