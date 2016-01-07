# mobilecodePatterns

## Logic
- Build a multidimentional array, containing from a position what all traversals are possible.
- Build loop to rotate from all the positions, i.e, starting point is controlled by loop.
- For each position 
-- traverse to the maximum possible depth  
-- print when you add node and the node count is >4
-- recursive calls to check with each position.
-- The break for the recursive would be based on the condition checks algorithm

## Missing Points
- Condition for a patterns is not adhering to the problem definition. At present we check for - no edge repetition for more than twice.
- reflexive edges are missing.
- edges are only considering horzontal, vertical and diagonal. Not considered curve edges. i.e (1,9)..etc. [This is also not a possible edge in present Android lock system]

## Assumptions
