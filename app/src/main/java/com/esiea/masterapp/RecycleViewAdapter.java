package com.esiea.masterapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MonsterViewHolder> {

    private List<MonsterActivity> monActivityList = new ArrayList<>();
    private ItemSelectionListener listener;
    @NonNull
    @Override
    public MonsterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_monster_list,viewGroup,false);
        return new MonsterViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull MonsterViewHolder monsterViewHolder, int i) {
        MonsterActivity monActivity = monActivityList.get(i);
        monsterViewHolder.monsterId.setText(String.valueOf(monActivity.getId()));
        monsterViewHolder.monsterName.setText(monActivity.getName());
        monsterViewHolder.monsterGroup.setText(monActivity.getGroup());
        monsterViewHolder.monsterElement.setText(monActivity.getElements());
        monsterViewHolder.monsterWeakness.setText(monActivity.getWeaknesses());
        monsterViewHolder.monsterDanger.setText(String.valueOf(monActivity.getDanger()));
        monsterViewHolder.monsterDescription.setText(monActivity.getDescription());
    }
    @Override
    public int getItemCount() {
        return monActivityList.size();
    }
    public void monsterPlant(List<MonsterActivity> listMonster){
        this.monActivityList = listMonster;
        notifyDataSetChanged();
    }
    public MonsterActivity getMonster(int i){
        return monActivityList.get(i);
    }
    class MonsterViewHolder extends RecyclerView.ViewHolder {
        private TextView monsterId;
        private TextView monsterName;
        private TextView monsterGroup;
        private TextView monsterElement;
        private TextView monsterWeakness;
        private TextView monsterDanger;
        private TextView monsterDescription;

        public MonsterViewHolder(View itemView) {
            super(itemView);
            monsterId = itemView.findViewById(R.id.monster_id_case);
            monsterName = itemView.findViewById(R.id.monster_name_case);
            monsterGroup = itemView.findViewById(R.id.monster_group_case);
            monsterElement = itemView.findViewById(R.id.monster_elements_case);
            monsterWeakness = itemView.findViewById(R.id.monster_weaknesses_case);
            monsterDanger = itemView.findViewById(R.id.monster_danger_case);
            monsterDescription = itemView.findViewById(R.id.monster_description_case);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int i = getAdapterPosition();
                    if(listener != null && i != RecyclerView.NO_POSITION) {
                        listener.itemSelection(monActivityList.get(i));
                    }
                }
            });
        }
    }
    public interface ItemSelectionListener{
        void itemSelection(MonsterActivity monActivity);
    }
    public void setItemSelectionListener(ItemSelectionListener listener){
        this.listener = listener;
    }
}
