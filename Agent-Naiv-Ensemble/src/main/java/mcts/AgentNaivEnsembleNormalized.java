package mcts;

import abstractDeterminized.AbstractDeterminizedEnsembleAgent;
import at.ac.tuwien.ifs.sge.engine.Logger;
import core.AbstractAgentConfiguration;

import java.util.Random;

/// AgentNaivEnsembleNormalized
///
/// Uses per-tree normalized ensemble aggregation instead of pooled visit weighting.
public class AgentNaivEnsembleNormalized extends AbstractDeterminizedEnsembleAgent {
    private static final AbstractAgentConfiguration CONFIG = new AbstractAgentConfiguration(1.6f, 100, 0.2f, 5);
    private static final int ENSEMBLE_AGENTS = 5;

    public AgentNaivEnsembleNormalized() {
        this(null, new Random(99));
    }

    public AgentNaivEnsembleNormalized(Logger logger) {
        this(logger, new Random(99));
    }

    public AgentNaivEnsembleNormalized(Random rand) {
        this(null, rand);
    }

    public AgentNaivEnsembleNormalized(Logger logger, Random rand) {
        super(logger, CONFIG, ENSEMBLE_AGENTS, AbstractDeterminizedEnsembleAgent.normalizedPerTreeAggregationMode(), rand, NaiveEnsembleSubAgent::new);
    }
}
