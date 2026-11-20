package com.bytedance.adsdk.ugeno.sc.pFF;

import android.animation.FloatEvaluator;
import android.animation.Keyframe;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.bytedance.adsdk.ugeno.qr.Qj;
import java.util.TreeMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF extends sc {

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.sc.pFF.pFF$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        static final /* synthetic */ int[] f26452sc;

        static {
            int[] iArr = new int[com.bytedance.adsdk.ugeno.sc.We.values().length];
            f26452sc = iArr;
            try {
                iArr[com.bytedance.adsdk.ugeno.sc.We.TRANSLATE_X.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26452sc[com.bytedance.adsdk.ugeno.sc.We.TRANSLATE_Y.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26452sc[com.bytedance.adsdk.ugeno.sc.We.SCALE_X.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f26452sc[com.bytedance.adsdk.ugeno.sc.We.SCALE_Y.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f26452sc[com.bytedance.adsdk.ugeno.sc.We.ROTATE_X.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f26452sc[com.bytedance.adsdk.ugeno.sc.We.ROTATE_Y.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f26452sc[com.bytedance.adsdk.ugeno.sc.We.ROTATE_Z.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f26452sc[com.bytedance.adsdk.ugeno.sc.We.ALPHA.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f26452sc[com.bytedance.adsdk.ugeno.sc.We.BORDER_RADIUS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public pFF(Context context, com.bytedance.adsdk.ugeno.pFF.zY zYVar, String str, TreeMap<Float, String> treeMap) {
        super(context, zYVar, str, treeMap);
    }

    @Override // com.bytedance.adsdk.ugeno.sc.pFF.sc
    public TypeEvaluator TRI() {
        return new FloatEvaluator();
    }

    @Override // com.bytedance.adsdk.ugeno.sc.pFF.sc
    public void pFF() {
        float fTf;
        switch (AnonymousClass1.f26452sc[this.We.ordinal()]) {
            case 1:
                fTf = this.f26453qr.Tf();
                break;
            case 2:
                fTf = this.f26453qr.Ql();
                break;
            case 3:
                fTf = this.f26453qr.SR();
                break;
            case 4:
                fTf = this.f26453qr.BT();
                break;
            case 5:
                fTf = this.f26453qr.dE();
                break;
            case 6:
                fTf = this.f26453qr.Xc();
                break;
            case 7:
                fTf = this.f26453qr.wjp();
                break;
            case 8:
                fTf = this.f26453qr.Sfl();
                break;
            case 9:
                fTf = this.f26453qr.YIK();
                break;
            default:
                fTf = 0.0f;
                break;
        }
        this.ExN.add(Keyframe.ofFloat(0.0f, fTf));
    }

    @Override // com.bytedance.adsdk.ugeno.sc.pFF.sc
    public void sc(float f11, String str) {
        this.ExN.add(Keyframe.ofFloat(f11, (this.pFF.startsWith(com.bytedance.adsdk.ugeno.sc.We.TRANSLATE.sc()) || this.We == com.bytedance.adsdk.ugeno.sc.We.BORDER_RADIUS) ? Qj.sc(this.f26454sc, com.bytedance.adsdk.ugeno.qr.zY.sc(str, 0.0f)) : com.bytedance.adsdk.ugeno.qr.zY.sc(str, 0.0f)));
    }
}
