package com.facebook.ads.redexgen.uinode;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ee, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1281Ee extends AbstractC1808Za {
    public static TimeInterpolator A0B;
    public static String[] A0C = {"K3xavpXOVVnTPS8V8FmisIpuez1NdmFn", "QjoCrUVtXYT15qNhmppxWCsnlOvXMRWn", "HVYav4KnfeU3lAWSFDiSVAYelCZD7hW1", "SKhwmHHGUoQzTLK2kw5WKB1efbL3jYLm", "aZpNXGptJoOcjVlsPlgA0RFw1bcc4fI1", "y8DDj9eTKGlZyxtiH83YwnquX80t2qUq", "Eqht3urb", "PkOCx2w9GPXTa0iGANdHxOJetOGxrMw0"};
    public ArrayList<AnonymousClass56> A0A = new ArrayList<>();
    public ArrayList<AnonymousClass56> A07 = new ArrayList<>();
    public ArrayList<C4M> A09 = new ArrayList<>();
    public ArrayList<C4L> A08 = new ArrayList<>();
    public ArrayList<ArrayList<AnonymousClass56>> A01 = new ArrayList<>();
    public ArrayList<ArrayList<C4M>> A05 = new ArrayList<>();
    public ArrayList<ArrayList<C4L>> A03 = new ArrayList<>();
    public ArrayList<AnonymousClass56> A00 = new ArrayList<>();
    public ArrayList<AnonymousClass56> A04 = new ArrayList<>();
    public ArrayList<AnonymousClass56> A06 = new ArrayList<>();
    public ArrayList<AnonymousClass56> A02 = new ArrayList<>();

    private void A01(C4L c4l) {
        if (c4l.A05 != null) {
            A07(c4l, c4l.A05);
        }
        if (c4l.A04 != null) {
            A07(c4l, c4l.A04);
        }
    }

    private void A03(final AnonymousClass56 anonymousClass56) {
        final View view = anonymousClass56.A0H;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.A06.add(anonymousClass56);
        viewPropertyAnimatorAnimate.setDuration(A07()).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.facebook.ads.redexgen.X.4G
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                view.setAlpha(1.0f);
                this.A02.A0P(anonymousClass56);
                this.A02.A06.remove(anonymousClass56);
                this.A02.A0V();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
            }
        }).start();
    }

    private void A04(AnonymousClass56 anonymousClass56) {
        if (A0B == null) {
            A0B = new ValueAnimator().getInterpolator();
        }
        anonymousClass56.A0H.animate().setInterpolator(A0B);
        A0K(anonymousClass56);
    }

    private final void A05(List<AnonymousClass56> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).A0H.animate().cancel();
        }
    }

    private void A06(List<C4L> list, AnonymousClass56 anonymousClass56) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C4L c4l = list.get(size);
            if (A07(c4l, anonymousClass56) && c4l.A05 == null && c4l.A04 == null) {
                list.remove(c4l);
            }
        }
    }

    private boolean A07(C4L c4l, AnonymousClass56 anonymousClass56) {
        boolean z11 = false;
        if (c4l.A04 == anonymousClass56) {
            c4l.A04 = null;
        } else {
            if (c4l.A05 != anonymousClass56) {
                return false;
            }
            c4l.A05 = null;
            z11 = true;
        }
        anonymousClass56.A0H.setAlpha(1.0f);
        anonymousClass56.A0H.setTranslationX(0.0f);
        anonymousClass56.A0H.setTranslationY(0.0f);
        A0Q(anonymousClass56, z11);
        return true;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10574k
    public final void A0I() {
        for (int size = this.A09.size() - 1; size >= 0; size--) {
            C4M c4m = this.A09.get(size);
            View view = c4m.A04.A0H;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            A0O(c4m.A04);
            this.A09.remove(size);
        }
        for (int size2 = this.A0A.size() - 1; size2 >= 0; size2--) {
            A0P(this.A0A.get(size2));
            this.A0A.remove(size2);
        }
        for (int size3 = this.A07.size() - 1; size3 >= 0; size3--) {
            AnonymousClass56 anonymousClass56 = this.A07.get(size3);
            anonymousClass56.A0H.setAlpha(1.0f);
            A0N(anonymousClass56);
            this.A07.remove(size3);
        }
        for (int size4 = this.A08.size() - 1; size4 >= 0; size4--) {
            A01(this.A08.get(size4));
        }
        this.A08.clear();
        if (A0L()) {
            for (int size5 = this.A05.size() - 1; size5 >= 0; size5--) {
                ArrayList<C4M> arrayList = this.A05.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    C4M c4m2 = arrayList.get(size6);
                    View view2 = c4m2.A04.A0H;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    A0O(c4m2.A04);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.A05.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.A01.size() - 1; size7 >= 0; size7--) {
                ArrayList<AnonymousClass56> arrayList2 = this.A01.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    AnonymousClass56 anonymousClass57 = arrayList2.get(size8);
                    anonymousClass57.A0H.setAlpha(1.0f);
                    A0N(anonymousClass57);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.A01.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.A03.size() - 1; size9 >= 0; size9--) {
                ArrayList<C4L> arrayList3 = this.A03.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    A01(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.A03.remove(arrayList3);
                    }
                }
            }
            A05(this.A06);
            A05(this.A04);
            A05(this.A00);
            A05(this.A02);
            A0A();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10574k
    public final void A0J() {
        boolean z11 = !this.A0A.isEmpty();
        boolean z12 = !this.A09.isEmpty();
        boolean z13 = !this.A08.isEmpty();
        boolean z14 = !this.A07.isEmpty();
        if (z11 || z12 || z14 || z13) {
            Iterator<AnonymousClass56> it = this.A0A.iterator();
            while (it.hasNext()) {
                A03(it.next());
            }
            this.A0A.clear();
            if (z12) {
                final ArrayList<C4M> arrayList = new ArrayList<>();
                arrayList.addAll(this.A09);
                this.A05.add(arrayList);
                this.A09.clear();
                Runnable runnable = new Runnable() { // from class: com.facebook.ads.redexgen.X.4D
                    @Override // java.lang.Runnable
                    public final void run() {
                        for (C4M c4m : arrayList) {
                            this.A00.A0Y(c4m.A04, c4m.A00, c4m.A01, c4m.A02, c4m.A03);
                        }
                        arrayList.clear();
                        this.A00.A05.remove(arrayList);
                    }
                };
                if (z11) {
                    C3T.A0E(arrayList.get(0).A04.A0H, runnable, A07());
                } else {
                    runnable.run();
                }
            }
            if (z13) {
                final ArrayList<C4L> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.A08);
                this.A03.add(arrayList2);
                this.A08.clear();
                Runnable runnable2 = new Runnable() { // from class: com.facebook.ads.redexgen.X.4E
                    @Override // java.lang.Runnable
                    public final void run() {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            this.A00.A0W((C4L) it2.next());
                        }
                        arrayList2.clear();
                        this.A00.A03.remove(arrayList2);
                    }
                };
                if (z11) {
                    C3T.A0E(arrayList2.get(0).A05.A0H, runnable2, A07());
                } else {
                    runnable2.run();
                }
            }
            if (z14) {
                final ArrayList<AnonymousClass56> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.A07);
                this.A01.add(arrayList3);
                this.A07.clear();
                Runnable runnable3 = new Runnable() { // from class: com.facebook.ads.redexgen.X.4F
                    @Override // java.lang.Runnable
                    public final void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            this.A00.A0X((AnonymousClass56) it2.next());
                        }
                        arrayList3.clear();
                        this.A00.A01.remove(arrayList3);
                    }
                };
                if (!z11 && !z12 && !z13) {
                    runnable3.run();
                    return;
                }
                if (A0C[0].charAt(3) == 'S') {
                    throw new RuntimeException();
                }
                String[] strArr = A0C;
                strArr[4] = "oGS3g0YSOogxL8fDiPQ9wWzcLRV8E0qu";
                strArr[3] = "UwBhVdK7HoWqzQqehBBKiWd5H5AJwN9O";
                C3T.A0E(arrayList3.get(0).A0H, runnable3, Math.max(z12 ? A06() : 0L, z13 ? A05() : 0L) + (z11 ? A07() : 0L));
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10574k
    public final void A0K(AnonymousClass56 anonymousClass56) {
        View view = anonymousClass56.A0H;
        view.animate().cancel();
        for (int size = this.A09.size() - 1; size >= 0; size--) {
            if (this.A09.get(size).A04 == anonymousClass56) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                A0O(anonymousClass56);
                this.A09.remove(size);
            }
        }
        A06(this.A08, anonymousClass56);
        if (this.A0A.remove(anonymousClass56)) {
            view.setAlpha(1.0f);
            A0P(anonymousClass56);
        }
        if (this.A07.remove(anonymousClass56)) {
            view.setAlpha(1.0f);
            A0N(anonymousClass56);
        }
        for (int size2 = this.A03.size() - 1; size2 >= 0; size2--) {
            ArrayList<C4L> arrayList = this.A03.get(size2);
            A06(arrayList, anonymousClass56);
            if (arrayList.isEmpty()) {
                this.A03.remove(size2);
            }
        }
        for (int size3 = this.A05.size() - 1; size3 >= 0; size3--) {
            ArrayList<C4M> arrayList2 = this.A05.get(size3);
            for (int size4 = arrayList2.size() - 1; size4 >= 0; size4--) {
                if (arrayList2.get(size4).A04 == anonymousClass56) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    String[] strArr = A0C;
                    if (strArr[4].charAt(9) == strArr[3].charAt(9)) {
                        A0C[1] = "ZnQkkSK02m4qlFQsfXGc8k1uWyp7aRL1";
                        A0O(anonymousClass56);
                        arrayList2.remove(size4);
                        if (!arrayList2.isEmpty()) {
                            break;
                        }
                        this.A05.remove(size3);
                        break;
                    }
                    throw new RuntimeException();
                }
            }
        }
        int size5 = this.A01.size();
        if (A0C[0].charAt(3) == 'S') {
            throw new RuntimeException();
        }
        A0C[7] = "NHib0yCpDtVNZGbvtAXjIsv6RzrfBwwf";
        for (int i11 = size5 - 1; i11 >= 0; i11--) {
            ArrayList<AnonymousClass56> arrayList3 = this.A01.get(i11);
            if (arrayList3.remove(anonymousClass56)) {
                view.setAlpha(1.0f);
                A0N(anonymousClass56);
                if (arrayList3.isEmpty()) {
                    this.A01.remove(i11);
                }
            }
        }
        this.A06.remove(anonymousClass56);
        this.A00.remove(anonymousClass56);
        this.A02.remove(anonymousClass56);
        this.A04.remove(anonymousClass56);
        A0V();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0073  */
    /* JADX WARN: Code duplicated, block: B:28:0x009c  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:38:0x00ba A[RETURN, SYNTHETIC] */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC10574k
    public final boolean A0L() {
        ArrayList<ArrayList<C4L>> arrayList;
        if (this.A07.isEmpty() && this.A08.isEmpty() && this.A09.isEmpty() && this.A0A.isEmpty()) {
            boolean zIsEmpty = this.A04.isEmpty();
            String[] strArr = A0C;
            if (strArr[2].charAt(18) == strArr[5].charAt(18)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0C;
            strArr2[4] = "HATKbuX1ioRbKjbJza4uRkbMkwnilInw";
            strArr2[3] = "55W5G9gSwoJRpeM2nuMk9rdzPBhIsXI5";
            if (zIsEmpty && this.A06.isEmpty()) {
                boolean zIsEmpty2 = this.A00.isEmpty();
                String[] strArr3 = A0C;
                if (strArr3[2].charAt(18) != strArr3[5].charAt(18)) {
                    A0C[7] = "PBqWGImhwZdo7IXQpaNFK9QlBHxMp4wk";
                    if (zIsEmpty2) {
                        if (this.A02.isEmpty() && this.A05.isEmpty() && this.A01.isEmpty()) {
                            arrayList = this.A03;
                            if (A0C[7].charAt(30) != 'w') {
                                throw new RuntimeException();
                            }
                            A0C[7] = "80rjjAfjuSoUPBYOWBOUrC4mhnJBtDwK";
                            if (!arrayList.isEmpty()) {
                                return false;
                            }
                        }
                    }
                } else if (zIsEmpty2) {
                    if (this.A02.isEmpty()) {
                        arrayList = this.A03;
                        if (A0C[7].charAt(30) != 'w') {
                            throw new RuntimeException();
                        }
                        A0C[7] = "80rjjAfjuSoUPBYOWBOUrC4mhnJBtDwK";
                        if (!arrayList.isEmpty()) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10574k
    public final boolean A0M(AnonymousClass56 anonymousClass56, List<Object> list) {
        return !list.isEmpty() || super.A0M(anonymousClass56, list);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1808Za
    public final boolean A0R(AnonymousClass56 anonymousClass56) {
        A04(anonymousClass56);
        anonymousClass56.A0H.setAlpha(0.0f);
        this.A07.add(anonymousClass56);
        return true;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1808Za
    public final boolean A0S(AnonymousClass56 anonymousClass56) {
        A04(anonymousClass56);
        this.A0A.add(anonymousClass56);
        return true;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1808Za
    public final boolean A0T(AnonymousClass56 anonymousClass56, int i11, int i12, int i13, int i14) {
        View view = anonymousClass56.A0H;
        int translationX = i11 + ((int) anonymousClass56.A0H.getTranslationX());
        int translationY = i12 + ((int) anonymousClass56.A0H.getTranslationY());
        A04(anonymousClass56);
        int i15 = i13 - translationX;
        int i16 = i14 - translationY;
        if (i15 == 0 && i16 == 0) {
            A0O(anonymousClass56);
            return false;
        }
        if (i15 != 0) {
            view.setTranslationX(-i15);
        }
        if (i16 != 0) {
            view.setTranslationY(-i16);
        }
        this.A09.add(new C4M(anonymousClass56, translationX, translationY, i13, i14));
        return true;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1808Za
    public final boolean A0U(AnonymousClass56 anonymousClass56, AnonymousClass56 anonymousClass57, int i11, int i12, int i13, int i14) {
        if (anonymousClass56 == anonymousClass57) {
            return A0T(anonymousClass56, i11, i12, i13, i14);
        }
        float translationX = anonymousClass56.A0H.getTranslationX();
        float translationY = anonymousClass56.A0H.getTranslationY();
        float alpha = anonymousClass56.A0H.getAlpha();
        A04(anonymousClass56);
        int i15 = (int) ((i13 - i11) - translationX);
        int i16 = (int) ((i14 - i12) - translationY);
        anonymousClass56.A0H.setTranslationX(translationX);
        anonymousClass56.A0H.setTranslationY(translationY);
        anonymousClass56.A0H.setAlpha(alpha);
        if (anonymousClass57 != null) {
            A04(anonymousClass57);
            anonymousClass57.A0H.setTranslationX(-i15);
            anonymousClass57.A0H.setTranslationY(-i16);
            anonymousClass57.A0H.setAlpha(0.0f);
        }
        this.A08.add(new C4L(anonymousClass56, anonymousClass57, i11, i12, i13, i14));
        return true;
    }

    public final void A0V() {
        if (A0L()) {
            return;
        }
        A0A();
    }

    public final void A0W(final C4L c4l) {
        AnonymousClass56 anonymousClass56 = c4l.A05;
        final View view = anonymousClass56 == null ? null : anonymousClass56.A0H;
        AnonymousClass56 anonymousClass57 = c4l.A04;
        final View view2 = anonymousClass57 != null ? anonymousClass57.A0H : null;
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(A05());
            this.A02.add(c4l.A05);
            duration.translationX(c4l.A02 - c4l.A00);
            duration.translationY(c4l.A03 - c4l.A01);
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.facebook.ads.redexgen.X.4J
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    this.A03.A0Q(c4l.A05, true);
                    this.A03.A02.remove(c4l.A05);
                    this.A03.A0V();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.A02.add(c4l.A04);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(A05()).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: com.facebook.ads.redexgen.X.4K
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorAnimate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    this.A03.A0Q(c4l.A04, false);
                    this.A03.A02.remove(c4l.A04);
                    this.A03.A0V();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                }
            }).start();
        }
    }

    public final void A0X(final AnonymousClass56 anonymousClass56) {
        final View view = anonymousClass56.A0H;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.A00.add(anonymousClass56);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(A04()).setListener(new AnimatorListenerAdapter() { // from class: com.facebook.ads.redexgen.X.4H
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                this.A02.A0N(anonymousClass56);
                this.A02.A00.remove(anonymousClass56);
                this.A02.A0V();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
            }
        }).start();
    }

    public final void A0Y(final AnonymousClass56 anonymousClass56, int i11, int i12, int i13, int i14) {
        final View view = anonymousClass56.A0H;
        final int i15 = i13 - i11;
        final int i16 = i14 - i12;
        if (i15 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i16 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.A04.add(anonymousClass56);
        viewPropertyAnimatorAnimate.setDuration(A06()).setListener(new AnimatorListenerAdapter() { // from class: com.facebook.ads.redexgen.X.4I
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                if (i15 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i16 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                this.A04.A0O(anonymousClass56);
                this.A04.A04.remove(anonymousClass56);
                this.A04.A0V();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
            }
        }).start();
    }
}
