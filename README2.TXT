Student name: Dilkush Punja

Please complete this README file for your level 3 mini-project submission.

If your level 1/2 submission did not get full marks you MUST complete the second part of this template describing how and where your have improved your code so that it now meets the level 1 and 2 requirements. If your code still does not meet level 1 and 2 requirements then you will get 0 for level 3.

LEVEL THREE

GUI

[The user interacts with the program via buttons and a text field. For example, once the user presses the "Play" button an action event is fired
 and an actionListener responds to this by invoking the actionPerformed method in the StartScreen class on line 49. Within the actionPerformed
 method is an if-else branch which carrys out different operations based on the button pressed. In the case of "Play", the layout of the GUI is 
 adjusted (lines 51- 129, StartScreen class), introducing a TextArea as the main program output, TextFields for important player stats along with a TextField and a "Continue" button,
 which once pressed returns the value entered by the user.]
 
Exceptions

['Game' class, line 696.]
[The above example of exception handling is required in my code because for the user to correctly 'battle' an NPC they are required to enter integer values,
 my code works by allowing the user to enter a String value which is later parsed into an integer, but the user may accidentially enter a String
 which cannot be parsed correctly which would throw a NumberFormatException. This exception needs to be dealt with otherwise the program would
 suddenly halt execution. Therefore, by using try catch the user is continually prompted to enter an appropriate value and only once the String 
 value has been successfully parsed can they continue.]

Collections

['Player' class, line 7 is where an ArrayList is declared. 'Game' class, line 82]
[The player has an inventory which can be used to store artefacts that they discover throughout the game. A collection class such as ArrayList
 is preferred over a regular array because NPCs which the user interacts with are able to remove items from the player's inventory, an ArrayList
 is able to change its size dynamically, whereas an array has a fixed size. Therefore, an ArrayList is better suited for this use as items are 
 constantly being added or removed. ArrayList is also used for file I/O line 559.]

File I/O

[My code implements file I/O in the 'Game' class lines 556-637, it is used to store the player's stats once they have finished the game. These
 statistics are then viewable as a Leaderboard when the user first starts the program or has finished the game. Before, the leaderboard is outputted
 to the TextArea in the GUI the leaderboard is sorted using bubble sort from highest score to lowest score and then displayed in the GUI window. ]

'Something impressive'

[My code implements the Java sound class ('Music' class lines 2-4), which provides background music which begins to play once the main method of the 'Game' class is run.
 The user has the ability to turn on and off the music using a button which is available in the main GUI window. Rather than simply stopping the
 music abruptly and starting it from the beginning everytime the button is pressed, the method 'pauseMusic' line 35, records the current timestamp
 of the music file being played and stores this in the Clip object. Allowing for play/pause, also the music loops continously once the .wav file has
 reached the end.] 


LEVELS 1 AND 2

(ONLY complete this if you did not get full marks for your level 1/2 submission.)

LEVEL ONE

[Briefly (three sentences) explain the changes you have made to your code so that it fully meets the level one requirements.]

My code demonstrates inheritance in the following way...

I have a superclass called [Insert name of superclass here]

This superclass is extended into at least two subclasses called [Insert names of the subclasses here]

For each of the named subclasses complete the following...

Subclass 1.

Subclass [Insert name of subclass] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [Insert names of properties here.]

These/this new properties/property are used by the subclass in the following way: [Insert justification for adding the property and give the line numbers in the code of where the property is used.]

Subclass [Insert name of subclass] extends the superclass by overriding the following methods (there must be at least one): [Insert names of overridden methods and their line numbers in the code.]

These overridden methods are used in the working code in the following places: [list the file names and line numbers where the overridden methods are called.]

Subclass 2.

Subclass [Insert name of subclass] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [Insert names of properties here.]

These/this new properties/property are used by the subclass in the following way: [Insert justification for adding the property and give the line numbers in the code of where the property is used.]

Subclass [Insert name of subclass] extends the superclass by overriding the following methods (there must be at least one): [Insert names of overridden methods and their line numbers in the code.]

These overridden methods are used in the working code in the following places: [list the file names and line numbers where the overridden methods are called.]


LEVEL TWO

[Briefly (three sentences) explain the changes you have made to your code so that it fully meets the level two requirements.]

Polymorphism consists of the use of the Substitution principle and Late Dynamic binding.

In my code, polymorphism is implemented in at least two places…

Example 1.

The substitution principle can be seen in use in [class name and line number where substitution is used]. The name of the superclass used this example is [name of superclass] and the subclasses used are [names of subclasses].

Late dynamic binding can be seen in [class name and line number].

[Explain briefly (no more than four sentences), why this example of polymorphism is necessary in your code.]

Example 2.

The substitution principle can be seen in use in [class name and line number where substitution is used]. The name of the superclass used this example is [name of superclass] and the subclasses used are [names of subclasses].

Late dynamic binding can be seen in [class name and line number].

[Explain briefly (no more than four sentences), why this example of polymorphism is necessary in your code.]


