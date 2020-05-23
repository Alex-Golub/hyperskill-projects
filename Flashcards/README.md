# hs-Flashcards
<hr>

add: add cards to card stack (card with same term will not be added)

remove: remove card by card term

import: import cards from external txt file at run-time, file must contain 3 lines for each card in this order:<br>
	term<br>
	definition<br>
	number of mistakes<br>
existing cards with same term for external file will be overwritten with the new definition and number of mistakes<br>
NOTE: if run from command-line you can enter name of file to import cards from upon application<br>
start, e.g. java flashcards.Main -import cards.txt<br>
this will load that cards from file upon application start<br> 

export: export the current session states to external txt file

ask: enter number of times to ask definition of a random card from stack
 
exit: exit the program (if run from command-line you can enter file name to log the session upon exit)<br>
	e.g. java flashcards.Main -export todayLog.txt<br>
	current session will be logged to todayLog.txt file<br>
	  
log: log all the output and input messages of app to external file
 
hardest card: print the card(s) with the highest number of mistakes
 
reset states: reset all cards number of mistakes to 0

<br>
<a href="https://ibb.co/8BDxMnj"><img src="https://i.ibb.co/Ct59Bpn/VU819-YClg-P.gif" alt="VU819-YClg-P" border="0"></a>
