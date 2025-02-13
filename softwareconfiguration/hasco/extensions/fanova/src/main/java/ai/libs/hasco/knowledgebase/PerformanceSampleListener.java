package ai.libs.hasco.knowledgebase;

import com.google.common.eventbus.Subscribe;

import ai.libs.hasco.core.HASCOSolutionCandidate;
import ai.libs.hasco.core.events.HASCOSolutionEvent;
import ai.libs.jaicore.components.api.IComponentInstance;

/**
 *
 * @author jmhansel
 *
 */
public class PerformanceSampleListener {

	private PerformanceKnowledgeBase performanceKnowledgeBase;
	private String benchmarkName;

	public PerformanceSampleListener(final PerformanceKnowledgeBase perfromanceKnowledgeBase, final String benchmarkName) {
		this.performanceKnowledgeBase = perfromanceKnowledgeBase;
		this.benchmarkName = benchmarkName;
	}

	@Subscribe
	public void handleEvent(final HASCOSolutionEvent<Double> event) {
		if (event.getSolutionCandidate() instanceof HASCOSolutionCandidate) {
			HASCOSolutionCandidate<?> solutionCandidate = event.getSolutionCandidate();
			IComponentInstance ci = solutionCandidate.getComponentInstance();
			double score = (Double) solutionCandidate.getScore();
			this.performanceKnowledgeBase.addPerformanceSample(this.benchmarkName, ci, score, false);
		}
	}

	public PerformanceKnowledgeBase getPerformanceKnowledgeBase() {
		return this.performanceKnowledgeBase;
	}

	public void setPerformanceKnowledgeBase(final PerformanceKnowledgeBase performanceKnowledgeBase) {
		this.performanceKnowledgeBase = performanceKnowledgeBase;
	}

	public String getBenchmarkName() {
		return this.benchmarkName;
	}

	public void setBenchmarkName(final String benchmarkName) {
		this.benchmarkName = benchmarkName;
	}

}
