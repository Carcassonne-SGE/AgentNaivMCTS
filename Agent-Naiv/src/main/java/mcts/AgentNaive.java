package mcts;

import abstractDeterminized.AbstractDeterminizedAgent;
import abstractDeterminized.DeterminizedActionNode;
import at.ac.tuwien.ifs.sge.engine.Logger;
import core.AbstractAgentConfiguration;
import model.state.State;

import java.util.Random;

public class AgentNaive extends AbstractDeterminizedAgent<AgentNaive.NaiveNode> {
    private static final AbstractAgentConfiguration CONFIG = new AbstractAgentConfiguration(4f, 5, 0.1f, 5);

    public AgentNaive(Logger logger) {
        this(logger, new Random(99));
    }

    public static final class NaiveNode extends DeterminizedActionNode<NaiveNode> {
        NaiveNode(AgentNaive agent, NaiveNode parent, int action, State checkpoint) {
            super(agent, parent, action, checkpoint);
        }
    }

    @Override
    protected NaiveNode rootFactory(State initialState) {
        return new NaiveNode(this, null, 0, initialState);
    }

    @Override
    public NaiveNode childFactory(NaiveNode parent, int action, State checkpoint) {
        return new NaiveNode(this, parent, action, checkpoint);
    }

    public AgentNaive() {
        this(null, new Random(99));
    }

    public AgentNaive(Random rand) {
        this(null, rand);

    }

    public AgentNaive(Logger logger, Random rand) {
        this(logger, CONFIG, rand);
    }

    public AgentNaive(Logger logger, AbstractAgentConfiguration config, Random rand) {
        super(logger, config, rand);
    }

}
