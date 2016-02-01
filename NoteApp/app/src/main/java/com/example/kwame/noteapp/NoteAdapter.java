package com.example.kwame.noteapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kwame on 11/14/15.
 */
public class NoteAdapter extends ArrayAdapter<Note>{

    private Context context;
    private List<Note> notes;

    public NoteAdapter(Context context, List<Note> notes) {
        super(context, android.R.layout.simple_list_item_1, notes);

        this.notes = notes;
        this.context=context;
    }

    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Note getItem(int position) {
        return notes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.list_item_layout,null);
        }

        Note note = notes.get(position);
        TextView noteTitle = (TextView) view.findViewById(R.id.singleItem);
        noteTitle.setText(note.getTitle());

        return view;
    }
}
