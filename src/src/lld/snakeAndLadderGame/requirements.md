## Snakes and Ladders — Final Requirements

### Core Rules

1. The board is a 10×10 grid with cells numbered 1 to 100.
2. The game supports 2 to 4 players.
3. Players take turns in a fixed order (Player 1 → Player 2 → ... → back to Player 1).
4. Each turn, a player rolls a single standard die (values 1–6, equally random).
5. All players start at position 0 (off the board). A player enters the board on their first roll.
6. A player moves forward by the number rolled.
7. If a move would take a player beyond 100, the player does not move that turn.
8. The first player to land exactly on 100 wins. The game ends immediately.

### Snakes and Ladders

9. The board has a configurable number of snakes and ladders (provided at game setup, not changed during the game).
10. A snake has a head (higher cell) and a tail (lower cell). Landing on the head moves the player down to the tail.
11. A ladder has a bottom (lower cell) and a top (higher cell). Landing on the bottom moves the player up to the top.
12. Snakes and ladders do not chain — if a snake/ladder drops/lifts you to another snake/ladder, nothing further happens. One transition per turn.
13. Cell 1 and cell 100 cannot have a snake head, snake tail, ladder top, or ladder bottom.
14. A snake and a ladder cannot start or end on the same cell.

### Die Rules

15. If a player rolls a 6, they get one bonus turn after moving. Only one bonus turn per 6 (no infinite chains).
16. If a player rolls three consecutive 6s, all three moves are cancelled (player returns to their position before the first 6), and their turn ends.

### Input/Output

17. Game setup takes as input: number of players, list of snakes (head, tail pairs), list of ladders (bottom, top pairs).
18. The die roll is random — not user-input.
19. After each turn, the system outputs: which player rolled, what they rolled, ^[their old position, their new position, and whether a snake/ladder was
    encountered.
20. When the game ends, the system outputs the winner.

