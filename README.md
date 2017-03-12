# CardGame
Java 2 Final - Card game.
A window pops up with several cards on it, face down. Player one clicks a card, and then player two clicks a card.
Each card flips up and whoever's card is a higher denomination wins. Wins are recorded in a text box on the window.

## Bugfixes
1. Simple IndexOutOfBounds issue; program might try to get card image at the arrylists index 52 for the opponents card.
2. Program was setting card values to one less than what they should be, which sometimes let the user pick three cards instead of two.

