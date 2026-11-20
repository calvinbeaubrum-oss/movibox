package com.bytedance.adsdk.ugeno.sc.pFF;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class sc {
    protected com.bytedance.adsdk.ugeno.sc.We We;
    protected String pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    protected com.bytedance.adsdk.ugeno.pFF.zY f26453qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected Context f26454sc;
    protected Map<Float, String> zY;
    protected List<PropertyValuesHolder> TRI = new ArrayList();
    protected List<Keyframe> ExN = new ArrayList();

    public sc(Context context, com.bytedance.adsdk.ugeno.pFF.zY zYVar, String str, Map<Float, String> map) {
        this.f26454sc = context;
        this.pFF = str;
        this.zY = map;
        this.We = com.bytedance.adsdk.ugeno.sc.We.sc(this.pFF);
        this.f26453qr = zYVar;
    }

    public List<PropertyValuesHolder> ExN() {
        String strPFF = this.We.pFF();
        We();
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(strPFF, (Keyframe[]) this.ExN.toArray(new Keyframe[0]));
        TypeEvaluator typeEvaluatorTRI = TRI();
        if (typeEvaluatorTRI != null) {
            propertyValuesHolderOfKeyframe.setEvaluator(typeEvaluatorTRI);
        }
        this.TRI.add(propertyValuesHolderOfKeyframe);
        return this.TRI;
    }

    public abstract TypeEvaluator TRI();

    public void We() {
        Map<Float, String> map = this.zY;
        if (map == null || map.size() <= 0) {
            return;
        }
        if (!sc()) {
            pFF();
        }
        for (Map.Entry<Float, String> entry : this.zY.entrySet()) {
            if (entry != null) {
                sc(entry.getKey().floatValue() / 100.0f, entry.getValue());
            }
        }
        zY();
    }

    public abstract void pFF();

    public abstract void sc(float f11, String str);

    public boolean sc() {
        Map<Float, String> map = this.zY;
        if (map == null || map.size() <= 0) {
            return false;
        }
        return this.zY.containsKey(Float.valueOf(0.0f));
    }

    public void zY() {
        Map<Float, String> map = this.zY;
        if (map == null || map.size() <= 0) {
            return;
        }
        Map<Float, String> map2 = this.zY;
        if (map2 instanceof TreeMap) {
            float fFloatValue = ((Float) ((TreeMap) map2).lastKey()).floatValue();
            if (fFloatValue != 100.0f) {
                sc(100.0f, this.zY.get(Float.valueOf(fFloatValue)));
            }
        }
    }
}
