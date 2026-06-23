package mcts;

import abstractDeterminized.AbstractDeterminizedEnsembleAgent;
import at.ac.tuwien.ifs.sge.engine.Logger;
import core.AbstractAgentConfiguration;

import java.util.Random;

/// AgentNaiveEnsemble
///
/// An ensemble agent that aggregates search statistics from multiple NaiveEnsembleSubAgent instances.
public class AgentNaiveEnsemble extends AbstractDeterminizedEnsembleAgent {
    private static final AbstractAgentConfiguration CONFIG = new AbstractAgentConfiguration(4f, 5, 0.1f, 5);
    private static final int ENSEMBLE_AGENTS = 5;

    /// AgentNaiveEnsemble
    ///
    /// Default constructor creating an ensemble agent with default logger and random generator.
    public AgentNaiveEnsemble() {
        this(null, new Random(99));
    }

    /// AgentNaiveEnsemble
    ///
    /// Constructor creating an ensemble agent with a custom logger and default random generator.
    ///
    /// @param logger the logger instance
    public AgentNaiveEnsemble(Logger logger) {
        this(logger, new Random(99));
    }

    /// AgentNaiveEnsemble
    ///
    /// Constructor creating an ensemble agent with a specific random generator and default logger.
    ///
    /// @param rand the random number generator
    public AgentNaiveEnsemble(Random rand) {
        this(null, rand);
    }

    /// AgentNaiveEnsemble
    ///
    /// Constructor creating an ensemble agent with custom logger and random generator.
    ///
    /// @param logger the logger instance
    /// @param rand the random number generator
    public AgentNaiveEnsemble(Logger logger, Random rand) {
        super(logger, CONFIG, ENSEMBLE_AGENTS, NaiveEnsembleSubAgent::new, rand);
    }
}
