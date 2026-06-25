package mcts;

import abstractDeterminized.AbstractDeterminizedAgent;
import abstractDeterminized.DeterminizedActionNode;
import at.ac.tuwien.ifs.sge.engine.Logger;
import core.AbstractAgentConfiguration;
import model.state.State;

import java.util.Random;

/// NaiveEnsembleSubAgent
///
/// An internal determinized sub-agent helper used by AgentNaiveEnsemble and AgentNaiveEnsembleNormalized.
final class NaiveEnsembleSubAgent extends AbstractDeterminizedAgent<NaiveEnsembleSubAgent.EnsembleSearchNode> {

    /// EnsembleSearchNode
    ///
    /// Concrete search node representation used within the NaiveEnsembleSubAgent tree.
    static final class EnsembleSearchNode extends DeterminizedActionNode<EnsembleSearchNode> {

        /// EnsembleSearchNode
        ///
        /// Constructor for EnsembleSearchNode.
        ///
        /// @param agent the determinized agent managing the search tree
        /// @param parent the parent node in the search tree
        /// @param action the action represented by this node
        /// @param checkpoint the checkpointed board state
        private EnsembleSearchNode(AbstractDeterminizedAgent<EnsembleSearchNode> agent, EnsembleSearchNode parent,
                int action, State checkpoint) {
            super(agent, parent, action, checkpoint);
        }
    }

    /// NaiveEnsembleSubAgent
    ///
    /// Constructor for NaiveEnsembleSubAgent.
    ///
    /// @param logger the logger instance
    /// @param config the configuration settings for the agent
    /// @param rand the random number generator
    NaiveEnsembleSubAgent(Logger logger, AbstractAgentConfiguration config, Random rand) {
        super(logger, config, rand);
    }

    /// rootFactory
    ///
    /// Factory method to construct the root node of the MCTS tree.
    ///
    /// @param initialState the initial game state
    /// @return the constructed root node
    @Override
    protected EnsembleSearchNode rootFactory(State initialState) {
        return new EnsembleSearchNode(this, null, 0, initialState);
    }

    /// childFactory
    ///
    /// Factory method to construct a new child node in the MCTS tree.
    ///
    /// @param parent the parent node
    /// @param action the action taken
    /// @param checkpoint the checkpointed state of the child node
    /// @return the constructed child node
    @Override
    public EnsembleSearchNode childFactory(EnsembleSearchNode parent, int action, State checkpoint) {
        return new EnsembleSearchNode(this, parent, action, checkpoint);
    }
}
