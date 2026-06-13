### Agent Naive MCTS

This Repository implements two Agents for the Carcassonne Environment based on the Abstract Agent Repository.
As the naive approach this project defines Agents that assume that the other agent performs at least as good as itself. This means they assume there is no uncertainty associated with planning that the other agent performs the planned step. The naive agents perform normal MCTS where the utility is the total sum of points of both agents. 


#### Agent Naive

implements the Naive approach with a single determinized base agent


#### Agent-Naive-Ensemble 

Implements Ensemble based which uses Agent-Naive as the sub agent to optimize over multiple possible tile orders.