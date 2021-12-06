package com.krishna;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ResetPassword extends AppCompatActivity {


    EditText old, newpwd, cnfpwd;
    Button save;
    String oldpassword, newpassword, cnfpassword;
    String pwd = AES.pwdtext.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpassword);

        old = (EditText) findViewById(R.id.old);


        newpwd = (EditText) findViewById(R.id.newp);


        cnfpwd = (EditText) findViewById(R.id.cnfpwd);


        save = (Button) findViewById(R.id.save);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oldpassword = old.getText().toString();
                newpassword = newpwd.getText().toString();
                cnfpassword = cnfpwd.getText().toString();
                if (pwd.equals(oldpassword)) {

                    if (newpassword.equals(cnfpassword)) {
                        AES.pwdtext = newpassword;
                        System.out.println("Updated Successfully");
                        Toast.makeText(ResetPassword.this, "Updated Successfully!!", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(ResetPassword.this, " Password does not Match", Toast.LENGTH_SHORT).show();
                        System.out.println("New Password doesn't match");
                    }
                } else {
                    System.out.println(pwd);
                    Toast.makeText(ResetPassword.this, " Password does not Match", Toast.LENGTH_SHORT).show();
                    System.out.println("Old Password doesn't match");
                    System.out.println(oldpassword);
                }
            }
        });

    }
}
