# mobilecodePatterns

## Logic
- Build a multidimentional array containing, from any given position what all are possible traversals.
- Examples: for position 1, the posssible traversals are {2,4,5}, for position 2 {3,4,5,6}
- Build loop to rotate from all the positions, i.e, starting point is controlled by loop.
- For each position
  - traverse to the maximum possible depth
  - print when you add node and the node count is >4
  - recursive calls to check with each position.
  - The break for the recursive would be based on the condition checks algorithm
- The codition check algorithm keeps track of edge/'reverse edge' and its count of occurance at any moment.
- The String Builder object, will build the GRAPH.

## Recursive Condition Chekcks
- step 1.1. Accept User-Input, and create edge and reverse edge with last value of existing graph and keyed-in value.
- step 1.2 Check if the keyed-in value exists for any existing node in the linked list.
  - step 1.3 if No, add it to GRAPH and check the edge occurance to add by 1. 
  - step 1.4 if yes, loop through Map <edge, totalOccurance> list, to check if any edge has more than 2 occurances "isAnyEdgeTwice" and also validate whether the current forming edge already exisits. "isEdgeExists".
  - step 1.5  ---------- Based on above flags increment the edge occurance, or add the edge to the list.
  - step 1.6  ---------- Recurrance throguh all possible positions from the given point. so the depth traversal is completed.
  - step 1.7 End the traverse once you complete all possibilities for the given position.
  - step 1.8 end.

## Missing Points
- We could have construct a Class for edge storage with methods like getEdge(), getReverseEdge(), compareEdges(), and count of Occurances.

## Assumptions
- Only Straight and Diagnoal traversals are considered for edge formation. No curve. Example (1,3) is not considered as edge because we cannot connect both vertices with straight line.
