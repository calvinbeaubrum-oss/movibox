package com.bytedance.adsdk.ugeno.sc.pFF;

import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.Keyframe;
import android.animation.TypeEvaluator;
import android.content.Context;
import java.util.TreeMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY extends sc {
    public zY(Context context, com.bytedance.adsdk.ugeno.pFF.zY zYVar, String str, TreeMap<Float, String> treeMap) {
        super(context, zYVar, str, treeMap);
    }

    @Override // com.bytedance.adsdk.ugeno.sc.pFF.sc
    public TypeEvaluator TRI() {
        return this.We == com.bytedance.adsdk.ugeno.sc.We.BACKGROUND_COLOR ? new ArgbEvaluator() : new IntEvaluator();
    }

    @Override // com.bytedance.adsdk.ugeno.sc.pFF.sc
    public void pFF() {
        if (this.We == com.bytedance.adsdk.ugeno.sc.We.BACKGROUND_COLOR) {
            this.ExN.add(Keyframe.ofInt(0.0f, this.f26453qr.kX()));
        }
    }

    @Override // com.bytedance.adsdk.ugeno.sc.pFF.sc
    public void sc(float f11, String str) {
        this.ExN.add(this.We == com.bytedance.adsdk.ugeno.sc.We.BACKGROUND_COLOR ? Keyframe.ofInt(f11, com.bytedance.adsdk.ugeno.qr.sc.sc(str)) : Keyframe.ofInt(f11, com.bytedance.adsdk.ugeno.qr.zY.sc(str, 0)));
    }
}
