# Piano Program
## Project 3: The Piano Man

This program is suppose to display a piano that allows the user to play different keys.

## Problem
- install the `processing.core.PApplet` library
- currently does not run on the NetBeans IDE
- once the library is successfully installed, the program can display the GUI but the keywords from Processing are not functional at the moment.

### Overview
In this project you will extend your Project 1 keyboard with a few new features using arrays and strings. You will run the code through NetBeans (or another Java IDE), not through the Processing development environment. Your new features will allow the user to play triads (3 notes at once), scales (7 notes in a sequence), or single notes as before.

### Introduction
We must cover some new music theory for this project.

#### Scales:
A *scale* is a sequence of musical notes in ascending or descending order. *Scales* start with a particular note
(e.g. C, A, or B-at) and choose subsequent notes in the scale by following a pattern specific to the type
of scale used. For example, a C major scale is comprised of the notes C-D-E-F-G-A-B-C, and a C minor
scale uses the notes C-D-E at-F-G-A at-B at-C.
A *major scale* is a sequence of notes, where the steps between notes in the scale follow this pattern:
    2, 2, 1, 2, 2, 2, 1

For example, the C major scale is
    C  D  E  F  G  A  B  C
     +2 +2 +1 +2 +2 +2 +1

which in integer notation is
    60 62 64 65 67 69 71 72;

and the A major scale is
    A B C# D E F# G# A

A *minor scale* is a sequence of notes where the steps between notes in the scale follow this pattern:
    2, 1, 2, 2, 1, 2, 2

The C minor scale is
    C D Eb F G Ab Bb C

which in integer notation is
    60 62 63 65 67 68 70 72

You should now understand that playing a scale through MIDI is about selecting the integer notation value of the starting note, and then following a pattern for the particular scale type to generate the following notes in the scale.

#### Chords and triads:
A *chord* is a group of notes played at the same time. Chords usually follow a pattern for choosing the notes so that the group sounds a particular way. One type of chord is called a triad, a grouping of 3 notes usually taken from the notes of a particular scale type.

A *major triad* consists of the first, third, and fifth notes of a major scale starting at a particular note. For example, a C major triad is
    C E G

as those are the first, third, and fifth notes in the corresponding C major scale. By applying the integer notation pattern for a major scale (reminder: 2, 2, 1, 2, 2, 2, 1), we see that the three notes of a major triad in integer notation are notes +0, +4, and +7 above the starting note. C major triad in integer notation is
    60 64 67

since +0/+4/+7 above the starting note of 60 is 60/64/67.
A minor triad consists of the first, third, and fifth notes of a minor scale. For example, the C minor triad is
    C Eb G

In integer notation, a minor triad is +0, +3, and +7.

### Starting Out
Your first task is to take your existing Project 1 code and port it to NetBeans or your favorite Java IDE. Porting means taking source code and translating it from one format to another such that the functionality is unchanged. I will give instructions for NetBeans; you will have to figure out the equivalent for a different editor.

Start by making a New Project -> Java Application as before. Name the project and finish creating it. You will see a Libraries folder in the Projects view on the left. Right click "Libraries" and choose "Add JAR/Folder...." You now need to navigate to the folder where you installed Processing. On my Windows machine, this is at `C:\Program Files\processing-3.0.2.` From there, go to the core folder, then the library folder inside that, and select the file `core.jar` to Open with the editor.

Next copy the same `MusicBox.java` file from Project 1 into your project's src directory.

Next add a Java file to the project called Project2.java. Copy and paste your code from Project 1 into the contents of the class `Project2 { `declaration in the .java file. This file won't compile yet; we have some surgery to do.

1. Add the line `import processing.core.PApplet;` to the start of the file.
2. Modify the line `public class Project2` to read `public class Project2 extends PApplet {`.
3. Add the word public to all function headers in the project. `void draw() `becomes `public void
draw()`.
4. If you use any floating-point numbers in your code (like `1.5`), you will need to put a lowercase `f` at the end of the number everywhere it is used. `1.5` becomes `1.5f`.
5. Java doesn't like `size()` being in the setup function. You need to remove it, then add a new function `public void settings()` where you can place the size call.
6. Replace any instances of `#` (for colors) with `0xFF`. `fill(#ABCDEF)` becomes `fill(0xFFABCDEF)`.
7. Finally, add this function to the class:
    `public static void main(String args[]) {
        PApplet.main(new String[]{"Project2"});
    }`
