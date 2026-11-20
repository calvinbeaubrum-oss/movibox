package aq;

import android.R;
import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public interface a {

    /* JADX INFO: renamed from: aq.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0130a {
        public static TextView a(a aVar, View view) {
            Intrinsics.g(view, "view");
            if (view instanceof TextView) {
                if (view.getId() == -1) {
                    view.setId(R.id.message);
                } else if (view.getId() != 16908299) {
                    throw new IllegalArgumentException("You must set the ID value of TextView to android.R.id.message".toString());
                }
                return (TextView) view;
            }
            if (!(view.findViewById(R.id.message) instanceof TextView)) {
                throw new IllegalArgumentException("You must include a TextView with an ID value of android.R.id.message");
            }
            View viewFindViewById = view.findViewById(R.id.message);
            Intrinsics.e(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
            return (TextView) viewFindViewById;
        }
    }

    boolean a();

    void cancel();

    int getDuration();

    int getGravity();

    float getHorizontalMargin();

    float getVerticalMargin();

    View getView();

    int getXOffset();

    int getYOffset();

    void setDuration(int i11);

    void setGravity(int i11, int i12, int i13);

    void setMargin(float f11, float f12);

    void setText(CharSequence charSequence);

    void setView(View view);

    void show();
}
