
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author NikkiNguyen
 */
//keyPressed, change scales and triads, play scales
import processing.core.PApplet;
import java.util.*;

public class PianoMan extends PApplet {

    Scanner scan = new Scanner(System.in);
    //declare global variables
    int wKeyWidth;
    int bKeyWidth;
    //remember mode
    int changeMode = 0;
    //set mode to false
    boolean notMode;

    String lNote = "";
    String nameOfNote = "";

    int box = 75;
    String majOrMinor = "Major";

    //gray when mode pressed
    int pressedColor = 150;

    //naturally white rectangle
    int triadsColor = 255;
    int scalesColor = 255;
    int majorColor = 255;
    int minorColor = 255;

    //signature
    float xpos, ypos;
    int xspeed = 5;
    int yspeed = 3;
    int xdirection = 1;
    int ydirection = 1;
    String s = "FLYING FUCK";

    // bring forth the notes for the keys
    int[] wKeyNotes = {48, 50, 52, 53, 55, 57, 59, 60, 62, 64, 65, 67, 69, 71, 72};
    int[] allNotes = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72};
    // 0 indicates no note to be played, goes to white key note
    int[] bKeyNotes = {0, 49, 51, 0, 54, 56, 58, 0, 61, 63, 0, 66, 68, 70, 0, 73};
    // change integer value of note to string
    String bwNotes[] = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C"};
    //String wNotes[] = {"C", "D", "E", "F", "G", "A", "B", "C", "D", "E", "F", "G", "A", "B", "C", "F"};
    //String bNotes[] = {"", "C#", "D#", "", "F#", "G#", "A#", "", "C#", "D#", "", "F#", "G#", "A#", "", "C#"};
    //scales
    public final int[] MAJOR_SCALE_INTERVALS = {2, 2, 1, 2, 2, 2, 1};
    public final int[] MINOR_SCALE_INTERVALS = {2, 1, 2, 2, 1, 2, 2};
    int[] scalesArray = new int[8];
    //triads
    public final int[] MAJOR_TRIAD_INTERVALS = {0, 4, 7};
    public final int[] MINOR_TRIAD_INTERVALS = {0, 3, 7};
    int[] triadArray = new int[3];

    public void settings() {
        size(1200, 500);
    }

