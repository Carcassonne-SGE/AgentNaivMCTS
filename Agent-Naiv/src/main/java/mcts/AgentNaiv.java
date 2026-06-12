package mcts;

import abstractDeterminized.AbstractDeterminizedAgent;
import abstractDeterminized.DeterminizedActionNode;
import at.ac.tuwien.ifs.sge.engine.Logger;
import core.AbstractAgentConfiguration;
import model.state.State;

import java.util.Random;

public class AgentNaiv extends AbstractDeterminizedAgent<AgentNaiv.NaiveNode> {
    private static final AbstractAgentConfiguration CONFIG = new AbstractAgentConfiguration(4f, 5, 0.1f, 5);

    public static final class NaiveNode extends DeterminizedActionNode<NaiveNode> {
        NaiveNode(AgentNaiv agent, NaiveNode parent, int action, State checkpoint) {
            super(agent, parent, action, checkpoint);
        }
    }

    public AgentNaiv() {
        this(null, new Random(99));
    }

    public AgentNaiv(Logger logger) {
        this(logger, new Random(99));
    }

    public AgentNaiv(Random rand) {
        this(null, rand);

    }

    public AgentNaiv(Logger logger, Random rand) {
        this(logger, CONFIG, rand);
    }

    public AgentNaiv(Logger logger, AbstractAgentConfiguration config, Random rand) {
        super(logger, config, rand);
    }

    @Override
    protected NaiveNode rootFactory(State initialState) {
        return new NaiveNode(this, null, 0, initialState);
    }

    @Override
    public NaiveNode childFactory(NaiveNode parent, int action, State checkpoint) {
        return new NaiveNode(this, parent, action, checkpoint);
    }
}
