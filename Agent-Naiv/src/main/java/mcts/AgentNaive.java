package mcts;

import abstractDeterminized.AbstractDeterminizedAgent;
import abstractDeterminized.DeterminizedActionNode;
import at.ac.tuwien.ifs.sge.engine.Logger;
import core.AbstractAgentConfiguration;
import model.state.State;

import java.util.Random;

/// AgentNaive
///
/// A basic naive MCTS agent that performs search on determinized Carcassonne game states
/// using standard UCB selection.
public class AgentNaive extends AbstractDeterminizedAgent<AgentNaive.NaiveNode> {
    private static final AbstractAgentConfiguration CONFIG = new AbstractAgentConfiguration(4f, 5, 0.1f, 5);

    /// AgentNaive
    ///
    /// Constructor creating an agent with a logger and default configuration.
    ///
    /// @param logger the logger instance
    public AgentNaive(Logger logger) {
        this(logger, new Random(99));
    }

    /// NaiveNode
    ///
    /// Concrete search node representation used within the AgentNaive tree.
    public static final class NaiveNode extends DeterminizedActionNode<NaiveNode> {

        /// NaiveNode
        ///
        /// Constructor for NaiveNode.
        ///
        /// @param agent the AgentNaive instance
        /// @param parent the parent node in the search tree
        /// @param action the action represented by this node
        /// @param checkpoint the checkpointed board state
        NaiveNode(AgentNaive agent, NaiveNode parent, int action, State checkpoint) {
            super(agent, parent, action, checkpoint);
        }
    }

    /// rootFactory
    ///
    /// Factory method to construct the root node of the MCTS tree.
    ///
    /// @param initialState the initial game state
    /// @return the constructed root node
    @Override
    protected NaiveNode rootFactory(State initialState) {
        return new NaiveNode(this, null, 0, initialState);
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
    public NaiveNode childFactory(NaiveNode parent, int action, State checkpoint) {
        return new NaiveNode(this, parent, action, checkpoint);
    }

    /// AgentNaive
    ///
    /// Default constructor creating an agent with default configuration.
    public AgentNaive() {
        this(null, new Random(99));
    }

    /// AgentNaive
    ///
    /// Constructor creating an agent with a specific random generator and default configuration.
    ///
    /// @param rand the random number generator
    public AgentNaive(Random rand) {
        this(null, rand);
    }

    /// AgentNaive
    ///
    /// Constructor creating an agent with a logger and specific random generator.
    ///
    /// @param logger the logger instance
    /// @param rand the random number generator
    public AgentNaive(Logger logger, Random rand) {
        this(logger, CONFIG, rand);
    }

    /// AgentNaive
    ///
    /// Constructor creating an agent with custom logger, configuration, and random generator.
    ///
    /// @param logger the logger instance
    /// @param config the agent configuration
    /// @param rand the random number generator
    public AgentNaive(Logger logger, AbstractAgentConfiguration config, Random rand) {
        super(logger, config, rand);
    }

}