// setup canvas and initialize MusicBox.java
    public void setup() {
        //signature
        xpos = 0;
        ypos = 0;

        background(100, 200, 130);
        MusicBox.initialize();

    }

    public void draw() {

        background(100, 200, 130);
        //declare variables
        int wKeyWidth = width / 15;
        int bKeyWidth = wKeyWidth / 2;
        int bKeyHeight = height / 2;

        //see if mouse is over key (-1 = white keys, i = black)
        //piece of shit ide cant handle global variables
        int smallHover = -1;
        //+3 pixels because stroke weight
        int blackBottom = bKeyHeight + box + 3; //not dirty

        //see if mouse if over black keys (increments black keys 0-7)
        for (int i = 0; i < 15; i++) {
            int wKeyX = i * wKeyWidth;
            int bKeyX = wKeyX + wKeyWidth * 3 / 4;
            int bKeyRight = bKeyX + bKeyWidth;
            if (mouseX > bKeyX && mouseX < bKeyRight && mouseY > box && mouseY <= blackBottom
                    && i != 2 && i != 6 && i != 9 & i != 13 & i != 14) {
                smallHover = i;
            }
        }
        // changes fill when mouse is pressed and hovered on white key
        for (int i = 0; i < 15; i++) {
            int wKeyX = i * wKeyWidth;
            int bKeyX = wKeyX + wKeyWidth * 3 / 4;
            int wKeyRight = wKeyX + wKeyWidth;
            int notBKey = wKeyRight - bKeyWidth / 2;

            //dark blue if pressed
            if (mousePressed && mouseX > wKeyX && mouseX < wKeyRight && mouseY > box
                    && smallHover == -1) {
                fill(0xFF217B93);

                // light blue if hover
            } else if (mouseX > wKeyX && mouseX < wKeyRight && mouseY > box
                    && smallHover == -1) {
                fill(0xFFB9F2F7);

                //fill white if neither of the above are in play
            } else {
                fill(255);
            }
            //draw white keys
            strokeWeight(2);
            //change height to height if you want to scale
            rect(wKeyX, box, wKeyWidth, height);
        }
        //changes fill when mouse is pressed and hovered on black key
        for (int bKey = 1; bKey < 17; bKey++) {
            int blackLeft = wKeyWidth * bKey - bKeyWidth / 2;
            if (mousePressed && mouseX > blackLeft && mouseX < blackLeft + bKeyWidth && mouseY <= blackBottom && mouseY > box
                    && bKey != 3 && bKey != 7 && bKey != 10 & bKey != 14 & bKey != 15) {
                fill(0xFF217B93);
            } else if (mouseX > blackLeft && mouseX < blackLeft + bKeyWidth && mouseY <= blackBottom && mouseY > box) {
                fill(0xFFB9F2F7);
            } else {
                fill(0);
            }
            // don't draw black key on 3, 7, 10, 14, 15
            if (bKey != 3 && bKey != 7 && bKey != 10 & bKey != 14 & bKey != 15) {
                rect(blackLeft, box, bKeyWidth, bKeyHeight);
            }

        }
        //who dis? new num
        if (mousePressed) {

            textSize(100);
            fill(random(255), random(255), random(255));

            xpos = xpos + (xspeed * xdirection);
            ypos = ypos + (yspeed * ydirection);

            if (xpos > 575) {
                xdirection = -1;
            }
            if (xpos < 0) {
                xdirection = 1;
            }
            if (ypos > 400) {
                ydirection = -1;

            }
            if (ypos < 0) {
                ydirection = 1;
            }
            text(s, xpos, ypos, width, height);
        }

        //display mode
        fill(255);
        textSize(30);
        text("Mode:", 20, 37);

        //display notes
        fill(pressedColor);
        rect(117, 11, 88, 35);
        fill(0);
        text("Notes", 120, 37);

        //display triads
        fill(triadsColor);
        rect(226, 11, 94, 35);
        fill(0);
        text("Triads", 230, 37);

        //display scales
        fill(scalesColor);
        rect(342, 11, 94, 35);
        fill(0);
        text("Scales", 345, 37);

        //display major
        fill(majorColor);
        rect(600, 11, 88, 35);
        fill(0);
        text("Major", 603, 37);

        //display minor
        fill(minorColor);
        rect(710, 11, 90, 35);
        fill(0);
        text("Minor", 713, 37);

        //display last note, triad, scale
        if (changeMode == 1) {
            fill(255);
            text("Last Triad: " + lNote + " " + majOrMinor, 850, 37);
        } else if (changeMode == 2) {
            fill(255);
            text("Last Scale: " + lNote + " " + majOrMinor, 850, 37);
        } else {
            fill(255);
            text("Last Note: " + lNote, 850, 37);
        }
    }

    public String getNoteName(int note) {
        for (int i = 0; i < allNotes.length; i++) {
            if (note == allNotes[i]) {
                nameOfNote = bwNotes[i];
            }

        }
        return nameOfNote;
    }

    public void noteClicked(int note) {

        switch (changeMode) {
            case 0:
                //notes
                //notes being played in mousePressed
                //MusicBox.playNote(note, 1000);
                lNote = getNoteName(note);
                break;
            case 1:
                triadArray[0] = note;

                for (int i = 1; i < 3; i++) {
                    //triads for white keys
                    if (majOrMinor == "Major") {

                        triadArray[i] = note + MAJOR_TRIAD_INTERVALS[i];

                    } //triads for black keys
                    else if (majOrMinor == "Minor") {

                        triadArray[i] = note + MINOR_TRIAD_INTERVALS[i];

                    }
                }
                MusicBox.playChord(triadArray, 1000);
                lNote = getNoteName(note);
                break;
            case 2:
                scalesArray[0] = note;
                //major scales
                for (int i = 1; i < 8; i++) {
                    if (majOrMinor == "Major") {
                        scalesArray[i] = scalesArray[i - 1] + MAJOR_SCALE_INTERVALS[i - 1];
                        //minor scales
                    } else if (majOrMinor == "Minor") {
                        scalesArray[i] = scalesArray[i - 1] + MINOR_SCALE_INTERVALS[i - 1];
                    }
                }
                MusicBox.playScale(scalesArray, 1000);
                lNote = getNoteName(note);
                break;
        }

    }

      //switch modes
    public void nextMode() {

        //notes
        if (mouseX >= 117 && mouseX <= 205 && mouseY >= 11 && mouseY <= 35) {
            changeMode = 0;
            notMode = false;
            pressedColor = 150;
            triadsColor = 255;
            scalesColor = 255;
            majorColor = 255;
            minorColor = 255;
            //changeMode ++;
            //if(changeMode > 2){
               // changeMode = 0;
            //}
        }

        //triads
        else if (mouseX >= 226 && mouseX <= 320 && mouseY >= 11 && mouseY <= 35) {
            changeMode = 1;
            notMode = true;
            triadsColor = 150;
            majorColor = 150;
            pressedColor = 255;
            scalesColor = 255;
            minorColor = 255;

        } //scales
        else if (mouseX >= 342 && mouseX <= 436 && mouseY >= 11 && mouseY <= 35) {
            changeMode = 2;
            notMode = true;
            scalesColor = 150;
            majorColor = 150;
            pressedColor = 255;
            triadsColor = 255;
            minorColor = 255;
        }
        System.out.println(changeMode);
    }

    public void nextTriadScaleType() {
        if (mouseX >= 600 && mouseX <= 688 && mouseY >= 11 && mouseY <= 35 && notMode == true) {
            majOrMinor = "Major";
            majorColor = 150;
            minorColor = 255;
        }
        else if (mouseX >= 710 && mouseX <= 800 && mouseY >= 11 && mouseY <= 35 && notMode == true) {
            majOrMinor = "Minor";
            minorColor = 150;
            majorColor = 255;
        }
        System.out.println(majOrMinor);

    }

    public void keyPressed() {
        //same as mousePressed
        if (key == 'm') {
            switch (changeMode) {
                //notes go to triads
                case 0:
                    changeMode = 1;
                    notMode = false;
                    pressedColor = 255;
                    triadsColor = 150;
                    scalesColor = 255;
                    majorColor = 150;
                    minorColor = 255;

                    break;
                //triads to scales
                case 1:
                    changeMode = 2;
                    notMode = true;
                    triadsColor = 255;
                    majorColor = 150;
                    pressedColor = 255;
                    scalesColor = 150;
                    minorColor = 255;
                    break;
                //scales go back to notes
                case 2:
                    changeMode = 0;
                    notMode = true;
                    scalesColor = 255;
                    majorColor = 255;
                    pressedColor = 150;
                    triadsColor = 255;
                    minorColor = 255;
                    break;
            }

        }
        if (key == 't' && changeMode != 0) {
            switch (majOrMinor) {
                case "Major":
                    majOrMinor = "Minor";
                    majorColor = 255;
                    minorColor = 150;
                    break;
                case "Minor":
                    majOrMinor = "Major";
                    minorColor = 255;
                    majorColor = 150;
                    break;
            }
        }

    }




    public void mousePressed() {
        nextMode();
        nextTriadScaleType();
        //variables
        int wKeyWidth = width / 15;
        int bKeyWidth = wKeyWidth / 2;
        int bKeyHeight = height / 2;
        int smallHover = -1;
        int blackBottom = bKeyHeight + box + 3;

        for (int i = 0; i < 15; i++) {
            int wKeyX = i * wKeyWidth;
            int bKeyX = wKeyX + wKeyWidth * 3 / 4;
            int bKeyRight = bKeyX + bKeyWidth;
            if (mouseX > bKeyX && mouseX < bKeyRight && mouseY <= blackBottom
                    && mouseY > box && i != 2 && i != 6 && i != 9 && i != 13 && i != 14) {
                smallHover = i;

            }
        }
        for (int i = 0; i < 15; i++) {
            int wKeyX = i * wKeyWidth;
            int bKeyX = wKeyX + wKeyWidth * 3 / 4;
            int wKeyRight = wKeyX + wKeyWidth;
            int notBKey = wKeyRight - bKeyWidth / 2;

            if (mouseX > wKeyX && mouseX < wKeyRight && mouseY > box
                    && smallHover == -1) {
                // plays the notes from wKeyNotes in order
                MusicBox.playNote(wKeyNotes[i], 1000);
                noteClicked(wKeyNotes[i]);
            }
        }
        for (int i = 1; i < 17; i++) {
            int blackLeft = wKeyWidth * i - bKeyWidth / 2;
            if (mouseX > blackLeft && mouseX < blackLeft + bKeyWidth && mouseY <= blackBottom
                    && mouseY > box && i != 3 && i != 7 && i != 10 && i != 14 && i != 15) {
                // plays the notes from bKeyNotes in order
                MusicBox.playNote(bKeyNotes[i], 1000);
                noteClicked(bKeyNotes[i]);
            }
        }

    }

    public static void main(String args[]) {
        PApplet.main(new String[]{"PianoMan"});
    }
}
