package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class BottomSheetDialogFragment extends AppCompatDialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f36353a;

    /* JADX INFO: compiled from: source.java */
    public class b extends BottomSheetBehavior.f {
        public b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void b(@NonNull View view, float f11) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void c(@NonNull View view, int i11) {
            if (i11 == 5) {
                BottomSheetDialogFragment.this.h0();
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        if (j0(false)) {
            return;
        }
        super.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
        if (j0(true)) {
            return;
        }
        super.dismissAllowingStateLoss();
    }

    public final void h0() {
        if (this.f36353a) {
            super.dismissAllowingStateLoss();
        } else {
            super.dismiss();
        }
    }

    public final void i0(@NonNull BottomSheetBehavior<?> bottomSheetBehavior, boolean z11) {
        this.f36353a = z11;
        if (bottomSheetBehavior.q0() == 5) {
            h0();
            return;
        }
        if (getDialog() instanceof com.google.android.material.bottomsheet.b) {
            ((com.google.android.material.bottomsheet.b) getDialog()).q();
        }
        bottomSheetBehavior.Y(new b());
        bottomSheetBehavior.U0(5);
    }

    public final boolean j0(boolean z11) {
        Dialog dialog = getDialog();
        if (!(dialog instanceof com.google.android.material.bottomsheet.b)) {
            return false;
        }
        com.google.android.material.bottomsheet.b bVar = (com.google.android.material.bottomsheet.b) dialog;
        BottomSheetBehavior<FrameLayout> bottomSheetBehaviorO = bVar.o();
        if (!bottomSheetBehaviorO.x0() || !bVar.p()) {
            return false;
        }
        i0(bottomSheetBehaviorO, z11);
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        return new com.google.android.material.bottomsheet.b(getContext(), getTheme());
    }
}
