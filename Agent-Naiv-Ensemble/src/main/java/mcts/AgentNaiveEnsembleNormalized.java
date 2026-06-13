package mcts;

import abstractDeterminized.AbstractDeterminizedEnsembleAgent;
import at.ac.tuwien.ifs.sge.engine.Logger;
import core.AbstractAgentConfiguration;

import java.util.Random;

/// AgentNaiveEnsembleNormalized
///
/// Uses per-tree normalized ensemble aggregation instead of pooled visit weighting.
public class AgentNaiveEnsembleNormalized extends AbstractDeterminizedEnsembleAgent {
    private static final AbstractAgentConfiguration CONFIG = new AbstractAgentConfiguration(1.6f, 100, 0.2f, 5);
    private static final int ENSEMBLE_AGENTS = 5;

    public AgentNaiveEnsembleNormalized() {
        this(null, new Random(99));
    }

    public AgentNaiveEnsembleNormalized(Logger logger) {
        this(logger, new Random(99));
    }

    public AgentNaiveEnsembleNormalized(Random rand) {
        this(null, rand);
    }

    public AgentNaiveEnsembleNormalized(Logger logger, Random rand) {
        super(logger, CONFIG, ENSEMBLE_AGENTS, AbstractDeterminizedEnsembleAgent.normalizedPerTreeAggregationMode(),
                rand, NaiveEnsembleSubAgent::new);
    }
}
