package com.google.zxing;

import com.google.zxing.oned.Code128Writer;
import java.util.Map;
import qm.a0;
import qm.n;
import qm.t;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class g implements m {

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41528a;

        static {
            int[] iArr = new int[BarcodeFormat.values().length];
            f41528a = iArr;
            try {
                iArr[BarcodeFormat.EAN_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41528a[BarcodeFormat.UPC_E.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41528a[BarcodeFormat.EAN_13.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41528a[BarcodeFormat.UPC_A.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41528a[BarcodeFormat.QR_CODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41528a[BarcodeFormat.CODE_39.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41528a[BarcodeFormat.CODE_93.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f41528a[BarcodeFormat.CODE_128.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f41528a[BarcodeFormat.ITF.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f41528a[BarcodeFormat.PDF_417.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f41528a[BarcodeFormat.CODABAR.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f41528a[BarcodeFormat.DATA_MATRIX.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f41528a[BarcodeFormat.AZTEC.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    @Override // com.google.zxing.m
    public hm.b a(String str, BarcodeFormat barcodeFormat, int i11, int i12, Map<EncodeHintType, ?> map) throws WriterException {
        m kVar;
        switch (a.f41528a[barcodeFormat.ordinal()]) {
            case 1:
                kVar = new qm.k();
                break;
            case 2:
                kVar = new a0();
                break;
            case 3:
                kVar = new qm.i();
                break;
            case 4:
                kVar = new t();
                break;
            case 5:
                kVar = new zm.b();
                break;
            case 6:
                kVar = new qm.e();
                break;
            case 7:
                kVar = new qm.g();
                break;
            case 8:
                kVar = new Code128Writer();
                break;
            case 9:
                kVar = new n();
                break;
            case 10:
                kVar = new um.d();
                break;
            case 11:
                kVar = new qm.b();
                break;
            case 12:
                kVar = new km.b();
                break;
            case 13:
                kVar = new dm.c();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format " + barcodeFormat);
        }
        return kVar.a(str, barcodeFormat, i11, i12, map);
    }

    public hm.b b(String str, BarcodeFormat barcodeFormat, int i11, int i12) throws WriterException {
        return a(str, barcodeFormat, i11, i12, null);
    }
}
