### Agent Naiv MCTS

This Repository implements 2 Agents for the Carcassonne Environment based on the Abstract Agent Repository.
As the naive approach this project defines Agents that assume that the other agent performs at least as good as itself. This means they assume there is no uncertainty associated with planning that the other agent performs the planned step.

This means that the naive agent perform normal MCTS where the utility is just the total sum of points of both agents. 


#### Agent Naiv

implements the Naiv approach with a single defeminized base agent


#### Agent-Naiv-Ensemble 

Implements Ensemble based which uses Agent-Naiv as the sub agent