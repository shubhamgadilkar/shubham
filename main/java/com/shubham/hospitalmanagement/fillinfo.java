package com.shubham.hospitalmanagement;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class fillinfo extends AppCompatActivity {
    MyDbHandler mydb;
    Button button,viewbut,updatebtn,delbtn;
    EditText name,address,rage,rweight,rheight,rcontact,rdisease,rdrug,rdocname,eid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fillinfo);
        mydb=new MyDbHandler(this);
        name=(EditText) findViewById(R.id.pname);
        address=(EditText) findViewById(R.id.padd);
        rage=(EditText) findViewById(R.id.page);
        rweight=(EditText) findViewById(R.id.pweight);
        rheight=(EditText) findViewById(R.id.pheight);
        rcontact=(EditText) findViewById(R.id.pcontact);
        rdisease=(EditText) findViewById(R.id.pdisease);
        rdrug=(EditText) findViewById(R.id.pdrug);
        rdocname=(EditText) findViewById(R.id.pdoc);
        button=(Button) findViewById(R.id.psubmit);
        viewbut=(Button) findViewById(R.id.pview);
        updatebtn=(Button) findViewById(R.id.pupdate);
        eid=(EditText) findViewById(R.id.pid);
        delbtn=(Button) findViewById(R.id.pdelete);
        addData();
        ViewData();
        UpdateData();
        DeleteData();

    }

    public void addData(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String patient_name=name.getText().toString();
                String patient_address=address.getText().toString();
                String age=rage.getText().toString();
                String weight=rweight.getText().toString();
                String height=rheight.getText().toString();
                String contact=rcontact.getText().toString();
                String disease_name=rdisease.getText().toString();
                String drug=rdrug.getText().toString();
                String doc_name=rdocname.getText().toString();
                boolean insertData=mydb.addData(patient_name,patient_address,age,weight,height,contact,disease_name,drug,doc_name);
                if(insertData==true){
                    Toast.makeText(fillinfo.this,"Data successfully inserted",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(fillinfo.this,"something went wrong",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void ViewData()
    {
        viewbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor data=mydb.showData();
                if(data.getCount()==0){
                    display("Error","No Data Found");
                    return;
                }

                StringBuffer buffer=new StringBuffer();
                while(data.moveToNext()){
                    buffer.append("ID:"+data.getString(0)+"\n\n");
                    buffer.append("patient_name:\t"+data.getString(1)+"\n");
                    buffer.append("patient_address:\t"+data.getString(2)+"\n");
                    buffer.append("age:\t"+data.getString(3)+"\n");
                    buffer.append("weight:\t"+data.getString(4)+"\n");
                    buffer.append("height:\t"+data.getString(5)+"\n");
                    buffer.append("contact:\t"+data.getString(6)+"\n");
                    buffer.append("disease_name:\t"+data.getString(7)+"\n");
                    buffer.append("drug:\t"+data.getString(8)+"\n");
                    buffer.append("doc_name:\t"+data.getString(9)+"\n\n\n");

                    display("All Stored Data",buffer.toString());


                }
            }
        });
    }
    public void display(String title,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void UpdateData(){
        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = eid.getText().toString().length();
                if (temp > 0) {
                    boolean update = mydb.updateData(eid.getText().toString(), name.getText().toString(), address.getText().toString(), rage.getText().toString(), rweight.getText().toString(), rheight.getText().toString(), rcontact.getText().toString(), rdisease.getText().toString(), rdrug.getText().toString(), rdocname.getText().toString());
                    if (update = true) {
                        Toast.makeText(fillinfo.this, "Successfully Upadated", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(fillinfo.this, "Some Thing Went Wrong", Toast.LENGTH_LONG).show();

                    }
                } else {
                    Toast.makeText(fillinfo.this, "You Must Enter An ID to Update", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
    public void DeleteData(){
        delbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp=eid.getText().toString().length();
                if(temp>0){
                    Integer deleteRow=mydb.deleteData(eid.getText().toString());
                    if(deleteRow>0){
                        Toast.makeText(fillinfo.this, "Data Deleted Successfully", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(fillinfo.this, "Something Went Wrong!", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(fillinfo.this, "You Must Enter An ID to Delete", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
