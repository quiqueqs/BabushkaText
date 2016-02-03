/*
 * Copyright (C) 2014 Henrique Boregio.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @author Henrique Boregio (hboregio@gmail.com)
 */
package com.arthas.example.babush;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import babushkatext.BabushkaText;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Display "9.5 excellent!"

        final BabushkaText babushka1 = (BabushkaText)findViewById(R.id.text);
        babushka1.addPiece(new BabushkaText.Piece.Builder("  9.5  ")
                .backgroundColor(Color.parseColor("#073680"))
                .textColor(Color.WHITE)
                .build());
        babushka1.addPiece(new BabushkaText.Piece.Builder(" excellent! ")
                .backgroundColor(Color.parseColor("#DFF1FE"))
                .textColor(Color.parseColor("#073680"))
                .style(Typeface.BOLD)
                .build());
        babushka1.display();

        // Display "3.4 horrible!"
        final BabushkaText babushka2 = (BabushkaText)findViewById(R.id.text2);
        babushka2.addPiece(new BabushkaText.Piece.Builder("  3.4  ")
                .backgroundColor(Color.parseColor("#800736"))
                .textColor(Color.WHITE)
                .build());
        babushka2.addPiece(new BabushkaText.Piece.Builder(" horrible! ")
                .backgroundColor(Color.parseColor("#fedfe2"))
                .textColor(Color.parseColor("#800736"))
                .style(Typeface.BOLD)
                .build());
        babushka2.display();

        // Display "starting at $420"
        BabushkaText babushka3 = (BabushkaText)findViewById(R.id.text3);
        babushka3.addPiece(new BabushkaText.Piece.Builder("starting at ")
                .textColor(Color.parseColor("#50AF2C"))
                .build());
        babushka3.addPiece(new BabushkaText.Piece.Builder("$420!")
                .textColor(Color.parseColor("#50AF2C"))
                .textSizeRelative(1.2f)
                .style(Typeface.BOLD)
                .build());
        babushka3.display();

        // Display "nightly price"
        BabushkaText babushka4 = (BabushkaText)findViewById(R.id.text4);
        babushka4.addPiece(new BabushkaText.Piece.Builder("nightly price  ")
                .textColor(Color.parseColor("#5F5F5F"))
                .superscript()
                .textSizeRelative(0.9f)
                .style(Typeface.BOLD)
                .build());
        babushka4.addPiece(new BabushkaText.Piece.Builder("$256")
                .textColor(Color.parseColor("#5F5F5F"))
                .superscript()
                .strike()
                .textSizeRelative(0.9f)
                .style(Typeface.BOLD)
                .build());
        babushka4.addPiece(new BabushkaText.Piece.Builder(" $179")
                .textColor(Color.parseColor("#9E0719"))
                .textSizeRelative(1.5f)
                .style(Typeface.BOLD)
                .build());
        babushka4.display();

        // Display "new York"
        BabushkaText babushka5 = (BabushkaText)findViewById(R.id.text5);
        babushka5.addPiece(new BabushkaText.Piece.Builder("New York, United States\n")
                .textColor(Color.parseColor("#414141"))
                .style(Typeface.BOLD)
                .build());
        babushka5.addPiece(new BabushkaText.Piece.Builder("870 7th Av, New York, Ny\n")
                .textColor(Color.parseColor("#969696"))
                .textSizeRelative(0.9f)
                .style(Typeface.BOLD)
                .build());
        babushka5.addPiece(new BabushkaText.Piece.Builder("10019, United States of America")
                .textColor(Color.parseColor("#969696"))
                .textSizeRelative(0.8f)
                .build());
        babushka5.display();

        // Display "Central Park"
        BabushkaText babushka6 = (BabushkaText)findViewById(R.id.text6);
        babushka6.addPiece(new BabushkaText.Piece.Builder("Central Park, NY\n")
                .textColor(Color.parseColor("#414141"))
                .build());
        babushka6.addPiece(new BabushkaText.Piece.Builder("1.2 mi ")
                .textColor(Color.parseColor("#0081E2"))
                .textSizeRelative(0.9f)
                .build());
        babushka6.addPiece(new BabushkaText.Piece.Builder("from here")
                .textColor(Color.parseColor("#969696"))
                .textSizeRelative(0.9f)
                .build());
        babushka6.display();

        // Display "Bryant Park Hotel"
        BabushkaText babushka7 = (BabushkaText)findViewById(R.id.text7);
        babushka7.addPiece(new BabushkaText.Piece.Builder("The Bryant Park Hotel\n")
                .textColor(Color.parseColor("#414141"))
                .build());
        babushka7.addPiece(new BabushkaText.Piece.Builder("#6 of 434 ")
                .textColor(Color.parseColor("#0081E2"))
                .build());
        babushka7.addPiece(new BabushkaText.Piece.Builder("in New York City\n")
                .textColor(Color.parseColor("#969696"))
                .build());
        babushka7.addPiece(new BabushkaText.Piece.Builder("2487 reviews\n")
                .textColor(Color.parseColor("#969696"))
                .build());
        babushka7.addPiece(new BabushkaText.Piece.Builder("$540")
                .textColor(Color.parseColor("#F7B53F"))
                .style(Typeface.BOLD)
                .build());
        babushka7.addPiece(new BabushkaText.Piece.Builder(" per night")
                .textColor(Color.parseColor("#969696"))
                .build());
        babushka7.display();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BabushkaText.Piece aPiece = babushka1.getPiece(0);
                aPiece.setText("  9.9  ");
                babushka1.display();
            }
        });
    }

}
