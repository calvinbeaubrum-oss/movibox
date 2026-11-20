package com.transsion.home.adapter.suboperate.provider;

import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.adapter.suboperate.adapter.SubAppointmentAdapter;
import com.transsion.moviedetailapi.bean.AppointSubject;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class c extends BaseItemProvider<OperateItem> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<Function1<? super Boolean, Unit>, Unit> f52174f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f52175g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SimpleDateFormat f52176h;

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function1<? super Function1<? super Boolean, Unit>, Unit> onAppointmentCLick, int i11) {
        Intrinsics.g(onAppointmentCLick, "onAppointmentCLick");
        this.f52174f = onAppointmentCLick;
        this.f52175g = i11;
        this.f52176h = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    }

    public static final void w(c this$0, OperateItem item) {
        List<OperateItem> listD;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(item, "$item");
        BaseProviderMultiAdapter<OperateItem> baseProviderMultiAdapterC = this$0.c();
        if (baseProviderMultiAdapterC != null && (listD = baseProviderMultiAdapterC.D()) != null) {
            listD.remove(item);
        }
        BaseProviderMultiAdapter<OperateItem> baseProviderMultiAdapterC2 = this$0.c();
        if (baseProviderMultiAdapterC2 != null) {
            baseProviderMultiAdapterC2.notifyDataSetChanged();
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return PostItemType.APPOINTMENT_LIST.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_sub_operation_appointment;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, final OperateItem item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        ((TextView) helper.getView(R$id.sub_operation_appointment_title)).setText(item.getTitle());
        RecyclerView recyclerView = (RecyclerView) helper.getView(R$id.sub_operation_appointment_recycle);
        SubAppointmentAdapter subAppointmentAdapter = new SubAppointmentAdapter(0, this.f52174f, this.f52175g, item, 1, null);
        recyclerView.setAdapter(subAppointmentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(g(), 0, false));
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new ro.e(8.0f, 0.0f, 12.0f, 2, null));
        }
        List<AppointSubject> subjects = item.getSubjects();
        if (subjects == null) {
            subjects = new ArrayList<>();
        }
        List<AppointSubject> listX = x(subjects);
        subAppointmentAdapter.w0(listX);
        if (listX.isEmpty()) {
            helper.itemView.post(new Runnable() { // from class: com.transsion.home.adapter.suboperate.provider.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.w(this.f52172a, item);
                }
            });
        }
    }

    public final List<AppointSubject> x(List<AppointSubject> list) {
        Date date = new Date();
        ArrayList arrayList = new ArrayList();
        try {
            for (AppointSubject appointSubject : list) {
                SimpleDateFormat simpleDateFormat = this.f52176h;
                String appointmentDate = appointSubject.getAppointmentDate();
                if (appointmentDate == null) {
                    appointmentDate = "";
                }
                Date date2 = simpleDateFormat.parse(appointmentDate);
                if (date2 != null && date2.after(date)) {
                    arrayList.add(appointSubject);
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return arrayList;
    }
}
