package mcts;

import abstractDeterminized.AbstractDeterminizedEnsembleAgent;
import at.ac.tuwien.ifs.sge.engine.Logger;
import core.AbstractAgentConfiguration;

import java.util.Random;

public class AgentNaiveEnsemble extends AbstractDeterminizedEnsembleAgent {
    private static final AbstractAgentConfiguration CONFIG = new AbstractAgentConfiguration(4f, 5, 0.1f, 5);
    private static final int ENSEMBLE_AGENTS = 5;

    public AgentNaiveEnsemble() {
        this(null, new Random(99));
    }

    public AgentNaiveEnsemble(Logger logger) {
        this(logger, new Random(99));
    }

    public AgentNaiveEnsemble(Random rand) {
        this(null, rand);
    }

    public AgentNaiveEnsemble(Logger logger, Random rand) {
        super(logger, CONFIG, ENSEMBLE_AGENTS, NaiveEnsembleSubAgent::new, rand);
    }
}