8. You should now be able to run your program from your IDE.

### Operations
Your project will retain its current features, and add the ability to switch modes between playing single notes, triads of 3 notes, or scales of 8 notes. You will also need to extend your keyboard to show two full octaves instead of the single octave in Project 1. The leftmost key of your new keyboard will be note 48 instead of 60.

#### Modes:
1. Your piano's height should no longer take the full height of the application. There should instead be a
small (50-100 pixels) gap between the top edge of the window and the top of the keys. This gap should
be filled in with a color of your choosing. In this gap, you will display information about the program, including a button to change the program's mode.
2. You must display three things in this gap:
  * First, you must display the application's current mode. The application can be in one of three modes: Notes, Triads, and Scales. Display this as text.
  * If the mode is Triads or Scales, you must also display a string showing the triad/scale's current Type. Major and Minor are the two valid types.
  * Second, you must display the last node/triad/scale to be played by the user. This must be displayed as the name of a musical note, like C# for note 61.
3. If the user clicks on the current mode, you should change the mode to the next mode in sequence. That is, if the mode is currently Notes, you will change to Triads. You will need a variable to keep track of the current mode and will have to update it accordingly.
4. If the user clicks on the triad/scale type, it must switch between the two valid types. You will also need a variable for this.
5. If the user presses the `m` key on the keyboard, switch the mode as if they clicked on the mode with the mouse.
6. If the user presses the `t` key on the keyboard, change the triad/scale type as if they clicked it with the mouse.

#### New functions:
We will take advantage of what we have learned about writing our own functions to improve our code in this project. You must define and use these functions in your code:
1. `public String getNoteName(int note)`: given the integer value of a note, returns the string name of that note. Use # to indicate sharp notes, and do not indicate at notes (use the sharp equivalent instead). Example: `getNoteName(61)` would `return C#`.
2. `public void noteClicked(int note)`: call this function when the user clicks a key on the key- board. All the logic for playing the appropriate note, triad, or scale should be in this function. Your mousePressed function should then simply determine which note was clicked and pass that value to `noteClicked`.
3. `public void nextMode()`: call this function when the user clicks on the mode label to switch modes. Examine the current mode, then change to the next appropriate mode.
4. `public void nextTriadScaleType()`: call this function when the user clicks on the triad/scale type to switch types.

#### Playing triads and scales:
1. Your `mousePressed` function cannot assume that it should use `MusicBox.playNote` at all times. Depending on the piano's current mode, you will need to use two other functions from the music box: `MusicBox.playChord` and `MusicBox.playScale`. Both of those functions take an array of notes to play, as well as the duration to play them for.
2. To play a triad, create an array of 3 values equal to the three notes in the triad you want to play, then call `MusicBox.playChord`.
3. To play a scale, create an array of 8 values equal to the notes you want to play in sequence, then call `MusicBox.playScale`.
4. Any time any note, triad, or scale is played, the information area must be updated to indicate the
name of the most recently played operation was. For single notes, display `Last Note: __`; for triads,
display `Last Triad: ____` major/minor (as appropriate); for scales, display `Last Scale: ____`
major/minor (likewise).

#### Programming triads and scales:
1. Make arrays in your class (outside of all your functions) like this:
` public final int[] MAJOR_SCALE_INTERVALS = {2, 2, 1, 2, 2, 2, 1};
  public final int[] MAJOR_TRIAD_INTERVALS = {0, 4, 7};`
2. Do the same for the minor scale discussed in the introduction.
3. When the user clicks a key and the program's mode is triads or scales, then after determining which
key number they pressed, you will need to construct an array of values by applying the pattern from
the arrays above to the starting value. For example, if we are playing a major triad and the starting
note is 62, then we would make an array with values 62,62+4,62+7.
