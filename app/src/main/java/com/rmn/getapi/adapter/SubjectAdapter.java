package com.rmn.getapi.adapter;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rmn.getapi.EditActivity;
import com.rmn.getapi.model.Subject;
import com.rmn.getapi.R;

import java.util.List;
public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.MyViewHolder>{
    List<Subject> mSubjectList;
    public SubjectAdapter(List <Subject> SubjectList) {
        mSubjectList = SubjectList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_subject_list, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder,final int position){
        holder.mTextViewId.setText("ID = " + mSubjectList.get(position).getSubject_id());
        holder.mTextViewNama.setText("Subject Name = " + mSubjectList.get(position).getSubject_name());
        holder.mTextViewSKS.setText("SKS = " + mSubjectList.get(position).getSks());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditActivity.class);
                mIntent.putExtra("id", mSubjectList.get(position).getSubject_id());
                mIntent.putExtra("nama", mSubjectList.get(position).getSubject_name());
                mIntent.putExtra("sks", mSubjectList.get(position).getSks());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mSubjectList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewNama, mTextViewSKS;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.tvId);
            mTextViewNama = (TextView) itemView.findViewById(R.id.tvNama);
            mTextViewSKS = (TextView) itemView.findViewById(R.id.tvSKS);
        }
    }
}
