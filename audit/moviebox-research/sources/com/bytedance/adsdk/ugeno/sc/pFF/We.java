package com.bytedance.adsdk.ugeno.sc.pFF;

import android.animation.FloatEvaluator;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.qr.Qj;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We extends sc {
    private List<Keyframe> Qj;

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.sc.pFF.We$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        static final /* synthetic */ int[] f26451sc;

        static {
            int[] iArr = new int[com.bytedance.adsdk.ugeno.sc.We.values().length];
            f26451sc = iArr;
            try {
                iArr[com.bytedance.adsdk.ugeno.sc.We.TRANSLATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26451sc[com.bytedance.adsdk.ugeno.sc.We.SCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public We(Context context, com.bytedance.adsdk.ugeno.pFF.zY zYVar, String str, Map<Float, String> map) {
        super(context, zYVar, str, map);
        this.Qj = new ArrayList();
    }

    @Override // com.bytedance.adsdk.ugeno.sc.pFF.sc
    public List<PropertyValuesHolder> ExN() {
        String strPFF = this.We.pFF();
        We();
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(strPFF + "X", (Keyframe[]) this.ExN.toArray(new Keyframe[0]));
        this.TRI.add(propertyValuesHolderOfKeyframe);
        PropertyValuesHolder propertyValuesHolderOfKeyframe2 = PropertyValuesHolder.ofKeyframe(strPFF + "Y", (Keyframe[]) this.Qj.toArray(new Keyframe[0]));
        this.TRI.add(propertyValuesHolderOfKeyframe2);
        TypeEvaluator typeEvaluatorTRI = TRI();
        if (typeEvaluatorTRI != null) {
            propertyValuesHolderOfKeyframe.setEvaluator(typeEvaluatorTRI);
            propertyValuesHolderOfKeyframe2.setEvaluator(typeEvaluatorTRI);
        }
        return this.TRI;
    }

    @Override // com.bytedance.adsdk.ugeno.sc.pFF.sc
    public TypeEvaluator TRI() {
        return new FloatEvaluator();
    }

    @Override // com.bytedance.adsdk.ugeno.sc.pFF.sc
    public void pFF() {
        Keyframe keyframeOfFloat;
        Keyframe keyframeOfFloat2;
        int i11 = AnonymousClass1.f26451sc[this.We.ordinal()];
        if (i11 == 1) {
            keyframeOfFloat = Keyframe.ofFloat(0.0f, this.f26453qr.Tf());
            keyframeOfFloat2 = Keyframe.ofFloat(0.0f, this.f26453qr.Ql());
        } else if (i11 != 2) {
            keyframeOfFloat = null;
            keyframeOfFloat2 = null;
        } else {
            keyframeOfFloat = Keyframe.ofFloat(0.0f, this.f26453qr.SR());
            keyframeOfFloat2 = Keyframe.ofFloat(0.0f, this.f26453qr.BT());
        }
        if (keyframeOfFloat != null) {
            this.ExN.add(keyframeOfFloat);
        }
        if (keyframeOfFloat2 != null) {
            this.Qj.add(keyframeOfFloat2);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.sc.pFF.sc
    public void sc(float f11, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() != 2) {
                return;
            }
            float fOptDouble = (float) jSONArray.optDouble(0);
            float fOptDouble2 = (float) jSONArray.optDouble(1);
            if (this.We == com.bytedance.adsdk.ugeno.sc.We.TRANSLATE) {
                fOptDouble = Qj.sc(this.f26454sc, fOptDouble);
                fOptDouble2 = Qj.sc(this.f26454sc, fOptDouble2);
            }
            this.ExN.add(Keyframe.ofFloat(f11, fOptDouble));
            this.Qj.add(Keyframe.ofFloat(f11, fOptDouble2));
        } catch (JSONException unused) {
        }
    }
}
