# mobilecodePatterns

## Logic
- Build a multidimentional array, containing from a position what all traversals are possible.
- Build loop to rotate from all the positions, i.e, starting point is controlled by loop.
- For each position
  - traverse to the maximum possible depth
  - print when you add node and the node count is >4
  - recursive calls to check with each position.
  - The break for the recursive would be based on the condition checks algorithm

## Recursive Condition Chekcks
- step 1.1. Accept User-Input, and create NEW_NODE with value keyed-in.
- step 1.2 Check if the keyed-in value exists for any existing node in the linked list.
  - step 1.3 if No, add NEW_NODE.
  - step 1.4 if yes, check if CURRENT-LAST-NODE value is same in either BEFORE or AFTER node of this identified position.
  - step 1.5  ---------- if yes increment EDGE-COUNT by 1 and repeat step 1.4
  - step 1.6  ---------- if EDGE-COUNT is more than 2, throw error as 'unacceptable pattern' and exit.
  - step 1.7 if EDGE-COUNT is <2, Add NEW_NODE.
  - step 1.8 end.


## Missing Points
- Condition for a patterns is not adhering to the problem definition. At present we check for - no edge repetition for more than twice.
- reflexive edges are missing.
- edges are only considering horzontal, vertical and diagonal. Not considered curve edges. i.e (1,9)..etc. [This is also not a possible edge in present Android lock system]

## Assumptions
