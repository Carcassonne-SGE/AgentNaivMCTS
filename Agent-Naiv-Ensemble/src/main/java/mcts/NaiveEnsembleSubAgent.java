package mcts;

import abstractDeterminized.AbstractDeterminizedAgent;
import abstractDeterminized.DeterminizedActionNode;
import at.ac.tuwien.ifs.sge.engine.Logger;
import core.AbstractAgentConfiguration;
import model.state.State;

import java.util.Random;

final class NaiveEnsembleSubAgent extends AbstractDeterminizedAgent<NaiveEnsembleSubAgent.EnsembleSearchNode> {
    static final class EnsembleSearchNode extends DeterminizedActionNode<EnsembleSearchNode> {
        private EnsembleSearchNode(AbstractDeterminizedAgent<EnsembleSearchNode> agent, EnsembleSearchNode parent,
                int action, State checkpoint) {
            super(agent, parent, action, checkpoint);
        }
    }

    NaiveEnsembleSubAgent(Logger logger, AbstractAgentConfiguration config, Random rand) {
        super(logger, config, rand);
    }

    @Override
    protected EnsembleSearchNode rootFactory(State initialState) {
        return new EnsembleSearchNode(this, null, 0, initialState);
    }

    @Override
    public EnsembleSearchNode childFactory(EnsembleSearchNode parent, int action, State checkpoint) {
        return new EnsembleSearchNode(this, parent, action, checkpoint);
    }
}
