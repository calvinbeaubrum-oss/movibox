package com.facebook.ads.redexgen.uinode;

import android.view.View;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class QJ extends RelativeLayout {
    public static String[] A03 = {"Z7YDROQZDOzGgLZ6JRzm0VB6SZj4zDor", "PEDxZ1hmcJv2HtokqPZuboN03zqPqfuu", "ZN3aiXgGzfL", "UoQOzdqMFdmvRVk6jZTbQbhJ01APWmUd", "BWydKlRDXGFiivyHlYlBLR13h8bygoZy", "calSGpe10AH6YV6oPZJsWkhcYoOFDSm8", "CqyCvSup05V", "6oqVw1T1HmkJfSZKyFG8rr7XXeYSScI0"};
    public C7R A00;
    public WeakReference<QI> A01;
    public final R9 A02;

    /* JADX WARN: Multi-variable type inference failed */
    public QJ(C1795Yn c1795Yn, R9 r11) {
        super(c1795Yn);
        this.A02 = r11;
        AbstractC1462Lo.A0J((View) r11);
        addView(r11.getView(), new RelativeLayout.LayoutParams(-1, -1));
    }

    public final void A00(QQ qq2) {
        addView(qq2, new RelativeLayout.LayoutParams(-1, -1));
        this.A00 = (C7R) qq2;
    }

    public final void A01(QQ qq2) {
        AbstractC1462Lo.A0J(qq2);
        this.A00 = null;
    }

    public final boolean A02() {
        return this.A02.A8c();
    }

    public int getCurrentPosition() {
        return this.A02.getCurrentPosition();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        ((View) this.A02).layout(0, 0, getWidth(), getHeight());
        C7R c7r = this.A00;
        if (c7r != null) {
            c7r.layout(0, 0, getWidth(), getHeight());
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x00e4  */
    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int i11, int i12) {
        boolean z11 = false;
        int videoWidth = this.A02.getVideoWidth();
        int videoHeight = this.A02.getVideoHeight();
        int defaultSize = getDefaultSize(videoWidth, i11);
        int defaultSize2 = getDefaultSize(videoHeight, i12);
        if (videoWidth > 0 && videoHeight > 0) {
            z11 = true;
            int mode = View.MeasureSpec.getMode(i11);
            String[] strArr = A03;
            if (strArr[5].charAt(24) == strArr[4].charAt(24)) {
                throw new RuntimeException();
            }
            A03[1] = "CDDJeYuNvDEJubiWpvjZnzRFdpaPIWUA";
            int size = View.MeasureSpec.getSize(i11);
            int mode2 = View.MeasureSpec.getMode(i12);
            int size2 = View.MeasureSpec.getSize(i12);
            if (mode == 1073741824 && mode2 == 1073741824) {
                defaultSize = size;
                defaultSize2 = size2;
                if (videoWidth * defaultSize2 < defaultSize * videoHeight) {
                    defaultSize = (defaultSize2 * videoWidth) / videoHeight;
                } else {
                    int i13 = videoWidth * defaultSize2;
                    int i14 = defaultSize * videoHeight;
                    if (A03[3].charAt(9) != 'h') {
                        A03[3] = "fC7LLJ1Dm89Wzyv9Y7CU7RKyEHK0kUw2";
                        if (i13 > i14) {
                            defaultSize2 = (defaultSize * videoHeight) / videoWidth;
                        }
                    } else if (i13 > i14) {
                        defaultSize2 = (defaultSize * videoHeight) / videoWidth;
                    }
                }
            } else if (mode == 1073741824) {
                defaultSize = size;
                defaultSize2 = (defaultSize * videoHeight) / videoWidth;
                if (mode2 == Integer.MIN_VALUE && defaultSize2 > size2) {
                    defaultSize2 = size2;
                }
            } else if (mode2 == 1073741824) {
                defaultSize2 = size2;
                defaultSize = (defaultSize2 * videoWidth) / videoHeight;
                String[] strArr2 = A03;
                if (strArr2[7].charAt(1) != strArr2[0].charAt(1)) {
                    String[] strArr3 = A03;
                    strArr3[7] = "6OY3VkVRTo9gTvB5T4EFQBtDC7FaIDf0";
                    strArr3[0] = "lXHmnICBdoyL7DjWTMRRGmshSxtLnfI6";
                    if (mode == Integer.MIN_VALUE) {
                        if (defaultSize > size) {
                            defaultSize = size;
                        }
                    }
                } else if (mode == Integer.MIN_VALUE) {
                    if (defaultSize > size) {
                        defaultSize = size;
                    }
                }
            } else {
                defaultSize = videoWidth;
                defaultSize2 = videoHeight;
                if (mode2 == Integer.MIN_VALUE && defaultSize2 > size2) {
                    defaultSize2 = size2;
                    defaultSize = (defaultSize2 * videoWidth) / videoHeight;
                }
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize = size;
                    defaultSize2 = (defaultSize * videoHeight) / videoWidth;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
        if (A03[3].charAt(9) != 'h') {
            A03[1] = "jUvlMuc6V7f2FSIr4bukaecFyxTPY1HC";
            if (!z11) {
                return;
            }
        } else if (!z11) {
            return;
        }
        WeakReference<QI> weakReference = this.A01;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.A01.get().ADZ();
    }

    public void setViewImplInflationListener(QI qi2) {
        this.A01 = new WeakReference<>(qi2);
    }
}
