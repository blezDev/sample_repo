package com.example.forms

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.forms.TeamFormAdapter.TeamViewHolder

class TeamFormAdapter(private val TeamList : List<TeamForm>):RecyclerView.Adapter<TeamViewHolder>()  {
    var onSubmit : ((TeamForm)-> Unit) ?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.form_model,parent,false)
        return TeamViewHolder(v)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {


        val Team = TeamList[position]
        val name = holder.Name.text.toString()
        val roll = holder.Roll.text.toString()
        val mail = holder.Email.text.toString()
        val teamName = holder.teamName.text.toString()
        val phone = holder.Phone.text.toString()
        holder.button.setOnClickListener {
            onSubmit?.invoke(TeamForm(name, roll, mail, teamName, phone))
        }


    }

    override fun getItemCount(): Int {
        return TeamList.size
    }


    class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val Name: EditText = itemView.findViewById(R.id.memberName)
        val Roll: EditText = itemView.findViewById(R.id.memberRoll)
        val Email: EditText = itemView.findViewById(R.id.memberEmail)
        val teamName: EditText = itemView.findViewById(R.id.teamName)
        val Phone: EditText = itemView.findViewById(R.id.memberPhone)
        val button :Button = itemView.findViewById(R.id.button2)


    }
}