package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.internal.api.AdComponentViewApi;
import com.facebook.ads.internal.api.AdOptionsViewApi;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class ZX extends C10725a implements AdOptionsViewApi {
    public static byte[] A03;
    public static final int A04;
    public static final int A05;
    public final ImageView A00;
    public final ImageView A01;
    public final AdOptionsView A02;

    static {
        A02();
        A04 = (int) (LD.A02 * 23.0f);
        A05 = (int) (LD.A02 * 4.0f);
    }

    public ZX(final Context context, NativeAdBase nativeAdBase, NativeAdLayout nativeAdLayout, AdOptionsView.Orientation orientation, int i11, AdOptionsView adOptionsView) {
        this.A02 = adOptionsView;
        final LinearLayout linearLayout = new LinearLayout(context);
        adOptionsView.addView(linearLayout);
        linearLayout.setOrientation(orientation == AdOptionsView.Orientation.HORIZONTAL ? 0 : 1);
        ImageView imageViewA00 = A00(EnumC1470Lw.DEFAULT_INFO_ICON);
        this.A01 = imageViewA00;
        ImageView imageViewA01 = A00(EnumC1470Lw.AD_CHOICES_ICON);
        this.A00 = imageViewA01;
        imageViewA01.setContentDescription(A01(0, 9, 116));
        linearLayout.addView(imageViewA00);
        linearLayout.addView(imageViewA01);
        setIconSizeDp(i11);
        setIconColor(-10459280);
        final V2 v2A0L = V2.A0L(nativeAdBase.getInternalNativeAd());
        v2A0L.A1S(nativeAdLayout);
        v2A0L.A1U(this);
        C1913bK c1913bKA0y = v2A0L.A0y();
        if (c1913bKA0y != null && c1913bKA0y.A0R() && !c1913bKA0y.A0P()) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.5N
                public static String[] A04 = {"KRKQmCMMKryGk4zgpNIytFvS3TD6bAeJ", "Xc6miAmzcu08Y", "37gtSV6CsPxBYDJYgwQ03wIm04Bn1UoS", "vc4nNQQkh46pzBlyEmkoOi4CgZODKTHg", "arJKEayC0J1tSfFqlaoS22WOKdh4xl60", "Efttk19GyNCXlxxyYR0mavkkkhSaw2Qp", "IGlWio493rL8eTjetjpBhFYcUhZqKyAr", ""};

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws Throwable {
                    if (KL.A02(this)) {
                        return;
                    }
                    try {
                        v2A0L.A1I();
                        if (Build.VERSION.SDK_INT < 16 || !C1384Ih.A23(context)) {
                            return;
                        }
                        linearLayout.performAccessibilityAction(128, null);
                    } catch (Throwable th2) {
                        if (A04[5].charAt(5) == 'z') {
                            throw new RuntimeException();
                        }
                        A04[6] = "upfEaDqgYzKFHRA83M0GBorRIFZJY191";
                        KL.A00(th2, this);
                    }
                }
            });
            LI.A04(adOptionsView, LI.A0B);
        }
    }

    public ZX(Context context, NativeAdBase nativeAdBase, NativeAdLayout nativeAdLayout, AdOptionsView adOptionsView) {
        this(context, nativeAdBase, nativeAdLayout, AdOptionsView.Orientation.HORIZONTAL, 23, adOptionsView);
    }

    private ImageView A00(EnumC1470Lw enumC1470Lw) {
        ImageView imageView = new ImageView(this.A02.getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        int i11 = A05;
        imageView.setPadding(i11, i11, i11, i11);
        imageView.setImageBitmap(AbstractC1471Lx.A01(enumC1470Lw));
        return imageView;
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 125);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{91, 108, 121, 102, 123, 125, 41, 72, 109};
    }

    public final void A03(EnumC1470Lw enumC1470Lw) {
        this.A01.setImageBitmap(AbstractC1471Lx.A01(enumC1470Lw));
    }

    @Override // com.facebook.ads.internal.api.AdComponentViewApiProvider
    public final AdComponentViewApi getAdComponentViewApi() {
        return this;
    }

    @Override // com.facebook.ads.internal.api.AdOptionsViewApi
    public final void setIconColor(int i11) {
        this.A01.setColorFilter(i11);
        this.A00.setColorFilter(i11);
    }

    @Override // com.facebook.ads.internal.api.AdOptionsViewApi
    public final void setIconSizeDp(int i11) {
        int iMax = Math.max(A04, (int) (LD.A02 * i11));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iMax, iMax);
        this.A01.setLayoutParams(layoutParams);
        this.A00.setLayoutParams(layoutParams);
    }

    @Override // com.facebook.ads.redexgen.uinode.C10725a, com.facebook.ads.internal.api.AdComponentView
    public final void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -2;
        layoutParams.height = -2;
        super.setLayoutParams(layoutParams);
    }

    @Override // com.facebook.ads.internal.api.AdOptionsViewApi
    public final void setSingleIcon(boolean z11) {
        AbstractC1462Lo.A0N(this.A01, z11 ? 8 : 0);
    }
}
